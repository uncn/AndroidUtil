package com.sunzn.utils.library;

import android.os.Environment;

/**
 * Created by sunzn on 2016/12/7.
 */

public class SDCardUtils {

    private SDCardUtils() {
        super();
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

}
