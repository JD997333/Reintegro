package com.reintegro.profuturo.app.api.vo;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

public class SaveInitialCaptureRequest {

    @Expose
    @SerializedName("capturaInicial")
    InitialCapture initialCapture;

    public InitialCapture getInitialCapture() {
        return initialCapture;
    }

    public void setInitialCapture(InitialCapture initialCapture) {
        this.initialCapture = initialCapture;
    }

    public static class InitialCapture{
        @Expose
        @SerializedName("fechTramite")
        String fechTramite;
        @Expose
        @SerializedName("idTipoTramite")
        String idTipoTramite;
        @Expose
        @SerializedName("idEstatusTramite")
        String idEstatusTramite;
        @Expose
        @SerializedName("numCuenta")
        String numCuenta;
        @Expose
        @SerializedName("curp")
        String curp;
        @Expose
        @SerializedName("nss")
        String nss;
        @Expose
        @SerializedName("idTipoSolicitante")
        String idTipoSolicitante;
        @Expose
        @SerializedName("curpSol")
        String curpSol;
        @Expose
        @SerializedName("folioAutentificacion")
        String folioAutentificacion;
        @Expose
        @SerializedName("idValImporte")
        String idValImporte;
        @Expose
        @SerializedName("fechEstatus")
        String fechEstatus;
        @Expose
        @SerializedName("idMotivoRechazo")
        String idMotivoRechazo;
        @Expose
        @SerializedName("montoSemana")
        String montoSemana;
        @Expose
        @SerializedName("semMaxReitegrar")
        String semMaxReitegrar;
        @Expose
        @SerializedName("semSolReintegrar")
        String semSolReintegrar;
        @Expose
        @SerializedName("semPrevReintegrados")
        String semPrevReintegrados;
        @Expose
        @SerializedName("fechSolTRD")
        String fechSolTRD;
        @Expose
        @SerializedName("montoPagDRT")
        String montoPagDRT;
        @Expose
        @SerializedName("montoReintegrar")
        String montoReintegrar;
        @Expose
        @SerializedName("idSucAsignada")
        String idSucAsignada;
        @Expose
        @SerializedName("curpAgenteServ")
        String curpAgenteServ;
        @Expose
        @SerializedName("numAsesor")
        String numAsesor;
        @Expose
        @SerializedName("numAsesorConsar")
        String numAsesorConsar;
        @Expose
        @SerializedName("canal")
        String canal;
        @Expose
        @SerializedName("selloVol")
        String selloVol;
        @Expose
        @SerializedName("idEstatusSello")
        String idEstatusSello;
        @Expose
        @SerializedName("usuCre")
        String usuCre;
        @Expose
        @SerializedName("idEstatus")
        Integer idEstatus;
        @Expose
        @SerializedName("idEstatusProceso")
        Integer idEstatusProceso;
        @Expose
        @SerializedName("idResultado")
        Integer idResultado;
        @Expose
        @SerializedName("idEtapa")
        Integer idEtapa;
        @Expose
        @SerializedName("idSubEtapa")
        Integer idSubEtapa;
        @Expose
        @SerializedName("idProceso")
        Integer idProceso;
        @Expose
        @SerializedName("idCanal")
        Integer idCanal;
        @Expose
        @SerializedName("idSubProceso")
        Integer idSubProceso;
        @Expose
        @SerializedName("numeroResolucion")
        String resolutionNumber;
        @Expose
        @SerializedName("fechaRetiro")
        String withdrawalDate;
        @Expose
        @SerializedName("semanasCalculadasReintegrar")
        String weeksRepaymentCalc;
        @Expose
        @SerializedName("montoRealCalculadoReintegrar")
        String amountRepaymentCalc;
        @Expose
        @SerializedName("montoAcrediatrApovol")
        String amountApovol;

        public String getFechTramite() {
            return fechTramite;
        }

        public void setFechTramite(String fechTramite) {
            this.fechTramite = fechTramite;
        }

        public String getIdTipoTramite() {
            return idTipoTramite;
        }

        public void setIdTipoTramite(String idTipoTramite) {
            this.idTipoTramite = idTipoTramite;
        }

        public String getIdEstatusTramite() {
            return idEstatusTramite;
        }

        public void setIdEstatusTramite(String idEstatusTramite) {
            this.idEstatusTramite = idEstatusTramite;
        }

        public String getNumCuenta() {
            return numCuenta;
        }

        public void setNumCuenta(String numCuenta) {
            this.numCuenta = numCuenta;
        }

        public String getCurp() {
            return curp;
        }

        public void setCurp(String curp) {
            this.curp = curp;
        }

        public String getNss() {
            return nss;
        }

        public void setNss(String nss) {
            this.nss = nss;
        }

        public String getIdTipoSolicitante() {
            return idTipoSolicitante;
        }

        public void setIdTipoSolicitante(String idTipoSolicitante) {
            this.idTipoSolicitante = idTipoSolicitante;
        }

        public String getCurpSol() {
            return curpSol;
        }

        public void setCurpSol(String curpSol) {
            this.curpSol = curpSol;
        }

        public String getFolioAutentificacion() {
            return folioAutentificacion;
        }

        public void setFolioAutentificacion(String folioAutentificacion) {
            this.folioAutentificacion = folioAutentificacion;
        }

        public String getIdValImporte() {
            return idValImporte;
        }

        public void setIdValImporte(String idValImporte) {
            this.idValImporte = idValImporte;
        }

        public String getFechEstatus() {
            return fechEstatus;
        }

