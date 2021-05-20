package com.reintegro.profuturo.app.api.vo;

import com.google.gson.annotations.SerializedName;

import java.util.List;

public class GetBranchOfficesResponse {
    public class BranchOffice {
        @SerializedName("calle") private String street;
        @SerializedName("ciudad") private String city;
        @SerializedName("colonia") private String neighborhood;
        @SerializedName("delegacionMunicipio") private String town;
        @SerializedName("distancia") private Long distance;
        @SerializedName("entidadFederativa") private String federalEntity;
        @SerializedName("estado") private String state;
        @SerializedName("fehAct") private String updateDate;
        @SerializedName("fehCre") private String creationDate;
        @SerializedName("idCc") private Long costCenterId;
        @SerializedName("idSucursal") private Long branchOfficeId;
        @SerializedName("latitud") private Double latitude;
        @SerializedName("longitud") private Double longitude;
        @SerializedName("nombreSucursal") private String branchOfficeName;
        @SerializedName("usuAct") private String updateUser;
        @SerializedName("usuCre") private String creationUser;

        public String getStreet() {
            return street;
        }

        public String getCity() {
            return city;
        }

        public String getNeighborhood() {
            return neighborhood;
        }

        public String getTown() {
            return town;
        }

        public Long getDistance() {
            return distance;
        }

        public String getFederalEntity() {
            return federalEntity;
        }

        public String getState() {
            return state;
        }

        public String getUpdateDate() {
            return updateDate;
        }

        public String getCreationDate() {
            return creationDate;
        }

        public Long getCostCenterId() {
            return costCenterId;
        }

        public Long getBranchOfficeId() {
            return branchOfficeId;
        }

        public Double getLatitude() {
            return latitude;
        }

        public Double getLongitude() {
            return longitude;
        }

        public String getBranchOfficeName() {
            return branchOfficeName;
        }

        public String getUpdateUser() {
            return updateUser;
        }

        public String getCreationUser() {
            return creationUser;
        }
    }

    @SerializedName("encontrada") private Boolean located;
    @SerializedName("mensaje") private String message;
    @SerializedName("success") private Boolean success;
    @SerializedName("sucursales") private List<BranchOffice> branchOffices;

    public Boolean isLocated() {
        return located;
    }

    public String getMessage() {
        return message;
    }

    public Boolean isSuccess() {
        return success;
    }

    public List<BranchOffice> getBranchOffices() {
        return branchOffices;
    }
}
