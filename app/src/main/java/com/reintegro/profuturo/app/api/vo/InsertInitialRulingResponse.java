package com.reintegro.profuturo.app.api.vo;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

public class InsertInitialRulingResponse {
    @Expose
    @SerializedName("iniciarResponse")
    private StartResponse startResponse;

    public StartResponse getStartResponse() {
        return startResponse;
    }

    public void setStartResponse(StartResponse startResponse) {
        this.startResponse = startResponse;
    }

    public static class StartResponse{
        @Expose
        @SerializedName("success")
        private boolean success;
        @Expose
        @SerializedName("message")
        private String message;
        @Expose
        @SerializedName("idProcesoBPM")
        private String idBpm;

        public boolean isSuccess() {
            return success;
        }

        public void setSuccess(boolean success) {
            this.success = success;
        }

        public String getMessage() {
            return message;
        }

        public void setMessage(String message) {
            this.message = message;
        }

        public String getIdBpm() {
            return idBpm;
        }

        public void setIdBpm(String idBpm) {
            this.idBpm = idBpm;
        }
    }
}
