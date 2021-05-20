package com.reintegro.profuturo.app.database.model;

import java.util.UUID;

import io.realm.RealmObject;
import io.realm.annotations.PrimaryKey;

public class AgentModel extends RealmObject {
    @PrimaryKey
    private String id = UUID.randomUUID().toString();

    private DateModel consarRegistrationDate;
    private String agentCode;
    private String branchOfficeName;
    private String curp;
    private String email;
    private String fatherLastName;
    private String fullName;
    private String motherLastName;
    private String name;
    private String userId;
    private long branchOfficeNumber;
    private long consarKey;
    private long costCenter;

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public DateModel getConsarRegistrationDate() {
        return consarRegistrationDate;
    }

    public void setConsarRegistrationDate(DateModel consarRegistrationDate) {
        this.consarRegistrationDate = consarRegistrationDate;
    }

    public String getAgentCode() {
        return agentCode;
    }

    public void setAgentCode(String agentCode) {
        this.agentCode = agentCode;
    }

    public String getBranchOfficeName() {
        return branchOfficeName;
    }

    public void setBranchOfficeName(String branchOfficeName) {
        this.branchOfficeName = branchOfficeName;
    }

    public String getCurp() {
        return curp;
    }

    public void setCurp(String curp) {
        this.curp = curp;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getFatherLastName() {
        return fatherLastName;
    }

    public void setFatherLastName(String fatherLastName) {
        this.fatherLastName = fatherLastName;
    }

    public String getFullName() {
        return fullName;
    }

    public void setFullName(String fullName) {
        this.fullName = fullName;
    }

    public String getMotherLastName() {
        return motherLastName;
    }

    public void setMotherLastName(String motherLastName) {
        this.motherLastName = motherLastName;
    }

    public String getName() {
        return name;
    }

    public String getUserId() {
        return userId;
    }

    public void setUserId(String userId) {
        this.userId = userId;
    }

    public void setName(String name) {
        this.name = name;
    }

    public long getBranchOfficeNumber() {
        return branchOfficeNumber;
    }

    public void setBranchOfficeNumber(long branchOfficeNumber) {
        this.branchOfficeNumber = branchOfficeNumber;
    }

    public long getConsarKey() {
        return consarKey;
    }

    public void setConsarKey(long consarKey) {
        this.consarKey = consarKey;
    }

    public long getCostCenter() {
        return costCenter;
    }

    public void setCostCenter(long costCenter) {
        this.costCenter = costCenter;
    }

}

