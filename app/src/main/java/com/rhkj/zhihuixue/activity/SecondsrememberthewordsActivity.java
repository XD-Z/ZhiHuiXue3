package com.rhkj.zhihuixue.activity;

import android.annotation.SuppressLint;
import android.support.v7.widget.GridLayoutManager;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.View;
import android.widget.TextView;
import android.widget.Toast;

import com.chad.library.adapter.base.BaseQuickAdapter;
import com.chad.library.adapter.base.listener.OnItemClickListener;
import com.rhkj.zhihuixue.R;
import com.rhkj.zhihuixue.adapter.SecondsrememberthewordsAdapter;
import com.rhkj.zhihuixue.adapter.SpeechAssessmentAdapter;
import com.rhkj.zhihuixue.base.BaseActivity;
import com.rhkj.zhihuixue.bean.SecondsrememberthewordsBean;
import com.rhkj.zhihuixue.bean.SpeechAssessmentBean;

import java.util.ArrayList;

import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.OnClick;

/**
 * 秒记单词
 */
public class SecondsrememberthewordsActivity extends BaseActivity {

    @BindView(R.id.re_second_words)
    RecyclerView reSecondWords;
    @BindView(R.id.re_second_word_details)
    RecyclerView reSecondWordDetails;
    @BindView(R.id.btn_to_evaluation)
    TextView btnToEvaluation;
    private LinearLayoutManager linearLayoutManager;
    private SpeechAssessmentAdapter speechAssessmentAdapter;
    private SecondsrememberthewordsAdapter secondsrememberthewordsAdapter;
    private GridLayoutManager gridLayoutManager;



    @Override
    protected void initLayout() {
        setContentView(R.layout.activity_secondsrememberthewords);
        ButterKnife.bind(this);
    }

    @Override
    protected void initViews() {
        tvTitle.setText("秒记单词");

        gridLayoutManager = new GridLayoutManager(this, 2, LinearLayoutManager.VERTICAL, false);
        reSecondWords.setLayoutManager(gridLayoutManager);

        linearLayoutManager = new LinearLayoutManager(this, LinearLayoutManager.HORIZONTAL, false);
        reSecondWordDetails.setLayoutManager(linearLayoutManager);
    }

    @Override
    protected void initData() {
        ArrayList<SecondsrememberthewordsBean> wordsBean = new ArrayList<>();
        wordsBean.add(new SecondsrememberthewordsBean("book"));
        wordsBean.add(new SecondsrememberthewordsBean("mouse"));
        wordsBean.add(new SecondsrememberthewordsBean("android"));
        wordsBean.add(new SecondsrememberthewordsBean("studio"));
        secondsrememberthewordsAdapter = new SecondsrememberthewordsAdapter(wordsBean);
        reSecondWords.setAdapter(secondsrememberthewordsAdapter);

        ArrayList<SpeechAssessmentBean> speechAssessmentBeans = new ArrayList<>();
        speechAssessmentBeans.add(new SpeechAssessmentBean("n.", "书；卷；账簿"));
        speechAssessmentBeans.add(new SpeechAssessmentBean("vt.&vi.", "预定"));
        speechAssessmentBeans.add(new SpeechAssessmentBean("vt.", "登记；（向旅店、饭店、戏院等）预约；立案(控告某人）；订立演出契约"));
        speechAssessmentBeans.add(new SpeechAssessmentBean("abj.", "书的；帐薄上的；得之（或来自）书本的；按照（或依据）书本的"));
        speechAssessmentAdapter = new SpeechAssessmentAdapter(speechAssessmentBeans);
        reSecondWordDetails.setAdapter(speechAssessmentAdapter);


    }

    @Override
    protected void addListener() {
        reSecondWords.addOnItemTouchListener(new OnItemClickListener() {
            @Override
            public void onSimpleItemClick(BaseQuickAdapter adapter, View view, int position) {
                secondsrememberthewordsAdapter.setIsInt(position);

            }
        });
    }


    @OnClick(R.id.btn_to_evaluation)
    public void onViewClicked() {
    }
}
