package com.valeev.testapp.commons.bus;

import org.greenrobot.eventbus.EventBus;

public class GreenrobotEventBus implements Bus {

    private final EventBus bus;

    public GreenrobotEventBus(EventBus bus) {
        this.bus = bus;
    }

    @Override
    public void subscribe(Object subscriber) {
        if (!bus.isRegistered(subscriber)) {
            bus.register(subscriber);
        }
    }

    @Override
    public void unsubscribe(Object subscriber) {
        if (bus.isRegistered(subscriber)) {
            bus.unregister(subscriber);
        }
    }

    @Override
    public void publishEvent(Object event) {
        bus.post(event);
    }
}
