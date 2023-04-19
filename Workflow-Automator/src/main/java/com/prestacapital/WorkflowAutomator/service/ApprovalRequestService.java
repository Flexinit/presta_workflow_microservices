package com.prestacapital.WorkflowAutomator.service;

import com.prestacapital.WorkflowAutomator.Data.ApproveAction;
import com.prestacapital.WorkflowAutomator.Utils.Utils;
import com.prestacapital.WorkflowAutomator.entity.ApprovalRequest;
import com.prestacapital.WorkflowAutomator.repository.ApprovalRequestRepository;
import com.prestacapital.WorkflowAutomator.repository.ApproversRepository;
import com.prestacapital.WorkflowAutomator.repository.DocumentTypeRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.web.client.RestTemplateBuilder;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpHeaders;
import org.springframework.http.MediaType;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;
import javax.transaction.Transactional;
import java.util.Collections;
import java.util.List;
import java.util.Objects;
import java.util.Optional;
import java.util.function.Consumer;
import java.util.function.Function;

@Service
public class ApprovalRequestService {
    private final ApproversRepository approversRepository;
    private  ApprovalRequestRepository approvalRequestRepository;
    private RestTemplate restTemplate ;

    private RestTemplateBuilder restTemplateBuilder;
    private  DocumentTypeRepository documentTypeRepository;

    @Autowired
    public ApprovalRequestService(ApprovalRequestRepository approvalRequestRepository,
                                  DocumentTypeRepository documentTypeRepository,
                                  ApproversRepository approversRepository) {
        this.approvalRequestRepository = approvalRequestRepository;
        this.documentTypeRepository = documentTypeRepository;
        this.approversRepository = approversRepository;
    }

    public ApprovalRequest  makeApprovalRequest(ApprovalRequest approvalRequest)   {
        documentTypeRepository.findById(approvalRequest.documentTypeId)
                .orElseThrow(()-> new IllegalStateException("The Document Type  with Id "+ approvalRequest.documentTypeId+ " does Not exist."));
        approvalRequest.createdAt = Utils.getCurrentDateTime.apply(null);
        return approvalRequestRepository.save(approvalRequest);
    }

    public List<Optional<ApprovalRequest>> getApprovalRequests(Boolean approved) {
        return approvalRequestRepository.getApprovalrequestByStatus(approved);
    }

    @Transactional
    public ApprovalRequest approveOrReject(ApproveAction approveAction) {

        ApprovalRequest approvalRequest = approvalRequestRepository.findById(approveAction.approveRequestId)
                .orElseThrow(()-> new IllegalStateException("The Approval Request  with Id "+ approveAction.approveRequestId+ " does Not exist."));

        approversRepository.findById(approveAction.approverId)
                .orElseThrow(()-> new IllegalStateException("The Approver  with Id "+ approveAction.approverId+ " does Not exist."));
        if(Objects.equals(approveAction.approved, "Approve")){
            approvalRequest.setApproved(true);
            sendApprovalNotificationConsumer(approvalRequest);
        }

        return approvalRequest;
    }


    //Send to Approvals initiator
   public ApprovalRequest sendApprovalNotificationConsumer (ApprovalRequest approvalRequest) {
       restTemplate = new RestTemplate();
       HttpHeaders headers = new HttpHeaders();
       headers.setContentType(MediaType.APPLICATION_JSON);
       headers.setAccept(Collections.singletonList(MediaType.APPLICATION_JSON));
       HttpEntity<ApprovalRequest> entity = new HttpEntity<>(approvalRequest, headers);

       return restTemplate.postForObject(Utils.URL, entity, ApprovalRequest.class);

   }


}
