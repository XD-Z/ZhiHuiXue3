package com.rhkj.zhihuixue.bean;

import java.util.List;

/**
 * Created by zjx on 2019/5/16.
 */

public class ShopGsonBean {

    /**
     * state : 200
     * msg : 获取成功!
     * data : [{"id":15,"name":"学习套餐类","res":[{"goods_id":3,"goods_name":"怪不得","cat_id":15,"shop_price":"50.00","virtual_indate":30,"original_img":"http://pq76gdclh.bkt.clouddn.com/a4c13201905111039066513.png,http://pq76gdclh.bkt.clouddn.com/c6049201905111039077177.png"}]},{"id":27,"name":"秒记单词类","res":[{"goods_id":2,"goods_name":"分封神","cat_id":27,"shop_price":"1.00","virtual_indate":0,"original_img":"http://pq76gdclh.bkt.clouddn.com/a4c13201905111039066513.png,http://pq76gdclh.bkt.clouddn.com/c6049201905111039077177.png"}]}]
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
         * id : 15
         * name : 学习套餐类
         * res : [{"goods_id":3,"goods_name":"怪不得","cat_id":15,"shop_price":"50.00","virtual_indate":30,"original_img":"http://pq76gdclh.bkt.clouddn.com/a4c13201905111039066513.png,http://pq76gdclh.bkt.clouddn.com/c6049201905111039077177.png"}]
         */

        private int id;
        private String name;
        private List<ResBean> res;

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

        public List<ResBean> getRes() {
            return res;
        }

        public void setRes(List<ResBean> res) {
            this.res = res;
        }

        public static class ResBean {
            /**
             * goods_id : 3
             * goods_name : 怪不得
             * cat_id : 15
             * shop_price : 50.00
             * virtual_indate : 30
             * original_img : http://pq76gdclh.bkt.clouddn.com/a4c13201905111039066513.png,http://pq76gdclh.bkt.clouddn.com/c6049201905111039077177.png
             */

            private int goods_id;
            private String goods_name;
            private int cat_id;
            private String shop_price;
            private int virtual_indate;
            private String original_img;

            public int getGoods_id() {
                return goods_id;
            }

            public void setGoods_id(int goods_id) {
                this.goods_id = goods_id;
            }

            public String getGoods_name() {
                return goods_name;
            }

            public void setGoods_name(String goods_name) {
                this.goods_name = goods_name;
            }

            public int getCat_id() {
                return cat_id;
            }

            public void setCat_id(int cat_id) {
                this.cat_id = cat_id;
            }

            public String getShop_price() {
                return shop_price;
            }

            public void setShop_price(String shop_price) {
                this.shop_price = shop_price;
            }

            public int getVirtual_indate() {
                return virtual_indate;
            }

            public void setVirtual_indate(int virtual_indate) {
                this.virtual_indate = virtual_indate;
            }

            public String getOriginal_img() {
                return original_img;
            }

            public void setOriginal_img(String original_img) {
                this.original_img = original_img;
            }
        }
    }
}
