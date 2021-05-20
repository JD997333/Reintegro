package com.reintegro.profuturo.app.api.vo;

import com.google.gson.annotations.SerializedName;

public class SaveLoginResponse {
    @SerializedName("success") private Boolean success;

    public Boolean isSuccess() {
        return success;
    }
}
