package com.valeev.testapp.adreess.book;

import android.content.ContentResolver;
import android.content.Context;
import android.database.Cursor;
import android.graphics.Bitmap;
import android.net.Uri;
import android.provider.ContactsContract;
import android.provider.MediaStore;

import com.valeev.testapp.commons.SimpleSubscriber;
import com.valeev.testapp.commons.bus.Bus;

import java.util.ArrayList;
import java.util.List;

import rx.Observable;
import rx.android.schedulers.AndroidSchedulers;
import rx.functions.Func0;
import rx.functions.Func1;
import rx.schedulers.Schedulers;
import rx.util.async.Async;

public class ContactListModel extends ContactListMvp.Model {

    private final Context context;

    public ContactListModel(Context context, Bus bus) {
        super(bus);
        this.context = context;
    }

    @Override
    public void requestContacts() {
        asyncLoadContacts(context)
                .subscribeOn(Schedulers.io())
                .observeOn(AndroidSchedulers.mainThread())
                .toList()
                .subscribe(new SimpleSubscriber<List<Contact>>() {
                    @Override
                    public void onNext(List<Contact> contacts) {
                        getBus().publishEvent(new ContactsFetchedEvent(contacts));
                    }
                });


    }

    private static Observable<Contact> asyncLoadContacts(final Context context) {
        return Async.start(new Func0<List<Contact>>() {
            @Override
            public List<Contact> call() {
                return loadContacts(context);
            }
        }).flatMap(new Func1<List<Contact>, Observable<Contact>>() {
            @Override
            public Observable<Contact> call(List<Contact> contacts) {
                return Observable.from(contacts);
            }
        });
    }

    private static List<Contact> loadContacts(Context context) {
        List<Contact> contacts = new ArrayList<>();
        ContentResolver cr = context.getContentResolver();
        Cursor contactsCursor = null;
        Cursor emailCursor = null;

        try {
            contactsCursor = cr.query(ContactsContract.Contacts.CONTENT_URI, null, null, null, null);
            if (contactsCursor != null && contactsCursor.getCount() > 0) {
                while (contactsCursor.moveToNext()) {

                    String id = contactsCursor.getString(contactsCursor.getColumnIndex(ContactsContract.Contacts._ID));
                    String name = contactsCursor.getString(contactsCursor.getColumnIndex(ContactsContract.Contacts.DISPLAY_NAME));

                    emailCursor = cr.query(
                            ContactsContract.CommonDataKinds.Email.CONTENT_URI,
                            null,
                            ContactsContract.CommonDataKinds.Email.CONTACT_ID + " = ?",
                            new String[]{id}, null);

                    while (emailCursor != null && emailCursor.moveToNext()) {
                        String email = emailCursor.getString(emailCursor.getColumnIndex(ContactsContract.CommonDataKinds.Email.DATA));
                        contacts.add(new Contact(name, email));

                    }
                    safeCloseCursor(emailCursor);
                }
            }

        } finally {
            safeCloseCursor(emailCursor);
            safeCloseCursor(contactsCursor);
        }

        return contacts;
    }

    private static void safeCloseCursor(Cursor cursor) {
        if (cursor != null && !cursor.isClosed()) {
            cursor.close();
        }
    }
}
