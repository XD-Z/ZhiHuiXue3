package com.rhkj.zhihuixue.adapter;

import android.support.annotation.Nullable;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;

import com.bumptech.glide.Glide;
import com.chad.library.adapter.base.BaseQuickAdapter;
import com.chad.library.adapter.base.BaseViewHolder;
import com.rhkj.zhihuixue.R;
import com.rhkj.zhihuixue.bean.ShopGsonBean;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * Created by zjx on 2019/5/7.
 */

public class ShopRvAdapter extends BaseQuickAdapter<ShopGsonBean.DataBean.ResBean, BaseViewHolder> {

    public ShopRvAdapter(@Nullable List<ShopGsonBean.DataBean.ResBean> data) {
        super(R.layout.item_shop_rv, data);
    }

    @Override
    protected void convert(BaseViewHolder helper, ShopGsonBean.DataBean.ResBean item) {

        helper.setText(R.id.tv_name, item.getGoods_name());
        helper.setText(R.id.tv_money, item.getShop_price());
        ImageView ivCover = helper.getView(R.id.iv_cover);


        String original_img = item.getOriginal_img();
        String replace = original_img.replace(" ", "");
        List<String> strings = Arrays.asList(replace.split(","));
        if (!strings.isEmpty()) {
            String s = strings.get(0);
            Glide.with(mContext).load(s).into(ivCover);
        }


    }
}
