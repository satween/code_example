package com.valeev.testapp.dagger;

import com.valeev.testapp.MainActivity;
import com.valeev.testapp.adreess.book.ContactListFragment;
import com.valeev.testapp.friends.MoreFriendsFragment;

import dagger.Component;

@Component(modules = {
        CommonsModule.class,
        NetworkModule.class,
        ApiModule.class,
        FriendsPageModule.class,
        ContactListModule.class,
})
public interface AppComponent {
    void inject(MoreFriendsFragment fragment);

    void inject(ContactListFragment fragment);

    void inject(MainActivity activity);
}
