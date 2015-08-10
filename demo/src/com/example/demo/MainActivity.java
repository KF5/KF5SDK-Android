package com.example.demo;

import com.kf5sdk.api.CallBack;
import com.kf5sdk.model.HelpCenterType;
import com.kf5sdk.model.KF5SDKConfig;

import android.app.Activity;
import android.os.Bundle;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.Window;
import android.widget.TextView;
import android.widget.Toast;

public class MainActivity extends Activity {


	private TextView tv1,tv2,tv3,tv4,tv5;

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		requestWindowFeature(Window.FEATURE_NO_TITLE);
		setContentView(R.layout.activity_main);
		tv1 = (TextView) findViewById(R.id.activity_main_help_btn);
		//		
		//		KF5SDKConfig.INSTANCE.init(MainActivity.this,"tianxiang.kf5.com","1234567@ncrxsz.org", "111111", 
		//				"001552bace471f5b06e40e803231d450366cdc2095621fa0",
		//				new CallBack() {
		//
		//			@Override
		//			public void onSuccess(String arg0) {
		//				// TODO Auto-generated method stub
		//
		//			}
		//
		//			@Override
		//			public void onFailure(String arg0) {
		//				// TODO Auto-generated method stub
		//
		//			}
		//		});

		KF5SDKConfig.INSTANCE.init(MainActivity.this,"tianxiang.kf5.com","111@kf5.com", 
				"00155b5f81ac5a9318cd15ca21123187c1e381d1d7e577ca",new CallBack() {

			@Override
			public void onSuccess(String result) {
				// TODO Auto-generated method stub
				Toast.makeText(MainActivity.this, result, 1).show();
			}

			@Override
			public void onFailure(String result) {
				// TODO Auto-generated method stub
				Toast.makeText(MainActivity.this, result, 1).show();
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
