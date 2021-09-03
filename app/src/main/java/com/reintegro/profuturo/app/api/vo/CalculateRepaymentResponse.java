package com.reintegro.profuturo.app.api.vo;


import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

public class CalculateRepaymentResponse {

    @SerializedName("calcularReintegroResponse")
    @Expose
    private CalculateRepaymentResp calculateRepaymentResp;

    public CalculateRepaymentResp getCalculateRepaymentResp() {
        return calculateRepaymentResp;
    }

    public void setCalculateRepaymentResp(CalculateRepaymentResp calculateRepaymentResp) {
        this.calculateRepaymentResp = calculateRepaymentResp;
    }

    public static class CalculateRepaymentResp {

        @SerializedName("diagnosticoProceso")
        @Expose
        private String diagnosticoProceso;
        @SerializedName("fechaRetiro")
        @Expose
        private String fechaRetiro;
        @SerializedName("maxSemanasReintegrar")
        @Expose
        private String maxSemanasReintegrar;
        @SerializedName("montoReintegrar")
        @Expose
        private String montoReintegrar;
        @SerializedName("nssTrabajador")
        @Expose
        private String nssTrabajador;
        @SerializedName("numeroResolucion")
        @Expose
        private String numeroResolucion;
        @SerializedName("numeroSemanasReintegrar")
        @Expose
        private String numeroSemanasReintegrar;
        @SerializedName("resultadoOperacion")
        @Expose
        private String resultadoOperacion;

        public String getDiagnosticoProceso() {
            return diagnosticoProceso;
        }

        public void setDiagnosticoProceso(String diagnosticoProceso) {
            this.diagnosticoProceso = diagnosticoProceso;
        }

        public String getFechaRetiro() {
            return fechaRetiro;
        }

        public void setFechaRetiro(String fechaRetiro) {
            this.fechaRetiro = fechaRetiro;
        }

        public String getMaxSemanasReintegrar() {
            return maxSemanasReintegrar;
        }

        public void setMaxSemanasReintegrar(String maxSemanasReintegrar) {
            this.maxSemanasReintegrar = maxSemanasReintegrar;
        }

        public String getMontoReintegrar() {
            return montoReintegrar;
        }

        public void setMontoReintegrar(String montoReintegrar) {
            this.montoReintegrar = montoReintegrar;
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

        public String getResultadoOperacion() {
            return resultadoOperacion;
        }

        public void setResultadoOperacion(String resultadoOperacion) {
            this.resultadoOperacion = resultadoOperacion;
        }

    }

}