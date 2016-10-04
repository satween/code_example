package com.valeev.testapp.commons.recycler;

import android.content.Context;
import android.graphics.Canvas;
import android.graphics.Rect;
import android.graphics.drawable.Drawable;
import android.support.v4.content.ContextCompat;
import android.support.v7.widget.RecyclerView;
import android.view.View;

public class DrawableDivider extends RecyclerView.ItemDecoration {

    private final Drawable divider;
    private final Rect padding;

    public DrawableDivider(Context context, int resId) {
        divider = ContextCompat.getDrawable(context, resId);
        padding = new Rect();
        divider.getPadding(padding);
    }

    @Override
    public void onDrawOver(Canvas c, RecyclerView parent, RecyclerView.State state) {
        int left = parent.getPaddingLeft() + padding.left;
        int right = parent.getWidth() - parent.getPaddingRight() - padding.right;

        int childCount = parent.getChildCount();
        for (int i = 0; i < childCount; i++) {
            View child = parent.getChildAt(i);

            RecyclerView.LayoutParams params = (RecyclerView.LayoutParams) child.getLayoutParams();

            int top = child.getBottom() + params.bottomMargin;
            int bottom = top + divider.getIntrinsicHeight();

            divider.setBounds(left, top, right, bottom);
            divider.draw(c);
        }
    }
}
