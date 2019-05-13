package com.rhkj.zhihuixue.bean;

import java.util.List;

/**
 * Created by zjx on 2019/5/13.
 */

public class SpeechAssessmentGosnBean {


    /**
     * state : 200
     * msg : 获取成功
     * data : [{"id":3,"name":"material","meaning":"材","level_id":6,"sorc":"10","explain":"材料，原料;   素材;   布，织物","video_url":"http://pq76gdclh.bkt.clouddn.com/f394d201905111536573008.mp4,http://pq76gdclh.bkt.clouddn.com/7becc201905111536594367.mp4","audio_url":null,"addtime":"1557561809"}]
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
         * name : material
         * meaning : 材
         * level_id : 6
         * sorc : 10
         * explain : 材料，原料;   素材;   布，织物
         * video_url : http://pq76gdclh.bkt.clouddn.com/f394d201905111536573008.mp4,http://pq76gdclh.bkt.clouddn.com/7becc201905111536594367.mp4
         * audio_url : null
         * addtime : 1557561809
         */

        private int id;
        private String name;
        private String meaning;
        private int level_id;
        private String sorc;
        private String explain;
        private String video_url;
        private String audio_url;
        private String addtime;

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

        public String getMeaning() {
            return meaning;
        }

        public void setMeaning(String meaning) {
            this.meaning = meaning;
        }

        public int getLevel_id() {
            return level_id;
        }

        public void setLevel_id(int level_id) {
            this.level_id = level_id;
        }

        public String getSorc() {
            return sorc;
        }

        public void setSorc(String sorc) {
            this.sorc = sorc;
        }

        public String getExplain() {
            return explain;
        }

        public void setExplain(String explain) {
            this.explain = explain;
        }

        public String getVideo_url() {
            return video_url;
        }

        public void setVideo_url(String video_url) {
            this.video_url = video_url;
        }

        public String getAudio_url() {
            return audio_url;
        }

        public void setAudio_url(String audio_url) {
            this.audio_url = audio_url;
        }

        public String getAddtime() {
            return addtime;
        }

        public void setAddtime(String addtime) {
            this.addtime = addtime;
        }
    }
}
