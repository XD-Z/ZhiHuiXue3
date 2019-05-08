package com.rhkj.zhihuixue.activity.mine;

import android.content.Intent;
import android.view.Gravity;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.RelativeLayout;
import android.widget.TextView;
import android.widget.Toast;

import com.example.zhouwei.library.CustomPopWindow;
import com.lljjcoder.Interface.OnCityItemClickListener;
import com.lljjcoder.bean.CityBean;
import com.lljjcoder.bean.DistrictBean;
import com.lljjcoder.bean.ProvinceBean;
import com.lljjcoder.citywheel.CityConfig;
import com.lljjcoder.style.citypickerview.CityPickerView;
import com.rhkj.zhihuixue.R;
import com.rhkj.zhihuixue.activity.ChangePhoneActivity;
import com.rhkj.zhihuixue.activity.login_register.AmendPasswordActivity;
import com.rhkj.zhihuixue.activity.login_register.LoginActivity;
import com.rhkj.zhihuixue.base.BaseActivity;
import com.rhkj.zhihuixue.utils.MyApplication;

import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.OnClick;


/**
 * 设置
 */
public class SettingActivity extends BaseActivity {

    @BindView(R.id.iv_back)
    ImageView ivBack;
    @BindView(R.id.tv_title)
    TextView tvTitle;
    @BindView(R.id.setting_district)
    RelativeLayout settingDistrict;
    @BindView(R.id.setting_amend_password)
    RelativeLayout settingAmendPassword;
    @BindView(R.id.setting_change_phone)
    RelativeLayout settingChangePhone;
    @BindView(R.id.setting_exit)
    RelativeLayout settingExit;
    @BindView(R.id.setting_login_out)
    RelativeLayout settingLoginOut;
    @BindView(R.id.setting_layout_parent)
    LinearLayout settingLayoutParent;
    private CustomPopWindow popWindow;
    private CityPickerView mPicker;

    @Override
    protected void initLayout() {
        super.initLayout();
        setContentView(R.layout.activity_setting);
        ButterKnife.bind(this);
        mPicker = new CityPickerView();//实例化城市选择器
        //预先加载仿iOS滚轮实现的全部数据
        mPicker.init(this);
    }

    @Override
    protected void initViews() {
        super.initViews();
        tvTitle.setText("账号设置");
    }

    @Override
    protected void initData() {
        super.initData();
    }

    @OnClick({R.id.iv_back, R.id.setting_district, R.id.setting_amend_password, R.id.setting_change_phone, R.id.setting_exit, R.id.setting_login_out})
    public void onViewClicked(View view) {
        switch (view.getId()) {
            case R.id.iv_back:
                finish();
                break;
            case R.id.setting_district://区域
                chosecityConfig();//城市选择器
                break;
            case R.id.setting_amend_password://修改密码
                startActivity(new Intent(this, AmendPasswordActivity.class));
                break;
            case R.id.setting_change_phone://更换手机号
                startActivity(new Intent(this, ChangePhoneActivity.class));
                break;
            case R.id.setting_exit://退出账号
                popWindowhow();
                break;
            case R.id.setting_login_out://注销

                break;
        }
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
                Toast.makeText(SettingActivity.this, province.toString() + city.toString() + district.toString(), Toast.LENGTH_SHORT).show();
            }

            @Override
            public void onCancel() {
                Toast.makeText(SettingActivity.this, "已取消", Toast.LENGTH_SHORT).show();
            }
        });
        //显示
        mPicker.showCityPicker();
    }


    /**
     * //退出登录popupwindows
     */
    private void popWindowhow() {
        int width = getWindowManager().getDefaultDisplay().getWidth();
        View contentView = LayoutInflater.from(this).inflate(R.layout.popupwindow_exit, null);
        //处理popWindow 显示内容
        handleLogic(contentView);
        //创建并显示popWindow
        popWindow = new CustomPopWindow.PopupWindowBuilder(this)
                .setView(contentView)//显示的布局，还可以通过设置一个View
                .enableBackgroundDark(true) //弹出popWindow时，背景是否变暗
                .setBgDarkAlpha(0.7f) // 控制亮度
                .size(width, 300) //设置显示的大小，不设置就默认包裹内容
                .setFocusable(true)//是否获取焦点，默认为ture
                .setOutsideTouchable(true)//是否PopupWindow 以外触摸dissmiss
                .create()//创建PopupWindow
                .showAsDropDown(settingLayoutParent, Gravity.BOTTOM, 0, 0);
    }

    /**
     * //popupwindows点击事件
     */
    private void handleLogic(View contentView) {

        View.OnClickListener listener = new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (popWindow != null) {
                    popWindow.dissmiss();
                }
                switch (v.getId()) {
                    case R.id.setting_exit_logout:
                        startActivity(new Intent(SettingActivity.this, LoginActivity.class));
                        finish();
                        break;
                    case R.id.setting_exit_close:
                        MyApplication.getInstance().exit();

                        break;
                }
            }
        };
        contentView.findViewById(R.id.setting_exit_logout).setOnClickListener(listener);
        contentView.findViewById(R.id.setting_exit_close).setOnClickListener(listener);
    }
}





