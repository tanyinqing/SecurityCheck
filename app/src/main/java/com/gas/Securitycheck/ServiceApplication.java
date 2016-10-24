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
    public static PreferenceUtil mPrefUtil;
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
     *
     *
     */
    public static String read_String(String store_id){
        String m=mPrefUtil.getStrSetting(store_id);
        return m;
    }

    /**
     * ??????????
     * @param u
     */
    public void saveUser(User u)
    {
        mPrefUtil.putSetting(Constant.user_pref, u);
    }
    /**
     *
     * @return
     */
    public User readUser()
    {
        User user = (User) mPrefUtil.readObject(Constant.user_pref);
        return (User) mPrefUtil.readObject(Constant.user_pref);
    }

    /**
     * session
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
     *
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
