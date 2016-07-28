package com.example.ciscen.qianfan.fragment;


import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ListView;

import com.example.ciscen.qianfan.R;
import com.example.ciscen.qianfan.adapter.ListAdapter_Wealth;
import com.example.ciscen.qianfan.beans.RankWealthBean;
import com.example.ciscen.qianfan.utils.JsonUtil;

import org.xutils.common.Callback;
import org.xutils.http.RequestParams;
import org.xutils.x;

import java.util.ArrayList;
import java.util.List;

public class GrandSubFragment_rank_wealth extends Fragment {

    private ListView listView;
    private List<RankWealthBean> list;
    private String path;
    private ListAdapter_Wealth adapter;
    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_grand_sub_fragment_rank_wealth, container, false);
        initView(view);
        return view;
    }

    private void initView(View view) {
        path = getArguments().getString("path");
        listView = (ListView) view.findViewById(R.id.listView_rank);
        list = new ArrayList<>();
        adapter = new ListAdapter_Wealth(list, getActivity());
        getData();
    }

    private void getData() {
        RequestParams params = new RequestParams(path);
        x.http().get(params, new Callback.CommonCallback<String>() {
            @Override
            public void onSuccess(String result) {
                list.clear();
                JsonUtil.getRankWealth(result, list);
                listView.setAdapter(adapter);
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
