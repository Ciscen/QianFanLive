package com.example.ciscen.qianfan.beans;

/**
 * Created by Yan on 16-7-18.
 * 内容:周星榜类
 */
public class FansRankBean {
    private int coin;
    private int rank;
    private int giftId;
    private int giftNum;
    private int giftType;
    private int level;
    private int statusInLive;
    private int roomPushType;
    private String roomid;
    private String uid;
    private String giftName;
    private String giftPcImg;
    private String giftAppImg;
    private String nickname;
    private String avatar;

    public FansRankBean() {
    }

    public FansRankBean(int coin, int rank, int giftId, int giftNum, int giftType, int level, int statusInLive, int roomPushType, String roomid, String uid, String giftName, String giftPcImg, String giftAppImg, String nickname, String avatar) {
        this.coin = coin;
        this.rank = rank;
        this.giftId = giftId;
        this.giftNum = giftNum;
        this.giftType = giftType;
        this.level = level;
        this.statusInLive = statusInLive;
        this.roomPushType = roomPushType;
        this.roomid = roomid;
        this.uid = uid;
        this.giftName = giftName;
        this.giftPcImg = giftPcImg;
        this.giftAppImg = giftAppImg;
        this.nickname = nickname;
        this.avatar = avatar;
    }

    public int getCoin() {
        return coin;
    }

    public void setCoin(int coin) {
        this.coin = coin;
    }

    public int getRank() {
        return rank;
    }

    public void setRank(int rank) {
        this.rank = rank;
    }

    public int getGiftId() {
        return giftId;
    }

    public void setGiftId(int giftId) {
        this.giftId = giftId;
    }

    public int getGiftNum() {
        return giftNum;
    }

    public void setGiftNum(int giftNum) {
        this.giftNum = giftNum;
    }

    public int getGiftType() {
        return giftType;
    }

    public void setGiftType(int giftType) {
        this.giftType = giftType;
    }

    public int getLevel() {
        return level;
    }

    public void setLevel(int level) {
        this.level = level;
    }

    public int getStatusInLive() {
        return statusInLive;
    }

    public void setStatusInLive(int statusInLive) {
        this.statusInLive = statusInLive;
    }

    public int getRoomPushType() {
        return roomPushType;
    }

    public void setRoomPushType(int roomPushType) {
        this.roomPushType = roomPushType;
    }

    public String getRoomid() {
        return roomid;
    }

    public void setRoomid(String roomid) {
        this.roomid = roomid;
    }

    public String getUid() {
        return uid;
    }

    public void setUid(String uid) {
        this.uid = uid;
    }

    public String getGiftName() {
        return giftName;
    }

    public void setGiftName(String giftName) {
        this.giftName = giftName;
    }

    public String getGiftPcImg() {
        return giftPcImg;
    }

    public void setGiftPcImg(String giftPcImg) {
        this.giftPcImg = giftPcImg;
    }

    public String getGiftAppImg() {
        return giftAppImg;
    }

    public void setGiftAppImg(String giftAppImg) {
        this.giftAppImg = giftAppImg;
    }

    public String getNickname() {
        return nickname;
    }

    public void setNickname(String nickname) {
        this.nickname = nickname;
    }

    public String getAvatar() {
        return avatar;
    }

    public void setAvatar(String avatar) {
        this.avatar = avatar;
    }
}

