package com.example.ciscen.qianfan.utils;


import com.example.ciscen.qianfan.beans.AnchorInfo_Room;
import com.example.ciscen.qianfan.beans.DiscoverSwapBean;
import com.example.ciscen.qianfan.beans.DiscoverTitleBean;
import com.example.ciscen.qianfan.beans.FansRankBean;
import com.example.ciscen.qianfan.beans.HomeRoomIdBean;
import com.example.ciscen.qianfan.beans.HomeUrlBean;
import com.example.ciscen.qianfan.beans.RankSAndPBean;
import com.example.ciscen.qianfan.beans.RankWealthBean;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import java.util.List;



public class JsonUtil {

    //直播最外层
    public static List<HomeUrlBean> homeUrlParse(String json, List<HomeUrlBean> list) {
        try {
            JSONObject jsonObject = new JSONObject(json);
            JSONObject object = jsonObject.getJSONObject("message");
            JSONArray jsonArray = object.getJSONArray("anchors");
            for (int i = 0; i < jsonArray.length(); i++) {
                JSONObject data = jsonArray.getJSONObject(i);
                String uid = data.getString("uid");
                String roomid = data.getString("roomid");
                String name = data.getString("name");
                String pic51 = data.getString("pic51");
                String pic74 = data.getString("pic74");
                String live = data.getString("live");
                String push = data.getString("push");
                String focus = data.getString("focus");
                String weeklyStar = data.getString("weeklyStar");
                HomeUrlBean homeUrlBean = new HomeUrlBean(uid,roomid,name,pic51,pic74,live,push,focus,weeklyStar);
                list.add(homeUrlBean);
            }
        } catch (JSONException e) {
            e.printStackTrace();
        }
        return list;
    }

    //直播房间
    public static List<HomeRoomIdBean> homeRoomParse(String json, List<HomeRoomIdBean> list) {
        try {
            JSONObject jsonObject = new JSONObject(json);
            JSONObject object = jsonObject.getJSONObject("message");
            String audioUrl = object.getString("audioUrl");
            String sp = object.getString("sp");
            String hd = object.getString("hd");
            String rUrl = object.getString("rUrl");
            String push = object.getString("push");
            String live = object.getString("live");

            HomeRoomIdBean homeRoomIdBean = new HomeRoomIdBean(audioUrl,sp,hd,rUrl,push,live);
            list.add(homeRoomIdBean);
        } catch (JSONException e) {
            e.printStackTrace();
        }
        return list;
    }

    //顶部banner轮播
    public static List<DiscoverTitleBean> bannerParse(String json, List<DiscoverTitleBean> list) {
        try {
            JSONObject jsonObject = new JSONObject(json);
            JSONObject object = jsonObject.getJSONObject("message");
            JSONArray jsonArray = object.getJSONArray("banners");
            for (int i = 0;i<jsonArray.length();i++){
                JSONObject data = jsonArray.getJSONObject(i);
                String name = data.getString("name");
                String picUrl = data.getString("picUrl");
                String linkUrl = data.getString("linkUrl");
                DiscoverTitleBean discoverTitleBean = new DiscoverTitleBean(name,picUrl,linkUrl);
                list.add(discoverTitleBean);
            }
        } catch (JSONException e) {
            e.printStackTrace();
        }
        return list;
    }

