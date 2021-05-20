package com.reintegro.profuturo.app.domain.dto;

public class DateDto {
    private String id;
    private int day;
    private int month;
    private int year;
    private int hours;
    private int minutes;
    private int seconds;

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public int getDay() {
        return day;
    }

    public void setDay(int day) {
        this.day = day;
    }

    public int getMonth() {
        return month;
    }

    public void setMonth(int month) {
        this.month = month;
    }

    public int getYear() {
        return year;
    }

    public void setYear(int year) {
        this.year = year;
    }

    public int getHours() {
        return hours;
    }

    public void setHours(int hours) {
        this.hours = hours;
    }

    public int getMinutes() {
        return minutes;
    }

    public void setMinutes(int minutes) {
        this.minutes = minutes;
    }

    public int getSeconds() {
        return seconds;
    }

    public void setSeconds(int seconds) {
        this.seconds = seconds;
    }

    public String toDate() {
        if (day != 0
                && month != 0
                && year != 0) {
            StringBuilder stringBuilder;
            stringBuilder = new StringBuilder();

            if (day < 10) {
                stringBuilder.append(0);
            }

            stringBuilder.append(day);
            stringBuilder.append("/");

            if (month < 10) {
                stringBuilder.append(0);
            }

            stringBuilder.append(month + 1);
            stringBuilder.append("/");

            stringBuilder.append(year);

            return stringBuilder.toString();
        } else {
            return "";
        }
    }

    public String toDateExtended() {
        if (day != 0
                && month != 0
                && year != 0) {
            StringBuilder stringBuilder;
            stringBuilder = new StringBuilder();

            if (day < 10) {
                stringBuilder.append(0);
            }

            stringBuilder.append(day);
            stringBuilder.append(" de ");

            switch (month) {
                case 0:
                    stringBuilder.append("Enero");
                    break;
                case 1:
                    stringBuilder.append("Febrero");
                    break;
                case 2:
                    stringBuilder.append("Marzo");
                    break;
                case 3:
                    stringBuilder.append("Abril");
                    break;
                case 4:
                    stringBuilder.append("Mayo");
                    break;
                case 5:
                    stringBuilder.append("Junio");
                    break;
                case 6:
                    stringBuilder.append("Julio");
                    break;
                case 7:
                    stringBuilder.append("Agosto");
                    break;
                case 8:
                    stringBuilder.append("Septiembre");
                    break;
                case 9:
                    stringBuilder.append("Octubre");
                    break;
                case 10:
                    stringBuilder.append("Noviembre");
                    break;
                case 11:
                    stringBuilder.append("Diciembre");
                    break;
                default:
            }

            stringBuilder.append(", ");

            stringBuilder.append(year);

            return stringBuilder.toString();
        } else {
            return "";
        }
    }
}

