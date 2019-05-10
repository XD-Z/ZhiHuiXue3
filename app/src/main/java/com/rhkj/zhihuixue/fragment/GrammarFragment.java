package com.rhkj.zhihuixue.fragment;

import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.support.v7.widget.GridLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.rhkj.zhihuixue.R;
import com.rhkj.zhihuixue.adapter.ScheduleStraightAdapter;
import com.rhkj.zhihuixue.base.BaseFragment;
import com.rhkj.zhihuixue.bean.ScheduleStraightBean;

import java.util.ArrayList;

/**
 * 语法一点通
 * <p>
 * Created by zjx on 2019/5/9.
 */

public class GrammarFragment extends Fragment {

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        return inflater.inflate(R.layout.fr_grammar, null, false);
    }

    @Override
    public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState) {
        RecyclerView recyclerView = view.findViewById(R.id.rv);
        recyclerView.setLayoutManager(new GridLayoutManager(getActivity(), 5));


        ArrayList<ScheduleStraightBean> scheduleStraightBeans = new ArrayList<>();

        for (int i = 0; i < 10; i++) {
            ScheduleStraightBean scheduleStraightBean = new ScheduleStraightBean();
            scheduleStraightBean.setNum("1-1");
            scheduleStraightBean.setIsAdopt(ScheduleStraightBean.ADOPT);
            scheduleStraightBeans.add(scheduleStraightBean);
        }

        ScheduleStraightAdapter scheduleStraightAdapter = new ScheduleStraightAdapter();
        recyclerView.setAdapter(scheduleStraightAdapter);
        scheduleStraightAdapter.setNewData(scheduleStraightBeans);
    }

}
