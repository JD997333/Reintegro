package com.reintegro.profuturo.app.api.factory;

import com.reintegro.profuturo.app.api.vo.ApplicantTypeRequest;
import com.reintegro.profuturo.app.api.vo.CalculateRepaymentRequest;
import com.reintegro.profuturo.app.api.vo.GetAgentAssignedBranchOfficeRequest;
import com.reintegro.profuturo.app.api.vo.GetAgentInformationRequest;
import com.reintegro.profuturo.app.api.vo.GetClientData360Request;
import com.reintegro.profuturo.app.api.vo.GetClientImageRequest;
import com.reintegro.profuturo.app.api.vo.GetLetterRepaymentDocRequest;
import com.reintegro.profuturo.app.api.vo.GetRecommendedFingersRequest;
import com.reintegro.profuturo.app.api.vo.GetRepaymentEventsRequest;
import com.reintegro.profuturo.app.api.vo.GetRepaymentSolicitudeDocRequest;
import com.reintegro.profuturo.app.api.vo.GetVoluntarySealRequest;
import com.reintegro.profuturo.app.api.vo.InsertClientRequest;
import com.reintegro.profuturo.app.api.vo.InsertInitialRulingRequest;
import com.reintegro.profuturo.app.api.vo.InsertProcessBinnacleRequest;
import com.reintegro.profuturo.app.api.vo.MarkNciCoexistenceRequest;
import com.reintegro.profuturo.app.api.vo.SaveInitialCaptureRequest;
import com.reintegro.profuturo.app.api.vo.SaveLoginRequest;
import com.reintegro.profuturo.app.api.vo.SaveVoluntarySealRequest;
import com.reintegro.profuturo.app.api.vo.UpdatePaperworkRequest;
import com.reintegro.profuturo.app.api.vo.SendEmailRequest;
import com.reintegro.profuturo.app.api.vo.UploadFilesToFileNetRequest;
import com.reintegro.profuturo.app.api.vo.ValCoexistenceNCIRequest;
import com.reintegro.profuturo.app.api.vo.ValidateAuthFolioRequest;
import com.reintegro.profuturo.app.data.entity.AgentEntity;
import com.reintegro.profuturo.app.data.entity.ClientEntity;
import com.reintegro.profuturo.app.data.entity.DocumentEntity;
import com.reintegro.profuturo.app.data.entity.FingerPrintEntity;
import com.reintegro.profuturo.app.data.entity.NotificationChannelEntity;
import com.reintegro.profuturo.app.data.entity.ProcedureEntity;
import com.reintegro.profuturo.app.data.entity.RepaymentEntity;
import com.reintegro.profuturo.app.util.Base64Utils;
import com.reintegro.profuturo.app.util.Constants;
import com.reintegro.profuturo.app.util.DateUtils;
import com.reintegro.profuturo.app.util.TypeUtils;
import com.reintegro.profuturo.app.util.Utils;

import java.util.ArrayList;
import java.util.List;

public class RequestFactory {

    public GetAgentInformationRequest createGetAgentInformationRequest(AgentEntity agentEntity) {
        GetAgentInformationRequest.AgentNumber agentNumber;
        agentNumber = new GetAgentInformationRequest.AgentNumber();
        agentNumber.setAgentNumber(TypeUtils.getValueOrDefault(agentEntity.getAgentCode()));

        GetAgentInformationRequest getAgentInformationRequest;
        getAgentInformationRequest = new GetAgentInformationRequest();
        getAgentInformationRequest.setAgentNumber(agentNumber);

        return getAgentInformationRequest;
    }

    public GetAgentAssignedBranchOfficeRequest createGetAgentAssignedBranchOfficeRequest(AgentEntity agentEntity) {
        GetAgentAssignedBranchOfficeRequest.AgentNumber agentNumber;
        agentNumber = new GetAgentAssignedBranchOfficeRequest.AgentNumber();
        agentNumber.setAgentNumber(TypeUtils.getValueOrDefault(agentEntity.getAgentCode()));

        GetAgentAssignedBranchOfficeRequest getAgentAssignedBranchOfficeRequest;
        getAgentAssignedBranchOfficeRequest = new GetAgentAssignedBranchOfficeRequest();
        getAgentAssignedBranchOfficeRequest.setAgentNumber(agentNumber);

        return getAgentAssignedBranchOfficeRequest;
    }

