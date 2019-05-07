package com.rhkj.zhihuixue.adapter;

import android.support.annotation.Nullable;

import com.chad.library.adapter.base.BaseQuickAdapter;
import com.chad.library.adapter.base.BaseViewHolder;
import com.rhkj.zhihuixue.R;
import com.rhkj.zhihuixue.bean.MineBean;

import java.util.List;

public class MineItemAdapter extends BaseQuickAdapter<MineBean, BaseViewHolder> {

    public MineItemAdapter(@Nullable List<MineBean> data) {
        super(R.layout.item_re_mine, data);
    }

    @Override
    protected void convert(BaseViewHolder helper, MineBean item) {
        int images = item.getImages();
        String titles = item.getTitles();

        helper.setImageResource(R.id.item_mine_re_img, images);
        helper.setText(R.id.item_mine_re_title, titles);


    }
}
