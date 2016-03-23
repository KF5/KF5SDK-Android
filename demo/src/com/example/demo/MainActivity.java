package com.example.demo;


import com.kf5sdk.api.CallBack;
import com.kf5sdk.init.KF5SDKConfig;
import com.kf5sdk.init.UserInfo;
import com.kf5sdk.model.HelpCenterType;
import com.kf5sdk.simpleapp.R;

import android.app.Activity;
import android.os.Bundle;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.Window;
import android.widget.LinearLayout;

public class MainActivity extends Activity {


	private LinearLayout layoutHelpCenter,layoutFeedBack,layoutLookFeedBack;

	private Activity activity;

	public static final String KEY_TITLE = "title";
	public static final String KEY_MESSAGE = "message";
	public static final String KEY_EXTRAS = "extras";

	public static final String MESSAGE_RECEIVED_ACTION = "com.example.jpushdemo.MESSAGE_RECEIVED_ACTION";

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		requestWindowFeature(Window.FEATURE_NO_TITLE);
		setContentView(R.layout.activity_main);
		activity = this;
		UserInfo userInfo = new UserInfo();

		userInfo.appId = "00155bxxx5exxxxa5aa21c6ffc35f7aa7ed0999d7c6b6029";
		userInfo.helpAddress = "xxxxg.kf5.com";
		userInfo.email = "12q33333@qq.com";
		userInfo.deviceToken = "";
		userInfo.name = "测试";


		


		KF5SDKConfig.INSTANCE.init(MainActivity.this, userInfo, new CallBack() {

			@Override
			public void onSuccess(String result) {
				// TODO Auto-generated method stub
				//				Toast.makeText(getApplicationContext(), "�ɹ�"+ result, 1).show();
				//				String pushID = JPushInterface.getRegistrationID(MainActivity.this);
				//				System.out.println(pushID+"==========");
				//				KF5SDKConfig.INSTANCE.savePushToken(activity, pushID);
			}

			@Override
			public void onFailure(String result) {
				// TODO Auto-generated method stub
				//				Toast.makeText(getApplicationContext(), "ʧ��"+ result, 1).show();
			}
		});

		layoutHelpCenter = (LinearLayout) findViewById(R.id.help_center_layout);
		layoutHelpCenter.setOnClickListener(new OnClickListener() {

			@Override
			public void onClick(View v) {
				// TODO Auto-generated method stub


				KF5SDKConfig.INSTANCE.startHelpCenterActivity(MainActivity.this, HelpCenterType.HELPCENTERDEFAULT );

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

		LinearLayout layout = (LinearLayout) findViewById(R.id.chat_center);
		layout.setOnClickListener(new OnClickListener() {

			@Override
			public void onClick(View v) {
				// TODO Auto-generated method stub
				KF5SDKConfig.INSTANCE.startKF5ChatActivity(MainActivity.this);
				//				startActivity(new Intent(getApplicationContext(), KF5ChatActivity.class));
			}
		});

	}
}
