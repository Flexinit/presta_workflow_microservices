package com.prestacapital.WorkflowAutomator.repository;

import com.prestacapital.WorkflowAutomator.entity.ApprovalRequest;
import com.prestacapital.WorkflowAutomator.entity.Approvers;
import com.prestacapital.WorkflowAutomator.entity.DocumentTypes;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@Repository
public interface ApprovalRequestRepository extends JpaRepository<ApprovalRequest, Long> {

    @Query(nativeQuery = true, value = "SELECT * FROM approval_request r WHERE r.approved = ?1")
    List<Optional<ApprovalRequest>> getApprovalrequestByStatus(Boolean approved);



}
