package com.openxu.anim;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.view.animation.Animation;
import android.view.animation.AnimationUtils;
import android.view.animation.DecelerateInterpolator;
import android.view.animation.Interpolator;
import android.view.animation.TranslateAnimation;

/** 
 * autour: openXu
 * date: 2017/6/2 10:36
 * blog : http://blog.csdn.net/xmxkf
 * gitHub : https://github.com/openXu
 * className: InterpolatorActivity
 * version: 
 * description: 插值器基本用法&系统自带插值器
 */
public class InterpolatorActivity extends AppCompatActivity {


    private View view;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_interpolator);
        view = findViewById(R.id.view);
    }

    //动画xml中设置插值器
    public void interpolatorXml(View v){
        //加载动画
        Animation anim = AnimationUtils.loadAnimation(this, R.anim.anim_test);
        //执行动画
        view.startAnimation(anim);
    }
    //java中设置插值器
    public void interpolatorJava(View v){
        //创建动画
        Animation anim = new TranslateAnimation(0,0,0,1000);
        anim.setDuration(1000);
        //减速插值器
        Interpolator interpolator = new DecelerateInterpolator();
        //设置插值器
        anim.setInterpolator(interpolator);
        //执行动画
        view.startAnimation(anim);
    }


}
