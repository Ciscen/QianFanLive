package com.example.ciscen.qianfan.adapter;

import android.content.Context;
import android.content.res.AssetManager;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.os.Bundle;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.ImageView;
import android.widget.TextView;

import com.example.ciscen.qianfan.beans.FansRankBean;
import com.example.ciscen.qianfan.R;
import org.xutils.image.ImageOptions;
import org.xutils.x;

import java.io.IOException;
import java.io.InputStream;
import java.net.URLEncoder;
import java.util.List;

/**
 * Created by Chong on 2016/7/20
 */
public class ListAdapter_Week extends BaseAdapter {
    private List<FansRankBean> list;

    private Context context;

    public ListAdapter_Week(List<FansRankBean> list, Context context) {
        this.list = list;
        this.context = context;

    }

    @Override
    public int getCount() {
        return list.size();
    }

    @Override
    public Object getItem(int i) {

        return list.get(i);
    }

    @Override
    public long getItemId(int i) {
        return i;
    }

    @Override
    public View getView(int i, View view, ViewGroup viewGroup) {
        ViewHolder holder = view==null?null:(ViewHolder) view.getTag();
        if (view == null) {
            holder = new ViewHolder();
            view = View.inflate(context, R.layout.item_listview_rank_week, null);
            holder.title = (TextView) view.findViewById(R.id.title);
            holder.gift_iv = (ImageView) view.findViewById(R.id.gift_iv);
            holder.rank_iv = (ImageView) view.findViewById(R.id.rank_iv);
            holder.giftName_tv = (TextView) view.findViewById(R.id.giftName_tv);
            holder.name_tv = (TextView) view.findViewById(R.id.name_tv);
            holder.num_tv = (TextView) view.findViewById(R.id.num_tv);
            holder.view = view.findViewById(R.id.container_rankStar);//用于点击事件
            view.setTag(holder);
        }
        FansRankBean bean = list.get(i);
        Bundle bundle = new Bundle();
        bundle.putString("roomId",bean.getRoomid());
        bundle.putString("push", String.valueOf(bean.getRoomPushType()));
        holder.view.setTag(bundle);
        holder.name_tv.setText(bean.getNickname());
        holder.title.setVisibility(View.GONE);
        AssetManager manager = context.getAssets();//资产文件管理
        String path ;//资产文件路径
        if (i < 11) {//主播排行榜
            if (i==0) {//标题可见
                holder.title.setVisibility(View.VISIBLE);
                holder.title.setText("主播排行榜");
            }
            //主播的等级图片地址
            path = "level_"+bean.getLevel()+".png";
            holder.num_tv.setText(String.format("本周获得x%d个",bean.getGiftNum()));
        } else {//富豪排行榜
            if (i == 11) {//富豪榜的标题可见
                holder.title.setVisibility(View.VISIBLE);
                holder.title.setText("富豪排行榜");
            }
            //富豪的等级图片地址
            path = "ic_host_level_"+bean.getLevel()+".png";
            holder.num_tv.setText(String.format("本周贡献x%d个",bean.getGiftNum()));
        }
        try {
            InputStream is = manager.open(path);
            Bitmap bitmap = BitmapFactory.decodeStream(is);
            //设置等级图片
            holder.rank_iv.setImageBitmap(bitmap);
        } catch (IOException e) {
            e.printStackTrace();
        }
        //设置礼物名称
        holder.giftName_tv.setText(bean.getGiftName());
        //设置礼物图片
        x.image().bind(holder.gift_iv,bean.getGiftPcImg());
        return view;
    }
    class ViewHolder{
        TextView title,giftName_tv,num_tv,name_tv;
        ImageView rank_iv,gift_iv;
        View view;
        public ViewHolder() {
        }
    }
}