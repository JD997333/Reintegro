package com.reintegro.profuturo.app.api.vo;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

public class GetRecommendedFingersRequest {
    @Expose
    @SerializedName("rqt")
    private Req req;

    public Req getReq() {
        return req;
    }

    public void setReq(Req req) {
        this.req = req;
    }


    public static class Req{
        @Expose
        @SerializedName("curp")
        private String curp;

        public String getCurp() {
            return curp;
        }

        public void setCurp(String curp) {
            this.curp = curp;
        }
    }
}
