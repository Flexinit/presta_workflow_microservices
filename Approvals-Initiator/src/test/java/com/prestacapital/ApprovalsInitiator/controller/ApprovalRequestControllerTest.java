package com.prestacapital.ApprovalsInitiator.controller;

import static org.junit.jupiter.api.Assertions.assertSame;
import static org.mockito.Mockito.any;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;

import com.prestacapital.ApprovalsInitiator.service.ApprovalRequestService;
import com.prestacapital.WorkflowAutomator.entity.ApprovalRequest;
import com.prestacapital.WorkflowAutomator.entity.DocumentTypes;
import com.prestacapital.WorkflowAutomator.repository.ApprovalRequestRepository;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.ZoneId;
import java.util.Date;

import org.junit.jupiter.api.Disabled;

import org.junit.jupiter.api.Test;

class ApprovalRequestControllerTest {
    /**
     * Method under test: {@link ApprovalRequestController#makeApprovalRequest(ApprovalRequest)}
     */
    @Test
    void testMakeApprovalRequest() {
        //   Diffblue Cover was unable to write a Spring test,
        //   so wrote a non-Spring test instead.
        //   Diffblue AI was unable to find a test

        DocumentTypes documentTypes = new DocumentTypes();
        documentTypes.setDocumentTypeDescription("Document Description");
        documentTypes.setDocumentTypeId("42");
        documentTypes.setDocumentTypeName("Document Name");
        documentTypes.setId(123L);

        ApprovalRequest approvalRequest = new ApprovalRequest();
        approvalRequest.setApprovalStep("Approval Step");
        approvalRequest.setApproved(true);
        LocalDateTime atStartOfDayResult = LocalDate.of(1970, 1, 1).atStartOfDay();
        approvalRequest.setCreatedAt(Date.from(atStartOfDayResult.atZone(ZoneId.of("UTC")).toInstant()));
        approvalRequest.setCreatedBy("Jan 1, 2020 8:00am GMT+0100");
        approvalRequest.setDescription("The characteristics of someone or something");
        approvalRequest.setDocumentType(documentTypes);
        approvalRequest.setEmailAddress("42 Main St");
        approvalRequest.setFirstName("Jane");
        approvalRequest.setIDNumber("42");
        approvalRequest.setId(123L);
        approvalRequest.setLastName("Doe");
        approvalRequest.setPhoneNumber("4105551212");
        approvalRequest.setRequestId("42");
        ApprovalRequestRepository approvalRequestRepository = mock(ApprovalRequestRepository.class);
        when(approvalRequestRepository.save((ApprovalRequest) any())).thenReturn(approvalRequest);
        ApprovalRequestController approvalRequestController = new ApprovalRequestController(
                new ApprovalRequestService((com.prestacapital.ApprovalsInitiator.repository.ApprovalRequestRepository) approvalRequestRepository));

        DocumentTypes documentTypes1 = new DocumentTypes();
        documentTypes1.setDocumentTypeDescription("Document Description");
        //documentTypes1.setDocumentTypeId("42");
        documentTypes1.setDocumentTypeName("Document Name");
        documentTypes1.setId(123L);

        ApprovalRequest approvalRequest1 = new ApprovalRequest();
        approvalRequest1.setApprovalStep("Approval Step");
        approvalRequest1.setApproved(true);
        LocalDateTime atStartOfDayResult1 = LocalDate.of(1970, 1, 1).atStartOfDay();
        approvalRequest1.setCreatedAt(Date.from(atStartOfDayResult1.atZone(ZoneId.of("UTC")).toInstant()));
        approvalRequest1.setCreatedBy("Jan 1, 2020 8:00am GMT+0100");
        approvalRequest1.setDescription("The characteristics of someone or something");
        //approvalRequest1.setDocumentType(documentTypes1);
        approvalRequest1.setEmailAddress("42 Main St");
        approvalRequest1.setFirstName("Jane");
        approvalRequest1.setIDNumber("42");
        approvalRequest1.setId(123L);
        approvalRequest1.setLastName("Doe");
        approvalRequest1.setPhoneNumber("4105551212");
        approvalRequest1.setRequestId("42");
        assertSame(approvalRequest, approvalRequestController.makeApprovalRequest(approvalRequest1));
        verify(approvalRequestRepository).save((ApprovalRequest) any());
        Date expectedCreatedAt = approvalRequest1.createdAt;
        assertSame(expectedCreatedAt, approvalRequest1.getCreatedAt());
    }

