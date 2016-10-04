package com.valeev.testapp.friends.ui.cards;

import android.graphics.Rect;
import android.support.v7.widget.RecyclerView;
import android.view.View;

public class CardsDecorator extends RecyclerView.ItemDecoration {

    private final int spaceBetweenCards;
    private final int leftSpace;

    public CardsDecorator(int spaceBetweenCards, int leftSpace) {
        this.spaceBetweenCards = spaceBetweenCards;
        this.leftSpace = leftSpace;
    }

    @Override
    public void getItemOffsets(Rect outRect, View view, RecyclerView parent, RecyclerView.State state) {
        super.getItemOffsets(outRect, view, parent, state);
        if (parent.getChildAdapterPosition(view) == 0) {
            outRect.left = leftSpace;
        }

        outRect.right = spaceBetweenCards;
    }
}
