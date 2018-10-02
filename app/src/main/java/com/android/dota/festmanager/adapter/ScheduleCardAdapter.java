package com.android.dota.festmanager.adapter;

import android.content.Context;
import android.support.annotation.NonNull;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import com.android.dota.festmanager.R;

import java.util.ArrayList;

public class ScheduleCardAdapter extends RecyclerView.Adapter<ScheduleCardAdapter.ScheduleViewHolder> {

    private ArrayList<String> list = new ArrayList<>() ;
    private Context context;

    public ScheduleCardAdapter(ArrayList<String> list, Context context) {
        this.list = list;
        this.context = context;
    }

    @NonNull
    @Override
    public ScheduleViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View v = LayoutInflater.from(context).inflate(R.layout.fragment_schedule_cards_item,parent,false);
        return new ScheduleViewHolder(v);
    }

    @Override
    public void onBindViewHolder(@NonNull ScheduleViewHolder holder, int position) {
            holder.schedule_text.setText(list.get(position));
    }

    @Override
    public int getItemCount() {
        if(list!=null) {
            return list.size();
        }
        return  0;
    }

    public class ScheduleViewHolder extends RecyclerView.ViewHolder{
        TextView schedule_text;
        public ScheduleViewHolder(View itemView) {
            super(itemView);
            schedule_text = itemView.findViewById(R.id.schedule_day);
        }
    }


}
