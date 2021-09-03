package com.reintegro.profuturo.app.api.vo;


import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

public class ValidateAuthFolioResponse {

    @SerializedName("validarFolioAutenticacionResponse")
    @Expose
    private ValidateAuthFolioOut validateAuthFolioOut;

    public ValidateAuthFolioOut getValidateAuthFolioOut() {
        return validateAuthFolioOut;
    }

    public void setValidateAuthFolioOut(ValidateAuthFolioOut validateAuthFolioOut) {
        this.validateAuthFolioOut = validateAuthFolioOut;
    }

    public static class ValidateAuthFolioOut {

        @SerializedName("status")
        @Expose
        private Integer status;
        @SerializedName("result")
        @Expose
        private Boolean result;
        @SerializedName("statusText")
        @Expose
        private String statusText;
        @SerializedName("informacionAutenticacion")
        @Expose
        private InformacionAutenticacion informacionAutenticacion;

        public Integer getStatus() {
            return status;
        }

        public void setStatus(Integer status) {
            this.status = status;
        }

        public Boolean getResult() {
            return result;
        }

        public void setResult(Boolean result) {
            this.result = result;
        }

        public String getStatusText() {
            return statusText;
        }

        public void setStatusText(String statusText) {
            this.statusText = statusText;
        }

        public InformacionAutenticacion getInformacionAutenticacion() {
            return informacionAutenticacion;
        }

        public void setInformacionAutenticacion(InformacionAutenticacion informacionAutenticacion) {
            this.informacionAutenticacion = informacionAutenticacion;
        }

    }


    public static class InformacionAutenticacion {

        @SerializedName("proceso")
        @Expose
        private Integer proceso;
        @SerializedName("curpTitular")
        @Expose
        private String curpTitular;
        @SerializedName("telefono")
        @Expose
        private String telefono;
        @SerializedName("fechaAutenticacion")
        @Expose
        private String fechaAutenticacion;
        @SerializedName("vigenciaAutenticacion")
        @Expose
        private String vigenciaAutenticacion;

        public Integer getProceso() {
            return proceso;
        }

        public void setProceso(Integer proceso) {
            this.proceso = proceso;
        }

        public String getCurpTitular() {
            return curpTitular;
        }

        public void setCurpTitular(String curpTitular) {
            this.curpTitular = curpTitular;
        }

        public String getTelefono() {
            return telefono;
        }

        public void setTelefono(String telefono) {
            this.telefono = telefono;
        }

        public String getFechaAutenticacion() {
            return fechaAutenticacion;
        }

        public void setFechaAutenticacion(String fechaAutenticacion) {
            this.fechaAutenticacion = fechaAutenticacion;
        }

        public String getVigenciaAutenticacion() {
            return vigenciaAutenticacion;
        }

        public void setVigenciaAutenticacion(String vigenciaAutenticacion) {
            this.vigenciaAutenticacion = vigenciaAutenticacion;
        }

    }
}