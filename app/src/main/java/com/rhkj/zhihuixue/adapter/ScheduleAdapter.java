package com.rhkj.zhihuixue.adapter;

import android.support.annotation.Nullable;

import com.chad.library.adapter.base.BaseQuickAdapter;
import com.chad.library.adapter.base.BaseViewHolder;
import com.rhkj.zhihuixue.R;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by zjx on 2019/5/8.
 */

public class ScheduleAdapter extends BaseQuickAdapter<String, BaseViewHolder> {


    public ScheduleAdapter() {
        super(R.layout.item_schedule);

        initData();
    }

    private void initData() {
        ArrayList<String> strings = new ArrayList<>();
        strings.add("直记直译");
        strings.add("口语训练平台");
        strings.add("语法一点通");
        setNewData(strings);
    }

    @Override
    protected void convert(BaseViewHolder helper, String item) {
         helper.setText(R.id.tv_text,item);

    }
}
