package com.valeev.testapp.commons.recycler;

import android.support.annotation.LayoutRes;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import java.util.ArrayList;
import java.util.List;

public abstract class RecyclerAdapter<T, VH extends RecyclerViewHolder<T>> extends RecyclerView.Adapter<VH> {

    private final LayoutInflater inflater;
    private final List<T> data;

    public RecyclerAdapter(LayoutInflater inflater) {
        this.inflater = inflater;
        this.data = new ArrayList<>();
    }

    public void update(List<T> newData) {
        this.data.clear();
        this.data.addAll(newData);
        notifyDataSetChanged();
    }

    public List<T> getData() {
        return data;
    }

    @Override
    public void onBindViewHolder(VH holder, int position) {
        holder.setData(getData().get(position), position);
    }

    @Override
    public VH onCreateViewHolder(ViewGroup parent, int viewType) {
        return newViewHolder(inflater.inflate(getLayoutId(), parent, false));
    }

    @Override
    public int getItemCount() {
        return data.size();
    }

    protected abstract VH newViewHolder(View view);

    @LayoutRes
    public abstract int getLayoutId();
}
