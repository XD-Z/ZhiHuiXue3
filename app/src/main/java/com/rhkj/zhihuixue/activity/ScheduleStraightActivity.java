package com.rhkj.zhihuixue.activity;

import android.support.v7.widget.GridLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.util.Log;
import android.view.View;
import android.widget.EditText;

import com.rhkj.zhihuixue.R;
import com.rhkj.zhihuixue.adapter.ScheduleStraightAdapter;
import com.rhkj.zhihuixue.base.BaseActivity;

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
        for (int i = 0; i < 11; i++) {
            integerArrayList.add(1);
        }
        integerArrayList.add(0);
        integerArrayList.add(0);

        scheduleStraightAdapter = new ScheduleStraightAdapter(integerArrayList);
        recyclerView.setAdapter(scheduleStraightAdapter);

    }
}
