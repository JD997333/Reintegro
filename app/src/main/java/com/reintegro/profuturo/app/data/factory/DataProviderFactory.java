package com.reintegro.profuturo.app.data.factory;

import com.reintegro.profuturo.app.data.entity.AgentEntity;
import com.reintegro.profuturo.app.data.entity.BranchOfficeEntity;
import com.reintegro.profuturo.app.data.entity.ClientEntity;
import com.reintegro.profuturo.app.data.entity.DocumentEntity;
import com.reintegro.profuturo.app.data.entity.FingerPrintEntity;
import com.reintegro.profuturo.app.data.entity.LocationEntity;
import com.reintegro.profuturo.app.data.entity.NotificationChannelEntity;
import com.reintegro.profuturo.app.data.entity.ProcedureEntity;
import com.reintegro.profuturo.app.data.entity.RepaymentEntity;
import com.reintegro.profuturo.app.data.entity.SearchClientEntity;
import com.reintegro.profuturo.app.data.provider.Provider;
import com.reintegro.profuturo.app.vo.ApplicantType;
import com.reintegro.profuturo.app.vo.CoexistenceResult;
import com.reintegro.profuturo.app.vo.ValidateFolioResult;

import java.util.HashMap;
import java.util.List;

public abstract class DataProviderFactory {
    public abstract Provider<AgentEntity> createGetAgentInformationProvider(AgentEntity agentEntity);
    public abstract Provider<AgentEntity> createGetAgentAssignedBranchOfficeProvider(AgentEntity agentEntity);
    public abstract Provider<List<BranchOfficeEntity>> createGetBranchOfficesProvider(AgentEntity agentEntity, LocationEntity locationEntity);
    public abstract Provider<Boolean> createSaveLogin(AgentEntity agentEntity);
    public abstract Provider<List<ClientEntity>> createGetClientDataProvider(SearchClientEntity searchClientEntity);
    public abstract Provider<ClientEntity> createGetClientImageProvider(ClientEntity clientEntity);
    public abstract Provider<ProcedureEntity> saveInitialCapture(RepaymentEntity repaymentEntity, ClientEntity clientEntity, AgentEntity agentEntity, ProcedureEntity procedureEntity);
    public abstract Provider<Boolean> insertClient(ClientEntity clientEntity, AgentEntity agentEntity);
    public abstract Provider<HashMap<String, String>> getClientDataOP360(ClientEntity clientEntity);
    public abstract Provider<List<ApplicantType>> getApplicantTypes(ClientEntity clientEntity, ProcedureEntity procedureEntity);
    public abstract Provider<CoexistenceResult> createValCoexistenceNciProvider(ClientEntity clientEntity);
    public abstract Provider<List<RepaymentEntity>> createGetRepaymentsProvider(ClientEntity clientEntity);
    public abstract Provider<RepaymentEntity> createCalculateRepaymentProvider(RepaymentEntity repaymentEntity);
    public abstract Provider<ValidateFolioResult> createValidateAuthFolioProvider(ClientEntity clientEntity, ProcedureEntity procedureEntity);
    public abstract Provider<List<DocumentEntity>> createGetDocumentsProvider(int idProcess, int applicantType, int idSubProcess);
    public abstract Provider<String> createGetRepaymentSolicitudeDocProvider(AgentEntity agentEntity, ClientEntity clientEntity, ProcedureEntity procedureEntity, DocumentEntity documentEntity, RepaymentEntity repaymentEntity);
    public abstract Provider<String> createGetLetterRepaymentDocProvider(ClientEntity clientEntity, ProcedureEntity procedureEntity, RepaymentEntity repaymentEntity);
    public abstract Provider<Boolean> createStartBpmInstanceProvider(ProcedureEntity procedureEntity);
    public abstract Provider<String> createGetRecommendedFingersProvider(ClientEntity clientEntity);
    public abstract Provider<ProcedureEntity> createGetVoluntarySealProvider(ClientEntity clientEntity, AgentEntity agentEntity, ProcedureEntity procedureEntity, List<FingerPrintEntity> fingerPrintEntities);
    public abstract Provider<Boolean> createSaveVoluntarySealProvider(ClientEntity clientEntity, AgentEntity agentEntity, ProcedureEntity procedureEntity);
    public abstract Provider<CoexistenceResult> createMarkNciCoexistenceProvider(ClientEntity clientEntity, AgentEntity agentEntity, ProcedureEntity procedureEntity);
    public abstract Provider<Boolean> createUploadFilesToFileNetProvider(ProcedureEntity procedureEntity, List<DocumentEntity> documents);

    public abstract Provider<Boolean> createSendEmailProvider(AgentEntity agentEntity, ClientEntity clientEntity, ProcedureEntity procedureEntity, List<DocumentEntity> documents, NotificationChannelEntity notificationChannel);
    public abstract Provider<Boolean> createInsertBinnacleProvider(AgentEntity agentEntity, ProcedureEntity procedureEntity);

}
