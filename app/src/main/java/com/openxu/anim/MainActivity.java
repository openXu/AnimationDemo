package com.openxu.anim;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;

import com.openxu.anim.anim.AnimationiActivity;

public class MainActivity extends AppCompatActivity {


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
    }

    //动画学习
    public void animation(View v){
        startActivity(new Intent(this, AnimationiActivity.class));
    }
    //插值器使用
    public void interpolatorTest(View v){
        startActivity(new Intent(this, InterpolatorActivity.class));
    }



}
