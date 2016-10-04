package com.valeev.testapp.adreess.book;

import android.Manifest;
import android.content.Context;

import com.tbruyelle.rxpermissions.RxPermissions;
import com.valeev.testapp.R;
import com.valeev.testapp.commons.SimpleSubscriber;
import com.valeev.testapp.commons.bus.Bus;

import org.greenrobot.eventbus.Subscribe;
import org.greenrobot.eventbus.ThreadMode;

public class ContactListPresenter extends ContactListMvp.Presenter {
    private final Context context;
    private ContactListMvp.View view = ContactListMvp.View.EMPTY;

    public ContactListPresenter(Context context, Bus bus, ContactListMvp.Model model) {
        super(bus, model);
        this.context = context;
    }

    @Override
    public void onStart(final ContactListMvp.View view) {
        this.view = view;
        getBus().subscribe(this);
        RxPermissions.getInstance(context)
                .request(Manifest.permission.READ_CONTACTS)
                .subscribe(new SimpleSubscriber<Boolean>() {
                    @Override
                    public void onNext(Boolean granted) {
                        if (granted) {
                            getModel().requestContacts();
                        }
                        else {
                            view.setError(R.string.error_permission_is_not_provided);
                        }
                    }
                });
    }

    @Override
    public void onStop(ContactListMvp.View view) {
        this.view = ContactListMvp.View.EMPTY;
        getBus().unsubscribe(this);
    }


    @Subscribe(threadMode = ThreadMode.MAIN)
    public void onContactsFetchedEvent(ContactsFetchedEvent event) {
        if (event.getContacts().size() > 0) {
            view.showContacts(event.getContacts());
        } else {
            view.setError(R.string.error_your_contact_list_is_empty);
        }
    }
}
