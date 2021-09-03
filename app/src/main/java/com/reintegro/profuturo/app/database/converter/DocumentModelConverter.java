package com.reintegro.profuturo.app.database.converter;

import com.reintegro.profuturo.app.data.entity.DocumentEntity;
import com.reintegro.profuturo.app.database.model.DocumentModel;

import java.io.File;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

import io.realm.RealmList;

public class DocumentModelConverter {
    public static DocumentEntity convertFromModel(DocumentModel documentModel) {
        boolean hasFilePath;
        hasFilePath = !documentModel.getFilePath().isEmpty();

        DocumentEntity documentEntity;
        documentEntity = new DocumentEntity();
        documentEntity.setCaptured(documentModel.isCaptured());
        documentEntity.setConsecutive(documentModel.getConsecutive());
        documentEntity.setDocumentKey(documentModel.getDocumentKey());
        documentEntity.setDocumentName(documentModel.getDocumentName());
        documentEntity.setDocumentType(documentModel.getDocumentType());
        documentEntity.setExpedientType(documentModel.getExpedientType());
        documentEntity.setFile(hasFilePath ? new File(documentModel.getFilePath()) : null);
        documentEntity.setId(documentModel.getId());
        documentEntity.setPagination(documentModel.getPagination());
        documentEntity.setRequiredByProcesar(documentModel.isRequiredByProcesar());
        documentEntity.setRequiredByProfuturo(documentModel.isRequiredByProfuturo());

        HashMap<String, String> signatureHolders;
        signatureHolders = new HashMap<>();

        for (int position = 0; position < documentModel.getSignatureHolders().size(); position++) {
            signatureHolders.put(documentModel.getSignatureHolders().get(position), documentModel.getSignatures().get(position));
        }

        documentEntity.setSignatureHolders(signatureHolders);

        return documentEntity;
    }

    public static DocumentModel convertFromEntity(DocumentEntity documentEntity) {
        boolean hasFile;
        hasFile = documentEntity.getFile() != null;

        DocumentModel documentModel;
        documentModel = new DocumentModel();
        documentModel.setCaptured(documentEntity.isCaptured());
        documentModel.setConsecutive(documentEntity.getConsecutive());
        documentModel.setDocumentKey(documentEntity.getDocumentKey());
        documentModel.setDocumentName(documentEntity.getDocumentName());
        documentModel.setDocumentType(documentEntity.getDocumentType());
        documentModel.setExpedientType(documentEntity.getExpedientType());
        documentModel.setFilePath(hasFile ? documentEntity.getFile().getAbsolutePath() : "");
        documentModel.setPagination(documentEntity.getPagination());

        boolean hasId;
        hasId = documentEntity.getId() != null;

        if (hasId) {
            documentModel.setId(documentEntity.getId());
        }

        documentModel.setRequiredByProcesar(documentEntity.isRequiredByProcesar());
        documentModel.setRequiredByProfuturo(documentEntity.isRequiredByProfuturo());

        RealmList<String> signatures;
        signatures = new RealmList<>();

        for (String signature : documentEntity.getSignatureHolders().values()) {
            signatures.add(signature);
        }

        documentModel.setSignatures(signatures);

        RealmList<String> signatureHolders;
        signatureHolders = new RealmList<>();

        for (String signatureHolder : documentEntity.getSignatureHolders().keySet()) {
            signatureHolders.add(signatureHolder);
        }

        documentModel.setSignatureHolders(signatureHolders);

        return documentModel;
    }

    public static List<DocumentEntity> convertFromModels(List<DocumentModel> documentModels) {
        List<DocumentEntity> documentEntities;
        documentEntities = new ArrayList<>();

        for (DocumentModel documentModel : documentModels) {
            documentEntities.add(convertFromModel(documentModel));
        }

        return documentEntities;
    }

    public static List<DocumentModel> convertFromEntities(List<DocumentEntity> documentEntities) {
        List<DocumentModel> documentModels;
        documentModels = new ArrayList<>();

        for (DocumentEntity documentEntity : documentEntities) {
            documentModels.add(convertFromEntity(documentEntity));
        }

        return documentModels;
    }
}
