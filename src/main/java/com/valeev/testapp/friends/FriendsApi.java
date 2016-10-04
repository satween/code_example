package com.valeev.testapp.friends;

import com.valeev.testapp.friends.entities.UserInfo;

import retrofit2.http.GET;
import retrofit2.http.Path;
import rx.Observable;

public interface FriendsApi {
    @GET("/v2/{token}")
    Observable<UserInfo> listUsers(@Path("token") String token);
}
