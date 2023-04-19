package com.prestacapital.WorkflowAutomator.service;

import com.prestacapital.WorkflowAutomator.Utils.Utils;
import com.prestacapital.WorkflowAutomator.entity.ApprovalRequest;
import com.prestacapital.WorkflowAutomator.entity.Approvers;
import com.prestacapital.WorkflowAutomator.entity.DocumentTypes;
import com.prestacapital.WorkflowAutomator.repository.ApprovalRequestRepository;
import com.prestacapital.WorkflowAutomator.repository.ApproversRepository;
import com.prestacapital.WorkflowAutomator.repository.DocumentTypeRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;
import java.util.function.Function;

@Service
public class ApproversService {
    private  ApproversRepository approversRepository;
    private  ApprovalRequestRepository approvalRequestRepository;
    private  DocumentTypeRepository documentTypeRepository;

    @Autowired
    public ApproversService(ApproversRepository approversRepository,
                            ApprovalRequestRepository approvalRequestRepository,
                            DocumentTypeRepository documentTypeRepository) {
        this.approversRepository = approversRepository;
        this.approvalRequestRepository = approvalRequestRepository;
        this.documentTypeRepository = documentTypeRepository;
    }

    public Function<Approvers, Approvers> addNewApprover =  approver -> {
         documentTypeRepository.findById(approver.documentTypeId)
                .orElseThrow(()-> new IllegalStateException("The Document Type  with Id "+ approver.documentTypeId+ " does Not exist."));
        approver.createdAt = Utils.getCurrentDateTime.apply(null);

        return approversRepository.save(approver);
    };

    public Function<Long, List<Optional<Approvers>>> getApproverByDocumentType = documentTypeId-> approversRepository.getApproverByDocumentType(documentTypeId);
}
