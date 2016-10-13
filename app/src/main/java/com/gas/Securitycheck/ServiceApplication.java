package com.gas.Securitycheck;

import android.app.Activity;
import android.app.Application;
import android.content.Context;

import com.gas.Securitycheck.entity.User;
import com.gas.Securitycheck.utils.PreferenceUtil;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by Administrator on 2016/9/29 0029.
 */
public class ServiceApplication extends Application {
    private static ServiceApplication instance;
    public static PreferenceUtil mPrefUtil;  //用于配制信息的业务类  继成了各种方法
    private List<Activity> mActivityList;

    @Override
    public void onCreate() {
        super.onCreate();
        instance = this;
        mPrefUtil = new PreferenceUtil(this, Constant.prefName, Context.MODE_PRIVATE);
        mActivityList = new ArrayList<Activity>();
    }
    public static ServiceApplication getInstance() {
        return instance;
    }
    /**
     * 定义一个方法  来读取配置的信息的值
     *
     */
    public static String read_String(String store_id){
        String m=mPrefUtil.getStrSetting(store_id);
        return m;
    }

    /**
     * 保存用户信息
     * @param u
     */
    public void saveUser(User u)
    {
        mPrefUtil.putSetting(Constant.user_pref, u);
    }
    /**
     * 读取用户信息
     * @return
     */
    public User readUser()
    {
        User user = (User) mPrefUtil.readObject(Constant.user_pref);
        return (User) mPrefUtil.readObject(Constant.user_pref);
    }

    /**
     * session信息
     * @param
     */
    public void saveSession(String session)
    {
        mPrefUtil.putSetting(Constant.session_pref, session);
    }

    public String readSession()
    {
        return mPrefUtil.getStrSetting(Constant.session_pref);
    }

    /**
     * 注册和退出Activity
     * @param
     */

    public void register(Activity activity)
    {
        mActivityList.add(activity);
    }

    public void exit()
    {
        try {
            for (Activity activity : mActivityList) {
                if (activity != null)
                    activity.finish();
            }
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            System.exit(0);
        }
    }

}
