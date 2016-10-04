package com.valeev.testapp.adreess.book.ui;

import android.view.LayoutInflater;
import android.view.View;

import com.valeev.testapp.R;
import com.valeev.testapp.adreess.book.Contact;
import com.valeev.testapp.commons.recycler.RecyclerAdapter;

public class ContactListAdapter extends RecyclerAdapter<Contact, ContactListItemViewHolder> {

    public ContactListAdapter(LayoutInflater inflater) {
        super(inflater);
    }

    @Override
    protected ContactListItemViewHolder newViewHolder(View view) {
        return new ContactListItemViewHolder(view);
    }

    @Override
    public int getLayoutId() {
        return R.layout.list_item_contact;
    }
}
