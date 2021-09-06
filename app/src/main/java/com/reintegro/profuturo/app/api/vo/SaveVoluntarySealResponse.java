package com.reintegro.profuturo.app.api.vo;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

public class SaveVoluntarySealResponse {
    @SerializedName("guardarSelloProceSARResponse")
    @Expose
    private SaveVoluntarySealRespBody saveVoluntarySealRespBody;

    public SaveVoluntarySealRespBody getSaveVoluntarySealRespBody() {
        return saveVoluntarySealRespBody;
    }

    public void setSaveVoluntarySealRespBody(SaveVoluntarySealRespBody saveVoluntarySealRespBody) {
        this.saveVoluntarySealRespBody = saveVoluntarySealRespBody;
    }

    public static class SaveVoluntarySealRespBody {

        @SerializedName("Estatus")
        @Expose
        private Boolean estatus;
        @SerializedName("mensaje")
        @Expose
        private String mensaje;
        @SerializedName("idSello")
        @Expose
        private String idSello;

        public Boolean getEstatus() {
            return estatus;
        }

        public void setEstatus(Boolean estatus) {
            this.estatus = estatus;
        }

        public String getMensaje() {
            return mensaje;
        }

        public void setMensaje(String mensaje) {
            this.mensaje = mensaje;
        }

        public String getIdSello() {
            return idSello;
        }

        public void setIdSello(String idSello) {
            this.idSello = idSello;
        }

    }
}
