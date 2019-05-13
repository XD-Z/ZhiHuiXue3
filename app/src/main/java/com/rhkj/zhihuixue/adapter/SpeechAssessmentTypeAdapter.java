package com.rhkj.zhihuixue.adapter;

import android.support.annotation.Nullable;

import com.chad.library.adapter.base.BaseQuickAdapter;
import com.chad.library.adapter.base.BaseViewHolder;
import com.rhkj.zhihuixue.R;
import com.rhkj.zhihuixue.bean.SpeechAssessmentBean;

import java.util.List;

/**
 * Created by zjx on 2019/5/10.
 */

public class SpeechAssessmentTypeAdapter extends BaseQuickAdapter<SpeechAssessmentBean, BaseViewHolder> {
    public SpeechAssessmentTypeAdapter(@Nullable List<SpeechAssessmentBean> data) {
        super(R.layout.item_speech_assessment_type, data);
    }

    @Override
    protected void convert(BaseViewHolder helper, SpeechAssessmentBean item) {

        helper.setText(R.id.tv_type, item.getType());
        helper.setText(R.id.tv_text, item.getText());


    }
}
