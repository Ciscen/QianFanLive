package com.example.ciscen.qianfan.beans;

/**
 * Created by Yan on 16-7-18.
 *  内容:排行_明星榜/人气榜类
 */
public class RankSAndPBean {
    private int isInLive;
    private int watcherOnLine;
    private int showTime;
    private int isWeeklyStar;
    private int roomPushType;
    private int id;
    private int lvCount;
    private int level;
    private int sunshine;
    private int fanCount;
    private int createTime;
    private int updateTime;
    private int roomId;
    private String uid;
    private String nickname;
    private String avatar;
    private String bigHeadUrl;
    private String smallHeadUrl;

    public RankSAndPBean(int isInLive, int watcherOnLine, int showTime, int isWeeklyStar, int roomPushType, int id, int lvCount, int level, int sunshine, int fanCount, int createTime, int updateTime, int roomId, String uid, String nickname, String avatar, String bigHeadUrl, String smallHeadUrl) {
        this.isInLive = isInLive;
        this.watcherOnLine = watcherOnLine;
        this.showTime = showTime;
        this.isWeeklyStar = isWeeklyStar;
        this.roomPushType = roomPushType;
        this.id = id;
        this.lvCount = lvCount;
        this.level = level;
        this.sunshine = sunshine;
        this.fanCount = fanCount;
        this.createTime = createTime;
        this.updateTime = updateTime;
        this.roomId = roomId;
        this.uid = uid;
        this.nickname = nickname;
        this.avatar = avatar;
        this.bigHeadUrl = bigHeadUrl;
        this.smallHeadUrl = smallHeadUrl;
    }

    public RankSAndPBean() {
    }

    public int getIsInLive() {
        return isInLive;
    }

    public void setIsInLive(int isInLive) {
        this.isInLive = isInLive;
    }

    public int getWatcherOnLine() {
        return watcherOnLine;
    }

    public void setWatcherOnLine(int watcherOnLine) {
        this.watcherOnLine = watcherOnLine;
    }

    public int getShowTime() {
        return showTime;
    }

    public void setShowTime(int showTime) {
        this.showTime = showTime;
    }

    public int getIsWeeklyStar() {
        return isWeeklyStar;
    }

    public void setIsWeeklyStar(int isWeeklyStar) {
        this.isWeeklyStar = isWeeklyStar;
    }

    public int getRoomPushType() {
        return roomPushType;
    }

    public void setRoomPushType(int roomPushType) {
        this.roomPushType = roomPushType;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public int getLvCount() {
        return lvCount;
    }

    public void setLvCount(int lvCount) {
        this.lvCount = lvCount;
    }

    public int getLevel() {
        return level;
    }

    public void setLevel(int level) {
        this.level = level;
    }

    public int getSunshine() {
        return sunshine;
    }

    public void setSunshine(int sunshine) {
        this.sunshine = sunshine;
    }

    public int getFanCount() {
        return fanCount;
    }

    public void setFanCount(int fanCount) {
        this.fanCount = fanCount;
    }

    public int getCreateTime() {
        return createTime;
    }

    public void setCreateTime(int createTime) {
        this.createTime = createTime;
    }

    public int getUpdateTime() {
        return updateTime;
    }

    public void setUpdateTime(int updateTime) {
        this.updateTime = updateTime;
    }

    public int getRoomId() {
        return roomId;
    }

    public void setRoomId(int roomId) {
        this.roomId = roomId;
    }

    public String getUid() {
        return uid;
    }

    public void setUid(String uid) {
        this.uid = uid;
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

    public String getBigHeadUrl() {
        return bigHeadUrl;
    }

    public void setBigHeadUrl(String bigHeadUrl) {
        this.bigHeadUrl = bigHeadUrl;
    }

    public String getSmallHeadUrl() {
        return smallHeadUrl;
    }

    public void setSmallHeadUrl(String smallHeadUrl) {
        this.smallHeadUrl = smallHeadUrl;
    }
}
