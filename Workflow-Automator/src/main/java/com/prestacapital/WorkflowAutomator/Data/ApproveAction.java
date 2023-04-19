package com.prestacapital.WorkflowAutomator.Data;

import lombok.AllArgsConstructor;
import lombok.NoArgsConstructor;

@AllArgsConstructor
@NoArgsConstructor
public class ApproveAction {
    public  Long approveRequestId;
    public  Long approverId;
    public  String approved;
}
