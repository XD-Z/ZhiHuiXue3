package com.rhkj.zhihuixue.activity.login_register;

import android.annotation.SuppressLint;
import android.content.Intent;
import android.graphics.Color;
import android.graphics.drawable.Drawable;
import android.os.Handler;
import android.os.Message;
import android.text.TextUtils;
import android.text.method.HideReturnsTransformationMethod;
import android.text.method.PasswordTransformationMethod;
import android.util.Log;
import android.view.MotionEvent;
import android.view.View;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import com.blankj.utilcode.util.ObjectUtils;
import com.blankj.utilcode.util.RegexUtils;
import com.google.gson.Gson;
import com.lljjcoder.Interface.OnCityItemClickListener;
import com.lljjcoder.bean.CityBean;
import com.lljjcoder.bean.DistrictBean;
import com.lljjcoder.bean.ProvinceBean;
import com.lljjcoder.citywheel.CityConfig;
import com.lljjcoder.style.citypickerview.CityPickerView;
import com.rhkj.zhihuixue.R;
import com.rhkj.zhihuixue.activity.MainActivity;
import com.rhkj.zhihuixue.base.BaseActivity;
import com.rhkj.zhihuixue.base.Contents;
import com.rhkj.zhihuixue.bean.RegisterBean;
import com.rhkj.zhihuixue.bean.VerifyBean;
import com.zhy.http.okhttp.OkHttpUtils;
import com.zhy.http.okhttp.callback.StringCallback;

import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.OnClick;
import okhttp3.Call;

public class RegisterActivity extends BaseActivity {

    @BindView(R.id.register_et_phone)
    EditText registerEtPhone;
    @BindView(R.id.register_et_code)
    EditText registerEtCode;
    @BindView(R.id.register_verification_code)
    TextView registerVerificationCode;
    @BindView(R.id.register_et_new_password)
    EditText registerEtNewPassword;
    @BindView(R.id.register_et_sure_password)
    EditText registerEtSurePassword;
    @BindView(R.id.register_tv_district)
    TextView registerTvDistrict;
    @BindView(R.id.register_et_name)
    EditText registerEtName;
    @BindView(R.id.register_et_baby_name)
    EditText registerEtBabyName;
    @BindView(R.id.register_et_grade)
    EditText registerEtGrade;
    @BindView(R.id.btn_login)
    TextView btnLogin;

    private int timer = 60;
    private final int RESEND_VERIFICATION_CODE = -9;
    private final int RECEIVE_VERIFICATION_CODE = -8;
    private String TAG = "login_register";
    private CityPickerView mPicker;
    private boolean isHideFirst = true;// 输入框密码是否是隐藏的，默认为true

    @Override
    protected void initLayout() {
        super.initLayout();
        setContentView(R.layout.activity_register);
        ButterKnife.bind(this);
        mPicker = new CityPickerView();//实例化城市选择器
        //预先加载仿iOS滚轮实现的全部数据
        mPicker.init(this);
    }

    @Override
    protected void initViews() {
        super.initViews();

        tvTitle.setText("会员注册");
    }

    @Override
    protected void addListener() {
        super.addListener();
        ettouchSure();//确认密码时的眼睛显示
        ettouchNew(); //输入密码时的眼睛显示

    }

    private void ettouchSure() {
        final Drawable[] drawables = registerEtSurePassword.getCompoundDrawables();
        final int eyeWidth = drawables[2].getBounds().width();// 眼睛图标的宽度
        final Drawable drawableEyeOpen = getResources().getDrawable(R.mipmap.icon_eye_orange);
        drawableEyeOpen.setBounds(drawables[2].getBounds());//这一步不能省略
        registerEtSurePassword.setOnTouchListener(new View.OnTouchListener() {
                                                      @Override
                                                      public boolean onTouch(View v, MotionEvent event) {

                                                          if (event.getAction() == MotionEvent.ACTION_UP) {
                                                              float et_pwdMinX = v.getWidth() - eyeWidth - registerEtSurePassword.getPaddingRight();
                                                              float et_pwdMaxX = v.getWidth();
                                                              float et_pwdMinY = 0;
                                                              float et_pwdMaxY = v.getHeight();
                                                              float x = event.getX();
                                                              float y = event.getY();

                                                              if (x < et_pwdMaxX && x > et_pwdMinX && y > et_pwdMinY && y < et_pwdMaxY) {
                                                                  // 点击了眼睛图标的位置
                                                                  isHideFirst = !isHideFirst;
                                                                  if (isHideFirst) {
                                                                      registerEtSurePassword.setCompoundDrawables(null,
                                                                              null,
                                                                              drawables[2], null);

                                                                      registerEtSurePassword.setTransformationMethod(PasswordTransformationMethod.getInstance());
                                                                  } else {
                                                                      registerEtSurePassword.setCompoundDrawables(null, null,
                                                                              drawableEyeOpen,
                                                                              null);
                                                                      registerEtSurePassword.setTransformationMethod(HideReturnsTransformationMethod.getInstance());
                                                                  }
                                                              }
                                                          }
                                                          return false;
                                                      }
                                                  }
        );
    }

