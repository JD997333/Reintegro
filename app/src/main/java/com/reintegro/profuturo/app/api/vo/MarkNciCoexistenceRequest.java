package com.reintegro.profuturo.app.api.vo;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

import java.util.List;

public class MarkNciCoexistenceRequest {

    @SerializedName("folio")
    @Expose
    private String folio;
    @SerializedName("folioRelasionado")
    @Expose
    private String folioRelacionado;
    @SerializedName("idProceso")
    @Expose
    private String idProceso;
    @SerializedName("idSubProceso")
    @Expose
    private String idSubProceso;
    @SerializedName("numCuentaIndividual")
    @Expose
    private String numCuentaIndividual;
    @SerializedName("idSaldoOpera")
    @Expose
    private String idSaldoOpera;
    @SerializedName("tipoMovimiento")
    @Expose
    private String tipoMovimiento;
    @SerializedName("idSubEtapa")
    @Expose
    private String idSubEtapa;
    @SerializedName("usuario")
    @Expose
    private String usuario;
    @SerializedName("datosSubCta")
    @Expose
    private DatosSubCta datosSubCta;
    @SerializedName("idProcesoJudicial")
    @Expose
    private String idProcesoJudicial;
    @SerializedName("idSubProcesoJudicial")
    @Expose
    private String idSubProcesoJudicial;
    @SerializedName("flgSaltaIntgy")
    @Expose
    private String flgSaltaIntgy;

    public String getFolio() {
        return folio;
    }

    public void setFolio(String folio) {
        this.folio = folio;
    }

    public String getFolioRelacionado() {
        return folioRelacionado;
    }

    public void setFolioRelacionado(String folioRelacionado) {
        this.folioRelacionado = folioRelacionado;
    }

    public String getIdProceso() {
        return idProceso;
    }

    public void setIdProceso(String idProceso) {
        this.idProceso = idProceso;
    }

    public String getIdSubProceso() {
        return idSubProceso;
    }

    public void setIdSubProceso(String idSubProceso) {
        this.idSubProceso = idSubProceso;
    }

    public String getNumCuentaIndividual() {
        return numCuentaIndividual;
    }

    public void setNumCuentaIndividual(String numCuentaIndividual) {
        this.numCuentaIndividual = numCuentaIndividual;
    }

    public String getIdSaldoOpera() {
        return idSaldoOpera;
    }

    public void setIdSaldoOpera(String idSaldoOpera) {
        this.idSaldoOpera = idSaldoOpera;
    }

    public String getTipoMovimiento() {
        return tipoMovimiento;
    }

    public void setTipoMovimiento(String tipoMovimiento) {
        this.tipoMovimiento = tipoMovimiento;
    }

    public String getIdSubEtapa() {
        return idSubEtapa;
    }

    public void setIdSubEtapa(String idSubEtapa) {
        this.idSubEtapa = idSubEtapa;
    }

    public String getUsuario() {
        return usuario;
    }

    public void setUsuario(String usuario) {
        this.usuario = usuario;
    }

    public DatosSubCta getDatosSubCta() {
        return datosSubCta;
    }

    public void setDatosSubCta(DatosSubCta datosSubCta) {
        this.datosSubCta = datosSubCta;
    }

    public String getIdProcesoJudicial() {
        return idProcesoJudicial;
    }

    public void setIdProcesoJudicial(String idProcesoJudicial) {
        this.idProcesoJudicial = idProcesoJudicial;
    }

    public String getIdSubProcesoJudicial() {
        return idSubProcesoJudicial;
    }

    public void setIdSubProcesoJudicial(String idSubProcesoJudicial) {
        this.idSubProcesoJudicial = idSubProcesoJudicial;
    }

    public String getFlgSaltaIntgy() {
        return flgSaltaIntgy;
    }

    public void setFlgSaltaIntgy(String flgSaltaIntgy) {
        this.flgSaltaIntgy = flgSaltaIntgy;
    }


    public static class DatosSubCta {

        @SerializedName("subCta")
        @Expose
        private List<SubCtum> subCta;

        public List<SubCtum> getSubCta() {
            return subCta;
        }

        public void setSubCta(List<SubCtum> subCta) {
            this.subCta = subCta;
        }

    }

    public static class SubCtum {

        @SerializedName("idSubCta")
        @Expose
        private String idSubCta;
        @SerializedName("idTipoMonto")
        @Expose
        private String idTipoMonto;
        @SerializedName("monto")
        @Expose
        private String monto;

        public String getIdSubCta() {
            return idSubCta;
        }

        public void setIdSubCta(String idSubCta) {
            this.idSubCta = idSubCta;
        }

        public String getIdTipoMonto() {
            return idTipoMonto;
        }

        public void setIdTipoMonto(String idTipoMonto) {
            this.idTipoMonto = idTipoMonto;
        }

        public String getMonto() {
            return monto;
        }

        public void setMonto(String monto) {
            this.monto = monto;
        }

    }
}