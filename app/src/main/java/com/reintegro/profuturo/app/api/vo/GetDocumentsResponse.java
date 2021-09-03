package com.reintegro.profuturo.app.api.vo;

import com.google.gson.annotations.SerializedName;

import java.util.List;

public class GetDocumentsResponse {
    @SerializedName("respuesta")
    private List<DocumentCapture> documents;

    public List<DocumentCapture> getDocuments() {
        return documents;
    }

    public void setDocuments(List<DocumentCapture> documents) {
        this.documents = documents;
    }


    public static class DocumentCapture{
        @SerializedName("documentosACapturar")
        private DocumentData documentData;

        public DocumentData getDocumentData() {
            return documentData;
        }

        public void setDocumentData(DocumentData documentData) {
            this.documentData = documentData;
        }
    }

    public static class DocumentData{
        @SerializedName("claveDocumento")
        private String documentKey;
        @SerializedName("consecutivo")
        private Long consecutive;
        @SerializedName("obligatorio")
        private Required required;
        @SerializedName("paginacion")
        private String pagination;
        @SerializedName("tipoDocumento")
        private String documentName;
        @SerializedName("tipoExpediente")
        private String expedientType;

        public String getDocumentKey() {
            return documentKey;
        }

        public void setDocumentKey(String documentKey) {
            this.documentKey = documentKey;
        }

        public Long getConsecutive() {
            return consecutive;
        }

        public void setConsecutive(Long consecutive) {
            this.consecutive = consecutive;
        }

        public Required getRequired() {
            return required;
        }

        public void setRequired(Required required) {
            this.required = required;
        }

        public String getPagination() {
            return pagination;
        }

        public void setPagination(String pagination) {
            this.pagination = pagination;
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
    }

    public static class Required {
        @SerializedName("procesar")
        private String requiredByProcesar;
        @SerializedName("profuturo")
        private String requiredByProfuturo;

        public String isRequiredByProcesar() {
            return requiredByProcesar;
        }

        public void setRequiredByProcesar(String requiredByProcesar) {
            this.requiredByProcesar = requiredByProcesar;
        }

        public String isRequiredByProfuturo() {
            return requiredByProfuturo;
        }

        public void setRequiredByProfuturo(String requiredByProfuturo) {
            this.requiredByProfuturo = requiredByProfuturo;
        }
    }
}
