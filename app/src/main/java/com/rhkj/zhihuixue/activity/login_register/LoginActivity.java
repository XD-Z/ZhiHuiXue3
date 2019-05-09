package com.rhkj.zhihuixue.activity.login_register;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.EditText;
import android.widget.TextView;

import com.gyf.barlibrary.BarHide;
import com.gyf.barlibrary.ImmersionBar;
import com.rhkj.zhihuixue.R;
import com.rhkj.zhihuixue.activity.MainActivity;
import com.rhkj.zhihuixue.utils.SysApplication;

import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.OnClick;

public class LoginActivity extends AppCompatActivity {

    @BindView(R.id.login_et_phone)
    EditText loginEtPhone;
    @BindView(R.id.login_et_password)
    EditText loginEtPassword;
    @BindView(R.id.tv_login_forgetpassword)
    TextView tvLoginForgetpassword;
    @BindView(R.id.btn_login)
    TextView btnLogin;
    @BindView(R.id.btn_register)
    TextView btnRegister;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);
        SysApplication.getInstance().addActivity(this);
        // TODO: add setContentView(...) invocation
        ButterKnife.bind(this);
        initViews();
    }

    protected void initViews() {

        ImmersionBar.with(this)
                .statusBarColor(R.color.colorWhile)
                .statusBarDarkFont(true)
                .hideBar(BarHide.FLAG_HIDE_NAVIGATION_BAR)
                .init();
    }


    @OnClick({R.id.tv_login_forgetpassword, R.id.btn_login, R.id.btn_register})
    public void onViewClicked(View view) {
        switch (view.getId()) {
            case R.id.tv_login_forgetpassword:
                startActivity(new Intent(this, ForgetPasswordActivity.class));
                break;
            case R.id.btn_login:
                startActivity(new Intent(this, MainActivity.class));
                break;
            case R.id.btn_register:
                startActivity(new Intent(this, RegisterActivity.class));
                break;
        }
    }


    @Override
    protected void onDestroy() {
        super.onDestroy();
        ImmersionBar.with(this).destroy();  //不调用该方法，如果界面bar发生改变，在不关闭app的情况下，退出此界面再进入将记忆最后一次bar改变的状态
    }
}
