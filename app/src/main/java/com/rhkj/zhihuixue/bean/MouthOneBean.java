package com.rhkj.zhihuixue.bean;

import com.rhkj.zhihuixue.R;

import tellh.com.recyclertreeview_lib.LayoutItemType;

/**
 * Created by zjx on 2019/5/21.
 */

public class MouthOneBean implements LayoutItemType {

    public String oneName;


    public MouthOneBean(String oneName) {
        this.oneName = oneName;
    }

    public String getOneName() {
        return oneName;
    }

    public void setOneName(String oneName) {
        this.oneName = oneName;
    }

    @Override
    public int getLayoutId() {
        return R.layout.item_mouth_one;
    }
}
