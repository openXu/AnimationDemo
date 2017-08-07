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

import com.openxu.anim.R;
import com.openxu.anim.view.ColorEvaluator;
import com.openxu.anim.view.ValueAnimView;

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

    private ValueAnimView animView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_anim_property_height);
        animView = (ValueAnimView)findViewById(R.id.animView);
    }

    public void colorAnim(View v){
        //min API 21
/*        ObjectAnimator anim = ObjectAnimator.ofArgb(animView, "color", Color.BLACK, Color.RED);
        anim.setDuration(3000);
        anim.start();*/

        ObjectAnimator anim = ObjectAnimator.ofObject(animView, "color", new ColorEvaluator(), Color.BLACK, Color.RED);
        anim.setDuration(3000);
        anim.start();
    }



}
