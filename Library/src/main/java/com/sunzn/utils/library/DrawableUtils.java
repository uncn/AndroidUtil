package com.sunzn.utils.library;

import android.content.Context;
import android.graphics.PorterDuff;
import android.graphics.PorterDuffColorFilter;
import android.graphics.drawable.Drawable;
import android.graphics.drawable.NinePatchDrawable;
import android.os.Build;
import android.support.annotation.ColorInt;
import android.support.annotation.ColorRes;
import android.support.annotation.DrawableRes;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.support.v4.content.ContextCompat;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;

/**
 * Created by sunzn on 2017/4/20.
 */

public class DrawableUtils {

    private DrawableUtils() {
        throw new RuntimeException("Stub!");
    }

    /**
     * ╔════════════════════════════════════════════════════════════════════════════════════════════
     * ║ 名称：生成对应的 Drawable
     * ╟────────────────────────────────────────────────────────────────────────────────────────────
     * ║ 参数：context  上下文
     * ║ 参数：id       资源
     * ╟────────────────────────────────────────────────────────────────────────────────────────────
     * ║ 返回：void
     * ╚════════════════════════════════════════════════════════════════════════════════════════════
     */
    public static Drawable getDrawable(@NonNull Context context, @DrawableRes int id) {
        return ContextCompat.getDrawable(context, id);
    }

    /**
     * ╔════════════════════════════════════════════════════════════════════════════════════════════
     * ║ 名称：设置 TextView 的 DrawableLeft
     * ╟────────────────────────────────────────────────────────────────────────────────────────────
     * ║ 参数：view     TextView
     * ║ 参数：left     Drawable
     * ╟────────────────────────────────────────────────────────────────────────────────────────────
     * ║ 返回：void
     * ╚════════════════════════════════════════════════════════════════════════════════════════════
     */
    public static void setDrawableLeft(@NonNull TextView view, @Nullable Drawable left) {
        if (left != null) left.setBounds(0, 0, left.getMinimumWidth(), left.getMinimumHeight());
        view.setCompoundDrawables(left, null, null, null);
    }

    /**
     * ╔════════════════════════════════════════════════════════════════════════════════════════════
     * ║ 名称：设置 TextView 的 DrawableRight
     * ╟────────────────────────────────────────────────────────────────────────────────────────────
     * ║ 参数：view     TextView
     * ║ 参数：right    Drawable
     * ╟────────────────────────────────────────────────────────────────────────────────────────────
     * ║ 返回：void
     * ╚════════════════════════════════════════════════════════════════════════════════════════════
     */
    public static void setDrawableRight(@NonNull TextView view, @Nullable Drawable right) {
        if (right != null) right.setBounds(0, 0, right.getMinimumWidth(), right.getMinimumHeight());
        view.setCompoundDrawables(null, null, right, null);
    }

    /**
     * ╔════════════════════════════════════════════════════════════════════════════════════════════
     * ║ 名称：设置 TextView 的 DrawableTop
     * ╟────────────────────────────────────────────────────────────────────────────────────────────
     * ║ 参数：view     TextView
     * ║ 参数：top      Drawable
     * ╟────────────────────────────────────────────────────────────────────────────────────────────
     * ║ 返回：void
     * ╚════════════════════════════════════════════════════════════════════════════════════════════
     */
    public static void setDrawableTop(@NonNull TextView view, @Nullable Drawable top) {
        if (top != null) top.setBounds(0, 0, top.getMinimumWidth(), top.getMinimumHeight());
        view.setCompoundDrawables(null, top, null, null);
    }

    /**
     * ╔════════════════════════════════════════════════════════════════════════════════════════════
     * ║ 名称：设置 TextView 的 DrawableBottom
     * ╟────────────────────────────────────────────────────────────────────────────────────────────
     * ║ 参数：view     TextView
     * ║ 参数：btm      Drawable
     * ╟────────────────────────────────────────────────────────────────────────────────────────────
     * ║ 返回：void
     * ╚════════════════════════════════════════════════════════════════════════════════════════════
     */
    public static void setDrawableBottom(@NonNull TextView view, @Nullable Drawable btm) {
        if (btm != null) btm.setBounds(0, 0, btm.getMinimumWidth(), btm.getMinimumHeight());
        view.setCompoundDrawables(null, null, null, btm);
    }

