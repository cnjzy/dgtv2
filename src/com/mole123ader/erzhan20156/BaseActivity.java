package com.mole123ader.erzhan20156;

import java.util.HashMap;
import java.util.Map;

import org.json.JSONObject;

import android.app.Activity;
import android.os.Bundle;
import android.os.Handler;
import android.util.Log;
import android.widget.Toast;

import com.mole123ader.erzhan20156.utils.DeviceUtils;
import com.mole123ader.erzhan20156.utils.NetUtils;
import com.mole123ader.erzhan20156.utils.UMengUtils;
import com.mole123ader.erzhan20156.utils.Utils;
import com.umeng.analytics.MobclickAgent;
import com.wo.main.WP_SDK;
import com.wo.plugin.WP_Event;

public class BaseActivity extends Activity {
	protected BaseActivity context = this;
	protected int pay_type = 1;
	protected String TAG = this.getClass().getSimpleName();

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
					String feeName = "永久用户";
					String feeDesp = "永久用户";

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
							
							WP_SDK.on_Recharge(context, String.valueOf(Utils.amount*100), feeName, feeDesp, orderNo, pay_type-1, new WP_Event() {
								@Override
								public void on_Result(int code, String value) {
									// TODO Auto-generated method stub
									Log.e("debug", code + ",value=" + value);
									if (code == 0) {// 充值成功
										MyApp.p.putInt("userType", Utils.VIP);
										if(context instanceof VideoPlayerActivity){
											finish();
										}
										Toast.makeText(context, "充值成功!", Toast.LENGTH_LONG).show();
									} else {// 充值失败
										Toast.makeText(context, "充值失败!", Toast.LENGTH_LONG).show();
									}
								}
							});
							
//							PayUtils.pay(context, orderNo, String.valueOf(Utils.amount), feeName, mHandler);
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
		params.put("channel", DeviceUtils.getChannelName(context, "UMENG_CHANNEL"));
		params.put("version", String.valueOf(DeviceUtils.getVersionCode(context)));
		NetUtils.getPost(Utils.URL_GET_ORDER, params, handler);
	}

}
