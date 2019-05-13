package com.rhkj.zhihuixue.adapter;

import android.support.annotation.Nullable;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;

import com.chad.library.adapter.base.BaseQuickAdapter;
import com.chad.library.adapter.base.BaseViewHolder;
import com.rhkj.zhihuixue.R;
import com.rhkj.zhihuixue.bean.SpeechAssessmentBean;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by zjx on 2019/5/10.
 */

public class SpeechAssessmentAdapter extends BaseQuickAdapter<SpeechAssessmentBean, BaseViewHolder> {
    public SpeechAssessmentAdapter(@Nullable List<SpeechAssessmentBean> data) {
        super(R.layout.item_speech_assessment, data);
    }

    @Override
    protected void convert(BaseViewHolder helper, SpeechAssessmentBean item) {
        RecyclerView recyclerView = helper.getView(R.id.rv_item);
        recyclerView.setLayoutManager(new LinearLayoutManager(mContext));

        ArrayList<SpeechAssessmentBean> speechAssessmentBeans = new ArrayList<>();
        speechAssessmentBeans.add(new SpeechAssessmentBean("n.", "书；卷；账簿"));
        speechAssessmentBeans.add(new SpeechAssessmentBean("vt.&vi.", "预定"));
        speechAssessmentBeans.add(new SpeechAssessmentBean("vt.", "登记；（向旅店、饭店、戏院等）预约；立案(控告某人）；订立演出契约"));
        speechAssessmentBeans.add(new SpeechAssessmentBean("abj.", "书的；帐薄上的；得之（或来自）书本的；按照（或依据）书本的"));
        SpeechAssessmentTypeAdapter speechAssessmentTypeAdapter = new SpeechAssessmentTypeAdapter(speechAssessmentBeans);
        recyclerView.setAdapter(speechAssessmentTypeAdapter);


    }
}
