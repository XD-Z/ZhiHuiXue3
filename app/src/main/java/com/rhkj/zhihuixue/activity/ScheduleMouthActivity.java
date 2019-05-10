package com.rhkj.zhihuixue.activity;

import android.support.v7.widget.GridLayoutManager;
import android.support.v7.widget.RecyclerView;

import com.rhkj.zhihuixue.R;
import com.rhkj.zhihuixue.adapter.ScheduleStraightAdapter;
import com.rhkj.zhihuixue.base.BaseActivity;
import com.rhkj.zhihuixue.bean.ScheduleStraightBean;

import java.util.ArrayList;

/**
 *      口语训练平台
 * <p>
 * Created by zjx on 2019/5/8.
 */

public class ScheduleMouthActivity extends BaseActivity {

    private ScheduleStraightAdapter scheduleStraightAdapter;

    @Override
    protected void initLayout() {
        super.initLayout();
        setContentView(R.layout.ac_schedule_straight);
    }

    @Override
    protected void initViews() {
        tvTitle.setText("口语训练平台");

        RecyclerView recyclerView = findViewById(R.id.rv);
        recyclerView.setLayoutManager(new GridLayoutManager(this, 5));

        ArrayList<ScheduleStraightBean> scheduleStraightBeans = new ArrayList<>();

        for (int i = 0; i < 10; i++) {
            ScheduleStraightBean scheduleStraightBean = new ScheduleStraightBean();
            scheduleStraightBean.setNum("1-1");
            scheduleStraightBean.setIsAdopt(ScheduleStraightBean.ADOPT);
            scheduleStraightBeans.add(scheduleStraightBean);
        }


        scheduleStraightAdapter = new ScheduleStraightAdapter();
        recyclerView.setAdapter(scheduleStraightAdapter);
        scheduleStraightAdapter.setNewData(scheduleStraightBeans);

    }
}
