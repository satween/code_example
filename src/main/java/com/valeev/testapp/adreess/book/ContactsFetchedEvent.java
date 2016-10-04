package com.valeev.testapp.adreess.book;

import java.util.List;

public class ContactsFetchedEvent {
    private final List<Contact> contacts;

    public ContactsFetchedEvent(List<Contact> contacts) {
        this.contacts = contacts;
    }

    public List<Contact> getContacts() {
        return contacts;
    }
}
