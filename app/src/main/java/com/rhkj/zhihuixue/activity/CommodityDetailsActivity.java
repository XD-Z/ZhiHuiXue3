package com.rhkj.zhihuixue.activity;

import android.content.Intent;
import android.support.v4.view.ViewPager;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.LinearLayout;

import com.rhkj.zhihuixue.R;
import com.rhkj.zhihuixue.base.BaseActivity;
import com.rhkj.zhihuixue.utils.GlideImageLoader;
import com.youth.banner.Banner;
import com.youth.banner.BannerConfig;

import java.util.ArrayList;

/**
 * 商品详情
 * <p>
 * Created by zjx on 2019/5/7.
 */

public class CommodityDetailsActivity extends BaseActivity implements View.OnClickListener {

    private Banner banner;
    private int[] selectImg = {R.drawable.banner_select_t, R.drawable.banner_select_f};
    private LinearLayout llSelect;
    private Button button;


    @Override
    protected void initLayout() {
        super.initLayout();
        setContentView(R.layout.ac_commodity_detalis);
    }

    @Override
    protected void initViews() {
        super.initViews();
        banner = findViewById(R.id.vp);
        llSelect = findViewById(R.id.ll_select);
        button = findViewById(R.id.btn_purchase);


        initListener();
    }

    private void initListener() {
        button.setOnClickListener(this);
    }

    @Override
    protected void initData() {
        super.initData();

        tvTitle.setText("商品详情");
        ArrayList<Integer> integerArrayList = new ArrayList<>();
        integerArrayList.add(R.mipmap.test_img_one);
        integerArrayList.add(R.mipmap.test_img_two);

        banner.setImageLoader(new GlideImageLoader())
                .setImages(integerArrayList)
                .setBannerStyle(BannerConfig.NOT_INDICATOR)
                .start();


        bannerSelectInit(integerArrayList.size());
    }

    ArrayList<ImageView> imageViews = new ArrayList<>();

    private void bannerSelectInit(final int pageCount) {


        for (int i = 0; i < pageCount; i++) {
            ImageView imageView = new ImageView(this);
            LinearLayout.LayoutParams params = new LinearLayout.LayoutParams(new ViewGroup.LayoutParams(
                    ViewGroup.LayoutParams.WRAP_CONTENT, ViewGroup.LayoutParams.WRAP_CONTENT));
            //为小圆点左右添加间距
            params.leftMargin = 10;
            params.rightMargin = 10;
            //给小圆点一个默认大小
            params.height = 20;
            params.width = 20;
            if (i == 0) {
                imageView.setBackgroundResource(selectImg[0]);
            } else {
                imageView.setBackgroundResource(selectImg[1]);
            }
            //为LinearLayout添加ImageView
            llSelect.addView(imageView, params);
            imageViews.add(imageView);
        }

        banner.setOnPageChangeListener(new ViewPager.OnPageChangeListener() {
            @Override
            public void onPageScrolled(int i, float v, int i1) {

            }

            @Override
            public void onPageSelected(int pos) {
                for (int i = 0; i < pageCount; i++) {
                    //选中的页面改变小圆点为选中状态，反之为未选中
                    if ((pos % pageCount) == i) {
                        (imageViews.get(i)).setBackgroundResource(selectImg[0]);
                    } else {
                        (imageViews.get(i)).setBackgroundResource(selectImg[1]);
                    }
                }
            }

            @Override
            public void onPageScrollStateChanged(int i) {

            }
        });
    }

    @Override
    protected void onStart() {
        super.onStart();
        banner.startAutoPlay();
    }

    @Override
    protected void onStop() {
        super.onStop();
        banner.stopAutoPlay();
    }

    @Override
    public void onClick(View view) {
        switch (view.getId()) {
            case R.id.btn_purchase:
                startActivity(new Intent(this,OrderConfirmActivity.class));
                break;
        }

    }
}
