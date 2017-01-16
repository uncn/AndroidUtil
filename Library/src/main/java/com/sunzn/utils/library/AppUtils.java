package com.sunzn.utils.library;

import android.content.Context;
import android.content.pm.ApplicationInfo;
import android.content.pm.PackageInfo;
import android.content.pm.PackageManager;
import android.graphics.drawable.Drawable;

public class AppUtils {

    private AppUtils() {
        throw new RuntimeException("Stub!");
    }

    /**
     * ╔════════════════════════════════════════════════════════════════════════════════════════════
     * ║ 名称：获取 APP 包名
     * ╟────────────────────────────────────────────────────────────────────────────────────────────
     * ║ 参数：context 上下文
     * ╟────────────────────────────────────────────────────────────────────────────────────────────
     * ║ 返回：APP 包名
     * ╚════════════════════════════════════════════════════════════════════════════════════════════
     */
    public static String getAppPackageName(Context context) {
        return context.getPackageName();
    }

    /**
     * ╔════════════════════════════════════════════════════════════════════════════════════════════
     * ║ 名称：获取 APP 名称
     * ╟────────────────────────────────────────────────────────────────────────────────────────────
     * ║ 参数：context 上下文
     * ╟────────────────────────────────────────────────────────────────────────────────────────────
     * ║ 返回：APP 名称
     * ╚════════════════════════════════════════════════════════════════════════════════════════════
     */
    public static String getAppName(Context context) {
        return getAppName(context, context.getPackageName());
    }

    /**
     * ╔════════════════════════════════════════════════════════════════════════════════════════════
     * ║ 名称：获取 APP 名称
     * ╟────────────────────────────────────────────────────────────────────────────────────────────
     * ║ 参数：context     上下文
     * ║ 参数：packageName 包名
     * ╟────────────────────────────────────────────────────────────────────────────────────────────
     * ║ 返回：APP 名称
     * ╚════════════════════════════════════════════════════════════════════════════════════════════
     */
    public static String getAppName(Context context, String packageName) {
        if (StringUtils.isEmpty(packageName)) return null;
        try {
            PackageManager pm = context.getPackageManager();
            PackageInfo pi = pm.getPackageInfo(packageName, 0);
            return pi == null ? null : pi.applicationInfo.loadLabel(pm).toString();
        } catch (PackageManager.NameNotFoundException e) {
            return null;
        }
    }

    /**
     * ╔════════════════════════════════════════════════════════════════════════════════════════════
     * ║ 名称：获取 APP 图标
     * ╟────────────────────────────────────────────────────────────────────────────────────────────
     * ║ 参数：context 上下文
     * ╟────────────────────────────────────────────────────────────────────────────────────────────
     * ║ 返回：APP 图标
     * ╚════════════════════════════════════════════════════════════════════════════════════════════
     */
    public static Drawable getAppIcon(Context context) {
        return getAppIcon(context, context.getPackageName());
    }

    /**
     * ╔════════════════════════════════════════════════════════════════════════════════════════════
     * ║ 名称：获取 APP 图标
     * ╟────────────────────────────────────────────────────────────────────────────────────────────
     * ║ 参数：context     上下文
     * ║ 参数：packageName 包名
     * ╟────────────────────────────────────────────────────────────────────────────────────────────
     * ║ 返回：APP 图标
     * ╚════════════════════════════════════════════════════════════════════════════════════════════
     */
    public static Drawable getAppIcon(Context context, String packageName) {
        if (StringUtils.isEmpty(packageName)) return null;
        try {
            PackageManager pm = context.getPackageManager();
            PackageInfo pi = pm.getPackageInfo(packageName, 0);
            return pi == null ? null : pi.applicationInfo.loadIcon(pm);
        } catch (PackageManager.NameNotFoundException e) {
            e.printStackTrace();
            return null;
        }
    }

    /**
     * ╔════════════════════════════════════════════════════════════════════════════════════════════
     * ║ 名称：获取 APP 路径
     * ╟────────────────────────────────────────────────────────────────────────────────────────────
     * ║ 参数：context 上下文
     * ╟────────────────────────────────────────────────────────────────────────────────────────────
     * ║ 返回：APP 路径
     * ╚════════════════════════════════════════════════════════════════════════════════════════════
     */
    public static String getAppPath(Context context) {
        return getAppPath(context, context.getPackageName());
    }

    /**
     * ╔════════════════════════════════════════════════════════════════════════════════════════════
     * ║ 名称：获取 APP 路径
     * ╟────────────────────────────────────────────────────────────────────────────────────────────
     * ║ 参数：context     上下文
     * ║ 参数：packageName 包名
     * ╟────────────────────────────────────────────────────────────────────────────────────────────
     * ║ 返回：APP 路径
     * ╚════════════════════════════════════════════════════════════════════════════════════════════
     */
    public static String getAppPath(Context context, String packageName) {
        if (StringUtils.isEmpty(packageName)) return null;
        try {
            PackageManager pm = context.getPackageManager();
            PackageInfo pi = pm.getPackageInfo(packageName, 0);
            return pi == null ? null : pi.applicationInfo.sourceDir;
        } catch (PackageManager.NameNotFoundException e) {
            e.printStackTrace();
            return null;
        }
    }

