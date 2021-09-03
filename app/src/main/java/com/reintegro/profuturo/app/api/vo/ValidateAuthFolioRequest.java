package com.reintegro.profuturo.app.api.vo;


import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

public class ValidateAuthFolioRequest {

    @SerializedName("validarFolioAutenticacion")
    @Expose
    private ValidateAuthFolioIn validateAuthFolioIn;

    public ValidateAuthFolioIn getValidateAuthFolioIn() {
        return validateAuthFolioIn;
    }

    public void setValidateAuthFolioIn(ValidateAuthFolioIn validateAuthFolioIn) {
        this.validateAuthFolioIn = validateAuthFolioIn;
    }


    public static class ValidateAuthFolioIn {

        @SerializedName("proceso")
        @Expose
        private Integer proceso;
        @SerializedName("curpTitular")
        @Expose
        private String curpTitular;
        @SerializedName("folioAutenticacion")
        @Expose
        private String folioAutenticacion;

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

        public String getFolioAutenticacion() {
            return folioAutenticacion;
        }

        public void setFolioAutenticacion(String folioAutenticacion) {
            this.folioAutenticacion = folioAutenticacion;
        }

    }
}