package com.reintegro.profuturo.app.database.converter;

import com.reintegro.profuturo.app.data.entity.ClientEmailEntity;
import com.reintegro.profuturo.app.database.model.ClientEmailModel;

import java.util.ArrayList;
import java.util.List;

import io.realm.RealmList;

public class ClientEmailConverter {
    public static List<ClientEmailEntity> convertFromModels(List<ClientEmailModel> clientEmailModels) {
        List<ClientEmailEntity> clientEmailEntities;
        clientEmailEntities = new ArrayList<>();

        for (ClientEmailModel clientEmailModel : clientEmailModels) {
            ClientEmailEntity clientEmailEntity = new ClientEmailEntity();
            clientEmailEntity.setEmail(clientEmailModel.getEmail());
            clientEmailEntity.setEmailType(clientEmailModel.getEmailType());
            clientEmailEntity.setId(clientEmailModel.getId());
            clientEmailEntity.setPreferential(clientEmailModel.isPreferential());
            clientEmailEntity.setValidEmail(clientEmailModel.isValidEmail());

            clientEmailEntities.add(clientEmailEntity);
        }

        return clientEmailEntities;
    }

    public static RealmList<ClientEmailModel> convertFromEntities(List<ClientEmailEntity> clientEmailEntities) {
        RealmList<ClientEmailModel> clientEmailModels;
        clientEmailModels = new RealmList<>();

        for (ClientEmailEntity entity : clientEmailEntities) {
            ClientEmailModel clientEmailModel = new ClientEmailModel();
            clientEmailModel.setEmail(entity.getEmail());
            clientEmailModel.setEmailType(entity.getEmailType());
            clientEmailModel.setPreferential(entity.isPreferential());
            clientEmailModel.setValidEmail(entity.isValidEmail());

            boolean hasId;
            hasId = entity.getId() != null;

            if (hasId) {
                clientEmailModel.setId(entity.getId());
            }

            clientEmailModels.add(clientEmailModel);
        }

        return clientEmailModels;
    }
}
