package com.rhkj.zhihuixue.activity;

import android.os.Bundle;

import com.rhkj.zhihuixue.R;
import com.rhkj.zhihuixue.base.BaseActivity;

public class MessagedetailsActivity extends BaseActivity {



    @Override
    protected void initLayout() {
        super.initLayout();
        setContentView(R.layout.activity_messagedetails);
    }

    @Override
    protected void initViews() {
        super.initViews();
        tvTitle.setText("消息详情");
    }

    @Override
    protected void initData() {
        super.initData();
    }
}
