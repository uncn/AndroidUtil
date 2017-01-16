package com.sunzn.utils.library;

import android.annotation.TargetApi;
import android.content.Context;
import android.graphics.Color;
import android.os.Build;
import android.support.v4.content.ContextCompat;
import android.text.Html;
import android.text.Spanned;

/**
 * Created by sunzn on 2016/12/9.
 */

public class ColorUtils {

    private ColorUtils() {
        throw new RuntimeException("Stub!");
    }

    /**
     * ╔════════════════════════════════════════════════════════════════════════════════════════════
     * ║ 名称：获取颜色值
     * ╟────────────────────────────────────────────────────────────────────────────────────────────
     * ║ 参数：color
     * ╟────────────────────────────────────────────────────────────────────────────────────────────
     * ║ 返回：int
     * ╚════════════════════════════════════════════════════════════════════════════════════════════
     */
    public static int getColor(String color) {
        return Color.parseColor(color);
    }

    /**
     * ╔════════════════════════════════════════════════════════════════════════════════════════════
     * ║ 名称：获取颜色值
     * ╟────────────────────────────────────────────────────────────────────────────────────────────
     * ║ 参数：context
     * ║ 参数：color
     * ╟────────────────────────────────────────────────────────────────────────────────────────────
     * ║ 返回：int
     * ╚════════════════════════════════════════════════════════════════════════════════════════════
     */
    public static int getColor(Context context, int color) {
        return ContextCompat.getColor(context, color);
    }

    /**
     * ╔════════════════════════════════════════════════════════════════════════════════════════════
     * ║ 名称：用指定颜色标记全部正则匹配的字符串
     * ╟────────────────────────────────────────────────────────────────────────────────────────────
     * ║ 参数：input  要替换的字符串
     * ║ 参数：regex  正则表达式
     * ║ 参数：color  标记的颜色值
     * ╟────────────────────────────────────────────────────────────────────────────────────────────
     * ║ 返回：颜色标记后的内容
     * ╚════════════════════════════════════════════════════════════════════════════════════════════
     */
    @TargetApi(Build.VERSION_CODES.N)
    public static Spanned markColor(String input, String regex, String color) {
        if (input != null && regex != null && color != null) {
            String s = RegexUtils.getReplaceAll(input, regex, "<font color = " + color + ">" + regex + "</font>");
            return Build.VERSION.SDK_INT >= 24 ? Html.fromHtml(s, Html.FROM_HTML_MODE_LEGACY) : Html.fromHtml(s);
        } else {
            return null;
        }
    }

}
