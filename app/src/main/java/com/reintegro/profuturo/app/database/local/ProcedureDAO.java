package com.reintegro.profuturo.app.database.local;

import com.reintegro.profuturo.app.data.entity.ProcedureEntity;
import com.reintegro.profuturo.app.data.repository.ProcedureRepository;
import com.reintegro.profuturo.app.database.converter.ProcedureModelConverter;
import com.reintegro.profuturo.app.database.model.ProcedureModel;

import io.realm.Realm;
import io.realm.RealmResults;

public class ProcedureDAO implements ProcedureRepository {

    @Override
    public ProcedureEntity add(ProcedureEntity procedureEntity) {
        Realm realm;
        realm = Realm.getDefaultInstance();
        realm.beginTransaction();

        ProcedureModel model = realm.copyToRealm(ProcedureModelConverter.convertFromEntity(procedureEntity));

        ProcedureEntity entity = ProcedureModelConverter.convertFromModel(model);

        realm.commitTransaction();
        realm.close();

        return entity;
    }

    @Override
    public ProcedureEntity getFirst() {
        Realm realm = Realm.getDefaultInstance();

        ProcedureModel result = realm.where(ProcedureModel.class).findFirst();
        ProcedureEntity entity = null;

        if (result != null){
            entity = ProcedureModelConverter.convertFromModel(result);
        }

        realm.close();

        return entity;
    }

    @Override
    public ProcedureEntity update(ProcedureEntity procedureEntity) {
        Realm realm;
        realm = Realm.getDefaultInstance();
        realm.beginTransaction();

        ProcedureModel model = realm.copyToRealmOrUpdate(ProcedureModelConverter.convertFromEntity(procedureEntity));
        ProcedureEntity entity = ProcedureModelConverter.convertFromModel(model);

        realm.commitTransaction();
        realm.close();

        return entity;
    }

    @Override
    public void clear() {
        Realm realm = Realm.getDefaultInstance();
        realm.beginTransaction();

        RealmResults<ProcedureModel> results;
        results = realm.where(ProcedureModel.class).findAll();

        if (!results.isEmpty()){
            results.deleteAllFromRealm();
        }

        realm.commitTransaction();
        realm.close();
    }
}
