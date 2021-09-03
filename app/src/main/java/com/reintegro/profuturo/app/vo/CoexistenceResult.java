package com.reintegro.profuturo.app.vo;

public class CoexistenceResult {
    private boolean coexistenceSuccess;
    private String coexistenceMessage;

    public boolean isCoexistenceSuccess() {
        return coexistenceSuccess;
    }

    public void setCoexistenceSuccess(boolean coexistenceSuccess) {
        this.coexistenceSuccess = coexistenceSuccess;
    }

    public String getCoexistenceMessage() {
        return coexistenceMessage;
    }

    public void setCoexistenceMessage(String coexistenceMessage) {
        this.coexistenceMessage = coexistenceMessage;
    }
}