        public void setFechEstatus(String fechEstatus) {
            this.fechEstatus = fechEstatus;
        }

        public String getIdMotivoRechazo() {
            return idMotivoRechazo;
        }

        public void setIdMotivoRechazo(String idMotivoRechazo) {
            this.idMotivoRechazo = idMotivoRechazo;
        }

        public String getMontoSemana() {
            return montoSemana;
        }

        public void setMontoSemana(String montoSemana) {
            this.montoSemana = montoSemana;
        }

        public String getSemMaxReitegrar() {
            return semMaxReitegrar;
        }

        public void setSemMaxReitegrar(String semMaxReitegrar) {
            this.semMaxReitegrar = semMaxReitegrar;
        }

        public String getSemSolReintegrar() {
            return semSolReintegrar;
        }

        public void setSemSolReintegrar(String semSolReintegrar) {
            this.semSolReintegrar = semSolReintegrar;
        }

        public String getSemPrevReintegrados() {
            return semPrevReintegrados;
        }

        public void setSemPrevReintegrados(String semPrevReintegrados) {
            this.semPrevReintegrados = semPrevReintegrados;
        }

        public String getFechSolTRD() {
            return fechSolTRD;
        }

        public void setFechSolTRD(String fechSolTRD) {
            this.fechSolTRD = fechSolTRD;
        }

        public String getMontoPagDRT() {
            return montoPagDRT;
        }

        public void setMontoPagDRT(String montoPagDRT) {
            this.montoPagDRT = montoPagDRT;
        }

        public String getMontoReintegrar() {
            return montoReintegrar;
        }

        public void setMontoReintegrar(String montoReintegrar) {
            this.montoReintegrar = montoReintegrar;
        }

        public String getIdSucAsignada() {
            return idSucAsignada;
        }

        public void setIdSucAsignada(String idSucAsignada) {
            this.idSucAsignada = idSucAsignada;
        }

        public String getCurpAgenteServ() {
            return curpAgenteServ;
        }

        public void setCurpAgenteServ(String curpAgenteServ) {
            this.curpAgenteServ = curpAgenteServ;
        }

        public String getNumAsesor() {
            return numAsesor;
        }

        public void setNumAsesor(String numAsesor) {
            this.numAsesor = numAsesor;
        }

        public String getNumAsesorConsar() {
            return numAsesorConsar;
        }

        public void setNumAsesorConsar(String numAsesorConsar) {
            this.numAsesorConsar = numAsesorConsar;
        }

        public String getCanal() {
            return canal;
        }

        public void setCanal(String canal) {
            this.canal = canal;
        }

        public String getSelloVol() {
            return selloVol;
        }

        public void setSelloVol(String selloVol) {
            this.selloVol = selloVol;
        }

        public String getIdEstatusSello() {
            return idEstatusSello;
        }

        public void setIdEstatusSello(String idEstatusSello) {
            this.idEstatusSello = idEstatusSello;
        }

        public String getUsuCre() {
            return usuCre;
        }

        public void setUsuCre(String usuCre) {
            this.usuCre = usuCre;
        }

        public Integer getIdEstatus() {
            return idEstatus;
        }

        public void setIdEstatus(Integer idEstatus) {
            this.idEstatus = idEstatus;
        }

        public Integer getIdEstatusProceso() {
            return idEstatusProceso;
        }

        public void setIdEstatusProceso(Integer idEstatusProceso) {
            this.idEstatusProceso = idEstatusProceso;
        }

        public Integer getIdResultado() {
            return idResultado;
        }

        public void setIdResultado(Integer idResultado) {
            this.idResultado = idResultado;
        }

        public Integer getIdEtapa() {
            return idEtapa;
        }

        public void setIdEtapa(Integer idEtapa) {
            this.idEtapa = idEtapa;
        }

        public Integer getIdSubEtapa() {
            return idSubEtapa;
        }

        public void setIdSubEtapa(Integer idSubEtapa) {
            this.idSubEtapa = idSubEtapa;
        }

        public Integer getIdProceso() {
            return idProceso;
        }

        public void setIdProceso(Integer idProceso) {
            this.idProceso = idProceso;
        }

        public Integer getIdCanal() {
            return idCanal;
        }

        public void setIdCanal(Integer idCanal) {
            this.idCanal = idCanal;
        }

        public Integer getIdSubProceso() {
            return idSubProceso;
        }

        public void setIdSubProceso(Integer idSubProceso) {
            this.idSubProceso = idSubProceso;
        }

        public String getResolutionNumber() {
            return resolutionNumber;
        }

        public void setResolutionNumber(String resolutionNumber) {
            this.resolutionNumber = resolutionNumber;
        }

        public String getWithdrawalDate() {
            return withdrawalDate;
        }

        public void setWithdrawalDate(String withdrawalDate) {
            this.withdrawalDate = withdrawalDate;
        }

        public String getWeeksRepaymentCalc() {
            return weeksRepaymentCalc;
        }

        public void setWeeksRepaymentCalc(String weeksRepaymentCalc) {
            this.weeksRepaymentCalc = weeksRepaymentCalc;
        }

        public String getAmountRepaymentCalc() {
            return amountRepaymentCalc;
        }

        public void setAmountRepaymentCalc(String amountRepaymentCalc) {
            this.amountRepaymentCalc = amountRepaymentCalc;
        }

        public String getAmountApovol() {
            return amountApovol;
        }

        public void setAmountApovol(String amountApovol) {
            this.amountApovol = amountApovol;
        }
    }
}
