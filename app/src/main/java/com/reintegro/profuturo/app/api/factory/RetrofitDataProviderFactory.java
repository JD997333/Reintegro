package com.reintegro.profuturo.app.api.factory;

import android.content.Context;

import com.reintegro.profuturo.app.api.Api;
import com.reintegro.profuturo.app.api.converter.GetAgentAssignedBranchOfficeResponseConverter;
import com.reintegro.profuturo.app.api.converter.GetAgentInformationResponseConverter;
import com.reintegro.profuturo.app.api.converter.GetBranchOfficesResponseConverter;
import com.reintegro.profuturo.app.api.converter.GetClientDataResponseConverter;
import com.reintegro.profuturo.app.api.converter.GetClientImageResponseConverter;
import com.reintegro.profuturo.app.api.converter.SaveLoginResponseConverter;
import com.reintegro.profuturo.app.api.provider.RetrofitWebServiceDataProvider;
import com.reintegro.profuturo.app.api.validator.GetAgentAssignedBranchOfficeResponseValidator;
import com.reintegro.profuturo.app.api.validator.GetAgentInformationResponseValidator;
import com.reintegro.profuturo.app.api.validator.GetBranchOfficesResponseValidator;
import com.reintegro.profuturo.app.api.validator.GetClientDataResponseValidator;
import com.reintegro.profuturo.app.api.validator.GetClientImageResponseValidator;
import com.reintegro.profuturo.app.api.validator.SaveLoginResponseValidator;
import com.reintegro.profuturo.app.api.vo.GetAgentAssignedBranchOfficeRequest;
import com.reintegro.profuturo.app.api.vo.GetAgentInformationRequest;
import com.reintegro.profuturo.app.api.vo.SaveLoginRequest;
import com.reintegro.profuturo.app.data.entity.AgentEntity;
import com.reintegro.profuturo.app.data.entity.BranchOfficeEntity;
import com.reintegro.profuturo.app.data.entity.ClientEntity;
import com.reintegro.profuturo.app.data.entity.LocationEntity;
import com.reintegro.profuturo.app.data.entity.SearchClientEntity;
import com.reintegro.profuturo.app.data.factory.DataProviderFactory;
import com.reintegro.profuturo.app.data.provider.Provider;

import java.util.List;

public class RetrofitDataProviderFactory extends DataProviderFactory {
    private RequestFactory requestFactory;

    public RetrofitDataProviderFactory(Context context) {
        requestFactory = new RequestFactory();
    }

    @Override
    public Provider<AgentEntity> createGetAgentInformationProvider(AgentEntity agentEntity) {
        GetAgentInformationRequest request = requestFactory.createGetAgentInformationRequest(agentEntity);
        return new RetrofitWebServiceDataProvider<>(
                Api.getClient().getAgentInformation(request),
                new GetAgentInformationResponseConverter(),
                new GetAgentInformationResponseValidator()
        );
    }

    @Override
    public Provider<AgentEntity> createGetAgentAssignedBranchOfficeProvider(AgentEntity agentEntity) {
        GetAgentAssignedBranchOfficeRequest request = requestFactory.createGetAgentAssignedBranchOfficeRequest(agentEntity);
        return new RetrofitWebServiceDataProvider<>(
            Api.getClient().getAgentAssignedBranchOffice(request),
            new GetAgentAssignedBranchOfficeResponseConverter(),
            new GetAgentAssignedBranchOfficeResponseValidator()
        );
    }

    @Override
    public Provider<List<BranchOfficeEntity>> createGetBranchOfficesProvider(AgentEntity agentEntity, LocationEntity locationEntity) {
        return new RetrofitWebServiceDataProvider<>(
            Api.getClient().getBranchOffices(agentEntity.getBranchOfficeNumber(), locationEntity.getLatitude(), locationEntity.getLongitude()),
            new GetBranchOfficesResponseConverter(),
            new GetBranchOfficesResponseValidator()
        );
    }

    @Override
    public Provider<Boolean> createSaveLogin(AgentEntity agentEntity) {
        return new RetrofitWebServiceDataProvider<>(
            Api.getClient().saveLogin(requestFactory.createSaveLoginRequest(agentEntity)),
            new SaveLoginResponseConverter(),
            new SaveLoginResponseValidator()
        );
    }

    @Override
    public Provider<List<ClientEntity>> createGetClientDataProvider(SearchClientEntity searchClientEntity) {
        return new RetrofitWebServiceDataProvider<>(
            Api.getClient().getClientData(searchClientEntity.getAccountNumber(), searchClientEntity.getCurp(), searchClientEntity.getNss()),
            new GetClientDataResponseConverter(),
            new GetClientDataResponseValidator()
        );
    }

    @Override
    public Provider<ClientEntity> createGetClientImageProvider(ClientEntity clientEntity) {
        return new RetrofitWebServiceDataProvider<>(
            Api.getClient().getClientImage(requestFactory.createGetClientImageRequest(clientEntity)),
            new GetClientImageResponseConverter(),
            new GetClientImageResponseValidator()
        );
    }
}
