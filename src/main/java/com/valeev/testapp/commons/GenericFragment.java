package com.valeev.testapp.commons;

import android.os.Bundle;
import android.support.annotation.LayoutRes;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.valeev.testapp.App;
import com.valeev.testapp.dagger.AppComponent;

public abstract class GenericFragment extends Fragment implements Mvp.View {

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View view = inflater.inflate(getLayoutId(), container, false);
        setHasOptionsMenu(true);
        App application = (App) getActivity().getApplication();
        inject(application.getAppComponent());
        bindViews(view);
        return view;
    }

    protected abstract void inject(AppComponent appComponent);

    @LayoutRes
    protected abstract int getLayoutId();
}
