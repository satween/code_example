package com.valeev.testapp.friends;

import com.valeev.testapp.friends.entities.InviteMethod;
import com.valeev.testapp.friends.entities.UserInfo;

import java.util.List;

public interface FriendsPageEvents {

    class UsersFetchedEvent {

        private final UserInfo userInfo;

        public UsersFetchedEvent(UserInfo userInfo) {
            this.userInfo = userInfo;
        }

        public UserInfo getUserInfo() {
            return userInfo;
        }
    }

    class ShareItemsFetchedEvent {
        private final List<InviteMethod> items;

        public ShareItemsFetchedEvent(List<InviteMethod> items) {
            this.items = items;
        }

        public List<InviteMethod> getItems() {
            return items;
        }
    }
}
