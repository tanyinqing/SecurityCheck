package com.gas.Securitycheck.utils;

import android.util.Log;

/**
 * Created by Administrator on 2016/9/27 0027.
 */
public class MyLog {
    //���� ���ص���������
    private static String TAG="tanyinqing";
    //���� �ӿڷ��ص�������ص�����
    private static String TAG1="tanyinqingWangLuoJieKou";

    //�ر����е�Log���ݵĴ�ӡ
    private static Boolean ifShow=true;

    public static void ShowLog(String content){
        if (ifShow){
            Log.d(TAG1, content);
        }
    }
}
