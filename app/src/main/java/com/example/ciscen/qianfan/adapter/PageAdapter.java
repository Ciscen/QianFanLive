package com.example.ciscen.qianfan.adapter;

import android.support.v4.view.PagerAdapter;
import android.view.View;
import android.view.ViewGroup;
import android.view.ViewParent;
import android.widget.ImageView;

import java.util.List;

/**
 * Created by Chong on 2016/7/21
 */
public class PageAdapter extends PagerAdapter {
    private List<ImageView> list;

    public PageAdapter(List<ImageView> list) {
        this.list = list;
    }

    @Override
    public int getCount() {
        return Integer.MAX_VALUE;
    }

    @Override
    public Object instantiateItem(ViewGroup container, int position) {
        int p = position%list.size();
        View view = list.get(p);
        ViewParent parent = view.getParent();
        if (parent == null) {
            container.addView(view);
        } else {
            ViewGroup vg = (ViewGroup) parent;
            vg.removeView(view);
            container.addView(view);
        }
        return view;

    }

    @Override
    public void destroyItem(ViewGroup container, int position, Object object) {
        container.removeView(list.get(position%list.size()));
    }

    @Override
    public boolean isViewFromObject(View view, Object object) {
        return view == object;
    }
}
