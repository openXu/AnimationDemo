package com.openxu.anim.anim;

import android.animation.Animator;
import android.animation.AnimatorInflater;
import android.animation.AnimatorListenerAdapter;
import android.animation.AnimatorSet;
import android.animation.ObjectAnimator;
import android.animation.ValueAnimator;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.util.Log;
import android.view.View;

import com.openxu.anim.R;

/** 
 * autour: openXu
 * date: 2017/6/2 10:36
 * blog : http://blog.csdn.net/xmxkf
 * gitHub : https://github.com/openXu
 * className: PropertyAnimHeightActivity
 * version: 
 * description: 属性动画高级
 */
public class PropertyAnimHeightActivity extends AppCompatActivity {

    private View view;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_anim_property_height);
        view = findViewById(R.id.view);
    }

    //ValueAnimator用法
    public void valueAnim(View v){
        //1、将一个值从0平滑过渡到1，时长300毫秒
        ValueAnimator anim = ValueAnimator.ofFloat(0f, 1f);
        anim.setDuration(300);
        //监听动画值变化
        anim.addUpdateListener(new ValueAnimator.AnimatorUpdateListener() {
            @Override
            public void onAnimationUpdate(ValueAnimator animation) {
                float currentValue = (float) animation.getAnimatedValue();
                Log.d("openxu", "当前value = " + currentValue);
            }
        });
        anim.start();

        //2、从0到10整型过渡
        anim = ValueAnimator.ofInt(0,10);
        anim.setDuration(300);
        anim.start();
        //3、将一个值在5秒内从0过渡到5，再过渡到3，再过渡到10
        anim = ValueAnimator.ofFloat(0f, 5f, 3f, 10f);
        anim.setDuration(300);
        anim.start();
    }



}
