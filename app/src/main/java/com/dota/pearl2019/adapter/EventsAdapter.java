package com.dota.pearl2019.adapter;

import android.content.Context;
import android.content.Intent;
import android.support.annotation.DrawableRes;
import android.support.annotation.NonNull;
import android.support.v7.widget.CardView;
import android.support.v7.widget.RecyclerView;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Filter;
import android.widget.Filterable;
import android.widget.FrameLayout;
import android.widget.ImageView;
import android.widget.TextView;

import com.dota.pearl2019.R;
import com.dota.pearl2019.activity.MatchesActivity;
import com.dota.pearl2019.model.EventDetails;

import java.util.ArrayList;
import java.util.List;

public class EventsAdapter extends RecyclerView.Adapter<EventsAdapter.EventViewHolder> implements Filterable {

    private ArrayList<EventDetails> list = new ArrayList<>();
    private Context context;
    private List<EventDetails> filterlist = new ArrayList<>();
    private RowFilter rowFilter;

    public EventsAdapter(ArrayList<EventDetails> list, Context context) {
        this.list = list;
        this.context = context;
        filterlist = list;
//        getFilter();
    }

    @NonNull
    @Override
    public EventsAdapter.EventViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View v = LayoutInflater.from(context).inflate(R.layout.fragment_events_item, parent, false);
        return new EventViewHolder(v);
    }

    @Override
    public void onBindViewHolder(@NonNull EventsAdapter.EventViewHolder holder, final int position) {



        holder.eventName.setText(list.get(position).getName());
        holder.eventView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(context, MatchesActivity.class);
                intent.putExtra("id", list.get(position).getId());
                intent.putExtra("name",list.get(position).getName());
                view.getContext().startActivity(intent);
            }
        });
        holder.eventImage.setImageResource(getFoldedImage(list.get(position).getName().toLowerCase()));
    }

    @Override
    public int getItemCount() {
        return list.size();
    }

    @Override
    public Filter getFilter() {
        Log.e("Filter","received");
        if(rowFilter==null)
        {
            rowFilter = new RowFilter();
        }
        return rowFilter;
    }

    public class EventViewHolder extends RecyclerView.ViewHolder {
        TextView eventName, eventFee, eventPrizemoney;
        CardView eventView;
        ImageView eventImage;
        FrameLayout frameLayout;

        public EventViewHolder(View itemView) {
            super(itemView);
            eventName = itemView.findViewById(R.id.events_name);
//            eventTagLine = itemView.findViewById(R.id.events_tagline);
            eventView = itemView.findViewById(R.id.event_item_cardview);
            eventImage = itemView.findViewById(R.id.event_image);
            frameLayout = itemView.findViewById(R.id.frame_layout_events);
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

    public class RowFilter extends Filter{

        @Override
        protected FilterResults performFiltering(CharSequence charSequence) {
            FilterResults filterResults = new FilterResults();
            return filterResults;
        }

        @Override
        protected void publishResults(CharSequence charSequence, FilterResults filterResults) {
            filterlist = new ArrayList<>();
             if(charSequence!=null&&charSequence.length()>0)
             {
                Log.e("EventsAdapter",charSequence.toString().toLowerCase());
                Log.e("EventsAdapter",String.valueOf(list.size()));
                ArrayList<EventDetails> templist = new ArrayList<>();

                for(int i=0;i<list.size();i++)
                {
                    EventDetails model = list.get(i);
                    String text = charSequence.toString().toLowerCase();
                    Log.e("events adapter1",model.getName().toLowerCase());
                    if(model.getName().toLowerCase().contains(text))
                    {
                        Log.e("events adapter",model.getName().toLowerCase());
                        templist.add(model);
                    }
                }
                filterResults.count = templist.size();
                filterResults.values = templist;
//                filterlist.addAll(templist);
            }
            else
            {
                filterResults.count = list.size();
                filterResults.values = list;
//                filterlist.addAll(list);
            }
            filterlist.clear();
            filterlist.addAll((ArrayList<EventDetails>)filterResults.values);
            Log.e("eventsfilter",String.valueOf(filterlist.size()));
            notifyDataSetChanged();
        }
    }
}