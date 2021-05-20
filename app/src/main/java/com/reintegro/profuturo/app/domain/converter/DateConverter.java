package com.reintegro.profuturo.app.domain.converter;

import com.reintegro.profuturo.app.data.entity.DateEntity;
import com.reintegro.profuturo.app.domain.dto.DateDto;

public class DateConverter {
    public static DateDto convertFromEntity(DateEntity dateEntity) {
        DateDto dateDto;
        dateDto = new DateDto();

        if (dateEntity != null) {
            dateDto.setDay(dateEntity.getDay());
            dateDto.setHours(dateEntity.getHours());
            dateDto.setId(dateEntity.getId());
            dateDto.setMinutes(dateEntity.getMinutes());
            dateDto.setMonth(dateEntity.getMonth());
            dateDto.setSeconds(dateEntity.getSeconds());
            dateDto.setYear(dateEntity.getYear());
        }

        return dateDto;
    }

    public static DateEntity convertFromDto(DateDto dateDto) {
        DateEntity dateEntity;
        dateEntity = new DateEntity();

        if (dateDto != null) {
            dateEntity.setDay(dateDto.getDay());
            dateEntity.setHours(dateDto.getHours());
            dateEntity.setId(dateDto.getId());
            dateEntity.setMinutes(dateDto.getMinutes());
            dateEntity.setMonth(dateDto.getMonth());
            dateEntity.setSeconds(dateDto.getSeconds());
            dateEntity.setYear(dateDto.getYear());
        }

        return dateEntity;
    }
}

