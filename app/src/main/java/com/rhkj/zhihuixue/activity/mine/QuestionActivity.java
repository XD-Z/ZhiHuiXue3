package com.rhkj.zhihuixue.activity.mine;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;

import com.rhkj.zhihuixue.R;
import com.rhkj.zhihuixue.base.BaseActivity;

/**
 * 常见问题
 */
public class QuestionActivity extends BaseActivity {

    private RecyclerView recyclerView;

    @Override
    protected void initLayout() {
        super.initLayout();
        setContentView(R.layout.activity_question);
    }

    @Override
    protected void initViews() {
        tvTitle.setText("常见问题解答");
        recyclerView = findViewById(R.id.rv);
        recyclerView.setLayoutManager(new LinearLayoutManager(this));


    }

    @Override
    protected void initData() {


    }
}
