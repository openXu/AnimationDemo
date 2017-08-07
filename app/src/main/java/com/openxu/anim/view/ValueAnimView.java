package com.openxu.anim.view;

import android.animation.ValueAnimator;
import android.content.Context;
import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.Paint;
import android.graphics.Point;
import android.graphics.PointF;
import android.util.AttributeSet;
import android.view.View;

/**
 * autour: openXu
 * date: 2017/6/2 10:36
 * blog : http://blog.csdn.net/xmxkf
 * gitHub : https://github.com/openXu
 * className: ValueAnimView
 * version:
 * description: ValueAnimator高级使用--自定义控件
 */
public class  ValueAnimView extends View {
    public static final float RADIUS = 100;
    private MyPoint currentPoint;
    private Paint mPaint;

    public ValueAnimView(Context context, AttributeSet attrs) {
        super(context, attrs);
        mPaint = new Paint(Paint.ANTI_ALIAS_FLAG);
        mPaint.setColor(Color.BLUE);
    }

    private int color;
    public int getColor() {
        return color;
    }
    public void setColor(int color) {
        this.color = color;
        mPaint.setColor(color);
        invalidate();
    }

    @Override
    protected void onDraw(Canvas canvas) {
        if (currentPoint == null) {
            currentPoint = new MyPoint(RADIUS, RADIUS);
            drawCircle(canvas);
            startAnimation();
        } else {
            drawCircle(canvas);
        }
    }
    //在制定的点绘制一个圆
    private void drawCircle(Canvas canvas) {
        canvas.drawCircle(currentPoint.getX(), currentPoint.getY(), RADIUS, mPaint);
    }
    private void startAnimation() {
        MyPoint startPoint = new MyPoint(RADIUS, RADIUS);
        MyPoint endPoint = new MyPoint(getWidth() - RADIUS, getHeight() - RADIUS);
        ValueAnimator anim = ValueAnimator.ofObject(new PointEvaluator(), startPoint, endPoint);
        anim.addUpdateListener(new ValueAnimator.AnimatorUpdateListener() {
            @Override
            public void onAnimationUpdate(ValueAnimator animation) {
                //点位值变化后，重绘
                currentPoint = (MyPoint) animation.getAnimatedValue();
                invalidate();
            }
        });
        anim.setDuration(5000);
        anim.start();
    }

}