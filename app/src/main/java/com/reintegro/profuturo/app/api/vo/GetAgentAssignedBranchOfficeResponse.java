package com.reintegro.profuturo.app.api.vo;

import com.google.gson.annotations.SerializedName;

public class GetAgentAssignedBranchOfficeResponse {
    @SerializedName("nombreSucursal") private String branchOfficeName;
    @SerializedName("numeroSucursal") private Long branchOfficeNumber;
    @SerializedName("result") private Boolean success;
    @SerializedName("status") private Long status;
    @SerializedName("statusText") private String statusText;

    public String getBranchOfficeName() {
        return branchOfficeName;
    }

    public Long getBranchOfficeNumber() {
        return branchOfficeNumber;
    }

    public Boolean isSuccess() {
        return success;
    }

    public Long getStatus() {
        return status;
    }

    public String getStatusText() {
        return statusText;
    }
}

