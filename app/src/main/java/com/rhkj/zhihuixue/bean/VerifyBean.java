package com.rhkj.zhihuixue.bean;

public class VerifyBean {

    /**
     * state : 1
     * msg : 发送成功
     * data :
     */

    private int state;
    private String msg;
    private String data;

    public int getState() {
        return state;
    }

    public void setState(int state) {
        this.state = state;
    }

    public String getMsg() {
        return msg;
    }

    public void setMsg(String msg) {
        this.msg = msg;
    }

    public String getData() {
        return data;
    }

    public void setData(String data) {
        this.data = data;
    }
}
