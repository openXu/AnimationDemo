package com.openxu.anim;

import android.graphics.drawable.AnimationDrawable;
import android.graphics.drawable.Drawable;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;

import com.openxu.anim.R;

/** 
 * autour: openXu
 * date: 2017/6/2 10:36
 * blog : http://blog.csdn.net/xmxkf
 * gitHub : https://github.com/openXu
 * className: FrameAnimActivity
 * version: 
 * description: 帧动画的运用
 */
public class FrameAnimActivity extends AppCompatActivity {

    private View frameView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_anim_frame);
        frameView = findViewById(R.id.frameView);
    }

    //开始动画
    public void runAnim(View v){
        AnimationDrawable anim = (AnimationDrawable) frameView.getBackground(); //获取ImageView背景,此时已被编译成AnimationDrawable
        anim.start();
    }
    //停止动画
    public void stopAnim(View v){
        AnimationDrawable anim = (AnimationDrawable) frameView.getBackground();
        //如果正在运行,就停止
        if (anim.isRunning()) {
            anim.stop();
        }
    }
    //代码方式实现动画
    public void codeAnim(View v){
        AnimationDrawable anim = new AnimationDrawable();
        for (int i = 1; i <= 4; i++) {
            //根据资源名称和目录获取R.java中对应的资源ID
            int id = getResources().getIdentifier("frame" + i, "drawable", getPackageName());
            //根据资源ID获取到Drawable对象
            Drawable drawable = getResources().getDrawable(id);
            //将此帧添加到AnimationDrawable中
            anim.addFrame(drawable, 100);
        }
        //设置动画是否应该播放一次或重复,true为1次
        anim.setOneShot(true);
        //将动画设置为ImageView背景
//        frameView.setBackgroundDrawable(anim);
        frameView.setBackground(anim);
        anim.start();
    }
}
