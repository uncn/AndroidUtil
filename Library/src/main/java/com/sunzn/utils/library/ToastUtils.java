package com.sunzn.utils.library;

import android.content.Context;
import android.widget.Toast;

/**
 * Created by sunzn on 2017/1/6.
 */

public class ToastUtils {

    private ToastUtils() {
        throw new RuntimeException("Stub!");
    }

    /**
     * ╔══════════════════════════════════════════════════════════════════════════════════════════════════════════════
     * ║ 名称：显示短时土司
     * ╟──────────────────────────────────────────────────────────────────────────────────────────────────────────────
     * ║ 参数：context 上下文
     * ║ 参数：content 内容
     * ╟──────────────────────────────────────────────────────────────────────────────────────────────────────────────
     * ║ 返回：void
     * ╚══════════════════════════════════════════════════════════════════════════════════════════════════════════════
     */
    public static void makeShortText(Context context, String content) {
        if (context != null && !StringUtils.isNull(content)) {
            Toast.makeText(context, content, Toast.LENGTH_SHORT).show();
        }
    }

    /**
     * ╔══════════════════════════════════════════════════════════════════════════════════════════════════════════════
     * ║ 名称：显示长时土司
     * ╟──────────────────────────────────────────────────────────────────────────────────────────────────────────────
     * ║ 参数：context 上下文
     * ║ 参数：content 内容
     * ╟──────────────────────────────────────────────────────────────────────────────────────────────────────────────
     * ║ 返回：void
     * ╚══════════════════════════════════════════════════════════════════════════════════════════════════════════════
     */
    public static void makeLongText(Context context, String content) {
        if (context != null && !StringUtils.isNull(content)) {
            Toast.makeText(context, content, Toast.LENGTH_LONG).show();
        }
    }

}