    public SaveLoginRequest createSaveLoginRequest(AgentEntity agentEntity) {
        SaveLoginRequest saveLoginRequest;
        saveLoginRequest = new SaveLoginRequest();
        saveLoginRequest.setAccessDate(DateUtils.parseDate(Constants.DATE_FORMAT_1, Constants.DATE_FORMAT_2, agentEntity.getConsarRegistrationDate().toDate()));
        saveLoginRequest.setAgentNumber(agentEntity.getAgentCode());
        saveLoginRequest.setAssignedBranchOfficeId(String.valueOf(agentEntity.getBranchOfficeNumber()));
        saveLoginRequest.setBranchOfficeName(agentEntity.getBranchOfficeName());
        saveLoginRequest.setConsarAgentNumber(String.valueOf(agentEntity.getConsarKey()));
        saveLoginRequest.setCreationUser("Mobile");
        saveLoginRequest.setCurp(agentEntity.getCurp());
        saveLoginRequest.setEmail(agentEntity.getEmail());
        saveLoginRequest.setFatherLastName(agentEntity.getFatherLastName());
        saveLoginRequest.setMotherLastName(agentEntity.getMotherLastName());
        saveLoginRequest.setName(agentEntity.getName());

        return saveLoginRequest;
    }

    public GetClientImageRequest createGetClientImageRequest(ClientEntity clientEntity) {
        GetClientImageRequest getClientImageRequest;
        getClientImageRequest = new GetClientImageRequest();
        getClientImageRequest.setAccountNumber(Long.parseLong(clientEntity.getAccountNumber()));

        return getClientImageRequest;
    }

    public SaveInitialCaptureRequest createSaveInitialCaptureRequest(AgentEntity agentEntity, ClientEntity clientEntity, RepaymentEntity repaymentEntity, ProcedureEntity procedureEntity){
        SaveInitialCaptureRequest request = new SaveInitialCaptureRequest();
        SaveInitialCaptureRequest.InitialCapture initialCapture = new SaveInitialCaptureRequest.InitialCapture();

        initialCapture.setCanal(procedureEntity.getIdChannel());
        initialCapture.setCurp(clientEntity.getCurp());
        initialCapture.setCurpAgenteServ(agentEntity.getCurp());
        initialCapture.setCurpSol(procedureEntity.getApplicantCurp());
        initialCapture.setFechEstatus(DateUtils.getFormatedTodayDate(Constants.DATE_FORMAT_2));
        initialCapture.setFechSolTRD(DateUtils.parseDate(Constants.DATE_FORMAT_1, Constants.DATE_FORMAT_2, repaymentEntity.getTrdDate().toDate()));
        initialCapture.setFechTramite(DateUtils.getFormatedTodayDate(Constants.DATE_FORMAT_2));
        initialCapture.setFolioAutentificacion(procedureEntity.getAuthFolio());
        initialCapture.setIdCanal(Integer.parseInt(procedureEntity.getIdChannel()));
        initialCapture.setIdEstatus(Constants.BINNACLE_STATUS_OPEN);
        initialCapture.setIdEstatusProceso(Constants.BINNACLE_STATUS_PROCESS);
        initialCapture.setIdEstatusTramite(Constants.STATUS_SUB_STAGE_PENDING.toString());
        initialCapture.setIdEtapa(Constants.ID_STAGE_RECEPTION);
        initialCapture.setIdProceso(procedureEntity.getIdProcess());
        initialCapture.setIdResultado(Constants.ID_RESULT_BINNACLE);
        initialCapture.setIdSubEtapa(Constants.ID_SUB_STAGE_CAPTURE);
        initialCapture.setIdSubProceso(procedureEntity.getIdSubProcess());
        initialCapture.setIdSucAsignada(String.valueOf(agentEntity.getBranchOfficeNumber()));
        initialCapture.setIdTipoSolicitante(procedureEntity.getIdApplicantType().toString());
        initialCapture.setIdTipoTramite(procedureEntity.getIdSubProcess().toString());
        initialCapture.setMontoPagDRT(repaymentEntity.getTrdAmount().toString());
        initialCapture.setMontoReintegrar(repaymentEntity.getCalculatedAmount().toString());
        initialCapture.setMontoSemana(repaymentEntity.getWeekAmountValue().toString());
        initialCapture.setNss(clientEntity.getNss());
        initialCapture.setNumAsesor(agentEntity.getAgentCode());
        initialCapture.setNumAsesorConsar(String.valueOf(agentEntity.getConsarKey()));
        initialCapture.setNumCuenta(clientEntity.getAccountNumber());
        initialCapture.setResolutionNumber(repaymentEntity.getResolutionNumber());
        initialCapture.setSemMaxReitegrar(repaymentEntity.getMaxWeeksRepayment().toString());
        initialCapture.setSemPrevReintegrados(repaymentEntity.getPreDiscountedWeeks().toString());
        initialCapture.setSemSolReintegrar(repaymentEntity.getRequestedWeeks().toString());
        initialCapture.setUsuCre(agentEntity.getAgentCode());
        initialCapture.setWithdrawalDate(DateUtils.parseDate(Constants.DATE_FORMAT_1, Constants.DATE_FORMAT_5, repaymentEntity.getTrdDate().toDate()));

        request.setInitialCapture(initialCapture);

        return request;
    }

