package com.sunzn.utils.library;

import android.content.Context;
import android.graphics.Color;
import android.graphics.Typeface;
import android.graphics.drawable.Drawable;
import android.support.annotation.ColorInt;
import android.support.annotation.DrawableRes;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

/**
 * Created by sunzn on 2017/1/6.
 */

public class ToastUtils {

    private ToastUtils() {
        throw new RuntimeException("Stub!");
    }

    private static final
    @ColorInt
    int TEXT_COLOR = Color.parseColor("#FFFFFF");
    private static final
    @ColorInt
    int ERROR_COLOR = Color.parseColor("#D50000");
    private static final
    @ColorInt
    int INFO_COLOR = Color.parseColor("#3F51B5");
    private static final
    @ColorInt
    int SUCCESS_COLOR = Color.parseColor("#388E3C");
    private static final
    @ColorInt
    int WARNING_COLOR = Color.parseColor("#FFA900");

    private static final String TOAST_TYPEFACE = "sans-serif-condensed";

    private static final int INVALID_ID = -1;

    /**
     * ╔══════════════════════════════════════════════════════════════════════════════════════════════════════════════
     * ║ 名称：显示默认土司
     * ╟──────────────────────────────────────────────────────────────────────────────────────────────────────────────
     * ║ 参数：context 上下文
     * ║ 参数：message 内容
     * ╟──────────────────────────────────────────────────────────────────────────────────────────────────────────────
     * ║ 返回：void
     * ╚══════════════════════════════════════════════════════════════════════════════════════════════════════════════
     */
    public static void normal(Context context, CharSequence message) {
        normal(context, message, INVALID_ID);
    }

    /**
     * ╔══════════════════════════════════════════════════════════════════════════════════════════════════════════════
     * ║ 名称：显示提示土司
     * ╟──────────────────────────────────────────────────────────────────────────────────────────────────────────────
     * ║ 参数：context 上下文
     * ║ 参数：message 内容
     * ╟──────────────────────────────────────────────────────────────────────────────────────────────────────────────
     * ║ 返回：void
     * ╚══════════════════════════════════════════════════════════════════════════════════════════════════════════════
     */
    public static void notice(Context context, CharSequence message) {
        notice(context, message, INVALID_ID);
    }

    /**
     * ╔══════════════════════════════════════════════════════════════════════════════════════════════════════════════
     * ║ 名称：显示错误土司
     * ╟──────────────────────────────────────────────────────────────────────────────────────────────────────────────
     * ║ 参数：context 上下文
     * ║ 参数：message 内容
     * ╟──────────────────────────────────────────────────────────────────────────────────────────────────────────────
     * ║ 返回：void
     * ╚══════════════════════════════════════════════════════════════════════════════════════════════════════════════
     */
    public static void failure(Context context, CharSequence message) {
        failure(context, message, INVALID_ID);
    }

    /**
     * ╔══════════════════════════════════════════════════════════════════════════════════════════════════════════════
     * ║ 名称：显示成功土司
     * ╟──────────────────────────────────────────────────────────────────────────────────────────────────────────────
     * ║ 参数：context 上下文
     * ║ 参数：message 内容
     * ╟──────────────────────────────────────────────────────────────────────────────────────────────────────────────
     * ║ 返回：void
     * ╚══════════════════════════════════════════════════════════════════════════════════════════════════════════════
     */
    public static void success(Context context, CharSequence message) {
        success(context, message, INVALID_ID);
    }

    /**
     * ╔══════════════════════════════════════════════════════════════════════════════════════════════════════════════
     * ║ 名称：显示警告土司
     * ╟──────────────────────────────────────────────────────────────────────────────────────────────────────────────
     * ║ 参数：context 上下文
     * ║ 参数：message 内容
     * ╟──────────────────────────────────────────────────────────────────────────────────────────────────────────────
     * ║ 返回：void
     * ╚══════════════════════════════════════════════════════════════════════════════════════════════════════════════
     */
    public static void warning(Context context, CharSequence message) {
        warning(context, message, INVALID_ID);
    }

    /**
     * ╔══════════════════════════════════════════════════════════════════════════════════════════════════════════════
     * ║ 名称：显示默认土司
     * ╟──────────────────────────────────────────────────────────────────────────────────────────────────────────────
     * ║ 参数：context 上下文
     * ║ 参数：message 内容
     * ║ 参数：iconRes 图标资源
     * ╟──────────────────────────────────────────────────────────────────────────────────────────────────────────────
     * ║ 返回：void
     * ╚══════════════════════════════════════════════════════════════════════════════════════════════════════════════
     */
    public static void normal(Context context, CharSequence message, @DrawableRes int iconRes) {
        normal(context, message, iconRes, Toast.LENGTH_SHORT);
    }

