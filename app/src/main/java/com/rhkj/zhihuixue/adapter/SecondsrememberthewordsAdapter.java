package com.rhkj.zhihuixue.adapter;

import android.support.annotation.Nullable;
import android.view.View;
import android.widget.TextView;

import com.chad.library.adapter.base.BaseQuickAdapter;
import com.chad.library.adapter.base.BaseViewHolder;
import com.rhkj.zhihuixue.R;
import com.rhkj.zhihuixue.bean.SecondsrememberthewordsBean;

import java.util.List;

public class SecondsrememberthewordsAdapter extends BaseQuickAdapter<SecondsrememberthewordsBean, BaseViewHolder> {

    private int isInt=-1;

    public SecondsrememberthewordsAdapter(@Nullable List<SecondsrememberthewordsBean> data) {
        super(R.layout.item_re_words, data);
    }

    public void setIsInt(int isInt) {
        this.isInt = isInt;
        notifyDataSetChanged();
    }

    @Override
    protected void convert(BaseViewHolder helper, SecondsrememberthewordsBean item) {
        TextView view = helper.getView(R.id.item_tv_words);


        if(isInt==helper.getLayoutPosition()){
            view.setBackgroundResource(R.drawable.bg_tv_words_true);
        }else {
            view.setBackgroundResource(R.drawable.bg_tv_words_false);
        }


    }
}
