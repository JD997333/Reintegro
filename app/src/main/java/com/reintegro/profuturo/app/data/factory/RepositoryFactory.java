package com.reintegro.profuturo.app.data.factory;

import com.reintegro.profuturo.app.data.repository.AgentRepository;
import com.reintegro.profuturo.app.data.repository.ClientRepository;
import com.reintegro.profuturo.app.data.repository.RepaymentEventRepository;

public abstract class RepositoryFactory {
    public abstract AgentRepository createAgentRepository();
    public abstract ClientRepository createClientRepository();
    public abstract RepaymentEventRepository createRepaymentEventRepository();
}
