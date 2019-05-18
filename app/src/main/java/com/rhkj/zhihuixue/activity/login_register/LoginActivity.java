package com.rhkj.zhihuixue.activity.login_register;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.text.TextUtils;
import android.util.Log;
import android.view.View;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import com.blankj.utilcode.util.ObjectUtils;
import com.blankj.utilcode.util.RegexUtils;
import com.blankj.utilcode.util.SPUtils;
import com.google.gson.Gson;
import com.gyf.barlibrary.BarHide;
import com.gyf.barlibrary.ImmersionBar;
import com.rhkj.zhihuixue.R;
import com.rhkj.zhihuixue.activity.MainActivity;
import com.rhkj.zhihuixue.base.Contents;
import com.rhkj.zhihuixue.bean.LogoinBean;
import com.rhkj.zhihuixue.utils.SharedPrefsUtil;
import com.rhkj.zhihuixue.utils.SysApplication;
import com.zhy.http.okhttp.OkHttpUtils;
import com.zhy.http.okhttp.callback.StringCallback;

import org.json.JSONException;
import org.json.JSONObject;

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
    private String TAG = "login_register";

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

        loginEtPhone.setText("17664092628");
        loginEtPassword.setText("123456");
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
//                startActivity(new Intent(LoginActivity.this, MainActivity.class));
                void_login();//登录按钮请求接口
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
        if (TextUtils.isEmpty(loginEtPhone.getText().toString().trim())) {
            Toast.makeText(this, "请输入手机号码", Toast.LENGTH_SHORT).show();
            return;
        }
        if (!RegexUtils.isMobileSimple(loginEtPhone.getText().toString())) {
            Toast.makeText(this, "请输入正确的手机号", Toast.LENGTH_SHORT).show();
            return;
        }
        if (TextUtils.isEmpty(loginEtPassword.getText().toString().trim())) {
            Toast.makeText(this, "请输入密码", Toast.LENGTH_SHORT).show();
            return;
        }
        OkHttpUtils.post().url(Contents.LOGOIN)
                .addParams("mobile", loginEtPhone.getText().toString())
                .addParams("password", loginEtPassword.getText().toString())
                .build()
                .execute(new StringCallback() {
                    @Override
                    public void onError(Call call, Exception e, int id) {

                    }

                    @Override
                    public void onResponse(String response, int id) {
                        Log.e(TAG, "onResponse: " + response);

                        try {
                            JSONObject jsonObject = new JSONObject(response);
                            int state = jsonObject.getInt("state");
                            String msg = jsonObject.getString("msg");
                            if (state == 1) {
                                LogoinBean logoinBean = new Gson().fromJson(response, LogoinBean.class);
                                Log.e(TAG, "onResponse: " + response);
                                //往SP中存入token，ID，name
                                SharedPrefsUtil.putData("user_token", logoinBean.getData().getToken());
                                SharedPrefsUtil.putData("user_id", String.valueOf(logoinBean.getData().getId()));
                                SharedPrefsUtil.putData("user_name", logoinBean.getData().getUser_name());

                                startActivity(new Intent(LoginActivity.this, MainActivity.class));
                                finish();
                            } else {
                                Toast.makeText(LoginActivity.this, msg, Toast.LENGTH_SHORT).show();
                            }

                        } catch (JSONException e) {
                            e.printStackTrace();
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
