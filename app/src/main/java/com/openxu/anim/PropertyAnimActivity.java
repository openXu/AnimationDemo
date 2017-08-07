package com.openxu.anim;

import android.animation.Animator;
import android.animation.AnimatorInflater;
import android.animation.AnimatorListenerAdapter;
import android.animation.AnimatorSet;
import android.animation.ObjectAnimator;
import android.animation.ValueAnimator;
import android.graphics.Color;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.util.Log;
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
        setContentView(R.layout.activity_anim_property);
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

    //ObjectAnimator用法
    public void objectAnim(View v){
        //1、让view从不透明到全透明，然后不透明
        ObjectAnimator animator = ObjectAnimator.ofFloat(view, "alpha", 1f, 0f, 1f);
        animator.setDuration(3000);
        animator.start();
        //2、让view再3s内从0°旋转到360°
        animator = ObjectAnimator.ofFloat(view, "rotation", 0f, 360f);
        animator.setDuration(3000);
        animator.start();
        //3、让view从当前位置沿X轴方向向右平移500个像素，然后回到原位
        float curTranslationX = view.getTranslationX();
        animator = ObjectAnimator.ofFloat(view, "translationX", curTranslationX, 500f, curTranslationX);
        animator.setDuration(3000);
        animator.start();
        //4、让view垂直方向放大3倍，然后缩放到原来的大小
        animator = ObjectAnimator.ofFloat(view, "scaleY", 1f, 3f, 1f);
        animator.setDuration(3000);
        animator.start();
    }
    //AnimatorSet
    public void nimatorSet(View v){
        float curTranslationX = view.getTranslationX();
        ObjectAnimator trans = ObjectAnimator.ofFloat(view, "translationX", curTranslationX, 500f, curTranslationX);
        ObjectAnimator rotate = ObjectAnimator.ofFloat(view, "rotation", 0f, 360f);
        ObjectAnimator alpha = ObjectAnimator.ofFloat(view, "alpha", 1f, 0f, 1f);
        ObjectAnimator scale = ObjectAnimator.ofFloat(view, "scaleY", 1f, 3f, 1f);
        AnimatorSet animSet = new AnimatorSet();
        animSet.play(trans).with(rotate).after(alpha).before(scale);
        animSet.setDuration(3000);
        animSet.start();
    }
    //AnimatorListener
    public void animatorListener(View v){
        ObjectAnimator scale = ObjectAnimator.ofFloat(view, "scaleY", 1f, 3f, 1f);
        scale.setRepeatCount(2);
        scale.setDuration(3000);
        scale.addListener(new Animator.AnimatorListener() {
            //动画开始的时候调用
            @Override
            public void onAnimationStart(Animator animation) {
                Log.i("openxu", "动画开始了onAnimationStart");
            }
            //动画重复执行的时候调用
            @Override
            public void onAnimationRepeat(Animator animation) {
                Log.i("openxu", "动画重复执行onAnimationRepeat");
            }
            //动画结束的时候调用
            @Override
            public void onAnimationEnd(Animator animation) {
                Log.i("openxu", "动画结束了onAnimationEnd");
            }
            //取消的时候调用
            @Override
            public void onAnimationCancel(Animator animation) {
                Log.i("openxu", "动画被取消了onAnimationCancel");
            }
        });
        scale.setDuration(3000);
        scale.addListener(new AnimatorListenerAdapter() {
            @Override
            public void onAnimationEnd(Animator animation) {
                super.onAnimationCancel(animation);
            }
        });
        scale.addPauseListener(new Animator.AnimatorPauseListener() {
            @Override
            public void onAnimationPause(Animator animation) {
                Log.i("openxu", "动画暂停");
            }
            @Override
            public void onAnimationResume(Animator animation) {
                Log.i("openxu", "动画恢复");
            }
        });
        scale.addUpdateListener(new ValueAnimator.AnimatorUpdateListener() {
            @Override
            public void onAnimationUpdate(ValueAnimator animation) {
                Log.i("openxu", "onAnimationUpdate:"+animation.getAnimatedValue());
            }
        });
        scale.start();
    }

    public void xmlAnim(View v){
        Animator animator = AnimatorInflater.loadAnimator(this, R.animator.alpha);
        animator.setTarget(view);
        animator.start();
    }



}
