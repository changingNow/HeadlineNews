package com.example.lw.headlinenews;

import android.app.Application;
import android.content.Context;
import android.support.multidex.MultiDex;

import com.raizlabs.android.dbflow.config.FlowManager;


/**
 * Created by lw on 17-11-24.
 */

public class HNApplication extends Application {

    private static Context context;

    @Override
    public void onCreate() {
        super.onCreate();
        this.context = getApplicationContext();
        MultiDex.install(context);
        FlowManager.init(context);
    }

    public static Context getAppContext() {
        return context;
    }
}
