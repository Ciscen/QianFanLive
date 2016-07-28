package com.example.ciscen.qianfan.fragment;


import android.os.Bundle;
import android.support.design.widget.TabLayout;
import android.support.v4.app.Fragment;
import android.support.v4.view.ViewPager;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.example.ciscen.qianfan.R;
import com.example.ciscen.qianfan.adapter.Frag_Adapter;

import org.xutils.db.annotation.Table;

import java.util.ArrayList;
import java.util.List;

public class RankFragment extends Fragment {
    private ViewPager viewPager;
    private TabLayout tabLayout;
    private String[] titles = {"明星榜", "富豪榜", "人气榜", "周星榜"};
    private Frag_Adapter adapter;
    private List<Fragment> list;

    @Override

    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_rank, container, false);
        initView(view);


        return view;
    }

    private void initView(View view) {
        viewPager = (ViewPager) view.findViewById(R.id.viewPager_rank);
        tabLayout = (TabLayout) view.findViewById(R.id.tabLayout_rank);
        list = new ArrayList<>();
        adapter = new Frag_Adapter(getChildFragmentManager(), list, titles);
        for (int i = 0; i < 3; i++) {
            Fragment fragment = new SubFragment_rank();
            Bundle bundle = new Bundle();
            bundle.putInt("index", i);
            fragment.setArguments(bundle);
            list.add(fragment);
        }
        Fragment fragment = new SubFragment_rank_week();
        list.add(fragment);
        viewPager.setAdapter(adapter);
        viewPager.setOffscreenPageLimit(0);
        tabLayout.setupWithViewPager(viewPager);
    }

}
