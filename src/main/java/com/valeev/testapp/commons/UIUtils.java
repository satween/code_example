package com.valeev.testapp.commons;

import android.content.Context;
import android.graphics.drawable.Drawable;
import android.support.annotation.ColorRes;
import android.support.annotation.DrawableRes;
import android.support.annotation.IdRes;
import android.support.v4.content.ContextCompat;
import android.support.v4.graphics.drawable.DrawableCompat;
import android.view.View;

public class UIUtils {

    public static Drawable getColoredDrawable(Context context, @DrawableRes int drawableRes, @ColorRes int colorRes) {
        Drawable drawable = ContextCompat.getDrawable(context, drawableRes);
        drawable = DrawableCompat.wrap(drawable);
        DrawableCompat.setTint(drawable.mutate(), ContextCompat.getColor(context, colorRes));
        return drawable;
    }

    public static <T extends View> T findViewById(View root, @IdRes int resId) {
        return (T) root.findViewById(resId);
    }
}
