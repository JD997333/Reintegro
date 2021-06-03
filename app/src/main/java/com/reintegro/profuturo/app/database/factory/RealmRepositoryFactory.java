package com.reintegro.profuturo.app.database.factory;

import com.reintegro.profuturo.app.data.factory.RepositoryFactory;
import com.reintegro.profuturo.app.data.repository.AgentRepository;
import com.reintegro.profuturo.app.data.repository.ClientRepository;
import com.reintegro.profuturo.app.data.repository.RepaymentEventRepository;
import com.reintegro.profuturo.app.database.local.AgentDAO;
import com.reintegro.profuturo.app.database.local.ClientDAO;
import com.reintegro.profuturo.app.database.local.RepaymentEventDAO;

public class RealmRepositoryFactory extends RepositoryFactory {
    @Override
    public AgentRepository createAgentRepository() {
        return new AgentDAO();
    }

    @Override
    public ClientRepository createClientRepository() {
        return new ClientDAO();
    }

    @Override
    public RepaymentEventRepository createRepaymentEventRepository() {
        return new RepaymentEventDAO();
    }
}
