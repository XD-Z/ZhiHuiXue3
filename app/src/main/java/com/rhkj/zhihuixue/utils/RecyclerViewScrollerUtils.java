package com.rhkj.zhihuixue.utils;

import android.content.Context;
import android.support.v7.widget.LinearSmoothScroller;
import android.support.v7.widget.RecyclerView;

/**
 * Created by zjx on 2019/5/13.
 */

public class RecyclerViewScrollerUtils extends LinearSmoothScroller {


    public RecyclerViewScrollerUtils(Context context) {
        super(context);
    }

    @Override
    protected int getHorizontalSnapPreference() {
        return SNAP_TO_START;
    }

    @Override
    protected int getVerticalSnapPreference() {
        return SNAP_TO_START;
    }
}
