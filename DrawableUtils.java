package com.lvwee.googleplay.utils;

import android.graphics.drawable.Drawable;
import android.graphics.drawable.GradientDrawable;
import android.graphics.drawable.StateListDrawable;

/**
 * Created by Administrator on 2017/12/17 0017.
 */

public class DrawableUtils {

    //设置背景Drawable
    public static GradientDrawable getGradientDrawable(int color, int radius) {

        //xml中定义的shape标签对应此类
        GradientDrawable shape = new GradientDrawable();
        shape.setShape(GradientDrawable.RECTANGLE);

        shape.setColor(color);
        shape.setCornerRadius(radius);
        return shape;
    }

    //设置TextView的点击效果
    public static StateListDrawable getSelector(Drawable normal, Drawable press) {

        StateListDrawable stateListDrawable = new StateListDrawable();
        stateListDrawable.addState(new int[]{android.R.attr.state_pressed}, press);//按下状态
        stateListDrawable.addState(new int[]{}, normal);//默认图片
        return stateListDrawable;
    }

    //设置TextView的点击效果
    public static StateListDrawable getSelector(int normalColor, int pressColor, int radius) {

        GradientDrawable normalDrawable = getGradientDrawable(normalColor, radius);
        GradientDrawable pressDrawable = getGradientDrawable(pressColor, radius);
        StateListDrawable selector = getSelector(normalDrawable, pressDrawable);
        return selector;
    }
}
