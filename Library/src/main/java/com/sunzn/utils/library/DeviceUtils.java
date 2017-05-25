package com.sunzn.utils.library;

import android.content.Context;
import android.os.Build;
import android.provider.Settings;
import android.telephony.TelephonyManager;

/**
 * Created by sunzn on 2016/12/7.
 */

public class DeviceUtils {

    private DeviceUtils() {
        throw new RuntimeException("Stub!");
    }

    /**
     * ╔════════════════════════════════════════════════════════════════════════════════════════════
     * ║ 名称：获取设备系统版本号
     * ╟────────────────────────────────────────────────────────────────────────────────────────────
     * ║ 返回：int
     * ╚════════════════════════════════════════════════════════════════════════════════════════════
     */
    public static int getSDKVersion() {
        return android.os.Build.VERSION.SDK_INT;
    }

    /**
     * ╔════════════════════════════════════════════════════════════════════════════════════════════
     * ║ 名称：获取设备厂商
     * ╟────────────────────────────────────────────────────────────────────────────────────────────
     * ║ 返回：String
     * ╚════════════════════════════════════════════════════════════════════════════════════════════
     */
    public static String getManufacturer() {
        return Build.MANUFACTURER;
    }

    /**
     * ╔════════════════════════════════════════════════════════════════════════════════════════════
     * ║ 名称：获取设备IMEI
     * ╟────────────────────────────────────────────────────────────────────────────────────────────
     * ║ 返回：String
     * ╚════════════════════════════════════════════════════════════════════════════════════════════
     */
    public static String getDeviceId(Context context) {
        TelephonyManager manager = (TelephonyManager) context.getSystemService(Context.TELEPHONY_SERVICE);
        if (manager.getDeviceId() == null) {
            return Settings.Secure.getString(context.getContentResolver(), Settings.Secure.ANDROID_ID);
        } else {
            return manager.getDeviceId();
        }
    }

}
