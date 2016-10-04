package com.valeev.testapp.dagger;

import android.content.Context;

import com.valeev.testapp.commons.FontsLoader;
import com.valeev.testapp.commons.bus.Bus;
import com.valeev.testapp.commons.bus.GreenrobotEventBus;

import org.greenrobot.eventbus.EventBus;

import javax.inject.Singleton;

import dagger.Module;
import dagger.Provides;

@Module
@Singleton
public class CommonsModule {
    private final Context context;

    public CommonsModule(Context context) {
        this.context = context;
    }

    @Provides
    public Context provideContext() {
        return context;
    }

    @Provides
    public Bus provideBus() {
        return new GreenrobotEventBus(EventBus.getDefault());
    }

    @Provides
    public FontsLoader provideFonts() {
        return new FontsLoader(context);
    }
}
