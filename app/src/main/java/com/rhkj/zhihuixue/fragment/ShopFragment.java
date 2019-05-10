package com.rhkj.zhihuixue.fragment;



import android.app.Fragment;
import android.content.Intent;
import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.chad.library.adapter.base.BaseQuickAdapter;
import com.rhkj.zhihuixue.R;
import com.rhkj.zhihuixue.activity.CommodityDetailsActivity;
import com.rhkj.zhihuixue.adapter.ShopAdapter;
import com.rhkj.zhihuixue.utils.SimpleDividerItemDecoration;

import java.util.ArrayList;

/**
 *  商城
 *
 * A simple {@link Fragment} subclass.
 */
public class ShopFragment extends Fragment {


    private RecyclerView recyclerView;


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        return inflater.inflate(R.layout.fragment_shop, container, false);

    }

    @Override
    public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState) {


        recyclerView = view.findViewById(R.id.rv);
        recyclerView.setLayoutManager(new LinearLayoutManager(getActivity()));
        recyclerView.addItemDecoration(new SimpleDividerItemDecoration(getActivity(),2));
        ArrayList<String> strings = new ArrayList<>();
        strings.add("");
        strings.add("");
        strings.add("");
        strings.add("");
        ShopAdapter shopAdapter = new ShopAdapter(strings);
        recyclerView.setAdapter(shopAdapter);

        shopAdapter.setOnItemClickListener(new BaseQuickAdapter.OnItemClickListener() {
            @Override
            public void onItemClick(BaseQuickAdapter adapter, View view, int position) {
                startActivity(new Intent(getActivity(), CommodityDetailsActivity.class));
            }
        });



    }
}
