package com.prestacapital.ApprovalsInitiator.service;


import com.prestacapital.ApprovalsInitiator.entity.ApprovalRequest;
import com.prestacapital.ApprovalsInitiator.repository.ApprovalRequestRepository;
import jakarta.transaction.Transactional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.*;
import java.util.function.Function;

@Service
public class ApprovalRequestService {

    private  ApprovalRequestRepository approvalRequestRepository;

    @Autowired
    public ApprovalRequestService(ApprovalRequestRepository approvalRequestRepository) {
        this.approvalRequestRepository = approvalRequestRepository;
    }

    public Function<ApprovalRequest, ApprovalRequest> makeApprovalRequest = approvalRequest ->  {
        approvalRequest.createdAt = getCurrentDateTime.apply(null);
        return approvalRequestRepository.save(approvalRequest);
    };

    public static Function<Void, Date> getCurrentDateTime = date -> {
        Calendar cal = Calendar.getInstance();
        return cal.getTime();
    };
}
