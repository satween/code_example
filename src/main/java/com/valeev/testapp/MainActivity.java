package com.valeev.testapp;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentTransaction;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.widget.Toast;

import com.valeev.testapp.adreess.book.ContactListFragment;
import com.valeev.testapp.commons.GenericFragment;
import com.valeev.testapp.commons.InviteItemSelectedEvent;
import com.valeev.testapp.commons.UIUtils;
import com.valeev.testapp.commons.bus.Bus;
import com.valeev.testapp.friends.MoreFriendsFragment;
import com.valeev.testapp.friends.entities.InviteMethod;

import org.greenrobot.eventbus.Subscribe;
import org.greenrobot.eventbus.ThreadMode;

import javax.inject.Inject;

public class MainActivity extends AppCompatActivity {

    @Inject
    protected Bus bus;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        Toolbar toolbar = (Toolbar) findViewById(R.id.my_toolbar);
        setSupportActionBar(toolbar);

        getSupportActionBar().setDisplayHomeAsUpEnabled(true);
        getSupportActionBar().setDefaultDisplayHomeAsUpEnabled(true);
        getSupportActionBar().setTitle(R.string.activity_title);
        getSupportActionBar().setHomeAsUpIndicator(UIUtils.getColoredDrawable(this, R.drawable.abc_ic_ab_back_mtrl_am_alpha, R.color.orange));

        openFragment(new MoreFriendsFragment());
        ((App) getApplication()).getAppComponent().inject(this);
    }

    @Override
    protected void onStart() {
        super.onStart();
        bus.subscribe(this);

    }

    @Override
    protected void onStop() {
        super.onStop();
        bus.unsubscribe(this);
    }

    @Override
    public boolean onSupportNavigateUp() {
        if (getSupportFragmentManager().getBackStackEntryCount() > 1) {
            getSupportFragmentManager().popBackStack();
        }

        return true;
    }

    @Subscribe(threadMode = ThreadMode.MAIN)
    public void onOpenFragmentEvent(InviteItemSelectedEvent event) {
        if (InviteMethod.ADDRESS_BOOK == event.getInviteMethod()) {
            openFragment(new ContactListFragment());
        } else {
            Toast.makeText(this, R.string.error_not_implemented, Toast.LENGTH_SHORT).show();
        }
    }

    private void openFragment(GenericFragment fragment) {
        FragmentManager fm = getSupportFragmentManager();
        FragmentTransaction ft = fm.beginTransaction();
        ft.addToBackStack(fragment.getClass().getCanonicalName());
        ft.replace(R.id.container, fragment);
        ft.commit();
    }
}
