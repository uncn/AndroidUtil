package com.sunzn.utils.library;

import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.content.IntentFilter;

/**
 * Created by sunzn on 2016/12/8.
 */

public class BroadcastUtils {

    private BroadcastUtils() {
        throw new RuntimeException("Stub!");
    }

    /**
     * ╔════════════════════════════════════════════════════════════════════════════════════════════
     * ║ 名称：发送本地广播
     * ╟────────────────────────────────────────────────────────────────────────────────────────────
     * ║ 参数：context  上下文
     * ║ 参数：intent   广播意图
     * ╟────────────────────────────────────────────────────────────────────────────────────────────
     * ║ 返回：void
     * ╚════════════════════════════════════════════════════════════════════════════════════════════
     */
    public static void sendLocalBroadcast(Context context, Intent intent) {
        if (context != null && intent != null) {
            LocalBroadcastManager.getInstance(context).sendBroadcast(intent);
        }
    }

    /**
     * ╔════════════════════════════════════════════════════════════════════════════════════════════
     * ║ 名称：发送本地广播
     * ╟────────────────────────────────────────────────────────────────────────────────────────────
     * ║ 参数：context  上下文
     * ║ 参数：action   广播动作
     * ╟────────────────────────────────────────────────────────────────────────────────────────────
     * ║ 返回：void
     * ╚════════════════════════════════════════════════════════════════════════════════════════════
     */
    public static void sendLocalBroadcast(Context context, String action) {
        if (context != null && action != null) {
            Intent intent = new Intent(action);
            LocalBroadcastManager.getInstance(context).sendBroadcast(intent);
        }
    }

    /**
     * ╔════════════════════════════════════════════════════════════════════════════════════════════
     * ║ 名称：注册本地广播接收者
     * ╟────────────────────────────────────────────────────────────────────────────────────────────
     * ║ 参数：context  上下文
     * ║ 参数：receiver 广播接收者
     * ║ 参数：filter   过滤器
     * ╟────────────────────────────────────────────────────────────────────────────────────────────
     * ║ 返回：void
     * ╚════════════════════════════════════════════════════════════════════════════════════════════
     */
    public static void registerLocalReceiver(Context context, BroadcastReceiver receiver, IntentFilter filter) {
        if (context != null && receiver != null && filter != null) {
            LocalBroadcastManager.getInstance(context).registerReceiver(receiver, filter);
        }
    }

    /**
     * ╔════════════════════════════════════════════════════════════════════════════════════════════
     * ║ 名称：注销本地广播接收者
     * ╟────────────────────────────────────────────────────────────────────────────────────────────
     * ║ 参数：context  上下文
     * ║ 参数：receiver 广播接收者
     * ╟────────────────────────────────────────────────────────────────────────────────────────────
     * ║ 返回：void
     * ╚════════════════════════════════════════════════════════════════════════════════════════════
     */
    public static void unregisterLocalReceiver(Context context, BroadcastReceiver receiver) {
        if (context != null && receiver != null) {
            LocalBroadcastManager.getInstance(context).unregisterReceiver(receiver);
        }
    }

    /**
     * ╔════════════════════════════════════════════════════════════════════════════════════════════
     * ║ 名称：发送全局广播
     * ╟────────────────────────────────────────────────────────────────────────────────────────────
     * ║ 参数：context  上下文
     * ║ 参数：intent   广播意图
     * ╟────────────────────────────────────────────────────────────────────────────────────────────
     * ║ 返回：void
     * ╚════════════════════════════════════════════════════════════════════════════════════════════
     */
    public static void sendGlobalBroadcast(Context context, Intent intent) {
        if (context != null && intent != null) {
            context.sendBroadcast(intent);
        }
    }

    /**
     * ╔════════════════════════════════════════════════════════════════════════════════════════════
     * ║ 名称：发送本地广播
     * ╟────────────────────────────────────────────────────────────────────────────────────────────
     * ║ 参数：context  上下文
     * ║ 参数：action   广播动作
     * ╟────────────────────────────────────────────────────────────────────────────────────────────
     * ║ 返回：void
     * ╚════════════════════════════════════════════════════════════════════════════════════════════
     */
    public static void sendGlobalBroadcast(Context context, String action) {
        if (context != null && action != null) {
            Intent intent = new Intent(action);
            context.sendBroadcast(intent);
        }
    }

    /**
     * ╔════════════════════════════════════════════════════════════════════════════════════════════
     * ║ 名称：注册全局广播接收者
     * ╟────────────────────────────────────────────────────────────────────────────────────────────
     * ║ 参数：context  上下文
     * ║ 参数：receiver 广播接收者
     * ║ 参数：filter   过滤器
     * ╟────────────────────────────────────────────────────────────────────────────────────────────
     * ║ 返回：void
     * ╚════════════════════════════════════════════════════════════════════════════════════════════
     */
    public static void registerGlobalReceiver(Context context, BroadcastReceiver receiver, IntentFilter filter) {
        if (context != null && receiver != null && filter != null) {
            context.registerReceiver(receiver, filter);
        }
    }

    /**
     * ╔════════════════════════════════════════════════════════════════════════════════════════════
     * ║ 名称：注销全局广播接收者
     * ╟────────────────────────────────────────────────────────────────────────────────────────────
     * ║ 参数：context  上下文
     * ║ 参数：receiver 广播接收者
     * ╟────────────────────────────────────────────────────────────────────────────────────────────
     * ║ 返回：void
     * ╚════════════════════════════════════════════════════════════════════════════════════════════
     */
    public static void unregisterGlobalReceiver(Context context, BroadcastReceiver receiver) {
        if (context != null && receiver != null) {
            context.unregisterReceiver(receiver);
        }
    }

}
