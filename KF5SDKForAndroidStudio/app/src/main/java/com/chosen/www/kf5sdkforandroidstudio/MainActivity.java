package com.chosen.www.kf5sdkforandroidstudio;

import android.app.Activity;
import android.content.Context;
import android.graphics.Color;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.LinearLayout;
import android.widget.Toast;

import com.kf5sdk.api.CallBack;
import com.kf5sdk.config.ChatActivityParamsConfig;
import com.kf5sdk.config.ChatActivityUIConfig;
import com.kf5sdk.config.HelpCenterActivityUIConfig;
import com.kf5sdk.config.KF5ActivityUiConfig;
import com.kf5sdk.config.KF5SDKActivityParamsManager;
import com.kf5sdk.config.KF5SDKActivityUIManager;
import com.kf5sdk.config.api.HelpCenterTopRightBtnCallBack;
import com.kf5sdk.init.KF5SDKConfig;
import com.kf5sdk.init.UserInfo;
import com.kf5sdk.model.HelpCenterType;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

public class MainActivity extends AppCompatActivity {

    private Activity activity;

    private UserInfo kf5UserInfo;

    private LinearLayout layoutHelpCenter, layoutFeedBack, layoutLookFeedBack;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        activity = this;
        setKF5UI();
        layoutHelpCenter = (LinearLayout) findViewById(R.id.help_center_layout);
        layoutHelpCenter.setOnClickListener(new View.OnClickListener() {

            @Override
            public void onClick(View v) {
                // TODO Auto-generated method stub

                KF5SDKConfig.INSTANCE.startHelpCenterActivity(MainActivity.this, HelpCenterType.HELPCENTERTYPEPOST);

            }
        });

        layoutFeedBack = (LinearLayout) findViewById(R.id.feed_back_layout);
        layoutFeedBack.setOnClickListener(new View.OnClickListener() {

            @Override
            public void onClick(View v) {
                // TODO Auto-generated method stub

                KF5SDKConfig.INSTANCE.startFeedBackActivity(MainActivity.this);

            }
        });
        //
        layoutLookFeedBack = (LinearLayout) findViewById(R.id.look_feed_back_layout);
        layoutLookFeedBack.setOnClickListener(new View.OnClickListener() {

            @Override
            public void onClick(View v) {
                // TODO Auto-generated method stub

                KF5SDKConfig.INSTANCE.startFeedBackListActivity(MainActivity.this);

            }
        });

        LinearLayout layout = (LinearLayout) findViewById(R.id.chat_center);
        layout.setOnClickListener(new View.OnClickListener() {

            @Override
            public void onClick(View v) {
                // TODO Auto-generated method stub

                try {
                    JSONArray jsonArray = new JSONArray();
                    JSONObject jsonObject2 = new JSONObject();
                    jsonObject2.put("name", "field_11175");
                    jsonObject2.put("value", System.currentTimeMillis() + "");
                    jsonArray.put(jsonObject2);
                    ChatActivityParamsConfig chatActivityParamsConfig = new ChatActivityParamsConfig();
                    chatActivityParamsConfig.setUserParams(jsonArray.toString());
                    KF5SDKActivityParamsManager.setChatParamsConfig(chatActivityParamsConfig);
                    KF5SDKConfig.INSTANCE.startKF5ChatActivity(MainActivity.this);
                } catch (JSONException e) {
                    // TODO Auto-generated catch block
                    e.printStackTrace();
                }

                // startActivity(new Intent(getApplicationContext(),
                // KF5ChatActivity.class));
            }
        });
    }

    private void setKF5UI() {

        KF5ActivityUiConfig activityUiConfig = new KF5ActivityUiConfig();
        activityUiConfig.topBarHeight = 200;
        activityUiConfig.topBarBackground = Color.RED;

        activityUiConfig.setTvTitleTextSize(20);
        activityUiConfig.setTvRightViewTextSize(18);
        KF5SDKActivityUIManager.setKf5ActivityUiConfig(activityUiConfig);
        HelpCenterActivityUIConfig helpCenterConfig = new HelpCenterActivityUIConfig();
        helpCenterConfig.setTvConnectUsText("联系客服");
        helpCenterConfig.setTvTitleText("帮助中心");
        helpCenterConfig.setHelpCenterTopRightBtnCallBack(new HelpCenterTopRightBtnCallBack() {
            @Override
            public void onTopRightBtnClick(Context arg0) {
                // TODO Auto-generated method stub
                KF5SDKConfig.INSTANCE.startKF5ChatActivity(arg0);
            }
        });
        KF5SDKActivityUIManager.setHelpCenterActivityUIConfig(helpCenterConfig);
        ChatActivityUIConfig chatActivityUIConfig = new ChatActivityUIConfig();
        chatActivityUIConfig.setTvTicketVisible(false);
        chatActivityUIConfig.setShowDialogIfNoAgentOnline(true);
        KF5SDKActivityUIManager.setChatActivityUIConfig(chatActivityUIConfig);

        KF5SDKConfig.INSTANCE.init(MainActivity.this, getKF5UserInfo(), new CallBack() {

            @Override
            public void onSuccess(String result) {
                // TODO Auto-generated method stub
                runOnUiThread(new Runnable() {

                    @Override
                    public void run() {
                        // TODO Auto-generated method stub
                        Toast.makeText(activity, "登录成功", Toast.LENGTH_SHORT).show();
                    }
                });

            }

            @Override
            public void onFailure(String result) {
                // TODO Auto-generated method stub
            }
        });

        KF5SDKConfig.INSTANCE.savePushToken(MainActivity.this, new CallBack() {

            @Override
            public void onSuccess(final String arg0) {
                // TODO Auto-generated method stub
                runOnUiThread(new Runnable() {
                    public void run() {
                        Toast.makeText(activity, "保存成功" + arg0, Toast.LENGTH_SHORT).show();
                    }
                });

            }

            @Override
            public void onFailure(final String arg0) {
                // TODO Auto-generated method stub
                runOnUiThread(new Runnable() {
                    public void run() {
                        Toast.makeText(activity, "保存失败" + arg0, Toast.LENGTH_SHORT).show();
                    }
                });

            }
        });

    }

    /**
     * 注：appid的生成与查看方式请阅读https://support.kf5.com/hc/kb/article/199665/下第十一条FAQ
     * helpAddress即您所注册kf5平台的二级域名地址，例如demo.kf5.com
     * email，当前登录用户的邮箱，为保证用户的唯一性，每个用户的email必须不同。
     * phone,当前登录用户的手机号，为保证用户的唯一性，每个用户的phone必须不同。
     * email与phone至少填写其一，默认邮箱优先验证，如果需验证phone，则需设置kf5UserInfo.verifyPriorityType = VerifyPriorityType.VerifyPriorityTypePhone;
     * name即当前用户的昵称
     * sdkname即当前用户创建工单时显示的工单title
     *
     * @return
     */
    private UserInfo getKF5UserInfo() {
        if (kf5UserInfo == null) {
            kf5UserInfo = new UserInfo();
        }

        kf5UserInfo.appId = "00157032xxxxxxxxx6a8073e3ac7ec00";
        kf5UserInfo.helpAddress = "xxxxxx.kf5.com";
        kf5UserInfo.email = "xxxxxx@qq.com";
        kf5UserInfo.name = "Android测试";
        Toast.makeText(activity, "初始化SDK", Toast.LENGTH_SHORT).show();

        return kf5UserInfo;
    }
}
