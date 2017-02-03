package com.chosen.www.kf5sdkforandroidstudio;

import android.app.Application;

import com.kf5sdk.init.KF5SDKInitializer;

/**
 * author:chosen
 * date:2017/2/3 14:49
 * email:812219713@qq.com
 */

public class TestApplication extends Application {

    @Override
    public void onCreate() {
        super.onCreate();
        KF5SDKInitializer.initialize(this);
    }
}
