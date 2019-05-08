package com.rhkj.zhihuixue.activity.mine;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.View;

import com.rhkj.zhihuixue.R;
import com.rhkj.zhihuixue.adapter.MycourseAdapter;
import com.rhkj.zhihuixue.base.BaseActivity;
import com.rhkj.zhihuixue.bean.MycourseBean;

import java.util.ArrayList;

/**
 * 我的课程
 */
public class MycourseActivity extends BaseActivity {


    private RecyclerView recyclerView;

    @Override
    protected void initLayout() {
        super.initLayout();
        setContentView(R.layout.activity_mycourse);
    }

    @Override
    protected void initViews() {
        tvTitle.setText("我的课程");
        recyclerView = findViewById(R.id.rv);
        recyclerView.setLayoutManager(new LinearLayoutManager(this));


        ArrayList<MycourseBean> mycourseBeans = new ArrayList<>();
        mycourseBeans.add(new MycourseBean(1, 0));
        mycourseBeans.add(new MycourseBean(0, 0));
        mycourseBeans.add(new MycourseBean(0, 0));
        mycourseBeans.add(new MycourseBean(0, 0));
        mycourseBeans.add(new MycourseBean(1, 1));
        mycourseBeans.add(new MycourseBean(0, 1));

        MycourseAdapter mycourseAdapter = new MycourseAdapter(mycourseBeans);
        recyclerView.setAdapter(mycourseAdapter);


    }


}
