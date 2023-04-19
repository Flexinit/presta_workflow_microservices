package com.prestacapital.ApprovalsInitiator.controller;

import com.prestacapital.ApprovalsInitiator.entity.ApprovalRequest;
import com.prestacapital.ApprovalsInitiator.service.ApprovalRequestService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@Slf4j
@RestController
@RequestMapping(path = "api/v1/approvals")
public class ApprovalRequestController {
    private final ApprovalRequestService approvalRequestService;

    @Autowired
    public ApprovalRequestController(ApprovalRequestService approvalRequestService) {
        this.approvalRequestService = approvalRequestService;
    }

    @PostMapping
    public ApprovalRequest makeApprovalRequest(@RequestBody ApprovalRequest approvalRequest){
        log.info("Request Data From Workflow Automator Microservice {}",approvalRequest.toString());
        return approvalRequestService.makeApprovalRequest.apply(approvalRequest);
    }
}
