package com.rhkj.zhihuixue.fragment;


import android.app.Fragment;
import android.content.Intent;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import com.rhkj.zhihuixue.R;
import com.rhkj.zhihuixue.activity.ScheduleGrammarActivity;
import com.rhkj.zhihuixue.activity.ScheduleMouthActivity;
import com.rhkj.zhihuixue.activity.ScheduleStraightActivity;

import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.OnClick;
import butterknife.Unbinder;

/**
 * A simple {@link Fragment} subclass.
 */
public class ZhiFragment extends Fragment {


    @BindView(R.id.iv_back)
    ImageView ivBack;
    @BindView(R.id.tv_title)
    TextView tvTitle;
    @BindView(R.id.img_zhi_direct_writing)
    ImageView imgZhiDirectWriting;
    @BindView(R.id.img_zhi_spoken_language)
    ImageView imgZhiSpokenLanguage;
    @BindView(R.id.img_zhi_grammar)
    ImageView imgZhiGrammar;
    Unbinder unbinder;

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View view = inflater.inflate(R.layout.fragment_zhi, container, false);
        unbinder = ButterKnife.bind(this, view);
        ivBack.setVisibility(View.GONE);
        tvTitle.setText("智能学习系统");

        return view;
    }

    @Override
    public void onDestroyView() {
        super.onDestroyView();
        unbinder.unbind();
    }

    @OnClick({R.id.tv_title, R.id.img_zhi_direct_writing, R.id.img_zhi_spoken_language, R.id.img_zhi_grammar})
    public void onViewClicked(View view) {
        switch (view.getId()) {
            case R.id.tv_title:
                break;
            case R.id.img_zhi_direct_writing:
                startActivity(new Intent(getActivity(), ScheduleStraightActivity.class));
                break;
            case R.id.img_zhi_spoken_language:
                startActivity(new Intent(getActivity(), ScheduleMouthActivity.class));
                break;
            case R.id.img_zhi_grammar:
                startActivity(new Intent(getActivity(), ScheduleGrammarActivity.class));
                break;
        }
    }
}