    public InsertClientRequest createInsertClientRequest(ClientEntity clientEntity, AgentEntity agentEntity){
        InsertClientRequest request = new InsertClientRequest();
        InsertClientRequest.InsertClient insertClient = new InsertClientRequest.InsertClient();

        insertClient.setCellphone(clientEntity.getCellPhone());
        insertClient.setColony(clientEntity.getNeighborhood());
        insertClient.setCurp(clientEntity.getCurp());
        insertClient.setEmail(clientEntity.getPreferentialEmail());
        insertClient.setExternalNum("0");
        insertClient.setIdPersona(String.valueOf(clientEntity.getPersonId()));
        insertClient.setAccountNumber(clientEntity.getAccountNumber());
        insertClient.setInternalNum("");
        insertClient.setLastName(clientEntity.getFatherLastName());
        insertClient.setSurName(clientEntity.getMotherLastName());
        insertClient.setName(clientEntity.getName());
        insertClient.setMunicipality(clientEntity.getTown());
        insertClient.setNss(clientEntity.getNss());
        insertClient.setPhone(clientEntity.getPhone());
        insertClient.setRfc(clientEntity.getRfc());
        insertClient.setState(clientEntity.getFederalEntity());
        insertClient.setStreet(clientEntity.getStreet());
        insertClient.setTypeClient(String.valueOf(clientEntity.getClientTypeIndicatorValue()));
        insertClient.setZipCode(String.valueOf(clientEntity.getPostalCode()));
        insertClient.setUsuCre(agentEntity.getAgentCode());

        request.setInsertClientRequest(insertClient);

        return request;
    }

    public GetClientData360Request  createGetClientDataOP360Request(ClientEntity clientEntity){
        GetClientData360Request request = new GetClientData360Request();
        GetClientData360Request.ConsultarTrabajador getClient = new GetClientData360Request.ConsultarTrabajador();
        getClient.setNss(clientEntity.getNss());
        getClient.setIdCliente("4");
        getClient.setIdServicio("761");
        getClient.setIdEbusiness("12");

        request.setConsultarTrabajador(getClient);
        return request;
    }

    public ApplicantTypeRequest createGetApplicantTypesRequest(ClientEntity clientEntity, ProcedureEntity procedureEntity){
        ApplicantTypeRequest request = new ApplicantTypeRequest();
        ApplicantTypeRequest.TipoSolicitanteRequest applicantRequest = new ApplicantTypeRequest.TipoSolicitanteRequest();

        applicantRequest.setNumCta(clientEntity.getAccountNumber());
        applicantRequest.setTipoCliente(String.valueOf(clientEntity.getClientTypeIndicatorValue()));
        applicantRequest.setProceso(procedureEntity.getIdProcess().toString());
        applicantRequest.setSubProceso(procedureEntity.getIdSubProcess().toString());

        request.setTipoSolicitanteRequest(applicantRequest);
        return request;
    }