    /**
     * ╔════════════════════════════════════════════════════════════════════════════════════════════
     * ║ 名称：判断 APP 是否是系统应用
     * ╟────────────────────────────────────────────────────────────────────────────────────────────
     * ║ 参数：context 上下文
     * ╟────────────────────────────────────────────────────────────────────────────────────────────
     * ║ 返回：{true : 是} {false : 否}
     * ╚════════════════════════════════════════════════════════════════════════════════════════════
     */
    public static boolean isSystemApp(Context context) {
        return isSystemApp(context, context.getPackageName());
    }

    /**
     * ╔════════════════════════════════════════════════════════════════════════════════════════════
     * ║ 名称：判断 APP 是否是系统应用
     * ╟────────────────────────────────────────────────────────────────────────────────────────────
     * ║ 参数：context     上下文
     * ║ 参数：packageName 包名
     * ╟────────────────────────────────────────────────────────────────────────────────────────────
     * ║ 返回：{true : 是} {false : 否}
     * ╚════════════════════════════════════════════════════════════════════════════════════════════
     */
    public static boolean isSystemApp(Context context, String packageName) {
        if (StringUtils.isEmpty(packageName)) return false;
        try {
            PackageManager pm = context.getPackageManager();
            ApplicationInfo ai = pm.getApplicationInfo(packageName, 0);
            return ai != null && (ai.flags & ApplicationInfo.FLAG_SYSTEM) != 0;
        } catch (PackageManager.NameNotFoundException e) {
            e.printStackTrace();
            return false;
        }
    }

    /**
     * ╔════════════════════════════════════════════════════════════════════════════════════════════
     * ║ 名称：获取应用版本号（VersionName）
     * ╟────────────────────────────────────────────────────────────────────────────────────────────
     * ║ 参数：context 上下文
     * ╟────────────────────────────────────────────────────────────────────────────────────────────
     * ║ 返回：APP 版本号
     * ╚════════════════════════════════════════════════════════════════════════════════════════════
     */
    public static String getAppVersionName(Context context) {
        return getAppVersionName(context, context.getPackageName());
    }

    /**
     * ╔════════════════════════════════════════════════════════════════════════════════════════════
     * ║ 名称：获取应用版本号（VersionName）
     * ╟────────────────────────────────────────────────────────────────────────────────────────────
     * ║ 参数：context     上下文
     * ║ 参数：packageName 包名
     * ╟────────────────────────────────────────────────────────────────────────────────────────────
     * ║ 返回：APP 版本号
     * ╚════════════════════════════════════════════════════════════════════════════════════════════
     */
    public static String getAppVersionName(Context context, String packageName) {
        if (StringUtils.isEmpty(packageName)) return null;
        try {
            PackageManager pm = context.getPackageManager();
            PackageInfo pi = pm.getPackageInfo(packageName, 0);
            return pi == null ? null : pi.versionName;
        } catch (PackageManager.NameNotFoundException e) {
            e.printStackTrace();
            return null;
        }
    }

    /**
     * ╔════════════════════════════════════════════════════════════════════════════════════════════
     * ║ 名称：获取应用版本码（VersionCode）
     * ╟────────────────────────────────────────────────────────────────────────────────────────────
     * ║ 参数：context 上下文
     * ╟────────────────────────────────────────────────────────────────────────────────────────────
     * ║ 返回：APP 版本码
     * ╚════════════════════════════════════════════════════════════════════════════════════════════
     */
    public static int getAppVersionCode(Context context) {
        return getAppVersionCode(context, context.getPackageName());
    }

    /**
     * ╔════════════════════════════════════════════════════════════════════════════════════════════
     * ║ 名称：获取应用版本码（VersionCode）
     * ╟────────────────────────────────────────────────────────────────────────────────────────────
     * ║ 参数：context     上下文
     * ║ 参数：packageName 包名
     * ╟────────────────────────────────────────────────────────────────────────────────────────────
     * ║ 返回：APP 版本码
     * ╚════════════════════════════════════════════════════════════════════════════════════════════
     */
    public static int getAppVersionCode(Context context, String packageName) {
        if (StringUtils.isEmpty(packageName)) return -1;
        try {
            PackageManager pm = context.getPackageManager();
            PackageInfo pi = pm.getPackageInfo(packageName, 0);
            return pi == null ? -1 : pi.versionCode;
        } catch (PackageManager.NameNotFoundException e) {
            e.printStackTrace();
            return -1;
        }
    }

}