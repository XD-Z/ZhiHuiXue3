package com.rhkj.zhihuixue.activity;

import android.support.v7.widget.GridLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.util.Log;
import android.view.View;
import android.widget.EditText;

import com.rhkj.zhihuixue.R;
import com.rhkj.zhihuixue.adapter.ScheduleStraightAdapter;
import com.rhkj.zhihuixue.base.BaseActivity;
import com.rhkj.zhihuixue.bean.ScheduleStraightBean;

import java.util.ArrayList;

/**
 * 直记直译
 * <p>
 * Created by zjx on 2019/5/8.
 */

public class ScheduleStraightActivity extends BaseActivity {

    private ScheduleStraightAdapter scheduleStraightAdapter;

    @Override
    protected void initLayout() {
        super.initLayout();
        setContentView(R.layout.ac_schedule_straight);
    }

    @Override
    protected void initViews() {
        tvTitle.setText("直记直译");

        RecyclerView recyclerView = findViewById(R.id.rv);
        recyclerView.setLayoutManager(new GridLayoutManager(this, 5));

        ArrayList<Integer> integerArrayList = new ArrayList<>();

        integerArrayList.add(1);
        integerArrayList.add(2);
        integerArrayList.add(3);
        integerArrayList.add(4);

        scheduleStraightAdapter = new ScheduleStraightAdapter();
        recyclerView.setAdapter(scheduleStraightAdapter);

        ArrayList<ScheduleStraightBean> scheduleStraightBeans = new ArrayList<>();
        for (int i = 0; i < 16; i++) {
            ScheduleStraightBean scheduleStraightBean = new ScheduleStraightBean();
            scheduleStraightBean.setNum("1-" + i);
            scheduleStraightBean.setIsAdopt(ScheduleStraightBean.ADOPT);
            scheduleStraightBean.setDateState(ScheduleStraightBean.DATA_AVAILABLE);
            scheduleStraightBeans.add(scheduleStraightBean);
        }
        scheduleStraightAdapter.setDateList(scheduleStraightBeans);

    }
}
