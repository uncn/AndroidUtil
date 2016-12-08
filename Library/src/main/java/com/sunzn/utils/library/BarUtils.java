package com.sunzn.utils.library;

import android.content.Context;

public class BarUtils {

    private BarUtils() {
        super();
    }

    /**
     * ╔════════════════════════════════════════════════════════════════════════════════════════════
     * ║ 名称：获取状态栏高度
     * ╟────────────────────────────────────────────────────────────────────────────────────────────
     * ║ 参数：context 上下文
     * ╟────────────────────────────────────────────────────────────────────────────────────────────
     * ║ 返回：状态栏高度
     * ╚════════════════════════════════════════════════════════════════════════════════════════════
     */
    public static int getStatusBarHeight(Context context) {
        int result = -1;
        int resourceId = context.getResources().getIdentifier("status_bar_height", "dimen", "android");
        if (resourceId > 0) {
            result = context.getResources().getDimensionPixelSize(resourceId);
        }
        return result;
    }

}