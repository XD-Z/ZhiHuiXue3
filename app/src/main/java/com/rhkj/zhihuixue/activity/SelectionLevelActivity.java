package com.rhkj.zhihuixue.activity;

import android.content.Intent;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.util.Log;
import android.view.View;

import com.chad.library.adapter.base.BaseQuickAdapter;
import com.google.gson.Gson;
import com.rhkj.zhihuixue.R;
import com.rhkj.zhihuixue.adapter.SelectionLevelAdapter;
import com.rhkj.zhihuixue.base.BaseActivity;
import com.rhkj.zhihuixue.base.Contents;
import com.rhkj.zhihuixue.bean.SelectionLeveGsonBean;
import com.zhy.http.okhttp.OkHttpUtils;
import com.zhy.http.okhttp.callback.StringCallback;

import java.util.ArrayList;
import java.util.List;

import okhttp3.Call;

/**
 * 语音评测/选择级别
 * Created by zjx on 2019/5/10.
 */

public class SelectionLevelActivity extends BaseActivity implements BaseQuickAdapter.OnItemClickListener {

    private RecyclerView recyclerView;
    private Gson gson;
    private SelectionLevelAdapter selectionLevelAdapter;


    @Override
    protected void initLayout() {
        super.initLayout();
        setContentView(R.layout.ac_selection_level);
    }

    @Override
    protected void initViews() {
        tvTitle.setText("选择级别");

        recyclerView = findViewById(R.id.rv);
        recyclerView.setLayoutManager(new LinearLayoutManager(this));


    }

    @Override
    protected void initData() {
        selectionLevelAdapter = new SelectionLevelAdapter();
        recyclerView.setAdapter(selectionLevelAdapter);
        selectionLevelAdapter.setOnItemClickListener(this);
        gson = new Gson();

        OkHttpUtils
                .post()
                .url(Contents.WORD_LEVEL)
                .build()
                .execute(new StringCallback() {
                    @Override
                    public void onError(Call call, Exception e, int id) {

                    }

                    @Override
                    public void onResponse(String response, int id) {
                        SelectionLeveGsonBean selectionLeveGsonBean = gson.fromJson(response, SelectionLeveGsonBean.class);
                        List<SelectionLeveGsonBean.DataBean> data = selectionLeveGsonBean.getData();
                        selectionLevelAdapter.setNewData(data);

                    }
                });

    }

    @Override
    public void onItemClick(BaseQuickAdapter adapter, View view, int position) {
        List<SelectionLeveGsonBean.DataBean> data = selectionLevelAdapter.getData();

        SelectionLeveGsonBean.DataBean dataBean = data.get(position);

        int id = dataBean.getId();

        Intent intent = new Intent(this, SpeechAssessmentActivity.class);
        intent.putExtra("id", id);
        startActivity(intent);

    }
}
