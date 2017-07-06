package com.openxu.anim.anim;

import android.app.DatePickerDialog;
import android.app.Dialog;
import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.DatePicker;

import com.openxu.anim.R;

import java.util.Calendar;

/** 
 * autour: openXu
 * date: 2017/6/2 10:36
 * blog : http://blog.csdn.net/xmxkf
 * gitHub : https://github.com/openXu
 * className: AnimationiActivity
 * version: 
 * description: 各种动画
 */
public class AnimationiActivity extends AppCompatActivity {


    private View frameView, view;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_animation);
        frameView = findViewById(R.id.frameView);
        view = findViewById(R.id.view);
        mCalendar = java.util.Calendar.getInstance();
    }

    //帧动画
    public void frameAnim(View v){
        startActivity(new Intent(this, FrameAnimActivity.class));
    }
    //补间动画
    public void tweenAnim(View v){
//        startActivity(new Intent(this, TweenAnimActivity.class));
        Dialog dateDialog = new DatePickerDialog(this,
//                R.style.SDISPickerDateDialogTheme,
                android.R.style.Theme_Holo_Dialog,
                mDateSetListener,
                mCalendar.get(Calendar.YEAR),
                mCalendar.get(Calendar.MONTH),
                mCalendar.get(Calendar.DAY_OF_MONTH));
        dateDialog.setTitle("神挡杀神多所多");
        dateDialog.show();
    }
    private java.util.Calendar mCalendar;
    private DatePickerDialog.OnDateSetListener mDateSetListener = new DatePickerDialog.OnDateSetListener() {
        /**
         * @param view        The view associated with this listener.
         * @param year        The year that was set.
         * @param monthOfYear The month that was set (0-11) for compatibility
         *                    with {@link java.util.Calendar}.
         * @param dayOfMonth  The day of the month that was set.
         */
        @Override
        public void onDateSet(DatePicker view, int year, int monthOfYear, int dayOfMonth) {
            mCalendar.set(java.util.Calendar.YEAR, year);
            mCalendar.set(java.util.Calendar.MONTH, monthOfYear);
            mCalendar.set(java.util.Calendar.DAY_OF_MONTH, dayOfMonth);
        }
    };
}
