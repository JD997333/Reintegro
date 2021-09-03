package com.reintegro.profuturo.app.api.vo;

import com.google.gson.annotations.SerializedName;

public class SaveInitialCaptureResponse {
    @SerializedName("capturaInicialResponse")
    InitialCaptureResponse initialCaptureResponse;

    public InitialCaptureResponse getInitialCaptureResponse() {
        return initialCaptureResponse;
    }

    public void setInitialCaptureResponse(InitialCaptureResponse initialCaptureResponse) {
        this.initialCaptureResponse = initialCaptureResponse;
    }

    public static class InitialCaptureResponse{
        @SerializedName("operacionExitosa")
        ResponseSuccessful responseSuccessful;
        @SerializedName("folioTramite")
        String folioTramite;
        @SerializedName("folioBitacoraProceso")
        String folioBitacoraProceso;

        public ResponseSuccessful getResponseSuccessful() {
            return responseSuccessful;
        }

        public void setResponseSuccessful(ResponseSuccessful responseSuccessful) {
            this.responseSuccessful = responseSuccessful;
        }

        public String getFolioTramite() {
            return folioTramite;
        }

        public void setFolioTramite(String folioTramite) {
            this.folioTramite = folioTramite;
        }

        public String getFolioBitacoraProceso() {
            return folioBitacoraProceso;
        }

        public void setFolioBitacoraProceso(String folioBitacoraProceso) {
            this.folioBitacoraProceso = folioBitacoraProceso;
        }
    }

    public static class ResponseSuccessful{
        @SerializedName("success")
        String success;
        @SerializedName("response")
        String response;

        public String getSuccess() {
            return success;
        }

        public void setSuccess(String success) {
            this.success = success;
        }

        public String getResponse() {
            return response;
        }

        public void setResponse(String response) {
            this.response = response;
        }
    }
}
