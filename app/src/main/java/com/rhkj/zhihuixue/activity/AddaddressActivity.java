package com.rhkj.zhihuixue.activity;

import android.content.Intent;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.LinearLayout;
import android.widget.TextView;

import com.blankj.utilcode.util.RegexUtils;
import com.lljjcoder.Interface.OnCityItemClickListener;
import com.lljjcoder.bean.CityBean;
import com.lljjcoder.bean.DistrictBean;
import com.lljjcoder.bean.ProvinceBean;
import com.lljjcoder.citywheel.CityConfig;
import com.lljjcoder.style.citypickerview.CityPickerView;
import com.rhkj.zhihuixue.R;
import com.rhkj.zhihuixue.base.BaseActivity;
import com.rhkj.zhihuixue.base.Contents;
import com.rhkj.zhihuixue.utils.SharedPrefsUtil;
import com.suke.widget.SwitchButton;
import com.zhy.http.okhttp.OkHttpUtils;
import com.zhy.http.okhttp.callback.StringCallback;

import org.json.JSONException;
import org.json.JSONObject;

import okhttp3.Call;

public class AddaddressActivity extends BaseActivity implements View.OnClickListener {


    private EditText editAddress;
    private TextView tvRegion;
    private EditText editPhone;
    private EditText editName;

    private LinearLayout llRegion;
    private Button button;
    private SwitchButton switchButton;
    private String mProvince;
    private String mCity;
    private String mCountyarea;
    private CityPickerView mPicker;


    @Override
    protected void initLayout() {
        super.initLayout();
        setContentView(R.layout.activity_addaddress);
    }

    @Override
    protected void initViews() {
        tvTitle.setText("添加收货地址");
        editName = findViewById(R.id.edit_name);
        editPhone = findViewById(R.id.edit_phone);
        tvRegion = findViewById(R.id.tv_region);
        editAddress = findViewById(R.id.edit_address);
        llRegion = findViewById(R.id.ll_region);
        button = findViewById(R.id.btn_preservation);
        switchButton = findViewById(R.id.swbtn);


        llRegion.setOnClickListener(this);
        button.setOnClickListener(this);
    }

    @Override
    protected void initData() {
        mPicker = new CityPickerView();//实例化城市选择器
        //预先加载仿iOS滚轮实现的全部数据
        mPicker.init(this);


    }

    @Override
    public void onClick(View view) {
        switch (view.getId()) {
            case R.id.ll_region:
                chosecityConfig();
                break;
            case R.id.btn_preservation:
                preservation();
                break;
        }
    }

    private void preservation() {
        String name = editName.getText().toString().trim();
        String phone = editPhone.getText().toString().trim();
        String address = editAddress.getText().toString().trim();
        String region = tvRegion.getText().toString().trim();

        boolean checked = switchButton.isChecked();

        if (name.equals("")) {
            showToast("收货人为空");
            return;
        }
        if (!RegexUtils.isMobileSimple(phone)) {
            showToast("请输入正确的手机号码");
            return;
        }
        if (region.equals("")) {
            showToast("请选择所在地区");
            return;
        }
        if (address.equals("")) {
            showToast("请输入详细地址");
            return;
        }




        OkHttpUtils.post()
                .url(Contents.ADD_ADDRESS)
                .addParams("user_id", (String) SharedPrefsUtil.getData("user_id", ""))
                .addParams("name", name)
                .addParams("tel", phone)
                .addParams("province", mProvince)
                .addParams("city", mCity)
                .addParams("countyarea", mCountyarea)
                .addParams("desc", address)
                .addParams("default", checked ? "0" : "1")
                .build()
                .execute(new StringCallback() {
                    @Override
                    public void onError(Call call, Exception e, int id) {
                        Log.e("TAG", e.getMessage());
                    }

                    @Override
                    public void onResponse(String response, int id) {
                        try {
                            JSONObject jsonObject = new JSONObject(response);
                            String msg = jsonObject.getString("msg");
                            int state = jsonObject.getInt("state");

                            if (state == 200) {
                                Intent intent = new Intent();
                                intent.putExtra("statr", "1");
                                setResult(2, intent);
                                finish();

                            }
                            showToast(msg);
                        } catch (JSONException e) {
                            e.printStackTrace();
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
                mProvince = province.toString();
                mCity = city.toString();
                mCountyarea = district.toString();


                tvRegion.setText(mProvince + mCity + mCountyarea);
            }

            @Override
            public void onCancel() {
//                Toast.makeText(RegisterActivity.this, "已取消", Toast.LENGTH_SHORT).show();
            }
        });
        //显示
        mPicker.showCityPicker();
    }

}
