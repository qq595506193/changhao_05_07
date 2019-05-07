package com.changhao_exam_2019_04_30.entity;

import java.util.List;

public class HomeBean {


    public int code;
    public String remark;
    public ResultBean result;
    public Object pageInfo;



    public static class ResultBean {


        public String info;
        public List<List<VideoBean>> video;



        public static class VideoBean {


            public String coverImgUrl;
            public long createTime;
            public int delStatus;
            public int weight;
            public int videoId;
            public int showStatus;
            public long updateTime;
            public String title;
            public int categoryWeight;
            public String categoryName;
            public int categoryId;

            
        }
    }
}
