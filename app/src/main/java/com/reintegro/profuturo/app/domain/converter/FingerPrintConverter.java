package com.reintegro.profuturo.app.domain.converter;

import com.reintegro.profuturo.app.data.entity.FingerPrintEntity;
import com.reintegro.profuturo.app.domain.dto.FingerPrintDto;

import java.util.ArrayList;
import java.util.List;

public class FingerPrintConverter {
    public static FingerPrintEntity convertFromDto(FingerPrintDto fingerPrintDto){
        FingerPrintEntity fingerPrintEntity = new FingerPrintEntity();
        fingerPrintEntity.setAbsenceReason(fingerPrintDto.getAbsenceReason());
        fingerPrintEntity.setBase64Image(fingerPrintDto.getBase64Image());
        fingerPrintEntity.setCaptureDate(fingerPrintDto.getCaptureDate());
        fingerPrintEntity.setFingerPositionCode(fingerPrintDto.getFingerPositionCode());
        fingerPrintEntity.setImageHashValue(fingerPrintDto.getImageHashValue());
        fingerPrintEntity.setIsEmployee(fingerPrintDto.getIsEmployee());
        fingerPrintEntity.setNistQualityMeasure(fingerPrintDto.getNistQualityMeasure());
        fingerPrintEntity.setSerialNumber(fingerPrintDto.getSerialNumber());

        return fingerPrintEntity;
    }

    public static FingerPrintDto convertFromEntity(FingerPrintEntity fingerPrintEntity){
        FingerPrintDto fingerPrintDto = new FingerPrintDto();
        fingerPrintDto.setAbsenceReason(fingerPrintEntity.getAbsenceReason());
        fingerPrintDto.setBase64Image(fingerPrintEntity.getBase64Image());
        fingerPrintDto.setCaptureDate(fingerPrintEntity.getCaptureDate());
        fingerPrintDto.setFingerPositionCode(fingerPrintEntity.getFingerPositionCode());
        fingerPrintDto.setImageHashValue(fingerPrintEntity.getImageHashValue());
        fingerPrintDto.setIsEmployee(fingerPrintEntity.getIsEmployee());
        fingerPrintDto.setNistQualityMeasure(fingerPrintEntity.getNistQualityMeasure());
        fingerPrintDto.setSerialNumber(fingerPrintEntity.getSerialNumber());

        return fingerPrintDto;
    }

    public static List<FingerPrintEntity> convertFromDtos(List<FingerPrintDto> fingerPrintDtoList){
        List<FingerPrintEntity> fingerPrintEntities = new ArrayList<>();

        for (FingerPrintDto fingerPrintDto : fingerPrintDtoList){
            fingerPrintEntities.add(convertFromDto(fingerPrintDto));
        }

        return fingerPrintEntities;
    }

    public static List<FingerPrintDto> convertFromEntities(List<FingerPrintEntity> fingerPrintEntityList){
        List<FingerPrintDto> fingerPrintDtoList = new ArrayList<>();

        for (FingerPrintEntity fingerPrintEntity : fingerPrintEntityList){
            fingerPrintDtoList.add(convertFromEntity(fingerPrintEntity));
        }

        return fingerPrintDtoList;
    }
}
