package com.rhkj.zhihuixue.adapter;

import android.content.Intent;
import android.graphics.Color;
import android.support.annotation.Nullable;
import android.text.SpannableString;
import android.text.Spanned;
import android.text.style.ForegroundColorSpan;
import android.view.View;
import android.widget.TextView;

import com.chad.library.adapter.base.BaseQuickAdapter;
import com.chad.library.adapter.base.BaseViewHolder;
import com.rhkj.zhihuixue.R;
import com.rhkj.zhihuixue.activity.OrderCancelActivity;

import java.util.List;

/**
 * Created by zjx on 2019/5/8.
 */

public class MyOrderAdapter extends BaseQuickAdapter<String,BaseViewHolder> {
    public MyOrderAdapter(@Nullable List<String> data) {
        super(R.layout.item_myorder,data);
    }

    @Override
    protected void convert(final BaseViewHolder helper, String item) {
        TextView textView = helper.getView(R.id.tv_actual_money);

        String s = textView.getText().toString();
        SpannableString spannableString = new SpannableString(s);
        spannableString.setSpan(new ForegroundColorSpan(Color.parseColor("#de4d3e")),2,s.length(),Spanned.SPAN_EXCLUSIVE_EXCLUSIVE);
        textView.setText(spannableString);

        //取消订单
        helper.setOnClickListener(R.id.btn_cancel, new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                mContext.startActivity(new Intent(mContext, OrderCancelActivity.class));
            }
        });




    }
}
