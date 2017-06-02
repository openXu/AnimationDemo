package com.openxu.anim.anim;

import android.content.Context;
import android.graphics.drawable.AnimationDrawable;
import android.graphics.drawable.Drawable;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.view.animation.AlphaAnimation;
import android.view.animation.Animation;
import android.view.animation.AnimationUtils;

import com.openxu.anim.R;

/** 
 * autour: openXu
 * date: 2017/6/2 10:36
 * blog : http://blog.csdn.net/xmxkf
 * gitHub : https://github.com/openXu
 * className: TweenAnimActivity
 * version: 
 * description: 补间动画的运用
 */
public class TweenAnimActivity extends AppCompatActivity {

    private View view;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_anim_tween);
        view = findViewById(R.id.view);
    }

    //alpha透明度渐变
    public void alphaAnim(View v){

        Animation anim = new AlphaAnimation(1.0f, 0.1f);
        //持续时间
        anim.setDuration(1000);
        //动画将于500ms之后执行
//        anim.setStartOffset(500);
        anim.setFillEnabled(true);
//        anim.setFillBefore(false);
        //true:控件动画结束时，保持最后时的状态
        anim.setFillAfter(true);
        //动画重复2次
        anim.setRepeatCount(4);
        // 重复模式：重新开始
        anim.setRepeatMode(Animation.RESTART);
        anim.setZAdjustment(Animation.ZORDER_BOTTOM);
        view.startAnimation(anim);
//
//	* android:zAdjustment：
//	* android:backgroud：
//	* android:detachWallpaper：
//	* android:interpoloator


       /* //从资源文件中加载动画
        AnimationUtils.loadAnimation(context, id)
        //从资源文件中加载插值器
        AnimationUtils.loadInterpolator(context, id)
        AnimationUtils.loadLayoutAnimation()
        AnimationUtils.makeInAnimation()
        AnimationUtils.makeOutAnimation()
        Animation anim = new AlphaAnimation();*/
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
