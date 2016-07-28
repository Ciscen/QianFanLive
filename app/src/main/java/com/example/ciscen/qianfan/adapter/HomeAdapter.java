package com.example.ciscen.qianfan.adapter;

import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import com.example.ciscen.qianfan.R;
import com.example.ciscen.qianfan.activity.RoomActivity;
import com.example.ciscen.qianfan.beans.HomeUrlBean;

import org.xutils.image.ImageOptions;
import org.xutils.x;

import java.util.List;

/**
 * Created by Chong on 2016/7/18
 *
 *用于首页的RecyclerView的适配器
 */
public class HomeAdapter extends RecyclerView.Adapter<HomeAdapter.MyViewHolder> {

    private List<HomeUrlBean> list;
    private Context context;
    private LayoutInflater inflater;
    private OnClickListener listener;
    public interface OnClickListener {
        void onClick(View view,int position);
    }
    public HomeAdapter(List<HomeUrlBean> list, Context context) {
        this.list = list;
        this.context = context;
        inflater = LayoutInflater.from(context);
    }

    @Override
    public MyViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View view = inflater.inflate(R.layout.item_home_recyclerview, parent, false);
        return new MyViewHolder(view, new OnClickListener() {
            @Override
            public void onClick(View view, int position) {
                Intent intent = new Intent(context, RoomActivity.class);
                intent.putExtra("roomId", list.get(position).getRoomid());
                intent.putExtra("push", list.get(position).getPush());
                context.startActivity(intent);
            }
        });
    }

    @Override
    public void onBindViewHolder(MyViewHolder holder, int position) {
        HomeUrlBean bean = list.get(position);
        ImageOptions options = new ImageOptions.Builder()
                .setRadius(20)
                .setLoadingDrawableId(R.mipmap.ic_error_logo)
                .setFailureDrawableId(R.mipmap.ic_error_logo)
                .build();
        if (position % 2 == 1) {//奇数
            holder.pic.getLayoutParams().height = 350;
            x.image().bind(holder.pic,bean.getPic51(),options);
        } else {//偶数
           holder.pic.getLayoutParams().height = 450;
            x.image().bind(holder.pic,bean.getPic74(),options);
        }

        if (bean.getWeeklyStar().equals("1")) {//如果是周星
            holder.mark.setImageResource(R.mipmap.ic_home_corner_mark_weekstar);
        } else {
            if (bean.getLive().equals("1")) {//是否是直播
                holder.mark.setImageResource(R.mipmap.ic_home_corner_mark_live);
            } else {
                holder.mark.setVisibility(View.GONE);
            }
            if(bean.getPush().equals("2")){//是否是手机
                holder.mark.setImageResource(R.mipmap.ic_home_corner_mark_phone);
            }
        }
        holder.name.setText(list.get(position).getName());
        holder.focus.setText(list.get(position).getFocus());

    }

    @Override
    public int getItemCount() {
        return list.size();
    }

    class MyViewHolder extends RecyclerView.ViewHolder {
         TextView name, focus;
         ImageView pic, mark;
        private OnClickListener listener;
        public MyViewHolder(View itemView, final OnClickListener listener) {
            super(itemView);
            name = (TextView) itemView.findViewById(R.id.name_item_tv);
            focus = (TextView) itemView.findViewById(R.id.focus_tv_item);
            pic = (ImageView) itemView.findViewById(R.id.pic_item_iv);
            mark = (ImageView) itemView.findViewById(R.id.mark_item_iv);
            this.listener = listener;
            itemView.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View view) {
                    listener.onClick(view,getAdapterPosition());
                }
            });
        }

    }
}
