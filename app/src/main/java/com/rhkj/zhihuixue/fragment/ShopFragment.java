package com.rhkj.zhihuixue.fragment;


import android.app.Fragment;
import android.content.Intent;
import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.chad.library.adapter.base.BaseQuickAdapter;
import com.google.gson.Gson;
import com.rhkj.zhihuixue.R;
import com.rhkj.zhihuixue.activity.CommodityDetailsActivity;
import com.rhkj.zhihuixue.adapter.ShopAdapter;
import com.rhkj.zhihuixue.base.Contents;
import com.rhkj.zhihuixue.bean.ShopGsonBean;
import com.rhkj.zhihuixue.utils.SimpleDividerItemDecoration;
import com.zhy.http.okhttp.OkHttpUtils;
import com.zhy.http.okhttp.callback.StringCallback;

import java.util.ArrayList;
import java.util.List;

import okhttp3.Call;

/**
 * 商城
 * <p>
 * A simple {@link Fragment} subclass.
 */
public class ShopFragment extends Fragment {


    private RecyclerView recyclerView;
    private Gson gson;
    private ShopAdapter shopAdapter;


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
        recyclerView.addItemDecoration(new SimpleDividerItemDecoration(getActivity(), 2));


        init();


    }

    private void init() {
        gson = new Gson();

        shopAdapter = new ShopAdapter();
        recyclerView.setAdapter(shopAdapter);
        ArrayList<ShopGsonBean.DataBean> dataBeans = new ArrayList<>();
        dataBeans.add(new ShopGsonBean.DataBean());
        dataBeans.add(new ShopGsonBean.DataBean());
        dataBeans.add(new ShopGsonBean.DataBean());
        dataBeans.add(new ShopGsonBean.DataBean());
        dataBeans.add(new ShopGsonBean.DataBean());
        shopAdapter.setNewData(dataBeans);


//        OkHttpUtils.post()
//                .url(Contents.GOODS)
//                .build()
//                .execute(new StringCallback() {
//                    @Override
//                    public void onError(Call call, Exception e, int id) {
//
//
//                    }
//
//                    @Override
//                    public void onResponse(String response, int id) {
//
//                        ShopGsonBean shopGsonBean = gson.fromJson(response, ShopGsonBean.class);
//                        int state = shopGsonBean.getState();
//                        if (state == 200) {
//                            List<ShopGsonBean.DataBean> data = shopGsonBean.getData();
//                            shopAdapter.setNewData(data);
//                        }
//                    }
//                });


        shopAdapter.setOnItemClickListener(new BaseQuickAdapter.OnItemClickListener() {
            @Override
            public void onItemClick(BaseQuickAdapter adapter, View view, int position) {
                startActivity(new Intent(getActivity(), CommodityDetailsActivity.class));
            }
        });
    }
}