    /**
     * ╔════════════════════════════════════════════════════════════════════════════════════════════
     * ║ 名称：设置 TextView 的 DrawableLeft
     * ╟────────────────────────────────────────────────────────────────────────────────────────────
     * ║ 参数：context  上下文
     * ║ 参数：view     TextView
     * ║ 参数：id       资源
     * ╟────────────────────────────────────────────────────────────────────────────────────────────
     * ║ 返回：void
     * ╚════════════════════════════════════════════════════════════════════════════════════════════
     */
    public static void setDrawableLeft(@NonNull Context context, @NonNull TextView view, @DrawableRes int id) {
        Drawable drawable = getDrawable(context, id);
        drawable.setBounds(0, 0, drawable.getMinimumWidth(), drawable.getMinimumHeight());
        view.setCompoundDrawables(drawable, null, null, null);
    }

    /**
     * ╔════════════════════════════════════════════════════════════════════════════════════════════
     * ║ 名称：设置 TextView 的 DrawableRight
     * ╟────────────────────────────────────────────────────────────────────────────────────────────
     * ║ 参数：context  上下文
     * ║ 参数：view     TextView
     * ║ 参数：id       资源
     * ╟────────────────────────────────────────────────────────────────────────────────────────────
     * ║ 返回：void
     * ╚════════════════════════════════════════════════════════════════════════════════════════════
     */
    public static void setDrawableRight(@NonNull Context context, @NonNull TextView view, @DrawableRes int id) {
        Drawable drawable = getDrawable(context, id);
        drawable.setBounds(0, 0, drawable.getMinimumWidth(), drawable.getMinimumHeight());
        view.setCompoundDrawables(null, null, drawable, null);
    }

    /**
     * ╔════════════════════════════════════════════════════════════════════════════════════════════
     * ║ 名称：设置 TextView 的 DrawableTop
     * ╟────────────────────────────────────────────────────────────────────────────────────────────
     * ║ 参数：context  上下文
     * ║ 参数：view     TextView
     * ║ 参数：id       资源
     * ╟────────────────────────────────────────────────────────────────────────────────────────────
     * ║ 返回：void
     * ╚════════════════════════════════════════════════════════════════════════════════════════════
     */
    public static void setDrawableTop(@NonNull Context context, @NonNull TextView view, @DrawableRes int id) {
        Drawable drawable = getDrawable(context, id);
        drawable.setBounds(0, 0, drawable.getMinimumWidth(), drawable.getMinimumHeight());
        view.setCompoundDrawables(null, drawable, null, null);
    }

    /**
     * ╔════════════════════════════════════════════════════════════════════════════════════════════
     * ║ 名称：设置 TextView 的 DrawableBottom
     * ╟────────────────────────────────────────────────────────────────────────────────────────────
     * ║ 参数：context  上下文
     * ║ 参数：view     TextView
     * ║ 参数：id       资源
     * ╟────────────────────────────────────────────────────────────────────────────────────────────
     * ║ 返回：void
     * ╚════════════════════════════════════════════════════════════════════════════════════════════
     */
    public static void setDrawableBottom(@NonNull Context context, @NonNull TextView view, @DrawableRes int id) {
        Drawable drawable = getDrawable(context, id);
        drawable.setBounds(0, 0, drawable.getMinimumWidth(), drawable.getMinimumHeight());
        view.setCompoundDrawables(null, null, null, drawable);
    }

