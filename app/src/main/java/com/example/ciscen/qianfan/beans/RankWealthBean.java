package com.example.ciscen.qianfan.beans;

/**
 * Created by Yan on 16-7-18.
 * 内容:排行_富豪榜类
 */
public class RankWealthBean {
    private int id;
    private String mobile;
    private int sex;
    private int birthdate;
    private int lvCount;
    private int level;
    private int typeAnchor;
    private int focusCount;
    private int createtime;
    private int updatetime;
    private int unId;
    private String uid;
    private String nickname;
    private String avatar;
    private String province;
    private String city;
    private String email;
    private String realNickname;
    private String realAvatar;

    public RankWealthBean() {
    }

    public RankWealthBean(int id, String mobile, int sex, int birthdate, int lvCount, int level, int typeAnchor, int focusCount, int createtime, int updatetime, int unId, String uid, String nickname, String avatar, String province, String city, String email, String realNickname, String realAvatar) {
        this.id = id;
        this.mobile = mobile;
        this.sex = sex;
        this.birthdate = birthdate;
        this.lvCount = lvCount;
        this.level = level;
        this.typeAnchor = typeAnchor;
        this.focusCount = focusCount;
        this.createtime = createtime;
        this.updatetime = updatetime;
        this.unId = unId;
        this.uid = uid;
        this.nickname = nickname;
        this.avatar = avatar;
        this.province = province;
        this.city = city;
        this.email = email;
        this.realNickname = realNickname;
        this.realAvatar = realAvatar;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getImobiled() {
        return mobile;
    }

    public void setImobiled(String imobiled) {
        this.mobile = imobiled;
    }

    public int getSex() {
        return sex;
    }

    public void setSex(int sex) {
        this.sex = sex;
    }

    public int getBirthdate() {
        return birthdate;
    }

    public void setBirthdate(int birthdate) {
        this.birthdate = birthdate;
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

    public int getTypeAnchor() {
        return typeAnchor;
    }

    public void setTypeAnchor(int typeAnchor) {
        this.typeAnchor = typeAnchor;
    }

    public int getFocusCount() {
        return focusCount;
    }

    public void setFocusCount(int focusCount) {
        this.focusCount = focusCount;
    }

    public int getCreatetime() {
        return createtime;
    }

    public void setCreatetime(int createtime) {
        this.createtime = createtime;
    }

    public int getUpdatetime() {
        return updatetime;
    }

    public void setUpdatetime(int updatetime) {
        this.updatetime = updatetime;
    }

    public int getUnId() {
        return unId;
    }

    public void setUnId(int unId) {
        this.unId = unId;
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

    public String getProvince() {
        return province;
    }

    public void setProvince(String province) {
        this.province = province;
    }

    public String getCity() {
        return city;
    }

    public void setCity(String city) {
        this.city = city;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getRealNickname() {
        return realNickname;
    }

    public void setRealNickname(String realNickname) {
        this.realNickname = realNickname;
    }

    public String getRealAvatar() {
        return realAvatar;
    }

    public void setRealAvatar(String realAvatar) {
        this.realAvatar = realAvatar;
    }
}
