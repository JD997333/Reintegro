package com.reintegro.profuturo.app.database.local;

import com.reintegro.profuturo.app.data.entity.AgentEntity;
import com.reintegro.profuturo.app.data.repository.AgentRepository;
import com.reintegro.profuturo.app.database.converter.AgentModelConverter;
import com.reintegro.profuturo.app.database.model.AgentModel;

import io.realm.Realm;
import io.realm.RealmResults;

public class AgentDAO implements AgentRepository {
    @Override
    public AgentEntity add(AgentEntity agentEntity) {
        Realm realm;
        realm = Realm.getDefaultInstance();
        realm.beginTransaction();

        AgentModel model = realm.copyToRealm(AgentModelConverter.convertFromEntity(agentEntity));

        AgentEntity entity = AgentModelConverter.convertFromModel(model);

        realm.commitTransaction();
        realm.close();

        return entity;
    }

    @Override
    public AgentEntity getFirst() {
        Realm realm;
        realm = Realm.getDefaultInstance();

        AgentModel result = realm.where(AgentModel.class).findFirst();

        AgentEntity entity = null;

        if (result != null) {
            entity = AgentModelConverter.convertFromModel(realm.copyFromRealm(result));
        }

        realm.close();

        return entity;
    }

    @Override
    public AgentEntity update(AgentEntity agentEntity) {
        Realm realm;
        realm = Realm.getDefaultInstance();
        realm.beginTransaction();

        AgentModel model = realm.copyToRealmOrUpdate(AgentModelConverter.convertFromEntity(agentEntity));

        AgentEntity entity = AgentModelConverter.convertFromModel(model);

        realm.commitTransaction();
        realm.close();

        return entity;
    }

    @Override
    public void clear() {
        Realm realm;
        realm = Realm.getDefaultInstance();
        realm.beginTransaction();

        RealmResults<AgentModel> results;
        results = realm.where(AgentModel.class).findAll();

        if (!results.isEmpty()) {
            results.deleteAllFromRealm();
        }

        realm.commitTransaction();
        realm.close();
    }
}
