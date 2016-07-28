package com.example.ciscen.qianfan.fragment;


import android.content.Context;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.support.v7.widget.RecyclerView;
import android.support.v7.widget.StaggeredGridLayoutManager;
import android.util.Log;
import android.view.GestureDetector;
import android.view.LayoutInflater;
import android.view.MotionEvent;
import android.view.View;
import android.view.ViewGroup;

import com.chanven.lib.cptr.PtrClassicFrameLayout;
import com.chanven.lib.cptr.PtrDefaultHandler;
import com.chanven.lib.cptr.PtrFrameLayout;
import com.example.ciscen.qianfan.R;
import com.example.ciscen.qianfan.adapter.HomeAdapter;
import com.example.ciscen.qianfan.beans.HomeUrlBean;
import com.example.ciscen.qianfan.cans.Cans;
import com.example.ciscen.qianfan.utils.JsonUtil;

import org.xutils.common.Callback;
import org.xutils.http.RequestParams;
import org.xutils.x;

import java.util.ArrayList;
import java.util.List;

/**
 * 用语显示主播信息recyclerView的子Fragment
 */
public class subFragment_home extends Fragment {
    private List<HomeUrlBean> list;//主页展示数据的数据源
    private String path = null;//存放该页面的数据地址
    private RecyclerView recyclerView;
    private View emptyView;
    private PtrClassicFrameLayout ptr;
    private HomeAdapter adapter;//RecyclerView适配器
    private StaggeredGridLayoutManager manager;
    private Context context;
    private int type;//标记当前的Fragment在父Fragemnt中的索引（即分类标号）
    private int index;//用于分页
    private boolean isFreshing = false;


    @Override
    public void onAttach(Context context) {
        super.onAttach(context);
        this.context = context;
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_sub_fragment_home, container, false);
        initView(view);
        return view;
    }

    private void initView(View view) {
        recyclerView = (RecyclerView) view.findViewById(R.id.recyclerView_home);
        ptr = (PtrClassicFrameLayout) view.findViewById(R.id.ptr);
        emptyView = view.findViewById(R.id.emptyView);
        type = getArguments().getInt("type");
        path = String.format(Cans.HOME_PAGE, type);//得到连接地址
        list = new ArrayList<>();
        adapter = new HomeAdapter(list, context);
        manager = new StaggeredGridLayoutManager(2, StaggeredGridLayoutManager.VERTICAL);
        //设置布局管理器
        recyclerView.setLayoutManager(manager);
        recyclerView.setAdapter(adapter);
        recyclerView.addOnScrollListener(new RecyclerView.OnScrollListener() {
            @Override
            public void onScrollStateChanged(RecyclerView recyclerView, int newState) {
                super.onScrollStateChanged(recyclerView, newState);
            }

            @Override
            public void onScrolled(RecyclerView recyclerView, int dx, int dy) {
                super.onScrolled(recyclerView, dx, dy);
                //滑动到最底部的时候进行数据加载
                int[] positions = manager.findLastVisibleItemPositions(null);
                for (int i = 0; i < positions.length; i++) {
                    if (positions[i] == adapter.getItemCount() - 1 && !isFreshing) {
                        index++;
                        getData();
                    }
                }
            }
        });
        ptr.setPtrHandler(new PtrDefaultHandler() {
            @Override
            public void onRefreshBegin(PtrFrameLayout frame) {
                index = 0;
                list.clear();
                getData();
            }
        });
        ptr.getHeader().findViewById(R.id.ptr_classic_header_rotate_view);
        emptyView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                getData();
            }
        });
    }

    @Override
    public void onActivityCreated(@Nullable Bundle savedInstanceState) {
        super.onActivityCreated(savedInstanceState);
        getData();
    }

    private void getData() {
        isFreshing = true;
        RequestParams params = new RequestParams(path + index * 23);
        x.http().get(params, new Callback.CommonCallback<String>() {
            @Override
            public void onSuccess(String result) {
                emptyView.setVisibility(View.GONE);
                JsonUtil.homeUrlParse(result, list);
                adapter.notifyDataSetChanged();
                isFreshing = false;
                ptr.refreshComplete();
            }

            @Override
            public void onError(Throwable ex, boolean isOnCallback) {
                Log.e("TAG", "onError: " + "网络错误");
                isFreshing = false;
                emptyView.setVisibility(View.VISIBLE);
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
