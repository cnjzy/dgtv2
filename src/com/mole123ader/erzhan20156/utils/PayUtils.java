package com.mole123ader.erzhan20156.utils;

import java.util.HashMap;
import java.util.Map;

import android.app.Activity;
import android.os.Handler;

import com.android.unipay.Starter;

public class PayUtils {

	private static final String PAGETAG = "dddddd";

	public static void pay(final Activity context, String orderNo, String amount, String feeName, Handler mHandler){
		// 测试参数
		String key = "04488A242D974D0F844C488CCA98833C";
		String partnerId = "1000100020000318";
		String appId = "2554";
		String qn = DeviceUtils.getChannelName(context, "UMENG_CHANNEL");
		String money = amount;
		String tradeId = orderNo;
		String tradeName = feeName;
		String returnUrl="http://pay_success";
		String notifyUrl="http://uni.api.76iw.com/index.php/order/uninotify";
		String includeChannels="ALIPAY2,WECHAT";
		String layoutType="port";
		
		Map<String, String> map = new HashMap<String, String>();
		map.put("partnerId", partnerId);
		map.put("key", key);
		map.put("money", money);
		map.put("tradeId", tradeId);
		map.put("appId", appId);
		map.put("qn", qn);
		map.put("tradeName", tradeName);
		map.put("notifyUrl", notifyUrl);
		map.put("returnUrl", returnUrl);
		map.put("includeChannels", includeChannels);
		map.put("layoutType", layoutType);
		Starter.getInstance().webPay(context, map, mHandler);
	}
}
