package com.prestacapital.WorkflowAutomator.controller;

import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.when;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.prestacapital.WorkflowAutomator.entity.Approvers;
import com.prestacapital.WorkflowAutomator.service.ApproversService;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.ZoneId;
import java.util.Date;

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

@ContextConfiguration(classes = {ApproversController.class})
@ExtendWith(SpringExtension.class)
class ApproversControllerTest {
    @Autowired
    private ApproversController approversController;

    @MockBean
    private ApproversService approversService;

    /**
     * Method under test: {@link ApproversController#addNewApprover(Approvers)}
     */
    @Test
    void testAddNewApprover() throws Exception {
        Approvers approvers = new Approvers();
        //approvers.se("42");
        LocalDateTime atStartOfDayResult = LocalDate.of(1970, 1, 1).atStartOfDay();
        approvers.setCreatedAt(Date.from(atStartOfDayResult.atZone(ZoneId.of("UTC")).toInstant()));
        approvers.setDesignation("Designation");
        approvers.setDocumentTypeId(123L);
        approvers.setEmailAddress("42 Main St");
        approvers.setFirstName("Jane");
        approvers.setId(123L);
        approvers.setLastName("Doe");
        approvers.setPhoneNumber("4105551212");
        String content = (new ObjectMapper()).writeValueAsString(approvers);
        MockHttpServletRequestBuilder requestBuilder = MockMvcRequestBuilders.get("/")
                .contentType(MediaType.APPLICATION_JSON)
                .content(content);
        ResultActions actualPerformResult = MockMvcBuilders.standaloneSetup(approversController)
                .build()
                .perform(requestBuilder);
        actualPerformResult.andExpect(MockMvcResultMatchers.status().isNotFound());
    }

    /**
     * Method under test: {@link ApproversController#addNewApprover(Approvers)}
     */
    @Test
    void testAddNewApprover2() throws Exception {
        java.sql.Date date = mock(java.sql.Date.class);
        when(date.getTime()).thenReturn(10L);

        Approvers approvers = new Approvers();
        //approvers.setApproverId("42");
        approvers.setCreatedAt(date);
        approvers.setDesignation("Designation");
        approvers.setDocumentTypeId(123L);
        approvers.setEmailAddress("42 Main St");
        approvers.setFirstName("Jane");
        approvers.setId(123L);
        approvers.setLastName("Doe");
        approvers.setPhoneNumber("4105551212");
        String content = (new ObjectMapper()).writeValueAsString(approvers);
        MockHttpServletRequestBuilder requestBuilder = MockMvcRequestBuilders.get("/")
                .contentType(MediaType.APPLICATION_JSON)
                .content(content);
        ResultActions actualPerformResult = MockMvcBuilders.standaloneSetup(approversController)
                .build()
                .perform(requestBuilder);
        actualPerformResult.andExpect(MockMvcResultMatchers.status().isNotFound());
    }
}

