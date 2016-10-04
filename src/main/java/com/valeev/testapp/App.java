package com.valeev.testapp;

import android.app.Application;

import com.valeev.testapp.dagger.AppComponent;
import com.valeev.testapp.dagger.CommonsModule;
import com.valeev.testapp.dagger.DaggerAppComponent;

public class App extends Application {

    private AppComponent appComponent;

    @Override
    public void onCreate() {
        super.onCreate();
        appComponent = DaggerAppComponent.builder()
                .commonsModule(new CommonsModule(getApplicationContext()))
                .build();
    }

    public AppComponent getAppComponent() {
        return appComponent;
    }
}
