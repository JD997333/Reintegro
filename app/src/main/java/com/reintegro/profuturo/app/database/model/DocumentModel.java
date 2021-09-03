package com.reintegro.profuturo.app.database.model;

import java.util.UUID;

import io.realm.RealmList;
import io.realm.RealmObject;
import io.realm.annotations.PrimaryKey;

public class DocumentModel extends RealmObject {
    @PrimaryKey
    private String id = UUID.randomUUID().toString();

    private RealmList<String> signatureHolders;
    private RealmList<String> signatures;
    private String documentName;
    private String expedientType;
    private String filePath;
    private String pagination;
    private boolean captured;
    private boolean requiredByProcesar;
    private boolean requiredByProfuturo;
    private int documentKey;
    private int documentType;
    private long consecutive;

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public RealmList<String> getSignatureHolders() {
        return signatureHolders;
    }

    public void setSignatureHolders(RealmList<String> signatureHolders) {
        this.signatureHolders = signatureHolders;
    }

    public RealmList<String> getSignatures() {
        return signatures;
    }

    public void setSignatures(RealmList<String> signatures) {
        this.signatures = signatures;
    }

    public String getDocumentName() {
        return documentName;
    }

    public void setDocumentName(String documentName) {
        this.documentName = documentName;
    }

    public String getExpedientType() {
        return expedientType;
    }

    public void setExpedientType(String expedientType) {
        this.expedientType = expedientType;
    }

    public String getFilePath() {
        return filePath;
    }

    public void setFilePath(String filePath) {
        this.filePath = filePath;
    }

    public String getPagination() {
        return pagination;
    }

    public void setPagination(String pagination) {
        this.pagination = pagination;
    }

    public boolean isCaptured() {
        return captured;
    }

    public void setCaptured(boolean captured) {
        this.captured = captured;
    }

    public boolean isRequiredByProcesar() {
        return requiredByProcesar;
    }

    public void setRequiredByProcesar(boolean requiredByProcesar) {
        this.requiredByProcesar = requiredByProcesar;
    }

    public boolean isRequiredByProfuturo() {
        return requiredByProfuturo;
    }

    public void setRequiredByProfuturo(boolean requiredByProfuturo) {
        this.requiredByProfuturo = requiredByProfuturo;
    }

    public int getDocumentKey() {
        return documentKey;
    }

    public void setDocumentKey(int documentKey) {
        this.documentKey = documentKey;
    }

    public int getDocumentType() {
        return documentType;
    }

    public void setDocumentType(int documentType) {
        this.documentType = documentType;
    }

    public long getConsecutive() {
        return consecutive;
    }

    public void setConsecutive(long consecutive) {
        this.consecutive = consecutive;
    }
}

