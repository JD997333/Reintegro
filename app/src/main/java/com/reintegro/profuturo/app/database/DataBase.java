package com.reintegro.profuturo.app.database;

import android.content.Context;

import com.reintegro.profuturo.app.database.local.AgentDAO;
import com.reintegro.profuturo.app.database.local.ClientDAO;
import com.reintegro.profuturo.app.database.local.ProcedureDAO;
import com.reintegro.profuturo.app.database.local.RepaymentEventDAO;

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

        ClientDAO clientDAO = new ClientDAO();
        clientDAO.clear();

        RepaymentEventDAO repaymentEventDAO = new RepaymentEventDAO();
        repaymentEventDAO.clear();

        ProcedureDAO procedureDAO = new ProcedureDAO();
        procedureDAO.clear();
    }
}
