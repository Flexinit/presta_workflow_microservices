package com.prestacapital.WorkflowAutomator.repository;

import com.prestacapital.WorkflowAutomator.entity.Approvers;
import com.prestacapital.WorkflowAutomator.entity.DocumentTypes;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@Repository
public interface ApproversRepository extends JpaRepository<Approvers, Long> {
    @Query(nativeQuery = true, value = "SELECT * FROM approvers a WHERE a.document_type_id = ?1")
    List<Optional<Approvers>> getApproverByDocumentType(Long documentTypeId);
}
