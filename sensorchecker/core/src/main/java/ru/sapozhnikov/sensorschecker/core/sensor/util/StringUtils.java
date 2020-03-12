package ru.sapozhnikov.sensorschecker.core.sensor.util;

public class StringUtils {

    public static boolean fieldIsEmpty(String str){
            return str==null || str.trim().isEmpty();
    }

}
