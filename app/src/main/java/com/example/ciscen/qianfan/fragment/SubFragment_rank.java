package com.example.ciscen.qianfan.fragment;


import android.content.Context;
import android.graphics.Color;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.support.v4.view.ViewPager;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import com.example.ciscen.qianfan.R;
import com.example.ciscen.qianfan.adapter.Frag_Adapter;
import com.example.ciscen.qianfan.cans.Cans;

import java.util.ArrayList;
import java.util.List;

public class SubFragment_rank extends Fragment implements ViewPager.OnPageChangeListener {

    private ViewPager viewPager;
    private TextView[] textes;
    private Frag_Adapter adapter;
    private List<Fragment> list;
    private int page;//标记当前viewPager的页面
    private int index;//标记当前是那个排行分类下。0明星，1富豪，2人气
    private String[] pathes = {Cans.RANK_STAR, Cans.RANK_WEALTH, Cans.RANK_POPULARITY};
    private boolean flag = false;//标记为，利用生命周期，防止在viewpager切换回来后导航指示颜色错乱
    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_sub_fragment_rank, container, false);
        index = getArguments().getInt("index");

        initView(view);
        return view;
    }

    @Override
    public void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        flag = true;
    }

    @Override
    public void onDestroyView() {
        super.onDestroyView();
        flag = false;
    }

    private void initView(View view) {
        viewPager = (ViewPager) view.findViewById(R.id.viewPager_sub_rank);
        ViewGroup vg = (ViewGroup) view.findViewById(R.id.textes);
        textes = new TextView[vg.getChildCount()];
        for (int i = 0; i < vg.getChildCount(); i++) {
            textes[i] = (TextView) vg.getChildAt(i * 2);//由于里面掺杂着“|”，所以要乘以2
            final int finalI = i/2;
            textes[i/2].setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View view) {
                    viewPager.setCurrentItem(finalI);
                }
            });
        }
        textes[page].setTextColor(Color.parseColor("#CB9C64"));
        initFragment();
        adapter = new Frag_Adapter(getChildFragmentManager(), list);
        viewPager.setAdapter(adapter);
        viewPager.addOnPageChangeListener(this);
    }

    private void initFragment() {
        list = new ArrayList<>();
        for (int i = 0; i < 4; i++) {
            Bundle bundle = new Bundle();
            bundle.putString("path", pathes[index] + (i+1));
            Fragment fragment = null;
            if (index == 0 || index == 2) {
                fragment = new GrandSubFragment_rank();
            }
            if(index==1){
                fragment = new GrandSubFragment_rank_wealth();
            }
            bundle.putInt("index",index);
            fragment.setArguments(bundle);
            list.add(fragment);
        }
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
