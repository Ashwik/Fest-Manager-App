package com.dota.pearl2019.adapter;

import android.content.Context;
import android.support.annotation.NonNull;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import com.dota.pearl2019.R;
import com.dota.pearl2019.model.LiveMatchType1;

import java.util.ArrayList;

public class MatchLiveAdapter1 extends RecyclerView.Adapter<MatchLiveAdapter1.MyViewHolder> {
    private Context context;
    private ArrayList<LiveMatchType1> list;
    public MatchLiveAdapter1(Context context, ArrayList<LiveMatchType1> list){
        this.context = context;
        this.list = list;
    }

    @Override
    public void onBindViewHolder(@NonNull MyViewHolder holder, int i) {
        holder.title.setText(list.get(i).getTitle());
        holder.team1.setText(list.get(i).getTeamA());
        holder.team2.setText(list.get(i).getTeamB());
        holder.scoreA.setText(list.get(i).getScoreA());
        holder.scoreB.setText(list.get(i).getScoreB());
    }

    @NonNull
    @Override
    public MyViewHolder onCreateViewHolder(@NonNull ViewGroup viewGroup, int i) {
        return new MyViewHolder(LayoutInflater.from(context).inflate(R.layout.card_live_type1,viewGroup,false));
    }

    @Override
    public int getItemCount() {
        return list.size();
    }

    class MyViewHolder extends RecyclerView.ViewHolder{
        private TextView title,team1,team2,scoreA,scoreB;
        public MyViewHolder(View v){
            super(v);
            title = v.findViewById(R.id.title);
            team1 = v.findViewById(R.id.teamA);
            team2 = v.findViewById(R.id.teamB);
            scoreA = v.findViewById(R.id.scoreA);
            scoreB = v.findViewById(R.id.scoreB);
        }
    }
}