    /**
     * ╔══════════════════════════════════════════════════════════════════════════════════════════════════════════════
     * ║ 名称：显示提示土司
     * ╟──────────────────────────────────────────────────────────────────────────────────────────────────────────────
     * ║ 参数：context 上下文
     * ║ 参数：message 内容
     * ║ 参数：iconRes 图标资源
     * ╟──────────────────────────────────────────────────────────────────────────────────────────────────────────────
     * ║ 返回：void
     * ╚══════════════════════════════════════════════════════════════════════════════════════════════════════════════
     */
    public static void notice(Context context, CharSequence message, @DrawableRes int iconRes) {
        notice(context, message, iconRes, Toast.LENGTH_SHORT);
    }

    /**
     * ╔══════════════════════════════════════════════════════════════════════════════════════════════════════════════
     * ║ 名称：显示错误土司
     * ╟──────────────────────────────────────────────────────────────────────────────────────────────────────────────
     * ║ 参数：context 上下文
     * ║ 参数：message 内容
     * ║ 参数：iconRes 图标资源
     * ╟──────────────────────────────────────────────────────────────────────────────────────────────────────────────
     * ║ 返回：void
     * ╚══════════════════════════════════════════════════════════════════════════════════════════════════════════════
     */
    public static void failure(Context context, CharSequence message, @DrawableRes int iconRes) {
        failure(context, message, iconRes, Toast.LENGTH_SHORT);
    }

    /**
     * ╔══════════════════════════════════════════════════════════════════════════════════════════════════════════════
     * ║ 名称：显示成功土司
     * ╟──────────────────────────────────────────────────────────────────────────────────────────────────────────────
     * ║ 参数：context 上下文
     * ║ 参数：message 内容
     * ║ 参数：iconRes 图标资源
     * ╟──────────────────────────────────────────────────────────────────────────────────────────────────────────────
     * ║ 返回：void
     * ╚══════════════════════════════════════════════════════════════════════════════════════════════════════════════
     */
    public static void success(Context context, CharSequence message, @DrawableRes int iconRes) {
        success(context, message, iconRes, Toast.LENGTH_SHORT);
    }

    /**
     * ╔══════════════════════════════════════════════════════════════════════════════════════════════════════════════
     * ║ 名称：显示警告土司
     * ╟──────────────────────────────────────────────────────────────────────────────────────────────────────────────
     * ║ 参数：context 上下文
     * ║ 参数：message 内容
     * ║ 参数：iconRes 图标资源
     * ╟──────────────────────────────────────────────────────────────────────────────────────────────────────────────
     * ║ 返回：void
     * ╚══════════════════════════════════════════════════════════════════════════════════════════════════════════════
     */
    public static void warning(Context context, CharSequence message, @DrawableRes int iconRes) {
        warning(context, message, iconRes, Toast.LENGTH_SHORT);
    }

    /**
     * ╔══════════════════════════════════════════════════════════════════════════════════════════════════════════════
     * ║ 名称：显示默认土司
     * ╟──────────────────────────────────────────────────────────────────────────────────────────────────────────────
     * ║ 参数：context  上下文
     * ║ 参数：message  内容
     * ║ 参数：iconRes  图标资源
     * ║ 参数：duration 显示时长
     * ╟──────────────────────────────────────────────────────────────────────────────────────────────────────────────
     * ║ 返回：void
     * ╚══════════════════════════════════════════════════════════════════════════════════════════════════════════════
     */
    public static void normal(Context context, CharSequence message, @DrawableRes int iconRes, int duration) {
        custom(context, message, iconRes, TEXT_COLOR, INVALID_ID, duration);
    }

    /**
     * ╔══════════════════════════════════════════════════════════════════════════════════════════════════════════════
     * ║ 名称：显示提示土司
     * ╟──────────────────────────────────────────────────────────────────────────────────────────────────────────────
     * ║ 参数：context  上下文
     * ║ 参数：message  内容
     * ║ 参数：iconRes  图标资源
     * ║ 参数：duration 显示时长
     * ╟──────────────────────────────────────────────────────────────────────────────────────────────────────────────
     * ║ 返回：void
     * ╚══════════════════════════════════════════════════════════════════════════════════════════════════════════════
     */
    public static void notice(Context context, CharSequence message, @DrawableRes int iconRes, int duration) {
        custom(context, message, iconRes, TEXT_COLOR, INFO_COLOR, duration);
    }

    /**
     * ╔══════════════════════════════════════════════════════════════════════════════════════════════════════════════
     * ║ 名称：显示错误土司
     * ╟──────────────────────────────────────────────────────────────────────────────────────────────────────────────
     * ║ 参数：context  上下文
     * ║ 参数：message  内容
     * ║ 参数：iconRes  图标资源
     * ║ 参数：duration 显示时长
     * ╟──────────────────────────────────────────────────────────────────────────────────────────────────────────────
     * ║ 返回：void
     * ╚══════════════════════════════════════════════════════════════════════════════════════════════════════════════
     */
    public static void failure(Context context, CharSequence message, @DrawableRes int iconRes, int duration) {
        custom(context, message, iconRes, TEXT_COLOR, ERROR_COLOR, duration);
    }