    public  static List<DiscoverSwapBean> disSwaParse(String json, List<DiscoverSwapBean> list){
        try {
            JSONObject jsonObject = new JSONObject(json);
            JSONObject object = jsonObject.getJSONObject("message");
            JSONArray jsonArray = object.getJSONArray("anchors");
            for (int i = 0;i<jsonArray.length();i++) {
                JSONObject data = jsonArray.getJSONObject(i);
                String roomid = data.getString("roomid");
                String uid = data.getString("uid");
                String pic51 = data.getString("pic51");
                String push = data.getString("push");
                String name = data.getString("name");
                String live = data.getString("live");
                DiscoverSwapBean discoverSwapBean = new DiscoverSwapBean(roomid,uid,pic51,push,name,live);
                list.add(discoverSwapBean);
            }
        } catch (JSONException e) {
            e.printStackTrace();
        }
        return list;
    }
    //明星榜/人气榜解析
    public static List<RankSAndPBean> getRankStar(String json, List<RankSAndPBean>list,int type){

        try {
            JSONObject message = new JSONObject(json);
            JSONObject rankStar = message.getJSONObject("message");
            JSONArray rank = null;
            if (type == 0) {
                rank = rankStar.getJSONArray("rankStar");
            } else {
                rank = rankStar.getJSONArray("rankPopularity");
            }
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
    public static List<RankWealthBean> getRankWealth(String path, List<RankWealthBean>list){

        try {
            JSONObject message = new JSONObject(path);
            JSONObject rankWealth = message.getJSONObject("message");
            JSONArray rank = rankWealth.getJSONArray("rankWealth");
            for (int i = 0; i <rank.length() ; i++) {
                JSONObject jo = rank.getJSONObject(i);
                int id = jo.getInt("id");
                String mobile = jo.getString("mobile");
                int sex = jo.getInt("sex");
                int lvCount = jo.getInt("lvCount");
                int level = jo.getInt("level");
                int focusCount = jo.getInt("focusCount");
                int updatetime = jo.getInt("updatetime");
                String uid = jo.getString("uid");
                String nickname = jo.getString("nickname");
                String avatar = jo.getString("avatar");
                String realNickname = jo.getString("realNickname");
                String realAvatar = jo.getString("realAvatar");

                RankWealthBean rankWerlthBean = new RankWealthBean(id,mobile,sex,0,lvCount,level,0,
                        focusCount,0,updatetime,0,uid,nickname,avatar,"","","",realNickname,realAvatar);
                list.add(rankWerlthBean);
            }
            return list;
        } catch (JSONException e) {
            e.printStackTrace();
        }
        return null;
    }

    //周星榜
    public static List<FansRankBean> getFansRank(String path, List<FansRankBean>list ){
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
                String roomid = jo.getString("roomid");
                String uid = jo.getString("uid");
                String giftName = jo.getString("giftName");
                String giftPcImg = jo.getString("giftPcImg");
                String giftAppImg = jo.getString("giftAppImg");
                String nickname = jo.getString("nickname");
                String avatar = jo.getString("avatar");

                FansRankBean fansRankBean = new FansRankBean(coin,rank,giftId,giftNum,giftType,
                        level,statusInLive,roomPushType,roomid,uid,giftName,giftPcImg,
                        giftAppImg,nickname,avatar);
                list.add(fansRankBean);
            }
            JSONArray anchorRank = rankFans.getJSONArray("anchorRank");
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
                String roomid = jo.getString("roomid");
                String uid = jo.getString("uid");
                String giftName = jo.getString("giftName");
                String giftPcImg = jo.getString("giftPcImg");
                String giftAppImg = jo.getString("giftAppImg");
                String nickname = jo.getString("nickname");
                String avatar = jo.getString("avatar");

                FansRankBean fansRankBean = new FansRankBean(coin,rank,giftId,giftNum,giftType,
                        level,statusInLive,roomPushType,roomid,uid,giftName,giftPcImg,
                        giftAppImg,nickname,avatar);
                list.add(fansRankBean);
            }
            return list;
        } catch (JSONException e) {
            e.printStackTrace();
        }
        return null;
    }
    public static void parseAnchorInfo_Room(String json,AnchorInfo_Room info) {
        try {
            JSONObject obj = new JSONObject(json);
            JSONObject message = obj.getJSONObject("message");
            JSONObject anchor =  message.getJSONObject("anchor");
            String roomId = anchor.getString("roomId");
            String aname = anchor.getString("aname");
            String avatar = anchor.getString("avatar");
            info.setAname(aname);
            info.setAvatar(avatar);
            info.setMedalId(roomId);

        } catch (JSONException e) {
            e.printStackTrace();
        }
    }
}
