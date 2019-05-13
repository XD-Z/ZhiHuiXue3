package com.rhkj.zhihuixue.activity.login_register;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import com.blankj.utilcode.util.SPUtils;
import com.google.gson.Gson;
import com.gyf.barlibrary.BarHide;
import com.gyf.barlibrary.ImmersionBar;
import com.rhkj.zhihuixue.R;
import com.rhkj.zhihuixue.activity.MainActivity;
import com.rhkj.zhihuixue.base.Contents;
import com.rhkj.zhihuixue.bean.LogoinBean;
import com.rhkj.zhihuixue.utils.SysApplication;
import com.zhy.http.okhttp.OkHttpUtils;
import com.zhy.http.okhttp.callback.StringCallback;

import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.OnClick;
import okhttp3.Call;

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
        initData();

    }

    private void initData() {
//        //判断是否第一次登录
//        String token = SPUtils.getInstance().getString("token");
//        if (ObjectUtils.isNotEmpty(token)) {
//            startActivity(new Intent(LoginActivity.this, MainActivity.class));
//            return;
//        }
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
                startActivity(new Intent(LoginActivity.this, MainActivity.class));
//                void_login();//请求接口
                break;
            case R.id.btn_register:
                startActivity(new Intent(this, RegisterActivity.class));
                break;
        }
    }

    /**
     * //请求接口
     */
    private void void_login() {
        OkHttpUtils.post().url(Contents.LOGOIN)
                .addParams("mobile", loginEtPhone.getText().toString())
                .addParams("password", loginEtPassword.getText().toString())
                .build().execute(new StringCallback() {
            @Override
            public void onError(Call call, Exception e, int id) {
            }

            @Override
            public void onResponse(String response, int id) {
                LogoinBean logoinBean = new Gson().fromJson(response, LogoinBean.class);
                if (logoinBean.getState() == 200) {
                    //往SP中存入token，ID，name
                    SPUtils.getInstance().put("user_token", logoinBean.getData().getToken());
                    SPUtils.getInstance().put("user_id", logoinBean.getData().getId());
                    SPUtils.getInstance().put("user_name", logoinBean.getData().getUser_name());
                    startActivity(new Intent(LoginActivity.this, MainActivity.class));
                    finish();
                } else {
                    Toast.makeText(LoginActivity.this, logoinBean.getMsg(), Toast.LENGTH_SHORT).show();
                }

            }
        });
    }


    @Override
    protected void onDestroy() {
        super.onDestroy();
        ImmersionBar.with(this).destroy();  //不调用该方法，如果界面bar发生改变，在不关闭app的情况下，退出此界面再进入将记忆最后一次bar改变的状态
    }
}
