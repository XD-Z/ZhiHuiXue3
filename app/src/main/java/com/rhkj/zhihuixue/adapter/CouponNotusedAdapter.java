package com.rhkj.zhihuixue.adapter;

import android.support.annotation.Nullable;

import com.chad.library.adapter.base.BaseQuickAdapter;
import com.chad.library.adapter.base.BaseViewHolder;
import com.rhkj.zhihuixue.R;

import java.util.List;

/**
 * Created by zjx on 2019/5/10.
 */

public class CouponNotusedAdapter extends BaseQuickAdapter<String,BaseViewHolder> {
    public CouponNotusedAdapter(@Nullable List<String> data) {
        super(R.layout.item_coupon_notused, data);
    }

    @Override
    protected void convert(BaseViewHolder helper, String item) {

    }
}
