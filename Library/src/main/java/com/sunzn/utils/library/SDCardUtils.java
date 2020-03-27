package com.sunzn.utils.library;

import android.annotation.TargetApi;
import android.os.Build;
import android.os.Environment;
import android.os.StatFs;

import java.io.BufferedInputStream;
import java.io.BufferedReader;
import java.io.File;
import java.io.InputStreamReader;

/**
 * Created by sunzn on 2016/12/7.
 */

public class SDCardUtils {

    private SDCardUtils() {
        throw new RuntimeException("Stub!");
    }

    /**
     * ╔════════════════════════════════════════════════════════════════════════════════════════════
     * ║ 名称：判断 SD 卡是否可用
     * ╟────────────────────────────────────────────────────────────────────────────────────────────
     * ║ 返回：Boolean
     * ╚════════════════════════════════════════════════════════════════════════════════════════════
     */
    public static boolean isSDCardEnable() {
        return Environment.MEDIA_MOUNTED.equals(Environment.getExternalStorageState());
    }

    /**
     * ╔════════════════════════════════════════════════════════════════════════════════════════════
     * ║ 名称：获取SD卡路径
     * ╟────────────────────────────────────────────────────────────────────────────────────────────
     * ║ 返回：String
     * ╚════════════════════════════════════════════════════════════════════════════════════════════
     */
    public static String getSDCardPath() {
        if (!isSDCardEnable()) return "sdcard unable!";
        String cmd = "cat /proc/mounts";
        Runtime run = Runtime.getRuntime();
        BufferedReader bufferedReader = null;
        try {
            Process p = run.exec(cmd);
            bufferedReader = new BufferedReader(new InputStreamReader(new BufferedInputStream(p.getInputStream())));
            String lineStr;
            while ((lineStr = bufferedReader.readLine()) != null) {
                if (lineStr.contains("sdcard") && lineStr.contains(".android_secure")) {
                    String[] strArray = lineStr.split(" ");
                    if (strArray.length >= 5) {
                        return strArray[1].replace("/.android_secure", "") + File.separator;
                    }
                }
                if (p.waitFor() != 0 && p.exitValue() == 1) {
                    break;
                }
            }
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            CloseUtils.closeIO(bufferedReader);
        }
        return Environment.getExternalStorageDirectory().getPath() + File.separator;
    }

    /**
     * ╔════════════════════════════════════════════════════════════════════════════════════════════
     * ║ 名称：获取SD卡剩余空间
     * ╟────────────────────────────────────────────────────────────────────────────────────────────
     * ║ 返回：Long
     * ╚════════════════════════════════════════════════════════════════════════════════════════════
     */
    @TargetApi(Build.VERSION_CODES.JELLY_BEAN_MR2)
    public static long getFreeSpace() {
        if (!isSDCardEnable()) return 0;
        StatFs stat = new StatFs(getSDCardPath());
        long blockSize, availableBlocks;
        availableBlocks = stat.getAvailableBlocksLong();
        blockSize = stat.getBlockSizeLong();
        return availableBlocks * blockSize;
    }

}
