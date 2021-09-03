package com.reintegro.profuturo.app.api.vo;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

import java.util.List;

public class GetRepaymentEventsResponse {

    @SerializedName("consultarHistoricosResponse")
    @Expose
    private List<RepaymentEvent> repaymentEvents;

    public List<RepaymentEvent> getRepaymentEvents() {
        return repaymentEvents;
    }

    public void setRepaymentEvents(List<RepaymentEvent> repaymentEvents) {
        this.repaymentEvents = repaymentEvents;
    }

    public static class RepaymentEvent {

        @SerializedName("claveAforeRetiroReintegro")
        @Expose
        private String claveAforeRetiroReintegro;
        @SerializedName("diagnosticoProceso")
        @Expose
        private String diagnosticoProceso;
        @SerializedName("fechaRetiroReintegro")
        @Expose
        private String fechaRetiroReintegro;
        @SerializedName("montoRetiroReintegro")
        @Expose
        private String montoRetiroReintegro;
        @SerializedName("nssTrabajador")
        @Expose
        private String nssTrabajador;
        @SerializedName("numeroResolucion")
        @Expose
        private String numeroResolucion;
        @SerializedName("resultadoOperacion")
        @Expose
        private String resultadoOperacion;
        @SerializedName("semanasDescontadosRecuperadas")
        @Expose
        private String semanasDescontadosRecuperadas;
        @SerializedName("tipoPrestacion")
        @Expose
        private String tipoPrestacion;
        @SerializedName("valorDiaReintegrar")
        @Expose
        private String valorDiaReintegrar;

        public String getClaveAforeRetiroReintegro() {
            return claveAforeRetiroReintegro;
        }

        public void setClaveAforeRetiroReintegro(String claveAforeRetiroReintegro) {
            this.claveAforeRetiroReintegro = claveAforeRetiroReintegro;
        }

        public String getDiagnosticoProceso() {
            return diagnosticoProceso;
        }

        public void setDiagnosticoProceso(String diagnosticoProceso) {
            this.diagnosticoProceso = diagnosticoProceso;
        }

        public String getFechaRetiroReintegro() {
            return fechaRetiroReintegro;
        }

        public void setFechaRetiroReintegro(String fechaRetiroReintegro) {
            this.fechaRetiroReintegro = fechaRetiroReintegro;
        }

        public String getMontoRetiroReintegro() {
            return montoRetiroReintegro;
        }

        public void setMontoRetiroReintegro(String montoRetiroReintegro) {
            this.montoRetiroReintegro = montoRetiroReintegro;
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

        public String getResultadoOperacion() {
            return resultadoOperacion;
        }

        public void setResultadoOperacion(String resultadoOperacion) {
            this.resultadoOperacion = resultadoOperacion;
        }

        public String getSemanasDescontadosRecuperadas() {
            return semanasDescontadosRecuperadas;
        }

        public void setSemanasDescontadosRecuperadas(String semanasDescontadosRecuperadas) {
            this.semanasDescontadosRecuperadas = semanasDescontadosRecuperadas;
        }

        public String getTipoPrestacion() {
            return tipoPrestacion;
        }

        public void setTipoPrestacion(String tipoPrestacion) {
            this.tipoPrestacion = tipoPrestacion;
        }

        public String getValorDiaReintegrar() {
            return valorDiaReintegrar;
        }

        public void setValorDiaReintegrar(String valorDiaReintegrar) {
            this.valorDiaReintegrar = valorDiaReintegrar;
        }

    }
}
