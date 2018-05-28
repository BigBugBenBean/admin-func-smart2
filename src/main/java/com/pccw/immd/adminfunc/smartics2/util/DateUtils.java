package com.pccw.immd.adminfunc.smartics2.util;

import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;

public class DateUtils {

    public static final String DATE_INPUT_FORMAT = "dd/MM/yyyy";
    private static SimpleDateFormat sdf = null;

    public static Date parseDate(String dateStr){
        sdf = new SimpleDateFormat(DATE_INPUT_FORMAT);
        try{
            return sdf.parse(dateStr);
        }catch (Exception e){
            return null;
        }
    }

    public static String format(Date date){
        sdf = new SimpleDateFormat(DATE_INPUT_FORMAT);
        try{
            return sdf.format(date);
        }catch (Exception e){
            return null;
        }
    }

    public static boolean isSunday(Date date){
        Calendar cal = Calendar.getInstance();
        cal.setTime(date);
        return cal.get(Calendar.DAY_OF_WEEK) == Calendar.SUNDAY;
    }

    public static boolean isSameDate(Date date1, Date date2){
        Calendar c1 = Calendar.getInstance();
        c1.setTime(date1);

        Calendar c2 = Calendar.getInstance();
        c2.setTime(date2);
        return c2.equals(c1);
    }
}
