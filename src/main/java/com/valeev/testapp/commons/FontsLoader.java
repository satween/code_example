package com.valeev.testapp.commons;

import android.content.Context;
import android.graphics.Typeface;

public class FontsLoader {

    private final Context context;
    private final Typeface mediumFont;

    public FontsLoader(Context context) {
        this.context = context;
        mediumFont = Typeface.createFromAsset(context.getAssets(), "Roboto-Medium.ttf");
    }

    public Typeface getMediumFont() {
        return mediumFont;
    }
}
