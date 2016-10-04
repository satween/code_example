package com.valeev.testapp.friends.ui.invite;

import android.content.Context;
import android.support.v4.content.ContextCompat;
import android.support.v7.widget.CardView;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;

import com.valeev.testapp.R;
import com.valeev.testapp.commons.InviteItemSelectedEvent;
import com.valeev.testapp.commons.UIUtils;
import com.valeev.testapp.commons.bus.Bus;
import com.valeev.testapp.commons.recycler.RecyclerViewHolder;
import com.valeev.testapp.friends.entities.InviteMethod;

import static com.valeev.testapp.commons.UIUtils.findViewById;

public class InviteIMethodsItemViewHolder extends RecyclerViewHolder<InviteMethod> {

    private final Context context;
    private final Bus bus;
    private final View itemView;
    private ImageView icon;
    private CardView iconBackground;
    private TextView methodName;

    public InviteIMethodsItemViewHolder(Bus bus, View itemView) {
        super(itemView);
        this.bus = bus;
        this.itemView = itemView;
        context = this.itemView.getContext();
        icon = findViewById(itemView, R.id.icon);
        iconBackground = findViewById(itemView, R.id.icon_bg);
        iconBackground.setCardBackgroundColor(ContextCompat.getColor(context, R.color.cardview_light_background));
        methodName = findViewById(itemView, R.id.invite_method_name);
    }

    @Override
    public void setData(final InviteMethod data, int position) {

        methodName.setText(data.getTextStringRes());
        iconBackground.setCardBackgroundColor(ContextCompat.getColor(context, data.getBackgroundRes()));
        if (data == InviteMethod.OTHER_METHODS) {
            icon.setImageDrawable(UIUtils.getColoredDrawable(context, data.getIconResId(), R.color.orange));
        } else {
            icon.setImageResource(data.getIconResId());
        }

        itemView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                bus.publishEvent(new InviteItemSelectedEvent(data));
            }
        });

    }
}
