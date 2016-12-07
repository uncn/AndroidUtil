package com.sunzn.utils.library;

import android.content.Context;
import android.content.SharedPreferences;

import java.util.Map;

public class SPUtils {

    private SPUtils() {
        super();
    }

    /**
     * ╔════════════════════════════════════════════════════════════════════════════════════════════
     * ║ 名称：获取 SP 中的 String 值
     * ╟────────────────────────────────────────────────────────────────────────────────────────────
     * ║ 参数：context
     * ║ 参数：name
     * ║ 参数：key
     * ║ 参数：defValue
     * ╟────────────────────────────────────────────────────────────────────────────────────────────
     * ║ 返回：String 值
     * ╚════════════════════════════════════════════════════════════════════════════════════════════
     */
    public static String getString(Context context, String name, String key, String defValue) {
        SharedPreferences preferences = context.getSharedPreferences(name, Context.MODE_PRIVATE);
        return preferences.getString(key, defValue);
    }

    /**
     * ╔════════════════════════════════════════════════════════════════════════════════════════════
     * ║ 名称：将 String 值压入 SP 中
     * ╟────────────────────────────────────────────────────────────────────────────────────────────
     * ║ 参数：context
     * ║ 参数：name
     * ║ 参数：key
     * ║ 参数：value
     * ╟────────────────────────────────────────────────────────────────────────────────────────────
     * ║ 返回：void
     * ╚════════════════════════════════════════════════════════════════════════════════════════════
     */
    public static void putString(Context context, String name, String key, String value) {
        SharedPreferences preferences = context.getSharedPreferences(name, Context.MODE_PRIVATE);
        preferences.edit().putString(key, value).apply();
    }

    /**
     * ╔════════════════════════════════════════════════════════════════════════════════════════════
     * ║ 名称：获取 SP 中的 int 值
     * ╟────────────────────────────────────────────────────────────────────────────────────────────
     * ║ 参数：context
     * ║ 参数：name
     * ║ 参数：key
     * ║ 参数：defValue
     * ╟────────────────────────────────────────────────────────────────────────────────────────────
     * ║ 返回：int 值
     * ╚════════════════════════════════════════════════════════════════════════════════════════════
     */
    public static int getInt(Context context, String name, String key, int defValue) {
        SharedPreferences preferences = context.getSharedPreferences(name, Context.MODE_PRIVATE);
        return preferences.getInt(key, defValue);
    }

    /**
     * ╔════════════════════════════════════════════════════════════════════════════════════════════
     * ║ 名称：将 int 值压入 SP 中
     * ╟────────────────────────────────────────────────────────────────────────────────────────────
     * ║ 参数：context
     * ║ 参数：name
     * ║ 参数：key
     * ║ 参数：value
     * ╟────────────────────────────────────────────────────────────────────────────────────────────
     * ║ 返回：void
     * ╚════════════════════════════════════════════════════════════════════════════════════════════
     */
    public static void putInt(Context context, String name, String key, int value) {
        SharedPreferences preferences = context.getSharedPreferences(name, Context.MODE_PRIVATE);
        preferences.edit().putInt(key, value).apply();
    }

    /**
     * ╔════════════════════════════════════════════════════════════════════════════════════════════
     * ║ 名称：获取 SP 中的 Boolean 值
     * ╟────────────────────────────────────────────────────────────────────────────────────────────
     * ║ 参数：context
     * ║ 参数：name
     * ║ 参数：key
     * ║ 参数：defValue
     * ╟────────────────────────────────────────────────────────────────────────────────────────────
     * ║ 返回：Boolean 值
     * ╚════════════════════════════════════════════════════════════════════════════════════════════
     */
    public static boolean getBoolean(Context context, String name, String key, boolean defValue) {
        SharedPreferences preferences = context.getSharedPreferences(name, Context.MODE_PRIVATE);
        return preferences.getBoolean(key, defValue);
    }

    /**
     * ╔════════════════════════════════════════════════════════════════════════════════════════════
     * ║ 名称：将 Boolean 值压入 SP 中
     * ╟────────────────────────────────────────────────────────────────────────────────────────────
     * ║ 参数：context
     * ║ 参数：name
     * ║ 参数：key
     * ║ 参数：value
     * ╟────────────────────────────────────────────────────────────────────────────────────────────
     * ║ 返回：void
     * ╚════════════════════════════════════════════════════════════════════════════════════════════
     */
    public static void putBoolean(Context context, String name, String key, boolean value) {
        SharedPreferences preferences = context.getSharedPreferences(name, Context.MODE_PRIVATE);
        preferences.edit().putBoolean(key, value).apply();
    }

    /**
     * ╔════════════════════════════════════════════════════════════════════════════════════════════
     * ║ 名称：获取 SP 中的 Long 值
     * ╟────────────────────────────────────────────────────────────────────────────────────────────
     * ║ 参数：context
     * ║ 参数：name
     * ║ 参数：key
     * ║ 参数：defValue
     * ╟────────────────────────────────────────────────────────────────────────────────────────────
     * ║ 返回：Long 值
     * ╚════════════════════════════════════════════════════════════════════════════════════════════
     */
    public static long getLong(Context context, String name, String key, long defValue) {
        SharedPreferences preferences = context.getSharedPreferences(name, Context.MODE_PRIVATE);
        return preferences.getLong(key, defValue);
    }

