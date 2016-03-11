package com.example.ddddd.utils;

import android.content.Context;
import android.content.pm.ApplicationInfo;
import android.content.pm.PackageInfo;
import android.content.pm.PackageManager;
import android.content.pm.PackageManager.NameNotFoundException;
import android.os.Bundle;
import android.telephony.TelephonyManager;

public class DeviceUtils {
	private static float scale;
	
	/**
	 * 获得IMEI
	 * 
	 * @param cx
	 * @return
	 */
	public static String getImei(Context cx) {
		TelephonyManager tm = (TelephonyManager) cx.getSystemService(Context.TELEPHONY_SERVICE);
		return tm.getDeviceId();
	}

	/**
	 * 获得当前程序包名
	 * 
	 * @param cx
	 * @return
	 */
	public static String getMyPackageName(Context cx) {
		try {
			return cx.getPackageManager().getPackageInfo(cx.getPackageName(), 0).packageName;
		} catch (NameNotFoundException e) {
		}
		return null;
	}

	/**
	 * 获得包信息
	 * 
	 * @param c
	 * @return
	 */
	private static PackageInfo getPackageInfo(Context c) {
		try {
			return c.getPackageManager().getPackageInfo(c.getPackageName(), PackageManager.GET_CONFIGURATIONS);
		} catch (NameNotFoundException e) {
		}
		return null;
	}

	/**
	 * 
	 * @param cx
	 * @return
	 */
	public static Bundle getAppMetaDate(Context cx) {
		try {
			ApplicationInfo appInfo = cx.getPackageManager().getApplicationInfo(cx.getPackageName(), PackageManager.GET_META_DATA);
			return appInfo.metaData;
		} catch (NameNotFoundException e) {
			// TODO Auto-generated catch block
		}
		return null;
	}

	/**
	 * 判断渠道号
	 * 
	 * @param cx
	 * @param meta_date
	 * @return
	 */
	public static String getChannelName(Context cx, String meta_date) {
		return getAppMetaDate(cx).get(meta_date).toString();
	}

	/**
	 * 获取当前程序的版本号
	 * 
	 * @param cx
	 * @return
	 */
	public static String getVersionName(Context cx) {
		return getPackageInfo(cx).versionName;
	}

	/**
	 * 获取当前程序的内部版本号
	 * 
	 * @param cx
	 * @return
	 */
	public static int getVersionCode(Context cx) {
		return getPackageInfo(cx).versionCode;
	}

	/**
	 * 单位转换
	 * 
	 * @param context
	 * @param dipValue
	 * @return
	 */
	public static final int dip2px(Context context, float dipValue) {
		if (scale == 0)
			scale = context.getResources().getDisplayMetrics().density;
		return (int) (dipValue * scale + 0.5f);
	}
}
