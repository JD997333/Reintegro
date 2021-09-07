package com.reintegro.profuturo.app.api.vo;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

public class InsertInitialRulingRequest {
    @SerializedName("iniciar")
    @Expose
    private Iniciar iniciar;

    public Iniciar getIniciar() {
        return iniciar;
    }

    public void setIniciar(Iniciar iniciar) {
        this.iniciar = iniciar;
    }

    public static class Iniciar {

        @SerializedName("folio")
        @Expose
        private String folio;
        @SerializedName("folioBitacora")
        @Expose
        private String folioBitacora;
        @SerializedName("idTipoTramite")
        @Expose
        private String idTipoTramite;
        @SerializedName("nombreTipoTramite")
        @Expose
        private String nombreTipoTramite;
        @SerializedName("idProceso")
        @Expose
        private String idProceso;
        @SerializedName("nombreProceso")
        @Expose
        private String nombreProceso;

        public String getFolio() {
            return folio;
        }

        public void setFolio(String folio) {
            this.folio = folio;
        }

        public String getFolioBitacora() {
            return folioBitacora;
        }

        public void setFolioBitacora(String folioBitacora) {
            this.folioBitacora = folioBitacora;
        }

        public String getIdTipoTramite() {
            return idTipoTramite;
        }

        public void setIdTipoTramite(String idTipoTramite) {
            this.idTipoTramite = idTipoTramite;
        }

        public String getNombreTipoTramite() {
            return nombreTipoTramite;
        }

        public void setNombreTipoTramite(String nombreTipoTramite) {
            this.nombreTipoTramite = nombreTipoTramite;
        }

        public String getIdProceso() {
            return idProceso;
        }

        public void setIdProceso(String idProceso) {
            this.idProceso = idProceso;
        }

        public String getNombreProceso() {
            return nombreProceso;
        }

        public void setNombreProceso(String nombreProceso) {
            this.nombreProceso = nombreProceso;
        }

    }
}
