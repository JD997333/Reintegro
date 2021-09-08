package com.reintegro.profuturo.app.api.vo;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

public class UpdatePaperworkResponse {

    @SerializedName("actualizarTramiteResponse")
    @Expose
    private ActualizarTramiteResponse actualizarTramiteResponse;

    public ActualizarTramiteResponse getActualizarTramiteResponse() {
        return actualizarTramiteResponse;
    }

    public void setActualizarTramiteResponse(ActualizarTramiteResponse actualizarTramiteResponse) {
        this.actualizarTramiteResponse = actualizarTramiteResponse;
    }


    public static class ActualizarTramiteResponse {

        @SerializedName("success")
        @Expose
        private String success;
        @SerializedName("message")
        @Expose
        private String message;

        public String getSuccess() {
            return success;
        }

        public void setSuccess(String success) {
            this.success = success;
        }

        public String getMessage() {
            return message;
        }

        public void setMessage(String message) {
            this.message = message;
        }
    }


}
