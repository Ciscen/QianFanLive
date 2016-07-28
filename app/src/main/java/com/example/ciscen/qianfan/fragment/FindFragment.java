package com.example.ciscen.qianfan.fragment;


import android.content.Intent;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.support.v4.view.ViewPager;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.LinearLayout;

import com.example.ciscen.qianfan.R;
import com.example.ciscen.qianfan.activity.RoomActivity;
import com.example.ciscen.qianfan.adapter.PageAdapter;
import com.example.ciscen.qianfan.beans.DiscoverSwapBean;
import com.example.ciscen.qianfan.beans.DiscoverTitleBean;
import com.example.ciscen.qianfan.cans.Cans;
import com.example.ciscen.qianfan.utils.JsonUtil;
import com.example.ciscen.qianfan.view.viewpager.AutoScrollViewPager;

import org.xutils.common.Callback;
import org.xutils.http.RequestParams;
import org.xutils.image.ImageOptions;
import org.xutils.x;

import java.util.ArrayList;
import java.util.List;

public class FindFragment extends Fragment implements ViewPager.OnPageChangeListener, View.OnClickListener {

    private AutoScrollViewPager viewPager;

    private View[] indicators;
    private List<ImageView> list_imgs;//存放顶部banner的图片
    private List<DiscoverTitleBean> list_titles;//存放解析得到的Banner实体类
    private List<ImageView> list_ulike;//解析猜你喜欢中的5张图片
    private List<DiscoverSwapBean> list_guest;//存放解析得到的猜你喜欢实体类

    private int currentPage = 0;
    private int index = 0;

