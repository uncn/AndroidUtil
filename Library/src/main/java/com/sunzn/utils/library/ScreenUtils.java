package com.sunzn.utils.library;

import android.app.Activity;
import android.app.KeyguardManager;
import android.content.Context;
import android.content.pm.ActivityInfo;
import android.content.res.Configuration;
import android.graphics.Bitmap;
import android.util.DisplayMetrics;
import android.view.Surface;
import android.view.View;
import android.view.WindowManager;

import com.sunzn.utils.library.EntityUtils.Screen;

/**
 * Created by sunzn on 2016/12/6.
 */

public class ScreenUtils {

    private ScreenUtils() {
        throw new RuntimeException("Stub!");
    }

    /**
     * ╔════════════════════════════════════════════════════════════════════════════════════════════
     * ║ 名称：获取屏幕的宽度 (单位：px)
     * ╟────────────────────────────────────────────────────────────────────────────────────────────
     * ║ 参数：context
     * ╟────────────────────────────────────────────────────────────────────────────────────────────
     * ║ 返回：屏幕宽度
     * ╚════════════════════════════════════════════════════════════════════════════════════════════
     */
    public static int getScreenWidth(Context context) {
        context = context.getApplicationContext();
        WindowManager manager = (WindowManager) context.getSystemService(Context.WINDOW_SERVICE);
        DisplayMetrics dm = new DisplayMetrics();     // 创建了一张白纸
        manager.getDefaultDisplay().getMetrics(dm);   // 给白纸设置宽高
        return dm.widthPixels;
    }

    /**
     * ╔════════════════════════════════════════════════════════════════════════════════════════════
     * ║ 名称：获取屏幕的高度 (单位：px)
     * ╟────────────────────────────────────────────────────────────────────────────────────────────
     * ║ 参数：context
     * ╟────────────────────────────────────────────────────────────────────────────────────────────
     * ║ 返回：屏幕高度
     * ╚════════════════════════════════════════════════════════════════════════════════════════════
     */
    public static int getScreenHeight(Context context) {
        context = context.getApplicationContext();
        WindowManager manager = (WindowManager) context.getSystemService(Context.WINDOW_SERVICE);
        DisplayMetrics dm = new DisplayMetrics();     // 创建了一张白纸
        manager.getDefaultDisplay().getMetrics(dm);   // 给白纸设置宽高
        return dm.heightPixels;
    }

    /**
     * ╔════════════════════════════════════════════════════════════════════════════════════════════
     * ║ 名称：获取屏幕宽 (单位：px)、高 (单位：px)、密度
     * ╟────────────────────────────────────────────────────────────────────────────────────────────
     * ║ 参数：context
     * ╟────────────────────────────────────────────────────────────────────────────────────────────
     * ║ 返回：屏幕实体类
     * ╚════════════════════════════════════════════════════════════════════════════════════════════
     */
    public static Screen getScreenInfo(Context context) {
        context = context.getApplicationContext();
        WindowManager manager = (WindowManager) context.getSystemService(Context.WINDOW_SERVICE);
        DisplayMetrics dm = new DisplayMetrics();
        manager.getDefaultDisplay().getMetrics(dm);
        return new Screen(dm.widthPixels, dm.heightPixels, dm.densityDpi);
    }

    /**
     * ╔════════════════════════════════════════════════════════════════════════════════════════════
     * ║ 名称：设置屏幕为横屏
     * ╟────────────────────────────────────────────────────────────────────────────────────────────
     * ║ 参数：activity
     * ╟────────────────────────────────────────────────────────────────────────────────────────────
     * ║ 返回：void
     * ╟────────────────────────────────────────────────────────────────────────────────────────────
     * ║ 说明：1、还有一种就是在 Activity 中加属性 android:screenOrientation="landscape"，
     * ║
     * ║      2、不设置 Activity 的android:configChanges 时，切屏会重新调用各个生命周期，切横屏时会执行一次，
     * ║      切竖屏时会执行两次；
     * ║
     * ║      3、设置 Activity 的 android:configChanges="orientation" 时，切屏还是会重新调用各个生命周期，
     * ║      切横、竖屏时只会执行一次；
     * ║
     * ║      4、设置 Activity 的 android:configChanges="orientation|keyboardHidden|screenSize"（4.0
     * ║      以上必须带最后一个参数）时切屏不会重新调用各个生命周期，只会执行onConfigurationChanged 方法
     * ╚════════════════════════════════════════════════════════════════════════════════════════════
     */
    public static void setLandscape(Activity activity) {
        activity.setRequestedOrientation(ActivityInfo.SCREEN_ORIENTATION_LANDSCAPE);
    }

    /**
     * ╔════════════════════════════════════════════════════════════════════════════════════════════
     * ║ 名称：设置屏幕为竖屏
     * ╟────────────────────────────────────────────────────────────────────────────────────────────
     * ║ 参数：activity
     * ╟────────────────────────────────────────────────────────────────────────────────────────────
     * ║ 返回：void
     * ╚════════════════════════════════════════════════════════════════════════════════════════════
     */
    public static void setPortrait(Activity activity) {
        activity.setRequestedOrientation(ActivityInfo.SCREEN_ORIENTATION_PORTRAIT);
    }

