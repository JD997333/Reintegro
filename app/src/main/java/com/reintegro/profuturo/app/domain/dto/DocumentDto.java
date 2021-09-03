package com.reintegro.profuturo.app.domain.dto;

import java.io.File;
import java.util.HashMap;

public class DocumentDto {
    private File file;
    private HashMap<String, String> signatureHolders;
    private String documentName;
    private String expedientType;
    private String id;
    private String pagination;
    private boolean captured;
    private boolean requiredByProcesar;
    private boolean requiredByProfuturo;
    private int documentKey;
    private int documentType;
    private long consecutive;

    public File getFile() {
        return file;
    }

    public void setFile(File file) {
        this.file = file;
    }

    public HashMap<String, String> getSignatureHolders() {
        return signatureHolders;
    }

    public void setSignatureHolders(HashMap<String, String> signatureHolders) {
        this.signatureHolders = signatureHolders;
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

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
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

