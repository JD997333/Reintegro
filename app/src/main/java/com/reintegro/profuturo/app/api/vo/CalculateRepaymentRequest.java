package com.reintegro.profuturo.app.api.vo;


import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

public class CalculateRepaymentRequest {

    @SerializedName("calcularReintegro")
    @Expose
    private CalculateRepayment calculateRepayment;

    public CalculateRepayment getCalcularReintegro() {
        return calculateRepayment;
    }

    public void setCalcularReintegro(CalculateRepayment calculateRepayment) {
        this.calculateRepayment = calculateRepayment;
    }



    public static class CalculateRepayment {

        @SerializedName("claveAfore")
        @Expose
        private String claveAfore;
        @SerializedName("fechaRetiro")
        @Expose
        private String fechaRetiro;
        @SerializedName("nssTrabajador")
        @Expose
        private String nssTrabajador;
        @SerializedName("numeroResolucion")
        @Expose
        private String numeroResolucion;
        @SerializedName("numeroSemanasReintegrar")
        @Expose
        private String numeroSemanasReintegrar;

        public String getClaveAfore() {
            return claveAfore;
        }

        public void setClaveAfore(String claveAfore) {
            this.claveAfore = claveAfore;
        }

        public String getFechaRetiro() {
            return fechaRetiro;
        }

        public void setFechaRetiro(String fechaRetiro) {
            this.fechaRetiro = fechaRetiro;
        }

        public String getNssTrabajador() {
            return nssTrabajador;
        }

        public void setNssTrabajador(String nssTrabajador) {
            this.nssTrabajador = nssTrabajador;
        }

        public String getNumeroResolucion() {
            return numeroResolucion;
        }

        public void setNumeroResolucion(String numeroResolucion) {
            this.numeroResolucion = numeroResolucion;
        }

        public String getNumeroSemanasReintegrar() {
            return numeroSemanasReintegrar;
        }

        public void setNumeroSemanasReintegrar(String numeroSemanasReintegrar) {
            this.numeroSemanasReintegrar = numeroSemanasReintegrar;
        }

    }


}
