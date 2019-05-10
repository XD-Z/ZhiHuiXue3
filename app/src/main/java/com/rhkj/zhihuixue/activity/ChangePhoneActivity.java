package com.rhkj.zhihuixue.activity;

import android.os.Bundle;

import com.rhkj.zhihuixue.R;
import com.rhkj.zhihuixue.base.BaseActivity;

public class ChangePhoneActivity extends BaseActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_change_phone);
    }

    @Override
    protected void initLayout() {
        super.initLayout();
    }

    @Override
    protected void initViews() {
        super.initViews();
        tvTitle.setText("更换手机号");
    }
}
