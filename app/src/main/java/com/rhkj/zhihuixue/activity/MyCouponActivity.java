package com.rhkj.zhihuixue.activity;

import android.support.v4.app.Fragment;
import android.support.v4.view.ViewPager;
import android.support.v7.widget.RecyclerView;
import android.view.View;

import com.flyco.tablayout.SlidingTabLayout;
import com.rhkj.zhihuixue.R;
import com.rhkj.zhihuixue.base.BaseActivity;
import com.rhkj.zhihuixue.fragment.CouponAlreadyusedFragment;
import com.rhkj.zhihuixue.fragment.CouponExpiredFragment;
import com.rhkj.zhihuixue.fragment.CouponNotusedFragment;

import java.util.ArrayList;

/**
 * 我的优惠券
 * <p>
 * Created by zjx on 2019/5/10.
 */

public class MyCouponActivity extends BaseActivity {


    private SlidingTabLayout slidingTabLayout;
    private ViewPager viewPager;
    private String[] title = {"待使用", "已使用", "已过期"};

    @Override
    protected void initLayout() {
        super.initLayout();
        setContentView(R.layout.ac_my_coupon);
    }

    @Override
    protected void initViews() {
        tvTitle.setText("优惠券");

        slidingTabLayout = findViewById(R.id.stl);
        viewPager = findViewById(R.id.vp);

    }

    @Override
    protected void initData() {
        ArrayList<Fragment> fragments = new ArrayList<>();
        fragments.add(new CouponNotusedFragment());
        fragments.add(new CouponAlreadyusedFragment());
        fragments.add(new CouponExpiredFragment());

        slidingTabLayout.setViewPager(viewPager, title, this, fragments);


    }
}
