package com.dota.pearl2019.adapter;

import android.content.Context;
import android.content.Intent;
import android.support.annotation.NonNull;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.RelativeLayout;
import android.widget.TextView;

import com.dota.pearl2019.R;
import com.dota.pearl2019.activity.HomeActivity;

import java.util.ArrayList;

public class LandingAdapter extends RecyclerView.Adapter<LandingAdapter.EventViewHolder> {

    private ArrayList<String> list = new ArrayList<>();
    private Context context;

    public LandingAdapter(ArrayList<String> list, Context context) {
        this.list = list;
        this.context = context;
    }

    @NonNull
    @Override
    public EventViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View v = LayoutInflater.from(context).inflate(R.layout.fragment_landing_item, parent, false);
        return new EventViewHolder(v);
    }

    @Override
    public void onBindViewHolder(@NonNull EventViewHolder holder, final int position) {
        holder.event_cardText.setText(list.get(position));
        holder.event_cardText_2.setText(list.get(position));
        holder.event_cardView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(context, HomeActivity.class);
                intent.putExtra(String.valueOf(R.string.home_type_id), list.get(position));
                v.getContext().startActivity(intent);
            }
        });
    }

    @Override
    public int getItemCount() {
        if (list != null) {
            return list.size();
        }
        return 0;
    }

    public class EventViewHolder extends RecyclerView.ViewHolder {
        RelativeLayout event_cardView;
        TextView event_cardText, event_cardText_2;

        public EventViewHolder(View itemView) {
            super(itemView);
            event_cardView = itemView.findViewById(R.id.landing_item_cardview);
            event_cardText = itemView.findViewById(R.id.landing_card_text);
            event_cardText_2 = itemView.findViewById(R.id.landing_card_text_2);
        }
    }
}
