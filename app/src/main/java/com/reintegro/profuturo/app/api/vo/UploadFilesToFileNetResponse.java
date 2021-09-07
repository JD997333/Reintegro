package com.reintegro.profuturo.app.api.vo;

import com.google.gson.annotations.SerializedName;

public class UploadFilesToFileNetResponse {
    public static class Response {
        @SerializedName("success") private Boolean success;
        @SerializedName("mensaje") private String message;

        public Boolean getSuccess() {
            return success;
        }

        public String getMessage() {
            return message;
        }
    }

    @SerializedName("result")
    private boolean result;
    @SerializedName("cargarImagenResponse")
    private Response response;

    public Response getResponse() {
        return response;
    }

    public boolean isResult() {
        return result;
    }
}
