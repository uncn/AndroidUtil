package com.sunzn.utils.library;

import android.content.Context;
import android.graphics.PorterDuff;
import android.graphics.PorterDuffColorFilter;
import android.graphics.drawable.Drawable;
import android.graphics.drawable.NinePatchDrawable;
import android.os.Build;
import android.support.annotation.ColorInt;
import android.support.annotation.DrawableRes;
import android.support.annotation.NonNull;
import android.support.v4.content.ContextCompat;
import android.view.View;

/**
 * Created by sunzn on 2017/4/20.
 */

public class DrawableUtils {

    private DrawableUtils() {
        throw new RuntimeException("Stub!");
    }

    /**
     * ╔══════════════════════════════════════════════════════════════════════════════════════════════════════════════
     * ║ 名称：生成对应色彩的 NinePatchDrawable
     * ╟──────────────────────────────────────────────────────────────────────────────────────────────────────────────
     * ║ 参数：context   上下文
     * ║ 参数：tintColor 颜色
     * ║ 参数：id        背景资源
     * ╟──────────────────────────────────────────────────────────────────────────────────────────────────────────────
     * ║ 返回：void
     * ╚══════════════════════════════════════════════════════════════════════════════════════════════════════════════
     */
    public static Drawable getTintNinePatchDrawable(@NonNull Context context, @ColorInt int tintColor, @DrawableRes int id) {
        final NinePatchDrawable drawable = (NinePatchDrawable) getDrawable(context, id);
        drawable.setColorFilter(new PorterDuffColorFilter(tintColor, PorterDuff.Mode.SRC_IN));
        return drawable;
    }

    /**
     * ╔══════════════════════════════════════════════════════════════════════════════════════════════════════════════
     * ║ 名称：生成对应的 Drawable
     * ╟──────────────────────────────────────────────────────────────────────────────────────────────────────────────
     * ║ 参数：context  上下文
     * ║ 参数：id       资源
     * ╟──────────────────────────────────────────────────────────────────────────────────────────────────────────────
     * ║ 返回：void
     * ╚══════════════════════════════════════════════════════════════════════════════════════════════════════════════
     */
    public static Drawable getDrawable(@NonNull Context context, @DrawableRes int id) {
        return ContextCompat.getDrawable(context, id);
    }

    static void setBackground(@NonNull View view, Drawable drawable) {
        if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.JELLY_BEAN) {
            view.setBackground(drawable);
        } else {
            view.setBackgroundDrawable(drawable);
        }
    }

}
