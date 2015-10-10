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
import android.widget.TextView;

public class MainActivity extends Activity {


	private TextView tv1,tv2,tv3,tv4,tv5;

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		requestWindowFeature(Window.FEATURE_NO_TITLE);
		setContentView(R.layout.activity_main);
		tv1 = (TextView) findViewById(R.id.activity_main_help_btn);

		UserInfo userInfo = new UserInfo();
		userInfo.appId = "00155f5851e24de5079262dda41816a9cd253e165ef799cf";
		userInfo.helpAddress = "joymay.kf5.com";
		userInfo.email = "888888@qq.com";
		//		userInfo.password = "1212356465";
		//		userInfo.name = "¿Æ±È1234";
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


		tv1.setOnClickListener(new OnClickListener() {

			@Override
			public void onClick(View v) {
				// TODO Auto-generated method stub


				KF5SDKConfig.INSTANCE.startHelpCenterActivity(MainActivity.this, HelpCenterType.HELPCENTERTYPEPOST );

			}
		});

		tv2 = (TextView) findViewById(R.id.activity_main_feedback_btn);
		tv2.setOnClickListener(new OnClickListener() {

			@Override
			public void onClick(View v) {
				// TODO Auto-generated method stub

				KF5SDKConfig.INSTANCE.startFeedBackActivity(MainActivity.this);

			}
		});
		//
		tv3 = (TextView) findViewById(R.id.activity_main_look_feedback_btn);
		tv3.setOnClickListener(new OnClickListener() {

			@Override
			public void onClick(View v) {
				// TODO Auto-generated method stub

				KF5SDKConfig.INSTANCE.startFeedBackListActivity(MainActivity.this);

			}
		});
	}
}
