package com.sunzn.utils.library;

import android.content.Context;
import android.net.ConnectivityManager;
import android.net.NetworkInfo;

/**
 * Created by sunzn on 2016/12/7.
 */

public class NetWorkUtils {

    private NetWorkUtils() {
        throw new RuntimeException("Stub!");
    }

    /**
     * ╔════════════════════════════════════════════════════════════════════════════════════════════
     * ║ 名称：获取活动网络信息
     * ╟────────────────────────────────────────────────────────────────────────────────────────────
     * ║ 参数：context
     * ╟────────────────────────────────────────────────────────────────────────────────────────────
     * ║ 权限：<uses-permission android:name="android.permission.ACCESS_NETWORK_STATE"/>
     * ╟────────────────────────────────────────────────────────────────────────────────────────────
     * ║ 返回：NetworkInfo
     * ╚════════════════════════════════════════════════════════════════════════════════════════════
     */
    private static NetworkInfo getActiveNetworkInfo(Context context) {
        context = context.getApplicationContext();
        ConnectivityManager cm = (ConnectivityManager) context.getSystemService(Context.CONNECTIVITY_SERVICE);
        return cm.getActiveNetworkInfo();
    }

    /**
     * ╔════════════════════════════════════════════════════════════════════════════════════════════
     * ║ 名称：判断网络是否连接
     * ╟────────────────────────────────────────────────────────────────────────────────────────────
     * ║ 参数：context
     * ╟────────────────────────────────────────────────────────────────────────────────────────────
     * ║ 权限：<uses-permission android:name="android.permission.ACCESS_NETWORK_STATE"/>
     * ╟────────────────────────────────────────────────────────────────────────────────────────────
     * ║ 返回：{true ：是} {false ：否}
     * ╚════════════════════════════════════════════════════════════════════════════════════════════
     */
    public static boolean isConnected(Context context) {
        NetworkInfo info = getActiveNetworkInfo(context);
        return info != null && info.isConnected();
    }

}
