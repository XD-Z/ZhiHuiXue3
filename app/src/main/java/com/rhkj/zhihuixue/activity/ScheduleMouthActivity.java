package com.rhkj.zhihuixue.activity;


import android.os.Bundle;
import android.view.View;
import android.view.WindowManager;
import android.widget.TextView;

import com.rhkj.zhihuixue.R;
import com.rhkj.zhihuixue.base.BaseActivity;

import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.OnClick;

/**
 * 口语训练平台
 * <p>
 * Created by zjx on 2019/5/8.
 */

public class ScheduleMouthActivity extends BaseActivity {


    @BindView(R.id.skip_video_title)
    TextView skipVideoTitle;
    @BindView(R.id.skip_video_skip)
    TextView skipVideoSkip;

    @Override
    protected void initLayout() {
        getWindow().setFlags(WindowManager.LayoutParams.FLAG_FULLSCREEN,//去掉状态栏
                WindowManager.LayoutParams.FLAG_FULLSCREEN);
        setContentView(R.layout.activity_schedulemouth);
        // TODO: add setContentView(...) invocation
        ButterKnife.bind(this);
    }

    @Override
    protected void initViews() {
        skipVideoTitle.setText("选择语法");
        skipVideoSkip.setText("我的证书");

    }


    @OnClick({R.id.skip_video_back, R.id.skip_video_skip})
    public void onViewClicked(View view) {
        switch (view.getId()) {
            case R.id.skip_video_back:
                finish();
                break;
            case R.id.skip_video_skip:

                break;
        }
    }
}
