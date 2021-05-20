package com.reintegro.profuturo.app.domain.converter;

import com.reintegro.profuturo.app.data.entity.BranchOfficeEntity;
import com.reintegro.profuturo.app.domain.dto.BranchOfficeDto;

import java.util.ArrayList;
import java.util.List;

public class BranchOfficeConverter {
    public static BranchOfficeEntity convertFromDto(BranchOfficeDto branchOfficeDto) {
        BranchOfficeEntity branchOfficeEntity;
        branchOfficeEntity= new BranchOfficeEntity();
        branchOfficeEntity.setBranchOfficeId(branchOfficeDto.getBranchOfficeId());
        branchOfficeEntity.setBranchOfficeName(branchOfficeDto.getBranchOfficeName());
        branchOfficeEntity.setCity(branchOfficeDto.getCity());
        branchOfficeEntity.setCostCenterId(branchOfficeDto.getCostCenterId());
        branchOfficeEntity.setCreationDate(DateConverter.convertFromDto(branchOfficeDto.getCreationDate()));
        branchOfficeEntity.setCreationUser(branchOfficeDto.getCreationUser());
        branchOfficeEntity.setDistance(branchOfficeDto.getDistance());
        branchOfficeEntity.setFederalEntity(branchOfficeDto.getFederalEntity());
        branchOfficeEntity.setId(branchOfficeDto.getId());
        branchOfficeEntity.setLatitude(branchOfficeDto.getLatitude());
        branchOfficeEntity.setLongitude(branchOfficeDto.getLongitude());
        branchOfficeEntity.setNeighborhood(branchOfficeDto.getNeighborhood());
        branchOfficeEntity.setState(branchOfficeDto.getState());
        branchOfficeEntity.setStreet(branchOfficeDto.getStreet());
        branchOfficeEntity.setTown(branchOfficeDto.getTown());
        branchOfficeEntity.setUpdateDate(DateConverter.convertFromDto(branchOfficeDto.getUpdateDate()));
        branchOfficeEntity.setUpdateUser(branchOfficeDto.getUpdateUser());

        return branchOfficeEntity;
    }

    public static List<BranchOfficeDto> convertFromEntities(List<BranchOfficeEntity> branchOfficeEntities) {
        List<BranchOfficeDto> branchOfficeDtos;
        branchOfficeDtos = new ArrayList<>();

        for (BranchOfficeEntity branchOfficeEntity : branchOfficeEntities) {
            BranchOfficeDto branchOfficeDto = new BranchOfficeDto();
            branchOfficeDto.setBranchOfficeId(branchOfficeEntity.getBranchOfficeId());
            branchOfficeDto.setBranchOfficeName(branchOfficeEntity.getBranchOfficeName());
            branchOfficeDto.setCity(branchOfficeEntity.getCity());
            branchOfficeDto.setCostCenterId(branchOfficeEntity.getCostCenterId());
            branchOfficeDto.setCreationDate(DateConverter.convertFromEntity(branchOfficeEntity.getCreationDate()));
            branchOfficeDto.setCreationUser(branchOfficeEntity.getCreationUser());
            branchOfficeDto.setDistance(branchOfficeEntity.getDistance());
            branchOfficeDto.setFederalEntity(branchOfficeEntity.getFederalEntity());
            branchOfficeDto.setId(branchOfficeEntity.getId());
            branchOfficeDto.setLatitude(branchOfficeEntity.getLatitude());
            branchOfficeDto.setLongitude(branchOfficeEntity.getLongitude());
            branchOfficeDto.setNeighborhood(branchOfficeEntity.getNeighborhood());
            branchOfficeDto.setState(branchOfficeEntity.getState());
            branchOfficeDto.setStreet(branchOfficeEntity.getStreet());
            branchOfficeDto.setTown(branchOfficeEntity.getTown());
            branchOfficeDto.setUpdateDate(DateConverter.convertFromEntity(branchOfficeEntity.getUpdateDate()));
            branchOfficeDto.setUpdateUser(branchOfficeEntity.getUpdateUser());

            branchOfficeDtos.add(branchOfficeDto);
        }

        return branchOfficeDtos;
    }
}
