package com.example.demo;


import com.kf5sdk.api.CallBack;
import com.kf5sdk.config.ChatAdapterUIConfig;
import com.kf5sdk.config.FeedBackActivityUIConfig;
import com.kf5sdk.config.FeedBackDetailsActivityUIConfig;
import com.kf5sdk.config.FeedBackDetailsAdapterUIConfig;
import com.kf5sdk.config.HelpCenterActivityUIConfig;
import com.kf5sdk.config.HelpCenterTypeDetailsActivityUIConfig;
import com.kf5sdk.config.KF5ActivityUiConfig;
import com.kf5sdk.config.KF5SDKActivityUIManager;
import com.kf5sdk.config.LookFeedBackAdapterUIConfig;
import com.kf5sdk.config.OrderAttributeActivityUIConfig;
import com.kf5sdk.config.OrderAttributeAdapterUIConfig;
import com.kf5sdk.config.api.HelpCenterTopRightBtnCallBack;
import com.kf5sdk.init.KF5SDKConfig;
import com.kf5sdk.init.UserInfo;
import com.kf5sdk.model.HelpCenterType;
import com.kf5sdk.simpleapp.R;

import android.app.Activity;
import android.content.Context;
import android.content.res.ColorStateList;
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
import android.widget.Toast;

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
		userInfo.appId = "00155beexc3xax6b6029";
		userInfo.helpAddress = "xxxxxg.kf5.com";
		userInfo.email = "88xxxxx213@qq.com";
		userInfo.deviceToken = "";
		userInfo.name = "测试";
		userInfo.phone = "1xxxx5678";


		
		//全局头部工具栏UI设置
		KF5ActivityUiConfig kf5ActivityUiConfig = new KF5ActivityUiConfig();
		//		kf5ActivityUiConfig.topBarBackground = Color.BLUE;
		kf5ActivityUiConfig.topBarHeight = 200;
		//		kf5ActivityUiConfig.setTvRightViewTextColor(R.drawable.text_colordrawable);
		//		kf5ActivityUiConfig.setTvRightViewTextColor(Color.RED);
		kf5ActivityUiConfig.setTvRightViewTextSize(16);
		kf5ActivityUiConfig.setTvRightViewTextColorId(R.drawable.text_colordrawable);
		kf5ActivityUiConfig.setTvTitleTextColor(Color.YELLOW);
		kf5ActivityUiConfig.setTvTitleTextSize(18);
		kf5ActivityUiConfig.setBackImgSource(R.drawable.back_img_source);
		KF5SDKActivityUIManager.setKf5ActivityUiConfig(kf5ActivityUiConfig);


		

		//工单反馈界面UI设置
		FeedBackActivityUIConfig feedBackActivityUIConfig = new FeedBackActivityUIConfig();
		feedBackActivityUIConfig.setImageBtnSource(R.drawable.feed_back);
		feedBackActivityUIConfig.setItemAttachmentNameTextColor(Color.BLUE);
		feedBackActivityUIConfig.setItemAttachmentNameTextSize(20);
		feedBackActivityUIConfig.setItemImageSource(R.drawable.ic_launcher);
		feedBackActivityUIConfig.setItemTvRemoveTextColor(Color.GREEN);
		feedBackActivityUIConfig.setItemTvRemoveTextSize(10);
		feedBackActivityUIConfig.setTvCommitContent("点我");
		feedBackActivityUIConfig.setTvTitleContent("我要反馈");
		KF5SDKActivityUIManager.setFeedBackActivityUIConfig(feedBackActivityUIConfig);



		//工单回复详情适配器UI设置
		FeedBackDetailsAdapterUIConfig  feedBackDetailsAdapterUIConfig = new FeedBackDetailsAdapterUIConfig();
		feedBackDetailsAdapterUIConfig.setTvContentTextColor(Color.GREEN);
		feedBackDetailsAdapterUIConfig.setTvContentTextSize(20);
		feedBackDetailsAdapterUIConfig.setTvDateTextColor(Color.RED);
		feedBackDetailsAdapterUIConfig.setTvDateTextSize(10);
		feedBackDetailsAdapterUIConfig.setTvNameTextColor(Color.YELLOW);
		feedBackDetailsAdapterUIConfig.setTvNameTextSize(16);
		KF5SDKActivityUIManager.setFeedBackDetailsAdapterUIConfig(feedBackDetailsAdapterUIConfig);

		//工单属性界面UI设置
		OrderAttributeAdapterUIConfig orderAttributeAdapterUIConfig = new  OrderAttributeAdapterUIConfig();
		orderAttributeAdapterUIConfig.setTvLabelTextColor(Color.GREEN);
		orderAttributeAdapterUIConfig.setTvLabelTextSize(22);
		orderAttributeAdapterUIConfig.setTvValueTextColor(Color.YELLOW);
		orderAttributeAdapterUIConfig.setTvValueTextSize(14);
		KF5SDKActivityUIManager.setOrderAttributeAdapterUIConfig(orderAttributeAdapterUIConfig);


		//帮助中心详情UI设置
		HelpCenterTypeDetailsActivityUIConfig helpCenterTypeDetailsActivityUIConfig = new HelpCenterTypeDetailsActivityUIConfig();
		helpCenterTypeDetailsActivityUIConfig.setTvContentTitleTextColor(Color.YELLOW);
		helpCenterTypeDetailsActivityUIConfig.setTvContentTitleTextSize(10);
		helpCenterTypeDetailsActivityUIConfig.setTvDateTextColor(Color.RED);
		helpCenterTypeDetailsActivityUIConfig.setTvDateTextSize(22);
		KF5SDKActivityUIManager.setHelpCenterTypeDetailsActivityUIConfig(helpCenterTypeDetailsActivityUIConfig);

		//IM适配器UI设置
		ChatAdapterUIConfig chatAdapterUIConfig = new ChatAdapterUIConfig();
		chatAdapterUIConfig.setMsgComeTextColor(Color.YELLOW);
		chatAdapterUIConfig.setMsgSendTextColor(Color.GREEN);
		chatAdapterUIConfig.setTvContentTextSize(12);
		chatAdapterUIConfig.setMsgComeLinkTextColor(Color.GREEN);
		chatAdapterUIConfig.setMsgSendLinkTextColor(Color.YELLOW);
		KF5SDKActivityUIManager.setChatAdapterUIConfig(chatAdapterUIConfig);

		//帮助中心UI设置
		HelpCenterActivityUIConfig helpCenterActivityUIConfig = new HelpCenterActivityUIConfig();
		helpCenterActivityUIConfig.setAdapterItemTitleTextColor(Color.RED);
		helpCenterActivityUIConfig.setAdapterItemTitleTextSize(18);
		helpCenterActivityUIConfig.setHelpCenterTopRightBtnCallBack(new HelpCenterTopRightBtnCallBack() {

			@Override
			public void onTopRightBtnClick(Context context) {
				// TODO Auto-generated method stub
				Toast.makeText(activity, "现在全体都使用这一个回调事件咯", Toast.LENGTH_LONG).show();
			}
		});
		KF5SDKActivityUIManager.setHelpCenterActivityUIConfig(helpCenterActivityUIConfig);


		//反馈详情界面UI设置
		FeedBackDetailsActivityUIConfig feedBackDetailsActivityUIConfig = new FeedBackDetailsActivityUIConfig();
		feedBackDetailsActivityUIConfig.setTvSubmitTextSize(22);
		feedBackDetailsActivityUIConfig.setTvSubmitTextColor(R.drawable.text_colordrawable);
		KF5SDKActivityUIManager.setFeedBackDetailsActivityUIConfig(feedBackDetailsActivityUIConfig);

		LookFeedBackAdapterUIConfig lookFeedBackAdapterUIConfig = new LookFeedBackAdapterUIConfig();
		lookFeedBackAdapterUIConfig.setTvDateTextColor(Color.BLUE);
		lookFeedBackAdapterUIConfig.setTvDateTextSize(16);
		lookFeedBackAdapterUIConfig.setTvStatusTextColor(Color.RED);
		lookFeedBackAdapterUIConfig.setTvStatusTextSize(18);
		lookFeedBackAdapterUIConfig.setTvTitleTextColor(Color.YELLOW);
		lookFeedBackAdapterUIConfig.setTvTitleTextSize(20);
		KF5SDKActivityUIManager.setLookFeedBackAdapterUIConfig(lookFeedBackAdapterUIConfig);

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
