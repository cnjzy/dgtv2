package com.example.ddddd.utils;

import android.content.Context;

import com.umeng.analytics.MobclickAgent;

public class UMengUtils {

	/**
	 * 记录自定义事件
	 * @param context
	 * @param eventId
	 */
	private static void addEvent(Context context, String eventId){
		MobclickAgent.onEvent(context, eventId);
	}
	
	/**
	 * 进入主页次数
	 * @param context
	 */
	public static void addShowMain(Context context){
		addEvent(context, "a_main");
	}
	
	/**
	 * 安卓微信点击计数
	 * @param context
	 */
	public static void addClickWechat(Context context){
		addEvent(context, "a_wechat");
	}
	
	/**
	 * 安卓点击支付宝
	 * @param context
	 */
	public static void addClickAlipay(Context context){
		addEvent(context, "a_alipay");
	}
	
	/**
	 * 点击内容
	 * @param context
	 */
	public static void addClickContnt(Context context){
		addEvent(context, "a_content");
	}
	
	/**
	 * 安卓支付成功
	 * @param context
	 */
	public static void addPaySuccess(Context context){
		addEvent(context, "a_pay_success");
	}
}