    private void ettouchNew() {
        final Drawable[] drawables = registerEtNewPassword.getCompoundDrawables();
        final int eyeWidth = drawables[2].getBounds().width();// 眼睛图标的宽度
        final Drawable drawableEyeOpen = getResources().getDrawable(R.mipmap.icon_eye_orange);
        drawableEyeOpen.setBounds(drawables[2].getBounds());//这一步不能省略
        registerEtNewPassword.setOnTouchListener(new View.OnTouchListener() {
                                                     @Override
                                                     public boolean onTouch(View v, MotionEvent event) {


                                                         if (event.getAction() == MotionEvent.ACTION_UP) {
                                                             float et_pwdMinX = v.getWidth() - eyeWidth - registerEtNewPassword.getPaddingRight();
                                                             float et_pwdMaxX = v.getWidth();
                                                             float et_pwdMinY = 0;
                                                             float et_pwdMaxY = v.getHeight();
                                                             float x = event.getX();
                                                             float y = event.getY();

                                                             if (x < et_pwdMaxX && x > et_pwdMinX && y > et_pwdMinY && y < et_pwdMaxY) {
                                                                 // 点击了眼睛图标的位置
                                                                 isHideFirst = !isHideFirst;
                                                                 if (isHideFirst) {
                                                                     registerEtNewPassword.setCompoundDrawables(null,
                                                                             null,
                                                                             drawables[2], null);

                                                                     registerEtNewPassword.setTransformationMethod(PasswordTransformationMethod.getInstance());
                                                                 } else {
                                                                     registerEtNewPassword.setCompoundDrawables(null, null,
                                                                             drawableEyeOpen,
                                                                             null);
                                                                     registerEtNewPassword.setTransformationMethod(HideReturnsTransformationMethod.getInstance());
                                                                 }
                                                             }
                                                         }
                                                         return false;
                                                     }
                                                 }
        );
    }

    @Override
    protected void initData() {
        super.initData();
    }


    @OnClick({R.id.register_verification_code, R.id.register_tv_district, R.id.btn_login})
    public void onViewClicked(View view) {
        switch (view.getId()) {
            case R.id.register_verification_code:
                void_SendCode();
                break;
            case R.id.register_tv_district:
                chosecityConfig();//城市选择器
                break;
            case R.id.btn_login:
                void_logoin();
                break;
        }
    }

    private void void_logoin() {
        Log.e(TAG, "void_logoin1: " + registerEtSurePassword.getText().toString().trim());
        Log.e(TAG, "void_logoin2: " + registerEtNewPassword.getText().toString().trim());
        if (TextUtils.isEmpty(registerEtPhone.getText().toString().trim())) {
            Toast.makeText(this, "请输入手机号码", Toast.LENGTH_SHORT).show();
            return;
        }
        if (TextUtils.isEmpty(registerEtCode.getText().toString().trim())) {
            Toast.makeText(this, "请输入验证码", Toast.LENGTH_SHORT).show();
            return;
        }
        if (TextUtils.isEmpty(registerEtNewPassword.getText().toString().trim())) {
            Toast.makeText(this, "请输入密码", Toast.LENGTH_SHORT).show();
            return;
        }
        if (TextUtils.isEmpty(registerTvDistrict.getText().toString().trim())) {
            Toast.makeText(this, "请输入所在城市", Toast.LENGTH_SHORT).show();
            return;
        }
        if (TextUtils.isEmpty(registerEtBabyName.getText().toString().trim())) {
            Toast.makeText(this, "请输入宝宝昵称", Toast.LENGTH_SHORT).show();
            return;
        }
        if (TextUtils.isEmpty(registerEtGrade.getText().toString().trim())) {
            Toast.makeText(this, "请输入当前年级", Toast.LENGTH_SHORT).show();
            return;
        }
        if (!ObjectUtils.equals(registerEtSurePassword.getText().toString().trim(),
                registerEtNewPassword.getText().toString().trim())) {
            Toast.makeText(this, "第二次密码输入错误", Toast.LENGTH_SHORT).show();
            return;
        }
        OkHttpUtils.post().url(Contents.REGISTER)
                .addParams("mobile", registerEtPhone.getText().toString().trim())
                .addParams("password", registerEtNewPassword.getText().toString().trim())
                .addParams("yzm", registerEtCode.getText().toString().trim())
                .addParams("user_name", registerEtName.getText().toString().trim())
                .addParams("nickname", registerEtBabyName.getText().toString().trim())
                .addParams("city", registerTvDistrict.getText().toString().trim())
                .addParams("grade_id", registerEtGrade.getText().toString().trim())
                .build()
                .execute(new StringCallback() {
                    @Override
                    public void onError(Call call, Exception e, int id) {
                        Log.e(TAG, "onError: " + e);
                    }

                    @Override
                    public void onResponse(String response, int id) {
                        Log.e(TAG, "onResponse: " + response);
                        RegisterBean registerBean = new Gson().fromJson(response, RegisterBean.class);
                        if (registerBean.getState() == 200){
                            startActivity(new Intent(RegisterActivity.this, MainActivity.class));
                            finish();
                        }
                    }
                });
    }

