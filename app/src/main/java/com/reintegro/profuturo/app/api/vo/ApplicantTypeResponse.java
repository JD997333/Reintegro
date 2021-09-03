package com.reintegro.profuturo.app.api.vo;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

import java.util.List;

public class ApplicantTypeResponse {

    @SerializedName("tipoSolicitanteResponse")
    @Expose
    private TipoSolicitanteResponse tipoSolicitanteResponse;

    public TipoSolicitanteResponse getTipoSolicitanteResponse() {
        return tipoSolicitanteResponse;
    }

    public void setTipoSolicitanteResponse(TipoSolicitanteResponse tipoSolicitanteResponse) {
        this.tipoSolicitanteResponse = tipoSolicitanteResponse;
    }


    public static class TipoSolicitanteResponse {

        @SerializedName("listaTipoSolicitante")
        @Expose
        private List<ApplicantType> applicantTypeList;

        public List<ApplicantType> getListaTipoSolicitante() {
            return applicantTypeList;
        }

        public void setListaTipoSolicitante(List<ApplicantType> applicantType) {
            this.applicantTypeList = applicantType;
        }

    }


    public static class ApplicantType {

        @SerializedName("id")
        @Expose
        private String id;
        @SerializedName("descripcion")
        @Expose
        private String descripcion;

        public String getId() {
            return id;
        }

        public void setId(String id) {
            this.id = id;
        }

        public String getDescripcion() {
            return descripcion;
        }

        public void setDescripcion(String descripcion) {
            this.descripcion = descripcion;
        }

    }

}