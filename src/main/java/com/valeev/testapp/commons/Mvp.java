package com.valeev.testapp.commons;

import com.valeev.testapp.commons.bus.Bus;

public interface Mvp {

    abstract class Model {
        private final Bus bus;

        public Model(Bus bus) {
            this.bus = bus;
        }

        public Bus getBus() {
            return bus;
        }
    }

    interface View {
        void bindViews(android.view.View root);
    }

    abstract class Presenter<M extends Mvp.Model, V extends Mvp.View> {
        private final Bus bus;
        private final M model;

        public Presenter(Bus bus, M model) {
            this.bus = bus;
            this.model = model;
        }

        public Bus getBus() {
            return bus;
        }

        public M getModel() {
            return model;
        }

        public abstract void onStart(V view);

        public abstract void onStop(V view);
    }
}
