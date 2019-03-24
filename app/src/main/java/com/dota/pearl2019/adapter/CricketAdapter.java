package com.dota.pearl2019.adapter;

import android.content.Context;
import android.support.annotation.NonNull;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import com.dota.pearl2019.R;
import com.dota.pearl2019.model.LiveCricket;

import java.util.ArrayList;

public class CricketAdapter extends RecyclerView.Adapter<CricketAdapter.MyViewHolder> {
    private Context context;
    private ArrayList<LiveCricket> list;

    public CricketAdapter(Context context, ArrayList<LiveCricket> list) {
        this.context = context;
        this.list = list;
    }

    @Override
    public void onBindViewHolder(@NonNull MyViewHolder holder, int i) {
        holder.title.setText(list.get(i).getTitle());
        holder.message.setText(list.get(i).getDesc());

        if (list.get(i).getT1() == null) {
            holder.team1.setText("-");
            holder.team2.setText("-");
            holder.scoreA.setText("0/0 (0.0)");
            holder.scoreB.setText("-");
        } else if (list.get(i).getT1().equals("A")) {
            holder.team1.setText(list.get(i).getTeamA());
            holder.team2.setText(list.get(i).getTeamB());
            holder.scoreA.setText(list.get(i).getScoreA());
        } else if (list.get(i).getT1().equals("B")) {
            holder.team1.setText(list.get(i).getTeamB());
            holder.team2.setText(list.get(i).getTeamA());
            holder.scoreA.setText(list.get(i).getScoreB());
        }

        if (list.get(i).getInning() == null || list.get(i).getT1() == null)
            return;

        if (list.get(i).getInning().equals("1"))
            holder.scoreB.setText("-");
        else {
            if (list.get(i).getT1().equals("A"))
                holder.scoreB.setText(list.get(i).getScoreB());
            else
                holder.scoreB.setText(list.get(i).getScoreA());
        }
    }

    @NonNull
    @Override
    public MyViewHolder onCreateViewHolder(@NonNull ViewGroup viewGroup, int i) {
        return new MyViewHolder(LayoutInflater.from(context).inflate(R.layout.card_cricket, viewGroup, false));
    }

    @Override
    public int getItemCount() {
        return list.size();
    }

    class MyViewHolder extends RecyclerView.ViewHolder {
        private TextView title, team1, team2, scoreA, scoreB, message;

        public MyViewHolder(View v) {
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