    /**
     * ╔════════════════════════════════════════════════════════════════════════════════════════════
     * ║ 名称：判断是否横屏
     * ╟────────────────────────────────────────────────────────────────────────────────────────────
     * ║ 参数：context
     * ╟────────────────────────────────────────────────────────────────────────────────────────────
     * ║ 返回：boolean {true:是} {false:否}
     * ╚════════════════════════════════════════════════════════════════════════════════════════════
     */
    public static boolean isLandscape(Context context) {
        return context.getResources().getConfiguration().orientation == Configuration.ORIENTATION_LANDSCAPE;
    }

    /**
     * ╔════════════════════════════════════════════════════════════════════════════════════════════
     * ║ 名称：判断是否竖屏
     * ╟────────────────────────────────────────────────────────────────────────────────────────────
     * ║ 参数：context
     * ╟────────────────────────────────────────────────────────────────────────────────────────────
     * ║ 返回：boolean {true:是} {false:否}
     * ╚════════════════════════════════════════════════════════════════════════════════════════════
     */
    public static boolean isPortrait(Context context) {
        return context.getResources().getConfiguration().orientation == Configuration.ORIENTATION_PORTRAIT;
    }

    /**
     * ╔════════════════════════════════════════════════════════════════════════════════════════════
     * ║ 名称：获取屏幕旋转角度
     * ╟────────────────────────────────────────────────────────────────────────────────────────────
     * ║ 参数：activity
     * ╟────────────────────────────────────────────────────────────────────────────────────────────
     * ║ 返回：屏幕旋转角度
     * ╚════════════════════════════════════════════════════════════════════════════════════════════
     */
    public static int getScreenRotation(Activity activity) {
        switch (activity.getWindowManager().getDefaultDisplay().getRotation()) {
            default:
            case Surface.ROTATION_0:
                return 0;
            case Surface.ROTATION_90:
                return 90;
            case Surface.ROTATION_180:
                return 180;
            case Surface.ROTATION_270:
                return 270;
        }
    }

    /**
     * ╔════════════════════════════════════════════════════════════════════════════════════════════
     * ║ 名称：获取当前屏幕截图，包含状态栏
     * ╟────────────────────────────────────────────────────────────────────────────────────────────
     * ║ 参数：activity
     * ╟────────────────────────────────────────────────────────────────────────────────────────────
     * ║ 返回：Bitmap
     * ╚════════════════════════════════════════════════════════════════════════════════════════════
     */
    public static Bitmap captureWithStatusBar(Activity activity) {
        View view = activity.getWindow().getDecorView();
        view.setDrawingCacheEnabled(true);
        view.buildDrawingCache();
        Bitmap bmp = view.getDrawingCache();
        DisplayMetrics dm = new DisplayMetrics();
        activity.getWindowManager().getDefaultDisplay().getMetrics(dm);
        Bitmap ret = Bitmap.createBitmap(bmp, 0, 0, dm.widthPixels, dm.heightPixels);
        view.destroyDrawingCache();
        return ret;
    }

    /**
     * ╔════════════════════════════════════════════════════════════════════════════════════════════
     * ║ 名称：获取当前屏幕截图，不包含状态栏
     * ╟────────────────────────────────────────────────────────────────────────────────────────────
     * ║ 参数：activity
     * ╟────────────────────────────────────────────────────────────────────────────────────────────
     * ║ 返回：Bitmap
     * ╚════════════════════════════════════════════════════════════════════════════════════════════
     */
    public static Bitmap captureWithoutStatusBar(Activity activity) {
        View view = activity.getWindow().getDecorView();
        view.setDrawingCacheEnabled(true);
        view.buildDrawingCache();
        Bitmap bmp = view.getDrawingCache();
        int statusBarHeight = BarUtils.getStatusBarHeight(activity);
        DisplayMetrics dm = new DisplayMetrics();
        activity.getWindowManager().getDefaultDisplay().getMetrics(dm);
        Bitmap ret = Bitmap.createBitmap(bmp, 0, statusBarHeight, dm.widthPixels, dm.heightPixels - statusBarHeight);
        view.destroyDrawingCache();
        return ret;
    }

    /**
     * ╔════════════════════════════════════════════════════════════════════════════════════════════
     * ║ 名称：判断是否锁屏
     * ╟────────────────────────────────────────────────────────────────────────────────────────────
     * ║ 参数：context
     * ╟────────────────────────────────────────────────────────────────────────────────────────────
     * ║ 返回：boolean {true:是} {false:否}
     * ╚════════════════════════════════════════════════════════════════════════════════════════════
     */
    public static boolean isScreenLock(Context context) {
        KeyguardManager km = (KeyguardManager) context.getApplicationContext().getSystemService(Context.KEYGUARD_SERVICE);
        return km.inKeyguardRestrictedInputMode();
    }

}
