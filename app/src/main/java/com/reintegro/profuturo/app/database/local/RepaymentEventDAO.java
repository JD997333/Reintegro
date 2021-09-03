package com.reintegro.profuturo.app.database.local;

import com.reintegro.profuturo.app.data.entity.RepaymentEntity;
import com.reintegro.profuturo.app.data.repository.RepaymentEventRepository;
import com.reintegro.profuturo.app.database.converter.RepaymentModelConverter;
import com.reintegro.profuturo.app.database.model.AgentModel;
import com.reintegro.profuturo.app.database.model.RepaymentModel;

import java.util.ArrayList;
import java.util.List;

import io.realm.Realm;
import io.realm.RealmResults;

public class RepaymentEventDAO implements RepaymentEventRepository {

    private static final String FIELD_SELECTED = "selected";

    @Override
    public List<RepaymentEntity> addAll(List<RepaymentEntity> repaymentEntities) {
        Realm realm = Realm.getDefaultInstance();
        realm.beginTransaction();

        List<RepaymentModel> models;
        models = RepaymentModelConverter.convertFromEntities(repaymentEntities);
        realm.copyToRealm(models);

        List<RepaymentEntity> entities;
        entities = RepaymentModelConverter.convertFromModels(models);

        realm.commitTransaction();
        realm.close();

        return entities;
    }

    @Override
    public RepaymentEntity update(RepaymentEntity repaymentEntity) {
        Realm realm = Realm.getDefaultInstance();
        realm.beginTransaction();

        RepaymentModel model = RepaymentModelConverter.convertFromEntity(repaymentEntity);

        model = realm.copyToRealmOrUpdate(model);

        RepaymentEntity entity = RepaymentModelConverter.convertFromModel(model);

        realm.commitTransaction();
        realm.close();

        return entity;
    }

    @Override
    public RepaymentEntity getSelected() {
        Realm realm = Realm.getDefaultInstance();
        realm.beginTransaction();

        RepaymentModel result;
        result = realm.where(RepaymentModel.class)
            .equalTo(FIELD_SELECTED, true)
            .findFirst();

        RepaymentEntity entity;

        if (result != null){
            entity = RepaymentModelConverter.convertFromModel(result);
        }else{
            entity = null;
        }

        realm.close();

        return entity;
    }

    @Override
    public void setSelected(RepaymentEntity repaymentEntity) {
        Realm realm = Realm.getDefaultInstance();
        realm.beginTransaction();

        RealmResults<RepaymentModel> results;
        results = realm.where(RepaymentModel.class).findAll();

        List<RepaymentModel> models;
        models = realm.copyFromRealm(results);

        for (RepaymentModel model : models){
            if (model.getId().equals(repaymentEntity.getId())){
                model.setSelected(true);
            } else{
                model.setSelected(false);
            }
            realm.copyToRealmOrUpdate(model);
        }

        realm.commitTransaction();
        realm.close();
    }

    @Override
    public List<RepaymentEntity> getAll() {
        Realm realm;
        realm = Realm.getDefaultInstance();

        RealmResults<RepaymentModel> results;
        results = realm.where(RepaymentModel.class).findAll();

        List<RepaymentEntity> entities;
        entities = new ArrayList<>();

        if (!results.isEmpty()) {
            entities.addAll(RepaymentModelConverter.convertFromModels(realm.copyFromRealm(results)));
        }

        realm.close();

        return entities;
    }

    @Override
    public void clear() {
        Realm realm = Realm.getDefaultInstance();
        realm.beginTransaction();

        RealmResults<RepaymentModel> results;
        results = realm.where(RepaymentModel.class).findAll();

        if (!results.isEmpty()) {
            results.deleteAllFromRealm();
        }

        realm.commitTransaction();
        realm.close();
    }
}
