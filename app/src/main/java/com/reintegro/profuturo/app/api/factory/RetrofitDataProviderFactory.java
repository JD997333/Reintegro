package com.reintegro.profuturo.app.api.factory;

import android.content.Context;

import com.reintegro.profuturo.app.api.Api;
import com.reintegro.profuturo.app.api.converter.ApplicantTypeResponseConverter;
import com.reintegro.profuturo.app.api.converter.CalculateRepaymentResponseConverter;
import com.reintegro.profuturo.app.api.converter.GetAgentAssignedBranchOfficeResponseConverter;
import com.reintegro.profuturo.app.api.converter.GetAgentInformationResponseConverter;
import com.reintegro.profuturo.app.api.converter.GetBranchOfficesResponseConverter;
import com.reintegro.profuturo.app.api.converter.GetClientDataOP360ResponseConverter;
import com.reintegro.profuturo.app.api.converter.GetClientDataResponseConverter;
import com.reintegro.profuturo.app.api.converter.GetClientImageResponseConverter;
import com.reintegro.profuturo.app.api.converter.GetDocumentsResponseConverter;
import com.reintegro.profuturo.app.api.converter.GetLetterRepaymentResponseConverter;
import com.reintegro.profuturo.app.api.converter.GetRepaymentEventsResponseConverter;
import com.reintegro.profuturo.app.api.converter.GetRepaymentSolicitudeDocResponseConverter;
import com.reintegro.profuturo.app.api.converter.InsertClientResponseConverter;
import com.reintegro.profuturo.app.api.converter.InsertInitialRulingResponseConverter;
import com.reintegro.profuturo.app.api.converter.SaveInitialCaptureResponseConverter;
import com.reintegro.profuturo.app.api.converter.SaveLoginResponseConverter;
import com.reintegro.profuturo.app.api.converter.ValCoexistenceNciResponseConverter;
import com.reintegro.profuturo.app.api.converter.ValidateAuthFolioResponseConverter;
import com.reintegro.profuturo.app.api.provider.RetrofitWebServiceDataProvider;
import com.reintegro.profuturo.app.api.validator.ApplicantTypeResponseValidator;
import com.reintegro.profuturo.app.api.validator.CalculateRepaymentResponseValidator;
import com.reintegro.profuturo.app.api.validator.GetAgentAssignedBranchOfficeResponseValidator;
import com.reintegro.profuturo.app.api.validator.GetAgentInformationResponseValidator;
import com.reintegro.profuturo.app.api.validator.GetBranchOfficesResponseValidator;
import com.reintegro.profuturo.app.api.validator.GetClientDataOP360ResponseValidator;
import com.reintegro.profuturo.app.api.validator.GetClientDataResponseValidator;
import com.reintegro.profuturo.app.api.validator.GetClientImageResponseValidator;
import com.reintegro.profuturo.app.api.validator.GetDocumentsResponseValidator;
import com.reintegro.profuturo.app.api.validator.GetLetterRepaymentResponseValidator;
import com.reintegro.profuturo.app.api.validator.GetRepaymentEventsResponseValidator;
import com.reintegro.profuturo.app.api.validator.GetRepaymentSolicitudeDocResponseValidator;
import com.reintegro.profuturo.app.api.validator.InsertClientResponseValidator;
import com.reintegro.profuturo.app.api.validator.InsertInitialRulingResponseValidator;
import com.reintegro.profuturo.app.api.validator.SaveInitialCaptureResponseValidator;
import com.reintegro.profuturo.app.api.validator.SaveLoginResponseValidator;
import com.reintegro.profuturo.app.api.validator.ValCoexistenceNciResponseValidator;
import com.reintegro.profuturo.app.api.validator.ValidateAuthFolioResponseValidator;
import com.reintegro.profuturo.app.api.vo.GetAgentAssignedBranchOfficeRequest;
import com.reintegro.profuturo.app.api.vo.GetAgentInformationRequest;
import com.reintegro.profuturo.app.data.entity.AgentEntity;
import com.reintegro.profuturo.app.data.entity.BranchOfficeEntity;
import com.reintegro.profuturo.app.data.entity.ClientEntity;
import com.reintegro.profuturo.app.data.entity.DocumentEntity;
import com.reintegro.profuturo.app.data.entity.LocationEntity;
import com.reintegro.profuturo.app.data.entity.ProcedureEntity;
import com.reintegro.profuturo.app.data.entity.RepaymentEntity;
import com.reintegro.profuturo.app.data.entity.SearchClientEntity;
import com.reintegro.profuturo.app.data.factory.DataProviderFactory;
import com.reintegro.profuturo.app.data.provider.Provider;
import com.reintegro.profuturo.app.vo.ApplicantType;
import com.reintegro.profuturo.app.vo.CoexistenceResult;
import com.reintegro.profuturo.app.vo.ValidateFolioResult;

