package com.rhkj.zhihuixue.bean;

/**
 * Created by zjx on 2019/5/8.
 */

public class MycourseBean {


    private int state;
    private int style;


    public MycourseBean(int state, int style) {
        this.state = state;
        this.style = style;
    }

    public int getState() {
        return state;
    }

    public void setState(int state) {
        this.state = state;
    }

    public int getStyle() {
        return style;
    }

    public void setStyle(int style) {
        this.style = style;
    }
}
