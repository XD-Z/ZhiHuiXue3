package com.rhkj.zhihuixue.activity;

import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.util.Log;
import android.view.MotionEvent;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;

import com.constraint.ResultBody;
import com.rhkj.zhihuixue.R;
import com.rhkj.zhihuixue.adapter.SpeechAssessmentAdapter;
import com.rhkj.zhihuixue.base.BaseActivity;
import com.rhkj.zhihuixue.base.Contents;
import com.rhkj.zhihuixue.bean.SpeechAssessmentBean;
import com.rhkj.zhihuixue.dialog.EvaluationResultsDialog;
import com.rhkj.zhihuixue.utils.RecyclerViewScrollerUtils;
import com.xs.BaseSingEngine;
import com.xs.SingEngine;
import com.xs.impl.OnEndCallback;
import com.zhy.http.okhttp.OkHttpUtils;
import com.zhy.http.okhttp.callback.StringCallback;

import org.json.JSONObject;

import java.util.ArrayList;
import okhttp3.Call;

/**
 * 语音评测
 * Created by zjx on 2019/5/10.
 */

public class SpeechAssessmentActivity extends BaseActivity implements View.OnClickListener {

    private RecyclerView recyclerView;
    private TextView tvEvaluating;
    private SpeechAssessmentAdapter speechAssessmentAdapter;
    private LinearLayoutManager linearLayoutManager;
    private ImageView ivNext;
    private ImageView ivUp;

    private SingEngine mEngine;

    @Override
    protected void initLayout() {
        super.initLayout();
        setContentView(R.layout.ac_speech_assessment);

//        mEngine = SingEngine.newInstance(SpeechAssessmentActivity.this);
//        mEngine.createEngine();
//        mEngine.setListener(new BaseSingEngine.ResultListener() {
//            @Override
//            public void onBegin() {
//
//            }
//
//            @Override
//            public void onResult(JSONObject jsonObject) {
//
//            }
//
//            @Override
//            public void onEnd(int i, String s) {
//
//            }
//
//            @Override
//            public void onUpdateVolume(int i) {
//
//            }
//
//            @Override
//            public void onFrontVadTimeOut() {
//
//            }
//
//            @Override
//            public void onBackVadTimeOut() {
//
//            }
//
//            @Override
//            public void onRecordingBuffer(byte[] bytes, int i) {
//
//            }
//
//            @Override
//            public void onRecordLengthOut() {
//
//            }
//
//            @Override
//            public void onReady() {
//
//            }
//
//            @Override
//            public void onPlayCompeleted() {
//
//            }
//
//            @Override
//            public void onRecordStop() {
//
//            }
//        });
//        mEngine.setOnEndCallback(new OnEndCallback() {
//            @Override
//            public void onEnd(ResultBody resultBody) {
//
//            }
//        });

    }

    @Override
    protected void initViews() {
        tvTitle.setText("语音评测");
        ivUp = findViewById(R.id.iv_up);
        ivNext = findViewById(R.id.iv_next);
        recyclerView = findViewById(R.id.rv);
        linearLayoutManager = new LinearLayoutManager(this, LinearLayoutManager.HORIZONTAL, false);
        recyclerView.setLayoutManager(linearLayoutManager);
        tvEvaluating = findViewById(R.id.tv_evaluating);

        recyclerView.setOnTouchListener(new View.OnTouchListener() {
            @Override
            public boolean onTouch(View view, MotionEvent motionEvent) {
                return true;
            }
        });

        initClickListener();

        
    }


    private void initClickListener() {
        tvEvaluating.setOnClickListener(this);
        ivNext.setOnClickListener(this);
        ivUp.setOnClickListener(this);
    }

    @Override
    protected void initData() {
//        int id = getIntent().getIntExtra("id", -1);
//
//
//        OkHttpUtils.post()
//                .url(Contents.SPEECH_ASSESSMENT)
//                .addParams("id", String.valueOf(id))
//                .build()
//                .execute(new StringCallback() {
//                    @Override
//                    public void onError(Call call, Exception e, int id) {
//
//                    }
//
//                    @Override
//                    public void onResponse(String response, int id) {
//
//                        Log.e("TAG", response);
//
//                    }
//                });


        ArrayList<SpeechAssessmentBean> speechAssessmentBeans = new ArrayList<>();
        speechAssessmentBeans.add(new SpeechAssessmentBean("n.", "书；卷；账簿"));
        speechAssessmentBeans.add(new SpeechAssessmentBean("vt.&vi.", "预定"));
        speechAssessmentBeans.add(new SpeechAssessmentBean("vt.", "登记；（向旅店、饭店、戏院等）预约；立案(控告某人）；订立演出契约"));
        speechAssessmentBeans.add(new SpeechAssessmentBean("abj.", "书的；帐薄上的；得之（或来自）书本的；按照（或依据）书本的"));
        speechAssessmentAdapter = new SpeechAssessmentAdapter(speechAssessmentBeans);
        recyclerView.setAdapter(speechAssessmentAdapter);


    }






    private int num = 0;

    @Override
    public void onClick(View view) {
        switch (view.getId()) {
            case R.id.tv_evaluating:
                EvaluationResultsDialog evaluationResultsDialog = new EvaluationResultsDialog();
                evaluationResultsDialog.show(getSupportFragmentManager(), "evaluationDialog");

                break;
            case R.id.iv_up:
                if (num == 0) {
                    return;
                }
                num--;
                RecyclerViewScrollerUtils recyclerViewScrollerUtils = new RecyclerViewScrollerUtils(this);
                recyclerViewScrollerUtils.setTargetPosition(num);
                linearLayoutManager.startSmoothScroll(recyclerViewScrollerUtils);

                break;
            case R.id.iv_next:
                if (num + 1 == speechAssessmentAdapter.getData().size()) {
                    return;
                }
                num++;
                RecyclerViewScrollerUtils recyclerViewScrollerUtils1 = new RecyclerViewScrollerUtils(this);
                recyclerViewScrollerUtils1.setTargetPosition(num);
                linearLayoutManager.startSmoothScroll(recyclerViewScrollerUtils1);

                break;

        }

    }


}
