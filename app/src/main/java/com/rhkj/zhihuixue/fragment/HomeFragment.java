package com.rhkj.zhihuixue.fragment;


import android.app.Fragment;
import android.content.Intent;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;

import com.gyf.barlibrary.ImmersionBar;
import com.rhkj.zhihuixue.R;
import com.rhkj.zhihuixue.activity.SelectionLevelActivity;
import com.rhkj.zhihuixue.base.BaseFragment;
import com.youth.banner.Banner;

import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.Unbinder;

/**
 * A simple {@link Fragment} subclass.
 */
public class HomeFragment extends BaseFragment {


    @BindView(R.id.banner)
    Banner banner;
    @BindView(R.id.img_voice_recognition)
    ImageView ivVoiceRecognition;

    Unbinder unbinder;

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
        switch (v.getId()) {
            case R.id.img_voice_recognition:
                startActivity(new Intent(getActivity(), SelectionLevelActivity.class));
                break;
        }

    }

    @Override
    protected void setListener() {
        ivVoiceRecognition.setOnClickListener(this);

    }


    @Override
    public void onDestroyView() {
        super.onDestroyView();
        unbinder.unbind();
    }
}
