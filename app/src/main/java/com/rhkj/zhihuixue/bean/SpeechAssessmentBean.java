package com.rhkj.zhihuixue.bean;

/**
 * Created by zjx on 2019/5/10.
 */

public class SpeechAssessmentBean {
    private String type;
    private String text;

    public SpeechAssessmentBean(String type, String text) {
        this.type = type;
        this.text = text;
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

    public String getText() {
        return text;
    }

    public void setText(String text) {
        this.text = text;
    }
}
