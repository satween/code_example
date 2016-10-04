package com.valeev.testapp.commons;

import com.valeev.testapp.friends.entities.InviteMethod;

public class InviteItemSelectedEvent {

    private final InviteMethod inviteMethod;

    public InviteItemSelectedEvent(InviteMethod inviteMethod) {
        this.inviteMethod = inviteMethod;
    }

    public InviteMethod getInviteMethod() {
        return inviteMethod;
    }
}
