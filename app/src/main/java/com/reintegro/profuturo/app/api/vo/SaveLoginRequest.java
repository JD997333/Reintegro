package com.reintegro.profuturo.app.api.vo;

import com.google.gson.annotations.SerializedName;

public class SaveLoginRequest {
    @SerializedName("apMaterno") private String motherLastName;
    @SerializedName("apPaterno") private String fatherLastName;
    @SerializedName("correoAsesor") private String email;
    @SerializedName("curp") private String curp;
    @SerializedName("fehAcceso") private String accessDate;
    @SerializedName("idSucAsignada") private String assignedBranchOfficeId;
    @SerializedName("nombre") private String name;
    @SerializedName("nomSuc") private String branchOfficeName;
    @SerializedName("numAsesor") private String agentNumber;
    @SerializedName("numAsesorConsar") private String consarAgentNumber;
    @SerializedName("usuCre") private String creationUser;

    public void setMotherLastName(String motherLastName) {
        this.motherLastName = motherLastName;
    }

    public void setFatherLastName(String fatherLastName) {
        this.fatherLastName = fatherLastName;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public void setCurp(String curp) {
        this.curp = curp;
    }

    public void setAccessDate(String accessDate) {
        this.accessDate = accessDate;
    }

    public void setAssignedBranchOfficeId(String assignedBranchOfficeId) {
        this.assignedBranchOfficeId = assignedBranchOfficeId;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void setBranchOfficeName(String branchOfficeName) {
        this.branchOfficeName = branchOfficeName;
    }

    public void setAgentNumber(String agentNumber) {
        this.agentNumber = agentNumber;
    }

    public void setConsarAgentNumber(String consarAgentNumber) {
        this.consarAgentNumber = consarAgentNumber;
    }

    public void setCreationUser(String creationUser) {
        this.creationUser = creationUser;
    }
}

