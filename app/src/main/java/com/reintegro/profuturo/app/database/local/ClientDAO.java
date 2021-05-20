package com.reintegro.profuturo.app.database.local;

import com.reintegro.profuturo.app.data.entity.ClientEntity;
import com.reintegro.profuturo.app.data.repository.ClientRepository;
import com.reintegro.profuturo.app.database.converter.ClientModelConverter;
import com.reintegro.profuturo.app.database.model.ClientModel;

import java.util.ArrayList;
import java.util.List;

import io.realm.Realm;
import io.realm.RealmResults;

public class ClientDAO implements ClientRepository {
    private static final String FIELD_NAME_SELECTED = "selected";

    @Override
    public ClientEntity getSelected() {
        Realm realm;
        realm = Realm.getDefaultInstance();

        ClientModel result;
        result = realm.where(ClientModel.class)
            .equalTo(FIELD_NAME_SELECTED, true)
            .findFirst();

        ClientEntity entity;

        if (result != null) {
            entity = ClientModelConverter.convertFromModel(result);
        } else {
            entity = null;
        }

        realm.close();

        return entity;
    }

    @Override
    public ClientEntity update(ClientEntity clientEntity) {
        Realm realm;
        realm = Realm.getDefaultInstance();
        realm.beginTransaction();

        ClientModel model = realm.copyToRealmOrUpdate(ClientModelConverter.convertFromEntity(clientEntity));

        ClientEntity entity = ClientModelConverter.convertFromModel(model);

        realm.commitTransaction();
        realm.close();

        return entity;
    }

    @Override
    public List<ClientEntity> addAll(List<ClientEntity> clientEntities) {
        Realm realm;
        realm = Realm.getDefaultInstance();
        realm.beginTransaction();

        List<ClientModel> models;
        models = realm.copyToRealm(ClientModelConverter.convertFromEntities(clientEntities));

        List<ClientEntity> entities;
        entities = ClientModelConverter.convertFromModels(models);

        realm.commitTransaction();
        realm.close();

        return entities;
    }

    @Override
    public List<ClientEntity> getAll() {
        Realm realm;
        realm = Realm.getDefaultInstance();

        RealmResults<ClientModel> results;
        results = realm.where(ClientModel.class).findAll();

        List<ClientEntity> entities;
        entities = new ArrayList<>();

        if (!results.isEmpty()) {
            entities.addAll(ClientModelConverter.convertFromModels(realm.copyFromRealm(results)));
        }

        realm.close();

        return entities;
    }

    @Override
    public void clear() {
        Realm realm;
        realm = Realm.getDefaultInstance();
        realm.beginTransaction();

        RealmResults<ClientModel> results;
        results = realm.where(ClientModel.class).findAll();

        if (!results.isEmpty()) {
            results.deleteAllFromRealm();
        }

        realm.commitTransaction();
        realm.close();
    }
}
