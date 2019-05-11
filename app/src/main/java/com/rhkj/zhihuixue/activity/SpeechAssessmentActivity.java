package com.rhkj.zhihuixue.activity;

import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.View;
import android.widget.TextView;

import com.rhkj.zhihuixue.R;
import com.rhkj.zhihuixue.adapter.SpeechAssessmentAdapter;
import com.rhkj.zhihuixue.base.BaseActivity;
import com.rhkj.zhihuixue.bean.SpeechAssessmentBean;
import com.rhkj.zhihuixue.dialog.EvaluationResultsDialog;

import java.util.ArrayList;

/**
 * 语音评测
 * Created by zjx on 2019/5/10.
 */

public class SpeechAssessmentActivity extends BaseActivity implements View.OnClickListener {

    private RecyclerView recyclerView;
    private TextView tvEvaluating;

    @Override
    protected void initLayout() {
        super.initLayout();
        setContentView(R.layout.ac_speech_assessment);

    }

    @Override
    protected void initViews() {
        tvTitle.setText("语音评测");
        recyclerView = findViewById(R.id.rv);
        recyclerView.setLayoutManager(new LinearLayoutManager(this));
        tvEvaluating = findViewById(R.id.tv_evaluating);


        initClickListener();
    }

    private void initClickListener() {
        tvEvaluating.setOnClickListener(this);
    }

    @Override
    protected void initData() {

        ArrayList<SpeechAssessmentBean> speechAssessmentBeans = new ArrayList<>();
        speechAssessmentBeans.add(new SpeechAssessmentBean("n.", "书；卷；账簿"));
        speechAssessmentBeans.add(new SpeechAssessmentBean("vt.&vi.", "预定"));
        speechAssessmentBeans.add(new SpeechAssessmentBean("vt.", "登记；（向旅店、饭店、戏院等）预约；立案(控告某人）；订立演出契约"));
        speechAssessmentBeans.add(new SpeechAssessmentBean("abj.", "书的；帐薄上的；得之（或来自）书本的；按照（或依据）书本的"));
        SpeechAssessmentAdapter speechAssessmentAdapter = new SpeechAssessmentAdapter(speechAssessmentBeans);
        recyclerView.setAdapter(speechAssessmentAdapter);


    }

    @Override
    public void onClick(View view) {
        switch (view.getId()) {
            case R.id.tv_evaluating:
                EvaluationResultsDialog evaluationResultsDialog = new EvaluationResultsDialog();
                evaluationResultsDialog.show(getSupportFragmentManager(), "evaluationDialog");

                break;

        }

    }
}
