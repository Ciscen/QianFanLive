package com.example.ciscen.qianfan.beans;

/**
 * Created by SunBang on 2016/7/18.
 */

public class DiscoverTitleBean {
//    "name": "活动",
//            "picUrl": "http://003.img.qf.56.itc.cn/group1/M01/D1/90/MTAuMTAuODguNzk=/dXBsb2FkRmlsZV8xXzE0NjM2MzcwMzEzNjM=.png",
//            "linkUrl": "http://qf.56.com/activity/week_star_h5/index.html"
    private String name;
    private String picUrl;
    private String linkUrl;

    public DiscoverTitleBean(String name, String picUrl, String linkUrl) {
        this.name = name;
        this.picUrl = picUrl;
        this.linkUrl = linkUrl;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void setPicUrl(String picUrl) {
        this.picUrl = picUrl;
    }

    public void setLinkUrl(String linkUrl) {
        this.linkUrl = linkUrl;
    }

    public String getName() {
        return name;
    }

    public String getPicUrl() {
        return picUrl;
    }

    public String getLinkUrl() {
        return linkUrl;
    }
}
