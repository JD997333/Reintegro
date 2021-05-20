package com.reintegro.profuturo.app.database.converter;

import com.reintegro.profuturo.app.data.entity.ClientSocialNetworkEntity;
import com.reintegro.profuturo.app.database.model.ClientSocialNetworkModel;

import java.util.ArrayList;
import java.util.List;

import io.realm.RealmList;

public class ClientSocialNetworkConverter {
    public static List<ClientSocialNetworkEntity> convertFromModels(List<ClientSocialNetworkModel> clientSocialNetworkModels) {
        List<ClientSocialNetworkEntity> clientSocialNetworkEntities;
        clientSocialNetworkEntities = new ArrayList<>();

        for (ClientSocialNetworkModel clientSocialNetworkModel : clientSocialNetworkModels) {
            ClientSocialNetworkEntity clientSocialNetworkEntity;
            clientSocialNetworkEntity = new ClientSocialNetworkEntity();
            clientSocialNetworkEntity.setId(clientSocialNetworkModel.getId());
            clientSocialNetworkEntity.setNetworkSocialType(ClientSocialNetworkTypeConverter.convertFromModel(clientSocialNetworkModel.getNetworkSocialType()));
            clientSocialNetworkEntity.setPreferential(clientSocialNetworkModel.isPreferential());
            clientSocialNetworkEntity.setValue(clientSocialNetworkModel.getValue());

            clientSocialNetworkEntities.add(clientSocialNetworkEntity);
        }

        return clientSocialNetworkEntities;
    }

    public static RealmList<ClientSocialNetworkModel> converterFromEntities(List<ClientSocialNetworkEntity> clientSocialNetworkEntities) {
        RealmList<ClientSocialNetworkModel> clientSocialNetworkModels;
        clientSocialNetworkModels = new RealmList<>();

        for (ClientSocialNetworkEntity entity : clientSocialNetworkEntities) {
            ClientSocialNetworkModel clientSocialNetworkModel;
            clientSocialNetworkModel = new ClientSocialNetworkModel();
            clientSocialNetworkModel.setNetworkSocialType(ClientSocialNetworkTypeConverter.convertFromEntity(entity.getNetworkSocialType()));
            clientSocialNetworkModel.setPreferential(entity.isPreferential());
            clientSocialNetworkModel.setValue(entity.getValue());

            boolean hasId;
            hasId = entity.getId() != null;

            if (hasId) {
                clientSocialNetworkModel.setId(entity.getId());
            }

            clientSocialNetworkModels.add(clientSocialNetworkModel);
        }

        return clientSocialNetworkModels;
    }
}

