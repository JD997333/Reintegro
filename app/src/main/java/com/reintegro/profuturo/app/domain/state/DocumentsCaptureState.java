package com.reintegro.profuturo.app.domain.state;

import com.reintegro.profuturo.app.contract.DocumentsCaptureContract;
import com.reintegro.profuturo.app.data.entity.DocumentEntity;
import com.reintegro.profuturo.app.domain.dto.DocumentDto;

import java.util.List;

public class DocumentsCaptureState implements DocumentsCaptureContract.State {
    private DocumentDto selectedDocument;
    private List<DocumentDto> documents;
    private int signatureCount;

    @Override
    public DocumentDto getSelectedDocument() {
        return selectedDocument;
    }

    @Override
    public List<DocumentDto> getDocuments() {
        return documents;
    }

    @Override
    public void setDocuments(List<DocumentDto> documents) {
        this.documents = documents;
    }

    @Override
    public void setSelectedDocument(DocumentDto document) {
        this.selectedDocument = document;
    }

    @Override
    public int getSignatureCount() {
        return signatureCount;
    }

    @Override
    public void incrementSignatureCount() {
        signatureCount++;
    }

    @Override
    public void resetSignatureCount() {
        signatureCount = 0;
    }
}
