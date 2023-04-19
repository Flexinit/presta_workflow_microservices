package com.prestacapital.WorkflowAutomator.controller;

import com.prestacapital.WorkflowAutomator.entity.Approvers;
import com.prestacapital.WorkflowAutomator.entity.DocumentTypes;
import com.prestacapital.WorkflowAutomator.service.ApproversService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping(path = "api/v1/approvers")
public class ApproversController {

    private final ApproversService approversService;

    @Autowired
    public ApproversController(ApproversService approversService) {
        this.approversService = approversService;
    }

    @PostMapping
    public Approvers addNewApprover(@RequestBody Approvers approver){
        return approversService.addNewApprover.apply(approver);
    }

    @GetMapping("/getApproverByDocumentType/{documentType}")
    public List<Optional<Approvers>> getApproverByDocumentType(@PathVariable("documentType") Long documentTypeId){
        return approversService.getApproverByDocumentType.apply(documentTypeId);
    }
}
