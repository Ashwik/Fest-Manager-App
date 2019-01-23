package com.dota.arena2019.adapter;

import android.content.Context;
import android.support.annotation.NonNull;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import com.dota.arena2019.R;
import com.dota.arena2019.model.MatchSubset;

import java.util.ArrayList;

public class InnerLiveAdapter2 extends RecyclerView.Adapter<InnerLiveAdapter2.MyViewHolder> {
    Context context;
    ArrayList<MatchSubset> list;
    String teamA,teamB;
    public InnerLiveAdapter2(Context context,ArrayList<MatchSubset> list,String a,String b){
        this.context = context;
        this.list = list;
        teamA = a;
        teamB = b;
    }

    @Override
    public void onBindViewHolder(@NonNull MyViewHolder holder, int i) {
        holder.title.setText(list.get(i).getTitle());
        holder.teamA.setText(this.teamA);
        holder.teamB.setText(this.teamB);
        holder.s1a.setText(list.get(i).getS1a());
        holder.s1b.setText(list.get(i).getS1b());
        holder.s2a.setText(list.get(i).getS2a());
        holder.s2b.setText(list.get(i).getS2b());
        holder.s3a.setText(list.get(i).getS3a());
        holder.s3b.setText(list.get(i).getS3b());
    }

    @NonNull
    @Override
    public MyViewHolder onCreateViewHolder(@NonNull ViewGroup viewGroup, int i) {
        return new MyViewHolder(LayoutInflater.from(context).inflate(R.layout.card_live_type22,viewGroup,false));
    }

    @Override
    public int getItemCount() {
        return list.size();
    }

    class MyViewHolder extends RecyclerView.ViewHolder{
        TextView s1a,s1b,s2a,s2b,s3a,s3b,title,teamA,teamB;
        public MyViewHolder(View v){
            super(v);
            s1a = v.findViewById(R.id.s1A);
            s1b = v.findViewById(R.id.s1B);
            s2a = v.findViewById(R.id.s2A);
            s2b = v.findViewById(R.id.s2B);
            s3a = v.findViewById(R.id.s3A);
            s3b = v.findViewById(R.id.s3B);
            title = v.findViewById(R.id.title);
            teamA = v.findViewById(R.id.teamA);
            teamB = v.findViewById(R.id.teamB);
        }
    }
}
