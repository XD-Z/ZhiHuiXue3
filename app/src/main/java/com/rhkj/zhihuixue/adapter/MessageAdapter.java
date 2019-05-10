package com.rhkj.zhihuixue.adapter;

import android.support.annotation.Nullable;

import com.chad.library.adapter.base.BaseQuickAdapter;
import com.chad.library.adapter.base.BaseViewHolder;
import com.rhkj.zhihuixue.R;

import java.util.List;

/**
 * Created by zjx on 2019/5/7.
 */

public class MessageAdapter extends BaseQuickAdapter<String,BaseViewHolder> {

    public MessageAdapter(@Nullable List<String> data) {
        super(R.layout.item_message_re,data);
    }

    @Override
    protected void convert(BaseViewHolder helper, String item) {
//        TextView tvMoney = helper.getView(R.id.tv_money);

    }
}
