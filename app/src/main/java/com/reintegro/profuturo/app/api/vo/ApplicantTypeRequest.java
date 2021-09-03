package com.reintegro.profuturo.app.api.vo;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

public class ApplicantTypeRequest {

    @SerializedName("tipoSolicitanteRequest")
    @Expose
    private TipoSolicitanteRequest tipoSolicitanteRequest;

    public TipoSolicitanteRequest getTipoSolicitanteRequest() {
        return tipoSolicitanteRequest;
    }

    public void setTipoSolicitanteRequest(TipoSolicitanteRequest tipoSolicitanteRequest) {
        this.tipoSolicitanteRequest = tipoSolicitanteRequest;
    }



    public static class TipoSolicitanteRequest {

        @SerializedName("numCta")
        @Expose
        private String numCta;
        @SerializedName("tipoCliente")
        @Expose
        private String tipoCliente;
        @SerializedName("proceso")
        @Expose
        private String proceso;
        @SerializedName("subProceso")
        @Expose
        private String subProceso;

        public String getNumCta() {
            return numCta;
        }

        public void setNumCta(String numCta) {
            this.numCta = numCta;
        }

        public String getTipoCliente() {
            return tipoCliente;
        }

        public void setTipoCliente(String tipoCliente) {
            this.tipoCliente = tipoCliente;
        }

        public String getProceso() {
            return proceso;
        }

        public void setProceso(String proceso) {
            this.proceso = proceso;
        }

        public String getSubProceso() {
            return subProceso;
        }

        public void setSubProceso(String subProceso) {
            this.subProceso = subProceso;
        }

    }

}