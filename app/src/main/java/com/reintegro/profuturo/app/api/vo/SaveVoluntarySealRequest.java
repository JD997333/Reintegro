package com.reintegro.profuturo.app.api.vo;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

public class SaveVoluntarySealRequest {
    @SerializedName("guardarSelloProceSARRequest")
    @Expose
    private SaveVoluntarySealBody saveVoluntarySealBody;

    public SaveVoluntarySealBody getSaveVoluntarySealBody() {
        return saveVoluntarySealBody;
    }

    public void setSaveVoluntarySealBody(SaveVoluntarySealBody saveVoluntarySealBody) {
        this.saveVoluntarySealBody = saveVoluntarySealBody;
    }

    public static class SaveVoluntarySealBody {

        @SerializedName("claveAfore")
        @Expose
        private String claveAfore;
        @SerializedName("claveConsar")
        @Expose
        private String claveConsar;
        @SerializedName("curpEmpleado")
        @Expose
        private String curpEmpleado;
        @SerializedName("curpTrabajador")
        @Expose
        private String curpTrabajador;
        @SerializedName("fechaGeneracion")
        @Expose
        private String fechaGeneracion;
        @SerializedName("fechaVigencia")
        @Expose
        private String fechaVigencia;
        @SerializedName("idEstatusSello")
        @Expose
        private String idEstatusSello;
        @SerializedName("idTipoSello")
        @Expose
        private String idTipoSello;
        @SerializedName("idTramite")
        @Expose
        private String idTramite;
        @SerializedName("numeroEmpleado")
        @Expose
        private String numeroEmpleado;
        @SerializedName("resultadoVerificacion")
        @Expose
        private String resultadoVerificacion;
        @SerializedName("selloVerificacion")
        @Expose
        private String selloVerificacion;

        public String getClaveAfore() {
            return claveAfore;
        }

        public void setClaveAfore(String claveAfore) {
            this.claveAfore = claveAfore;
        }

        public String getClaveConsar() {
            return claveConsar;
        }

        public void setClaveConsar(String claveConsar) {
            this.claveConsar = claveConsar;
        }

        public String getCurpEmpleado() {
            return curpEmpleado;
        }

        public void setCurpEmpleado(String curpEmpleado) {
            this.curpEmpleado = curpEmpleado;
        }

        public String getCurpTrabajador() {
            return curpTrabajador;
        }

        public void setCurpTrabajador(String curpTrabajador) {
            this.curpTrabajador = curpTrabajador;
        }

        public String getFechaGeneracion() {
            return fechaGeneracion;
        }

        public void setFechaGeneracion(String fechaGeneracion) {
            this.fechaGeneracion = fechaGeneracion;
        }

        public String getFechaVigencia() {
            return fechaVigencia;
        }

        public void setFechaVigencia(String fechaVigencia) {
            this.fechaVigencia = fechaVigencia;
        }

        public String getIdEstatusSello() {
            return idEstatusSello;
        }

        public void setIdEstatusSello(String idEstatusSello) {
            this.idEstatusSello = idEstatusSello;
        }

        public String getIdTipoSello() {
            return idTipoSello;
        }

        public void setIdTipoSello(String idTipoSello) {
            this.idTipoSello = idTipoSello;
        }

        public String getIdTramite() {
            return idTramite;
        }

        public void setIdTramite(String idTramite) {
            this.idTramite = idTramite;
        }

        public String getNumeroEmpleado() {
            return numeroEmpleado;
        }

        public void setNumeroEmpleado(String numeroEmpleado) {
            this.numeroEmpleado = numeroEmpleado;
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

    }

}
