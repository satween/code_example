package com.valeev.testapp.adreess.book.ui;

import android.view.View;
import android.widget.TextView;

import com.valeev.testapp.R;
import com.valeev.testapp.adreess.book.Contact;
import com.valeev.testapp.commons.recycler.RecyclerViewHolder;

import static com.valeev.testapp.commons.UIUtils.findViewById;

public class ContactListItemViewHolder extends RecyclerViewHolder<Contact> {

    private final TextView contactName;
    private final TextView contactEmail;

    public ContactListItemViewHolder(View itemView) {
        super(itemView);
        contactName = findViewById(itemView, R.id.contact_name);
        contactEmail = findViewById(itemView, R.id.contact_email);
    }

    @Override
    public void setData(Contact data, int position) {
        contactName.setText(data.getName());
        contactEmail.setText(data.getEmail());
    }
}
