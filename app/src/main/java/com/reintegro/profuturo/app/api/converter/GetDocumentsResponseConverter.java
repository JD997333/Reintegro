package com.reintegro.profuturo.app.api.converter;

import com.reintegro.profuturo.app.api.vo.GetDocumentsResponse;
import com.reintegro.profuturo.app.data.entity.DocumentEntity;
import com.reintegro.profuturo.app.util.TypeUtils;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

public class GetDocumentsResponseConverter extends ResponseConverter<GetDocumentsResponse, List<DocumentEntity>>{
    @Override
    public List<DocumentEntity> convert(GetDocumentsResponse response) {
        List<DocumentEntity> documentEntities;
        documentEntities = new ArrayList<>();

        for (GetDocumentsResponse.DocumentCapture document : response.getDocuments()) {
            DocumentEntity documentEntity;
            documentEntity = new DocumentEntity();
            documentEntity.setConsecutive(TypeUtils.getValueOrDefault(document.getDocumentData().getConsecutive()));
            documentEntity.setDocumentKey(TypeUtils.getValueOrDefault(Integer.parseInt(document.getDocumentData().getDocumentKey())));
            documentEntity.setDocumentName(TypeUtils.getValueOrDefault(document.getDocumentData().getDocumentName()));
            documentEntity.setExpedientType(TypeUtils.getValueOrDefault(document.getDocumentData().getExpedientType()));
            documentEntity.setPagination(TypeUtils.getValueOrDefault(document.getDocumentData().getPagination()));
            documentEntity.setRequiredByProcesar(TypeUtils.getValueOrDefault(Boolean.parseBoolean(document.getDocumentData().getRequired().isRequiredByProcesar())));
            documentEntity.setRequiredByProfuturo(TypeUtils.getValueOrDefault(Boolean.parseBoolean(document.getDocumentData().getRequired().isRequiredByProfuturo())));
            documentEntity.setSignatureHolders(new HashMap<>());

            documentEntities.add(documentEntity);
        }

        return documentEntities;
    }
}
