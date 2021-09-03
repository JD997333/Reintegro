package com.reintegro.profuturo.app.data.entity;

public class DateEntity {
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

    public String getMonthName(){
        switch (month) {
            case 0:
                return "Enero";
            case 1:
                return "Febrero";
            case 2:
                return "Marzo";
            case 3:
                return "Abril";
            case 4:
                return "Mayo";
            case 5:
                return "Junio";
            case 6:
                return "Julio";
            case 7:
                return "Agosto";
            case 8:
                return "Septiembre";
            case 9:
                return "Octubre";
            case 10:
                return "Noviembre";
            case 11:
                return "Diciembre";
            default:
                return "";
        }
    }
}
