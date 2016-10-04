package com.valeev.testapp.friends;

import android.content.Context;
import android.content.pm.PackageManager;
import android.support.annotation.NonNull;

import com.valeev.testapp.commons.SimpleSubscriber;
import com.valeev.testapp.commons.bus.Bus;
import com.valeev.testapp.friends.entities.InviteMethod;
import com.valeev.testapp.friends.entities.UserInfo;

import java.util.List;

import rx.Observable;
import rx.android.schedulers.AndroidSchedulers;
import rx.functions.Func1;
import rx.schedulers.Schedulers;

public class MoreFriendsModel extends FriendsPageMvp.Model {

    public static final String TOKEN = "5762c6a8100000df1f8b14dd";
    private final FriendsApi friendsApi;
    private Context context;

    public MoreFriendsModel(Context context, Bus bus, FriendsApi friendsApi) {
        super(bus);
        this.context = context;
        this.friendsApi = friendsApi;
    }

    @Override
    public void requestUsers() {
        friendsApi.listUsers(TOKEN)
                .subscribeOn(Schedulers.io())
                .observeOn(AndroidSchedulers.mainThread())
                .subscribe(new SimpleSubscriber<UserInfo>() {
                    @Override
                    public void onError(Throwable e) {
                    }

                    @Override
                    public void onNext(UserInfo userInfo) {
                        getBus().publishEvent(new FriendsPageEvents.UsersFetchedEvent(userInfo));
                    }
                });
    }

    @Override
    public void requestShareMethods() {
        Observable.from(InviteMethod.values())
                .subscribeOn(Schedulers.io())
                .observeOn(AndroidSchedulers.mainThread())
                .filter(isDefaultOrInstalled(context))
                .toList()
                .subscribe(new SimpleSubscriber<List<InviteMethod>>() {
                    @Override
                    public void onNext(List<InviteMethod> items) {
                        getBus().publishEvent(new FriendsPageEvents.ShareItemsFetchedEvent(items));
                    }
                });
    }

    @NonNull
    private static Func1<InviteMethod, Boolean> isDefaultOrInstalled(final Context context) {
        return new Func1<InviteMethod, Boolean>() {
            @Override
            public Boolean call(InviteMethod shareWithItem) {
                return shareWithItem.getPackageName() == null || isPackageInstalled(context, shareWithItem.getPackageName());
            }
        };
    }

    private static boolean isPackageInstalled(Context context, String packageName) {
        PackageManager pm = context.getPackageManager();
        try {
            pm.getPackageInfo(packageName, PackageManager.GET_ACTIVITIES);
            return true;
        } catch (PackageManager.NameNotFoundException e) {
            return false;
        }
    }

}
