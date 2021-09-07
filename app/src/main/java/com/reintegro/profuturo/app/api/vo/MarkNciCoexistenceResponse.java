package com.reintegro.profuturo.app.api.vo;


import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

public class MarkNciCoexistenceResponse {

    @SerializedName("success")
    @Expose
    private String success;
    @SerializedName("convive")
    @Expose
    private String convive;
    @SerializedName("mensaje")
    @Expose
    private String mensaje;
    @SerializedName("descripcionSubProceso")
    @Expose
    private String descripcionSubProceso;
    @SerializedName("idError")
    @Expose
    private String idError;
    @SerializedName("descripcionNoConvivencia")
    @Expose
    private String descripcionNoConvivencia;
    @SerializedName("subCuentas")
    @Expose
    private SubCuentas subCuentas;

    public String getSuccess() {
        return success;
    }

    public void setSuccess(String success) {
        this.success = success;
    }

    public String getConvive() {
        return convive;
    }

    public void setConvive(String convive) {
        this.convive = convive;
    }

    public String getMensaje() {
        return mensaje;
    }

    public void setMensaje(String mensaje) {
        this.mensaje = mensaje;
    }

    public String getDescripcionSubProceso() {
        return descripcionSubProceso;
    }

    public void setDescripcionSubProceso(String descripcionSubProceso) {
        this.descripcionSubProceso = descripcionSubProceso;
    }

    public String getIdError() {
        return idError;
    }

    public void setIdError(String idError) {
        this.idError = idError;
    }

    public String getDescripcionNoConvivencia() {
        return descripcionNoConvivencia;
    }

    public void setDescripcionNoConvivencia(String descripcionNoConvivencia) {
        this.descripcionNoConvivencia = descripcionNoConvivencia;
    }

    public SubCuentas getSubCuentas() {
        return subCuentas;
    }

    public void setSubCuentas(SubCuentas subCuentas) {
        this.subCuentas = subCuentas;
    }

    public static class SubCuentas {

        @SerializedName("convive")
        @Expose
        private String convive;
        @SerializedName("idSubCuenta")
        @Expose
        private String idSubCuenta;
        @SerializedName("mensaje")
        @Expose
        private String mensaje;
        @SerializedName("validacion")
        @Expose
        private String validacion;

        public String getConvive() {
            return convive;
        }

        public void setConvive(String convive) {
            this.convive = convive;
        }

        public String getIdSubCuenta() {
            return idSubCuenta;
        }

        public void setIdSubCuenta(String idSubCuenta) {
            this.idSubCuenta = idSubCuenta;
        }

        public String getMensaje() {
            return mensaje;
        }

        public void setMensaje(String mensaje) {
            this.mensaje = mensaje;
        }

        public String getValidacion() {
            return validacion;
        }

        public void setValidacion(String validacion) {
            this.validacion = validacion;
        }

    }

}