package com.valeev.testapp.friends;

import android.animation.ValueAnimator;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.support.v7.widget.SearchView;
import android.view.LayoutInflater;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.view.View;

import com.valeev.testapp.R;
import com.valeev.testapp.commons.FontsLoader;
import com.valeev.testapp.commons.GenericFragment;
import com.valeev.testapp.commons.bus.Bus;
import com.valeev.testapp.commons.recycler.DrawableDivider;
import com.valeev.testapp.dagger.AppComponent;
import com.valeev.testapp.friends.entities.InviteMethod;
import com.valeev.testapp.friends.entities.Result;
import com.valeev.testapp.friends.entities.UserInfo;
import com.valeev.testapp.friends.ui.cards.CardsAdapter;
import com.valeev.testapp.friends.ui.cards.CardsDecorator;
import com.valeev.testapp.friends.ui.cards.CardsScrollerManager;
import com.valeev.testapp.friends.ui.invite.InviteMethodsAdapter;

import java.util.ArrayList;
import java.util.List;

import javax.inject.Inject;

import static com.valeev.testapp.commons.UIUtils.findViewById;

public class MoreFriendsFragment extends GenericFragment implements FriendsPageMvp.View {

    @Inject
    protected Bus bus;
    @Inject
    protected FontsLoader fontsLoader;
    @Inject
    protected FriendsPageMvp.Presenter presenter;

    private CardsAdapter cardsAdapter;
    private InviteMethodsAdapter inviteMethodsAdapter;
    private RecyclerView slider;
    private View progress;

    @Override
    public void bindViews(View view) {
        int spaceBetweenCards = (int) getContext().getResources().getDimension(R.dimen.cards_offsets);
        final int leftSpace = (int) getContext().getResources().getDimension(R.dimen.left_space);

        progress = findViewById(view, R.id.progress_bar);
        slider = findViewById(view, R.id.users_slider);
        final CardsScrollerManager layoutManager = new CardsScrollerManager(getContext(), LinearLayoutManager.HORIZONTAL, false);
        slider.setLayoutManager(layoutManager);
        slider.setAdapter(cardsAdapter = new CardsAdapter(LayoutInflater.from(getContext()), fontsLoader));
        slider.addItemDecoration(new CardsDecorator(spaceBetweenCards, leftSpace));


        slider.addOnScrollListener(new RecyclerView.OnScrollListener() {
            private ValueAnimator valueAnimator;
            int nearestItemPos = 0;
            int center = 0;
            boolean ignoring;


            @Override
            public void onScrollStateChanged(RecyclerView recyclerView, int newState) {
                setValues();
                View firstItem = layoutManager.findViewByPosition(0);
                if (firstItem != null && firstItem.getLeft() == leftSpace) {
                    return;
                }

                recyclerView.smoothScrollBy(nearestItemPos - center, 0);
            }

            @Override
            public void onScrolled(RecyclerView recyclerView, int dx, int dy) {
                setValues();
                if (nearestItemPos - center == 0) {
                    recyclerView.stopScroll();
                }
            }

            private void setValues() {
                View item = layoutManager.findViewByPosition(layoutManager.findFirstVisibleItemPosition() + 1);
                nearestItemPos = item.getLeft() + item.getWidth() / 2;
                center = MoreFriendsFragment.this.getView().getWidth() / 2;
            }
        });

        RecyclerView inviteMethods = findViewById(view, R.id.invite_from);
        inviteMethods.setLayoutManager(new LinearLayoutManager(getContext()));
        inviteMethods.setAdapter(inviteMethodsAdapter = new InviteMethodsAdapter(bus, LayoutInflater.from(getContext())));
        inviteMethods.addItemDecoration(new DrawableDivider(getContext(), R.drawable.default_list_divider));
    }

    @Override
    protected int getLayoutId() {
        return R.layout.fragment_more_friends;
    }

    @Override
    protected void inject(AppComponent appComponent) {
        appComponent.inject(this);
    }

    @Override
    public void onStart() {
        super.onStart();
        presenter.onStart(this);
    }

    @Override
    public void onStop() {
        super.onStop();
        presenter.onStart(this);
    }

    @Override
    public void onCreateOptionsMenu(Menu menu, MenuInflater inflater) {
        inflater.inflate(R.menu.search, menu);
        MenuItem item = menu.getItem(0);
        SearchView searchView = (SearchView) item.getActionView();
        searchView.setIconified(true);
        searchView.setIconifiedByDefault(true);
        searchView.setQueryHint(getString(R.string.search_hint));
    }

    @Override
    public void updateUsers(UserInfo userInfo) {
        List<Result> users = new ArrayList<>(userInfo.getResult().size() + 1);
        users.add(new Result());
        users.addAll(userInfo.getResult());
        cardsAdapter.update(users);
        slider.setVisibility(View.VISIBLE);
        progress.setVisibility(View.GONE);
    }

    @Override
    public void updateShareMethod(List<InviteMethod> items) {
        inviteMethodsAdapter.update(items);
    }
}
