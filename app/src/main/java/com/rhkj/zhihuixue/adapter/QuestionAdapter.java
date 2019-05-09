package com.rhkj.zhihuixue.adapter;

import com.chad.library.adapter.base.BaseMultiItemQuickAdapter;
import com.chad.library.adapter.base.BaseViewHolder;
import com.rhkj.zhihuixue.R;
import com.rhkj.zhihuixue.bean.QuestionBean;

import java.util.List;

/**
 * Created by zjx on 2019/5/9.
 */

public class QuestionAdapter extends BaseMultiItemQuickAdapter<QuestionBean,BaseViewHolder> {
    /**
     * Same as QuickAdapter#QuickAdapter(Context,int) but with
     * some initialization data.
     *
     * @param data A new list is created out of this one to avoid mutable list
     */
    public QuestionAdapter(List<QuestionBean> data) {
        super(data);

        addItemType(QuestionBean.you, R.layout.item_question_you);
        addItemType(QuestionBean.my, R.layout.item_question_my);
    }

    @Override
    protected void convert(BaseViewHolder helper, QuestionBean item) {

    }
}
