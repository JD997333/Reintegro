package com.reintegro.profuturo.app.api;

import com.reintegro.profuturo.app.BuildConfig;
import com.reintegro.profuturo.app.api.vo.GetAgentAssignedBranchOfficeRequest;
import com.reintegro.profuturo.app.api.vo.GetAgentAssignedBranchOfficeResponse;
import com.reintegro.profuturo.app.api.vo.GetAgentInformationRequest;
import com.reintegro.profuturo.app.api.vo.GetAgentInformationResponse;
import com.reintegro.profuturo.app.api.vo.GetBranchOfficesResponse;
import com.reintegro.profuturo.app.api.vo.GetClientDataResponse;
import com.reintegro.profuturo.app.api.vo.GetClientImageRequest;
import com.reintegro.profuturo.app.api.vo.GetClientImageResponse;
import com.reintegro.profuturo.app.api.vo.SaveLoginRequest;
import com.reintegro.profuturo.app.api.vo.SaveLoginResponse;
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
}
