package com.example.demo;


import com.kf5sdk.api.CallBack;
import com.kf5sdk.config.KF5ActivityUiConfig;
import com.kf5sdk.config.KF5SDKActivityUIManager;
import com.kf5sdk.init.KF5SDKConfig;
import com.kf5sdk.init.UserInfo;
import com.kf5sdk.model.HelpCenterType;
import com.kf5sdk.simpleapp.R;

import android.app.Activity;
import android.graphics.Color;
import android.os.Bundle;
import android.text.Html;
import android.text.Layout;
import android.text.Spannable;
import android.text.SpannableStringBuilder;
import android.text.Spanned;
import android.text.method.LinkMovementMethod;
import android.text.style.BackgroundColorSpan;
import android.text.style.ClickableSpan;
import android.text.style.URLSpan;
import android.text.util.Linkify;
import android.util.Patterns;
import android.view.MotionEvent;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.Window;
import android.widget.LinearLayout;
import android.widget.TextView;

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
	


		KF5ActivityUiConfig kf5ActivityUiConfig = new KF5ActivityUiConfig();
		kf5ActivityUiConfig.topBarBackground = Color.BLUE;
		kf5ActivityUiConfig.topBarHeight = 200;
		KF5SDKActivityUIManager.setKf5ActivityUiConfig(kf5ActivityUiConfig);
				userInfo.appId = "00131211421354f6a8073e3ac7ec00f6a8073e3ac7ec00";
				userInfo.helpAddress = "xxxx.kf5.com";
				userInfo.email = "123@qq.com";
				userInfo.deviceToken = "";
				userInfo.name = "测试";
				userInfo.phone = "18712475678";



		


		KF5SDKConfig.INSTANCE.init(MainActivity.this, userInfo, new CallBack() {

			@Override
			public void onSuccess(String result) {
				// TODO Auto-generated method stub
				//				Toast.makeText(getApplicationContext(), "�ɹ�"+ result, 1).show();
				//				String pushID = JPushInterface.getRegistrationID(MainActivity.this);
				//				System.out.println(pushID+"==========");
				//				KF5SDKConfig.INSTANCE.savePushToken(activity, pushID);
				//				KF5SDKConfig.INSTANCE.deletePushToken(MainActivity.this, "1213546654asdzxcasd" , new CallBack() {
				//
				//					@Override
				//					public void onSuccess(final String result) {
				//						// TODO Auto-generated method stub
				//						System.out.println("==========成功"+result);
				//						runOnUiThread(new Runnable() {
				//							
				//							@Override
				//							public void run() {
				//								// TODO Auto-generated method stub
				//							try {
				//								Toast.makeText(activity, new JSONObject(result).getString("message"), 1).show();
				//							} catch (JSONException e) {
				//								// TODO Auto-generated catch block
				//								e.printStackTrace();
				//							}	
				//							}
				//						});
				//					}
				//
				//					@Override
				//					public void onFailure(String result) {
				//						// TODO Auto-generated method stub
				//						System.out.println("==========失败"+result);
				//					}
				//				});
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
