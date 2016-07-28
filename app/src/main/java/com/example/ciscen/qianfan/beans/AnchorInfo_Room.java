package com.example.ciscen.qianfan.beans;

/**
 * Created by Chong on 2016/7/24.
 */
public class AnchorInfo_Room {
    private String aname;
    private String avatar;
    private String  roomId;

    public AnchorInfo_Room(String aname, String avatar, String roomId) {
        this.aname = aname;
        this.avatar = avatar;
        this.roomId = roomId;
    }

    public AnchorInfo_Room() {
    }

    public String getAname() {
        return aname;
    }

    public void setAname(String aname) {
        this.aname = aname;
    }

    public String getAvatar() {
        return avatar;
    }

    public void setAvatar(String avatar) {
        this.avatar = avatar;
    }

    public String getMedalId() {
        return roomId;
    }

    public void setMedalId(String roomId) {
        this.roomId = roomId;
    }
}
