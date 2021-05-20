package com.reintegro.profuturo.app.data.entity;

public class ClientEmailEntity {
    private String email;
    private String emailType;
    private String id;
    private boolean preferential;
    private boolean validEmail;

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getEmailType() {
        return emailType;
    }

    public void setEmailType(String emailType) {
        this.emailType = emailType;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public boolean isPreferential() {
        return preferential;
    }

    public void setPreferential(boolean preferential) {
        this.preferential = preferential;
    }

    public boolean isValidEmail() {
        return validEmail;
    }

    public void setValidEmail(boolean validEmail) {
        this.validEmail = validEmail;
    }
}