    public FindFragment() {
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_find, container, false);
        initView(view);
        return view;
    }

    private void initView(View view) {
        /*
        实例化控件
         */
        viewPager = (AutoScrollViewPager) view.findViewById(R.id.viewPager_find);
        ViewGroup viewGroup = (ViewGroup) view.findViewById(R.id.indicatorContainer);
        ViewGroup container1 = (ViewGroup) view.findViewById(R.id.container_find1);
        ViewGroup container2 = (ViewGroup) view.findViewById(R.id.container_find2);
        LinearLayout change = (LinearLayout) view.findViewById(R.id.change_find);
        LinearLayout store = (LinearLayout) view.findViewById(R.id.store_find);
        LinearLayout fish = (LinearLayout) view.findViewById(R.id.fish_task);
        LinearLayout sign = (LinearLayout) view.findViewById(R.id.day_sign);

        store.setOnClickListener(this);
        fish.setOnClickListener(this);
        sign.setOnClickListener(this);
        change.setOnClickListener(this);
        /*
        初始化集合
         */
        indicators = new View[viewGroup.getChildCount()];
        list_imgs = new ArrayList<>();
        list_titles = new ArrayList<>();
        list_guest = new ArrayList<>();
        list_ulike = new ArrayList<>();
        for (int i = 0; i < viewGroup.getChildCount(); i++) {
            indicators[i] = viewGroup.getChildAt(i);
            //添加默认的图片
            ImageView imageView = new ImageView(getActivity());
            imageView.setImageResource(R.mipmap.ic_default_banner);
            imageView.setScaleType(ImageView.ScaleType.CENTER_INSIDE);
            list_imgs.add(imageView);
        }
        /*
        给存放猜你喜欢实体类的集合添加数据
         */
        for (int i = 0; i < 5; i++) {
            if (i < 3) {
                ImageView imageView = (ImageView) container1.getChildAt(i);
                imageView.setOnClickListener(this);
                imageView.setTag(i);
                list_ulike.add(imageView);
            }
            if (i >= 3) {
                ImageView imageView = (ImageView) container2.getChildAt(i - 3);
                imageView.setTag(i);
                imageView.setOnClickListener(this);
                list_ulike.add(imageView);
            }
        }
        //设置ViewPager的一些参数
        setViewPager();
    }

    //设置ViewPager的一些参数
    private void setViewPager() {
        PageAdapter adapter = new PageAdapter(list_imgs);
        viewPager.setAdapter(adapter);
        viewPager.setAutoScrollDurationFactor(10);
        viewPager.addOnPageChangeListener(this);
        viewPager.setInterval(2000);
        indicators[0].setAlpha(1);
        viewPager.setCurrentItem(10000, false);
        viewPager.startAutoScroll();
    }

    @Override
    public void onActivityCreated(@Nullable Bundle savedInstanceState) {
        super.onActivityCreated(savedInstanceState);
        getBannerData();//获取顶部广告轮播数据
        getGuest();//获取猜你喜欢模块的数据
    }

    private void getGuest() {
        RequestParams entity = new RequestParams(Cans.GUESS_YOUR_LIKE);
        x.http().get(entity, new Callback.CommonCallback<String>() {
            @Override
            public void onSuccess(String result) {
                JsonUtil.disSwaParse(result, list_guest);
                updateImages();
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

    private void updateImages() {
        ImageOptions options = new ImageOptions.Builder()
                .setLoadingDrawableId(R.mipmap.ic_error_logo)
                .setFailureDrawableId(R.mipmap.ic_error_logo)
                .setRadius(25)
                .setImageScaleType(ImageView.ScaleType.CENTER_CROP)
                .setCrop(true)
                .build();
        for (int i = 0; i < list_ulike.size(); i++) {
            x.image().bind(list_ulike.get(i), list_guest.get(i + index).getPic51(), options);
        }
    }

    private void getBannerData() {
        RequestParams entity = new RequestParams(Cans.HEADER_LOOP);
        x.http().get(entity, new Callback.CommonCallback<String>() {
            @Override
            public void onSuccess(String result) {
                JsonUtil.bannerParse(result, list_titles);
                ImageOptions options = new ImageOptions.Builder()
                        .setLoadingDrawableId(R.mipmap.ic_default_banner)
                        .setFailureDrawableId(R.mipmap.ic_default_banner)
                        .build();
                for (int i = 0; i < list_titles.size(); i++) {
                    x.image().bind(list_imgs.get(i), list_titles.get(i).getPicUrl(), options);
                }
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

    /*
    对ViewPager的滑动监听
     */
    @Override
    public void onPageScrolled(int position, float positionOffset, int positionOffsetPixels) {

    }

    @Override
    public void onPageSelected(int position) {
        indicators[currentPage].setAlpha(0.5f);
        indicators[position % 4].setAlpha(1);
        currentPage = position % 4;
    }

    @Override
    public void onPageScrollStateChanged(int state) {

    }

    @Override
    public void onClick(View view) {
        Intent intent = new Intent();
        if (list_guest.size() == 0) {
            return;
        }
        switch (view.getId()) {
            case R.id.change_find:
                index += 5;
                if (index == 25) {
                    index = 0;
                }
                updateImages();
                return;
            case R.id.store_find:

                return;
            case R.id.fish_task:

                return;
            case R.id.day_sign:

                return;
        }
        intent.setClass(getActivity(), RoomActivity.class);
        switch ((int) view.getTag()) {
            case 0:
                intent.putExtra("push", list_guest.get(index).getPush());
                intent.putExtra("roomId", list_guest.get(index).getRoomid());
                startActivity(intent);
                break;
            case 1:
                intent.putExtra("push", list_guest.get(1 + index).getPush());
                intent.putExtra("roomId", list_guest.get(1 + index).getRoomid());
                startActivity(intent);
                break;
            case 2:
                intent.putExtra("push", list_guest.get(2 + index).getPush());
                intent.putExtra("roomId", list_guest.get(2 + index).getRoomid());
                startActivity(intent);
                break;
            case 3:
                intent.putExtra("push", list_guest.get(3 + index).getPush());
                intent.putExtra("roomId", list_guest.get(3 + index).getRoomid());
                startActivity(intent);
                break;
            case 4:
                intent.putExtra("push", list_guest.get(4 + index).getPush());
                intent.putExtra("roomId", list_guest.get(4 + index).getRoomid());
                startActivity(intent);
                break;
        }
    }
}
