package com.sunzn.utils.library;

import android.view.View;

/**
 * Created by sunzn on 2017/1/18.
 */

public class ViewUtils {

    private ViewUtils() {
        throw new RuntimeException("Stub!");
    }

    /**
     * ╔════════════════════════════════════════════════════════════════════════════════════════════
     * ║ 名称：设置 View 显示状态
     * ╟────────────────────────────────────────────────────────────────────────────────────────────
     * ║ 参数：view
     * ║ 参数：visibility
     * ╟────────────────────────────────────────────────────────────────────────────────────────────
     * ║ 返回：void
     * ╚════════════════════════════════════════════════════════════════════════════════════════════
     */
    public static void setVisibility(View view, int visibility) {
        if (view != null) view.setVisibility(visibility);
    }

}
