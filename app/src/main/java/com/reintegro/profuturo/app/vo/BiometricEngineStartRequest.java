package com.reintegro.profuturo.app.vo;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

import java.util.List;

public class BiometricEngineStartRequest {

    @SerializedName("enroledProfuturo")
    @Expose
    private Boolean enroledProfuturo;
    @SerializedName("dedos")
    @Expose
    private List<FingerEngine> fingerEngines;
    @SerializedName("forcedCapture")
    @Expose
    private Boolean forcedCapture;
    @SerializedName("manoIzquierda")
    @Expose
    private Boolean manoIzquierda;
    @SerializedName("manoDerecha")
    @Expose
    private Boolean manoDerecha;

    public Boolean getEnroledProfuturo() {
        return enroledProfuturo;
    }

    public void setEnroledProfuturo(Boolean enroledProfuturo) {
        this.enroledProfuturo = enroledProfuturo;
    }

    public List<FingerEngine> getFingerEngines() {
        return fingerEngines;
    }

    public void setFingerEngines(List<FingerEngine> fingerEngines) {
        this.fingerEngines = fingerEngines;
    }

    public Boolean getForcedCapture() {
        return forcedCapture;
    }

    public void setForcedCapture(Boolean forcedCapture) {
        this.forcedCapture = forcedCapture;
    }

    public Boolean getManoIzquierda() {
        return manoIzquierda;
    }

    public void setManoIzquierda(Boolean manoIzquierda) {
        this.manoIzquierda = manoIzquierda;
    }

    public Boolean getManoDerecha() {
        return manoDerecha;
    }

    public void setManoDerecha(Boolean manoDerecha) {
        this.manoDerecha = manoDerecha;
    }


    public static class FingerEngine {

        @SerializedName("code")
        @Expose
        private Integer code;
        @SerializedName("exception")
        @Expose
        private String exception;
        @SerializedName("id")
        @Expose
        private Integer id;
        @SerializedName("quality")
        @Expose
        private Integer quality;
        @SerializedName("suggested")
        @Expose
        private Boolean suggested;

        public Integer getCode() {
            return code;
        }

        public void setCode(Integer code) {
            this.code = code;
        }

        public String getException() {
            return exception;
        }

        public void setException(String exception) {
            this.exception = exception;
        }

        public Integer getId() {
            return id;
        }

        public void setId(Integer id) {
            this.id = id;
        }

        public Integer getQuality() {
            return quality;
        }

        public void setQuality(Integer quality) {
            this.quality = quality;
        }

        public Boolean getSuggested() {
            return suggested;
        }

        public void setSuggested(Boolean suggested) {
            this.suggested = suggested;
        }
    }
}
