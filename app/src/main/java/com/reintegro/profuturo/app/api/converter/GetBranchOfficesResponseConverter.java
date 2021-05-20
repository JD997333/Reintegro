package com.reintegro.profuturo.app.api.converter;

import com.reintegro.profuturo.app.api.vo.GetBranchOfficesResponse;
import com.reintegro.profuturo.app.data.entity.BranchOfficeEntity;
import com.reintegro.profuturo.app.util.Constants;
import com.reintegro.profuturo.app.util.TypeUtils;

import java.util.ArrayList;
import java.util.List;

public class GetBranchOfficesResponseConverter extends ResponseConverter<GetBranchOfficesResponse, List<BranchOfficeEntity>> {
    @Override
    public List<BranchOfficeEntity> convert(GetBranchOfficesResponse response) {
        List<BranchOfficeEntity> branchOfficeEntities;
        branchOfficeEntities = new ArrayList<>();

        for (GetBranchOfficesResponse.BranchOffice branchOffice : response.getBranchOffices()) {
            BranchOfficeEntity branchOfficeEntity;
            branchOfficeEntity = new BranchOfficeEntity();
            branchOfficeEntity.setBranchOfficeId(TypeUtils.getValueOrDefault(branchOffice.getBranchOfficeId()));
            branchOfficeEntity.setBranchOfficeName(TypeUtils.getValueOrDefault(branchOffice.getBranchOfficeName()));
            branchOfficeEntity.setCity(TypeUtils.getValueOrDefault(branchOffice.getCity()));
            branchOfficeEntity.setCostCenterId(TypeUtils.getValueOrDefault(branchOffice.getCostCenterId()));
            branchOfficeEntity.setCreationDate(DateResponseConverter.convertFromResponse(branchOffice.getCreationDate(), Constants.DATE_FORMAT_3));
            branchOfficeEntity.setCreationUser(TypeUtils.getValueOrDefault(branchOffice.getCreationUser()));
            branchOfficeEntity.setDistance(TypeUtils.getValueOrDefault(branchOffice.getDistance()));
            branchOfficeEntity.setFederalEntity(TypeUtils.getValueOrDefault(branchOffice.getFederalEntity()));
            branchOfficeEntity.setLatitude(TypeUtils.getValueOrDefault(branchOffice.getLatitude()));
            branchOfficeEntity.setLongitude(TypeUtils.getValueOrDefault(branchOffice.getLongitude()));
            branchOfficeEntity.setNeighborhood(TypeUtils.getValueOrDefault(branchOffice.getNeighborhood()));
            branchOfficeEntity.setState(TypeUtils.getValueOrDefault(branchOffice.getState()));
            branchOfficeEntity.setStreet(TypeUtils.getValueOrDefault(branchOffice.getStreet()));
            branchOfficeEntity.setTown(TypeUtils.getValueOrDefault(branchOffice.getTown()));
            branchOfficeEntity.setUpdateDate(DateResponseConverter.convertFromResponse(branchOffice.getUpdateDate(), Constants.DATE_FORMAT_3));
            branchOfficeEntity.setUpdateUser(TypeUtils.getValueOrDefault(branchOffice.getUpdateUser()));

            branchOfficeEntities.add(branchOfficeEntity);
        }

        return branchOfficeEntities;
    }
}
