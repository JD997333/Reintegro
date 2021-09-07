package com.reintegro.profuturo.app.api.vo;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

public class UpdatePaperworkRequest {
    @SerializedName("actualizarTramite")
    @Expose
    private ActualizarTramite actualizarTramite;

    public ActualizarTramite getActualizarTramite() {
        return actualizarTramite;
    }

    public void setActualizarTramite(ActualizarTramite actualizarTramite) {
        this.actualizarTramite = actualizarTramite;
    }

    public static class ActualizarTramite {

        @SerializedName("folio")
        @Expose
        private String folio;
        @SerializedName("folioTramite")
        @Expose
        private String folioTramite;
        @SerializedName("fechTramite")
        @Expose
        private String fechTramite;
        @SerializedName("idTipoTramite")
        @Expose
        private String idTipoTramite;
        @SerializedName("idEstatusTramite")
        @Expose
        private String idEstatusTramite;
        @SerializedName("numCuenta")
        @Expose
        private String numCuenta;
        @SerializedName("curp")
        @Expose
        private String curp;
        @SerializedName("nss")
        @Expose
        private String nss;
        @SerializedName("idTipoSolicitante")
        @Expose
        private String idTipoSolicitante;
        @SerializedName("curpSol")
        @Expose
        private String curpSol;
        @SerializedName("folioAutentificacion")
        @Expose
        private String folioAutentificacion;
        @SerializedName("idValImporte")
        @Expose
        private String idValImporte;
        @SerializedName("fechEstatus")
        @Expose
        private String fechEstatus;
        @SerializedName("idMotivoRechazo")
        @Expose
        private String idMotivoRechazo;
        @SerializedName("montoSemana")
        @Expose
        private String montoSemana;
        @SerializedName("semMaxReitegrar")
        @Expose
        private String semMaxReitegrar;
        @SerializedName("semSolReintegrar")
        @Expose
        private String semSolReintegrar;
        @SerializedName("semPrevReintegrados")
        @Expose
        private String semPrevReintegrados;
        @SerializedName("fechSolTRD")
        @Expose
        private String fechSolTRD;
        @SerializedName("montoPagDRT")
        @Expose
        private String montoPagDRT;
        @SerializedName("montoReintegrar")
        @Expose
        private String montoReintegrar;
        @SerializedName("idSucAsignada")
        @Expose
        private String idSucAsignada;
        @SerializedName("curpagenteServ")
        @Expose
        private String curpagenteServ;
        @SerializedName("numAsesor")
        @Expose
        private String numAsesor;
        @SerializedName("numAsesorConsar")
        @Expose
        private String numAsesorConsar;
        @SerializedName("canal")
        @Expose
        private String canal;
        @SerializedName("selloVol")
        @Expose
        private String selloVol;
        @SerializedName("idEstatusSello")
        @Expose
        private String idEstatusSello;
        @SerializedName("usuAct")
        @Expose
        private String usuAct;
        @SerializedName("fehAct")
        @Expose
        private String fehAct;

        public String getFolio() {
            return folio;
        }

        public void setFolio(String folio) {
            this.folio = folio;
        }

        public String getFolioTramite() {
            return folioTramite;
        }

        public void setFolioTramite(String folioTramite) {
            this.folioTramite = folioTramite;
        }

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

        public String getCurpagenteServ() {
            return curpagenteServ;
        }

        public void setCurpagenteServ(String curpagenteServ) {
            this.curpagenteServ = curpagenteServ;
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

        public String getUsuAct() {
            return usuAct;
        }

        public void setUsuAct(String usuAct) {
            this.usuAct = usuAct;
        }

        public String getFehAct() {
            return fehAct;
        }

        public void setFehAct(String fehAct) {
            this.fehAct = fehAct;
        }

    }
}