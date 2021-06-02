package com.reintegro.profuturo.app.database.converter;

import com.reintegro.profuturo.app.data.entity.DateEntity;
import com.reintegro.profuturo.app.database.model.DateModel;

public class DateConverter {
    public static DateEntity convertFromModel(DateModel dateModel) {
        DateEntity dateEntity;
        dateEntity = new DateEntity();
        dateEntity.setDay(dateModel.getDay());
        dateEntity.setHours(dateModel.getHours());
        dateEntity.setId(dateModel.getId());
        dateEntity.setMinutes(dateModel.getMinutes());
        dateEntity.setMonth(dateModel.getMonth());
        dateEntity.setSeconds(dateModel.getSeconds());
        dateEntity.setYear(dateModel.getYear());

        return dateEntity;
    }

    public static DateModel convertFromEntity(DateEntity dateEntity) {
        DateModel dateModel;
        dateModel = new DateModel();
        dateModel.setDay(dateEntity.getDay());
        dateModel.setHours(dateEntity.getHours());
        dateModel.setMinutes(dateEntity.getMinutes());
        dateModel.setMonth(dateEntity.getMonth());
        dateModel.setSeconds(dateEntity.getSeconds());
        dateModel.setYear(dateEntity.getYear());

        boolean hasId;
        hasId = dateEntity.getId() != null;

        if (hasId) {
            dateModel.setId(dateEntity.getId());
        }

        return dateModel;
    }
}
