package com.reintegro.profuturo.app.util;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;

public class DateUtils {
    public static String parseDate(String from, String to, String date) {
        try {
            SimpleDateFormat simpleDateFormat;
            simpleDateFormat = new SimpleDateFormat(from, LocaleUtils.MEXICO);

            Date parsedDate;
            parsedDate = simpleDateFormat.parse(date);

            simpleDateFormat = new SimpleDateFormat(to, LocaleUtils.MEXICO);

            return simpleDateFormat.format(parsedDate);
        } catch (ParseException e) {
            e.printStackTrace();
        }

        return null;
    }

    public static String getToday() {
        Calendar calendar = Calendar.getInstance();
        calendar.setTime(new Date());

        StringBuilder stringBuilder;
        stringBuilder = new StringBuilder();
        stringBuilder.append(calendar.get(Calendar.YEAR));
        stringBuilder.append("-");

        if ((calendar.get(Calendar.MONTH) + 1) < 10) {
            stringBuilder.append("0");
        }

        stringBuilder.append(calendar.get(Calendar.MONTH) + 1);
        stringBuilder.append("-");

        if (calendar.get(Calendar.DAY_OF_MONTH) < 10) {
            stringBuilder.append("0");
        }

        stringBuilder.append(calendar.get(Calendar.DAY_OF_MONTH));

        return stringBuilder.toString();
    }

    public static String getFormatedTodayDate(String format){
        Date date = new Date();

        SimpleDateFormat dateFormat = new SimpleDateFormat(format, LocaleUtils.MEXICO);

        return dateFormat.format(date);
    }
}

