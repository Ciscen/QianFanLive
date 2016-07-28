package com.example.ciscen.qianfan.utils;


import com.example.ciscen.qianfan.beans.FansRankBean;
import com.example.ciscen.qianfan.beans.RankSAndPBean;
import com.example.ciscen.qianfan.beans.RankWealthBean;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import java.util.List;

/**
 * Created by YanZiAng on 16-7-18.
 */
public class ParseUtil {
    //明星榜/人气榜解析
    public List<RankSAndPBean> getRankStar(String path, List<RankSAndPBean>list){

        try {
            JSONObject message = new JSONObject(path);
            JSONObject rankStar = message.getJSONObject("message");
            JSONArray rank = rankStar.getJSONArray("rankStar");
            for (int i = 0; i <rank.length() ; i++) {
                JSONObject jo = rank.getJSONObject(i);
                 int isInLive = jo.getInt("isInLive");
                 int watcherOnLine = jo.getInt("watcherOnLine");
                 int showTime = jo.getInt("showTime");
                 int isWeeklyStar = jo.getInt("isWeeklyStar");
                 int roomPushType = jo.getInt("roomPushType");
                 int id = jo.getInt("id");
                 int lvCount = jo.getInt("lvCount");
                 int level = jo.getInt("level");
                 int sunshine = jo.getInt("sunshine");
                 int fanCount = jo.getInt("fanCount");
                 int createTime = jo.getInt("createTime");
                 int updateTime = jo.getInt("updateTime");
                 int roomId = jo.getInt("roomId");
                 String uid = jo.getString("uid");
                 String nickname = jo.getString("nickname");
                 String avatar = jo.getString("avatar");
                 String bigHeadUrl = jo.getString("bigHeadUrl");
                 String smallHeadUrl = jo.getString("smallHeadUrl");

                RankSAndPBean rankStarBean = new RankSAndPBean(isInLive,watcherOnLine,showTime,isWeeklyStar,roomPushType,id,lvCount,level,sunshine,fanCount,createTime,updateTime,roomId,uid,nickname,avatar,bigHeadUrl,smallHeadUrl);
                list.add(rankStarBean);
            }
                return list;
        } catch (JSONException e) {
            e.printStackTrace();
        }
        return null;
    }

    //富豪榜解析
    public List<RankWealthBean> getRankWealth(String path, List<RankWealthBean>list){

        try {
            JSONObject message = new JSONObject(path);
            JSONObject rankWealth = message.getJSONObject("message");
            JSONArray rank = rankWealth.getJSONArray("rankWealth");
            for (int i = 0; i <rank.length() ; i++) {
                JSONObject jo = rank.getJSONObject(i);
                int id = jo.getInt("id");
                int imobiled = jo.getInt("imobiled");
                int sex = jo.getInt("sex");
                int birthdate = jo.getInt("birthdate");
                int lvCount = jo.getInt("lvCount");
                int level = jo.getInt("level");
                int typeAnchor = jo.getInt("typeAnchor");
                int focusCount = jo.getInt("focusCount");
                int createtime = jo.getInt("createtime");
                int updatetime = jo.getInt("updatetime");
                int unId = jo.getInt("unId");
                String uid = jo.getString("uid");
                String nickname = jo.getString("nickname");
                String avatar = jo.getString("avatar");
                String province = jo.getString("province");
                String city = jo.getString("city");
                String email = jo.getString("email");
                String realNickname = jo.getString("realNickname");
                String realAvatar = jo.getString("realAvatar");

                RankWealthBean rankWerlthBean = new RankWealthBean();
                list.add(rankWerlthBean);
            }
            return list;
        } catch (JSONException e) {
            e.printStackTrace();
        }
        return null;
    }

    //周星榜
    public List<FansRankBean> getFansRank(String path, List<FansRankBean>list ){
        try {
            JSONObject message = new JSONObject(path);
            JSONObject rankFans = message.getJSONObject("message");
            JSONArray fans = rankFans.getJSONArray("fansRank");
            for (int i = 0; i <fans.length() ; i++) {
                JSONObject jo = fans.getJSONObject(i);
                int coin = jo.getInt("coin");
                int rank = jo.getInt("rank");
                int giftNum = jo.getInt("giftNum");
                int giftId = jo.getInt("giftId");
                int giftType = jo.getInt("giftType");
                int level = jo.getInt("level");
                int statusInLive = jo.getInt("statusInLive");
                int roomPushType = jo.getInt("roomPushType");
                int roomid = jo.getInt("roomid");
                String uid = jo.getString("uid");
                String giftName = jo.getString("giftName");
                String giftPcImg = jo.getString("giftPcImg");
                String giftAppImg = jo.getString("giftAppImg");
                String nickname = jo.getString("nickname");
                String avatar = jo.getString("avatar");

                FansRankBean FansRankBean = new FansRankBean();
                list.add(FansRankBean);
            }
            return list;
        } catch (JSONException e) {
            e.printStackTrace();
        }
        return null;
    }
}
