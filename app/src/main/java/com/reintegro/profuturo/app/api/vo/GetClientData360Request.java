package com.reintegro.profuturo.app.api.vo;


import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

public class GetClientData360Request {

    @SerializedName("consultarTrabajador")
    @Expose
    private ConsultarTrabajador consultarTrabajador;

    public ConsultarTrabajador getConsultarTrabajador() {
        return consultarTrabajador;
    }

    public void setConsultarTrabajador(ConsultarTrabajador consultarTrabajador) {
        this.consultarTrabajador = consultarTrabajador;
    }


    public static class ConsultarTrabajador {

        @SerializedName("nss")
        @Expose
        private String nss;
        @SerializedName("idCliente")
        @Expose
        private String idCliente;
        @SerializedName("idServicio")
        @Expose
        private String idServicio;
        @SerializedName("idEbusiness")
        @Expose
        private String idEbusiness;

        public String getNss() {
            return nss;
        }

        public void setNss(String nss) {
            this.nss = nss;
        }

        public String getIdCliente() {
            return idCliente;
        }

        public void setIdCliente(String idCliente) {
            this.idCliente = idCliente;
        }

        public String getIdServicio() {
            return idServicio;
        }

        public void setIdServicio(String idServicio) {
            this.idServicio = idServicio;
        }

        public String getIdEbusiness() {
            return idEbusiness;
        }

        public void setIdEbusiness(String idEbusiness) {
            this.idEbusiness = idEbusiness;
        }

    }



}