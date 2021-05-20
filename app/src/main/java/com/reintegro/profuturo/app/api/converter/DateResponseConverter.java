package com.reintegro.profuturo.app.api.converter;

import com.reintegro.profuturo.app.data.entity.DateEntity;
import com.reintegro.profuturo.app.util.LocaleUtils;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Calendar;

public class DateResponseConverter {
    public static DateEntity convertFromResponse(String response, String format) {
        DateEntity dateEntity = new DateEntity();

        if (response != null && !response.isEmpty()) {
            try {
                Calendar calendar = Calendar.getInstance();
                SimpleDateFormat simpleDateFormat = new SimpleDateFormat(format, LocaleUtils.MEXICO);
                calendar.setTime(simpleDateFormat.parse(response));
                dateEntity.setDay(calendar.get(Calendar.DAY_OF_MONTH));
                dateEntity.setMonth(calendar.get(Calendar.MONTH));
                dateEntity.setYear(calendar.get(Calendar.YEAR));
                dateEntity.setHours(calendar.get(Calendar.HOUR));
                dateEntity.setMinutes(calendar.get(Calendar.MINUTE));
                dateEntity.setSeconds(calendar.get(Calendar.SECOND));
            } catch (ParseException exception) {
                exception.printStackTrace();
            }
        }

        return dateEntity;
    }
}