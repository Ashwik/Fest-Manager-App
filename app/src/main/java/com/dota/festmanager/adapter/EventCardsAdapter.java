package com.dota.festmanager.adapter;

import android.content.Context;
import android.content.Intent;
import android.support.annotation.NonNull;
import android.support.v7.widget.CardView;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import com.dota.festmanager.R;
import com.dota.festmanager.activity.EventsActivity;

import java.util.ArrayList;

public class EventCardsAdapter extends RecyclerView.Adapter<EventCardsAdapter.EventViewHolder> {

    private ArrayList<String> list = new ArrayList<>();
    private Context context;

    public EventCardsAdapter(ArrayList<String> list, Context context) {
        this.list = list;
        this.context = context;
    }

    @NonNull
    @Override
    public EventViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View v = LayoutInflater.from(context).inflate(R.layout.fragment_cards_item,parent,false);
        return new EventViewHolder(v);
    }

    @Override
    public void onBindViewHolder(@NonNull EventViewHolder holder, final int position) {
            holder.event_cardText.setText(list.get(position));
            holder.event_cardView.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    Intent intent = new Intent(context,EventsActivity.class);
                    intent.putExtra(String.valueOf(R.string.event_type_id),list.get(position));
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

    public class EventViewHolder extends RecyclerView.ViewHolder{
        CardView event_cardView;
        TextView event_cardText;
        public EventViewHolder(View itemView) {
            super(itemView);
            event_cardView = itemView.findViewById(R.id.carousel_item_cardview);
            event_cardText = itemView.findViewById(R.id.event_card_text);
        }
    }
}
