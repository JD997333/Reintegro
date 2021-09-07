package com.reintegro.profuturo.app.api.vo;


import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

public class MarkNciCoexistenceResponse {
    @Expose
    @SerializedName("marcaCuentaResponse")
    private MarkResponse markResponse;

    public MarkResponse getMarkResponse() {
        return markResponse;
    }

    public void setMarkResponse(MarkResponse markResponse) {
        this.markResponse = markResponse;
    }

    public static class MarkResponse{
        @Expose
        @SerializedName("success")
        private boolean success;
        @Expose
        @SerializedName("convive")
        private boolean coexistence;
        @Expose
        @SerializedName("mensaje")
        private String message;

        public boolean isSuccess() {
            return success;
        }

        public void setSuccess(boolean success) {
            this.success = success;
        }

        public boolean isCoexistence() {
            return coexistence;
        }

        public void setCoexistence(boolean coexistence) {
            this.coexistence = coexistence;
        }

        public String getMessage() {
            return message;
        }

        public void setMessage(String message) {
            this.message = message;
        }
    }

}