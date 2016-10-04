package com.valeev.testapp.dagger;

import android.content.Context;

import com.valeev.testapp.commons.bus.Bus;
import com.valeev.testapp.friends.FriendsApi;
import com.valeev.testapp.friends.FriendsPageMvp;
import com.valeev.testapp.friends.MoreFriendsModel;
import com.valeev.testapp.friends.MoreFriendsPresenter;

import dagger.Module;
import dagger.Provides;

@Module
public class FriendsPageModule {

    @Provides
    public FriendsPageMvp.Model provideFriendsModel(Context context, Bus bus, FriendsApi api) {
        return new MoreFriendsModel(context, bus, api);
    }

    @Provides
    public FriendsPageMvp.Presenter provideFriendsPresenter(Bus bus, FriendsPageMvp.Model model) {
        return new MoreFriendsPresenter(bus, model);
    }
}
