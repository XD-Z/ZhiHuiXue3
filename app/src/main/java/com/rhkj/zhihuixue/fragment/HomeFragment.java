package com.rhkj.zhihuixue.fragment;


import android.app.Fragment;
import android.content.Intent;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;

import com.rhkj.zhihuixue.R;
import com.rhkj.zhihuixue.activity.SecondsrememberthewordsActivity;
import com.rhkj.zhihuixue.activity.SelectionLevelActivity;
import com.rhkj.zhihuixue.base.BaseFragment;
import com.youth.banner.Banner;

import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.OnClick;
import butterknife.Unbinder;

/**
 * A simple {@link Fragment} subclass.
 */
public class HomeFragment extends BaseFragment {


    Unbinder unbinder;
    @BindView(R.id.banner)
    Banner banner;
    @BindView(R.id.img_voice_recognition)
    ImageView imgVoiceRecognition;
    @BindView(R.id.img_remember_words)
    ImageView imgRememberWords;

    @Override
    protected View loadViewLayout(LayoutInflater inflater, ViewGroup container) {
        View view = inflater.inflate(R.layout.fragment_home, container, false);
        unbinder = ButterKnife.bind(this, view);
        return view;
    }

    @Override
    protected void findViewsById(View view) {

    }

    @Override
    protected void onClickEvent(View v) {

    }


    @Override
    protected void setListener() {

    }


    @Override
    public void onDestroyView() {
        super.onDestroyView();
        unbinder.unbind();
    }


    @OnClick({R.id.img_voice_recognition, R.id.img_remember_words})
    public void onViewClicked(View view) {
        switch (view.getId()) {
            case R.id.img_voice_recognition:
                startActivity(new Intent(getActivity(), SelectionLevelActivity.class));
                break;
            case R.id.img_remember_words:
                startActivity(new Intent(getActivity(), SecondsrememberthewordsActivity.class));
                break;
        }
    }


}
