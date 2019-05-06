package com.rhkj.zhihuixue.activity;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;

import com.gyf.barlibrary.ImmersionBar;
import com.rhkj.zhihuixue.R;
import com.rhkj.zhihuixue.base.BaseActivity;

public class LoginActivity extends BaseActivity {

    @Override
    protected void initViews() {
        setContentView(R.layout.activity_login);
        ImmersionBar.with(this)
                .statusBarColor(R.color.colorBlack)     //状态栏颜色，不写默认透明色

                .init();
    }

    @Override
    protected void initData() {
        super.initData();
    }
}
