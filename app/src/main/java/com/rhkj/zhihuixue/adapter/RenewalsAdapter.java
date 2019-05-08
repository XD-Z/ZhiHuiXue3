package com.rhkj.zhihuixue.adapter;

import android.support.annotation.Nullable;

import com.chad.library.adapter.base.BaseQuickAdapter;
import com.chad.library.adapter.base.BaseViewHolder;
import com.rhkj.zhihuixue.R;

import java.util.List;

/**
 * Created by zjx on 2019/5/8.
 */

public class RenewalsAdapter extends BaseQuickAdapter<Integer, BaseViewHolder> {

    public RenewalsAdapter(@Nullable List<Integer> data) {
        super(R.layout.item_renewals,data);
    }

    @Override
    protected void convert(BaseViewHolder helper, Integer item) {

    }
}
