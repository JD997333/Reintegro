package com.reintegro.profuturo.app.database;

import android.content.Context;

import com.reintegro.profuturo.app.database.local.AgentDAO;

import io.realm.Realm;
import io.realm.RealmConfiguration;

public class DataBase {
    public static void init(Context context){
        Realm.init(context);

        RealmConfiguration realmConfiguration = new RealmConfiguration.Builder()
                .deleteRealmIfMigrationNeeded()
                .name("reintegro.realm")
                .schemaVersion(1)
                .build();

        Realm.setDefaultConfiguration(realmConfiguration);

        AgentDAO agentDAO = new AgentDAO();
        agentDAO.clear();
    }
}
