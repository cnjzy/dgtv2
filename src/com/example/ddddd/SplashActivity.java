package com.example.ddddd;

import android.app.Activity;
import android.content.Intent;
import android.media.MediaPlayer;
import android.media.MediaPlayer.OnCompletionListener;
import android.net.Uri;
import android.os.Bundle;
import android.widget.VideoView;

public class SplashActivity extends BaseActivity{
	
	private VideoView mVideoView;
	
	@Override
	protected void onCreate(Bundle savedInstanceState) {
		// TODO Auto-generated method stub
		super.onCreate(savedInstanceState);
		
		setContentView(R.layout.activity_video);
		mVideoView = (VideoView) findViewById(R.id.video_view);
		
		mVideoView.setOnCompletionListener(new OnCompletionListener() {
			public void onCompletion(MediaPlayer mp) {
				Intent intent = new Intent(SplashActivity.this, MainActivity.class);
				startActivity(intent);
				finish();
			}
		});
		
		String str = "android.resource://" + getPackageName() + "/" + R.raw.video;
		mVideoView.setVideoURI(Uri.parse(str));
		mVideoView.start();
	}
	
	@Override
	protected void onDestroy() {
		super.onDestroy();
		mVideoView.pause();
		mVideoView.stopPlayback();
	}
}
