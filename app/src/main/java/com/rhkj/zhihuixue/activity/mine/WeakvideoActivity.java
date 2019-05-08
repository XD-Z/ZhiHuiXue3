package com.rhkj.zhihuixue.activity.mine;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.View;
import android.widget.TextView;

import com.rhkj.zhihuixue.R;
import com.rhkj.zhihuixue.adapter.WeakvideoAdapter;
import com.rhkj.zhihuixue.base.BaseActivity;

import java.util.ArrayList;

/**
 *  薄弱节点视频
 */
public class WeakvideoActivity extends BaseActivity {

    private TextView tvIntroduce;
    private RecyclerView recyclerView;

    @Override
    protected void initLayout() {
        super.initLayout();
        setContentView(R.layout.activity_weakvideo);
    }

    @Override
    protected void initViews() {
        tvIntroduce = findViewById(R.id.tv_introduce);
        recyclerView = findViewById(R.id.rv);

        recyclerView.setLayoutManager(new LinearLayoutManager(this));


    }

    @Override
    protected void initData() {
        tvTitle.setText("薄弱节点视频");
        tvIntroduce.setText("以下节点视频为智能系统针对\n" +
                "您直记直译答题情况匹配的，请加强训练");


        ArrayList<Integer> integerArrayList = new ArrayList<>();
        integerArrayList.add(1);
        integerArrayList.add(0);
        integerArrayList.add(0);
        integerArrayList.add(0);
        integerArrayList.add(0);
        integerArrayList.add(1);
        integerArrayList.add(0);
        integerArrayList.add(0);

        WeakvideoAdapter weakvideoAdapter = new WeakvideoAdapter(integerArrayList);
        recyclerView.setAdapter(weakvideoAdapter);




    }
}
