package com.rhkj.zhihuixue.activity.login_register;

import android.os.Bundle;

import com.rhkj.zhihuixue.R;
import com.rhkj.zhihuixue.base.BaseActivity;

public class AmendPasswordActivity extends BaseActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_amend);
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
