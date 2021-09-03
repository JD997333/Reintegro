package com.reintegro.profuturo.app.data.repository;

import com.reintegro.profuturo.app.data.entity.DocumentEntity;

import java.util.List;

public interface DocumentRepository {
    List<DocumentEntity> addAll(List<DocumentEntity> documentEntities);
    List<DocumentEntity> getCaptured();
    List<DocumentEntity> updateAll(List<DocumentEntity> documentEntities);
    void clear();
}