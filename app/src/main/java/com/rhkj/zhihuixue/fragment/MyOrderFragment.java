package com.rhkj.zhihuixue.fragment;

import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.rhkj.zhihuixue.R;
import com.rhkj.zhihuixue.adapter.MyOrderAdapter;

import java.util.ArrayList;

/**
 * Created by zjx on 2019/5/8.
 */

public class MyOrderFragment extends Fragment {

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        return inflater.inflate(R.layout.fr_order, null, false);
    }

    @Override
    public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState) {
        RecyclerView recyclerView = view.findViewById(R.id.rv);
        recyclerView.setLayoutManager(new LinearLayoutManager(getActivity()));

        ArrayList<String> strings = new ArrayList<>();
        for (int i = 0; i < 6; i++) {
            strings.add("");

        }

        MyOrderAdapter myOrderAdapter = new MyOrderAdapter(strings);
        recyclerView.setAdapter(myOrderAdapter);

    }
}
