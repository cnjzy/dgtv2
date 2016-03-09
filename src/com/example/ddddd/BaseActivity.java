package com.example.ddddd;

import java.util.HashMap;
import java.util.Map;

import org.json.JSONObject;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.os.Handler;
import android.widget.Toast;

import com.example.ddddd.utils.DeviceUtils;
import com.example.ddddd.utils.NetUtils;
import com.example.ddddd.utils.PayUtils;
import com.example.ddddd.utils.UMengUtils;
import com.example.ddddd.utils.Utils;
import com.umeng.analytics.MobclickAgent;

public class BaseActivity extends Activity {
	protected BaseActivity context = this;
	protected int pay_type = 1;

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		// TODO Auto-generated method stub
		super.onCreate(savedInstanceState);
	}

	public void onResume() {
		super.onResume();
		MobclickAgent.onResume(this);
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see android.app.Activity#onPause()
	 */

	protected void onPause() {
		super.onPause();
		MobclickAgent.onPause(this);
	}

	private Handler handler = new Handler() {
		public void handleMessage(android.os.Message msg) {
			try {
				if (msg.what == 1) {
					int code = 0;
					String message = "";
					JSONObject jsonObj = new JSONObject(msg.obj.toString());
					if (!jsonObj.isNull("status")) {
						code = jsonObj.getInt("status");
					}
					if (!jsonObj.isNull("msg")) {
						message = jsonObj.getString("msg");
					}
					if (!jsonObj.isNull("msg")) {
						message = jsonObj.getString("msg");
					}
					if (code == 200 && !jsonObj.isNull("data")) {
						JSONObject dataObj = jsonObj.getJSONObject("data");
						if (!dataObj.isNull("order_no")) {
							String orderNo = dataObj.getString("order_no");
							int mStrPayMode = pay_type == 1 ? 2 : 1;
							PayUtils.pay(context, orderNo, String.valueOf(mStrPayMode), String.valueOf(Utils.amount * 100));
						}
					} else {
						Toast.makeText(context, message, Toast.LENGTH_SHORT).show();
					}
				} else {
					Toast.makeText(context, msg.obj.toString(), Toast.LENGTH_SHORT).show();
				}
			} catch (Exception e) {
				e.printStackTrace();
			}
		};
	};

	/**
	 * 
	 * @param amount
	 * @param pay_type
	 *            1支付宝 2微信
	 * @param member_type
	 *            1包年 2终生
	 */
	public void getOrder(int amount, int pay_type, int member_type) {
		if (pay_type == 1) {
			UMengUtils.addClickAlipay(context);
		} else {
			UMengUtils.addClickWechat(context);
		}
		this.pay_type = pay_type;
		Map<String, String> params = new HashMap<String, String>();
		params.put("imei", DeviceUtils.getImei(context));
		params.put("device_os", 1 + "");
		params.put("amount", amount + "");
		params.put("pay_type", pay_type + "");
		params.put("member_type", member_type + "");
		NetUtils.getPost(Utils.URL_GET_ORDER, params, handler);
	}

}
