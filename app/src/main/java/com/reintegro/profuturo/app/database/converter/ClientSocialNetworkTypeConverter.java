package com.reintegro.profuturo.app.database.converter;

import com.reintegro.profuturo.app.data.entity.ClientSocialNetworkTypeEntity;
import com.reintegro.profuturo.app.database.model.ClientSocialNetworkTypeModel;

public class ClientSocialNetworkTypeConverter {
    public static ClientSocialNetworkTypeEntity convertFromModel(ClientSocialNetworkTypeModel clientSocialNetworkTypeModel) {
        ClientSocialNetworkTypeEntity clientSocialNetworkTypeEntity;
        clientSocialNetworkTypeEntity = new ClientSocialNetworkTypeEntity();
        clientSocialNetworkTypeEntity.setDescription(clientSocialNetworkTypeModel.getDescription());
        clientSocialNetworkTypeEntity.setId(clientSocialNetworkTypeModel.getId());
        clientSocialNetworkTypeEntity.setKey(clientSocialNetworkTypeModel.getKey());

        return clientSocialNetworkTypeEntity;
    }

    public static ClientSocialNetworkTypeModel convertFromEntity(ClientSocialNetworkTypeEntity clientSocialNetworkTypeEntity) {
        ClientSocialNetworkTypeModel clientSocialNetworkTypeModel;
        clientSocialNetworkTypeModel = new ClientSocialNetworkTypeModel();
        clientSocialNetworkTypeModel.setDescription(clientSocialNetworkTypeEntity.getDescription());
        clientSocialNetworkTypeModel.setKey(clientSocialNetworkTypeEntity.getKey());

        boolean hasId;
        hasId = clientSocialNetworkTypeEntity.getId() != null;

        if (hasId) {
            clientSocialNetworkTypeModel.setId(clientSocialNetworkTypeEntity.getId());
        }

        return clientSocialNetworkTypeModel;
    }
}