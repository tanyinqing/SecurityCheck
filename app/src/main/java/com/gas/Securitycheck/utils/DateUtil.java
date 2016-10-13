package com.gas.Securitycheck.utils;

import java.util.Calendar;
import java.util.Date;

/**
 * Created by xinliwei on 2015/7/14.
 *
 * 关于日期和时间处理的工具类
 */
public class DateUtil {

    public static int parserYear(Date date){
        int year = 0;

        Calendar calendar = Calendar.getInstance();
        calendar.setTime(date);
        year = calendar.get(Calendar.YEAR);
        return year;
    }

    public static int parserYear(long time){
        int year = 2015;

        Calendar calendar = Calendar.getInstance();
        calendar.setTimeInMillis(time);
        year = calendar.get(Calendar.YEAR);

        return year;
    }

    public static String formatDate(long time){
        Calendar calendar = Calendar.getInstance();
        calendar.setTimeInMillis(time);

        return calendar.get(Calendar.YEAR) + "-" + (calendar.get(Calendar.MONTH)+1) + "-" + calendar.get(Calendar.DAY_OF_MONTH);
    }

    public static Date createDate(int year,int month,int day){
        Calendar calendar = Calendar.getInstance();
        calendar.set(year, month - 1, day);
        return calendar.getTime();
    }

    public static String TimeStamp2Date(String timestampString, String formats){
        Long timestamp = Long.parseLong(timestampString)*1000+28800000;
        String date = new java.text.SimpleDateFormat(formats).format(new java.util.Date(timestamp));
        return date;
    }
}
