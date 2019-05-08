package com.rhkj.zhihuixue.adapter;

import android.support.annotation.Nullable;
import android.view.View;
import android.widget.LinearLayout;

import com.chad.library.adapter.base.BaseQuickAdapter;
import com.chad.library.adapter.base.BaseViewHolder;
import com.rhkj.zhihuixue.R;
import com.rhkj.zhihuixue.bean.MineBean;

import java.util.List;

/**
 * Created by zjx on 2019/5/8.
 */

public class WeakvideoAdapter extends BaseQuickAdapter<Integer, BaseViewHolder> {

    public WeakvideoAdapter(@Nullable List<Integer> data) {
        super(R.layout.item_weakvideo, data);
    }

    @Override
    protected void convert(BaseViewHolder helper, Integer item) {
        LinearLayout linearLayout = helper.getView(R.id.ll_title);

        if(item==1){
            linearLayout.setVisibility(View.VISIBLE);
        }else {
            linearLayout.setVisibility(View.GONE);
        }




    }
}