import java.util.HashMap;
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

    @Override
    public Provider<ProcedureEntity> saveInitialCapture(RepaymentEntity repaymentEntity, ClientEntity clientEntity, AgentEntity agentEntity, ProcedureEntity procedureEntity) {
        return new RetrofitWebServiceDataProvider<>(
                Api.getClient().saveInitialCapture(requestFactory.createSaveInitialCaptureRequest(agentEntity, clientEntity, repaymentEntity, procedureEntity)),
                new SaveInitialCaptureResponseConverter(),
                new SaveInitialCaptureResponseValidator()
        );
    }

    @Override
    public Provider<Boolean> insertClient(ClientEntity clientEntity, AgentEntity agentEntity) {
        return new RetrofitWebServiceDataProvider<>(
                Api.getClient().insertClient(requestFactory.createInsertClientRequest(clientEntity, agentEntity)),
                new InsertClientResponseConverter(),
                new InsertClientResponseValidator()
        );
    }

    @Override
    public Provider<HashMap<String, String>> getClientDataOP360(ClientEntity clientEntity) {
        return new RetrofitWebServiceDataProvider<>(
                Api.getClient().getClientDataOP360(requestFactory.createGetClientDataOP360Request(clientEntity)),
                new GetClientDataOP360ResponseConverter(),
                new GetClientDataOP360ResponseValidator()
        );
    }

    @Override
    public Provider<List<ApplicantType>> getApplicantTypes(ClientEntity clientEntity, ProcedureEntity procedureEntity) {
        return new RetrofitWebServiceDataProvider<>(
                Api.getClient().getApplicantTypes(requestFactory.createGetApplicantTypesRequest(clientEntity, procedureEntity)),
                new ApplicantTypeResponseConverter(),
                new ApplicantTypeResponseValidator()
        );
    }

    @Override
    public Provider<CoexistenceResult> createValCoexistenceNciProvider(ClientEntity clientEntity) {
        return new RetrofitWebServiceDataProvider<>(
                Api.getClient().valCoexistenceNci(requestFactory.createValCoexistenceNciRequest(clientEntity)),
                new ValCoexistenceNciResponseConverter(),
                new ValCoexistenceNciResponseValidator()
        );
    }

    @Override
    public Provider<List<RepaymentEntity>> createGetRepaymentsProvider(ClientEntity clientEntity) {
        return new RetrofitWebServiceDataProvider<>(
                Api.getClient().getRepaymentEvents(requestFactory.createGetRepaymentEventsRequest(clientEntity)),
                new GetRepaymentEventsResponseConverter(),
                new GetRepaymentEventsResponseValidator()
        );
    }

    @Override
    public Provider<RepaymentEntity> createCalculateRepaymentProvider(RepaymentEntity repaymentEntity) {
        return new RetrofitWebServiceDataProvider<>(
                Api.getClient().calculateRepayment(requestFactory.createCalculateRepaymentRequest(repaymentEntity)),
                new CalculateRepaymentResponseConverter(),
                new CalculateRepaymentResponseValidator()
        );
    }

    @Override
    public Provider<ValidateFolioResult> createValidateAuthFolioProvider(ClientEntity clientEntity, ProcedureEntity procedureEntity) {
        return new RetrofitWebServiceDataProvider<>(
                Api.getClient().validateAuthFolio(requestFactory.createValidateAuthFolioRequest(clientEntity, procedureEntity)),
                new ValidateAuthFolioResponseConverter(),
                new ValidateAuthFolioResponseValidator()
        );
    }

    @Override
    public Provider<List<DocumentEntity>> createGetDocumentsProvider(int idProcess, int applicantType, int idSubProcess) {
        return new RetrofitWebServiceDataProvider<>(
                Api.getClient().getDocuments(idProcess, applicantType, idSubProcess),
                new GetDocumentsResponseConverter(),
                new GetDocumentsResponseValidator()
        );
    }

    @Override
    public Provider<String> createGetRepaymentSolicitudeDocProvider(AgentEntity agentEntity, ClientEntity clientEntity, ProcedureEntity procedureEntity, DocumentEntity documentEntity, RepaymentEntity repaymentEntity) {
        return new RetrofitWebServiceDataProvider<>(
                Api.getClient().getRepaymentSolicitudeDocument(requestFactory.createGetRepaymentSolicitudeRequest(agentEntity, clientEntity, procedureEntity, repaymentEntity, documentEntity)),
                new GetRepaymentSolicitudeDocResponseConverter(),
                new GetRepaymentSolicitudeDocResponseValidator()
        );
    }

    @Override
    public Provider<String> createGetLetterRepaymentDocProvider(ClientEntity clientEntity, ProcedureEntity procedureEntity, RepaymentEntity repaymentEntity) {
        return new RetrofitWebServiceDataProvider<>(
                Api.getClient().getLetterRepaymentDocument(requestFactory.createGetLetterRepaymentRequest(clientEntity, procedureEntity, repaymentEntity)),
                new GetLetterRepaymentResponseConverter(),
                new GetLetterRepaymentResponseValidator()
        );
    }

    @Override
    public Provider<Boolean> InsertInitialRulingProvider(ClientEntity clientEntity, ProcedureEntity procedureEntity, RepaymentEntity repaymentEntity) {
        return new RetrofitWebServiceDataProvider<>(
                Api.getClient().insertInitialRuling(requestFactory.createInsertInitialRulingRequest(clientEntity, procedureEntity, repaymentEntity)),
                new InsertInitialRulingResponseConverter(),
                new InsertInitialRulingResponseValidator()
                );
    }
}
