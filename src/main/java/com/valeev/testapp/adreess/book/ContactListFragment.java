package com.valeev.testapp.adreess.book;

import android.support.annotation.StringRes;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.TextView;

import com.valeev.testapp.R;
import com.valeev.testapp.adreess.book.ui.ContactListAdapter;
import com.valeev.testapp.commons.GenericFragment;
import com.valeev.testapp.dagger.AppComponent;
import com.valeev.testapp.commons.recycler.DrawableDivider;

import java.util.List;

import javax.inject.Inject;

import static com.valeev.testapp.commons.UIUtils.findViewById;

public class ContactListFragment extends GenericFragment implements ContactListMvp.View {

    private ContactListAdapter adapter;

    @Inject
    protected ContactListMvp.Presenter presenter;
    private RecyclerView contactList;
    private TextView errorMessage;
    private View progress;

    @Override
    protected void inject(AppComponent appComponent) {
        appComponent.inject(this);
    }

    @Override
    public void onStart() {
        super.onStart();
        presenter.onStart(this);
    }

    @Override
    public void onStop() {
        super.onStop();
        presenter.onStop(this);
    }

    @Override
    protected int getLayoutId() {
        return R.layout.fragment_adress_book;
    }

    @Override
    public void bindViews(View root) {
        progress = findViewById(root, R.id.progress_bar);
        errorMessage = findViewById(root, R.id.error_message);

        contactList = findViewById(root, R.id.contact_list);
        contactList.setLayoutManager(new LinearLayoutManager(getContext()));
        contactList.setAdapter(adapter = new ContactListAdapter(LayoutInflater.from(getContext())));
        contactList.addItemDecoration(new DrawableDivider(getContext(), R.drawable.default_list_divider));

    }

    @Override
    public void showContacts(List<Contact> newData) {
        adapter.update(newData);
        errorMessage.setVisibility(View.GONE);
        progress.setVisibility(View.GONE);
        contactList.setVisibility(View.VISIBLE);
    }

    @Override
    public void setError(@StringRes int errorResId) {
        errorMessage.setText(errorResId);
        errorMessage.setVisibility(View.VISIBLE);
        progress.setVisibility(View.GONE);
        contactList.setVisibility(View.GONE);
    }
}