    public ValCoexistenceNCIRequest createValCoexistenceNciRequest(ClientEntity clientEntity){
        ValCoexistenceNCIRequest request = new ValCoexistenceNCIRequest();
        ValCoexistenceNCIRequest.CoexistenceNCIRequest coexistenceRequest = new ValCoexistenceNCIRequest.CoexistenceNCIRequest();

        List<ValCoexistenceNCIRequest.SubCta> subCtaList = new ArrayList<>();
        ValCoexistenceNCIRequest.SubCta subCta = new ValCoexistenceNCIRequest.SubCta();
        subCta.setIdSubcuenta("151");
        subCta.setIdTipoMonto(184);
        subCta.setMonto(0D);
        subCtaList.add(subCta);

        ValCoexistenceNCIRequest.DatosSubcta subCtaData = new ValCoexistenceNCIRequest.DatosSubcta();
        subCtaData.setSubcuenta(subCtaList);

        coexistenceRequest.setIdProceso(Constants.ID_PROCESS.toString());
        coexistenceRequest.setIdSaldoOpera("12");
        coexistenceRequest.setIdSubProceso(Constants.ID_SUB_PROCESS.toString());
        coexistenceRequest.setIdTipoMovimiento(Constants.ID_MOVEMENT_TYPE.toString());
        coexistenceRequest.setNumCuentaIndividual(clientEntity.getAccountNumber());
        coexistenceRequest.setDatosSubcta(subCtaData);

        request.setConsultaConvivenciaCompletaComunNCIRequest(coexistenceRequest);
        return request;
    }

    public GetRepaymentEventsRequest createGetRepaymentEventsRequest(ClientEntity clientEntity){
        GetRepaymentEventsRequest request = new GetRepaymentEventsRequest();
        GetRepaymentEventsRequest.RequestHistoric requestHistoric = new GetRepaymentEventsRequest.RequestHistoric();
        requestHistoric.setAforeKey(Constants.ID_PROFUTURO_AFORE_KEY.toString());
        requestHistoric.setNss(clientEntity.getNss());
        request.setRequestHistoric(requestHistoric);
        return request;
    }

    public CalculateRepaymentRequest createCalculateRepaymentRequest(RepaymentEntity repaymentEntity){
        CalculateRepaymentRequest.CalculateRepayment calculateRepayment = new CalculateRepaymentRequest.CalculateRepayment();
        calculateRepayment.setClaveAfore(repaymentEntity.getAforeKey());
        calculateRepayment.setFechaRetiro(DateUtils.parseDate(Constants.DATE_FORMAT_1, Constants.DATE_FORMAT_5, repaymentEntity.getTrdDate().toDate()));
        calculateRepayment.setNssTrabajador(repaymentEntity.getNss());
        calculateRepayment.setNumeroResolucion(repaymentEntity.getResolutionNumber());
        calculateRepayment.setNumeroSemanasReintegrar(repaymentEntity.getRequestedWeeks().toString());

        CalculateRepaymentRequest request = new CalculateRepaymentRequest();
        request.setCalcularReintegro(calculateRepayment);

        return request;
    }

    public ValidateAuthFolioRequest createValidateAuthFolioRequest(ClientEntity clientEntity, ProcedureEntity procedureEntity){
        ValidateAuthFolioRequest request = new ValidateAuthFolioRequest();
        ValidateAuthFolioRequest.ValidateAuthFolioIn valRequest = new ValidateAuthFolioRequest.ValidateAuthFolioIn();
        valRequest.setProceso(Constants.ID_PROCESS_AUTH_FOLIO);
        valRequest.setCurpTitular(clientEntity.getCurp());
        valRequest.setFolioAutenticacion(procedureEntity.getAuthFolio());

        request.setValidateAuthFolioIn(valRequest);
        return request;
    }

