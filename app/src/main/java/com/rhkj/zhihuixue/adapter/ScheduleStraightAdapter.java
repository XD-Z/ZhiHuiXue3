package com.rhkj.zhihuixue.adapter;

import android.support.annotation.Nullable;
import android.util.Log;
import android.view.View;

import com.chad.library.adapter.base.BaseQuickAdapter;
import com.chad.library.adapter.base.BaseViewHolder;
import com.rhkj.zhihuixue.R;

import java.util.List;

/**
 * Created by zjx on 2019/5/8.
 */

public class ScheduleStraightAdapter extends BaseQuickAdapter<String, BaseViewHolder> {

    public ScheduleStraightAdapter(@Nullable List<String> data) {
        super(R.layout.item_schedule_straight, data);
    }

    @Override
    protected void convert(BaseViewHolder helper, String item) {
        View lineUp = helper.getView(R.id.line_up);
        View lineLeft = helper.getView(R.id.line_left);
        View lineRight = helper.getView(R.id.line_right);
        View lineLower = helper.getView(R.id.line_lower);


        int layoutPosition = helper.getLayoutPosition();


        if (layoutPosition == 0) {
            lineUp.setVisibility(View.GONE);
            lineLeft.setVisibility(View.GONE);
            lineLower.setVisibility(View.GONE);
            return;
        }


        int num = 1;
        int a = 0;

        do {
            a = layoutPosition - 5;
            num++;
        }
        while (a < 0);


        if (num % 2 == 1) {



        } else {


        }


    }
}
