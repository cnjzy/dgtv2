package com.example.kctv;

import java.text.SimpleDateFormat;
import java.util.Date;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;

import com.example.kctv.adapter.BannerAdapter;
import com.example.kctv.utils.UMengUtils;
import com.example.kctv.utils.Utils;
import com.example.kctv.widget.view.ChildViewPager;
import com.example.kctv.widget.view.PointWidget;
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
	
	private TextView refresh_date1;
	private TextView refresh_date2;
	private TextView refresh_date3;
	private TextView refresh_date4;
	
	private ChildViewPager viewPager;
	private BannerAdapter bannerAdapter;
	private PointWidget pw;
	
	
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

		this.refresh_date1 = ((TextView) findViewById(R.id.refresh_date1));
		this.refresh_date2 = ((TextView) findViewById(R.id.refresh_date2));
		this.refresh_date3 = ((TextView) findViewById(R.id.refresh_date3));
		this.refresh_date4 = ((TextView) findViewById(R.id.refresh_date4));
		
		String str = new SimpleDateFormat("MM-dd").format(new Date());
		this.refresh_date1.setText("最近更新日期：" + str);
		this.refresh_date2.setText("最近更新日期：" + str);
		this.refresh_date3.setText("最近更新日期：" + str);
		this.refresh_date4.setText("最近更新日期：" + str);
		
		ImageLoader.getInstance().displayImage(Utils.getImgPath(0), mv_1_4, MyApp.options, MyApp.animateFirstListener);
		ImageLoader.getInstance().displayImage(Utils.getImgPath(1), mv_1_5, MyApp.options, MyApp.animateFirstListener);
		ImageLoader.getInstance().displayImage(Utils.getImgPath(2), mv_2_1, MyApp.options, MyApp.animateFirstListener);
		ImageLoader.getInstance().displayImage(Utils.getImgPath(3), mv_2_2, MyApp.options, MyApp.animateFirstListener);
		ImageLoader.getInstance().displayImage(Utils.getImgPath(4), mv_2_3, MyApp.options, MyApp.animateFirstListener);
		ImageLoader.getInstance().displayImage(Utils.getImgPath(5), mv_2_4, MyApp.options, MyApp.animateFirstListener);
		ImageLoader.getInstance().displayImage(Utils.getImgPath(6), mv_2_5, MyApp.options, MyApp.animateFirstListener);
		ImageLoader.getInstance().displayImage(Utils.getImgPath(7), mv_3_1, MyApp.options, MyApp.animateFirstListener);
		ImageLoader.getInstance().displayImage(Utils.getImgPath(8), mv_3_2, MyApp.options, MyApp.animateFirstListener);
		ImageLoader.getInstance().displayImage(Utils.getImgPath(9), mv_3_3, MyApp.options, MyApp.animateFirstListener);
		ImageLoader.getInstance().displayImage(Utils.getImgPath(10), mv_3_4, MyApp.options, MyApp.animateFirstListener);
		ImageLoader.getInstance().displayImage(Utils.getImgPath(11), mv_3_5, MyApp.options, MyApp.animateFirstListener);
		
		viewPager = (ChildViewPager) findViewById(R.id.viewPager);
		pw = (PointWidget) findViewById(R.id.litu_welcome_ponit);
		bannerAdapter = new BannerAdapter(this, viewPager, pw);
		viewPager.setAdapter(bannerAdapter);
	}
	
	@Override
	protected void onDestroy() {
		super.onDestroy();
	}
	
	public void imageOnClick(View v) {
		UMengUtils.addClickContnt(context);
		switch(v.getId()){
		case R.id.image6:
			showDetailActivity(0, true, 5);
			break;
		case R.id.image7:
			showDetailActivity(0, true, 6);
			break;
		case R.id.image8:
			showDetailActivity(0, true, 7);
			break;
		case R.id.image9:
			showDetailActivity(0, true, 8);
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
	
	public void showDetailActivity(int position, boolean isTop, int index){
		if(MyApp.p.getInt("userType", 2) == Utils.VIP){
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
