package com.rhkj.zhihuixue.bean;

/**
 * Created by zjx on 2019/5/10.
 */

public class ScheduleStraightBean {
    //通过
    public static final int ADOPT = 1;
    //没通过
    public static final int NO_ADOPT = 2;
    //有数据
    public static final int DATA_AVAILABLE = 1;
    //假数据
    public static final int DATA_NO = 2;

    private String num;

    //是否是空数据   1是有数据 2是假数据
    private int dateState = DATA_AVAILABLE;

    //是否通过        1是通过 2是没通过
    private int isAdopt = DATA_AVAILABLE;


    public String getNum() {
        return num;
    }

    public void setNum(String num) {
        this.num = num;
    }

    public int getDateState() {
        return dateState;
    }

    public void setDateState(int dateState) {
        this.dateState = dateState;
    }

    public int getIsAdopt() {
        return isAdopt;
    }

    public void setIsAdopt(int isAdopt) {
        this.isAdopt = isAdopt;
    }
}
