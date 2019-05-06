package com.rhkj.zhihuixue.activity;


import android.content.Intent;
import android.os.Bundle;
import android.os.Handler;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;

import com.gyf.barlibrary.ImmersionBar;
import com.rhkj.zhihuixue.R;
import com.rhkj.zhihuixue.base.BaseActivity;

import java.util.Timer;
import java.util.TimerTask;

import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.OnClick;

public class WelcomeActivity extends BaseActivity {

    @BindView(R.id.spalsh_img)
    ImageView spalshImg;
    @BindView(R.id.spalsh_textview)
    TextView spalshTextview;

    private int recLen = 5;//跳过倒计时提示5秒
    Timer timer = new Timer();
    private Handler handler;
    private Runnable runnable;

    @Override
    protected void initLayout() {
        setContentView(R.layout.activity_welcome);
        // TODO: add setContentView(...) invocation
        ButterKnife.bind(this);
        ImmersionBar.with(this).init();
        timer.schedule(task, 1000, 1000);//等待时间一秒，停顿时间一秒
    }


    @Override
    protected void initData() {
        /**
         * 正常情况下不点击跳过
         */
        handler = new Handler();
        handler.postDelayed(runnable = new Runnable() {
            @Override
            public void run() {
                //从闪屏界面跳转到首界面
                Intent intent = new Intent(WelcomeActivity.this, LoginActivity.class);
                startActivity(intent);
                finish();
            }
        }, 5000);//延迟5S后发送handler信息
    }

    TimerTask task = new TimerTask() {
        @Override
        public void run() {
            runOnUiThread(new Runnable() { // UI thread
                @Override
                public void run() {
                    recLen--;
                    spalshTextview.setText("跳过 " + recLen);
                    if (recLen < 0) {
                        timer.cancel();
                        spalshTextview.setVisibility(View.GONE);//倒计时到0隐藏字体
                    }
                }
            });
        }
    };

    @OnClick({R.id.spalsh_img, R.id.spalsh_textview})
    public void onViewClicked(View view) {
        switch (view.getId()) {
            case R.id.spalsh_textview:
                //从闪屏界面跳转到首界面
                Intent intent = new Intent(WelcomeActivity.this, LoginActivity.class);
                startActivity(intent);
                finish();
                if (runnable != null) {
                    handler.removeCallbacks(runnable);
                }
                break;
        }
    }
}
