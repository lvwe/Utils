package com.lvwee.googleplay.utils;

import android.content.Context;
import android.content.res.ColorStateList;
import android.graphics.drawable.Drawable;
import android.os.Handler;
import android.view.View;

import com.lvwee.googleplay.global.GooglePlayApplication;

/**
 * Created by Administrator on 2017/12/12 0012.
 */

public class UIUtils {

    public static Context getContext() {

        return GooglePlayApplication.getContext();
    }

    public static Handler getHandler() {
        return GooglePlayApplication.getHandler();
    }

    public static int getMainThreadId() {
        return GooglePlayApplication.getMainThreadId();
    }

    public static String getString(int id){
        return getContext().getResources().getString(id);
    }

    public static String[] getStringArray(int id){
        return getContext().getResources().getStringArray(id);
    }

    public static Drawable getDrawable(int id){
        return getContext().getResources().getDrawable(id);
    }

    public static int getColor(int id){
        return getContext().getResources().getColor(id);
    }

    public static ColorStateList getColorStateList(int id){
        return getContext().getResources().getColorStateList(id);
    }

    public static int getDimen(int id){
        return getContext().getResources().getDimensionPixelSize(id);
    }

    public static int dip2px(float dip){
        float density = getContext().getResources().getDisplayMetrics().density;
        return (int) (dip * density + 0.5f);
    }

    public static float px2dip(float px){
        float density = getContext().getResources().getDisplayMetrics().density;
        return px / density;
    }

    public static View inflate(int id){
        return View.inflate(getContext(),id,null);
    }

    public static boolean  isRunOnUiTheard(){
        int myTid = (int) Thread.currentThread().getId();
        if (myTid == getMainThreadId()){
            return true;
        }
        return false;
    }

    //运行在主线程的方法
    public static void runOnUiThread(Runnable r){
        if (isRunOnUiTheard()){
            // 如果是主线程 直接运行
            r.run();
        }else {
            // 如果是子线程，借助Handler让其运行在主线程
            getHandler().post(r);
        }
    }
}
