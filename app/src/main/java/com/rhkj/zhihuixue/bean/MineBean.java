package com.rhkj.zhihuixue.bean;

public class MineBean {
    int images;
    String titles;

    public MineBean(int images, String titles) {
        this.images = images;
        this.titles = titles;
    }

    public int getImages() {
        return images;
    }

    public void setImages(int images) {
        this.images = images;
    }

    public String getTitles() {
        return titles;
    }

    public void setTitles(String titles) {
        this.titles = titles;
    }
}
