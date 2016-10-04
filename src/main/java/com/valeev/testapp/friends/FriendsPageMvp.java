package com.valeev.testapp.friends;

import com.valeev.testapp.commons.Mvp;
import com.valeev.testapp.commons.bus.Bus;
import com.valeev.testapp.friends.entities.InviteMethod;
import com.valeev.testapp.friends.entities.UserInfo;

import java.util.List;

public interface FriendsPageMvp {

    abstract class Model extends Mvp.Model {
        public Model(Bus bus) {
            super(bus);
        }

        abstract void requestUsers();

        abstract void requestShareMethods();
    }

    abstract class Presenter extends Mvp.Presenter<FriendsPageMvp.Model, FriendsPageMvp.View> {
        public Presenter(Bus bus, FriendsPageMvp.Model model) {
            super(bus, model);
        }
    }

    interface View extends Mvp.View {

        void updateUsers(UserInfo userInfo);

        void updateShareMethod(List<InviteMethod> items);

        FriendsPageMvp.View EMPTY = new View() {

            @Override
            public void updateUsers(UserInfo userInfo) {

            }

            @Override
            public void updateShareMethod(List<InviteMethod> items) {

            }

            @Override
            public void bindViews(android.view.View root) {

            }
        };
    }
}
