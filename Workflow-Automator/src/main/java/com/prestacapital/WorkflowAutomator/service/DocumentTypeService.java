package com.prestacapital.WorkflowAutomator.service;

import com.prestacapital.WorkflowAutomator.Utils.Utils;
import com.prestacapital.WorkflowAutomator.entity.DocumentTypes;
import com.prestacapital.WorkflowAutomator.repository.DocumentTypeRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;
import java.util.function.Function;

@Service
public class DocumentTypeService {
    private  DocumentTypeRepository documentTypeRepository;

    @Autowired
    public DocumentTypeService(DocumentTypeRepository documentTypeRepository) {
        this.documentTypeRepository = documentTypeRepository;
    }


    public Function<DocumentTypes, DocumentTypes> addNewDocumentType = documentTypes ->  {
        documentTypes.createdAt = Utils.getCurrentDateTime.apply(null);
        return documentTypeRepository.save(documentTypes);
    };

    public Function<Void,List<Optional<DocumentTypes>>> getDocumentType =
            documentTypes-> documentTypeRepository.getDocumentType();
}
