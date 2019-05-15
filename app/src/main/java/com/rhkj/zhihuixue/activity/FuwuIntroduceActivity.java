package com.rhkj.zhihuixue.activity;

import android.widget.ImageView;
import android.widget.TextView;

import com.rhkj.zhihuixue.R;
import com.rhkj.zhihuixue.base.BaseActivity;

/**
 * 服务介绍
 * <p>
 * Created by zjx on 2019/5/7.
 */

public class FuwuIntroduceActivity extends BaseActivity {


    private ImageView imageView;
    private TextView textView;

    @Override
    protected void initLayout() {
        super.initLayout();
        setContentView(R.layout.ac_fuwu_introduce);
    }

    @Override
    protected void initViews() {
        super.initViews();
        imageView = findViewById(R.id.iv_img);
        textView = findViewById(R.id.tv_text);

    }

    @Override
    protected void initData() {
        super.initData();
        tvTitle.setText("服务介绍");


    }
}
