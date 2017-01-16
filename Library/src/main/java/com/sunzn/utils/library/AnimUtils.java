package com.sunzn.utils.library;

import android.widget.ViewAnimator;

/**
 * Created by sunzn on 2016/12/13.
 */

public class AnimUtils {

    private AnimUtils() {
        throw new RuntimeException("Stub!");
    }

    /**
     * ╔════════════════════════════════════════════════════════════════════════════════════════════
     * ║ 名称：切换页面
     * ╟────────────────────────────────────────────────────────────────────────────────────────────
     * ║ 参数：animator
     * ║ 参数：ui
     * ╟────────────────────────────────────────────────────────────────────────────────────────────
     * ║ 返回：void
     * ╚════════════════════════════════════════════════════════════════════════════════════════════
     */
    public static void exec(ViewAnimator animator, int ui) {
        if (animator != null) {
            animator.setDisplayedChild(ui);
        }
    }

}
