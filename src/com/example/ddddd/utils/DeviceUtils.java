package com.example.ddddd.utils;

import android.content.Context;
import android.content.pm.ApplicationInfo;
import android.content.pm.PackageInfo;
import android.content.pm.PackageManager;
import android.content.pm.PackageManager.NameNotFoundException;
import android.os.Bundle;
import android.telephony.TelephonyManager;

public class DeviceUtils {
	/**
	 * 获得IMEI
	 * 
	 * @param cx
	 * @return
	 */
	public static String getImei(Context cx) {
		TelephonyManager tm = (TelephonyManager) cx
				.getSystemService(Context.TELEPHONY_SERVICE);
		return tm.getDeviceId();
	}
	
	/**
     * 
     * @param cx
     * @return
     */
    public static Bundle getAppMetaDate(Context cx) {
        try {
            ApplicationInfo appInfo = cx.getPackageManager().getApplicationInfo(cx.getPackageName(),
                    PackageManager.GET_META_DATA);
            return appInfo.metaData;
        } catch (NameNotFoundException e) {
            // TODO Auto-generated catch block
        }
        return null;
    }
	
	// 判断渠道号
    public static String getChannelName(Context cx, String meta_date) {
        return getAppMetaDate(cx).get(meta_date).toString();
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
}
