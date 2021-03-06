package com.sunzn.utils.library;

import android.annotation.TargetApi;
import android.content.Context;
import android.graphics.Color;
import android.os.Build;
import android.text.Html;
import android.text.Spanned;

import androidx.core.content.ContextCompat;

import java.util.regex.Pattern;

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
     * ║ 名称：用指定颜色标记给定的字符串
     * ╟────────────────────────────────────────────────────────────────────────────────────────────
     * ║ 参数：format  格式化规则
     * ║ 参数：regex   被标记的字符串
     * ║ 参数：color   标记的颜色值
     * ╟────────────────────────────────────────────────────────────────────────────────────────────
     * ║ 返回：颜色标记后的内容
     * ╚════════════════════════════════════════════════════════════════════════════════════════════
     */
    public static Spanned signColor(String format, String regex, String color) {
        if (!StringUtils.isEmpty(format, regex, color)) {
            String s = String.format(format, "<font color = " + color + ">" + regex + "</font>");
            return Build.VERSION.SDK_INT >= 24 ? Html.fromHtml(s, Html.FROM_HTML_MODE_LEGACY) : Html.fromHtml(s);
        } else {
            return null;
        }
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

    /**
     * ╔════════════════════════════════════════════════════════════════════════════════════════════
     * ║ 名称：用指定颜色标记全部正则匹配的字符串
     * ╟────────────────────────────────────────────────────────────────────────────────────────────
     * ║ 参数：input  要替换的字符串
     * ║ 参数：regex  正则表达式
     * ║ 参数：color  标记的颜色值
     * ║ 参数：flags  匹配标志 {@link Pattern.CASE_INSENSITIVE}, {@link Pattern.MULTILINE},
     * ║                      {@link Pattern.DOTALL},{@link Pattern.UNICODE_CASE},
     * ║                      {@link Pattern.CANON_EQ}, {@link Pattern.UNIX_LINES},
     * ║                      {@link Pattern.LITERAL}, {@link Pattern.UNICODE_CHARACTER_CLASS},
     * ║                      {@link Pattern.COMMENTS}
     * ╟────────────────────────────────────────────────────────────────────────────────────────────
     * ║ 返回：颜色标记后的内容
     * ╚════════════════════════════════════════════════════════════════════════════════════════════
     */
    @SuppressWarnings("JavadocReference")
    @TargetApi(Build.VERSION_CODES.N)
    public static Spanned markColor(String input, String regex, String color, int flags) {
        if (input != null && regex != null && color != null) {
            String s = RegexUtils.getReplaceAll(input, regex, "<font color = " + color + ">" + regex + "</font>", flags);
            return Build.VERSION.SDK_INT >= 24 ? Html.fromHtml(s, Html.FROM_HTML_MODE_LEGACY) : Html.fromHtml(s);
        } else {
            return null;
        }
    }

}
