package com.example.demo;


import com.kf5sdk.api.CallBack;
import com.kf5sdk.config.ChatActivityUIConfig;
import com.kf5sdk.config.ChatAdapterUIConfig;
import com.kf5sdk.config.FeedBackActivityUIConfig;
import com.kf5sdk.config.FeedBackDetailsActivityUIConfig;
import com.kf5sdk.config.FeedBackDetailsAdapterUIConfig;
import com.kf5sdk.config.HelpCenterActivityUIConfig;
import com.kf5sdk.config.HelpCenterTypeDetailsActivityUIConfig;
import com.kf5sdk.config.KF5ActivityUiConfig;
import com.kf5sdk.config.KF5SDKActivityParamsManager;
import com.kf5sdk.config.KF5SDKActivityUIManager;
import com.kf5sdk.config.LookFeedBackAdapterUIConfig;
import com.kf5sdk.config.OrderAttributeActivityUIConfig;
import com.kf5sdk.config.OrderAttributeAdapterUIConfig;
import com.kf5sdk.config.api.ChoiceAttachmentItemClickCallBack;
import com.kf5sdk.config.api.DialogBtnClickCallBack;
import com.kf5sdk.config.api.HelpCenterTopRightBtnCallBack;
import com.kf5sdk.config.api.KF5ChatActivityTopRightBtnCallBack;
import com.kf5sdk.config.api.RatingDialogItemClickCallBack;
import com.kf5sdk.config.api.TicketChoiceAttachmentCallBack;
import com.kf5sdk.config.api.UserDefinedDialogCallBack;
import com.kf5sdk.config.api.UserDefinedRatingDialogCallBack;
import com.kf5sdk.init.KF5SDKConfig;
import com.kf5sdk.init.UserInfo;
import com.kf5sdk.model.HelpCenterType;
import com.kf5sdk.simpleapp.R;
import com.kf5sdk.view.ActionSheetDialog;
import com.kf5sdk.view.ChatDialog;
import com.kf5sdk.view.ChatDialog.onClickListener;

import android.annotation.SuppressLint;
import android.app.Activity;
import android.content.Context;
import android.graphics.Color;
import android.os.Bundle;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.Window;
import android.widget.LinearLayout;
import android.widget.Toast;

@SuppressLint("ResourceAsColor")
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
	
				
		//				XmlResourceParser xpp=Resources.getSystem().getXml(R.color.button_text);   
		//				try {  
		//				     ColorStateList csl= ColorStateList.createFromXml(getResources(),xpp);  
		//				     btn.setTextColor(csl);  
		//				} catch (Exception e) {  
		//				     // TODO: handle exception  
		//				}  
		//				Button btn=(Button)findViewById(R.id.btn);  
		//				Resources resource=(Resources)getBaseContext().getResources();   
		//				ColorStateList csl=(ColorStateList)resource.getColorStateList(R.color.button_text);  
		//				if(csl!=null){  
		//				     btn.setTextColor(color_state_list);//设置按钮文字颜色  
		//				}  

		//全局头部工具栏UI设置
		KF5ActivityUiConfig kf5ActivityUiConfig = new KF5ActivityUiConfig();
		//		kf5ActivityUiConfig.topBarBackground = Color.BLUE;
		kf5ActivityUiConfig.topBarHeight = 200;