    /**
     * Method under test: {@link ApprovalRequestController#makeApprovalRequest(ApprovalRequest)}
     */
    @Test
    @Disabled("TODO: Complete this test")
    void testMakeApprovalRequest2() {
        //   Diffblue Cover was unable to write a Spring test,
        //   so wrote a non-Spring test instead.
        //   Diffblue AI was unable to find a test

        // TODO: Complete this test.
        //   Reason: R013 No inputs found that don't throw a trivial exception.
        //   Diffblue Cover tried to run the arrange/act section, but the method under
        //   test threw
        //   java.lang.NullPointerException: Cannot invoke "com.prestacapital.ApprovalsInitiator.service.ApprovalRequestService.makeApprovalRequest(com.prestacapital.WorkflowAutomator.entity.ApprovalRequest)" because "this.approvalRequestService" is null
        //       at com.prestacapital.ApprovalsInitiator.controller.ApprovalRequestController.makeApprovalRequest(ApprovalRequestController.java:23)
        //   See https://diff.blue/R013 to resolve this issue.

        ApprovalRequestController approvalRequestController = new ApprovalRequestController(null);

        DocumentTypes documentTypes = new DocumentTypes();
        documentTypes.setDocumentTypeDescription("Document Description");
        documentTypes.setDocumentTypeId("42");
        documentTypes.setDocumentTypeName("Document Name");
        documentTypes.setId(123L);

        ApprovalRequest approvalRequest = new ApprovalRequest();
        approvalRequest.setApprovalStep("Approval Step");
        approvalRequest.setApproved(true);
        LocalDateTime atStartOfDayResult = LocalDate.of(1970, 1, 1).atStartOfDay();
        approvalRequest.setCreatedAt(Date.from(atStartOfDayResult.atZone(ZoneId.of("UTC")).toInstant()));
        approvalRequest.setCreatedBy("Jan 1, 2020 8:00am GMT+0100");
        approvalRequest.setDescription("The characteristics of someone or something");
        approvalRequest.setDocumentType(documentTypes);
        approvalRequest.setEmailAddress("42 Main St");
        approvalRequest.setFirstName("Jane");
        approvalRequest.setIDNumber("42");
        approvalRequest.setId(123L);
        approvalRequest.setLastName("Doe");
        approvalRequest.setPhoneNumber("4105551212");
        approvalRequest.setRequestId("42");
        approvalRequestController.makeApprovalRequest(approvalRequest);
    }

    /**
     * Method under test: {@link ApprovalRequestController#makeApprovalRequest(ApprovalRequest)}
     */
    @Test
    void testMakeApprovalRequest3() {
        //   Diffblue Cover was unable to write a Spring test,
        //   so wrote a non-Spring test instead.
        //   Diffblue AI was unable to find a test

        DocumentTypes documentTypes = new DocumentTypes();
        documentTypes.setDocumentTypeDescription("Document Description");
        documentTypes.setDocumentTypeId("42");
        documentTypes.setDocumentTypeName("Document Name");
        documentTypes.setId(123L);

        ApprovalRequest approvalRequest = new ApprovalRequest();
        approvalRequest.setApprovalStep("Approval Step");
        approvalRequest.setApproved(true);
        LocalDateTime atStartOfDayResult = LocalDate.of(1970, 1, 1).atStartOfDay();
        approvalRequest.setCreatedAt(Date.from(atStartOfDayResult.atZone(ZoneId.of("UTC")).toInstant()));
        approvalRequest.setCreatedBy("Jan 1, 2020 8:00am GMT+0100");
        approvalRequest.setDescription("The characteristics of someone or something");
        approvalRequest.setDocumentType(documentTypes);
        approvalRequest.setEmailAddress("42 Main St");
        approvalRequest.setFirstName("Jane");
        approvalRequest.setIDNumber("42");
        approvalRequest.setId(123L);
        approvalRequest.setLastName("Doe");
        approvalRequest.setPhoneNumber("4105551212");
        approvalRequest.setRequestId("42");
        ApprovalRequestService approvalRequestService = mock(ApprovalRequestService.class);
        when(approvalRequestService.makeApprovalRequest((ApprovalRequest) any())).thenReturn(approvalRequest);
        ApprovalRequestController approvalRequestController = new ApprovalRequestController(approvalRequestService);

        DocumentTypes documentTypes1 = new DocumentTypes();
        documentTypes1.setDocumentTypeDescription("Document Description");
        documentTypes1.setDocumentTypeId("42");
        documentTypes1.setDocumentTypeName("Document Name");
        documentTypes1.setId(123L);

        ApprovalRequest approvalRequest1 = new ApprovalRequest();
        approvalRequest1.setApprovalStep("Approval Step");
        approvalRequest1.setApproved(true);
        LocalDateTime atStartOfDayResult1 = LocalDate.of(1970, 1, 1).atStartOfDay();
        approvalRequest1.setCreatedAt(Date.from(atStartOfDayResult1.atZone(ZoneId.of("UTC")).toInstant()));
        approvalRequest1.setCreatedBy("Jan 1, 2020 8:00am GMT+0100");
        approvalRequest1.setDescription("The characteristics of someone or something");
        approvalRequest1.setDocumentType(documentTypes1);
        approvalRequest1.setEmailAddress("42 Main St");
        approvalRequest1.setFirstName("Jane");
        approvalRequest1.setIDNumber("42");
        approvalRequest1.setId(123L);
        approvalRequest1.setLastName("Doe");
        approvalRequest1.setPhoneNumber("4105551212");
        approvalRequest1.setRequestId("42");
        assertSame(approvalRequest, approvalRequestController.makeApprovalRequest(approvalRequest1));
        verify(approvalRequestService).makeApprovalRequest((ApprovalRequest) any());
    }
}

