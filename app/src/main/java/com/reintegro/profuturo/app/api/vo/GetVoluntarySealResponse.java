package com.reintegro.profuturo.app.api.vo;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

import java.util.List;

public class GetVoluntarySealResponse {
    @SerializedName("status")
    @Expose
    private Integer status;
    @SerializedName("statusText")
    @Expose
    private String statusText;
    @SerializedName("infoSello")
    @Expose
    private SealInformation sealInformation;

    public Integer getStatus() {
        return status;
    }

    public void setStatus(Integer status) {
        this.status = status;
    }

    public String getStatusText() {
        return statusText;
    }

    public void setStatusText(String statusText) {
        this.statusText = statusText;
    }

    public SealInformation getSealInformation() {
        return sealInformation;
    }

    public void setSealInformation(SealInformation sealInformation) {
        this.sealInformation = sealInformation;
    }

    public static class SealInformation {

        @SerializedName("idSello")
        @Expose
        private Integer idSello;
        @SerializedName("resultadoVerificacion")
        @Expose
        private String resultadoVerificacion;
        @SerializedName("selloVerificacion")
        @Expose
        private String selloVerificacion;
        @SerializedName("validacionPosDesc")
        @Expose
        private Boolean validacionPosDesc;
        @SerializedName("diagnosticos")
        @Expose
        private List<SealDiagnoseResponse> diagnoseList;

        public Integer getIdSello() {
            return idSello;
        }

        public void setIdSello(Integer idSello) {
            this.idSello = idSello;
        }

        public String getResultadoVerificacion() {
            return resultadoVerificacion;
        }

        public void setResultadoVerificacion(String resultadoVerificacion) {
            this.resultadoVerificacion = resultadoVerificacion;
        }

        public String getSelloVerificacion() {
            return selloVerificacion;
        }

        public void setSelloVerificacion(String selloVerificacion) {
            this.selloVerificacion = selloVerificacion;
        }

        public Boolean getValidacionPosDesc() {
            return validacionPosDesc;
        }

        public void setValidacionPosDesc(Boolean validacionPosDesc) {
            this.validacionPosDesc = validacionPosDesc;
        }

        public List<SealDiagnoseResponse> getDiagnoseList() {
            return diagnoseList;
        }

        public void setDiagnoseList(List<SealDiagnoseResponse> diagnoseList) {
            this.diagnoseList = diagnoseList;
        }
    }

    public static class SealDiagnoseResponse {

        @SerializedName("clave")
        @Expose
        private String clave;
        @SerializedName("descripcion")
        @Expose
        private String descripcion;

        public String getClave() {
            return clave;
        }

        public void setClave(String clave) {
            this.clave = clave;
        }

        public String getDescripcion() {
            return descripcion;
        }

        public void setDescripcion(String descripcion) {
            this.descripcion = descripcion;
        }
    }
}
