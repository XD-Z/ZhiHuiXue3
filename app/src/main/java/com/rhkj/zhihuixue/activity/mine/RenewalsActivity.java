package com.rhkj.zhihuixue.activity.mine;

import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;

import com.rhkj.zhihuixue.R;
import com.rhkj.zhihuixue.adapter.RenewalsAdapter;
import com.rhkj.zhihuixue.base.BaseActivity;
import com.rhkj.zhihuixue.utils.GlideImageLoader;
import com.youth.banner.Banner;

import java.util.ArrayList;

/**
 *  我要续费
 */
public class RenewalsActivity extends BaseActivity {

    private Banner banner;
    private RecyclerView recyclerView;

    @Override
    protected void initLayout() {
        super.initLayout();
        setContentView(R.layout.activity_renewals);
    }

    @Override
    protected void initViews() {
        tvTitle.setText("我要续费");
        banner = findViewById(R.id.vp);
        recyclerView = findViewById(R.id.rv);
        recyclerView.setLayoutManager(new LinearLayoutManager(this,LinearLayoutManager.HORIZONTAL,false));


    }

    @Override
    protected void initData() {


        ArrayList<Integer> integerArrayList = new ArrayList<>();
        integerArrayList.add(R.mipmap.img_banner_renewals);
        integerArrayList.add(R.mipmap.img_banner_renewals);

        banner.setImages(integerArrayList).setImageLoader(new GlideImageLoader()).start();


        ArrayList<Integer> integerArrayList1 = new ArrayList<>();
        for (int i = 0; i < 6; i++) {
            integerArrayList1.add(0);
        }

        RenewalsAdapter renewalsAdapter = new RenewalsAdapter(integerArrayList1);
        recyclerView.setAdapter(renewalsAdapter);




    }
}
