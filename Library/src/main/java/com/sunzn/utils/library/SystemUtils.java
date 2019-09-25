package com.sunzn.utils.library;

import android.app.Activity;
import android.content.ContentResolver;
import android.content.Context;
import android.content.Intent;
import android.location.LocationManager;
import android.net.Uri;
import android.provider.Settings;

import java.util.List;

public class SystemUtils {

    /**
     * ╔════════════════════════════════════════════════════════════════════════════════════════════
     * ║ 名称：打开手机 WIFI 设置界面
     * ╟────────────────────────────────────────────────────────────────────────────────────────────
     * ║ 参数：context 上下文
     * ╚════════════════════════════════════════════════════════════════════════════════════════════
     */
    public static void openWifiSetting(Context context) {
        Intent intent = new Intent(Settings.ACTION_WIFI_SETTINGS);
        context.startActivity(intent);
    }

    /**
     * ╔════════════════════════════════════════════════════════════════════════════════════════════
     * ║ 名称：启动当前应用设置页面
     * ╟────────────────────────────────────────────────────────────────────────────────────────────
     * ║ 参数：context     上下文
     * ║ 参数：packageName 应用包名
     * ╚════════════════════════════════════════════════════════════════════════════════════════════
     */
    public static void openAppSettings(Context context, String packageName) {
        Intent intent = new Intent(Settings.ACTION_APPLICATION_DETAILS_SETTINGS);
        intent.setData(Uri.parse("package:" + packageName));
        context.startActivity(intent);
    }

    /**
     * ╔════════════════════════════════════════════════════════════════════════════════════════════
     * ║ 名称：检测 GPS 是否打开
     * ╟────────────────────────────────────────────────────────────────────────────────────────────
     * ║ 参数：context     上下文
     * ╚════════════════════════════════════════════════════════════════════════════════════════════
     */
    public static boolean isGpsEnabled(Context context) {
        LocationManager lm = (LocationManager) context.getSystemService(Context.LOCATION_SERVICE);
        List<String> accessibleProviders = lm.getProviders(true);
        for (String name : accessibleProviders) {
            if ("gps".equals(name)) {
                return true;
            }
        }
        return false;
    }

    /**
     * ╔════════════════════════════════════════════════════════════════════════════════════════════
     * ║ 名称：获取屏幕的亮度
     * ╟────────────────────────────────────────────────────────────────────────────────────────────
     * ║ 参数：activity     上下文
     * ╚════════════════════════════════════════════════════════════════════════════════════════════
     */
    public static int getScreenBrightness(Activity activity) {
        int nowBrightnessValue = 0;
        ContentResolver resolver = activity.getContentResolver();
        try {
            nowBrightnessValue = Settings.System.getInt(resolver, Settings.System.SCREEN_BRIGHTNESS);
        } catch (Exception e) {
            e.printStackTrace();
        }
        return nowBrightnessValue;
    }

    /**
     * ╔════════════════════════════════════════════════════════════════════════════════════════════
     * ║ 名称：设置亮度（每30递增）
     * ╟────────────────────────────────────────────────────────────────────────────────────────────
     * ║ 参数：activity     上下文
     * ╚════════════════════════════════════════════════════════════════════════════════════════════
     */
    public static void setBrightness(Activity activity) {
        ContentResolver resolver = activity.getContentResolver();
        Uri uri = Settings.System.getUriFor("screen_brightness");
        int nowScreenBri = getScreenBrightness(activity);
        nowScreenBri = nowScreenBri <= 225 ? nowScreenBri + 30 : 30;
        System.out.println("nowScreenBri==" + nowScreenBri);
        Settings.System.putInt(resolver, "screen_brightness", nowScreenBri);
        resolver.notifyChange(uri, null);
    }

}
