package com.openxu.anim.view;

import android.animation.TypeEvaluator;
import android.graphics.Color;

/**
 * autour: openXu
 * date: 2017/6/2 10:36
 * blog : http://blog.csdn.net/xmxkf
 * gitHub : https://github.com/openXu
 * className: ColorEvaluator
 * version:
 * description: 颜色动画值计算器
 */
public class ColorEvaluator implements TypeEvaluator {

    private int mCurrentRed = -1;
    private int mCurrentGreen = -1;
    private int mCurrentBlue = -1;
    @Override
    public Object evaluate(float fraction, Object startValue, Object endValue) {
        int startColor = (int) startValue;
        int endColor = (int) endValue;
        int startRed = Color.red(startColor);
        int startGreen = Color.green(startColor);
        int startBlue = Color.blue(startColor);
        int endRed = Color.red(endColor);
        int endGreen = Color.green(endColor);
        int endBlue = Color.blue(endColor);
        // 初始化颜色的值
        if (mCurrentRed == -1) {
            mCurrentRed = startRed;
        }
        if (mCurrentGreen == -1) {
            mCurrentGreen = startGreen;
        }
        if (mCurrentBlue == -1) {
            mCurrentBlue = startBlue;
        }
        // 计算初始颜色和结束颜色之间的差值
        int redDiff = Math.abs(startRed - endRed);
        int greenDiff = Math.abs(startGreen - endGreen);
        int blueDiff = Math.abs(startBlue - endBlue);
        int colorDiff = redDiff + greenDiff + blueDiff;
        if (mCurrentRed != endRed) {
            mCurrentRed = getCurrentColor(startRed, endRed, colorDiff, 0, fraction);
        } else if (mCurrentGreen != endGreen) {
            mCurrentGreen = getCurrentColor(startGreen, endGreen, colorDiff, redDiff, fraction);
        } else if (mCurrentBlue != endBlue) {
            mCurrentBlue = getCurrentColor(startBlue, endBlue, colorDiff,  redDiff + greenDiff, fraction);
        }
        return   Color.argb(255,mCurrentRed, mCurrentGreen,  mCurrentBlue);
    }

    /**
     * 根据fraction值来计算当前的颜色。
     */
    private int getCurrentColor(int startColor, int endColor, int colorDiff,
                                int offset, float fraction) {
        int currentColor;
        if (startColor > endColor) {
            currentColor = (int) (startColor - (fraction * colorDiff - offset));
            if (currentColor < endColor) {
                currentColor = endColor;
            }
        } else {
            currentColor = (int) (startColor + (fraction * colorDiff - offset));
            if (currentColor > endColor) {
                currentColor = endColor;
            }
        }
        return currentColor;
    }

}