    /**
     * ╔════════════════════════════════════════════════════════════════════════════════════════════
     * ║ 名称：设置 TextView 的 DrawableLeft
     * ╟────────────────────────────────────────────────────────────────────────────────────────────
     * ║ 参数：context  上下文
     * ║ 参数：view     TextView
     * ║ 参数：id       图片资源
     * ║ 参数：color    颜色资源
     * ╟────────────────────────────────────────────────────────────────────────────────────────────
     * ║ 返回：void
     * ╚════════════════════════════════════════════════════════════════════════════════════════════
     */
    public static void setColorDrawableLeft(@NonNull Context context, @NonNull TextView view, @DrawableRes int id, @ColorRes int color) {
        Drawable drawable = getDrawable(context, id).mutate();
        drawable.setColorFilter(ContextCompat.getColor(context, color), PorterDuff.Mode.SRC_ATOP);
        drawable.setBounds(0, 0, drawable.getMinimumWidth(), drawable.getMinimumHeight());
        view.setCompoundDrawables(drawable, null, null, null);
    }

    /**
     * ╔════════════════════════════════════════════════════════════════════════════════════════════
     * ║ 名称：设置 TextView 的 DrawableRight
     * ╟────────────────────────────────────────────────────────────────────────────────────────────
     * ║ 参数：context  上下文
     * ║ 参数：view     TextView
     * ║ 参数：id       图片资源
     * ║ 参数：color    颜色资源
     * ╟────────────────────────────────────────────────────────────────────────────────────────────
     * ║ 返回：void
     * ╚════════════════════════════════════════════════════════════════════════════════════════════
     */
    public static void setColorDrawableRight(@NonNull Context context, @NonNull TextView view, @DrawableRes int id, @ColorRes int color) {
        Drawable drawable = getDrawable(context, id).mutate();
        drawable.setColorFilter(ContextCompat.getColor(context, color), PorterDuff.Mode.SRC_ATOP);
        drawable.setBounds(0, 0, drawable.getMinimumWidth(), drawable.getMinimumHeight());
        view.setCompoundDrawables(null, null, drawable, null);
    }

    /**
     * ╔════════════════════════════════════════════════════════════════════════════════════════════
     * ║ 名称：设置 TextView 的 DrawableTop
     * ╟────────────────────────────────────────────────────────────────────────────────────────────
     * ║ 参数：context  上下文
     * ║ 参数：view     TextView
     * ║ 参数：id       图片资源
     * ║ 参数：color    颜色资源
     * ╟────────────────────────────────────────────────────────────────────────────────────────────
     * ║ 返回：void
     * ╚════════════════════════════════════════════════════════════════════════════════════════════
     */
    public static void setColorDrawableTop(@NonNull Context context, @NonNull TextView view, @DrawableRes int id, @ColorRes int color) {
        Drawable drawable = getDrawable(context, id).mutate();
        drawable.setColorFilter(ContextCompat.getColor(context, color), PorterDuff.Mode.SRC_ATOP);
        drawable.setBounds(0, 0, drawable.getMinimumWidth(), drawable.getMinimumHeight());
        view.setCompoundDrawables(null, drawable, null, null);
    }

    /**
     * ╔════════════════════════════════════════════════════════════════════════════════════════════
     * ║ 名称：设置 TextView 的 DrawableBottom
     * ╟────────────────────────────────────────────────────────────────────────────────────────────
     * ║ 参数：context  上下文
     * ║ 参数：view     TextView
     * ║ 参数：id       图片资源
     * ║ 参数：color    颜色资源
     * ╟────────────────────────────────────────────────────────────────────────────────────────────
     * ║ 返回：void
     * ╚════════════════════════════════════════════════════════════════════════════════════════════
     */
    public static void setColorDrawableBottom(@NonNull Context context, @NonNull TextView view, @DrawableRes int id, @ColorRes int color) {
        Drawable drawable = getDrawable(context, id).mutate();
        drawable.setColorFilter(ContextCompat.getColor(context, color), PorterDuff.Mode.SRC_ATOP);
        drawable.setBounds(0, 0, drawable.getMinimumWidth(), drawable.getMinimumHeight());
        view.setCompoundDrawables(null, null, null, drawable);
    }