    /**
     * //城市选择器
     */
    private void chosecityConfig() {
        //添加默认的配置，不需要自己定义，当然也可以自定义相关熟悉，详细属性请看demo
        CityConfig cityConfig = new CityConfig.Builder()
                .province("北京市")//默认显示的省份
                .city("省直辖县级行政单位")//默认显示省份下面的城市
                .district("朝阳区")//默认显示省市下面的区县数据
                .provinceCyclic(false)//省份滚轮是否可以循环滚动
                .build();
        mPicker.setConfig(cityConfig);

        //监听选择点击事件及返回结果
        mPicker.setOnCityItemClickListener(new OnCityItemClickListener() {
            @Override
            public void onSelected(ProvinceBean province, CityBean city, DistrictBean district) {
                registerTvDistrict.setText(district.toString());
            }

            @Override
            public void onCancel() {
                Toast.makeText(RegisterActivity.this, "已取消", Toast.LENGTH_SHORT).show();
            }
        });
        //显示
        mPicker.showCityPicker();
    }


    //处理验证码的handler
    @SuppressLint("HandlerLeak")
    Handler handler = new Handler() {
        @SuppressLint("SetTextI18n")
        @Override
        public void handleMessage(Message msg) {
            //小于60  大于0
            if (msg.what == RESEND_VERIFICATION_CODE) {
                registerVerificationCode.setText(timer + "  s后重新发送");
                registerVerificationCode.setEnabled(false);
                registerVerificationCode.setBackgroundColor(Color.rgb(199, 199, 199));
            } else if (msg.what == RECEIVE_VERIFICATION_CODE) {
                registerVerificationCode.setText("重新发送");
                registerVerificationCode.setEnabled(true);
                registerVerificationCode.setBackgroundColor(Color.rgb(234, 84, 4));
                timer = 60;
            }
        }
    };

    private void void_SendCode() {
        if (ObjectUtils.isEmpty(registerEtPhone.getText().toString())) {
            Toast.makeText(this, "请输入手机号码", Toast.LENGTH_SHORT).show();
            return;
        }
        if (!RegexUtils.isMobileSimple(registerEtPhone.getText().toString())) {
            Toast.makeText(this, "请输入正确的手机号", Toast.LENGTH_SHORT).show();
            return;
        }

        void_requestCode();
    }

    private void void_requestCode() {
        OkHttpUtils.post().url(Contents.VERICATCODE)
                .addParams("mobile", registerEtPhone.getText().toString())
                .build()
                .execute(new StringCallback() {
                    @Override
                    public void onError(Call call, Exception e, int id) {
                    }

                    @Override
                    public void onResponse(String response, int id) {
                        Log.e(TAG, "onResponse: " + response);
                        VerifyBean verifyBean = new Gson().fromJson(response, VerifyBean.class);
                        if (verifyBean.getState() == 200) {
                            registerVerificationCode.setText(timer + "  s后重新发送");
                            //子线程执行倒计时
                            new Thread(new Runnable() {
                                @Override
                                public void run() {
                                    for (; timer > 0; timer--) {
                                        handler.sendEmptyMessage(RESEND_VERIFICATION_CODE);
                                        if (timer < 0) {
                                            break;
                                        }
                                        try {
                                            Thread.sleep(1000);
                                        } catch (InterruptedException e) {
                                            e.printStackTrace();
                                        }
                                    }
                                    handler.sendEmptyMessage(RECEIVE_VERIFICATION_CODE);
                                }
                            }).start();
                            Toast.makeText(RegisterActivity.this, "发送成功", Toast.LENGTH_SHORT).show();
                        } else {
                            Toast.makeText(RegisterActivity.this, verifyBean.getMsg(), Toast.LENGTH_SHORT).show();
                        }
                    }
                });
    }

}
