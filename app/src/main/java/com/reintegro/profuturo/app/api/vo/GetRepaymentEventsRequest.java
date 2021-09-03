package com.reintegro.profuturo.app.api.vo;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

public class GetRepaymentEventsRequest {
    @Expose
    @SerializedName("consultarHistoricos")
    private RequestHistoric requestHistoric;

    public RequestHistoric getRequestHistoric() {
        return requestHistoric;
    }

    public void setRequestHistoric(RequestHistoric requestHistoric) {
        this.requestHistoric = requestHistoric;
    }

    public static class RequestHistoric {
        @Expose
        @SerializedName("nss")
        private String nss;
        @Expose
        @SerializedName("claveAfore")
        private String aforeKey;

        public String getNss() {
            return nss;
        }

        public void setNss(String nss) {
            this.nss = nss;
        }

        public String getAforeKey() {
            return aforeKey;
        }

        public void setAforeKey(String aforeKey) {
            this.aforeKey = aforeKey;
        }
    }
}
