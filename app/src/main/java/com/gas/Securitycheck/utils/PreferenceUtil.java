package com.gas.Securitycheck.utils;

import android.content.Context;
import android.content.SharedPreferences;
import android.content.SharedPreferences.Editor;
import android.text.TextUtils;

import java.io.ByteArrayInputStream;
import java.io.ByteArrayOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.io.StreamCorruptedException;
import java.util.HashMap;
import java.util.Iterator;

/**
 * 
 * 配置存储工具类
 * 
 * @author zeroangus
 * 
 */
public class PreferenceUtil {

	private SharedPreferences preferences;

	public PreferenceUtil(Context context, String name, int Mode) {
		preferences = context.getSharedPreferences(name, Mode);
	}

	/**
	 * 保存对象  将对象序列化后再转化为16进制的字符串保存
	 * @param key
	 * @param value
	 */
	public void putSetting(String key, Object value) {
		Editor editor = preferences.edit();
		try {
			ByteArrayOutputStream baos = new ByteArrayOutputStream();
			ObjectOutputStream oos = new ObjectOutputStream(baos);
			oos.writeObject(value);
			// 将序列化的数据转为16进制保存
			String value2 = bytesToHexString(baos.toByteArray());
			editor.putString(key, value2);
			editor.commit();
		} catch (Exception e) {
			System.out.println("putSetting ----> "+e.toString());
		}
	}

	/**
	 * desc:将数组转为16进制  将数组转化为字符串
	 * 
	 * @param bArray
	 * @return modified:
	 */
	public static String bytesToHexString(byte[] bArray) {
		if (bArray == null) {
			return null;
		}
		if (bArray.length == 0) {
			return "";
		}
		StringBuffer sb = new StringBuffer(bArray.length);
		String sTemp;
		for (int i = 0; i < bArray.length; i++) {
			sTemp = Integer.toHexString(0xFF & bArray[i]);
			if (sTemp.length() < 2)
				sb.append(0);
			sb.append(sTemp.toUpperCase());
		}
		return sb.toString();
	}

	/**
	 * desc:获取保存的Object对象
	 * 
	 * @param key
	 * @return modified:
	 */
	public Object readObject(String key) {
		try {
			if (preferences.contains(key)) {
				System.out.println("配置信息preferences.contains -------------> " + key);
				String string = preferences.getString(key, "");
				if (TextUtils.isEmpty(string)) {

					System.out.println( key + "配置信息 -----> is empty"  );
					return null;
				} else {

					System.out.println( key + " 配置信息-----> is not empty"  );
					// 将16进制的数据转为数组，准备反序列化
					byte[] stringToBytes = StringToBytes(string);
					ByteArrayInputStream bis = new ByteArrayInputStream(
							stringToBytes);
					ObjectInputStream is = new ObjectInputStream(bis);
					// 返回反序列化得到的对象
					Object readObject = is.readObject();
					return readObject;
				}
			}
		} catch (StreamCorruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (ClassNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		// 所有异常返回null
		return null;

	}

	/**
	 * desc:将16进制的数据转为数组  也就是把字符串转化为数组 一个单词一个组
	 * <p>
	 * 创建人：聂旭阳 , 2014-5-25 上午11:08:33
	 * </p>
	 * 
	 * @param data
	 * @return modified:
	 */
	public static byte[] StringToBytes(String data) {
		String hexString = data.toUpperCase().trim();
		if (hexString.length() % 2 != 0) {
			return null;
		}
		byte[] retData = new byte[hexString.length() / 2];
		for (int i = 0; i < hexString.length(); i++) {
			int int_ch; // 两位16进制数转化后的10进制数
			char hex_char1 = hexString.charAt(i); // //两位16进制数中的第一位(高位*16)
			int int_ch1;
			if (hex_char1 >= '0' && hex_char1 <= '9')
				int_ch1 = (hex_char1 - 48) * 16; // // 0 的Ascll - 48
			else if (hex_char1 >= 'A' && hex_char1 <= 'F')
				int_ch1 = (hex_char1 - 55) * 16; // // A 的Ascll - 65
			else
				return null;
			i++;
			char hex_char2 = hexString.charAt(i); // /两位16进制数中的第二位(低位)
			int int_ch2;
			if (hex_char2 >= '0' && hex_char2 <= '9')
				int_ch2 = (hex_char2 - 48); // // 0 的Ascll - 48
			else if (hex_char2 >= 'A' && hex_char2 <= 'F')
				int_ch2 = hex_char2 - 55; // // A 的Ascll - 65
			else
				return null;
			int_ch = int_ch1 + int_ch2;
			retData[i / 2] = (byte) int_ch;// 将转化后的数放入Byte里
		}
		return retData;
	}

	/**
	 * 
	 * 插入单个配置信息（string,string）
	 * 
	 * @param key
	 * @param value
	 */
	public void putSetting(String key, String value) {
		Editor editor = preferences.edit();
		editor.putString(key, value);
		editor.commit();
	}

	/**
	 * 
	 * 插入单个配置信息（string,int）
	 * 
	 * @param key
	 * @param value
	 */
	public void putSetting(String key, int value) {
		Editor editor = preferences.edit();
		editor.putInt(key, value);
		editor.commit();
	}

	/**
	 * 插入单个配置信息（string,boolean）
	 * 
	 * @param key
	 * @param value
	 */
	public void putSetting(String key, Boolean value) {

		Editor editor = preferences.edit();
		editor.putBoolean(key, value);
		editor.commit();
	}

	/**
	 * 
	 * 插入多个配置信息
	 * Java学习之Iterator(迭代器)的一般用法 （转）
	 * @param params
	 */
	public void putSettings(HashMap<String, Object> params) {
		Editor editor = preferences.edit();
		Iterator<String> iter = params.keySet().iterator();
		while (iter.hasNext()) {
			String name = (String) iter.next();
			if (params.get(name).getClass() == Boolean.class) {
				editor.putBoolean(name, (Boolean) params.get(name));
			} else {
				editor.putString(name, (String) params.get(name));
			}
		}
		editor.commit();
	}

	/**
	 * 缺省返回-1
	 * 
	 * @param key
	 * @return
	 */
	public int getIntSetting(String key) {
		return preferences.getInt(key, -1);
	}

	/**
	 * 缺省返回null
	 * 
	 * @param key
	 * @return
	 */
	public String getStrSetting(String key) {
		return preferences.getString(key, null);
	}

	/**
	 * 缺省返回false
	 * 
	 * @param key
	 * @return
	 */
	public boolean getBoolean(String key) {
		return preferences.getBoolean(key, false);
	}

}
