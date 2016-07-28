package com.example.ciscen.qianfan;

import android.animation.AnimatorSet;
import android.animation.ObjectAnimator;
import android.content.Intent;
import android.os.Handler;
import android.os.Message;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.view.Window;

public class WelcomeActivity extends AppCompatActivity {
    private View view;
    private View img2;
    private Handler handler = new Handler() {
        @Override
        public void handleMessage(Message msg) {
            super.handleMessage(msg);
            int width = view.getWidth();
            ObjectAnimator animator = ObjectAnimator.ofFloat(view, "translationX", 0, -width);
            animator.setDuration(500);
            ObjectAnimator animator1 = ObjectAnimator.ofFloat(img2, "translationX",width, 1);
            animator1.setDuration(500);
            AnimatorSet set = new AnimatorSet();
            set.play(animator).with(animator1);
//            animator.start();
//            animator1.start();
            set.start();
        }
    };

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        supportRequestWindowFeature(Window.FEATURE_NO_TITLE);
        setContentView(R.layout.activity_welcome);
        view = findViewById(R.id.ll);
        img2 = findViewById(R.id.nn);
//        img2 = View.inflate(this, R.layout.animator_img_start, null);
        handler.sendEmptyMessageDelayed(100, 1000);
    }

    public void onClick(View view) {
        Intent intent = new Intent(this,MainActivity.class);
        startActivity(intent);
        finish();
    }
}
