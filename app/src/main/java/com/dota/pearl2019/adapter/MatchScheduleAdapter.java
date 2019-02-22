package com.dota.pearl2019.adapter;

import android.content.Context;
import android.support.annotation.NonNull;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import com.dota.pearl2019.R;
import com.dota.pearl2019.model.MatchDetails;

import java.util.ArrayList;

public class MatchScheduleAdapter extends RecyclerView.Adapter<MatchScheduleAdapter.MyViewHolder>{
    private Context context;
    private ArrayList<MatchDetails> list;
    public MatchScheduleAdapter(Context context, ArrayList<MatchDetails> list){
        this.context = context;
        this.list = list;
    }

    @Override
    public void onBindViewHolder(@NonNull MyViewHolder holder, int i) {
        holder.title.setText(list.get(i).getTitle());
        holder.team1.setText(list.get(i).getTeamA());
        holder.team2.setText(list.get(i).getTeamB());
        holder.time.setText(list.get(i).getDate()+" || "+list.get(i).getTime());
    }

    @NonNull
    @Override
    public MyViewHolder onCreateViewHolder(@NonNull ViewGroup viewGroup, int i) {
        return new MyViewHolder(LayoutInflater.from(context).inflate(R.layout.card_match_schedule,viewGroup,false));
    }

    @Override
    public int getItemCount() {
        return list.size();
    }

    class MyViewHolder extends RecyclerView.ViewHolder{
        private TextView title,team1,team2,time;
        public MyViewHolder(View v){
            super(v);
            title = v.findViewById(R.id.title);
            team1 = v.findViewById(R.id.team1);
            team2 = v.findViewById(R.id.team2);
            time = v.findViewById(R.id.time);
        }
    }
}
