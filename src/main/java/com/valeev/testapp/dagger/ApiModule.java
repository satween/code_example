package com.valeev.testapp.dagger;

import com.valeev.testapp.friends.FriendsApi;

import dagger.Module;
import dagger.Provides;
import retrofit2.Retrofit;

@Module
public class ApiModule {

    @Provides
    public FriendsApi provideFriendsAPI(Retrofit retrofit) {
        return retrofit.create(FriendsApi.class);
    }

}
