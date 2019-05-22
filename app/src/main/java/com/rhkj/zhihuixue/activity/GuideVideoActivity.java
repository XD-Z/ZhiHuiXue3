package com.rhkj.zhihuixue.activity;

import android.view.View;

import com.rhkj.zhihuixue.R;
import com.rhkj.zhihuixue.base.BaseActivity;

/**
 * 直记直译引导视频页
 * <p>
 * Created by zjx on 2019/5/21.
 */

public class GuideVideoActivity extends BaseActivity implements View.OnClickListener {
    @Override
    protected void initLayout() {
        super.initLayout();
        setContentView(R.layout.ac_guide_video);
    }

    @Override
    protected void initViews() {
        tvTitle.setText("直记直译");



    }

    @Override
    protected void initData() {
        tvRight.setOnClickListener(this);
    }

    @Override
    public void onClick(View v) {


    }
}
