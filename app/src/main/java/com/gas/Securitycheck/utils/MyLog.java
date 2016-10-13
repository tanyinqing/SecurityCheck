package com.gas.Securitycheck.utils;

import android.util.Log;

/**
 * Created by Administrator on 2016/9/27 0027.
 */
public class MyLog {
    //过滤 返回的所有数据
    private static String TAG="tanyinqing";
    //过滤 接口返回的网络相关的数据
    private static String TAG1="tanyinqingWangLuoJieKou";

    //关闭所有的Log数据的打印
    private static Boolean ifShow=true;

    public static void ShowLog(String content){
        if (ifShow){
            Log.d(TAG1, content);
        }
    }
}
