package com.rhkj.zhihuixue.activity;


import android.support.v4.app.Fragment;
import android.support.v4.view.ViewPager;
import android.view.View;

import com.flyco.tablayout.SlidingTabLayout;
import com.rhkj.zhihuixue.R;
import com.rhkj.zhihuixue.base.BaseActivity;
import com.rhkj.zhihuixue.fragment.GrammarFragment;
import com.rhkj.zhihuixue.fragment.MyOrderFragment;

import java.util.ArrayList;

/**
 * 语法一点通
 * <p>
 * Created by zjx on 2019/5/9.
 */

public class ScheduleGrammarActivity extends BaseActivity {


    private String[] title = {"一般过去时", "一般将来时", "现在进行时", "一般现在时"};

    @Override
    protected void initLayout() {
        super.initLayout();
        setContentView(R.layout.ac_schedule_grammar);

    }

    @Override
    protected void initViews() {
        tvTitle.setText("语法易点通");
        SlidingTabLayout slidingTabLayout = findViewById(R.id.stl);
        ViewPager viewPager = findViewById(R.id.vp);

        ArrayList<Fragment> fragments = new ArrayList<>();
        for (int i = 0; i < title.length; i++) {
            fragments.add(new GrammarFragment());
        }

        slidingTabLayout.setViewPager(viewPager, title, this, fragments);


    }
}
