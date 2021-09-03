package com.reintegro.profuturo.app.vo;

public class ApplicantType {
    private String id;
    private String description;

    public ApplicantType(String id, String description) {
        this.id = id;
        this.description = description;
    }

    public ApplicantType() {
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }
}
