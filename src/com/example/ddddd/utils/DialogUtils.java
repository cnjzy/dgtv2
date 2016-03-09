package com.example.ddddd.utils;

import android.app.Activity;
import android.app.Dialog;
import android.content.DialogInterface;
import android.content.DialogInterface.OnCancelListener;
import android.view.Gravity;
import android.view.KeyEvent;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.View.OnKeyListener;
import android.view.Window;
import android.widget.LinearLayout;

import com.example.ddddd.R;

public class DialogUtils {
	public interface OnAlertSelectId {
        void onClick(int whichButton, Object o);
    }
	
	/**
	 * 支付3
	 * 
	 * @param context
	 * @return
	 */
	public static Dialog showPayDialog(final Activity context, final OnAlertSelectId onClickListener){
		return showPayDialog(context, onClickListener, null);
	}
	/**
	 * 支付3
	 * 
	 * @param context
	 * @return
	 */
	public static Dialog showPayDialog(final Activity context, final OnAlertSelectId onClickListener, OnCancelListener onCancelListenr) {
		final Dialog mDialog = new Dialog(context, R.style.PayDialogTheme);
		mDialog.setContentView(R.layout.pay_dialog);

		LinearLayout weixin = (LinearLayout) mDialog.findViewById(R.id.weixin);
		LinearLayout ali = (LinearLayout) mDialog.findViewById(R.id.ali);

		weixin.setOnClickListener(new OnClickListener() {
			public void onClick(View v) {
				mDialog.cancel();
				if(onClickListener != null){
					onClickListener.onClick(2, null);
				}
			}
		});
		
		ali.setOnClickListener(new OnClickListener() {
			public void onClick(View v) {
				mDialog.cancel();
				if(onClickListener != null){
					onClickListener.onClick(1, null);
				}
			}
		});
		
		mDialog.setCanceledOnTouchOutside(false);
		mDialog.setOnCancelListener(onCancelListenr);
		mDialog.setOnKeyListener(new DialogInterface.OnKeyListener() {
			public boolean onKey(DialogInterface dialog, int keyCode, KeyEvent event) {
				if(keyCode == event.KEYCODE_BACK && event.getAction() == KeyEvent.ACTION_DOWN){
					context.finish();
				}
				return false;
			}
		});
		// 设置居中
		Window dialogWindow = mDialog.getWindow();
		dialogWindow.setGravity(Gravity.CENTER);
		mDialog.show();
		return mDialog;
	}
}
