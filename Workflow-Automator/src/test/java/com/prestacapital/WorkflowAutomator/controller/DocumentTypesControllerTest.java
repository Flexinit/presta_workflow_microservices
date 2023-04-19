package com.prestacapital.WorkflowAutomator.controller;

import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.when;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.prestacapital.WorkflowAutomator.entity.DocumentTypes;
import com.prestacapital.WorkflowAutomator.service.DocumentTypeService;

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

@ContextConfiguration(classes = {DocumentTypesController.class})
@ExtendWith(SpringExtension.class)
class DocumentTypesControllerTest {
    @MockBean
    private DocumentTypeService documentTypeService;

    @Autowired
    private DocumentTypesController documentTypesController;

    /**
     * Method under test: {@link DocumentTypesController#addNewDocumentType(DocumentTypes)}
     */
    @Test
    void testAddNewDocumentType() throws Exception {
        DocumentTypes documentTypes = new DocumentTypes();
        LocalDateTime atStartOfDayResult = LocalDate.of(1970, 1, 1).atStartOfDay();
        documentTypes.setCreatedAt(Date.from(atStartOfDayResult.atZone(ZoneId.of("UTC")).toInstant()));
        documentTypes.setDocumentTypeCode("Document Type Code");
        documentTypes.setDocumentTypeDescription("Document Type Description");
        documentTypes.setDocumentTypeName("Document Type Name");
        documentTypes.setId(123L);
        String content = (new ObjectMapper()).writeValueAsString(documentTypes);
        MockHttpServletRequestBuilder requestBuilder = MockMvcRequestBuilders.get("/")
                .contentType(MediaType.APPLICATION_JSON)
                .content(content);
        ResultActions actualPerformResult = MockMvcBuilders.standaloneSetup(documentTypesController)
                .build()
                .perform(requestBuilder);
        actualPerformResult.andExpect(MockMvcResultMatchers.status().isNotFound());
    }

    /**
     * Method under test: {@link DocumentTypesController#addNewDocumentType(DocumentTypes)}
     */
    @Test
    void testAddNewDocumentType2() throws Exception {
        java.sql.Date date = mock(java.sql.Date.class);
        when(date.getTime()).thenReturn(10L);

        DocumentTypes documentTypes = new DocumentTypes();
        documentTypes.setCreatedAt(date);
        documentTypes.setDocumentTypeCode("Document Type Code");
        documentTypes.setDocumentTypeDescription("Document Type Description");
        documentTypes.setDocumentTypeName("Document Type Name");
        documentTypes.setId(123L);
        String content = (new ObjectMapper()).writeValueAsString(documentTypes);
        MockHttpServletRequestBuilder requestBuilder = MockMvcRequestBuilders.get("/")
                .contentType(MediaType.APPLICATION_JSON)
                .content(content);
        ResultActions actualPerformResult = MockMvcBuilders.standaloneSetup(documentTypesController)
                .build()
                .perform(requestBuilder);
        actualPerformResult.andExpect(MockMvcResultMatchers.status().isNotFound());
    }

    /**
     * Method under test: {@link DocumentTypesController#getDocumentType()}
     */
    @Test
    void testGetDocumentType() throws Exception {
        MockHttpServletRequestBuilder requestBuilder = MockMvcRequestBuilders.get("/");
        ResultActions actualPerformResult = MockMvcBuilders.standaloneSetup(documentTypesController)
                .build()
                .perform(requestBuilder);
        actualPerformResult.andExpect(MockMvcResultMatchers.status().isNotFound());
    }
}

