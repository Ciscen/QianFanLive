package com.example.ciscen.qianfan.fragment;


import android.graphics.Color;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v4.view.ViewPager;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.HorizontalScrollView;
import android.widget.TextView;

import com.example.ciscen.qianfan.R;
import com.example.ciscen.qianfan.adapter.Frag_Adapter;

import org.w3c.dom.Text;

import java.util.ArrayList;
import java.util.List;

/**
 * 首页Fragment 内有一个标题栏，一个ViewPager
 */
public class HomeFragment extends Fragment implements ViewPager.OnPageChangeListener {
    private ViewPager viewPager;
    private List<Fragment> list;
    private Frag_Adapter adapter;
    private HorizontalScrollView tab_scroll;//顶部的导航 #CB9C64
    private ViewGroup textes;
    private int cur_page;
    private int width_tv;
    private TextView tab_tv;
    private TextView tab2_tv;
    private int width_screen;

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_home, container, false);
        initView(view);
        return view;
    }

    private void initView(View view) {
        viewPager = (ViewPager) view.findViewById(R.id.viewPager_home);
        tab_scroll = (HorizontalScrollView) view.findViewById(R.id.tab_sroll);
        tab_tv = (TextView) view.findViewById(R.id.gyz);
        tab2_tv = (TextView) view.findViewById(R.id.all);
        textes = (ViewGroup) view.findViewById(R.id.textes);//tab栏里的textView的父容器
        TextView firstTab = (TextView) textes.getChildAt(0);//给第一个textView上色
        firstTab.setTextColor(Color.parseColor("#CB9C64"));
        width_screen = getResources().getDisplayMetrics().widthPixels;//得到屏幕的尺寸，用于跟随滑动时的计算
        list = new ArrayList<>();
        for (int i = 0; i < 9; i++) {
            Bundle bundle = new Bundle();
            bundle.putInt("type", i);
            Fragment fragment = new subFragment_home();
            fragment.setArguments(bundle);
            list.add(fragment);
            final int finalI = i;
            textes.getChildAt(i).setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View view) {
                    viewPager.setCurrentItem(finalI);
                }
            });
        }
        adapter = new Frag_Adapter(getChildFragmentManager(), list);
        viewPager.setAdapter(adapter);
        viewPager.addOnPageChangeListener(this);
    }

    @Override
    public void onPageScrolled(int position, float positionOffset, int positionOffsetPixels) {
        float d = width_screen*1.0f / tab_tv.getWidth();
            tab_scroll.smoothScrollTo((int) (textes.getChildAt(position).getLeft()-200 + positionOffsetPixels / d), 0);
    }

    @Override
    public void onPageSelected(int position) {
        width_tv = tab_tv.getWidth();
        TextView t = (TextView) textes.getChildAt(position);
        TextView t2 = (TextView) textes.getChildAt(cur_page);
        t2.setTextColor(Color.GRAY);
        t.setTextColor(Color.parseColor("#CB9C64"));
        cur_page = position;
    }

    @Override
    public void onPageScrollStateChanged(int state) {

    }


}
