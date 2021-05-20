package com.reintegro.profuturo.app.data.factory;

import com.reintegro.profuturo.app.data.entity.AgentEntity;
import com.reintegro.profuturo.app.data.entity.BranchOfficeEntity;
import com.reintegro.profuturo.app.data.entity.ClientEntity;
import com.reintegro.profuturo.app.data.entity.LocationEntity;
import com.reintegro.profuturo.app.data.entity.SearchClientEntity;
import com.reintegro.profuturo.app.data.provider.Provider;

import java.util.List;

public abstract class DataProviderFactory {
    public abstract Provider<AgentEntity> createGetAgentInformationProvider(AgentEntity agentEntity);
    public abstract Provider<AgentEntity> createGetAgentAssignedBranchOfficeProvider(AgentEntity agentEntity);
    public abstract Provider<List<BranchOfficeEntity>> createGetBranchOfficesProvider(AgentEntity agentEntity, LocationEntity locationEntity);
    public abstract Provider<Boolean> createSaveLogin(AgentEntity agentEntity);
    public abstract Provider<List<ClientEntity>> createGetClientDataProvider(SearchClientEntity searchClientEntity);
    public abstract Provider<ClientEntity> createGetClientImageProvider(ClientEntity clientEntity);

}
