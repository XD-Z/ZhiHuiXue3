package com.rhkj.zhihuixue.activity.mine;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.TextView;

import com.rhkj.zhihuixue.R;
import com.rhkj.zhihuixue.activity.AddaddressActivity;
import com.rhkj.zhihuixue.adapter.AddressAdapter;
import com.rhkj.zhihuixue.base.BaseActivity;

import java.util.ArrayList;

/**
 * 收货地址
 */
public class AddressActivity extends BaseActivity implements View.OnClickListener {


    private RecyclerView recyclerView;
    private TextView tvAdd;
    private View inflate;
    private TextView tvAddEmpty;

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


    }

    @Override
    protected void initData() {
        ArrayList<String> strings = new ArrayList<>();

        AddressAdapter addressAdapter = new AddressAdapter(strings);
        addressAdapter.setEmptyView(inflate);
        recyclerView.setAdapter(addressAdapter);


        initListener();
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
                startActivity(new Intent(this, AddaddressActivity.class));

                break;


        }

    }
}
