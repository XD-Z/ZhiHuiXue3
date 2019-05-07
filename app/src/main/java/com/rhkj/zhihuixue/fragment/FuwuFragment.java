package com.rhkj.zhihuixue.fragment;


import android.app.Fragment;
import android.content.Intent;
import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.gyf.barlibrary.ImmersionBar;
import com.gyf.barlibrary.ImmersionFragment;
import com.rhkj.zhihuixue.R;
import com.rhkj.zhihuixue.activity.FuwuIntroduceActivity;

/**
 * 服务
 * A simple {@link Fragment} subclass.
 */
public class FuwuFragment extends Fragment {


    public FuwuFragment() {
        // Required empty public constructor
    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {

        // Inflate the layout for this fragment
        return inflater.inflate(R.layout.fragment_fuwu, container, false);
    }

    @Override
    public void onViewCreated(View view, @Nullable Bundle savedInstanceState) {

        //智能英语介绍
        view.findViewById(R.id.cv_english).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(getActivity(), FuwuIntroduceActivity.class);
                intent.putExtra("state",0);
                startActivity(intent);
            }
        });
        //服务介绍
        view.findViewById(R.id.cv_introduce).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(getActivity(), FuwuIntroduceActivity.class);
                intent.putExtra("state",1);
                startActivity(intent);
            }
        });

    }


}
