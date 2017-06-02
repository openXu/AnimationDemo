package com.openxu.anim.anim;

import android.content.Intent;
import android.graphics.drawable.AnimationDrawable;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.view.animation.Animation;
import android.view.animation.AnimationUtils;
import android.view.animation.DecelerateInterpolator;
import android.view.animation.Interpolator;
import android.view.animation.TranslateAnimation;

import com.openxu.anim.R;

/** 
 * autour: openXu
 * date: 2017/6/2 10:36
 * blog : http://blog.csdn.net/xmxkf
 * gitHub : https://github.com/openXu
 * className: AnimationiActivity
 * version: 
 * description: 各种动画
 */
public class AnimationiActivity extends AppCompatActivity {


    private View frameView, view;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_animation);
        frameView = findViewById(R.id.frameView);
        view = findViewById(R.id.view);
    }

    //帧动画
    public void frameAnim(View v){
        startActivity(new Intent(this, FrameAnimActivity.class));
    }
    //补间动画
    public void tweenAnim(View v){
        startActivity(new Intent(this, TweenAnimActivity.class));
    }


}
