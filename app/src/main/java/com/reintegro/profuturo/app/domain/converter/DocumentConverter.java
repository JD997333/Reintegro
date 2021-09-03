package com.reintegro.profuturo.app.domain.converter;

import com.reintegro.profuturo.app.data.entity.DocumentEntity;
import com.reintegro.profuturo.app.domain.dto.DocumentDto;

import java.util.ArrayList;
import java.util.List;

public class DocumentConverter {
    public static DocumentDto convertFromEntity(DocumentEntity documentEntity) {
        DocumentDto documentDto;
        documentDto = new DocumentDto();
        documentDto.setCaptured(documentEntity.isCaptured());
        documentDto.setConsecutive(documentEntity.getConsecutive());
        documentDto.setDocumentKey(documentEntity.getDocumentKey());
        documentDto.setDocumentName(documentEntity.getDocumentName());
        documentDto.setDocumentType(documentEntity.getDocumentType());
        documentDto.setExpedientType(documentEntity.getExpedientType());
        documentDto.setFile(documentEntity.getFile());
        documentDto.setId(documentEntity.getId());
        documentDto.setPagination(documentEntity.getPagination());
        documentDto.setRequiredByProcesar(documentEntity.isRequiredByProcesar());
        documentDto.setRequiredByProfuturo(documentEntity.isRequiredByProfuturo());
        documentDto.setSignatureHolders(documentEntity.getSignatureHolders());

        return documentDto;
    }

    public static DocumentEntity convertFromDto(DocumentDto documentDto) {
        DocumentEntity documentEntity;
        documentEntity = new DocumentEntity();
        documentEntity.setCaptured(documentDto.isCaptured());
        documentEntity.setConsecutive(documentDto.getConsecutive());
        documentEntity.setDocumentKey(documentDto.getDocumentKey());
        documentEntity.setDocumentName(documentDto.getDocumentName());
        documentEntity.setDocumentType(documentDto.getDocumentType());
        documentEntity.setExpedientType(documentDto.getExpedientType());
        documentEntity.setFile(documentDto.getFile());
        documentEntity.setId(documentDto.getId());
        documentEntity.setPagination(documentDto.getPagination());
        documentEntity.setRequiredByProcesar(documentDto.isRequiredByProcesar());
        documentEntity.setRequiredByProfuturo(documentDto.isRequiredByProfuturo());
        documentEntity.setSignatureHolders(documentDto.getSignatureHolders());

        return documentEntity;
    }

    public static List<DocumentDto> convertFromEntities(List<DocumentEntity> documentEntities) {
        List<DocumentDto> documentDtos;
        documentDtos = new ArrayList<>();

        for (DocumentEntity documentEntity : documentEntities) {
            documentDtos.add(convertFromEntity(documentEntity));
        }

        return documentDtos;
    }

    public static List<DocumentEntity> convertFromDtos(List<DocumentDto> documentDtos) {
        List<DocumentEntity> documentEntities;
        documentEntities = new ArrayList<>();

        for (DocumentDto documentDto : documentDtos) {
            documentEntities.add(convertFromDto(documentDto));
        }

        return documentEntities;
    }
}
