package com.rhkj.zhihuixue.activity;

import android.support.v7.widget.GridLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.util.Log;

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


        ArrayList<String> strings = new ArrayList<>();
        for (int i = 0; i < 14; i++) {
            strings.add("");
        }
//        ScheduleStraightAdapter scheduleStraightAdapter = new ScheduleStraightAdapter(strings);
//        recyclerView.setAdapter(scheduleStraightAdapter);


        int num = 0;
        int a = 0;

        do {
            a = 14 - 5;
            num++;
        }
        while (a < 0);

        Log.e("TAG", num + "");

    }
}
