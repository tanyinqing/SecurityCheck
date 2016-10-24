package com.gas.Securitycheck.model;

import android.app.Activity;
import android.content.Context;
import android.content.Intent;

import com.gas.Securitycheck.ServiceApplication;
import com.gas.Securitycheck.entity.User;

public class BaseModel {
	
	protected Context mContext;
	
	protected ServiceApplication serviceApplication;//全局 成员变量 成员方法
	
	public BaseModel(Context mContext)
	{
		this.mContext = mContext;
		serviceApplication = ServiceApplication.getInstance();
	}
	

	public boolean isLogin()//判断是否登录
	{
		User user = serviceApplication.readUser();
		if(null != user)
		{
			return true;
		}
		else
		{
			return false;
		}
	}
	
	protected User getUser()//获取用户
	{
		return serviceApplication.readUser();
	}
	
	/**
	 * 关闭当前activity
	 */
	protected void closeActivity()
	{
		((Activity)mContext).finish();
	}
	
	/**
	 * 跳转到其他activity
	 * @param cls
	 */
	protected void startAcitityByClass(Class cls)
	{
		Intent intent = new Intent();
		intent.setClass(mContext, cls);
		mContext.startActivity(intent);
	}
	
	
}
