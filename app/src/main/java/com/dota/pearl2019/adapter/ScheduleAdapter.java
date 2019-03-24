package com.dota.pearl2019.adapter;

import android.content.Context;
import android.content.Intent;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.LinearLayout;
import android.widget.TextView;

import com.dota.pearl2019.R;
import com.dota.pearl2019.activity.DetailsActivity;
import com.dota.pearl2019.model.EventDetails;

import java.util.ArrayList;
import java.util.List;

import io.realm.Realm;
import io.realm.RealmResults;

/**
 * Created by ashwik on 20-02-2018.
 */

public class ScheduleAdapter extends RecyclerView.Adapter<ScheduleAdapter.ViewHolder> {

    List<String> times;

    Context context;
    private Realm realm;
    private String day;


    public ScheduleAdapter(List<String> times, Context context, String day) {
        this.times = times;
        this.context = context;
        this.day = day;
    }

    @Override
    public ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        Realm.init(context);
        realm = Realm.getDefaultInstance();
        View v = LayoutInflater.from(context).inflate(R.layout.fragment_schedule_item, parent, false);
        ViewHolder viewHolder = new ViewHolder(v);
        return viewHolder;
    }

    @Override
    public void onBindViewHolder(ViewHolder holder, int position) {

        holder.time.setText(times.get(position));
        holder.bindRecycler(times.get(position));

    }

    @Override
    public int getItemCount() {
        if (times != null) {
            return times.size();
        }
        return 0;
    }

    public class ViewHolder extends RecyclerView.ViewHolder {
        TextView time;
        LinearLayout linearLayout;

        public ViewHolder(View itemView) {
            super(itemView);
            time = itemView.findViewById(R.id.time);
            linearLayout = itemView.findViewById(R.id.sub_layout);
        }

        public void bindRecycler(String time) {

            RealmResults<EventDetails> results = realm.where(EventDetails.class).equalTo("date", day).equalTo("startTime", time).findAll();
            final List<EventDetails> sets = new ArrayList<>();
            sets.addAll(results);
            linearLayout.removeAllViews();

            for (int i = 0; i < sets.size(); i++) {
                final EventDetails set = sets.get(i);
                final View v = LayoutInflater.from(context).inflate(R.layout.fragment_schedule_sub_item, linearLayout, false);

                ((TextView) v.findViewById(R.id.event_name)).setText(set.getName());
                if (set.getVenue() == null) {
                    ((TextView) v.findViewById(R.id.event_tagline)).setHeight(0);
                } else {
                    ((TextView) v.findViewById(R.id.event_tagline)).setText("Venue: " + set.getVenue());
                }
                v.findViewById(R.id.schedule_item_cardview).setOnClickListener(new View.OnClickListener() {
                    @Override
                    public void onClick(View view) {
                        Intent intent = new Intent(context, DetailsActivity.class);
                        intent.putExtra("id", set.getId());
                        v.getContext().startActivity(intent);

                    }
                });
                linearLayout.addView(v);
                if (i != sets.size() - 1) {
                    View divider = LayoutInflater.from(context).inflate(R.layout.divider, linearLayout, false);
                    linearLayout.addView(divider);
                }
            }

        }
    }
}