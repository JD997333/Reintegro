package com.reintegro.profuturo.app.domain.dto;

public class ClientSocialNetworkDto {
    private ClientSocialNetworkTypeDto networkSocialType;
    private String id;
    private String value;
    private boolean preferential;

    public ClientSocialNetworkTypeDto getNetworkSocialType() {
        return networkSocialType;
    }

    public void setNetworkSocialType(ClientSocialNetworkTypeDto networkSocialType) {
        this.networkSocialType = networkSocialType;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getValue() {
        return value;
    }

    public void setValue(String value) {
        this.value = value;
    }

    public boolean isPreferential() {
        return preferential;
    }

    public void setPreferential(boolean preferential) {
        this.preferential = preferential;
    }
}