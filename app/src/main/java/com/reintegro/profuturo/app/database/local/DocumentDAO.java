package com.reintegro.profuturo.app.database.local;

import com.reintegro.profuturo.app.data.entity.DocumentEntity;
import com.reintegro.profuturo.app.data.repository.DocumentRepository;
import com.reintegro.profuturo.app.database.converter.DocumentModelConverter;
import com.reintegro.profuturo.app.database.model.DocumentModel;

import java.util.ArrayList;
import java.util.List;

import io.realm.Realm;
import io.realm.RealmResults;

public class DocumentDAO implements DocumentRepository {
    private static final String FIELD_NAME_CAPTURED = "captured";

    @Override
    public List<DocumentEntity> addAll(List<DocumentEntity> documentEntities) {
        Realm realm;
        realm = Realm.getDefaultInstance();
        realm.beginTransaction();

        List<DocumentModel> models;
        models = realm.copyToRealm(DocumentModelConverter.convertFromEntities(documentEntities));

        List<DocumentEntity> entities;
        entities = DocumentModelConverter.convertFromModels(models);

        realm.commitTransaction();
        realm.close();

        return entities;
    }

    @Override
    public List<DocumentEntity> getCaptured() {
        Realm realm;
        realm = Realm.getDefaultInstance();

        RealmResults<DocumentModel> results;
        results = realm
            .where(DocumentModel.class)
            .equalTo(FIELD_NAME_CAPTURED, true)
            .findAll();

        List<DocumentEntity> entities;
        entities = new ArrayList<>();
        entities.addAll(DocumentModelConverter.convertFromModels(realm.copyFromRealm(results)));

        realm.close();

        return entities;
    }

    @Override
    public List<DocumentEntity> updateAll(List<DocumentEntity> documentEntities) {
        Realm realm;
        realm = Realm.getDefaultInstance();
        realm.beginTransaction();

        List<DocumentModel> models;
        models = realm.copyToRealmOrUpdate(DocumentModelConverter.convertFromEntities(documentEntities));

        List<DocumentEntity> entities;
        entities = DocumentModelConverter.convertFromModels(models);

        realm.commitTransaction();
        realm.close();

        return entities;
    }

    @Override
    public void clear() {
        Realm realm;
        realm = Realm.getDefaultInstance();
        realm.beginTransaction();

        RealmResults<DocumentModel> results;
        results = realm.where(DocumentModel.class).findAll();

        if (!results.isEmpty()) {
            results.deleteAllFromRealm();
        }

        realm.commitTransaction();
        realm.close();
    }
}