    /**
     * ╔══════════════════════════════════════════════════════════════════════════════════════════════════════════════
     * ║ 名称：显示成功土司
     * ╟──────────────────────────────────────────────────────────────────────────────────────────────────────────────
     * ║ 参数：context  上下文
     * ║ 参数：message  内容
     * ║ 参数：iconRes  图标资源
     * ║ 参数：duration 显示时长
     * ╟──────────────────────────────────────────────────────────────────────────────────────────────────────────────
     * ║ 返回：void
     * ╚══════════════════════════════════════════════════════════════════════════════════════════════════════════════
     */
    public static void success(Context context, CharSequence message, @DrawableRes int iconRes, int duration) {
        custom(context, message, iconRes, TEXT_COLOR, SUCCESS_COLOR, duration);
    }

    /**
     * ╔══════════════════════════════════════════════════════════════════════════════════════════════════════════════
     * ║ 名称：显示警告土司
     * ╟──────────────────────────────────────────────────────────────────────────────────────────────────────────────
     * ║ 参数：context  上下文
     * ║ 参数：message  内容
     * ║ 参数：iconRes  图标资源
     * ║ 参数：duration 显示时长
     * ╟──────────────────────────────────────────────────────────────────────────────────────────────────────────────
     * ║ 返回：void
     * ╚══════════════════════════════════════════════════════════════════════════════════════════════════════════════
     */
    public static void warning(Context context, CharSequence message, @DrawableRes int iconRes, int duration) {
        custom(context, message, iconRes, TEXT_COLOR, WARNING_COLOR, duration);
    }

    /**
     * ╔══════════════════════════════════════════════════════════════════════════════════════════════════════════════
     * ║ 名称：显示自定义土司
     * ╟──────────────────────────────────────────────────────────────────────────────────────────────────────────────
     * ║ 参数：context    上下文
     * ║ 参数：message    内容
     * ║ 参数：iconRes    图标资源
     * ║ 参数：textColor  文字颜色
     * ║ 参数：tintColor  背景颜色
     * ║ 参数：duration   显示时长
     * ╟──────────────────────────────────────────────────────────────────────────────────────────────────────────────
     * ║ 返回：void
     * ╚══════════════════════════════════════════════════════════════════════════════════════════════════════════════
     */
    public static void custom(Context context, CharSequence message, @DrawableRes int iconRes, @ColorInt int textColor, @ColorInt int tintColor, int duration) {
        custom(context, message, iconRes == INVALID_ID ? null : DrawableUtils.getDrawable(context, iconRes), textColor, tintColor, duration);
    }

    /**
     * ╔══════════════════════════════════════════════════════════════════════════════════════════════════════════════
     * ║ 名称：显示自定义土司
     * ╟──────────────────────────────────────────────────────────────────────────────────────────────────────────────
     * ║ 参数：context    上下文
     * ║ 参数：message    内容
     * ║ 参数：icon       图标资源
     * ║ 参数：textColor  文字颜色
     * ║ 参数：tintColor  背景颜色
     * ║ 参数：duration   显示时长
     * ╟──────────────────────────────────────────────────────────────────────────────────────────────────────────────
     * ║ 返回：void
     * ╚══════════════════════════════════════════════════════════════════════════════════════════════════════════════
     */
    public static void custom(Context context, CharSequence message, Drawable icon, @ColorInt int textColor, @ColorInt int tintColor, int duration) {

        if (context == null || message == null) return;

        final Toast toast = new Toast(context);
        final View rootView = LayoutInflater.from(context).inflate(R.layout.toast_layout, null);
        final ImageView iconView = rootView.findViewById(R.id.toast_icon);
        final TextView textView = rootView.findViewById(R.id.toast_text);
        Drawable drawableFrame;

        if (INVALID_ID == tintColor) {
            drawableFrame = DrawableUtils.getDrawable(context, R.drawable.toast_frame);
        } else {
            drawableFrame = DrawableUtils.getTintNinePatchDrawable(context, tintColor, R.drawable.toast_frame);
        }

        DrawableUtils.setBackground(rootView, drawableFrame);

        if (icon != null) {
            DrawableUtils.setBackground(iconView, icon);
        } else {
            iconView.setVisibility(View.GONE);
        }

        textView.setTypeface(Typeface.create(TOAST_TYPEFACE, Typeface.NORMAL));
        textView.setTextColor(textColor);
        textView.setText(message);

        toast.setView(rootView);
        toast.setDuration(duration);
        toast.show();
    }

}
