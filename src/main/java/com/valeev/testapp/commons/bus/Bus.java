package com.valeev.testapp.commons.bus;

public interface Bus {

    void subscribe(Object subscriber);

    void unsubscribe(Object subscriber);

    void publishEvent(Object event);

}
