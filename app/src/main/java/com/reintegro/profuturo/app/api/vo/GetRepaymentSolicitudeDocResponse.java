package com.reintegro.profuturo.app.api.vo;


import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

public class GetRepaymentSolicitudeDocResponse {
    @SerializedName("status")
    @Expose
    private String status;
    @SerializedName("statusText")
    @Expose
    private String statusText;
    @SerializedName("pdf")
    @Expose
    private String pdf;

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    public String getStatusText() {
        return statusText;
    }

    public void setStatusText(String statusText) {
        this.statusText = statusText;
    }

    public String getPdf() {
        return pdf;
    }

    public void setPdf(String pdf) {
        this.pdf = pdf;
    }
}