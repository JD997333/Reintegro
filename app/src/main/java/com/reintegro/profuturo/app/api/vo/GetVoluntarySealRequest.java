package com.reintegro.profuturo.app.api.vo;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

import java.util.List;

public class GetVoluntarySealRequest {
    @Expose
    @SerializedName("rqt")
    private SealRequest sealRequest;

    public SealRequest getSealRequest() {
        return sealRequest;
    }

    public void setSealRequest(SealRequest sealRequest) {
        this.sealRequest = sealRequest;
    }

    public static class SealRequest {
        @SerializedName("infoGeneraNist")
        @Expose
        private SealInformation sealInformation;
        @SerializedName("infoTramite")
        @Expose
        private ProcedureInformation procedureInformation;

        public SealInformation getSealInformation() {
            return sealInformation;
        }

        public void setSealInformation(SealInformation sealInformation) {
            this.sealInformation = sealInformation;
        }

        public ProcedureInformation getProcedureInformation() {
            return procedureInformation;
        }

        public void setProcedureInformation(ProcedureInformation procedureInformation) {
            this.procedureInformation = procedureInformation;
        }
    }

    public static class ProcedureInformation {

        @SerializedName("idTipoSello")
        @Expose
        private String idTipoSello;
        @SerializedName("idTramite")
        @Expose
        private String idTramite;
        @SerializedName("indicadorSelloNuevo")
        @Expose
        private Boolean indicadorSelloNuevo;
        @SerializedName("numeroEmpleado")
        @Expose
        private String numeroEmpleado;

        public String getIdTipoSello() {
            return idTipoSello;
        }

        public void setIdTipoSello(String idTipoSello) {
            this.idTipoSello = idTipoSello;
        }

        public String getIdTramite() {
            return idTramite;
        }

        public void setIdTramite(String idTramite) {
            this.idTramite = idTramite;
        }

        public Boolean getIndicadorSelloNuevo() {
            return indicadorSelloNuevo;
        }

        public void setIndicadorSelloNuevo(Boolean indicadorSelloNuevo) {
            this.indicadorSelloNuevo = indicadorSelloNuevo;
        }

        public String getNumeroEmpleado() {
            return numeroEmpleado;
        }

        public void setNumeroEmpleado(String numeroEmpleado) {
            this.numeroEmpleado = numeroEmpleado;
        }
    }

    public static class SealInformation {

        @SerializedName("canalServicio")
        @Expose
        private String canalServicio;
        @SerializedName("curpEmpleado")
        @Expose
        private String curpEmpleado;
        @SerializedName("curpSolicitante")
        @Expose
        private String curpSolicitante;
        @SerializedName("curpTrabajador")
        @Expose
        private String curpTrabajador;
        @SerializedName("datosAdicionales1")
        @Expose
        private String datosAdicionales1;
        @SerializedName("datosAdicionales2")
        @Expose
        private String datosAdicionales2;
        @SerializedName("dispositivo")
        @Expose
        private Device device;
        @SerializedName("fechaSolicitud")
        @Expose
        private String fechaSolicitud;
        @SerializedName("folioSolicitud")
        @Expose
        private String folioSolicitud;
        @SerializedName("huellasEmpleado")
        @Expose
        private List<FingerPrint> agentFingerPrintList;
        @SerializedName("huellasTrabajador")
        @Expose
        private List<FingerPrint> clientFingerPrintList;
        @SerializedName("numeroOficina")
        @Expose
        private String numeroOficina;
        @SerializedName("serviceId")
        @Expose
        private String serviceId;
        @SerializedName("tipoSolicitante")
        @Expose
        private String tipoSolicitante;
        @SerializedName("tokenMovil")
        @Expose
        private String tokenMovil;
        @SerializedName("transactionDate")
        @Expose
        private String transactionDate;

        public String getCanalServicio() {
            return canalServicio;
        }

        public void setCanalServicio(String canalServicio) {
            this.canalServicio = canalServicio;
        }

        public String getCurpEmpleado() {
            return curpEmpleado;
        }

        public void setCurpEmpleado(String curpEmpleado) {
            this.curpEmpleado = curpEmpleado;
        }

        public String getCurpSolicitante() {
            return curpSolicitante;
        }

        public void setCurpSolicitante(String curpSolicitante) {
            this.curpSolicitante = curpSolicitante;
        }

        public String getCurpTrabajador() {
            return curpTrabajador;
        }

        public void setCurpTrabajador(String curpTrabajador) {
            this.curpTrabajador = curpTrabajador;
        }

        public String getDatosAdicionales1() {
            return datosAdicionales1;
        }

        public void setDatosAdicionales1(String datosAdicionales1) {
            this.datosAdicionales1 = datosAdicionales1;
        }

        public String getDatosAdicionales2() {
            return datosAdicionales2;
        }

        public void setDatosAdicionales2(String datosAdicionales2) {
            this.datosAdicionales2 = datosAdicionales2;
        }

