package com.rhkj.zhihuixue;

import android.app.Application;


import com.rhkj.zhihuixue.utils.SharedPrefsUtil;

/**
 * Created by zjx on 2019/5/16.
 */

public class MyApp extends Application {


    @Override
    public void onCreate() {
        super.onCreate();
        SharedPrefsUtil.getInstance(this, "zhihuixue");
    }
}
