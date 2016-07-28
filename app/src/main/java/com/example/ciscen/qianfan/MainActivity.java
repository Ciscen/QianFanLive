package com.example.ciscen.qianfan;

import android.content.Intent;
import android.graphics.Color;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentActivity;
import android.support.v4.app.FragmentManager;
import android.view.View;
import android.widget.LinearLayout;
import android.widget.RadioButton;
import android.widget.RadioGroup;

import com.example.ciscen.qianfan.activity.LoginActivity;
import com.example.ciscen.qianfan.activity.RoomActivity;
import com.example.ciscen.qianfan.activity.SettingActivity;
import com.example.ciscen.qianfan.fragment.FindFragment;
import com.example.ciscen.qianfan.fragment.HomeFragment;
import com.example.ciscen.qianfan.fragment.MineFragment;
import com.example.ciscen.qianfan.fragment.RankFragment;

import java.util.ArrayList;
import java.util.List;

public class MainActivity extends FragmentActivity {
    /**************
     * 组件声明
     ***************/
    private RadioGroup radioGroup;//底部四个RadioButton的RadioGroup
    private RadioButton[] buttons;//四个RadioButton
    private LinearLayout container;//主页的Fragment的容器
    /***************
     * 数据类
     ***************/
    private List<Fragment> fragments;
    /****************
     * 变量类
     **************/
    private int currentPage = 0;//当前被选中的fragment
    /****************
     * 管理类
     ***************/
    private FragmentManager manager;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        init();
        setView();//对View进行设置
    }


    private void init() {
        /******控件初始化*********/
        initView();
        /**********数据初始化************/
        fillFragments();//将fragment添加到集合，作为数据源
        manager = getSupportFragmentManager();
        //radioGroup的点击事件
        radioGroup.setOnCheckedChangeListener(new RadioGroup.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(RadioGroup radioGroup, int id) {
                for (int i = 0; i < buttons.length; i++) {
                    if (buttons[i].getId() == id) {
                        changeFragment(i);
                    }
                }
            }
        });
    }

    /******
     * 控件初始化
     *********/
    private void initView() {
        radioGroup = (RadioGroup) findViewById(R.id.radioGroup_main);
        buttons = new RadioButton[radioGroup.getChildCount()];
        container = (LinearLayout) findViewById(R.id.container_main);
        //实例化每个radioButton
        for (int i = 0; i < radioGroup.getChildCount(); i++) {
            buttons[i] = (RadioButton) radioGroup.getChildAt(i);
        }
        buttons[0].setChecked(true);
        buttons[0].setTextColor(Color.parseColor("#CB9C64"));
    }


    /*
    填充fragment到集合中
     */
    private void fillFragments() {
        fragments = new ArrayList<>();//实例化集合
        Fragment home_fr = new HomeFragment();
        Fragment rank_fr = new RankFragment();
        Fragment find_fr = new FindFragment();
        Fragment mine_fr = new MineFragment();
        fragments.add(home_fr);
        fragments.add(rank_fr);
        fragments.add(find_fr);
        fragments.add(mine_fr);
    }

    //切换fragment
    private void changeFragment(int i) {
        //颜色切换
        for (int j = 0; j < buttons.length; j++) {
            if (j == i) {
                buttons[i].setTextColor(Color.parseColor("#CB9C64"));
            } else {
                buttons[j].setTextColor(Color.GRAY);
            }
        }
        //中间多了个radioButton
        if (i > 2) {
            i--;
        }

        Fragment frag_current = fragments.get(currentPage);
        Fragment frag_to = fragments.get(i);
        if (frag_to.isAdded()) {
            manager.beginTransaction().show(frag_to).hide(frag_current).commit();
        } else {
            manager.beginTransaction().hide(frag_current).add(R.id.container_main, frag_to).commit();
        }
        currentPage = i;
    }

    private void setView() {
        //第一个先添加进去
        manager.beginTransaction().add(R.id.container_main, fragments.get(0)).commit();
    }

    public void onClick(View view) {
        Intent intent  = new Intent();
        switch (view.getId()) {
            case R.id.set_mine_rl:
                intent.setClass(this, SettingActivity.class);
                startActivity(intent);
                break;
            case R.id.container_rankStar:
                intent.setClass(this, RoomActivity.class);
                Bundle bundle = (Bundle) view.getTag();
                intent.putExtra("roomId", bundle.getString("roomId"));
                intent.putExtra("push", bundle.getString("push"));
                startActivity(intent);
                break;
            default:
                intent.setClass(this, LoginActivity.class);
                startActivity(intent);
                break;
        }
    }
}
