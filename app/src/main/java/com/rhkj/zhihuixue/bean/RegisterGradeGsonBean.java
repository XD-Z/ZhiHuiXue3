package com.rhkj.zhihuixue.bean;

import java.util.List;

/**
 * Created by zjx on 2019/5/17.
 */

public class RegisterGradeGsonBean {


    /**
     * state : 200
     * msg : 获取成功
     * data : [{"id":2,"name":"小学二年级"},{"id":3,"name":"小学三年级"},{"id":4,"name":"热热身"},{"id":6,"name":"初中一年级"},{"id":8,"name":"小学1"}]
     */

    private int state;
    private String msg;
    private List<DataBean> data;

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

    public List<DataBean> getData() {
        return data;
    }

    public void setData(List<DataBean> data) {
        this.data = data;
    }

    public static class DataBean {
        /**
         * id : 2
         * name : 小学二年级
         */

        private int id;
        private String name;

        public int getId() {
            return id;
        }

        public void setId(int id) {
            this.id = id;
        }

        public String getName() {
            return name;
        }

        public void setName(String name) {
            this.name = name;
        }
    }
}