    /**
     * ╔════════════════════════════════════════════════════════════════════════════════════════════
     * ║ 名称：将 Long 值压入 SP 中
     * ╟────────────────────────────────────────────────────────────────────────────────────────────
     * ║ 参数：context
     * ║ 参数：name
     * ║ 参数：key
     * ║ 参数：value
     * ╟────────────────────────────────────────────────────────────────────────────────────────────
     * ║ 返回：void
     * ╚════════════════════════════════════════════════════════════════════════════════════════════
     */
    public static void putLong(Context context, String name, String key, long value) {
        SharedPreferences preferences = context.getSharedPreferences(name, Context.MODE_PRIVATE);
        preferences.edit().putLong(key, value).apply();
    }

    /**
     * ╔════════════════════════════════════════════════════════════════════════════════════════════
     * ║ 名称：获取 SP 中的 Float 值
     * ╟────────────────────────────────────────────────────────────────────────────────────────────
     * ║ 参数：context
     * ║ 参数：name
     * ║ 参数：key
     * ║ 参数：defValue
     * ╟────────────────────────────────────────────────────────────────────────────────────────────
     * ║ 返回：Long 值
     * ╚════════════════════════════════════════════════════════════════════════════════════════════
     */
    public static float getFloat(Context context, String name, String key, Float defValue) {
        SharedPreferences preferences = context.getSharedPreferences(name, Context.MODE_PRIVATE);
        return preferences.getFloat(key, defValue);
    }

    /**
     * ╔════════════════════════════════════════════════════════════════════════════════════════════
     * ║ 名称：将 Float 值压入 SP 中
     * ╟────────────────────────────────────────────────────────────────────────────────────────────
     * ║ 参数：context
     * ║ 参数：name
     * ║ 参数：key
     * ║ 参数：value
     * ╟────────────────────────────────────────────────────────────────────────────────────────────
     * ║ 返回：void
     * ╚════════════════════════════════════════════════════════════════════════════════════════════
     */
    public static void putFloat(Context context, String name, String key, float value) {
        SharedPreferences preferences = context.getSharedPreferences(name, Context.MODE_PRIVATE);
        preferences.edit().putFloat(key, value).apply();
    }

    /**
     * ╔════════════════════════════════════════════════════════════════════════════════════════════
     * ║ 名称：获取 SP 中的所有键值对
     * ╟────────────────────────────────────────────────────────────────────────────────────────────
     * ║ 参数：context
     * ║ 参数：name
     * ╟────────────────────────────────────────────────────────────────────────────────────────────
     * ║ 返回：Map
     * ╚════════════════════════════════════════════════════════════════════════════════════════════
     */
    public static Map<String, ?> getAll(Context context, String name) {
        SharedPreferences preferences = context.getSharedPreferences(name, Context.MODE_PRIVATE);
        return preferences.getAll();
    }

    /**
     * ╔════════════════════════════════════════════════════════════════════════════════════════════
     * ║ 名称：移除 SP 中对应的 Key
     * ╟────────────────────────────────────────────────────────────────────────────────────────────
     * ║ 参数：context
     * ║ 参数：name
     * ║ 参数：key
     * ╟────────────────────────────────────────────────────────────────────────────────────────────
     * ║ 返回：void
     * ╚════════════════════════════════════════════════════════════════════════════════════════════
     */
    public static void remove(Context context, String name, String key) {
        SharedPreferences preferences = context.getSharedPreferences(name, Context.MODE_PRIVATE);
        preferences.edit().remove(key).apply();
    }

    /**
     * ╔════════════════════════════════════════════════════════════════════════════════════════════
     * ║ 名称：检测 SP 中 Key 是否存在
     * ╟────────────────────────────────────────────────────────────────────────────────────────────
     * ║ 参数：context
     * ║ 参数：name
     * ║ 参数：key
     * ╟────────────────────────────────────────────────────────────────────────────────────────────
     * ║ 返回：Boolean
     * ╚════════════════════════════════════════════════════════════════════════════════════════════
     */
    public static boolean contains(Context context, String name, String key) {
        SharedPreferences preferences = context.getSharedPreferences(name, Context.MODE_PRIVATE);
        return preferences.contains(key);
    }

    /**
     * ╔════════════════════════════════════════════════════════════════════════════════════════════
     * ║ 名称：清空 SP 中的所有数据
     * ╟────────────────────────────────────────────────────────────────────────────────────────────
     * ║ 参数：context
     * ║ 参数：name
     * ╟────────────────────────────────────────────────────────────────────────────────────────────
     * ║ 返回：void
     * ╚════════════════════════════════════════════════════════════════════════════════════════════
     */
    public static void clear(Context context, String name) {
        SharedPreferences preferences = context.getSharedPreferences(name, Context.MODE_PRIVATE);
        preferences.edit().clear().apply();
    }

}
