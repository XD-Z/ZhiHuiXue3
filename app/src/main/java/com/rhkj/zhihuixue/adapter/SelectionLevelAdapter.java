package com.rhkj.zhihuixue.adapter;

import android.support.annotation.Nullable;
import android.widget.ImageView;

import com.bumptech.glide.Glide;
import com.chad.library.adapter.base.BaseQuickAdapter;
import com.chad.library.adapter.base.BaseViewHolder;
import com.rhkj.zhihuixue.R;
import com.rhkj.zhihuixue.bean.SelectionLeveGsonBean;

import java.util.List;

/**
 * Created by zjx on 2019/5/10.
 */

public class SelectionLevelAdapter extends BaseQuickAdapter<SelectionLeveGsonBean.DataBean, BaseViewHolder> {

    public SelectionLevelAdapter() {
        super(R.layout.item_selection_leve);
    }


    @Override
    protected void convert(BaseViewHolder helper, SelectionLeveGsonBean.DataBean item) {
//        String name = item.getName();
//
//        helper.setText(R.id.tv_level, name);
//
//
//        String img = item.getImg();
//
//        if (img != null) {
//            Glide.with(mContext).load(img).into((ImageView) helper.getView(R.id.iv_img));
//        }


    }
}
