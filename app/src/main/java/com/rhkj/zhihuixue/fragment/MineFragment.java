package com.rhkj.zhihuixue.fragment;


import android.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.gyf.barlibrary.ImmersionBar;
import com.rhkj.zhihuixue.R;
import com.rhkj.zhihuixue.base.BaseFragment;

/**
 * A simple {@link Fragment} subclass.
 */
public class MineFragment extends BaseFragment {


    @Override
    protected View loadViewLayout(LayoutInflater inflater, ViewGroup container) {
        View view = inflater.inflate(R.layout.fragment_mine, container, false);

        //沉浸式状态栏
        ImmersionBar.with(getActivity()).init();



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
}
