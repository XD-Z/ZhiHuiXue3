package com.rhkj.zhihuixue.activity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.view.Window;
import android.view.WindowManager;
import android.widget.ImageView;
import android.widget.TextView;

import com.rhkj.zhihuixue.R;
import com.rhkj.zhihuixue.base.BaseActivity;

import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.OnClick;

public class SkipvidioActivity extends BaseActivity {

    @BindView(R.id.skip_video_back)
    ImageView skipVideoBack;
    @BindView(R.id.skip_video_title)
    TextView skipVideoTitle;
    @BindView(R.id.skip_video_skip)
    TextView skipVideoSkip;
    private Intent intent;
    private String zhi_type;

    @Override
    protected void initLayout() {
        getWindow().setFlags(WindowManager.LayoutParams.FLAG_FULLSCREEN,//去掉状态栏
                WindowManager.LayoutParams.FLAG_FULLSCREEN);
        setContentView(R.layout.activity_skipvidio);

        ButterKnife.bind(this);

        intent = getIntent();
        zhi_type = intent.getStringExtra("zhi_type");
        if (zhi_type.equals(1 + "")) {
            skipVideoTitle.setText("直记直译");
        } else if (zhi_type.equals(2 + "")) {
            skipVideoTitle.setText("口语训练平台");
        } else if (zhi_type.equals(3 + "")) {
            skipVideoTitle.setText("语法易点通");
        }
    }

    @Override
    protected void initViews() {
        super.initViews();
        intent = getIntent();
    }

    @Override
    protected void initData() {
        super.initData();
    }


    @OnClick({R.id.skip_video_back, R.id.skip_video_skip})
    public void onViewClicked(View view) {
        switch (view.getId()) {
            case R.id.skip_video_back:
                finish();
                break;
            case R.id.skip_video_skip:
                if (zhi_type.equals(1 + "")) {
                    skipVideoTitle.setText("直记直译");
                } else if (zhi_type.equals(2 + "")) {
                    skipVideoTitle.setText("口语训练平台");
                    startActivity(new Intent(SkipvidioActivity.this, ScheduleMouthActivity.class));
                } else if (zhi_type.equals(3 + "")) {
                    skipVideoTitle.setText("语法易点通");
                }
                break;
        }
    }
}
