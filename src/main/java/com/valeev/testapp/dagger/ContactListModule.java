package com.valeev.testapp.dagger;

import android.content.Context;

import com.valeev.testapp.adreess.book.ContactListModel;
import com.valeev.testapp.adreess.book.ContactListMvp;
import com.valeev.testapp.adreess.book.ContactListPresenter;
import com.valeev.testapp.commons.bus.Bus;

import dagger.Module;
import dagger.Provides;

@Module
public class ContactListModule {

    @Provides
    public ContactListMvp.Presenter providePresenter(Context context, Bus bus, ContactListMvp.Model model) {
        return new ContactListPresenter(context, bus, model);
    }

    @Provides
    public ContactListMvp.Model provideModel(Context context, Bus bus) {
        return new ContactListModel(context, bus);
    }

}