        public Device getDevice() {
            return device;
        }

        public void setDevice(Device device) {
            this.device = device;
        }

        public String getFechaSolicitud() {
            return fechaSolicitud;
        }

        public void setFechaSolicitud(String fechaSolicitud) {
            this.fechaSolicitud = fechaSolicitud;
        }

        public String getFolioSolicitud() {
            return folioSolicitud;
        }

        public void setFolioSolicitud(String folioSolicitud) {
            this.folioSolicitud = folioSolicitud;
        }

        public List<FingerPrint> getAgentFingerPrintList() {
            return agentFingerPrintList;
        }

        public void setAgentFingerPrintList(List<FingerPrint> agentFingerPrintList) {
            this.agentFingerPrintList = agentFingerPrintList;
        }

        public List<FingerPrint> getClientFingerPrintList() {
            return clientFingerPrintList;
        }

        public void setClientFingerPrintList(List<FingerPrint> clientFingerPrintList) {
            this.clientFingerPrintList = clientFingerPrintList;
        }

        public String getNumeroOficina() {
            return numeroOficina;
        }

        public void setNumeroOficina(String numeroOficina) {
            this.numeroOficina = numeroOficina;
        }

        public String getServiceId() {
            return serviceId;
        }

        public void setServiceId(String serviceId) {
            this.serviceId = serviceId;
        }

        public String getTipoSolicitante() {
            return tipoSolicitante;
        }

        public void setTipoSolicitante(String tipoSolicitante) {
            this.tipoSolicitante = tipoSolicitante;
        }

        public String getTokenMovil() {
            return tokenMovil;
        }

        public void setTokenMovil(String tokenMovil) {
            this.tokenMovil = tokenMovil;
        }

        public String getTransactionDate() {
            return transactionDate;
        }

        public void setTransactionDate(String transactionDate) {
            this.transactionDate = transactionDate;
        }
    }

    public static class FingerPrint {

        @SerializedName("motivoSinHuella")
        @Expose
        private String motivoSinHuella;
        @SerializedName("base64data")
        @Expose
        private String base64data;
        @SerializedName("fechaCaptura")
        @Expose
        private String fechaCaptura;
        @SerializedName("fingerPositionCode")
        @Expose
        private String fingerPositionCode;
        @SerializedName("imageHashValue")
        @Expose
        private String imageHashValue;
        @SerializedName("nistQualityMeasure")
        @Expose
        private String nistQualityMeasure;

        public String getMotivoSinHuella() {
            return motivoSinHuella;
        }

        public void setMotivoSinHuella(String motivoSinHuella) {
            this.motivoSinHuella = motivoSinHuella;
        }

        public String getBase64data() {
            return base64data;
        }

        public void setBase64data(String base64data) {
            this.base64data = base64data;
        }

        public String getFechaCaptura() {
            return fechaCaptura;
        }

        public void setFechaCaptura(String fechaCaptura) {
            this.fechaCaptura = fechaCaptura;
        }

        public String getFingerPositionCode() {
            return fingerPositionCode;
        }

        public void setFingerPositionCode(String fingerPositionCode) {
            this.fingerPositionCode = fingerPositionCode;
        }

        public String getImageHashValue() {
            return imageHashValue;
        }

        public void setImageHashValue(String imageHashValue) {
            this.imageHashValue = imageHashValue;
        }

        public String getNistQualityMeasure() {
            return nistQualityMeasure;
        }

        public void setNistQualityMeasure(String nistQualityMeasure) {
            this.nistQualityMeasure = nistQualityMeasure;
        }
    }


    public static class Device {

        @SerializedName("acquisitionProfileCode")
        @Expose
        private String acquisitionProfileCode;
        @SerializedName("captureResolution")
        @Expose
        private String captureResolution;
        @SerializedName("deviceIdentificationId")
        @Expose
        private String deviceIdentificationId;
        @SerializedName("imageScaleUnitsCode")
        @Expose
        private String imageScaleUnitsCode;

        public String getAcquisitionProfileCode() {
            return acquisitionProfileCode;
        }

        public void setAcquisitionProfileCode(String acquisitionProfileCode) {
            this.acquisitionProfileCode = acquisitionProfileCode;
        }

        public String getCaptureResolution() {
            return captureResolution;
        }

        public void setCaptureResolution(String captureResolution) {
            this.captureResolution = captureResolution;
        }

        public String getDeviceIdentificationId() {
            return deviceIdentificationId;
        }

        public void setDeviceIdentificationId(String deviceIdentificationId) {
            this.deviceIdentificationId = deviceIdentificationId;
        }

        public String getImageScaleUnitsCode() {
            return imageScaleUnitsCode;
        }

        public void setImageScaleUnitsCode(String imageScaleUnitsCode) {
            this.imageScaleUnitsCode = imageScaleUnitsCode;
        }
    }
}
