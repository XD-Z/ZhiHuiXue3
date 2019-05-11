package com.rhkj.zhihuixue.bean;

public class LogoinBean {

    /**
     * state : 1
     * msg : 成功
     * data : {"id":1,"user_name":"zx_3829","password":"e10adc3949ba59abbe56e057f20f883e","mobile":"18801471386","city":"","address":null,"gender":0,"addtime":2019,"upd_time":0,"purchased":null,"status":0,"token":"cmVuaGVzeGpoczE2NjU4LzE="}
     */

    private int state;
    private String msg;
    private DataBean data;

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

    public DataBean getData() {
        return data;
    }

    public void setData(DataBean data) {
        this.data = data;
    }

    public static class DataBean {
        /**
         * id : 1
         * user_name : zx_3829
         * password : e10adc3949ba59abbe56e057f20f883e
         * mobile : 18801471386
         * city :
         * address : null
         * gender : 0
         * addtime : 2019
         * upd_time : 0
         * purchased : null
         * status : 0
         * token : cmVuaGVzeGpoczE2NjU4LzE=
         */

        private int id;
        private String user_name;
        private String password;
        private String mobile;
        private String city;
        private Object address;
        private int gender;
        private int addtime;
        private int upd_time;
        private Object purchased;
        private int status;
        private String token;

        public int getId() {
            return id;
        }

        public void setId(int id) {
            this.id = id;
        }

        public String getUser_name() {
            return user_name;
        }

        public void setUser_name(String user_name) {
            this.user_name = user_name;
        }

        public String getPassword() {
            return password;
        }

        public void setPassword(String password) {
            this.password = password;
        }

        public String getMobile() {
            return mobile;
        }

        public void setMobile(String mobile) {
            this.mobile = mobile;
        }

        public String getCity() {
            return city;
        }

        public void setCity(String city) {
            this.city = city;
        }

        public Object getAddress() {
            return address;
        }

        public void setAddress(Object address) {
            this.address = address;
        }

        public int getGender() {
            return gender;
        }

        public void setGender(int gender) {
            this.gender = gender;
        }

        public int getAddtime() {
            return addtime;
        }

        public void setAddtime(int addtime) {
            this.addtime = addtime;
        }

        public int getUpd_time() {
            return upd_time;
        }

        public void setUpd_time(int upd_time) {
            this.upd_time = upd_time;
        }

        public Object getPurchased() {
            return purchased;
        }

        public void setPurchased(Object purchased) {
            this.purchased = purchased;
        }

        public int getStatus() {
            return status;
        }

        public void setStatus(int status) {
            this.status = status;
        }

        public String getToken() {
            return token;
        }

        public void setToken(String token) {
            this.token = token;
        }
    }
}
