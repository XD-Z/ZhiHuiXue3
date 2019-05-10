package com.rhkj.zhihuixue.activity.login_register;

import android.widget.TextView;

import com.rhkj.zhihuixue.R;
import com.rhkj.zhihuixue.base.BaseActivity;

import butterknife.BindView;
import butterknife.ButterKnife;

public class LogoutActivity extends BaseActivity {

    @BindView(R.id.tv_title)
    TextView tvTitle;


    @Override
    protected void initLayout() {
        super.initLayout();
        setContentView(R.layout.activity_logout);
        ButterKnife.bind(this);

    }

    @Override
    protected void initViews() {
        super.initViews();
        tvTitle.setText("注销账号");
    }

    @Override
    protected void initData() {
        super.initData();
    }

    @Override
    protected void addListener() {
        super.addListener();
    }
}
