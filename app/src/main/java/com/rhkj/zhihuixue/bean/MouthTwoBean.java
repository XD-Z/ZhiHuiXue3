package com.rhkj.zhihuixue.bean;

import com.rhkj.zhihuixue.R;

import tellh.com.recyclertreeview_lib.LayoutItemType;

/**
 * Created by zjx on 2019/5/21.
 */

public class MouthTwoBean implements LayoutItemType {

    public String oneName;


    public MouthTwoBean(String oneName) {
        this.oneName = oneName;
    }


    @Override
    public int getLayoutId() {
        return R.layout.item_mouth_two;
    }
}
