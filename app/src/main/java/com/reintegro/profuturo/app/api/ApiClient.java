package com.reintegro.profuturo.app.api;

import com.reintegro.profuturo.app.BuildConfig;
import com.reintegro.profuturo.app.api.vo.ApplicantTypeRequest;
import com.reintegro.profuturo.app.api.vo.ApplicantTypeResponse;
import com.reintegro.profuturo.app.api.vo.CalculateRepaymentRequest;
import com.reintegro.profuturo.app.api.vo.CalculateRepaymentResponse;
import com.reintegro.profuturo.app.api.vo.GetAgentAssignedBranchOfficeRequest;
import com.reintegro.profuturo.app.api.vo.GetAgentAssignedBranchOfficeResponse;
import com.reintegro.profuturo.app.api.vo.GetAgentInformationRequest;
import com.reintegro.profuturo.app.api.vo.GetAgentInformationResponse;
import com.reintegro.profuturo.app.api.vo.GetBranchOfficesResponse;
import com.reintegro.profuturo.app.api.vo.GetClientData360Request;
import com.reintegro.profuturo.app.api.vo.GetClientData360Response;
import com.reintegro.profuturo.app.api.vo.GetClientDataResponse;
import com.reintegro.profuturo.app.api.vo.GetClientImageRequest;
import com.reintegro.profuturo.app.api.vo.GetClientImageResponse;
import com.reintegro.profuturo.app.api.vo.GetDocumentsResponse;
import com.reintegro.profuturo.app.api.vo.GetLetterRepaymentDocRequest;
import com.reintegro.profuturo.app.api.vo.GetLetterRepaymentDocResponse;
import com.reintegro.profuturo.app.api.vo.GetRepaymentEventsRequest;
import com.reintegro.profuturo.app.api.vo.GetRepaymentEventsResponse;
import com.reintegro.profuturo.app.api.vo.GetRepaymentSolicitudeDocRequest;
import com.reintegro.profuturo.app.api.vo.GetRepaymentSolicitudeDocResponse;
import com.reintegro.profuturo.app.api.vo.InsertClientRequest;
import com.reintegro.profuturo.app.api.vo.InsertClientResponse;
import com.reintegro.profuturo.app.api.vo.InsertInitialRulingRequest;
import com.reintegro.profuturo.app.api.vo.InsertInitialRulingResponse;
import com.reintegro.profuturo.app.api.vo.SaveInitialCaptureRequest;
import com.reintegro.profuturo.app.api.vo.SaveInitialCaptureResponse;
import com.reintegro.profuturo.app.api.vo.SaveLoginRequest;
import com.reintegro.profuturo.app.api.vo.SaveLoginResponse;
import com.reintegro.profuturo.app.api.vo.ValCoexistenceNCIRequest;
import com.reintegro.profuturo.app.api.vo.ValCoexistenceNCIResponse;
import com.reintegro.profuturo.app.api.vo.ValidateAuthFolioRequest;
import com.reintegro.profuturo.app.api.vo.ValidateAuthFolioResponse;
import com.reintegro.profuturo.app.util.Constants;

import retrofit2.Call;
import retrofit2.http.Body;
import retrofit2.http.GET;
import retrofit2.http.Headers;
import retrofit2.http.POST;
import retrofit2.http.Query;

public interface ApiClient {
    @Headers({Constants.HTTP_HEADER_AUTHORIZATION})
    @POST(Constants.URL_BASE + BuildConfig.PORT_4 + Constants.URN_GET_AGENT_INFORMATION)
    Call<GetAgentInformationResponse> getAgentInformation(
            @Body GetAgentInformationRequest request
    );

    @Headers({Constants.HTTP_HEADER_AUTHORIZATION})
    @POST(Constants.URL_BASE + BuildConfig.PORT_4 + Constants.URN_GET_AGENT_ASSIGNED_BRANCH_OFFICE)
    Call<GetAgentAssignedBranchOfficeResponse> getAgentAssignedBranchOffice(
        @Body GetAgentAssignedBranchOfficeRequest request
    );

    @GET(Constants.URL_BASE + BuildConfig.PORT_1 + Constants.URN_GET_BRANCH_OFFICES)
    @Headers({Constants.HTTP_HEADER_AUTHORIZATION})
    Call<GetBranchOfficesResponse> getBranchOffices(
        @Query("idSucursal") Long branchOfficeId,
        @Query("latitud") Double latitude,
        @Query("longitud") Double longitude
    );

    @GET(Constants.URL_BASE + BuildConfig.PORT_1 + Constants.URN_GET_CLIENT_DATA)
    @Headers({Constants.HTTP_HEADER_AUTHORIZATION})
    Call<GetClientDataResponse> getClientData(
        @Query("numeroCuenta") String accountNumber,
        @Query("curp") String curp,
        @Query("nss") String nss
    );

