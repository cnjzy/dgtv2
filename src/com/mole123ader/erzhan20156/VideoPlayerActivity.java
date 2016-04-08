package com.mole123ader.erzhan20156;

import android.app.Activity;
import android.app.ProgressDialog;
import android.content.Context;
import android.content.Intent;
import android.content.pm.ActivityInfo;
import android.media.MediaPlayer;
import android.media.MediaPlayer.OnPreparedListener;
import android.net.Uri;
import android.os.Bundle;
import android.os.CountDownTimer;
import android.view.View;
import android.view.WindowManager;
import android.widget.MediaController;
import android.widget.TextView;
import android.widget.VideoView;

import com.mole123ader.erzhan20156.utils.DialogUtils;
import com.mole123ader.erzhan20156.utils.DialogUtils.OnAlertSelectId;
import com.mole123ader.erzhan20156.utils.Utils;
import com.wo.main.WP_SDK;

public class VideoPlayerActivity extends BaseActivity implements
		MediaPlayer.OnErrorListener, MediaPlayer.OnCompletionListener {
	private Activity context = this;
	
	public static final String TAG = "VideoPlayer";
	private VideoView mVideoView;
	private Uri mUri;
	private int mPositionWhenPaused = -1;
	private MediaController mMediaController;

	private TextView video_count_down_tv;
	
	private ProgressDialog loadingDialog;
	
	private boolean isTest = true;
	private boolean isPlayer = true;
	private String videoUrl = "";
	private int countDown;
	
	/**
     * 计时器
     */
    private CountDownTimer contDownTimer;
	
	@Override
	protected void onCreate(Bundle savedInstanceState) {
		getWindow().addFlags(WindowManager.LayoutParams.FLAG_KEEP_SCREEN_ON); 
		this.setRequestedOrientation(ActivityInfo.SCREEN_ORIENTATION_LANDSCAPE);
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_video);
		
		isTest = getIntent().getBooleanExtra("isTest", true);
		videoUrl = getIntent().getStringExtra("videoUrl");
		countDown = getIntent().getIntExtra("countDown", 20);
		
		mVideoView = (VideoView) findViewById(R.id.video_view);
		mVideoView.setOnPreparedListener(new OnPreparedListener() {
			public void onPrepared(MediaPlayer mp) {
				mp.setVolume(1, 1);
				dismissLoading();
				
				System.err.println("======width:" + mp.getVideoWidth() + " height:" + mp.getVideoHeight());
			}
		});
		
		video_count_down_tv = (TextView) findViewById(R.id.video_count_down_tv);
		
		// Create media controller，组件可以控制视频的播放，暂停，回复，seek等操作，不需要你实现
		if(!isTest){
			mMediaController = new MediaController(this);
			mVideoView.setMediaController(mMediaController);
		}else{
			
			video_count_down_tv.setVisibility(View.VISIBLE);
            contDownTimer = new CountDownTimer(countDown * 1000, 1000) {  
                public void onTick(long millisUntilFinished) {
                	video_count_down_tv.setText("试播还剩：" + millisUntilFinished/1000 + "秒");
                }  
                public void onFinish() {  
                    if(!isFinishing() && contDownTimer != null){
                    	video_count_down_tv.setText("试播还剩：0秒");
                    	mVideoView.pause();
                    	isPlayer = false;
                    	DialogUtils.showPayDialog(context, new OnAlertSelectId() {
							public void onClick(int whichButton, Object o) {
								getOrder(Utils.amount, whichButton, 2);
							}
						});
                    }
                }  
             }.start(); 
		}
		// Video file
		mUri = Uri.parse(videoUrl);
		WP_SDK.on_Init(this);
	}

	public void onStart() {
		if(isPlayer){
			showLoading();
			// Play Video
			mVideoView.setVideoURI(mUri);
			mVideoView.start();
		}

		super.onStart();
	}

	public void onResume() {
		if(isPlayer){
			// Resume video player
			if (mPositionWhenPaused >= 0) {
				mVideoView.seekTo(mPositionWhenPaused);
				mPositionWhenPaused = -1;
			}
		}

		super.onResume();
	}

	public void onPause() {
		// Stop video when the activity is pause.
		mPositionWhenPaused = mVideoView.getCurrentPosition();
		mVideoView.stopPlayback();

		super.onPause();
	}

	@Override
	protected void onDestroy() {
		dismissLoading();
		if(contDownTimer != null){
			contDownTimer.cancel();
			contDownTimer = null;
		}
		super.onDestroy();
	}

	public boolean onError(MediaPlayer player, int arg1, int arg2) {
		return false;
	}

	public void onCompletion(MediaPlayer mp) {
	}

	private void showLoading() {
		if(loadingDialog == null){
			loadingDialog = new ProgressDialog(context);
			loadingDialog.setMessage("正在加载");
		}
		if (loadingDialog != null && !loadingDialog.isShowing()) {
			loadingDialog.show();
		}
	}

	private void dismissLoading() {
		if (loadingDialog != null && loadingDialog.isShowing()) {
			loadingDialog.dismiss();
		}
	}
	
	public static void show(Context context, String url, boolean isTest, int countDown){
		Intent intent = new Intent(context, VideoPlayerActivity.class);
		intent.putExtra("isTest", isTest);
		intent.putExtra("videoUrl", url);
		intent.putExtra("countDown", countDown);
		context.startActivity(intent);
	}
}
