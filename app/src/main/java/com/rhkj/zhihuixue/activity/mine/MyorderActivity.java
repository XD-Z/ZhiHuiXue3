package com.rhkj.zhihuixue.activity.mine;

import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v4.view.ViewPager;
import android.support.v7.app.AppCompatActivity;
import android.view.View;

import com.flyco.tablayout.SlidingTabLayout;
import com.rhkj.zhihuixue.R;
import com.rhkj.zhihuixue.base.BaseActivity;
import com.rhkj.zhihuixue.fragment.MyOrderFragment;

import java.util.ArrayList;

/**
 * 我的订单
 */
public class MyorderActivity extends BaseActivity {

    private SlidingTabLayout slidingTabLayout;
    private ViewPager viewPager;
    private String[] title = {"全部", "待付款", "待收货", "已完成"};

    @Override
    protected void initLayout() {
        super.initLayout();
        setContentView(R.layout.activity_myorder);
    }

    @Override
    protected void initViews() {
        tvTitle.setText("我的订单");
        slidingTabLayout = findViewById(R.id.stl);
        viewPager = findViewById(R.id.vp);
    }

    @Override
    protected void initData() {

        ArrayList<Fragment> fragments = new ArrayList<>();
        for (int i = 0; i < title.length; i++) {
            fragments.add(new MyOrderFragment());
        }


        slidingTabLayout.setViewPager(viewPager,title,this,fragments);
    }
}
