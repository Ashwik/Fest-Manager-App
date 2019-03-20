package com.dota.pearl2019.adapter;

import android.content.Context;
import android.content.Intent;
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
import com.dota.pearl2019.activity.DetailsActivity;
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
                Intent intent = new Intent(context, DetailsActivity.class);
                intent.putExtra("id",list.get(position).getId());
                view.getContext().startActivity(intent);
            }
        });

        if(list.get(position).getPrize()==null||list.get(position).getPrize().equals(""))
        {
          holder.eventPrizemoney.setVisibility(View.GONE);
        }else{
            holder.eventPrizemoney.setVisibility(View.VISIBLE);
            holder.eventPrizemoney.setText("Prize: "+list.get(position).getPrize());
        }
        if(list.get(position).getPrice()==null||list.get(position).getPrice().equals(""))
        {
            holder.eventFee.setVisibility(View.GONE);
        }else{
            holder.eventFee.setVisibility(View.VISIBLE);
            holder.eventFee.setText("Fee: "+list.get(position).getPrice());
        }


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

            eventFee = itemView.findViewById(R.id.fee_events);
            eventPrizemoney = itemView.findViewById(R.id.prize_money_events);
        }

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