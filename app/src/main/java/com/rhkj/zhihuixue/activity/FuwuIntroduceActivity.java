package com.rhkj.zhihuixue.activity;

import android.widget.ImageView;
import android.widget.TextView;

import com.rhkj.zhihuixue.R;
import com.rhkj.zhihuixue.base.BaseActivity;

/**
 * 智能英语介绍/服务介绍
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

        int state = getIntent().getIntExtra("state", -1);


        if (state == 0) {
            tvTitle.setText("智能英语介绍");
            imageView.setImageResource(R.mipmap.img_fuwu_english);

        } else {
            tvTitle.setText("服务介绍");
            imageView.setImageResource(R.mipmap.img_fuwu_introduce);

        }


    }
}
