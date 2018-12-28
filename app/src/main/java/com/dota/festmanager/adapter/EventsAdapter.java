package com.dota.festmanager.adapter;

import android.content.Context;
import android.content.Intent;
import android.support.annotation.NonNull;
import android.support.v7.widget.CardView;
import android.support.v7.widget.RecyclerView;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import com.dota.festmanager.R;
import com.dota.festmanager.activity.DetailsActivity;
import com.dota.festmanager.model.EventDetails;

import java.util.ArrayList;

public class EventsAdapter extends RecyclerView.Adapter<EventsAdapter.EventViewHolder> {

    private ArrayList<EventDetails> list = new ArrayList<>();
    private Context context;

    public EventsAdapter(ArrayList<EventDetails> list, Context context) {
        this.list = list;
        this.context = context;
    }

    @NonNull
    @Override
    public EventsAdapter.EventViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View v = LayoutInflater.from(context).inflate(R.layout.fragment_events_item, parent, false);
        return new EventViewHolder(v);
    }

    @Override
    public void onBindViewHolder(@NonNull EventsAdapter.EventViewHolder holder, final int position) {

            holder.eventView.setVisibility(View.VISIBLE);
            holder.eventName.setText(list.get(position).getName());
            holder.eventTagLine.setVisibility(View.VISIBLE);
            holder.eventPrizemoney.setVisibility(View.VISIBLE);
            holder.eventFee.setVisibility(View.VISIBLE);
            if (list.get(position).getTagline() == null || list.get(position).getTagline().equals("")) {
                holder.eventTagLine.setVisibility(View.GONE);
            } else {
                holder.eventTagLine.setText(list.get(position).getTagline());
            }
            if (list.get(position).getPrice() == null || list.get(position).getPrice().equals("")) {
                holder.eventFee.setVisibility(View.GONE);
            } else {
                holder.eventFee.setText("Fee: " + list.get(position).getPrice());
            }
            if (list.get(position).getPrize() == null || list.get(position).getPrize().equals("")) {
                holder.eventPrizemoney.setVisibility(View.GONE);
            } else {
                holder.eventPrizemoney.setText("Prize: " + list.get(position).getPrize());
            }

            holder.eventView.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    Intent intent = new Intent(context, DetailsActivity.class);
                    intent.putExtra("id", list.get(position).getId());
                    v.getContext().startActivity(intent);
                }
            });

    }

    @Override
    public int getItemCount() {
        return list.size();
    }

    public class EventViewHolder extends RecyclerView.ViewHolder {
        TextView eventName,eventTagLine ,eventFee ,eventPrizemoney;
        CardView eventView ;

        public EventViewHolder(View itemView) {
            super(itemView);
            eventName = itemView.findViewById(R.id.events_name);
            eventTagLine = itemView.findViewById(R.id.events_tagline);
            eventFee = itemView.findViewById(R.id.events_fee);
            eventPrizemoney = itemView.findViewById(R.id.events_prizemoney);
            eventView = itemView.findViewById(R.id.event_item_cardview);

        }

    }
}