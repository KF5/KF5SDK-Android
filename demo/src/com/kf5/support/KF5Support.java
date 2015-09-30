package com.kf5.support;

import com.kf5sdk.base.KF5BaseMethod;

import android.app.AlertDialog;
import android.content.Context;
import android.widget.TextView;

public class KF5Support  extends KF5BaseMethod{

	@Override
	public boolean addParams() {
		// TODO Auto-generated method stub
		return true;
	}

	@Override
	public void addParamsInFeedBackListActivity(Context arg0) {
		// TODO Auto-generated method stub
//		Toast.makeText(arg0, "呵呵，开始实现", 1).show();
//		Intent intent = new Intent(arg0, MainActivity.class);
//		arg0.startActivity(intent);
		AlertDialog.Builder builder = new AlertDialog.Builder(arg0);
		TextView textView = new TextView(arg0);
		textView.setText("我要提交参数");
		builder.setView(textView);
		builder.setPositiveButton("确定", null);
		builder.setNegativeButton("取消", null);
		builder.create().show();
		
	}

}
