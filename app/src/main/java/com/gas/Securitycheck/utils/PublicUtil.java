package com.gas.Securitycheck.utils;


import android.app.Activity;
import android.content.Context;
import android.content.res.Resources;
import android.graphics.Bitmap;
import android.view.View;
import android.view.inputmethod.InputMethodManager;
import android.widget.Toast;

import com.gas.Securitycheck.R;
import com.gas.Securitycheck.ServiceApplication;
import com.nostra13.universalimageloader.cache.memory.impl.WeakMemoryCache;
import com.nostra13.universalimageloader.core.DisplayImageOptions;
import com.nostra13.universalimageloader.core.ImageLoader;
import com.nostra13.universalimageloader.core.ImageLoaderConfiguration;
import com.nostra13.universalimageloader.core.assist.ImageScaleType;


public class PublicUtil {

    /**
     * 将时间转化
     *
     * @param content
     *            内容
     */
    public static String zhuanhuan(String content) {
        return  DateUtil.TimeStamp2Date(content, "yyyy-MM-dd HH:mm:ss ");
    }
    /**
     * 将字符串的后两位用**代替
     *
     * @param content
     *            内容
     */
    public static String tiHuan(String content) {
        int a=0;
        if (content.length()>3){
            a=3;
        }else if(content.length()>1&&content.length()<=3){
            a=1;
        }

        String b=content.substring(0,content.length()-a);
        StringBuffer result = new StringBuffer();
        result.append(b);
        result.append("***");
        return result.toString();
        //return  content;
    }

	/**
	 * Toast提醒
	 * 
	 * @param content
	 *            内容
	 */
	public static void ShowToast(String content) {
		Toast.makeText(ServiceApplication.getInstance(), content, Toast.LENGTH_SHORT)
				.show();
	}
	
	/**
	 * 获取设备宽度
	 * @return
	 */
	public static int getDeviceWidth() {
		return ServiceApplication.getInstance().getResources().getDisplayMetrics().widthPixels;
	}

	/**
	 * 获取设备高度
	 * @return
	 */
	public static int getDeviceHeight() {
		return ServiceApplication.getInstance().getResources().getDisplayMetrics().heightPixels;
	}
	
	public static int getResColor(int resid)
	{
		Resources rs = ServiceApplication.getInstance().getResources();
		return rs.getColor(resid);
	}
	
	/**
     * 判断输入合法性
     * @param name
     * @param addr
     * @param phone
     * @return
     */
    public static boolean isLegal(String name ,String addr,String phone)
    {
        if("".equals(name))
        {
            PublicUtil.ShowToast("请输入联系人姓名");
            return false;
        }
        if("".equals(addr))
        {
            PublicUtil.ShowToast("请输入联系人地址");
            return false;
        }
        if("".equals(phone) || !RegexUtil.isPhone(phone))
        {
            PublicUtil.ShowToast("请输入正确的联系人电话");
            return false;
        }
        return true;
    }


    //图片下载的参数的配置
    private static DisplayImageOptions classOption;
    public static DisplayImageOptions getClassOption()
    {
        if (null==classOption)
        {
            classOption=new DisplayImageOptions.Builder().bitmapConfig(Bitmap.Config.RGB_565).showImageOnFail(R.mipmap.ic_launcher).showImageOnLoading(R.mipmap.ic_launcher).imageScaleType(ImageScaleType.EXACTLY).cacheOnDisk(true).build();
        }
        return classOption;
    }

    private static DisplayImageOptions adsOption;
    public static DisplayImageOptions getAdsOption()
    {
        if(null == adsOption)
        {
            adsOption = new DisplayImageOptions.Builder().bitmapConfig(Bitmap.Config.RGB_565).showImageOnFail(R.mipmap.ic_launcher).showImageOnLoading(R.mipmap.ic_launcher).imageScaleType(ImageScaleType.EXACTLY).cacheOnDisk(true).build();
        }
        return  adsOption;
    }
    private static DisplayImageOptions goodsOption;

    public static DisplayImageOptions getGoodsOption()
    {
        if(null == goodsOption)
        {
            goodsOption = new DisplayImageOptions.Builder().bitmapConfig(Bitmap.Config.RGB_565).showImageOnFail(R.mipmap.ic_launcher).showImageOnLoading(R.mipmap.ic_launcher).imageScaleType(ImageScaleType.EXACTLY).cacheOnDisk(true).build();
        }
        return  goodsOption;
    }

    private static DisplayImageOptions headOption;

    public static DisplayImageOptions getHeadOption()
    {
        if(null == headOption)
        {
            headOption = new DisplayImageOptions.Builder().bitmapConfig(Bitmap.Config.RGB_565).showImageOnFail(R.mipmap.ic_launcher).showImageOnLoading(R.mipmap.ic_launcher).imageScaleType(ImageScaleType.EXACTLY).cacheOnDisk(true).build();
        }
        return  headOption;
    }


    private static ImageLoader mImageLoader;

    public static ImageLoader getImageLoader() {
        if (mImageLoader == null) {
            mImageLoader = ImageLoader.getInstance();
            ImageLoaderConfiguration configuration = new ImageLoaderConfiguration.Builder(ServiceApplication.getInstance()).threadPoolSize(3).memoryCache(new WeakMemoryCache()).build();
            mImageLoader.init(configuration);
        }

        return mImageLoader;
    }
    
    public static void closeKeyBoard(Context context)
    {
        /**隐藏软键盘**/
        View view = ((Activity)context).getWindow().peekDecorView();
        if (view != null) {
            InputMethodManager inputmanger = (InputMethodManager) ((Activity)context).getSystemService(Context.INPUT_METHOD_SERVICE);
            inputmanger.hideSoftInputFromWindow(view.getWindowToken(), 0);
        }
    }

    /**
     * 将字符串价格 转换为 显示2位小数的字符串
     *
     * @param str
     * @return
     */
    public static String priceFormat(String str)
    {
        float price = Float.valueOf(str);
        return String.format("%.2f ", price);
    }
}
