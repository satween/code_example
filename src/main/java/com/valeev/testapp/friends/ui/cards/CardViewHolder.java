package com.valeev.testapp.friends.ui.cards;

import android.content.Context;
import android.support.v4.content.ContextCompat;
import android.support.v7.widget.CardView;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;

import com.bumptech.glide.Glide;
import com.valeev.testapp.R;
import com.valeev.testapp.commons.FontsLoader;
import com.valeev.testapp.commons.recycler.RecyclerViewHolder;
import com.valeev.testapp.friends.entities.Result;

import static com.valeev.testapp.commons.UIUtils.findViewById;

public class CardViewHolder extends RecyclerViewHolder<Result> {

    public static final int COVER = 0;

    private final TextView name;
    private final TextView location;
    private final TextView pregnancy;
    private final ImageView avatar;
    private final Context context;
    private final TextView momFilter;
    private final CardView cardView;

    int whiteColor;
    int blueColor;

    public CardViewHolder(View itemView, FontsLoader fontsLoader) {
        super(itemView);
        this.context = itemView.getContext();

        cardView = ((CardView) itemView);
        whiteColor = ContextCompat.getColor(context, R.color.cardview_light_background);
        blueColor = ContextCompat.getColor(context, R.color.color_cover);
        cardView.setCardBackgroundColor(whiteColor);
        avatar = findViewById(itemView, R.id.avatar);
        name = findViewById(itemView, R.id.screen_name);
        name.setTypeface(fontsLoader.getMediumFont());

        pregnancy = findViewById(itemView, R.id.pregnancy);
        location = findViewById(itemView, R.id.loacation);
        momFilter = findViewById(itemView, R.id.mom_filter);
        momFilter.setTypeface(fontsLoader.getMediumFont());
    }


    @Override
    public void setData(Result user, int position) {
        if (position == COVER) {
            itemView.findViewById(R.id.cover).setVisibility(View.VISIBLE);
            itemView.findViewById(R.id.card).setVisibility(View.GONE);
            cardView.setCardBackgroundColor(blueColor);

        } else {
            cardView.setCardBackgroundColor(whiteColor);

            Glide.with(context)
                    .load(user.getAvatar().getFullUrl())
                    .crossFade()
                    .centerCrop()
                    .into(avatar);

            cardView.setPreventCornerOverlap(false);

            name.setText(user.getLogin());
            pregnancy.setText(String.valueOf(user.getPregnancySettings().getPregnancy()));
            location.setText(user.getLocality());

            itemView.findViewById(R.id.cover).setVisibility(View.GONE);
            itemView.findViewById(R.id.card).setVisibility(View.VISIBLE);
        }
    }
}