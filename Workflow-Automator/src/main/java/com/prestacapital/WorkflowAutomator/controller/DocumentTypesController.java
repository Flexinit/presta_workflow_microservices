package com.prestacapital.WorkflowAutomator.controller;

import com.prestacapital.WorkflowAutomator.entity.DocumentTypes;
import com.prestacapital.WorkflowAutomator.service.DocumentTypeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping(path = "api/v1/documentTypes")
public class DocumentTypesController {
    private final DocumentTypeService documentTypeService;

    @Autowired
    public DocumentTypesController(DocumentTypeService documentTypeService) {
        this.documentTypeService = documentTypeService;
    }

    @PostMapping
    public DocumentTypes addNewDocumentType(@RequestBody DocumentTypes documentTypes){
        return documentTypeService.addNewDocumentType.apply(documentTypes);
    }

    @GetMapping
    public List<Optional<DocumentTypes>> getDocumentType(){
        return documentTypeService.getDocumentType.apply(null);
    }

}
