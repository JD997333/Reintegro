package com.reintegro.profuturo.app.api.vo;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

import java.util.List;

public class GetRecommendedFingersResponse {
    @Expose
    @SerializedName("status")
    private int status;
    @Expose
    @SerializedName("result")
    private boolean result;
    @Expose
    @SerializedName("manoDerecha")
    private boolean rightHand;
    @Expose
    @SerializedName("manoIzquierda")
    private boolean leftHand;
    @Expose
    @SerializedName("enroladoProfuturo")
    private boolean enroladoProfuturo;
    @Expose
    @SerializedName("dedos")
    private List<Finger> fingers;

    public int getStatus() {
        return status;
    }

    public void setStatus(int status) {
        this.status = status;
    }

    public boolean isResult() {
        return result;
    }

    public void setResult(boolean result) {
        this.result = result;
    }

    public boolean isRightHand() {
        return rightHand;
    }

    public void setRightHand(boolean rightHand) {
        this.rightHand = rightHand;
    }

    public boolean isLeftHand() {
        return leftHand;
    }

    public void setLeftHand(boolean leftHand) {
        this.leftHand = leftHand;
    }

    public boolean isEnroladoProfuturo() {
        return enroladoProfuturo;
    }

    public void setEnroladoProfuturo(boolean enroladoProfuturo) {
        this.enroladoProfuturo = enroladoProfuturo;
    }

    public List<Finger> getFingers() {
        return fingers;
    }

    public void setFingers(List<Finger> fingers) {
        this.fingers = fingers;
    }

    public static class Finger{
        @Expose
        @SerializedName("id")
        private int id;
        @Expose
        @SerializedName("sugerido")
        private boolean suggested;
        @Expose
        @SerializedName("excepcion")
        private String exception;

        public int getId() {
            return id;
        }

        public void setId(int id) {
            this.id = id;
        }

        public boolean isSuggested() {
            return suggested;
        }

        public void setSuggested(boolean suggested) {
            this.suggested = suggested;
        }

        public String getException() {
            return exception;
        }

        public void setException(String exception) {
            this.exception = exception;
        }
    }
}
