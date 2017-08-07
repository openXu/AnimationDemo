package com.openxu.anim.view;

import android.animation.FloatEvaluator;
import android.animation.TypeEvaluator;
import android.graphics.Point;

/**
 * autour: openXu
 * date: 2017/6/2 10:36
 * blog : http://blog.csdn.net/xmxkf
 * gitHub : https://github.com/openXu
 * className: PointEvaluator
 * version:
 * description: MyPoint点动画值计算器
 */
public class PointEvaluator implements TypeEvaluator {
    @Override
    public Object evaluate(float fraction, Object startValue, Object endValue) {
        MyPoint startPoint = (MyPoint) startValue;   //初始值
        MyPoint endPoint = (MyPoint) endValue;       //结束值
        float x = startPoint.getX() + fraction * (endPoint.getX() - startPoint.getX());
        float y = startPoint.getY() + fraction * (endPoint.getY() - startPoint.getY());
        MyPoint point = new MyPoint(x, y);
        return point;
    }
}