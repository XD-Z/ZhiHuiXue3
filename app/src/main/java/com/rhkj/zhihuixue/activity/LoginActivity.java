package com.rhkj.zhihuixue.activity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.TextView;

import com.gyf.barlibrary.ImmersionBar;
import com.rhkj.zhihuixue.R;
import com.rhkj.zhihuixue.base.BaseActivity;

import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.OnClick;

public class LoginActivity extends BaseActivity {

    @Override
    protected void initViews() {
        setContentView(R.layout.activity_login);
        // TODO: add setContentView(...) invocation
        ButterKnife.bind(this);
        ImmersionBar.with(this)
                .statusBarColor(R.color.colorBlack)     //状态栏颜色，不写默认透明色
                .statusBarColor(R.color.colorLoginGrey)     //状态栏颜色，不写默认透明色
                .statusBarDarkFont(true)   //状态栏字体是深色，不写默认为亮色
                .init();
    }

    @Override
    protected void initData() {
        super.initData();
    }


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

    }

    @OnClick(R.id.btn_login)
    public void onViewClicked(View view) {
        switch (view.getId()) {
            case R.id.btn_login:
                startActivity(new Intent(this,MainActivity.class));
                break;
        }
    }

}
