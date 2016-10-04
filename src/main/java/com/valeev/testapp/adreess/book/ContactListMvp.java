package com.valeev.testapp.adreess.book;

import android.support.annotation.StringRes;

import com.valeev.testapp.commons.Mvp;
import com.valeev.testapp.commons.bus.Bus;

import java.util.List;

public interface ContactListMvp {

    interface View extends Mvp.View {
        void showContacts(List<Contact> contactList);

        void setError(@StringRes int errorResId);

        ContactListMvp.View EMPTY = new View() {
            @Override
            public void showContacts(List<Contact> contactList) {

            }

            @Override
            public void setError(@StringRes int errorResId) {

            }


            @Override
            public void bindViews(android.view.View root) {

            }
        };
    }

    abstract class Presenter extends Mvp.Presenter<ContactListMvp.Model, ContactListMvp.View> {
        public Presenter(Bus bus, ContactListMvp.Model model) {
            super(bus, model);
        }
    }

    abstract class Model extends Mvp.Model {

        public abstract void requestContacts();

        public Model(Bus bus) {
            super(bus);
        }
    }
}
