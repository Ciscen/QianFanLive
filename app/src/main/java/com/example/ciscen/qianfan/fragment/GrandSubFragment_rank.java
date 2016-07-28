package com.example.ciscen.qianfan.fragment;

import android.content.Context;
import android.content.Intent;
import android.graphics.Color;
import android.net.Uri;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v4.widget.SwipeRefreshLayout;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.ListView;
import android.widget.TextView;

import com.example.ciscen.qianfan.R;
import com.example.ciscen.qianfan.activity.RoomActivity;
import com.example.ciscen.qianfan.adapter.ListAdapter_SAP;
import com.example.ciscen.qianfan.beans.RankSAndPBean;
import com.example.ciscen.qianfan.utils.JsonUtil;

import org.xutils.common.Callback;
import org.xutils.http.RequestParams;
import org.xutils.x;

import java.util.ArrayList;
import java.util.List;

/**
 * 明星榜跟人气榜的展示布局
 */
public class GrandSubFragment_rank extends Fragment {

    private ListView listView;
    private List<RankSAndPBean> list;
    private String path;
    private ListAdapter_SAP adapter;
    private SwipeRefreshLayout swipeRefreshLayout;
    private int index;//标记当前是明星榜，还是人气榜
    @Override

    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_grand_sub_fragment_rank, container, false);
        initView(view);
        return view;
    }

    private void initView(View view) {
        path = getArguments().getString("path");
        index = getArguments().getInt("index");
        listView = (ListView) view.findViewById(R.id.listView_rank);
        list = new ArrayList<>();
        adapter = new ListAdapter_SAP(list, getActivity());
        getData();
        listView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> adapterView, View view, int i, long l) {
                Intent intent = new Intent(getActivity(), RoomActivity.class);
                intent.putExtra("roomId", list.get(i).getRoomId()+"");
                intent.putExtra("push", list.get(i).getRoomPushType()+"");
                startActivity(intent);
            }
        });
    }

    private void getData() {
        RequestParams params = new RequestParams(path);
        x.http().get(params, new Callback.CommonCallback<String>() {
            @Override
            public void onSuccess(String result) {
                list.clear();
                adapter.notifyDataSetChanged();
                JsonUtil.getRankStar(result, list,index);
                listView.setAdapter(adapter);
                swipeRefreshLayout.setRefreshing(false);
            }

            @Override
            public void onError(Throwable ex, boolean isOnCallback) {

            }

            @Override
            public void onCancelled(CancelledException cex) {

            }

            @Override
            public void onFinished() {

            }
        });
    }


}
