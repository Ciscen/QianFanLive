package com.example.ciscen.qianfan.beans;

/**
 * Created by SunBang on 2016/7/18
 *
 *
 * 猜你喜欢的实体类
 */

public class DiscoverSwapBean {
    private String roomid;
    private String uid;
    private String pic51;
    private String push;
    private String name;
    private String live;

    public DiscoverSwapBean(String roomid, String uid, String pic51, String push, String name, String live) {
        this.roomid = roomid;
        this.uid = uid;
        this.pic51 = pic51;
        this.push = push;
        this.name = name;
        this.live = live;
    }

    public void setRoomid(String roomid) {
        this.roomid = roomid;
    }

    public void setUid(String uid) {
        this.uid = uid;
    }

    public void setPic51(String pic51) {
        this.pic51 = pic51;
    }

    public void setPush(String push) {
        this.push = push;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void setLive(String live) {
        this.live = live;
    }

    public String getRoomid() {
        return roomid;
    }

    public String getUid() {
        return uid;
    }

    public String getPic51() {
        return pic51;
    }

    public String getPush() {
        return push;
    }

    public String getName() {
        return name;
    }

    public String getLive() {
        return live;
    }
}
