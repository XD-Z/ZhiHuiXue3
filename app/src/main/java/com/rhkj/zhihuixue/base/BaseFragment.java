package com.rhkj.zhihuixue.base;

import android.app.Fragment;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

public abstract class BaseFragment extends Fragment implements View.OnClickListener {
    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        return initView(inflater, container);
    }

    /**
     * 初始化布局
     */
    public View initView(LayoutInflater inflater, ViewGroup container) {
        View pView = loadViewLayout(inflater, container);
        findViewsById(pView);
        initData();
        setFragmentLogic();
        setListener();

        return pView;
    }

    /**
     * 加载布局
     */
    protected abstract View loadViewLayout(LayoutInflater inflater,
                                           ViewGroup container);

    /**
     * 初始化控件
     */
    protected abstract void findViewsById(View view);

    /**
     * @Description:初始化数据
     */
    protected void initData() {
    }

    ;

    /**
     * 处理点击事件
     *
     * @param
     */
    protected abstract void onClickEvent(View v);

    /**
     * 设置监听器
     */
    protected abstract void setListener();

    /**
     * 逻辑处理部分
     */
    protected void setFragmentLogic() {
    }

    ;

    @Override
    public void onClick(View v) {
        onClickEvent(v);

    }
}
