package com.rhkj.zhihuixue.activity;


import android.app.Activity;
import android.content.Intent;
import android.content.res.Resources;
import android.os.Bundle;
import android.os.Handler;
import android.util.Log;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;

import com.blankj.utilcode.util.AdaptScreenUtils;
import com.bumptech.glide.Glide;
import com.google.gson.Gson;
import com.gyf.barlibrary.BarHide;
import com.gyf.barlibrary.ImmersionBar;
import com.rhkj.zhihuixue.R;
import com.rhkj.zhihuixue.activity.login_register.LoginActivity;
import com.rhkj.zhihuixue.base.Contents;
import com.zhy.http.okhttp.OkHttpUtils;
import com.zhy.http.okhttp.callback.StringCallback;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import java.util.Timer;
import java.util.TimerTask;

import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.OnClick;
import okhttp3.Call;

public class WelcomeActivity extends Activity {

    @BindView(R.id.spalsh_img)
    ImageView spalshImg;
    @BindView(R.id.spalsh_textview)
    TextView spalshTextview;

    private int recLen = 5;//跳过倒计时提示5秒
    Timer timer = new Timer();
    private Handler handler;
    private Runnable runnable;
    private ImageView imageView;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_welcome);
        imageView = findViewById(R.id.spalsh_img);

        // TODO: add setContentView(...) invocation
        ButterKnife.bind(this);
        initLayout();
        initData();
    }

    protected void initLayout() {


        ImmersionBar.with(this)
                .hideBar(BarHide.FLAG_HIDE_NAVIGATION_BAR)
                .init();

        timer.schedule(task, 1000, 1000);//等待时间一秒，停顿时间一秒


        OkHttpUtils.post()
                .url(Contents.GUIDE)
                .build().execute(new StringCallback() {
            @Override
            public void onError(Call call, Exception e, int id) {

            }

            @Override
            public void onResponse(String response, int id) {
                try {
                    JSONObject jsonObject = new JSONObject(response);
                    int state = jsonObject.getInt("state");

                    if (state == 200) {
                        JSONArray data = jsonObject.getJSONArray("data");
                        if (data.length() != 0) {
                            JSONObject o = (JSONObject) data.get(0);
                            String desc = o.getString("desc");
//                            Glide.with(WelcomeActivity.this).load(desc).into(imageView);
                        }
                    }
                } catch (JSONException e) {
                    e.printStackTrace();
                }

            }
        });

    }


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

    @Override
    protected void onDestroy() {
        super.onDestroy();
        ImmersionBar.with(this).destroy();  //不调用该方法，如果界面bar发生改变，在不关闭app的情况下，退出此界面再进入将记忆最后一次bar改变的状态
    }
    @Override
    public Resources getResources() {
        return AdaptScreenUtils.adaptHeight(super.getResources(), 667);
    }
}