//		kf5ActivityUiConfig.setTvRightViewTextSize(16);
//		kf5ActivityUiConfig.setTvTitleTextColor(Color.YELLOW);
//		kf5ActivityUiConfig.setTvTitleTextSize(18);
//		kf5ActivityUiConfig.setBackImgSource(R.drawable.back_img_source);
		kf5ActivityUiConfig.setTvRightViewBackgroundSoure(R.drawable.chat);
		kf5ActivityUiConfig.setThemeId(R.style.TestAppTheme);
		kf5ActivityUiConfig.setTicketChoiceAttachmentCallBack(new TicketChoiceAttachmentCallBack() {
			
			@Override
			public void onChoiceAttachment(Context context,
					final ChoiceAttachmentItemClickCallBack choiceAttachmentItemClickCallBack) {
				// TODO Auto-generated method stub
				
				new ActionSheetDialog(context)
				.builder()
				.setCancelable(true)
				.setCanceledOnTouchOutside(true)
				.addSheetItem("相机", ActionSheetDialog.SheetItemColor.Red,
						new ActionSheetDialog.OnSheetItemClickListener() {
					@Override
					public void onClick(int which) {
						if (choiceAttachmentItemClickCallBack !=  null) {
							choiceAttachmentItemClickCallBack.capturePictureFromCamera();
						}
					}
				})
				.addSheetItem("相册", ActionSheetDialog.SheetItemColor.Red,
						new ActionSheetDialog.OnSheetItemClickListener() {
					@Override
					public void onClick(int which) {
						if (choiceAttachmentItemClickCallBack != null) {
							choiceAttachmentItemClickCallBack.choicePicturFromFile();
						}
					}
				}).show();
				
			}
		});
		kf5ActivityUiConfig.setUserDefinedDialogCallBack(new UserDefinedDialogCallBack() {
			
			@Override
			public void onShowUserDefinedDialog(Context context, String title, String content, String leftBtnText,
					String rightBtnText, DialogBtnClickCallBack dialogBtnClickCallBack) {
				// TODO Auto-generated method stub
//				dialogBtnClickCallBack.onPositiveBtnClick();
				Toast.makeText(context, content, Toast.LENGTH_SHORT).show();
			}
		});
		//		kf5ActivityUiConfig.setHttpRequestLoadingDialogCallBack(new HttpRequestLoadingDialogCallBack() {
		//
		//			@Override
		//			public void onHttpRequestStart(Context context,String content) {
		//				// TODO Auto-generated method stub
		//				Toast.makeText(activity, "请求开始"+content, Toast.LENGTH_SHORT).show();
		//			}
		//
		//			@Override
		//			public void onHttpRequestFinish(Context context) {
		//				// TODO Auto-generated method stub
		//				Toast.makeText(activity, "请求结束", Toast.LENGTH_SHORT).show();
		//			}
		//		});
		KF5SDKActivityUIManager.setKf5ActivityUiConfig(kf5ActivityUiConfig);


		userInfo.appId = "0015703xxx1145ffa131exxxx73e3ac7ec00";
		userInfo.helpAddress = "xxxx.kf5.com";
		userInfo.email = "123@qq.com";
		userInfo.deviceToken = "";
		userInfo.name = "测试";
		userInfo.phone = "187xxxx5679";



		//工单反馈界面UI设置
		FeedBackActivityUIConfig feedBackActivityUIConfig = new FeedBackActivityUIConfig();
		feedBackActivityUIConfig.setImageBtnSource(R.drawable.back_img_source);
		feedBackActivityUIConfig.setItemAttachmentNameTextColor(Color.BLUE);
		feedBackActivityUIConfig.setItemAttachmentNameTextSize(20);
		feedBackActivityUIConfig.setItemImageSource(R.drawable.ic_launcher);
		feedBackActivityUIConfig.setItemTvRemoveTextColor(Color.GREEN);
		feedBackActivityUIConfig.setItemTvRemoveTextSize(10);
		feedBackActivityUIConfig.setTvCommitContent("点我");
		feedBackActivityUIConfig.setTvTitleContent("我要反馈");
		feedBackActivityUIConfig.setEtContentHint("请在这里输入你要反馈的内容");
		feedBackActivityUIConfig.setEtContentTextColor(getResources().getColor(R.color.et_content_text_color));
		feedBackActivityUIConfig.setEtHintTextColor(getResources().getColor(R.color.et_hint_text_color));
		feedBackActivityUIConfig.setEtContentTextSize(18);
		feedBackActivityUIConfig.setEtBackgroundSource(R.color.et_content_text_color);
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

		//工单属性适配器UI设置
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

		//工单属性界面UI设置
		OrderAttributeActivityUIConfig orderAttributeActivityUIConfig = new OrderAttributeActivityUIConfig();
		orderAttributeActivityUIConfig.setTvTitleContent("工单属性噢");
		KF5SDKActivityUIManager.setOrderAttributeActivityUIConfig(orderAttributeActivityUIConfig);
		
		//反馈详情界面UI设置
		FeedBackDetailsActivityUIConfig feedBackDetailsActivityUIConfig = new FeedBackDetailsActivityUIConfig();
		feedBackDetailsActivityUIConfig.setTvSubmitTextSize(22);
		feedBackDetailsActivityUIConfig.setTvSubmitTextColor(R.drawable.text_colordrawable);
		feedBackDetailsActivityUIConfig.setTvSendText("开始发送");
		feedBackDetailsActivityUIConfig.setEtContentHint("你可以输入你想要的内容");
