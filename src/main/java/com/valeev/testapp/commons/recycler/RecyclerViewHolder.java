package com.valeev.testapp.commons.recycler;

import android.support.v7.widget.RecyclerView;
import android.view.View;

public abstract class RecyclerViewHolder<T> extends RecyclerView.ViewHolder {
    public RecyclerViewHolder(View itemView) {
        super(itemView);
    }

    public abstract void setData(T data, int position);
}
