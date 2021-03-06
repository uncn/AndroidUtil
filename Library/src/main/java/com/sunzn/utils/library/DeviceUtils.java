package com.sunzn.utils.library;

import android.Manifest;
import android.content.Context;
import android.content.pm.PackageManager;
import android.os.Build;
import android.provider.Settings;
import androidx.annotation.NonNull;
import androidx.core.app.ActivityCompat;
import androidx.core.content.ContextCompat;

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
     * ║ 名称：获取设备 IMEI 或 SN
     * ╟────────────────────────────────────────────────────────────────────────────────────────────
     * ║ 返回：String
     * ╚════════════════════════════════════════════════════════════════════════════════════════════
     */
    private static String getDeviceId(@NonNull Context context) {
        String ID = null;
        if (ContextCompat.checkSelfPermission(context, Manifest.permission.READ_PHONE_STATE) == PackageManager.PERMISSION_GRANTED) {
            try {
                TelephonyManager manager = (TelephonyManager) context.getSystemService(Context.TELEPHONY_SERVICE);
                if (manager != null) {
                    ID = Build.VERSION.SDK_INT >= Build.VERSION_CODES.O ? manager.getImei() : manager.getDeviceId();
                    if (ID == null || ID.length() == 0) {
                        ID = Build.VERSION.SDK_INT >= Build.VERSION_CODES.O ? Build.getSerial() : Build.SERIAL;
                    }
                    if (ID == null || ID.length() == 0) {
                        ID = Settings.Secure.getString(context.getContentResolver(), Settings.Secure.ANDROID_ID);
                    }
                    if (ID == null || ID.length() == 0) {
                        ID = Settings.System.getString(context.getContentResolver(), Settings.System.ANDROID_ID);
                    }
                }
            } catch (Exception e) {
                // TODO
            }
        }
        return ID;
    }

    /**
     * ╔════════════════════════════════════════════════════════════════════════════════════════════
     * ║ 名称：获取设备 IMEI 或 SN
     * ╟────────────────────────────────────────────────────────────────────────────────────────────
     * ║ 返回：String
     * ╚════════════════════════════════════════════════════════════════════════════════════════════
     */
    public static String getDeviceId(@NonNull Context context, @NonNull String value) {
        String ID = getDeviceId(context);
        return (ID == null || ID.length() == 0) ? value : ID;
    }

}