//		feedBackDetailsActivityUIConfig.setEtContentTextColor(getResources().getColor(R.color.et_content_text_color));
//		feedBackDetailsActivityUIConfig.setBackContentLayoutImageSource(R.drawable.ic_launcher);
//		feedBackDetailsActivityUIConfig.setEtBackgroundSource(R.color.et_content_text_color);
//		feedBackDetailsActivityUIConfig.setShowChoiceImageDialogImageSource(R.drawable.help_center);
//		feedBackDetailsActivityUIConfig.setShowImageLayoutImageSource(R.drawable.feed_back);
//		feedBackDetailsActivityUIConfig.setTvSendBackgroundSource(R.color.et_hint_text_color);
		KF5SDKActivityUIManager.setFeedBackDetailsActivityUIConfig(feedBackDetailsActivityUIConfig);

		LookFeedBackAdapterUIConfig lookFeedBackAdapterUIConfig = new LookFeedBackAdapterUIConfig();
		lookFeedBackAdapterUIConfig.setTvDateTextColor(Color.BLUE);
		lookFeedBackAdapterUIConfig.setTvDateTextSize(16);
		lookFeedBackAdapterUIConfig.setTvStatusTextColor(Color.RED);
		lookFeedBackAdapterUIConfig.setTvStatusTextSize(18);
		lookFeedBackAdapterUIConfig.setTvTitleTextColor(Color.YELLOW);
		lookFeedBackAdapterUIConfig.setTvTitleTextSize(20);
		KF5SDKActivityUIManager.setLookFeedBackAdapterUIConfig(lookFeedBackAdapterUIConfig);

		//IM界面UI设置
		ChatActivityUIConfig chatActivityUIConfig = new ChatActivityUIConfig();
		chatActivityUIConfig.setTvTicketText("自定义内容");
		chatActivityUIConfig.setShowPopwindow(false);
		chatActivityUIConfig.setRatDialogTitle("开始评价,你已经评价成功，请不要再次评价了你已经评价成功，请不要再次评价了你已经");
		chatActivityUIConfig.setRatTipContentIfRatingSuccess("你已经评价成功，请不要再次评价了");
		chatActivityUIConfig.setShowContentWhenChatEnd("恋爱已结束");
		chatActivityUIConfig.setShowContentWhenGetAgent("正在找人搭理你");
		chatActivityUIConfig.setShowContentWhenNoAgentOnline("没有人打理你");
		chatActivityUIConfig.setTitleForDialogIfNoAgentOnline("提示一下，没有人搭理你");
		chatActivityUIConfig.setShowContentWhenConnecting("正在寻找客服噢....");
//		chatActivityUIConfig.setTvTitleVisible(false);
		chatActivityUIConfig.setUserDefinedRatingDialogCallBack(new UserDefinedRatingDialogCallBack() {
			
			@Override
			public void onUserDefinedRatingDialogShow(Context context,
					final RatingDialogItemClickCallBack ratingDialogItemClickCallBack) {
				// TODO Auto-generated method stub
				new ChatDialog(context)
				.setTitle("提示一下")
				.setMessage("你需要评价一下他的回复")
				.setLeftButton("不满意", new  onClickListener() {
					
					@Override
					public void onClick(ChatDialog dialog) {
						// TODO Auto-generated method stub
						dialog.dismiss();
						ratingDialogItemClickCallBack.onRatingDialogItemClick(0);
					}
				}).setRightButton("确定", new onClickListener() {
					
					@Override
					public void onClick(ChatDialog dialog) {
						// TODO Auto-generated method stub
						dialog.dismiss();
						ratingDialogItemClickCallBack.onRatingDialogItemClick(1);
					}
				}).show();
			}
		});
		chatActivityUIConfig.setKf5ChatActivityTopRightBtnCallBack(new KF5ChatActivityTopRightBtnCallBack() {

			@Override
			public void onTopRightBtnClick(Context context) {
				// TODO Auto-generated method stub
				Toast.makeText(context, "这里是自定义回调噢", Toast.LENGTH_SHORT).show();
			}
		});
		KF5SDKActivityUIManager.setChatActivityUIConfig(chatActivityUIConfig);
		
		
		KF5SDKConfig.INSTANCE.init(MainActivity.this, userInfo, new CallBack() {

			@Override
			public void onSuccess(String result) {
				// TODO Auto-generated method stub
				Toast.makeText(activity, "登录成功", Toast.LENGTH_SHORT).show();
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

	@Override
	protected void onDestroy() {
		// TODO Auto-generated method stub
		super.onDestroy();
		KF5SDKActivityUIManager.resetActivityUIConfig();
		KF5SDKActivityParamsManager.resetActivityParamsConfig();
	}


}
