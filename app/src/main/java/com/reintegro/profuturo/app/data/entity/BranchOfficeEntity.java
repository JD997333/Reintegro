package com.reintegro.profuturo.app.data.entity;

public class BranchOfficeEntity {
    private DateEntity creationDate;
    private DateEntity updateDate;
    private String branchOfficeName;
    private String city;
    private String creationUser;
    private String federalEntity;
    private String id;
    private String neighborhood;
    private String state;
    private String street;
    private String town;
    private String updateUser;
    private double latitude;
    private double longitude;
    private long branchOfficeId;
    private long costCenterId;
    private long distance;

    public DateEntity getCreationDate() {
        return creationDate;
    }

    public void setCreationDate(DateEntity creationDate) {
        this.creationDate = creationDate;
    }

    public DateEntity getUpdateDate() {
        return updateDate;
    }

    public void setUpdateDate(DateEntity updateDate) {
        this.updateDate = updateDate;
    }

    public String getBranchOfficeName() {
        return branchOfficeName;
    }

    public void setBranchOfficeName(String branchOfficeName) {
        this.branchOfficeName = branchOfficeName;
    }

    public String getCity() {
        return city;
    }

    public void setCity(String city) {
        this.city = city;
    }

    public String getCreationUser() {
        return creationUser;
    }

    public void setCreationUser(String creationUser) {
        this.creationUser = creationUser;
    }

    public String getFederalEntity() {
        return federalEntity;
    }

    public void setFederalEntity(String federalEntity) {
        this.federalEntity = federalEntity;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getNeighborhood() {
        return neighborhood;
    }

    public void setNeighborhood(String neighborhood) {
        this.neighborhood = neighborhood;
    }

    public String getState() {
        return state;
    }

    public void setState(String state) {
        this.state = state;
    }

    public String getStreet() {
        return street;
    }

    public void setStreet(String street) {
        this.street = street;
    }

    public String getTown() {
        return town;
    }

    public void setTown(String town) {
        this.town = town;
    }

    public String getUpdateUser() {
        return updateUser;
    }

    public void setUpdateUser(String updateUser) {
        this.updateUser = updateUser;
    }

    public double getLatitude() {
        return latitude;
    }

    public void setLatitude(double latitude) {
        this.latitude = latitude;
    }

    public double getLongitude() {
        return longitude;
    }

    public void setLongitude(double longitude) {
        this.longitude = longitude;
    }

    public long getBranchOfficeId() {
        return branchOfficeId;
    }

    public void setBranchOfficeId(long branchOfficeId) {
        this.branchOfficeId = branchOfficeId;
    }

    public long getCostCenterId() {
        return costCenterId;
    }

    public void setCostCenterId(long costCenterId) {
        this.costCenterId = costCenterId;
    }

    public long getDistance() {
        return distance;
    }

    public void setDistance(long distance) {
        this.distance = distance;
    }
}
