package com.example.ddddd.utils;

import android.content.Context;
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
}
