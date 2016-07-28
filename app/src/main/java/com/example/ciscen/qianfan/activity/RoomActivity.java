package com.example.ciscen.qianfan.activity;

import android.animation.ObjectAnimator;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.GestureDetector;
import android.view.MotionEvent;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import com.example.ciscen.qianfan.R;
import com.example.ciscen.qianfan.beans.AnchorInfo_Room;
import com.example.ciscen.qianfan.beans.HomeRoomIdBean;
import com.example.ciscen.qianfan.cans.Cans;
import com.example.ciscen.qianfan.utils.JsonUtil;

import org.xutils.common.Callback;
import org.xutils.http.RequestParams;
import org.xutils.x;

import java.util.ArrayList;
import java.util.List;

import io.vov.vitamio.MediaPlayer;
import io.vov.vitamio.Vitamio;
import io.vov.vitamio.widget.MediaController;
import io.vov.vitamio.widget.VideoView;

public class RoomActivity extends AppCompatActivity implements GestureDetector.OnGestureListener {

    private String path;
    private GestureDetector detector;
    private View view;//浮层布局
    private View titleAndFoot;
    private View foot;
    private int position;
    private int screenWidth;
    private ObjectAnimator animator;
    private VideoView vitamio;
    private List<HomeRoomIdBean> list;
    private int point;
    private String roomId;
    private boolean isShow = false;//标记房间内顶栏跟底部的显示状态

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_room);
        Vitamio.isInitialized(this);
        roomId = getIntent().getStringExtra("roomId");
        path = Cans.LIVE_ROOM + roomId;
        int push = Integer.parseInt(getIntent().getStringExtra("push"));

        detector = new GestureDetector(this, this);
        view = findViewById(R.id.view);
        view.setVisibility(View.INVISIBLE);
        titleAndFoot = findViewById(R.id.title_room);
        foot = findViewById(R.id.foot);
        screenWidth = getResources().getDisplayMetrics().widthPixels;
        list = new ArrayList<>();
        vitamio = (VideoView) findViewById(R.id.vitamio);
        if (push == 1) {
            vitamio.setY(200);
        }
        getData();

        //对播放状态的监听
        vitamio.setOnInfoListener(new MediaPlayer.OnInfoListener() {
            @Override
            public boolean onInfo(MediaPlayer mp, int what, int extra) {
                int bufferProgress = mp.getBufferProgress();
                Log.d("TAG", "onInfo: " + bufferProgress);
                return false;
            }
        });
        getRoomInfo();
    }

    private void getRoomInfo() {
        RequestParams params = new RequestParams(Cans.ANCHORINFO + roomId);
        x.http().get(params, new Callback.CommonCallback<String>() {
            @Override
            public void onSuccess(String result) {
                AnchorInfo_Room info = new AnchorInfo_Room();
                JsonUtil.parseAnchorInfo_Room(result, info);
                TextView name = (TextView) RoomActivity.this.findViewById(R.id.name_tv);
                TextView roomId = (TextView) RoomActivity.this.findViewById(R.id.roomId_tv);
                ImageView header = (ImageView) RoomActivity.this.findViewById(R.id.header_iv);
                name.setText(info.getAname());
                roomId.setText(info.getMedalId());
                x.image().bind(header, info.getAvatar());
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

    private void getData() {
        RequestParams entity = new RequestParams(path);
        x.http().get(entity, new Callback.CommonCallback<String>() {
            @Override
            public void onSuccess(String result) {
                JsonUtil.homeRoomParse(result, list);
                initVideo();
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

    private void initVideo() {
        String s = list.get(0).getrUrl();
        final String flvPath = s.substring(0, s.indexOf("?"));
        vitamio.setVideoPath(flvPath);
        vitamio.setOnPreparedListener(new MediaPlayer.OnPreparedListener() {
            @Override
            public void onPrepared(MediaPlayer mp) {
            }
        });
        view.setVisibility(View.VISIBLE);
        isShow = true;
        vitamio.start();
    }

    @Override
    public boolean onTouchEvent(MotionEvent event) {
        switch (event.getAction()) {
            case MotionEvent.ACTION_UP:
                if (position < screenWidth / 2) {
                    animator = ObjectAnimator.ofFloat(view, "translationX", position, 0);
                    position = 0;
                } else {
                    animator = ObjectAnimator.ofFloat(view, "translationX", position, screenWidth);
                    position = screenWidth;
                }
                animator.setDuration(150);
                animator.start();

                break;

        }
        return detector.onTouchEvent(event);
    }

    @Override
    public boolean onDown(MotionEvent motionEvent) {
        return false;
    }

    @Override
    public void onShowPress(MotionEvent motionEvent) {

    }

    @Override
    public boolean onSingleTapUp(MotionEvent motionEvent) {
        if (isShow) {
            titleAndFoot.setVisibility(View.GONE);
            foot.setVisibility(View.GONE);
        } else {
            titleAndFoot.setVisibility(View.VISIBLE);
            foot.setVisibility(View.VISIBLE);
        }
        isShow = !isShow;
        return false;
    }

    @Override
    public boolean onScroll(MotionEvent motionEvent, MotionEvent motionEvent1, float v, float v1) {
        int dx = (int) (motionEvent1.getX() - motionEvent.getX());
        if (position - v < 0) {
            return false;
        }
        position = (int) (position - v);
        view.setX(position);
        return false;
    }

    @Override
    public void onLongPress(MotionEvent motionEvent) {
    }

    @Override
    public boolean onFling(MotionEvent motionEvent, MotionEvent motionEvent1, float v, float v1) {
        return false;
    }

}