    public GetRepaymentSolicitudeDocRequest createGetRepaymentSolicitudeRequest(AgentEntity agentEntity, ClientEntity clientEntity, ProcedureEntity procedureEntity, RepaymentEntity repaymentEntity, DocumentEntity documentEntity){
        GetRepaymentSolicitudeDocRequest request = new GetRepaymentSolicitudeDocRequest();
        request.setApellidoMaterno(clientEntity.getMotherLastName());
        request.setApellidoPaterno(clientEntity.getFatherLastName());
        request.setAvisoPrivacidad(Constants.PRIVATE_ADVERTISEMENT);
        request.setCurp(clientEntity.getCurp());
        request.setDesdSucursal(agentEntity.getBranchOfficeName());
        request.setFechSol(DateUtils.getFormatedTodayDate(Constants.DATE_FORMAT_1));
        request.setFecRetiro(repaymentEntity.getTrdDate().toDate());
        request.setFolio(procedureEntity.getProcedureFolio());
        request.setImagenFirmaAfore(documentEntity.getSignatureHolders().get(agentEntity.getFullName()));
        request.setImagenFirmaCliente(documentEntity.getSignatureHolders().get(clientEntity.getFullName()));
        request.setMaxMontoReintegrar(Utils.formatAmountToMoney(repaymentEntity.getWeekAmountValue() * repaymentEntity.getMaxWeeksRepayment()));
        request.setMaxSemanReintegrar(repaymentEntity.getMaxWeeksRepayment().toString());
        request.setMontoReintegrar(Utils.formatAmountToMoney(repaymentEntity.getCalculatedAmount()));
        request.setNombre(clientEntity.getName());
        request.setNombreFirmaCliente(clientEntity.getFullName());
        request.setNombreFirmaReceptorAfore(agentEntity.getFullName());
        request.setNss(clientEntity.getNss());
        request.setNumCuenta(clientEntity.getAccountNumber());
        request.setNumSucursal(String.valueOf(agentEntity.getBranchOfficeNumber()));
        request.setSemanDescontadas(repaymentEntity.getDiscountedWeeks().toString());
        request.setSemanReintegrar(repaymentEntity.getRequestedWeeks().toString());

        return request;
    }

    public GetLetterRepaymentDocRequest createGetLetterRepaymentRequest(ClientEntity clientEntity, ProcedureEntity procedureEntity, RepaymentEntity repaymentEntity){
        GetLetterRepaymentDocRequest request = new GetLetterRepaymentDocRequest();
        request.setAnio(String.valueOf(procedureEntity.getProcedureDate().getYear()));
        request.setAvisoPrivacidad(Constants.PRIVATE_ADVERTISEMENT);
        request.setColonia(clientEntity.getNeighborhood());
        request.setConcepto(Constants.DEPOSIT_DATA_CONCEPT);
        request.setCp(String.valueOf(clientEntity.getPostalCode()));
        request.setCurp(clientEntity.getCurp());
        request.setDia(String.valueOf(procedureEntity.getProcedureDate().getDay()));
        request.setDiasHabiles(Constants.DEPOSIT_DATA_WORKDAYS_VALIDITY);
        request.setDireccion(clientEntity.getStreet());
        request.setEstado(clientEntity.getFederalEntity());
        request.setFolio(procedureEntity.getProcedureFolio());
        request.setMes(String.valueOf(procedureEntity.getProcedureDate().getMonthName()));
        request.setMonto(Utils.formatAmountToMoney(repaymentEntity.getCalculatedAmount()));
        request.setNombreCompleto(clientEntity.getFullName());
        request.setNss(clientEntity.getNss());
        request.setNumConvenio(Constants.DEPOSIT_DATA_AGREEMENT);
        request.setNumCuenta(clientEntity.getAccountNumber());
        request.setReferencia(clientEntity.getAccountNumber());
        request.setSemanasaReintegrar(repaymentEntity.getRequestedWeeks().toString());

        return request;
    }


