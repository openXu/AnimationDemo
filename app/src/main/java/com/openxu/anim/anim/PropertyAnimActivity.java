package com.openxu.anim.anim;

import android.graphics.Color;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.view.animation.AlphaAnimation;
import android.view.animation.Animation;

import com.openxu.anim.R;

/** 
 * autour: openXu
 * date: 2017/6/2 10:36
 * blog : http://blog.csdn.net/xmxkf
 * gitHub : https://github.com/openXu
 * className: TweenAnimActivity
 * version: 
 * description: 属性动画的运用
 */
public class PropertyAnimActivity extends AppCompatActivity {

    private View view;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_anim_tween);
        view = findViewById(R.id.view);
    }

    //ValueAnimator用法
    public void valueAnim(View v){
    }
    //scale缩放动画
    public void scaleAnim(View v){
    }
    //translate位移动画
    public void translateAnim(View v){
    }
    //rotate旋转动画
    public void rotateAnim(View v){
    }


}
