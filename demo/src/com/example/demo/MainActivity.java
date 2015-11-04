package com.example.demo;


import com.kf5sdk.api.CallBack;
import com.kf5sdk.init.KF5SDKConfig;
import com.kf5sdk.init.UserInfo;
import com.kf5sdk.model.HelpCenterType;

import android.app.Activity;
import android.os.Bundle;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.Window;
import android.widget.LinearLayout;

public class MainActivity extends Activity {


	private LinearLayout layoutHelpCenter,layoutFeedBack,layoutLookFeedBack;
	
	

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		requestWindowFeature(Window.FEATURE_NO_TITLE);
		setContentView(R.layout.activity_main);

		UserInfo userInfo = new UserInfo();
		//		userInfo.appId = "00155f5851e24de5079262dda41816a9cd253e165ef799cf";
		//		userInfo.helpAddress = "joymay.kf5.com";
		//		userInfo.email = "888888@qq.com";
		//		userInfo.password = "1212356465";
		//		userInfo.name = "¿Æ±È1234";
		userInfo.setAppId("001561e7d848e79f55a2e93c3b75024d39dcc1fc4f1cd6cf");
		userInfo.setEmail("guest@kinglan.info");
		userInfo.setPassword("123456");
		userInfo.setHelpAddress("kinglan.kf5.com");
		userInfo.setName("kcdhrss");
		KF5SDKConfig.INSTANCE.init(MainActivity.this, userInfo, new CallBack() {

			@Override
			public void onSuccess(String result) {
				// TODO Auto-generated method stub

			}

			@Override
			public void onFailure(String result) {
				// TODO Auto-generated method stub

			}
		});

		layoutHelpCenter = (LinearLayout) findViewById(R.id.help_center_layout);
		layoutHelpCenter.setOnClickListener(new OnClickListener() {

			@Override
			public void onClick(View v) {
				// TODO Auto-generated method stub


				KF5SDKConfig.INSTANCE.startHelpCenterActivity(MainActivity.this, HelpCenterType.HELPCENTERTYPEPOST );

			}
		});

		layoutFeedBack = (LinearLayout) findViewById(R.id.feed_back_layout);
		layoutFeedBack.setOnClickListener(new OnClickListener() {

			@Override
			public void onClick(View v) {
				// TODO Auto-generated method stub

				KF5SDKConfig.INSTANCE.startFeedBackActivity(MainActivity.this);

			}
		});
		//
		layoutLookFeedBack = (LinearLayout) findViewById(R.id.look_feed_back_layout);
		layoutLookFeedBack.setOnClickListener(new OnClickListener() {

			@Override
			public void onClick(View v) {
				// TODO Auto-generated method stub

				KF5SDKConfig.INSTANCE.startFeedBackListActivity(MainActivity.this);

			}
		});
	}
}