    public InsertInitialRulingRequest createInsertInitialRulingRequest(ProcedureEntity procedureEntity){
        InsertInitialRulingRequest.Iniciar startReq = new InsertInitialRulingRequest.Iniciar();

        startReq.setFolio(procedureEntity.getProcedureFolio());
        startReq.setFolioBitacora(procedureEntity.getBinnacleFolio());
        startReq.setIdTipoTramite(procedureEntity.getIdSubProcess().toString());
        startReq.setNombreTipoTramite(Constants.SUB_PROCESS_NAME);
        startReq.setIdProceso(procedureEntity.getIdProcess().toString());
        startReq.setNombreProceso(Constants.PROCESS_NAME);

        InsertInitialRulingRequest request = new InsertInitialRulingRequest();
        request.setIniciar(startReq);

        return request;
    }

    public GetRecommendedFingersRequest createGetRecommendedFingersRequest(ClientEntity clientEntity){
        GetRecommendedFingersRequest request = new GetRecommendedFingersRequest();
        GetRecommendedFingersRequest.Req req = new GetRecommendedFingersRequest.Req();
        req.setCurp(clientEntity.getCurp());
        request.setReq(req);

        return request;
    }

    public GetVoluntarySealRequest createGetVoluntarySealRequest(ClientEntity clientEntity, AgentEntity agentEntity, ProcedureEntity procedureEntity, List<FingerPrintEntity> fingerPrintEntities){
        GetVoluntarySealRequest.Device device = new GetVoluntarySealRequest.Device();
        device.setDeviceIdentificationId(fingerPrintEntities.get(0).getSerialNumber());
        device.setAcquisitionProfileCode(Constants.REQUEST_BIOMETRIC_PROFILE_CODE);
        device.setCaptureResolution(Constants.REQUEST_BIOMETRIC_RESOLUTION);
        device.setImageScaleUnitsCode(Constants.REQUEST_BIOMETRIC_SCALE_UNITS);

        GetVoluntarySealRequest.ProcedureInformation procedureInformation = new GetVoluntarySealRequest.ProcedureInformation();
        procedureInformation.setIdTramite(procedureEntity.getProcedureFolio());
        procedureInformation.setNumeroEmpleado(agentEntity.getAgentCode());
        procedureInformation.setIdTipoSello(Constants.REQUEST_BIOMETRIC_SEAL_TYPE);
        procedureInformation.setIndicadorSelloNuevo(true);

        List<GetVoluntarySealRequest.FingerPrint> fingerPrintsAgent = new ArrayList<>();
        List<GetVoluntarySealRequest.FingerPrint> fingerPrintsClient = new ArrayList<>();
        GetVoluntarySealRequest.FingerPrint fingerPrintReq;

        for (FingerPrintEntity fingerEntity : fingerPrintEntities){
            if (fingerEntity.getIsEmployee() == 1){
                fingerPrintReq = new GetVoluntarySealRequest.FingerPrint();
                fingerPrintReq.setBase64data(fingerEntity.getBase64Image());
                fingerPrintReq.setFechaCaptura(fingerEntity.getCaptureDate());
                fingerPrintReq.setFingerPositionCode(String.valueOf(fingerEntity.getFingerPositionCode()));
                fingerPrintReq.setImageHashValue(fingerEntity.getImageHashValue());
                fingerPrintReq.setMotivoSinHuella(fingerEntity.getAbsenceReason());
                fingerPrintReq.setNistQualityMeasure(fingerEntity.getNistQualityMeasure());
                fingerPrintsAgent.add(fingerPrintReq);
            }else {
                fingerPrintReq = new GetVoluntarySealRequest.FingerPrint();
                fingerPrintReq.setBase64data(fingerEntity.getBase64Image());
                fingerPrintReq.setFechaCaptura(fingerEntity.getCaptureDate());
                fingerPrintReq.setFingerPositionCode(String.valueOf(fingerEntity.getFingerPositionCode()));
                fingerPrintReq.setImageHashValue(fingerEntity.getImageHashValue());
                fingerPrintReq.setMotivoSinHuella(fingerEntity.getAbsenceReason());
                fingerPrintReq.setNistQualityMeasure(fingerEntity.getNistQualityMeasure());
                fingerPrintsClient.add(fingerPrintReq);
            }
        }

        GetVoluntarySealRequest.SealInformation sealInformation = new GetVoluntarySealRequest.SealInformation();
        sealInformation.setAgentFingerPrintList(fingerPrintsAgent);
        sealInformation.setCanalServicio(Constants.REQUEST_BIOMETRIC_SERVICE_CHANNEL);
        sealInformation.setClientFingerPrintList(fingerPrintsClient);
        sealInformation.setCurpEmpleado(agentEntity.getCurp());
        sealInformation.setCurpSolicitante("");
        sealInformation.setCurpTrabajador(clientEntity.getCurp());
        sealInformation.setDevice(device);
        sealInformation.setFechaSolicitud(DateUtils.getFormatedTodayDate(Constants.DATE_FORMAT_6));
        sealInformation.setFolioSolicitud(procedureEntity.getProcedureFolio());
        sealInformation.setNumeroOficina(Constants.ID_PROFUTURO_AFORE_KEY.toString());
        sealInformation.setServiceId(Constants.REQUEST_BIOMETRIC_SERVICE_ID_TRD);
        sealInformation.setTipoSolicitante(Constants.REQUEST_BIOMETRIC_APPLICANT_TYPE);
        sealInformation.setTokenMovil("");
        sealInformation.setTransactionDate(DateUtils.getFormatedTodayDate(Constants.DATE_FORMAT_6));

        GetVoluntarySealRequest.SealRequest sealRequest = new GetVoluntarySealRequest.SealRequest();
        sealRequest.setSealInformation(sealInformation);
        sealRequest.setProcedureInformation(procedureInformation);

        GetVoluntarySealRequest request = new GetVoluntarySealRequest();
        request.setSealRequest(sealRequest);

        return request;
    }

