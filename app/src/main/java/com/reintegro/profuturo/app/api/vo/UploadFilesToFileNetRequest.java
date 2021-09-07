package com.reintegro.profuturo.app.api.vo;

import com.google.gson.annotations.SerializedName;

import java.util.List;

public class UploadFilesToFileNetRequest {
    public static class DocumentName {
        @SerializedName("base64") private String base64;
        @SerializedName("nombre") private String name;

        public void setName(String name) {
            this.name = name;
        }

        public void setBase64(String base64) {
            this.base64 = base64;
        }
    }

    public static class ImageData {
        @SerializedName("idProceso") private Integer processId;
        @SerializedName("idTramite") private String binnacleFolio;
        @SerializedName("nombreDocumentos") private List<DocumentName> documents;
        @SerializedName("reIntento") private Boolean retry;
        @SerializedName("total") private Long total;

        public void setProcessId(Integer processId) {
            this.processId = processId;
        }

        public void setBinnacleFolio(String binnacleFolio) {
            this.binnacleFolio = binnacleFolio;
        }

        public void setDocuments(List<DocumentName> documents) {
            this.documents = documents;
        }

        public void setRetry(Boolean retry) {
            this.retry = retry;
        }

        public void setTotal(Long total) {
            this.total = total;
        }
    }

    public static class Request {
        @SerializedName("datosCargaImagen") private ImageData imageData;

        public void setImageData(ImageData imageData) {
            this.imageData = imageData;
        }
    }

    @SerializedName("cargarImagenRequest") private Request request;

    public void setRequest(Request request) {
        this.request = request;
    }
}