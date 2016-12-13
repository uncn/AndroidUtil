package com.sunzn.utils.library;

import android.widget.ViewAnimator;

/**
 * Created by sunzn on 2016/12/13.
 */

public class AnimUtils {

    private AnimUtils() {
        super();
    }

    public static final int 加载 = 0;
    public static final int 成功 = 1;
    public static final int 失败 = 2;
    public static final int 空白 = 3;

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