    public SaveVoluntarySealRequest createSaveVoluntarySealRequest(ClientEntity clientEntity, AgentEntity agentEntity, ProcedureEntity procedureEntity){
        SaveVoluntarySealRequest request = new SaveVoluntarySealRequest();
        SaveVoluntarySealRequest.SaveVoluntarySealBody body = new SaveVoluntarySealRequest.SaveVoluntarySealBody();
        body.setClaveAfore(Constants.ID_PROFUTURO_AFORE_KEY.toString());
        body.setClaveConsar(String.valueOf(agentEntity.getConsarKey()));
        body.setCurpEmpleado(agentEntity.getCurp());
        body.setCurpTrabajador(clientEntity.getCurp());
        body.setFechaGeneracion(DateUtils.getFormatedTodayDate(Constants.DATE_FORMAT_7));
        body.setFechaVigencia(DateUtils.parseDateToString(DateUtils.getTomorrowDate(), Constants.DATE_FORMAT_7));
        body.setIdTramite(procedureEntity.getProcedureFolio());
        body.setNumeroEmpleado(agentEntity.getAgentCode());
        body.setIdEstatusSello(procedureEntity.getIdStatusVoluntarySeal());
        body.setResultadoVerificacion(procedureEntity.getVerificationResultSeal());
        body.setSelloVerificacion(procedureEntity.getVoluntarySeal());
        body.setIdTipoSello(Constants.REQUEST_BIOMETRIC_SEAL_TYPE);

        request.setSaveVoluntarySealBody(body);

        return request;
    }

    public MarkNciCoexistenceRequest createMarkNciCoexistenceRequest(ClientEntity clientEntity, AgentEntity agentEntity, ProcedureEntity procedureEntity){
        MarkNciCoexistenceRequest request = new MarkNciCoexistenceRequest();
        request.setFolio(procedureEntity.getBinnacleFolio());
        request.setIdProceso(procedureEntity.getIdProcess().toString());
        request.setIdSubProceso(procedureEntity.getIdSubProcess().toString());
        request.setNumCuentaIndividual(clientEntity.getAccountNumber());
        request.setIdSaldoOpera("12");
        request.setTipoMovimiento("181");
        request.setIdSubEtapa("25");
        request.setUsuario(agentEntity.getAgentCode());
        request.setFlgSaltaIntgy("1");
        return request;
    }

