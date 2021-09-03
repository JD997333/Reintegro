package com.reintegro.profuturo.app.api.vo;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

public class InsertClientResponse {
    @SerializedName("insertarClienteResponse")
    @Expose
    private InsertClient insertClientResponse;

    public InsertClient getInsertClientResponse() {
        return insertClientResponse;
    }

    public void setInsertClientResponse(InsertClient insertClientResponse) {
        this.insertClientResponse = insertClientResponse;
    }


    public static class InsertClient {

        @SerializedName("Success")
        @Expose
        private Boolean success;
        @SerializedName("Estatus")
        @Expose
        private Boolean status;
        @SerializedName("mensaje")
        @Expose
        private String message;

        public Boolean getSuccess() {
            return success;
        }

        public void setSuccess(Boolean success) {
            this.success = success;
        }

        public Boolean getStatus() {
            return status;
        }

        public void setStatus(Boolean status) {
            this.status = status;
        }

        public String getMessage() {
            return message;
        }

        public void setMessage(String message) {
            this.message = message;
        }

    }
}
