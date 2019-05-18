package com.rhkj.zhihuixue.activity.mine;

import android.content.Intent;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.EditText;
import android.widget.TextView;

import com.google.gson.Gson;
import com.rhkj.zhihuixue.R;
import com.rhkj.zhihuixue.activity.AddaddressActivity;
import com.rhkj.zhihuixue.adapter.AddressAdapter;
import com.rhkj.zhihuixue.base.BaseActivity;
import com.rhkj.zhihuixue.base.Contents;
import com.rhkj.zhihuixue.bean.AddressGsonBean;
import com.rhkj.zhihuixue.utils.SharedPrefsUtil;
import com.zhy.http.okhttp.OkHttpUtils;
import com.zhy.http.okhttp.callback.StringCallback;

import java.util.ArrayList;
import java.util.List;

import okhttp3.Call;

/**
 * 收货地址
 */
public class AddressActivity extends BaseActivity implements View.OnClickListener {


    private RecyclerView recyclerView;
    private TextView tvAdd;
    private View inflate;
    private TextView tvAddEmpty;
    private AddressAdapter addressAdapter;
    private Gson gson;

    @Override
    protected void initLayout() {
        super.initLayout();
        setContentView(R.layout.activity_address);
    }

    @Override
    protected void initViews() {
        recyclerView = findViewById(R.id.rv);
        recyclerView.setLayoutManager(new LinearLayoutManager(this));
        //空布局
        inflate = LayoutInflater.from(this).inflate(R.layout.empty_address, recyclerView, false);
        tvAdd = findViewById(R.id.tv_add);
        tvAddEmpty = inflate.findViewById(R.id.tv_add_empty);

        addressAdapter = new AddressAdapter();
        addressAdapter.setEmptyView(inflate);
        recyclerView.setAdapter(addressAdapter);


        gson = new Gson();

        initListener();
    }

    @Override
    protected void initData() {

        OkHttpUtils.post()
                .addParams("user_id", (String) SharedPrefsUtil.getData("user_id", ""))
                .url(Contents.ADDRESS)
                .build()
                .execute(new StringCallback() {
                    @Override
                    public void onError(Call call, Exception e, int id) {

                    }

                    @Override
                    public void onResponse(String response, int id) {
                        AddressGsonBean addressGsonBean = gson.fromJson(response, AddressGsonBean.class);
                        List<AddressGsonBean.DataBean> data = addressGsonBean.getData();

                        if (!data.isEmpty()) {
                            tvAdd.setVisibility(View.VISIBLE);
                        } else {
                            tvAdd.setVisibility(View.GONE);
                        }

                        addressAdapter.setNewData(data);
                    }
                });


    }

    private void initListener() {
        tvAdd.setOnClickListener(this);
        tvAddEmpty.setOnClickListener(this);
    }


    @Override
    public void onClick(View view) {
        switch (view.getId()) {
            case R.id.tv_add:
            case R.id.tv_add_empty:
                startActivityForResult(new Intent(this, AddaddressActivity.class), 1);
                break;

        }
    }

    @Override
    protected void onActivityResult(int requestCode, int resultCode, @Nullable Intent data) {
        super.onActivityResult(requestCode, resultCode, data);
        if (requestCode == 1 && resultCode == 2) {
            initData();
        }

    }
}