    public UploadFilesToFileNetRequest createUploadFilesFilenetRequest(ProcedureEntity procedureEntity, List<DocumentEntity> documents){
        List<UploadFilesToFileNetRequest.DocumentName> documentNames;
        documentNames = new ArrayList<>();

        for (DocumentEntity document : documents){
            String documentType;

            if (document.getDocumentType() == Constants.DOCUMENT_TYPE_PDF) {
                documentType = ".pdf";
            } else {
                documentType = ".jpg";
            }

            UploadFilesToFileNetRequest.DocumentName documentName;
            documentName = new UploadFilesToFileNetRequest.DocumentName();
            documentName.setBase64(Base64Utils.encodeFile(document.getFile()));
            documentName.setName(document.getDocumentKey() + "_" + document.getDocumentName() + "_" + "1" + documentType);

            documentNames.add(documentName);
        }

        UploadFilesToFileNetRequest.ImageData imageData;
        imageData = new UploadFilesToFileNetRequest.ImageData();
        imageData.setBinnacleFolio(procedureEntity.getBinnacleFolio());
        imageData.setDocuments(documentNames);
        imageData.setProcessId(Constants.ID_PROCESS_REPAYMENT_FILENET);
        imageData.setRetry(false);
        imageData.setTotal((long) documentNames.size());

        UploadFilesToFileNetRequest.Request request;
        request = new UploadFilesToFileNetRequest.Request();
        request.setImageData(imageData);

        UploadFilesToFileNetRequest uploadFilesToFileNetRequest;
        uploadFilesToFileNetRequest = new UploadFilesToFileNetRequest();
        uploadFilesToFileNetRequest.setRequest(request);

        return uploadFilesToFileNetRequest;
    }

    public UpdatePaperworkRequest createUpdateProcedureRequest(AgentEntity agentEntity, ProcedureEntity procedureEntity){
        UpdatePaperworkRequest request = new UpdatePaperworkRequest();

        UpdatePaperworkRequest.ActualizarTramite updatePaperwork = new UpdatePaperworkRequest.ActualizarTramite();
        updatePaperwork.setFolio(procedureEntity.getBinnacleFolio());
        updatePaperwork.setFolioTramite(procedureEntity.getProcedureFolio());
        updatePaperwork.setIdEstatusTramite(Constants.STATUS_SUB_STAGE_CAPTURED.toString());
        updatePaperwork.setFechEstatus(DateUtils.getFormatedTodayDate(Constants.DATE_FORMAT_2));
        updatePaperwork.setSelloVol(procedureEntity.getVoluntarySeal());
        updatePaperwork.setIdEstatusSello(procedureEntity.getIdStatusVoluntarySeal());
        updatePaperwork.setUsuAct(agentEntity.getAgentCode());
        updatePaperwork.setFehAct(DateUtils.getFormatedTodayDate(Constants.DATE_FORMAT_2));

        request.setActualizarTramite(updatePaperwork);
        return request;
    }
    public SendEmailRequest createSendEmailRequest(AgentEntity agentEntity, ClientEntity clientEntity, ProcedureEntity procedureEntity, List<DocumentEntity> documents, NotificationChannelEntity notificationChannel){
        SendEmailRequest request = new SendEmailRequest();

        return request;
    }

    public InsertProcessBinnacleRequest createInsertBinnacleRequest(AgentEntity agentEntity, ProcedureEntity procedureEntity){
        InsertProcessBinnacleRequest request = new InsertProcessBinnacleRequest();
        request.setFolio(procedureEntity.getBinnacleFolio());
        request.setIdEstatus(Constants.BINNACLE_STATUS_CLOSED);
        request.setIdEtapa(Constants.ID_STAGE_RECEPTION);
        request.setIdResultado(Constants.ID_RESULT_BINNACLE);
        request.setIdSubetapa(Constants.ID_SUB_STAGE_CAPTURE);
        request.setIdSubproceso(Constants.ID_SUB_PROCESS);
        request.setUsuario(agentEntity.getAgentCode());

        return request;
    }

}
