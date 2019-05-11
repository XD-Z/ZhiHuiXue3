package com.rhkj.zhihuixue.activity;

import com.rhkj.zhihuixue.R;
import com.rhkj.zhihuixue.base.BaseActivity;

/**
 * Created by zjx on 2019/5/11.
 */

public class ComeonActivity extends BaseActivity {

    @Override
    protected void initLayout() {
        super.initLayout();
        setContentView(R.layout.ac_comeon);
    }

    @Override
    protected void initViews() {
        tvTitle.setText("为我加油");

    }
}
