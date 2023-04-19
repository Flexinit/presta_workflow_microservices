package com.prestacapital.WorkflowAutomator.controller;

import com.prestacapital.WorkflowAutomator.Data.ApproveAction;
import com.prestacapital.WorkflowAutomator.entity.ApprovalRequest;
import com.prestacapital.WorkflowAutomator.service.ApprovalRequestService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

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
        return approvalRequestService.makeApprovalRequest(approvalRequest);
    }

    @GetMapping("/getApprovalRequestsByStatus/{isApproved}")
    public List<Optional<ApprovalRequest>> getApprovalRequests(@PathVariable("isApproved") String approved){
        return approvalRequestService.getApprovalRequests(Boolean.valueOf(approved));
    }

    @PutMapping("/approveOrReject")
    public ApprovalRequest approveOrReject(@RequestBody ApproveAction approveAction){
        return approvalRequestService.approveOrReject(approveAction);
    }
}
