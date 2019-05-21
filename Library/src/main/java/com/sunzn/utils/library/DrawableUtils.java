package com.sunzn.utils.library;

import android.content.Context;
import android.graphics.Bitmap;
import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.PixelFormat;
import android.graphics.PorterDuff;
import android.graphics.PorterDuffColorFilter;
import android.graphics.drawable.BitmapDrawable;
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
     * ║ 变量：节省每次创建时产生的开销，但要注意多线程操作 synchronized
     * ╚════════════════════════════════════════════════════════════════════════════════════════════
     */
    private static final Canvas sCanvas = new Canvas();

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
     * ║ 参数：id       资源
     * ║ 参数：text     文本
     * ╟────────────────────────────────────────────────────────────────────────────────────────────
     * ║ 返回：void
     * ╚════════════════════════════════════════════════════════════════════════════════════════════
     */
    public static void setDrawableLeft(@NonNull Context context, @NonNull TextView view, @DrawableRes int id, @NonNull String text) {
        Drawable drawable = getDrawable(context, id);
        drawable.setBounds(0, 0, drawable.getMinimumWidth(), drawable.getMinimumHeight());
        view.setCompoundDrawables(drawable, null, null, null);
        view.setText(text);
    }

    /**
     * ╔════════════════════════════════════════════════════════════════════════════════════════════
     * ║ 名称：设置 TextView 的 DrawableRight
     * ╟────────────────────────────────────────────────────────────────────────────────────────────
     * ║ 参数：context  上下文
     * ║ 参数：view     TextView
     * ║ 参数：id       资源
     * ║ 参数：text     文本
     * ╟────────────────────────────────────────────────────────────────────────────────────────────
     * ║ 返回：void
     * ╚════════════════════════════════════════════════════════════════════════════════════════════
     */
    public static void setDrawableRight(@NonNull Context context, @NonNull TextView view, @DrawableRes int id, @NonNull String text) {
        Drawable drawable = getDrawable(context, id);
        drawable.setBounds(0, 0, drawable.getMinimumWidth(), drawable.getMinimumHeight());
        view.setCompoundDrawables(null, null, drawable, null);
        view.setText(text);
    }

    /**
     * ╔════════════════════════════════════════════════════════════════════════════════════════════
     * ║ 名称：设置 TextView 的 DrawableTop
     * ╟────────────────────────────────────────────────────────────────────────────────────────────
     * ║ 参数：context  上下文
     * ║ 参数：view     TextView
     * ║ 参数：id       资源
     * ║ 参数：text     文本
     * ╟────────────────────────────────────────────────────────────────────────────────────────────
     * ║ 返回：void
     * ╚════════════════════════════════════════════════════════════════════════════════════════════
     */
    public static void setDrawableTop(@NonNull Context context, @NonNull TextView view, @DrawableRes int id, @NonNull String text) {
        Drawable drawable = getDrawable(context, id);
        drawable.setBounds(0, 0, drawable.getMinimumWidth(), drawable.getMinimumHeight());
        view.setCompoundDrawables(null, drawable, null, null);
        view.setText(text);
    }

    /**
     * ╔════════════════════════════════════════════════════════════════════════════════════════════
     * ║ 名称：设置 TextView 的 DrawableBottom
     * ╟────────────────────────────────────────────────────────────────────────────────────────────
     * ║ 参数：context  上下文
     * ║ 参数：view     TextView
     * ║ 参数：id       资源
     * ║ 参数：text     文本
     * ╟────────────────────────────────────────────────────────────────────────────────────────────
     * ║ 返回：void
     * ╚════════════════════════════════════════════════════════════════════════════════════════════
     */
    public static void setDrawableBottom(@NonNull Context context, @NonNull TextView view, @DrawableRes int id, @NonNull String text) {
        Drawable drawable = getDrawable(context, id);
        drawable.setBounds(0, 0, drawable.getMinimumWidth(), drawable.getMinimumHeight());
        view.setCompoundDrawables(null, null, null, drawable);
        view.setText(text);
    }

    /**
     * ╔════════════════════════════════════════════════════════════════════════════════════════════
     * ║ 名称：设置 TextView 的 DrawableLeft 和 DrawableRight
     * ╟────────────────────────────────────────────────────────────────────────────────────────────
     * ║ 参数：context  上下文
     * ║ 参数：view     TextView
     * ║ 参数：leftID   资源
     * ║ 参数：rightID  资源
     * ╟────────────────────────────────────────────────────────────────────────────────────────────
     * ║ 返回：void
     * ╚════════════════════════════════════════════════════════════════════════════════════════════
     */
    public static void setDrawableLeftAndRight(@NonNull Context context, @NonNull TextView view, @DrawableRes int leftID, @DrawableRes int rightID) {
        Drawable leftDrawable = getDrawable(context, leftID);
        leftDrawable.setBounds(0, 0, leftDrawable.getMinimumWidth(), leftDrawable.getMinimumHeight());
        Drawable rightDrawable = getDrawable(context, rightID);
        rightDrawable.setBounds(0, 0, rightDrawable.getMinimumWidth(), rightDrawable.getMinimumHeight());
        view.setCompoundDrawables(leftDrawable, null, rightDrawable, null);
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

    /**
     * ╔════════════════════════════════════════════════════════════════════════════════════════════
     * ║ 名称：从一个 view 创建原始大小的 Bitmap
     * ╟────────────────────────────────────────────────────────────────────────────────────────────
     * ║ 参数：view   用于生成 Bitmap 的 view
     * ╟────────────────────────────────────────────────────────────────────────────────────────────
     * ║ 返回：Bitmap
     * ╚════════════════════════════════════════════════════════════════════════════════════════════
     */
    public static Bitmap createBitmapFromView(@NonNull View view) {
        return createBitmapFromView(view, 1f);
    }

    /**
     * ╔════════════════════════════════════════════════════════════════════════════════════════════
     * ║ 名称：从一个 view 创建 Bitmap
     * ╟────────────────────────────────────────────────────────────────────────────────────────────
     * ║ 参数：view    用于生成 Bitmap 的 view
     * ║ 参数：scale   缩放比例，对创建的 Bitmap 进行缩放，数值支持从 0 到 1
     * ╟────────────────────────────────────────────────────────────────────────────────────────────
     * ║ 返回：Bitmap
     * ╟────────────────────────────────────────────────────────────────────────────────────────────
     * ║ 注意：绘制之前要清掉 View 的焦点，因为焦点可能会改变一个 View 的 UI 状态。
     * ╚════════════════════════════════════════════════════════════════════════════════════════════
     */
    public static Bitmap createBitmapFromView(@NonNull View view, float scale) {
        if (view instanceof ImageView) {
            Drawable drawable = ((ImageView) view).getDrawable();
            if (drawable instanceof BitmapDrawable) {
                return ((BitmapDrawable) drawable).getBitmap();
            }
        }
        view.clearFocus();
        Bitmap bitmap = createBitmapSafely((int) (view.getWidth() * scale), (int) (view.getHeight() * scale), Bitmap.Config.ARGB_8888, 1);
        if (bitmap != null) {
            synchronized (sCanvas) {
                Canvas canvas = sCanvas;
                canvas.setBitmap(bitmap);
                canvas.save();
                canvas.drawColor(Color.WHITE); // 防止 View 上面有些区域空白导致最终 Bitmap 上有些区域变黑
                canvas.scale(scale, scale);
                view.draw(canvas);
                canvas.restore();
                canvas.setBitmap(null);
            }
        }
        return bitmap;
    }

    /**
     * ╔════════════════════════════════════════════════════════════════════════════════════════════
     * ║ 名称：安全的从一个 view 创建 Bitmap
     * ║ 描述：如果新建 Bitmap 时产生了 OOM，可以主动进行一次 GC - System.gc()，然后再次尝试创建
     * ╟────────────────────────────────────────────────────────────────────────────────────────────
     * ║ 参数：width        Bitmap 宽度
     * ║ 参数：height       Bitmap 高度
     * ║ 参数：config       传入一个 Bitmap.Config
     * ║ 参数：retryCount   创建 Bitmap 时产生 OOM 后，主动重试的次数
     * ╟────────────────────────────────────────────────────────────────────────────────────────────
     * ║ 返回：Bitmap
     * ╚════════════════════════════════════════════════════════════════════════════════════════════
     */
    public static Bitmap createBitmapSafely(int width, int height, Bitmap.Config config, int retryCount) {
        try {
            return Bitmap.createBitmap(width, height, config);
        } catch (OutOfMemoryError e) {
            e.printStackTrace();
            if (retryCount > 0) {
                System.gc();
                return createBitmapSafely(width, height, config, retryCount - 1);
            }
            return null;
        }
    }

    /**
     * ╔════════════════════════════════════════════════════════════════════════════════════════════
     * ║ 名称：由一个 Drawable 生成 Bitmap
     * ╟────────────────────────────────────────────────────────────────────────────────────────────
     * ║ 参数：view    用于生成 Bitmap 的 Drawable
     * ╟────────────────────────────────────────────────────────────────────────────────────────────
     * ║ 返回：Bitmap
     * ╚════════════════════════════════════════════════════════════════════════════════════════════
     */
    public static Bitmap drawableToBitmap(Drawable drawable) {
        if (drawable == null)
            return null;
        else if (drawable instanceof BitmapDrawable) {
            return ((BitmapDrawable) drawable).getBitmap();
        }

        int intrinsicWidth = drawable.getIntrinsicWidth();
        int intrinsicHeight = drawable.getIntrinsicHeight();

        if (!(intrinsicWidth > 0 && intrinsicHeight > 0))
            return null;

        try {
            Bitmap.Config config = drawable.getOpacity() != PixelFormat.OPAQUE ? Bitmap.Config.ARGB_8888 : Bitmap.Config.RGB_565;
            Bitmap bitmap = Bitmap.createBitmap(intrinsicWidth, intrinsicHeight, config);
            Canvas canvas = new Canvas(bitmap);
            drawable.setBounds(0, 0, canvas.getWidth(), canvas.getHeight());
            drawable.draw(canvas);
            return bitmap;
        } catch (OutOfMemoryError e) {
            e.printStackTrace();
            return null;
        }
    }

}