    /**
     * ╔════════════════════════════════════════════════════════════════════════════════════════════
     * ║ 名称：为 View 设置背景 Drawable
     * ╟────────────────────────────────────────────────────────────────────────────────────────────
     * ║ 参数：view      控件
     * ║ 参数：drawable  背景
     * ╟────────────────────────────────────────────────────────────────────────────────────────────
     * ║ 返回：void
     * ╚════════════════════════════════════════════════════════════════════════════════════════════
     */
    public static void setBackground(@NonNull View view, @NonNull Drawable drawable) {
        if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.JELLY_BEAN) {
            view.setBackground(drawable);
        } else {
            view.setBackgroundDrawable(drawable);
        }
    }

    /**
     * ╔════════════════════════════════════════════════════════════════════════════════════════════
     * ║ 名称：为 ImageView 设置对应的色彩
     * ╟────────────────────────────────────────────────────────────────────────────────────────────
     * ║ 参数：context   上下文
     * ║ 参数：view      ImageView
     * ║ 参数：color     颜色资源
     * ╟────────────────────────────────────────────────────────────────────────────────────────────
     * ║ 返回：void
     * ╚════════════════════════════════════════════════════════════════════════════════════════════
     */
    public static void setColorDrawable(@NonNull Context context, @NonNull ImageView view, @ColorRes int color) {
        Drawable drawable = view.getDrawable().mutate();
        drawable.setColorFilter(ContextCompat.getColor(context, color), PorterDuff.Mode.SRC_ATOP);
    }

    /**
     * ╔════════════════════════════════════════════════════════════════════════════════════════════
     * ║ 名称：为 TextView 设置对应九宫格色彩资源
     * ╟────────────────────────────────────────────────────────────────────────────────────────────
     * ║ 参数：view      TextView
     * ║ 参数：tintColor 颜色
     * ╟────────────────────────────────────────────────────────────────────────────────────────────
     * ║ 返回：void
     * ╚════════════════════════════════════════════════════════════════════════════════════════════
     */
    public static void setNinePatchColorDrawable(@NonNull TextView view, @ColorInt int tintColor) {
        NinePatchDrawable drawable = (NinePatchDrawable) view.getBackground();
        drawable.setColorFilter(new PorterDuffColorFilter(tintColor, PorterDuff.Mode.SRC_IN));
        setBackground(view, drawable);
    }

    /**
     * ╔════════════════════════════════════════════════════════════════════════════════════════════
     * ║ 名称：为 TextView 设置对应九宫格色彩资源
     * ╟────────────────────────────────────────────────────────────────────────────────────────────
     * ║ 参数：context   上下文
     * ║ 参数：view      TextView
     * ║ 参数：tintColor 颜色
     * ╟────────────────────────────────────────────────────────────────────────────────────────────
     * ║ 返回：void
     * ╚════════════════════════════════════════════════════════════════════════════════════════════
     */
    public static void setNinePatchColorDrawable(@NonNull Context context, @NonNull TextView view, @ColorRes int color) {
        NinePatchDrawable drawable = (NinePatchDrawable) view.getBackground();
        drawable.setColorFilter(new PorterDuffColorFilter(ContextCompat.getColor(context, color), PorterDuff.Mode.SRC_IN));
        setBackground(view, drawable);
    }

    /**
     * ╔════════════════════════════════════════════════════════════════════════════════════════════
     * ║ 名称：生成对应色彩的 NinePatchDrawable
     * ╟────────────────────────────────────────────────────────────────────────────────────────────
     * ║ 参数：context   上下文
     * ║ 参数：tintColor 颜色
     * ║ 参数：id        背景资源
     * ╟────────────────────────────────────────────────────────────────────────────────────────────
     * ║ 返回：void
     * ╚════════════════════════════════════════════════════════════════════════════════════════════
     */
    public static Drawable getTintNinePatchDrawable(@NonNull Context context, @ColorInt int tintColor, @DrawableRes int id) {
        final NinePatchDrawable drawable = (NinePatchDrawable) getDrawable(context, id);
        drawable.setColorFilter(new PorterDuffColorFilter(tintColor, PorterDuff.Mode.SRC_IN));
        return drawable;
    }

}
