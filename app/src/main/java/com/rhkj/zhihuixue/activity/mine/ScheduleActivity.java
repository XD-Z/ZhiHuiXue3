package com.rhkj.zhihuixue.activity.mine;

import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.util.AttributeSet;
import android.view.View;

import com.chad.library.adapter.base.BaseQuickAdapter;
import com.rhkj.zhihuixue.R;
import com.rhkj.zhihuixue.activity.ScheduleStraightActivity;
import com.rhkj.zhihuixue.adapter.ScheduleAdapter;
import com.rhkj.zhihuixue.base.BaseActivity;

/**
 * 动态学习计划表
 */
public class ScheduleActivity extends BaseActivity {


    private RecyclerView recyclerView;

    @Override
    protected void initLayout() {
        super.initLayout();
        setContentView(R.layout.activity_schedule);
    }

    @Override
    protected void initViews() {
        tvTitle.setText("动态学习计划表");

        recyclerView = findViewById(R.id.rv);
        recyclerView.setLayoutManager(new LinearLayoutManager(this));

        ScheduleAdapter scheduleAdapter = new ScheduleAdapter();
        recyclerView.setAdapter(scheduleAdapter);

        scheduleAdapter.setOnItemClickListener(new BaseQuickAdapter.OnItemClickListener() {
            @Override
            public void onItemClick(BaseQuickAdapter adapter, View view, int position) {

                switch (position) {
                    case 0:
                        startActivity(new Intent(ScheduleActivity.this, ScheduleStraightActivity.class));
                        break;
                    case 1:

                        break;
                    case 2:

                        break;
                }
            }
        });

    }


}
