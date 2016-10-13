package com.gas.Securitycheck.utils;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class RegexUtil
{
    private static String TAG = "RegexUtil";
    
    public static boolean isPhone(String mobiles)
    {
        if (mobiles == null || "".equals(mobiles))
            return false;
       // Pattern p = Pattern.compile("^((13[0-9])|(15[^4,\\D])|(18[0,5-9]))\\d{8}$");
        //下面这句话让147和177这个号段的电话号码可以顺利注册
        Pattern p= Pattern.compile("^1(3|4|5|7|8)\\d{9}$");
        //Pattern p=Pattern.compile("/^1(3|4|5|7|8)\\d{9}$/");
        Matcher m = p.matcher(mobiles);
        return m.matches();
    }
    
    public static boolean isEmail(String email)
    {
        String str = "^([a-zA-Z0-9]*[-_]?[a-zA-Z0-9]+)*@([a-zA-Z0-9]*[-_]?[a-zA-Z0-9]+)+[\\.][A-Za-z]{2,3}([\\.][A-Za-z]{2})?$";
        Pattern p = Pattern.compile(str);
        Matcher m = p.matcher(email);
        return m.matches();
    }
}
