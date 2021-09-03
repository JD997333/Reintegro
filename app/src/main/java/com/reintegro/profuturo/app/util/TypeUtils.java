package com.reintegro.profuturo.app.util;

public class TypeUtils {
    public static final String DEFAULT_STRING = "";
    public static final Boolean DEFAULT_BOOLEAN = false;
    public static final Double DEFAULT_DOUBLE = 0.0;
    public static final Integer DEFAULT_INT = 0;
    public static final Long DEFAULT_LONG = 0L;

    public static Boolean getBooleanValueOrDefault(String value) {
        if (value != null) {
            return Boolean.parseBoolean(value);
        } else {
            return DEFAULT_BOOLEAN;
        }
    }

    public static Boolean getValueOrDefault(Boolean value) {
        if (value != null) {
            return value;
        }else {
            return DEFAULT_BOOLEAN;
        }
    }

    public static Double getValueOrDefault(Double value) {
        if (value != null) {
            return value;
        } else{
            return DEFAULT_DOUBLE;
        }
    }

    public static Double getDoubleValueOrDefault(String value){
        if (value != null){
            try {
                return Double.parseDouble(value);
            }catch (NumberFormatException e){
                return DEFAULT_DOUBLE;
            }
        }else{
            return DEFAULT_DOUBLE;
        }
    }

    public static Integer getIntValueOrDefault(String value) {
        if (value != null) {
            try {
                return Integer.parseInt(value);
            } catch (NumberFormatException exception) {
                return DEFAULT_INT;
            }
        } else {
            return DEFAULT_INT;
        }
    }

    public static Integer getValueOrDefault(Integer value) {
        if (value != null) {
            return value;
        } else {
            return DEFAULT_INT;
        }
    }

    public static Long getLongValueOrDefault(String value) {
        if (value != null) {
            try {
                return Long.parseLong(value);
            } catch (NumberFormatException exception) {
                return DEFAULT_LONG;
            }
        } else {
            return DEFAULT_LONG;
        }
    }

    public static Long getValueOrDefault(Long value) {
        if (value != null) {
            return value;
        } else {
            return DEFAULT_LONG;
        }
    }

    public static String getValueOrDefault(String value) {
        if (value != null) {
            return value;
        } else {
            return DEFAULT_STRING;
        }
    }
}
