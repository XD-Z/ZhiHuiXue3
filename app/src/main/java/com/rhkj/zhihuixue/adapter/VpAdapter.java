package com.rhkj.zhihuixue.adapter;

import android.content.Context;
import android.support.annotation.NonNull;
import android.support.v4.view.PagerAdapter;
import android.support.v7.widget.CardView;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by zjx on 2019/5/7.
 */

public class VpAdapter extends PagerAdapter {

    private List<Integer> integer;
    private Context context;
    private ArrayList<CardView> cardViewList;


    public VpAdapter(List<Integer> integer, Context context) {
        this.integer = integer;
        this.context = context;
        initView();
    }

    public void initView() {
        cardViewList = new ArrayList<>();

        for (int i = 0; i < integer.size(); i++) {
            CardView cardView = new CardView(context);
            cardView.setRadius(10);
            ImageView imageView = new ImageView(context);
            imageView.setScaleType(ImageView.ScaleType.FIT_XY);
            imageView.setImageResource(integer.get(i));
            cardView.addView(imageView);
            cardViewList.add(cardView);
        }


    }

    @Override
    public void destroyItem(@NonNull ViewGroup container, int position, @NonNull Object object) {
        container.removeView(cardViewList.get(position));
    }

    @NonNull
    @Override
    public Object instantiateItem(@NonNull ViewGroup container, int position) {
        container.addView(cardViewList.get(position));
        return cardViewList.get(position);
    }

    @Override
    public int getCount() {
        return integer.size();
    }

    @Override
    public boolean isViewFromObject(@NonNull View view, @NonNull Object o) {
        return view == o;
    }


}
