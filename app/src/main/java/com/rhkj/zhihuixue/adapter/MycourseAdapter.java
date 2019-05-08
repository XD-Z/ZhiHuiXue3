package com.rhkj.zhihuixue.adapter;

import android.graphics.Color;
import android.media.Image;
import android.support.annotation.Nullable;
import android.view.View;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;

import com.chad.library.adapter.base.BaseQuickAdapter;
import com.chad.library.adapter.base.BaseViewHolder;
import com.rhkj.zhihuixue.R;
import com.rhkj.zhihuixue.bean.MycourseBean;

import java.util.List;

/**
 * Created by zjx on 2019/5/8.
 */

public class MycourseAdapter extends BaseQuickAdapter<MycourseBean, BaseViewHolder> {

    public MycourseAdapter(@Nullable List<MycourseBean> data) {
        super(R.layout.item_mycourse, data);
    }

    @Override
    protected void convert(BaseViewHolder helper, MycourseBean item) {
        LinearLayout llTitle = helper.getView(R.id.ll_title);
        ImageView ivPlay = helper.getView(R.id.iv_play);
        TextView tvTitle = helper.getView(R.id.tv_title);

        int state = item.getState();
        int style = item.getStyle();

        if (state == 1) {
            if (style == 0) {
                ivPlay.setImageResource(R.mipmap.icon_course_play_hong);
                tvTitle.setText("秒记单词");
                tvTitle.setTextColor(Color.parseColor("#FF7E00"));
                llTitle.setBackgroundColor(Color.parseColor("#38FF7E00"));

            } else {
                ivPlay.setImageResource(R.mipmap.icon_course_play_lv);
                tvTitle.setText("自适应分层学习系统");
                tvTitle.setTextColor(Color.parseColor("#5cb704"));
                llTitle.setBackgroundColor(Color.parseColor("#385cb704"));
            }

        } else {
            llTitle.setVisibility(View.GONE);
        }


    }
}
