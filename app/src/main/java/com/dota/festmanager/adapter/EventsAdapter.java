package com.dota.festmanager.adapter;

import android.content.Context;
import android.content.Intent;
import android.support.annotation.DrawableRes;
import android.support.annotation.NonNull;
import android.support.v7.widget.CardView;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
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


        holder.itemView.setVisibility(View.VISIBLE);
        if(list.get(position).getName().toLowerCase().contains("pool")){
            holder.eventView.setVisibility(View.GONE);
        }
        holder.eventName.setText(list.get(position).getName());
        holder.eventView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(context, DetailsActivity.class);
                intent.putExtra("id", list.get(position).getId());
                v.getContext().startActivity(intent);
            }
        });
        holder.eventImage.setImageResource(getFoldedImage(list.get(position).getName().toLowerCase()));
        if(list.get(position).getName().toLowerCase().contains("pool")){
           holder.itemView.setVisibility(View.GONE);
        }
    }

    @Override
    public int getItemCount() {
        return list.size();
    }

    public class EventViewHolder extends RecyclerView.ViewHolder {
        TextView eventName, eventTagLine, eventFee, eventPrizemoney;
        CardView eventView;
        ImageView eventImage;

        public EventViewHolder(View itemView) {
            super(itemView);
            eventName = itemView.findViewById(R.id.events_name);
//            eventTagLine = itemView.findViewById(R.id.events_tagline);
//            eventFee = itemView.findViewById(R.id.events_fee);
//            eventPrizemoney = itemView.findViewById(R.id.events_prizemoney);
            eventView = itemView.findViewById(R.id.event_item_cardview);
            eventImage = itemView.findViewById(R.id.event_image);

        }

    }
    private @DrawableRes
    int getFoldedImage(String event){
        int resId = R.drawable.event_cricket; // default value

        if (event.contains("athletics")) {
            resId = R.drawable.event_athletics;
        }
        else if (event.contains("badminton")) {
            if (event.contains("boys")) {
                resId = R.drawable.event_badminton_boys;
            } else if (event.contains("girls")) {
                resId = R.drawable.event_badminton_girls;
            } else {
                resId = R.drawable.event_badminton_mixe;
            }
        }
        else if (event.contains("basketball")) {
            if (event.contains("boys")) {
                resId = R.drawable.event_basketboys;
            } else {
                resId = R.drawable.event_basketgirls;
            }
        }
        else if (event.contains("body-building")) {
            resId = R.drawable.event_bodybuilding;
        }
        else if (event.contains("carrom")) {
            resId = R.drawable.event_carrom;
        }
        else if (event.contains("chess")) {
            resId = R.drawable.event_chess;
        }
        else if (event.contains("cricket")) {
            resId = R.drawable.event_cricket;
        }
        else if (event.contains("duathlon")) {
            resId = R.drawable.event_duathlon;
        }
        else if (event.contains("football")) {
            if (event.contains("boys")) {
                resId = R.drawable.event_footballboys;
            } else {
                resId = R.drawable.event_footballgirls;
            }
        }
        else if (event.contains("hockey")) {
            resId = R.drawable.event_hockey;
        }
        else if (event.contains("kabaddi")) {
            resId = R.drawable.event_kabaddi;
        }
        else if (event.contains("pool")) {
            resId = R.drawable.event_cricket;
        }
        else if (event.contains("powerlifting")) {
            resId = R.drawable.event_powerlifting;
        }
        else if (event.contains("snooker")) {
            resId = R.drawable.event_snooker;
        }
        else if (event.contains("squash")) {
            if (event.contains("squash singles")) {
                resId = R.drawable.ev_squash_singles;
            } else {
                resId = R.drawable.event_squash_doubles;
            }

        }
        else if (event.contains("skating")) {
            resId = R.drawable.event_skating;
        }
        else if (event.contains("table tennis")) {
            if (event.contains("boys")) {
                resId = R.drawable.event_tt_boys;
            } else {
                resId = R.drawable.event_tt_girls;
            }

        }
        else if (event.contains("tennis")) {
            if (event.contains("boys")) {
                resId = R.drawable.event_tennis_boys;
            } else {
                resId = R.drawable.event_tennis_girls;
            }
        }
        else if (event.contains("thowball")) {
            resId = R.drawable.event_throwball;
        }
        else if (event.contains("throwball")) {
            resId = R.drawable.event_throwball;
        }
        else if (event.contains("volleyball")) {
            if (event.contains("boys")) {
                resId = R.drawable.ev_volleyball_boys;
            } else {
                resId = R.drawable.ev_volleyball_girls;
            }
        }

        return resId;
    }
}