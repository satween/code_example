package com.valeev.testapp.friends.entities;

import android.support.annotation.ColorRes;
import android.support.annotation.DrawableRes;
import android.support.annotation.StringRes;

import com.valeev.testapp.R;

public enum InviteMethod {

    ADDRESS_BOOK(R.color.address_book_bg, R.drawable.ic_phone_white_24dp, R.string.invite_methods_address_book, null),
    FACEBOOK(R.color.facebook_bg, R.drawable.ic_facebook_white_24dp, R.string.invite_methods_facebook, "com.facebook.katana"),
    MESSENGER(R.color.messenger_bg, R.drawable.ic_facebook_messenger_white_24dp, R.string.invite_methods_messenger, "com.facebook.orca"),
    WHATS_APP(R.color.whatsapp_bg, R.drawable.ic_whatsapp_white_24dp, R.string.invite_methods_whats_app, "com.whatsapp"),
    OTHER_METHODS(R.color.other_methods_bg, R.drawable.ic_share_variant_white_24dp, R.string.invite_methods_other_methods, null);

    private final int backgroundRes;
    private final int iconResId;
    private final int textStringRes;
    private final String packageName;


    InviteMethod(@ColorRes int backgroundRes, @DrawableRes int iconResId, @StringRes int textStringRes, String packageName) {
        this.backgroundRes = backgroundRes;
        this.iconResId = iconResId;
        this.textStringRes = textStringRes;
        this.packageName = packageName;
    }

    @DrawableRes
    public int getBackgroundRes() {
        return backgroundRes;
    }

    @DrawableRes
    public int getIconResId() {
        return iconResId;
    }

    @StringRes
    public int getTextStringRes() {
        return textStringRes;
    }

    public String getPackageName() {
        return packageName;
    }
}
