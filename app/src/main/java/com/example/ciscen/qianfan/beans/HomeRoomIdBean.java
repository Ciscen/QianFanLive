package com.example.ciscen.qianfan.beans;


public class HomeRoomIdBean {
    private String audioUrl;
    private String sp;
    private String hd;
    private String rUrl;
    private String push;
    private String live;

    public HomeRoomIdBean() {
    }

    public HomeRoomIdBean(String audioUrl, String sp, String hd, String rUrl, String push, String live) {
        this.audioUrl = audioUrl;
        this.sp = sp;
        this.hd = hd;
        this.rUrl = rUrl;
        this.push = push;
        this.live = live;
    }

    public void setAudioUrl(String audioUrl) {
        this.audioUrl = audioUrl;
    }

    public void setSp(String sp) {
        this.sp = sp;
    }

    public void setHd(String hd) {
        this.hd = hd;
    }

    public void setrUrl(String rUrl) {
        this.rUrl = rUrl;
    }

    public void setPush(String push) {
        this.push = push;
    }

    public void setLive(String live) {
        this.live = live;
    }

    public String getAudioUrl() {
        return audioUrl;
    }

    public String getSp() {
        return sp;
    }

    public String getHd() {
        return hd;
    }

    public String getrUrl() {
        return rUrl;
    }

    public String getPush() {
        return push;
    }

    public String getLive() {
        return live;
    }
}
