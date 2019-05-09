package com.rhkj.zhihuixue.activity.mine;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;

import com.rhkj.zhihuixue.R;
import com.rhkj.zhihuixue.base.BaseActivity;

/**
 *  面对面分享
 */
public class ShareActivity extends BaseActivity {
    @Override
    protected void initLayout() {
        super.initLayout();
        setContentView(R.layout.activity_share);
    }

    @Override
    protected void initViews() {
        tvTitle.setText("分享");


    }
}
