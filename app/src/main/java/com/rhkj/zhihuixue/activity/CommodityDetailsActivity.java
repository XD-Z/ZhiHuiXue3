package com.rhkj.zhihuixue.activity;

import android.support.v4.view.ViewPager;
import android.view.View;

import com.rhkj.zhihuixue.R;
import com.rhkj.zhihuixue.adapter.VpAdapter;
import com.rhkj.zhihuixue.base.BaseActivity;

import java.util.ArrayList;

/**
 *
 *  商品详情
 *
 * Created by zjx on 2019/5/7.
 */

public class CommodityDetailsActivity extends BaseActivity {

    private ViewPager viewPager;

    @Override
    protected void initLayout() {
        setContentView(R.layout.ac_commodity_detalis);
    }

    @Override
    protected void initViews() {
        viewPager = findViewById(R.id.vp);

        ArrayList<Integer> integerArrayList = new ArrayList<>();
        integerArrayList.add(R.mipmap.test_img_one);
        integerArrayList.add(R.mipmap.test_img_two);

        VpAdapter vpAdapter = new VpAdapter(integerArrayList, this);
        viewPager.setAdapter(vpAdapter);



    }
}
