package com.example.ddddd;

import java.text.SimpleDateFormat;
import java.util.Date;

import android.content.Intent;
import android.os.Bundle;
import android.os.Handler;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;

import com.example.ddddd.utils.UMengUtils;
import com.example.ddddd.utils.Utils;
import com.imageview.switchview.Image3DSwitchView;
import com.nostra13.universalimageloader.core.ImageLoader;

public class MainActivity extends BaseActivity {

	private ImageView mv_1_4;
	private ImageView mv_1_5;
	private ImageView mv_2_1;
	private ImageView mv_2_2;
	private ImageView mv_2_3;
	private ImageView mv_2_4;
	private ImageView mv_2_5;
	private ImageView mv_3_1;
	private ImageView mv_3_2;
	private ImageView mv_3_3;
	private ImageView mv_3_4;
	private ImageView mv_3_5;
	private Image3DSwitchView image_switch_view;
	private TextView refresh_date1;
	private TextView refresh_date2;
	private TextView refresh_date3;
	
	
	private Handler handler = new Handler();
	private Runnable loopRunnber = new Runnable() {
		public void run() {
			image_switch_view.scrollToNext();
			handler.postDelayed(loopRunnber, 3000);
		}
	};
	

	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.fragment_homepage);
		UMengUtils.addShowMain(context);

		mv_1_4 = (ImageView) findViewById(R.id.mv_1_4);
		mv_1_5 = (ImageView) findViewById(R.id.mv_1_5);
		mv_2_1 = (ImageView) findViewById(R.id.mv_2_1);
		mv_2_2 = (ImageView) findViewById(R.id.mv_2_2);
		mv_2_3 = (ImageView) findViewById(R.id.mv_2_3);
		mv_2_4 = (ImageView) findViewById(R.id.mv_2_4);
		mv_2_5 = (ImageView) findViewById(R.id.mv_2_5);
		mv_3_1 = (ImageView) findViewById(R.id.mv_3_1);
		mv_3_2 = (ImageView) findViewById(R.id.mv_3_2);
		mv_3_3 = (ImageView) findViewById(R.id.mv_3_3);
		mv_3_4 = (ImageView) findViewById(R.id.mv_3_4);
		mv_3_5 = (ImageView) findViewById(R.id.mv_3_5);

		this.image_switch_view = ((Image3DSwitchView) findViewById(R.id.image_switch_view));
		this.refresh_date1 = ((TextView) findViewById(R.id.refresh_date1));
		this.refresh_date2 = ((TextView) findViewById(R.id.refresh_date2));
		this.refresh_date3 = ((TextView) findViewById(R.id.refresh_date3));
		String str = new SimpleDateFormat("MM-dd").format(new Date());
		this.refresh_date1.setText("最近更新日期：" + str);
		this.refresh_date2.setText("最近更新日期：" + str);
		this.refresh_date3.setText("最近更新日期：" + str);
		
		handler.postDelayed(loopRunnber, 1000);
		
//		ImageLoader.getInstance().displayImage(Utils.getImgPath(0), mv_1_4, MyApp.options, MyApp.animateFirstListener);
//		ImageLoader.getInstance().displayImage(Utils.getImgPath(1), mv_1_5, MyApp.options, MyApp.animateFirstListener);
//		ImageLoader.getInstance().displayImage(Utils.getImgPath(2), mv_2_1, MyApp.options, MyApp.animateFirstListener);
//		ImageLoader.getInstance().displayImage(Utils.getImgPath(3), mv_2_2, MyApp.options, MyApp.animateFirstListener);
//		ImageLoader.getInstance().displayImage(Utils.getImgPath(4), mv_2_3, MyApp.options, MyApp.animateFirstListener);
//		ImageLoader.getInstance().displayImage(Utils.getImgPath(5), mv_2_4, MyApp.options, MyApp.animateFirstListener);
//		ImageLoader.getInstance().displayImage(Utils.getImgPath(6), mv_2_5, MyApp.options, MyApp.animateFirstListener);
//		ImageLoader.getInstance().displayImage(Utils.getImgPath(7), mv_3_1, MyApp.options, MyApp.animateFirstListener);
//		ImageLoader.getInstance().displayImage(Utils.getImgPath(8), mv_3_2, MyApp.options, MyApp.animateFirstListener);
//		ImageLoader.getInstance().displayImage(Utils.getImgPath(9), mv_3_3, MyApp.options, MyApp.animateFirstListener);
//		ImageLoader.getInstance().displayImage(Utils.getImgPath(10), mv_3_4, MyApp.options, MyApp.animateFirstListener);
//		ImageLoader.getInstance().displayImage(Utils.getImgPath(11), mv_3_5, MyApp.options, MyApp.animateFirstListener);
		
	}
	
	@Override
	protected void onDestroy() {
		handler.removeCallbacks(loopRunnber);
		super.onDestroy();
	}
	
	public void imageOnClick(View v) {
		UMengUtils.addClickContnt(context);
		switch(v.getId()){
		case R.id.image1:
			showDetailActivity(0, true, 0);
			break;
		case R.id.image2:
			showDetailActivity(0, true, 1);
			break;
		case R.id.image3:
			showDetailActivity(0, true, 2);
			break;
		case R.id.image4:
			showDetailActivity(0, true, 3);
			break;
		case R.id.image5:
			showDetailActivity(0, true, 4);
			break;
		case R.id.shikan_1:
			VideoPlayerActivity.show(context, Utils.tv_shibo1, true, 20);
			break;
		case R.id.shikan_2:
			VideoPlayerActivity.show(context, Utils.tv_shibo2, true, 40);
			break;
		case R.id.mv_1_1:
			showDetailActivity(0, false, 0);
			break;
		case R.id.mv_1_2:
			showDetailActivity(0, false, 1);
			break;
		case R.id.mv_1_3:
			showDetailActivity(0, false, 2);
			break;
		case R.id.mv_1_4:
			showDetailActivity(0, false, 3);
			break;
		case R.id.mv_1_5:
			showDetailActivity(0, false, 4);
			break;
		case R.id.mv_2_1:
			showDetailActivity(1, false, 5);
			break;
		case R.id.mv_2_1_1:
			showDetailActivity(1, false, 5);
			break;
		case R.id.mv_2_2:
			showDetailActivity(1, false, 6);
			break;
		case R.id.mv_2_3:
			showDetailActivity(1, false, 7);
			break;
		case R.id.mv_2_4:
			showDetailActivity(1, false, 8);
			break;
		case R.id.mv_2_5:
			showDetailActivity(1, false, 9);
			break;
		case R.id.mv_3_1:
			showDetailActivity(2, false, 10);
			break;
		case R.id.mv_3_1_1:
			showDetailActivity(2, false, 10);
			break;
		case R.id.mv_3_2:
			showDetailActivity(2, false, 11);
			break;
		case R.id.mv_3_3:
			showDetailActivity(2, false, 12);
			break;
		case R.id.mv_3_4:
			showDetailActivity(2, false, 13);
			break;
		case R.id.mv_3_5:
			showDetailActivity(2, false, 14);
			break;
		}
	}
	
	private void showDetailActivity(int position, boolean isTop, int index){
		if(MyApp.p.getInt("userType", 0) == Utils.VIP){
			if(isTop){
				VideoPlayerActivity.show(context, Utils.getTopUrl(index), false, 0);
			}else{
				VideoPlayerActivity.show(context, Utils.getMvUrl(index), false, 0);
			}
		}else{
			Intent intent = new Intent(this, DetailActivity.class);
			intent.putExtra("clickposition", position);
			startActivity(intent);
		}
	}
}
