package com.rhkj.zhihuixue.bean;

import com.google.gson.annotations.SerializedName;

import java.util.List;

/**
 * Created by zjx on 2019/5/17.
 */

public class AddressGsonBean {

    /**
     * state : 200
     * msg : 获取成功
     * data : [{"id":3,"user_id":1,"province":"北京市","city":"省直辖县级行政单位","countyarea":"朝阳区","desc":"详细地址11111","default":0,"name":"张","tel":"17664092628"},{"id":4,"user_id":1,"province":"天津市","city":"省直辖县级行政单位","countyarea":"和平区","desc":"详细地址2222222222","default":1,"name":"张","tel":"17664092628"}]
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
         * id : 3
         * user_id : 1
         * province : 北京市
         * city : 省直辖县级行政单位
         * countyarea : 朝阳区
         * desc : 详细地址11111
         * default : 0
         * name : 张
         * tel : 17664092628
         */

        private int id;
        private int user_id;
        private String province;
        private String city;
        private String countyarea;
        private String desc;
        @SerializedName("default")
        private int defaultX;
        private String name;
        private String tel;

        public int getId() {
            return id;
        }

        public void setId(int id) {
            this.id = id;
        }

        public int getUser_id() {
            return user_id;
        }

        public void setUser_id(int user_id) {
            this.user_id = user_id;
        }

        public String getProvince() {
            return province;
        }

        public void setProvince(String province) {
            this.province = province;
        }

        public String getCity() {
            return city;
        }

        public void setCity(String city) {
            this.city = city;
        }

        public String getCountyarea() {
            return countyarea;
        }

        public void setCountyarea(String countyarea) {
            this.countyarea = countyarea;
        }

        public String getDesc() {
            return desc;
        }

        public void setDesc(String desc) {
            this.desc = desc;
        }

        public int getDefaultX() {
            return defaultX;
        }

        public void setDefaultX(int defaultX) {
            this.defaultX = defaultX;
        }

        public String getName() {
            return name;
        }

        public void setName(String name) {
            this.name = name;
        }

        public String getTel() {
            return tel;
        }

        public void setTel(String tel) {
            this.tel = tel;
        }
    }
}
