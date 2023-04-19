package com.prestacapital.WorkflowAutomator.controller;

import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.when;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.prestacapital.WorkflowAutomator.Data.ApproveAction;
import com.prestacapital.WorkflowAutomator.entity.ApprovalRequest;
import com.prestacapital.WorkflowAutomator.service.ApprovalRequestService;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.ZoneId;
import java.util.Date;

import org.apache.catalina.User;
import org.apache.catalina.realm.UserDatabaseRealm;
import org.apache.catalina.users.MemoryUserDatabase;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.http.MediaType;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit.jupiter.SpringExtension;
import org.springframework.test.web.servlet.ResultActions;
import org.springframework.test.web.servlet.request.MockHttpServletRequestBuilder;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;
import org.springframework.test.web.servlet.result.MockMvcResultMatchers;
import org.springframework.test.web.servlet.setup.MockMvcBuilders;

@ContextConfiguration(classes = {ApprovalRequestController.class})
@ExtendWith(SpringExtension.class)
class ApprovalRequestControllerTest {
    @Autowired
    private ApprovalRequestController approvalRequestController;

    @MockBean
    private ApprovalRequestService approvalRequestService;

    /**
     * Method under test: {@link ApprovalRequestController#approveOrReject(ApproveAction)}
     */
    @Test
    void testApproveOrReject() throws Exception {
        MockHttpServletRequestBuilder contentTypeResult = MockMvcRequestBuilders.put("/approveOrReject")
                .contentType(MediaType.APPLICATION_JSON);

        ObjectMapper objectMapper = new ObjectMapper();
        MockHttpServletRequestBuilder requestBuilder = contentTypeResult
                .content(objectMapper.writeValueAsString(new ApproveAction()));
        ResultActions actualPerformResult = MockMvcBuilders.standaloneSetup(approvalRequestController)
                .build()
                .perform(requestBuilder);
        actualPerformResult.andExpect(MockMvcResultMatchers.status().isNotFound());
    }

    /**
     * Method under test: {@link ApprovalRequestController#approveOrReject(ApproveAction)}
     */
    @Test
    void testApproveOrReject2() throws Exception {
        User user = mock(User.class);
        when(user.getName()).thenReturn("Name");
        UserDatabaseRealm.UserDatabasePrincipal principal = new UserDatabaseRealm.UserDatabasePrincipal(user,
                new MemoryUserDatabase());

        MockHttpServletRequestBuilder putResult = MockMvcRequestBuilders.put("/approveOrReject");
        putResult.principal(principal);
        MockHttpServletRequestBuilder contentTypeResult = putResult.contentType(MediaType.APPLICATION_JSON);

        ObjectMapper objectMapper = new ObjectMapper();
        MockHttpServletRequestBuilder requestBuilder = contentTypeResult
                .content(objectMapper.writeValueAsString(new ApproveAction()));
        ResultActions actualPerformResult = MockMvcBuilders.standaloneSetup(approvalRequestController)
                .build()
                .perform(requestBuilder);
        actualPerformResult.andExpect(MockMvcResultMatchers.status().isNotFound());
    }

    /**
     * Method under test: {@link ApprovalRequestController#getApprovalRequests(String)}
     */
    @Test
    void testGetApprovalRequests() throws Exception {
        MockHttpServletRequestBuilder requestBuilder = MockMvcRequestBuilders
                .get("/getApprovalRequestsByStatus/{isApproved}", "Is Approved");
        ResultActions actualPerformResult = MockMvcBuilders.standaloneSetup(approvalRequestController)
                .build()
                .perform(requestBuilder);
        actualPerformResult.andExpect(MockMvcResultMatchers.status().isNotFound());
    }

    /**
     * Method under test: {@link ApprovalRequestController#makeApprovalRequest(ApprovalRequest)}
     */
    @Test
    void testMakeApprovalRequest() throws Exception {
        ApprovalRequest approvalRequest = new ApprovalRequest();
        approvalRequest.setApprovalStep("Approval Step");
        approvalRequest.setApproved(true);
        LocalDateTime atStartOfDayResult = LocalDate.of(1970, 1, 1).atStartOfDay();
        approvalRequest.setCreatedAt(Date.from(atStartOfDayResult.atZone(ZoneId.of("UTC")).toInstant()));
        approvalRequest.setCreatedBy("Jan 1, 2020 8:00am GMT+0100");
        approvalRequest.setDescription("The characteristics of someone or something");
        approvalRequest.setDocumentTypeId(123L);
        approvalRequest.setEmailAddress("42 Main St");
        approvalRequest.setFirstName("Jane");
        approvalRequest.setIDNumber("42");
        approvalRequest.setId(123L);
        approvalRequest.setLastName("Doe");
        approvalRequest.setPhoneNumber("4105551212");
        approvalRequest.setRequestId("42");
        String content = (new ObjectMapper()).writeValueAsString(approvalRequest);
        MockHttpServletRequestBuilder requestBuilder = MockMvcRequestBuilders.get("/")
                .contentType(MediaType.APPLICATION_JSON)
                .content(content);
        ResultActions actualPerformResult = MockMvcBuilders.standaloneSetup(approvalRequestController)
                .build()
                .perform(requestBuilder);
        actualPerformResult.andExpect(MockMvcResultMatchers.status().isNotFound());
    }

    /**
     * Method under test: {@link ApprovalRequestController#makeApprovalRequest(ApprovalRequest)}
     */
    @Test
    void testMakeApprovalRequest2() throws Exception {
        java.sql.Date date = mock(java.sql.Date.class);
        when(date.getTime()).thenReturn(10L);

        ApprovalRequest approvalRequest = new ApprovalRequest();
        approvalRequest.setApprovalStep("Approval Step");
        approvalRequest.setApproved(true);
        approvalRequest.setCreatedAt(date);
        approvalRequest.setCreatedBy("Jan 1, 2020 8:00am GMT+0100");
        approvalRequest.setDescription("The characteristics of someone or something");
        approvalRequest.setDocumentTypeId(123L);
        approvalRequest.setEmailAddress("42 Main St");
        approvalRequest.setFirstName("Jane");
        approvalRequest.setIDNumber("42");
        approvalRequest.setId(123L);
        approvalRequest.setLastName("Doe");
        approvalRequest.setPhoneNumber("4105551212");
        approvalRequest.setRequestId("42");
        String content = (new ObjectMapper()).writeValueAsString(approvalRequest);
        MockHttpServletRequestBuilder requestBuilder = MockMvcRequestBuilders.get("/")
                .contentType(MediaType.APPLICATION_JSON)
                .content(content);
        ResultActions actualPerformResult = MockMvcBuilders.standaloneSetup(approvalRequestController)
                .build()
                .perform(requestBuilder);
        actualPerformResult.andExpect(MockMvcResultMatchers.status().isNotFound());
    }
}

