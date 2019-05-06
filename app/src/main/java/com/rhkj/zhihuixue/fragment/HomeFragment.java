package com.rhkj.zhihuixue.fragment;


import android.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.rhkj.zhihuixue.R;
import com.rhkj.zhihuixue.base.BaseFragment;

/**
 * A simple {@link Fragment} subclass.
 */
public class HomeFragment extends BaseFragment {


    @Override
    protected View loadViewLayout(LayoutInflater inflater, ViewGroup container) {

        return inflater.inflate(R.layout.fragment_home, container, false);
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
}
