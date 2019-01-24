package com.dota.arena2019.adapter;

import android.content.Context;
import android.graphics.Color;
import android.support.annotation.NonNull;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import com.dota.arena2019.R;
import com.dota.arena2019.model.CricketResult;
import com.dota.arena2019.model.LiveCricket;
import com.dota.arena2019.model.LiveMatchType1;

import java.util.ArrayList;

public class CricketResultAdapter extends RecyclerView.Adapter<CricketResultAdapter.MyViewHolder> {
    private Context context;
    private ArrayList<CricketResult> list;
    public CricketResultAdapter(Context context, ArrayList<CricketResult> list){
        this.context = context;
        this.list = list;
    }

    @Override
    public void onBindViewHolder(@NonNull MyViewHolder holder, int i) {
        holder.title.setText(list.get(i).getTitle());
        holder.message.setText(list.get(i).getMessage());

        if(list.get(i).getT1().equals("A")) {
            holder.team1.setText(list.get(i).getTeamA());
            holder.team2.setText(list.get(i).getTeamB());
            holder.scoreA.setText(list.get(i).getScoreA());
            holder.scoreB.setText(list.get(i).getScoreB());
        }
        else if(list.get(i).getT1().equals("B")){
            holder.team1.setText(list.get(i).getTeamB());
            holder.team2.setText(list.get(i).getTeamA());
            holder.scoreA.setText(list.get(i).getScoreB());
            holder.scoreB.setText(list.get(i).getScoreA());
        }
        if(list.get(i).getStatus().equals("0")){
            holder.team1.setTextColor(Color.parseColor("#000000"));
            holder.scoreA.setTextColor(Color.parseColor("#000000"));
            holder.team2.setTextColor(Color.parseColor("#000000"));
            holder.scoreB.setTextColor(Color.parseColor("#000000"));
        }
        else if((list.get(i).getStatus().equals("1")&&list.get(i).getT1().equals("A"))||(list.get(i).getStatus().equals("2")&&list.get(i).getT1().equals("B")))
        {
            holder.team1.setTextColor(Color.parseColor("#00ff00"));
            holder.scoreA.setTextColor(Color.parseColor("#00ff00"));
            holder.team2.setTextColor(Color.parseColor("#ff0000"));
            holder.scoreB.setTextColor(Color.parseColor("#ff0000"));
        }
        else{
            holder.team1.setTextColor(Color.parseColor("#ff0000"));
            holder.scoreA.setTextColor(Color.parseColor("#ff0000"));
            holder.team2.setTextColor(Color.parseColor("#00ff00"));
            holder.scoreB.setTextColor(Color.parseColor("#00ff00"));
        }
    }

    @NonNull
    @Override
    public MyViewHolder onCreateViewHolder(@NonNull ViewGroup viewGroup, int i) {
        return new MyViewHolder(LayoutInflater.from(context).inflate(R.layout.card_cricket,viewGroup,false));
    }

    @Override
    public int getItemCount() {
        return list.size();
    }

    class MyViewHolder extends RecyclerView.ViewHolder{
        private TextView title,team1,team2,scoreA,scoreB,message;
        public MyViewHolder(View v){
            super(v);
            title = v.findViewById(R.id.title);
            team1 = v.findViewById(R.id.teamA);
            team2 = v.findViewById(R.id.teamB);
            scoreA = v.findViewById(R.id.scoreA);
            scoreB = v.findViewById(R.id.scoreB);
            message = v.findViewById(R.id.status);
        }
    }
}
