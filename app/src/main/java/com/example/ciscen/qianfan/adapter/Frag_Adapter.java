package com.example.ciscen.qianfan.adapter;

import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentPagerAdapter;

import java.util.List;

/**
 * Created by Chong on 2016/7/18
 */
public class Frag_Adapter extends FragmentPagerAdapter {
    private List<Fragment> list;
    private String[]titles ;
    public Frag_Adapter(FragmentManager fm,List<Fragment>list,String[]titles) {
        super(fm);
        this.list = list;
        this.titles = titles;
    }

    public Frag_Adapter(FragmentManager fm, List<Fragment> list) {
        super(fm);
        this.list = list;
    }

    @Override
    public Fragment getItem(int position) {
        return list.get(position);
    }

    @Override
    public int getCount() {
        return list.size();
    }

    @Override
    public CharSequence getPageTitle(int position) {
        if (titles != null) {
            return titles[position];
        }
        return super.getPageTitle(position);

    }
}
