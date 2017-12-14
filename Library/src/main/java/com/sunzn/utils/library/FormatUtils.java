package com.sunzn.utils.library;

import android.support.annotation.NonNull;

import java.text.DecimalFormat;
import java.util.Locale;

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
        DecimalFormat format = new DecimalFormat("0.00");
        return format.format(num);
    }

    /**
     * ╔════════════════════════════════════════════════════════════════════════════════════════════
     * ║ 名称：格式化字符串
     * ╟────────────────────────────────────────────────────────────────────────────────────────────
     * ║ 参数：format
     * ║ 参数：args
     * ╟────────────────────────────────────────────────────────────────────────────────────────────
     * ║ 返回：格式化数字 String 值
     * ╚════════════════════════════════════════════════════════════════════════════════════════════
     */
    public static String format(@NonNull String format, @NonNull Object... args) {
        return String.format(Locale.getDefault(), format, args);
    }

}
