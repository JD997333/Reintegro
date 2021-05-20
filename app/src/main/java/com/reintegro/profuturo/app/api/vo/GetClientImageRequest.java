package com.reintegro.profuturo.app.api.vo;

import com.google.gson.annotations.SerializedName;

public class GetClientImageRequest {
    @SerializedName("numCuenta") private Long accountNumber;

    public void setAccountNumber(Long accountNumber) {
        this.accountNumber = accountNumber;
    }
}

