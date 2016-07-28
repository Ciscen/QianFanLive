package com.example.ciscen.qianfan.beans;


/**
 * Created by SunBang on 2016/7/18.
 */

public class HomeUrlBean{
//        "uid": "wlunm372_561903025",
//                "roomid": "5282497",
//                "name": "辣条小公主",
//                "pic51": "http://005.img.qf.56.itc.cn/group2/M12/EB/7B/MTAuMTAuODguODI=/dXBsb2FkRmlsZV8xXzE0Njc2MjU4OTkyMzM=/cut@m=crop,x=0,y=68,w=722,h=722_cut@m=resize,w=510,h=510.jpg",
//                "pic74": "http://002.img.qf.56.itc.cn/group2/M12/EB/7B/MTAuMTAuODguODI=/dXBsb2FkRmlsZV8xXzE0Njc2MjU4OTkyMzM=/cut@m=crop,x=59,y=0,w=662,h=960_cut@m=resize,w=510,h=740.jpg",
//                "live": 1,
//                "push": 2,
//                "focus": 2903,
//                "weeklyStar": 0
        private String uid;
        private String roomid;
        private String name;
        private String pic51;
        private String pic74;
        private String live;//0在直播，1不在
        private String push;//1电脑，2手机
        private String focus;//粉丝
        private String weeklyStar;//是否是周星，1是，0否

    public HomeUrlBean() {
    }

    public HomeUrlBean(String uid, String roomid, String name, String pic51, String pic74, String live, String push, String focus, String weeklyStar) {
        this.uid = uid;
        this.roomid = roomid;
        this.name = name;
        this.pic51 = pic51;
        this.pic74 = pic74;
        this.live = live;
        this.push = push;
        this.focus = focus;
        this.weeklyStar = weeklyStar;
    }

    public void setUid(String uid) {
        this.uid = uid;
    }

    public void setRoomid(String roomid) {
        this.roomid = roomid;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void setPic51(String pic51) {
        this.pic51 = pic51;
    }

    public void setPic74(String pic74) {
        this.pic74 = pic74;
    }

    public void setLive(String live) {
        this.live = live;
    }

    public void setPush(String push) {
        this.push = push;
    }

    public void setFocus(String focus) {
        this.focus = focus;
    }

    public void setWeeklyStar(String weeklyStar) {
        this.weeklyStar = weeklyStar;
    }

    public String getUid() {
        return uid;
    }

    public String getRoomid() {
        return roomid;
    }

    public String getName() {
        return name;
    }

    public String getPic51() {
        return pic51;
    }

    public String getPic74() {
        return pic74;
    }

    public String getLive() {
        return live;
    }

    public String getPush() {
        return push;
    }

    public String getFocus() {
        return focus;
    }

    public String getWeeklyStar() {
        return weeklyStar;
    }
}
