package com.rhkj.zhihuixue.adapter;

import android.support.annotation.Nullable;
import android.widget.TextView;

import com.chad.library.adapter.base.BaseQuickAdapter;
import com.chad.library.adapter.base.BaseViewHolder;
import com.rhkj.zhihuixue.R;

import java.util.List;

/**
 * Created by zjx on 2019/5/7.
 */

public class ShopAdapter extends BaseQuickAdapter<String,BaseViewHolder> {

    public ShopAdapter(@Nullable List<String> data) {
        super(R.layout.item_shop,data);
    }

    @Override
    protected void convert(BaseViewHolder helper, String item) {
        TextView tvMoney = helper.getView(R.id.tv_money);

    }
}
