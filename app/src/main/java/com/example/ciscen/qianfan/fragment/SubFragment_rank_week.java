package com.example.ciscen.qianfan.fragment;


import android.graphics.Color;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v4.view.ViewPager;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import com.example.ciscen.qianfan.R;
import com.example.ciscen.qianfan.adapter.Frag_Adapter;
import com.example.ciscen.qianfan.cans.Cans;

import java.util.ArrayList;
import java.util.List;

public class SubFragment_rank_week extends Fragment implements ViewPager.OnPageChangeListener {

    private ViewPager viewPager;
    private TextView[] textes;
    private List<Fragment> list;
    private Frag_Adapter adapter;
    private int page;//表示ViewPager中的当前页面
    private String[]pathes = {Cans.RANK_FANS_THIS_WEEK,Cans.RANK_FANS_LAST_WEEK};

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_sub_fragment_rank_week, container, false);
        initView(view);
        return view;
    }

    private void initView(View view) {
        viewPager = (ViewPager) view.findViewById(R.id.viewPager_sub_rank_week);
        ViewGroup vg = (ViewGroup) view.findViewById(R.id.textes);
        textes = new TextView[vg.getChildCount()];
        for (int i = 0; i < vg.getChildCount(); i++) {
            textes[i] = (TextView) vg.getChildAt(i*2);
            final int finalI = i/2;
            textes[i/2].setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View view) {
                    viewPager.setCurrentItem(finalI);
                }
            });
        }
        textes[page].setTextColor(Color.parseColor("#CB9C64"));
        addFragment();
        viewPager.setAdapter(adapter);
        viewPager.addOnPageChangeListener(this);
    }

    private void addFragment() {//添加fragment到集合里
        list = new ArrayList<>();
        for (int i = 0; i < 2; i++) {
            Bundle bundle = new Bundle();
            bundle.putString("path", pathes[i]);//传送地址
            Fragment fragment = new GrandSubFragment_rank_week();
            fragment.setArguments(bundle);
            list.add(fragment);
        }
        adapter = new Frag_Adapter(getChildFragmentManager(), list);
    }

    @Override
    public void onPageScrolled(int position, float positionOffset, int positionOffsetPixels) {

    }

    @Override
    public void onPageSelected(int position) {
        textes[page].setTextColor(Color.BLACK);
        textes[position].setTextColor(Color.parseColor("#CB9C64"));
        page = position;
    }

    @Override
    public void onPageScrollStateChanged(int state) {

    }
}
