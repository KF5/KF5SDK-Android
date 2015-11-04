package com.example.demo;



import com.kf5sdk.init.KF5SDKInitializer;

import android.app.Application;


public class MyApplication 	extends Application{

	@Override
	public void onCreate() {
		// TODO Auto-generated method stub
		super.onCreate();
		KF5SDKInitializer.initialize(this);
	}

}
