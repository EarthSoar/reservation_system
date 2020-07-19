package com.example.reservation_system.util;

import java.text.SimpleDateFormat;

public class DateFormatUtil {

    public static SimpleDateFormat format(){
        SimpleDateFormat simpleDateFormat = new SimpleDateFormat("yyyy-MM-dd :hh:mm:ss");
        return simpleDateFormat;
    }
}
