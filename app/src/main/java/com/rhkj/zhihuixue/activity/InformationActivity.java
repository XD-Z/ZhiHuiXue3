package com.rhkj.zhihuixue.activity;

import android.content.Intent;
import android.net.Uri;
import android.support.annotation.Nullable;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.View;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.TextView;

import com.bumptech.glide.Glide;

import com.rhkj.zhihuixue.R;

import com.rhkj.zhihuixue.base.BaseActivity;
import com.rhkj.zhihuixue.bean.RegisterGradeGsonBean;
import com.rhkj.zhihuixue.repeat.CityData;
import com.rhkj.zhihuixue.repeat.GradeData;
import com.yalantis.ucrop.model.AspectRatio;


import java.io.File;
import java.util.ArrayList;
import java.util.List;

import cn.finalteam.rxgalleryfinal.RxGalleryFinal;
import cn.finalteam.rxgalleryfinal.imageloader.ImageLoaderType;
import cn.finalteam.rxgalleryfinal.rxbus.RxBusResultDisposable;
import cn.finalteam.rxgalleryfinal.rxbus.event.ImageRadioResultEvent;

/**
 * Created by zjx on 2019/5/17.
 */

public class InformationActivity extends BaseActivity implements View.OnClickListener {


    private EditText editPhone;
    private TextView tvAddress;
    private EditText editCall;
    private EditText editName;
    private TextView tvGrade;
    private TextView tvId;
    private CityData cityData;
    private int gradeId;
    private TextView tvPreservation;
    private ImageView ivHade;

    @Override
    protected void initLayout() {
        super.initLayout();
        setContentView(R.layout.ac_information);
    }

    @Override
    protected void initViews() {
        tvTitle.setText("个人中心");

        editPhone = findViewById(R.id.edit_phone);
        tvAddress = findViewById(R.id.tv_address);
        editCall = findViewById(R.id.edit_call);
        editName = findViewById(R.id.edit_name);
        tvGrade = findViewById(R.id.tv_grade);
        tvId = findViewById(R.id.tv_id);
        tvPreservation = findViewById(R.id.tv_preservation);
        ivHade = findViewById(R.id.iv_hade);


        tvGrade.setOnClickListener(this);
        tvAddress.setOnClickListener(this);
        ivHade.setOnClickListener(this);
    }

    @Override
    protected void initData() {
        cityData = new CityData(this);
    }

    @Override
    public void onClick(View v) {
        switch (v.getId()) {
            case R.id.tv_grade:
                grade();
                break;
            case R.id.tv_address:
                chosecityConfig();
                break;
            case R.id.tv_preservation:
                preservation();
                break;
            case R.id.iv_hade:
                imgSelect();
                break;

        }

    }


    private void preservation() {
        String phone = editPhone.getText().toString();
        String call = editCall.getText().toString();
        String name = editName.getText().toString();


    }

    private void imgSelect() {

        RxGalleryFinal
                .with(this)
                .image()
                .imageLoader(ImageLoaderType.GLIDE)
                .subscribe(new RxBusResultDisposable<ImageRadioResultEvent>() {
                    @Override
                    protected void onEvent(ImageRadioResultEvent imageRadioResultEvent) throws Exception {
                        String originalPath = imageRadioResultEvent.getResult().getOriginalPath();
                        Glide.with(InformationActivity.this).load(new File(originalPath)).into(ivHade);
                    }
                })
                .openGallery();
    }



    //选择年级
    private void grade() {
        GradeData gradeData = new GradeData(this);
        gradeData.setRepoeatInterface(new GradeData.GradeInterface() {
            @Override
            public void gradeData(RegisterGradeGsonBean.DataBean dataBean) {
                String name = dataBean.getName();
                gradeId = dataBean.getId();
                tvGrade.setText(name);
            }
        });
    }

    /**
     * 城市选择器
     */
    private void chosecityConfig() {
        cityData.setCityInterface(new CityData.CityInterface() {
            @Override
            public void city(String province, String city, String area) {
                tvAddress.setText(province + city + area);
            }
        });
    }
}
