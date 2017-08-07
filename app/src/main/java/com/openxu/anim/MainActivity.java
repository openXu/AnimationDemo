package com.openxu.anim;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
    }

    //帧动画
    public void frameAnim(View v){
        startActivity(new Intent(this, FrameAnimActivity.class));
    }
    //补间动画
    public void tweenAnim(View v){
        startActivity(new Intent(this, TweenAnimActivity.class));
    }
    //属性动画
    public void propertAnim(View v){
        startActivity(new Intent(this, PropertyAnimActivity.class));
    }
    //属性动画高级
    public void propertAnimHight(View v){
        startActivity(new Intent(this, PropertyAnimHeightActivity.class));
    }
    //补间器
    public void interpolator(View v){
        startActivity(new Intent(this, InterpolatorActivity.class));
    }
}
