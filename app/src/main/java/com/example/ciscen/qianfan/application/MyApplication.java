package com.example.ciscen.qianfan.application;

import android.app.Application;

import org.xutils.x;

/**
 * Created by Chong on 2016/7/18.
 */
public class MyApplication extends Application{
    @Override
    public void onCreate() {
        super.onCreate();
        x.Ext.init(this);
        x.Ext.setDebug(true);
    }
}
