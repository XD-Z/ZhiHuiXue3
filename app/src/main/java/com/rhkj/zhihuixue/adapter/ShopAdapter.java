package com.rhkj.zhihuixue.adapter;

import android.support.annotation.Nullable;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.View;
import android.widget.TextView;

import com.chad.library.adapter.base.BaseQuickAdapter;
import com.chad.library.adapter.base.BaseViewHolder;
import com.rhkj.zhihuixue.R;
import com.rhkj.zhihuixue.bean.ShopGsonBean;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by zjx on 2019/5/7.
 */

public class ShopAdapter extends BaseQuickAdapter<ShopGsonBean.DataBean, BaseViewHolder> {

    public ShopAdapter() {
        super(R.layout.item_shop);
    }

    @Override
    protected void convert(BaseViewHolder helper, ShopGsonBean.DataBean item) {

//        helper.setText(R.id.tv_title_item, item.getName());
        RecyclerView recyclerView = helper.getView(R.id.rv_itme);
        recyclerView.setLayoutManager(new LinearLayoutManager(mContext));

        ArrayList<ShopGsonBean.DataBean.ResBean> dataBeans = new ArrayList<>();
        dataBeans.add(new ShopGsonBean.DataBean.ResBean());
//        dataBeans.add(new ShopGsonBean.DataBean.ResBean());
//        dataBeans.add(new ShopGsonBean.DataBean.ResBean());
//        dataBeans.add(new ShopGsonBean.DataBean.ResBean());
//        dataBeans.add(new ShopGsonBean.DataBean.ResBean());

        ShopRvAdapter shopRvAdapter = new ShopRvAdapter(dataBeans);
        recyclerView.setAdapter(shopRvAdapter);


    }
}
