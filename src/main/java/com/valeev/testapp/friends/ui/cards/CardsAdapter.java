package com.valeev.testapp.friends.ui.cards;

import android.view.LayoutInflater;
import android.view.View;

import com.valeev.testapp.R;
import com.valeev.testapp.commons.FontsLoader;
import com.valeev.testapp.commons.recycler.RecyclerAdapter;
import com.valeev.testapp.friends.entities.Result;

public class CardsAdapter extends RecyclerAdapter<Result, CardViewHolder> {

    private final FontsLoader fontsLoader;

    public CardsAdapter(LayoutInflater inflater, FontsLoader fontsLoader) {
        super(inflater);
        this.fontsLoader = fontsLoader;
    }

    @Override
    protected CardViewHolder newViewHolder(View view) {
        return new CardViewHolder(view, fontsLoader);
    }

    @Override
    public int getLayoutId() {
        return R.layout.list_item_card;
    }
}