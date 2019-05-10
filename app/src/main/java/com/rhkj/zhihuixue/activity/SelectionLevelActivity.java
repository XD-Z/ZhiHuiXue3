package com.rhkj.zhihuixue.activity;

import android.content.Intent;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.View;

import com.chad.library.adapter.base.BaseQuickAdapter;
import com.rhkj.zhihuixue.R;
import com.rhkj.zhihuixue.adapter.SelectionLevelAdapter;
import com.rhkj.zhihuixue.base.BaseActivity;

import java.util.ArrayList;

/**
 * 语音评测/选择级别
 * Created by zjx on 2019/5/10.
 */

public class SelectionLevelActivity extends BaseActivity {

    @Override
    protected void initLayout() {
        super.initLayout();
        setContentView(R.layout.ac_selection_level);
    }

    @Override
    protected void initViews() {
        tvTitle.setText("选择级别");

        RecyclerView recyclerView = findViewById(R.id.rv);
        recyclerView.setLayoutManager(new LinearLayoutManager(this));

        ArrayList<String> strings = new ArrayList<>();
        for (int i = 0; i < 3; i++) {
            strings.add("");
        }
        SelectionLevelAdapter selectionLevelAdapter = new SelectionLevelAdapter(strings);
        recyclerView.setAdapter(selectionLevelAdapter);

        selectionLevelAdapter.setOnItemClickListener(new BaseQuickAdapter.OnItemClickListener() {
            @Override
            public void onItemClick(BaseQuickAdapter adapter, View view, int position) {
                startActivity(new Intent(SelectionLevelActivity.this,SpeechAssessmentActivity.class));
            }
        });

    }
}
