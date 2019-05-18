package com.rhkj.zhihuixue.adapter;

import android.support.annotation.Nullable;

import com.chad.library.adapter.base.BaseQuickAdapter;
import com.chad.library.adapter.base.BaseViewHolder;
import com.rhkj.zhihuixue.R;
import com.rhkj.zhihuixue.bean.AddressGsonBean;

import java.util.List;

/**
 * Created by zjx on 2019/5/16.
 */

public class AddressAdapter extends BaseQuickAdapter<AddressGsonBean.DataBean, BaseViewHolder> {
    public AddressAdapter() {
        super(R.layout.item_address);
    }

    @Override
    protected void convert(BaseViewHolder helper, AddressGsonBean.DataBean item) {

        helper.setText(R.id.tv_name, item.getName());
        helper.setText(R.id.tv_phone, item.getTel());
        helper.setText(R.id.tv_address, "收货地址:" + item.getProvince() + item.getCity() + item.getCountyarea() + item.getDesc());

        int defaultX = item.getDefaultX();

        if (defaultX == 0) {
            helper.setImageResource(R.id.iv_default, R.mipmap.icon_default);
        } else {
            helper.setImageResource(R.id.iv_default, R.mipmap.icon_default_f);
        }


    }
}
