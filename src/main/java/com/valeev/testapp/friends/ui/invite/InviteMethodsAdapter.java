package com.valeev.testapp.friends.ui.invite;

import android.view.LayoutInflater;
import android.view.View;

import com.valeev.testapp.R;
import com.valeev.testapp.commons.bus.Bus;
import com.valeev.testapp.commons.recycler.RecyclerAdapter;
import com.valeev.testapp.friends.entities.InviteMethod;

public class InviteMethodsAdapter extends RecyclerAdapter<InviteMethod, InviteIMethodsItemViewHolder> {

    private final Bus bus;

    public InviteMethodsAdapter(Bus bus, LayoutInflater inflater) {
        super(inflater);
        this.bus = bus;
    }

    @Override
    protected InviteIMethodsItemViewHolder newViewHolder(View view) {
        return new InviteIMethodsItemViewHolder(bus, view);
    }

    @Override
    public int getLayoutId() {
        return R.layout.list_item_invite_from;
    }
}
