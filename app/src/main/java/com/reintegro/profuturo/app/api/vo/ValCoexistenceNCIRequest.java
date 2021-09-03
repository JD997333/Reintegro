package com.reintegro.profuturo.app.api.vo;


import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

import java.util.List;

public class ValCoexistenceNCIRequest {

    @SerializedName("consultaConvivenciaCompletaComunNCIRequest")
    @Expose
    private CoexistenceNCIRequest coexistenceNCIRequest;

    public CoexistenceNCIRequest getConsultaConvivenciaCompletaComunNCIRequest() {
        return coexistenceNCIRequest;
    }

    public void setConsultaConvivenciaCompletaComunNCIRequest(CoexistenceNCIRequest coexistenceNCIRequest) {
        this.coexistenceNCIRequest = coexistenceNCIRequest;
    }



    public static class CoexistenceNCIRequest {

        @SerializedName("idProceso")
        @Expose
        private String idProceso;
        @SerializedName("idSaldoOpera")
        @Expose
        private String idSaldoOpera;
        @SerializedName("idSubProceso")
        @Expose
        private String idSubProceso;
        @SerializedName("idTipoMovimiento")
        @Expose
        private String idTipoMovimiento;
        @SerializedName("numCuentaIndividual")
        @Expose
        private String numCuentaIndividual;
        @SerializedName("datosSubcta")
        @Expose
        private DatosSubcta datosSubcta;

        public String getIdProceso() {
            return idProceso;
        }

        public void setIdProceso(String idProceso) {
            this.idProceso = idProceso;
        }

        public String getIdSaldoOpera() {
            return idSaldoOpera;
        }

        public void setIdSaldoOpera(String idSaldoOpera) {
            this.idSaldoOpera = idSaldoOpera;
        }

        public String getIdSubProceso() {
            return idSubProceso;
        }

        public void setIdSubProceso(String idSubProceso) {
            this.idSubProceso = idSubProceso;
        }

        public String getIdTipoMovimiento() {
            return idTipoMovimiento;
        }

        public void setIdTipoMovimiento(String idTipoMovimiento) {
            this.idTipoMovimiento = idTipoMovimiento;
        }

        public String getNumCuentaIndividual() {
            return numCuentaIndividual;
        }

        public void setNumCuentaIndividual(String numCuentaIndividual) {
            this.numCuentaIndividual = numCuentaIndividual;
        }

        public DatosSubcta getDatosSubcta() {
            return datosSubcta;
        }

        public void setDatosSubcta(DatosSubcta datosSubcta) {
            this.datosSubcta = datosSubcta;
        }

    }


    public static class DatosSubcta {

        @SerializedName("Subcuenta")
        @Expose
        private List<SubCta> subcuenta = null;

        public List<SubCta> getSubcuenta() {
            return subcuenta;
        }

        public void setSubcuenta(List<SubCta> subcuenta) {
            this.subcuenta = subcuenta;
        }

    }



    public static class SubCta {

        @SerializedName("idSubcuenta")
        @Expose
        private String idSubcuenta;
        @SerializedName("idTipoMonto")
        @Expose
        private Integer idTipoMonto;
        @SerializedName("monto")
        @Expose
        private Double monto;

        public String getIdSubcuenta() {
            return idSubcuenta;
        }

        public void setIdSubcuenta(String idSubcuenta) {
            this.idSubcuenta = idSubcuenta;
        }

        public Integer getIdTipoMonto() {
            return idTipoMonto;
        }

        public void setIdTipoMonto(Integer idTipoMonto) {
            this.idTipoMonto = idTipoMonto;
        }

        public Double getMonto() {
            return monto;
        }

        public void setMonto(Double monto) {
            this.monto = monto;
        }

    }

}
