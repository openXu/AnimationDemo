package com.openxu.anim.anim;

import android.content.Context;
import android.graphics.Color;
import android.graphics.drawable.AnimationDrawable;
import android.graphics.drawable.Drawable;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.view.ViewGroup;
import android.view.animation.AlphaAnimation;
import android.view.animation.Animation;
import android.view.animation.AnimationSet;
import android.view.animation.AnimationUtils;
import android.view.animation.RotateAnimation;
import android.view.animation.ScaleAnimation;
import android.view.animation.TranslateAnimation;

import com.openxu.anim.R;

import static android.view.animation.Animation.ABSOLUTE;

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

   /*     Animation anim = new AlphaAnimation(1.0f, 0.1f);
        //持续时间
        anim.setDuration(1000);
        //动画将于500ms之后执行
//        anim.setStartOffset(500);
        anim.setFillEnabled(true);
//        anim.setFillBefore(false);
        //true:控件动画结束时，保持最后时的状态
        anim.setFillAfter(true);
        anim.setRepeatCount(4);
        // 重复模式：重新开始
        anim.setRepeatMode(Animation.RESTART);
        anim.setZAdjustment(Animation.ZORDER_BOTTOM);
        anim.setBackgroundColor(Color.BLACK);
        anim.setDetachWallpaper(true);
        view.startAnimation(anim);*/


        //从资源文件中加载动画
        Animation alphaAnimation = AnimationUtils.loadAnimation(this, R.anim.anim_alpha);
        view.startAnimation(alphaAnimation);
    }
    //scale缩放动画
    public void scaleAnim(View v){
        /**
         * 以控件自身中心点 放大一倍
         * @param fromX 起始的X方向上相对自身的缩放比例
         * @param toX 结束时X方向上相对自身的缩放比例
         * @param fromY 起始时Y方向上相对自身的缩放比例
         * @param toY 结束时Y方向上相对自身的缩放比例
         * @param pivotXType 缩放中心点X坐标的类型
         *                   ①、Animation.ABSOLUTE 绝对坐标值
         *                   ②、Animation.RELATIVE_TO_SELF相对于自身宽的比例，0.5f相当于中点X坐标为目标控件中心
         *                   ③、Animation.RELATIVE_TO_PARENT相对于父控件宽的比例
         * @param pivotXValue 缩放中心点X坐标，可以是坐标绝对值（ABSOLUTE），也可以是百分比（1.0==100%）
         * @param pivotYType 缩放中心点Y坐标的类型
         * @param pivotYValue 缩放中心点Y坐标
         */
        ScaleAnimation anim = new ScaleAnimation(1.0f, 2.0f, 1.0f, 2.0f,
                Animation.RELATIVE_TO_SELF, 0.5f, Animation.RELATIVE_TO_SELF, 0.5f);
        //持续时间
        anim.setDuration(1000);
        anim.setFillEnabled(true);
        //true:控件动画结束时，保持最后时的状态
        anim.setFillAfter(true);
        //动画重复2次
        anim.setRepeatCount(2);
        // 重复模式：重新开始
        anim.setRepeatMode(Animation.RESTART);
        view.startAnimation(anim);
    }

    //rotate旋转动画
    public void rotateAnim(View v){
        /**
         * 以控件自身中心坐标为中心点，旋转45度
         * @param fromDegrees 开始旋转的角度位置为0度
         * @param toDegrees 结束时旋转到的角度位置45度
         * @param pivotXType 中点X坐标值的类型，一共分3种.
         *                   ①、Animation.ABSOLUTE坐标绝对值
         *                   ②、Animation.RELATIVE_TO_SELF相对于自己宽高的百分比
         *                   ③、Animation.RELATIVE_TO_PARENT相对于父控件宽高的百分比
         * @param pivotXValue 围绕某一点旋转的X轴坐标，可以是坐标绝对值（ABSOLUTE），也可以是百分比（1.0==100%）
         * @param pivotYType 中点Y坐标值的类型
         * @param pivotYValue 围绕某一点旋转 的Y轴坐标
         */
        RotateAnimation anim = new RotateAnimation(0, 45, Animation.RELATIVE_TO_SELF,
                0.5f,  Animation.RELATIVE_TO_SELF, 0.5f);
        //持续时间
        anim.setDuration(1000);
        anim.setFillAfter(true);
        //动画重复2次
        anim.setRepeatCount(2);
        // 重复模式：重新开始
        anim.setRepeatMode(Animation.RESTART);
        view.startAnimation(anim);
    }

    //translate位移动画
    public void translateAnim(View v){
        /**
         * 从坐标（0,0）移动到（150,300），注意（0,0）是控件左上角坐标
         *
         * @param fromXType 起始X轴坐标值类型， One of
         *                  Animation.ABSOLUTE,
         *                  Animation.RELATIVE_TO_SELF,
         *                  or Animation.RELATIVE_TO_PARENT.
         * @param fromXValue 起始X轴坐标值，可以是绝对值或者比值
         * @param toXType 结束X轴坐标值类型
         * @param toXValue 结束X轴坐标
         * @param fromYType 起始Y轴坐标值类型
         * @param fromYValue 起始Y轴坐标值
         * @param toYType 结束Y轴坐标值类型
         * @param toYValue 结束Y轴坐标
         */
        TranslateAnimation anim = new TranslateAnimation(Animation.ABSOLUTE, 0, Animation.ABSOLUTE, 150f,
                Animation.ABSOLUTE, 0, Animation.ABSOLUTE, 300f);
        //持续时间
        anim.setDuration(1000);
        anim.setFillAfter(true);
        //动画重复2次
        anim.setRepeatCount(2);
        // 重复模式：重新开始
        anim.setRepeatMode(Animation.RESTART);
        view.startAnimation(anim);
    }

    public void animSet(View v){
        ScaleAnimation anim1 = new ScaleAnimation(1.0f, 2.0f, 1.0f, 2.0f,
                Animation.RELATIVE_TO_SELF, 0.5f, Animation.RELATIVE_TO_SELF, 0.5f);
        RotateAnimation anim2 = new RotateAnimation(0, 45, Animation.RELATIVE_TO_SELF,
                0.5f,  Animation.RELATIVE_TO_SELF, 0.5f);
        TranslateAnimation anim3 = new TranslateAnimation(Animation.ABSOLUTE, 0, Animation.ABSOLUTE, 150f,
                Animation.ABSOLUTE, 0, Animation.ABSOLUTE, 300f);

        //创建组合动画，参数为true表示自己设置的插值器，false表示每个子动画都使用自己的插值器
        AnimationSet set = new AnimationSet(true);
        //将动画加入到组合动画中
        set.addAnimation(anim1);
        set.addAnimation(anim2);
        set.addAnimation(anim3);
        //持续时间
        set.setDuration(1000);
        view.startAnimation(set);
    }

}
