package com.reintegro.profuturo.app.database.model;

import java.util.UUID;

import io.realm.RealmObject;
import io.realm.annotations.PrimaryKey;

public class ClientSocialNetworkModel extends RealmObject {
    @PrimaryKey
    private String id = UUID.randomUUID().toString();

    private ClientSocialNetworkTypeModel networkSocialType;
    private String value;
    private boolean preferential;

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public ClientSocialNetworkTypeModel getNetworkSocialType() {
        return networkSocialType;
    }

    public void setNetworkSocialType(ClientSocialNetworkTypeModel networkSocialType) {
        this.networkSocialType = networkSocialType;
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