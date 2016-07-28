package com.example.ciscen.qianfan.adapter;

import android.content.Context;
import android.content.res.AssetManager;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.ImageView;
import android.widget.TextView;

import com.example.ciscen.qianfan.R;
import com.example.ciscen.qianfan.beans.RankSAndPBean;
import com.example.ciscen.qianfan.view.PolygonImageView;

import org.xutils.image.ImageOptions;
import org.xutils.x;

import java.io.IOException;
import java.io.InputStream;
import java.util.List;

/**
 * Created by Chong on 2016/7/19
 * 明星榜跟人气榜的ListView适配器
 */
public class ListAdapter_SAP extends BaseAdapter {
    private List<RankSAndPBean> list;
    private Context context;

    public ListAdapter_SAP(List<RankSAndPBean> list, Context context) {
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
        ViewHolder holder = view == null ? null : (ViewHolder) view.getTag();
        if (view == null) {
            holder = new ViewHolder();
            view = View.inflate(context, R.layout.item_listview_rank, null);
            holder.rank_iv = (ImageView) view.findViewById(R.id.rank_iv);
            holder.level_iv = (ImageView) view.findViewById(R.id.level_iv);
            holder.isLiving_iv = (ImageView) view.findViewById(R.id.isLiving_iv);
            holder.head_iv = (PolygonImageView) view.findViewById(R.id.header_iv);
            holder.rank_tv = (TextView) view.findViewById(R.id.rank_tv);
            holder.name_tv = (TextView) view.findViewById(R.id.name_tv);
            view.setTag(holder);
        }
        RankSAndPBean bean = list.get(i);
        holder.rank_iv.setVisibility(View.VISIBLE);
        holder.rank_tv.setVisibility(View.INVISIBLE);


        switch (i) {
            case 0:
                holder.rank_iv.setImageResource(R.mipmap.ic_contribution_1);
                break;
            case 1:
                holder.rank_iv.setImageResource(R.mipmap.ic_contribution_2);
                break;
            case 2:
                holder.rank_iv.setImageResource(R.mipmap.ic_contribution_3);
                break;
            default:
                holder.rank_iv.setVisibility(View.INVISIBLE);
                holder.rank_tv.setVisibility(View.VISIBLE);
                holder.rank_tv.setText(i + 1 + "");
                break;
        }
        /*
        设置头像
         */
        ImageOptions.Builder builder = new ImageOptions.Builder();
        builder.setFailureDrawableId(R.mipmap.ic_error_default_header)
                .setLoadingDrawableId(R.mipmap.ic_error_default_header);
        ImageOptions options = builder.build();
        x.image().bind(holder.head_iv, bean.getAvatar(), options);
        holder.name_tv.setText(bean.getNickname());
        switch (bean.getIsInLive()) {
            case 0:
                holder.isLiving_iv.setVisibility(View.INVISIBLE);
                break;
            case 1:
                holder.isLiving_iv.setVisibility(View.VISIBLE);
                break;
        }


        AssetManager manager = context.getAssets();
        try {
            InputStream is = manager.open("ic_host_level_" + bean.getLevel() + ".png");
            Bitmap bitmap = BitmapFactory.decodeStream(is);
            holder.level_iv.setImageBitmap(bitmap);
        } catch (IOException e) {
            e.printStackTrace();
        }
        return view;
    }

    class ViewHolder {
        TextView rank_tv, name_tv;
        ImageView rank_iv, level_iv, isLiving_iv;
        PolygonImageView head_iv;
        public ViewHolder() {
        }
    }
}
