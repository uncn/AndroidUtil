package com.sunzn.utils.library;

import java.text.DecimalFormat;

/**
 * Created by sunzn on 2016/12/23.
 */

public class FormatUtils {

    private FormatUtils() {
        throw new RuntimeException("Stub!");
    }

    /**
     * ╔════════════════════════════════════════════════════════════════════════════════════════════
     * ║ 名称：格式化保留 2 位小数
     * ╟────────────────────────────────────────────────────────────────────────────────────────────
     * ║ 参数：num
     * ╟────────────────────────────────────────────────────────────────────────────────────────────
     * ║ 返回：格式化数字 String 值
     * ╚════════════════════════════════════════════════════════════════════════════════════════════
     */
    public static String format(float num) {
        DecimalFormat format = new DecimalFormat("#.00");
        return format.format(num);
    }

}
