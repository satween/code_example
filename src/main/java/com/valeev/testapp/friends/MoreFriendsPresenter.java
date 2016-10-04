package com.valeev.testapp.friends;

import com.valeev.testapp.commons.bus.Bus;

import org.greenrobot.eventbus.Subscribe;
import org.greenrobot.eventbus.ThreadMode;

public class MoreFriendsPresenter extends FriendsPageMvp.Presenter {

    private FriendsPageMvp.View view = FriendsPageMvp.View.EMPTY;

    public MoreFriendsPresenter(Bus bus, FriendsPageMvp.Model model) {
        super(bus, model);
    }

    @Override
    public void onStart(FriendsPageMvp.View view) {
        this.view = view;
        getBus().subscribe(this);
        getModel().requestShareMethods();
        getModel().requestUsers();
    }

    @Override
    public void onStop(FriendsPageMvp.View view) {
        getBus().unsubscribe(this);
        this.view = FriendsPageMvp.View.EMPTY;
    }


    @Subscribe(threadMode = ThreadMode.MAIN)
    public void onUsersFetchedEvent(FriendsPageEvents.UsersFetchedEvent event) {
        view.updateUsers(event.getUserInfo());
    }

    @Subscribe(threadMode = ThreadMode.MAIN)
    public void onUsersFetchedEvent(FriendsPageEvents.ShareItemsFetchedEvent event) {
        view.updateShareMethod(event.getItems());
    }
}
