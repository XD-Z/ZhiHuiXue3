package com.rhkj.zhihuixue.bean;

import com.chad.library.adapter.base.entity.MultiItemEntity;

/**
 * Created by zjx on 2019/5/9.
 */

public class QuestionBean implements MultiItemEntity {

    public static final int you = 1;
    public static final int my = 2;
    private int itemType;

    public QuestionBean(int itemType) {
        this.itemType = itemType;
    }


    @Override
    public int getItemType() {
        return itemType;
    }
}