    @Headers({Constants.HTTP_HEADER_AUTHORIZATION})
    @POST(Constants.URL_BASE + BuildConfig.PORT_1 + Constants.URN_GET_CLIENT_IMAGE)
    Call<GetClientImageResponse> getClientImage(
        @Body GetClientImageRequest request
    );


    @Headers({Constants.HTTP_HEADER_AUTHORIZATION})
    @POST(Constants.URL_BASE + BuildConfig.PORT_1 + Constants.URN_SAVE_LOGIN)
    Call<SaveLoginResponse> saveLogin(
        @Body SaveLoginRequest request
    );

    @Headers({Constants.HTTP_HEADER_AUTHORIZATION})
    @POST(Constants.URL_BASE + BuildConfig.PORT_3 + Constants.URN_SAVE_INITIAL_CAPTURE)
    Call<SaveInitialCaptureResponse> saveInitialCapture(@Body SaveInitialCaptureRequest request);

    @Headers({Constants.HTTP_HEADER_AUTHORIZATION})
    @POST(Constants.URL_BASE + BuildConfig.PORT_1 + Constants.URN_INSERT_CLIENT)
    Call<InsertClientResponse> insertClient(@Body InsertClientRequest request);

    @Headers({Constants.HTTP_HEADER_AUTHORIZATION})
    @POST(Constants.URL_BASE + BuildConfig.PORT_2 + Constants.URN_SERVICE_OP360)
    Call<GetClientData360Response> getClientDataOP360(@Body GetClientData360Request request);

    @Headers({Constants.HTTP_HEADER_AUTHORIZATION})
    @POST(Constants.URL_BASE + BuildConfig.PORT_1 + Constants.URN_GET_APPLICANT_TYPES)
    Call<ApplicantTypeResponse> getApplicantTypes(@Body ApplicantTypeRequest request);

    @Headers({Constants.HTTP_HEADER_AUTHORIZATION})
    @POST(Constants.URL_BASE + BuildConfig.PORT_1 + Constants.URN_VAL_COEXISTENCE)
    Call<ValCoexistenceNCIResponse> valCoexistenceNci(@Body ValCoexistenceNCIRequest request);

    @Headers({Constants.HTTP_HEADER_AUTHORIZATION})
    @POST(Constants.URL_BASE + BuildConfig.PORT_3 + Constants.URN_GET_REPAYMENT_EVENTS)
    Call<GetRepaymentEventsResponse> getRepaymentEvents(@Body GetRepaymentEventsRequest request);

    @Headers({Constants.HTTP_HEADER_AUTHORIZATION})
    @POST(Constants.URL_BASE + BuildConfig.PORT_3 + Constants.URN_CALCULATE_REPAYMENT)
    Call<CalculateRepaymentResponse> calculateRepayment(@Body CalculateRepaymentRequest request);

    @Headers({Constants.HTTP_HEADER_AUTHORIZATION})
    @POST(Constants.URL_BASE + BuildConfig.PORT_2 + Constants.URN_VALIDATE_AUTH_FOLIO)
    Call<ValidateAuthFolioResponse> validateAuthFolio(@Body ValidateAuthFolioRequest request);

    @Headers({Constants.HTTP_HEADER_AUTHORIZATION})
    @GET(Constants.URL_BASE + BuildConfig.PORT_1 + Constants.URN_GET_DOCUMENTS)
    Call<GetDocumentsResponse> getDocuments(
        @Query("clasificacionRetiro") Integer idProcess,
        @Query("numeroBeneficiarios") Integer applicantType,
        @Query("tipoRetiro") Integer idSubProcess);

    @Headers({Constants.HTTP_HEADER_AUTHORIZATION})
    @POST(Constants.URL_BASE + BuildConfig.PORT_3 + Constants.URN_GET_REPAYMENT_SOLICITUDE_DOC)
    Call<GetRepaymentSolicitudeDocResponse> getRepaymentSolicitudeDocument(@Body GetRepaymentSolicitudeDocRequest request);

    @Headers({Constants.HTTP_HEADER_AUTHORIZATION})
    @POST(Constants.URL_BASE + BuildConfig.PORT_3 + Constants.URN_GET_LETTER_REPAYMENT_DOC)
    Call<GetLetterRepaymentDocResponse> getLetterRepaymentDocument(@Body GetLetterRepaymentDocRequest request);

    @Headers({Constants.HTTP_HEADER_AUTHORIZATION})
    @POST(Constants.URL_BASE + BuildConfig.PORT_3 + Constants.URN_SAVE_INITIAL_CAPTURE)
    Call<InsertInitialRulingResponse> insertInitialRuling(@Body InsertInitialRulingRequest request);
}
