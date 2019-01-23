package com.dota.arena2019.adapter;

import android.content.Context;
import android.support.annotation.NonNull;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.LinearLayout;
import android.widget.TextView;

import com.dota.arena2019.R;
import com.dota.arena2019.model.MatchSubset;

import java.util.ArrayList;
import java.util.HashMap;

public class InnerLiveAdapter2 extends RecyclerView.Adapter<InnerLiveAdapter2.MyViewHolder> {
    Context context;
    ArrayList<HashMap<String,MatchSubset>> list;
    ArrayList<String> titles;
    String teamA,teamB;
    public InnerLiveAdapter2(Context context, ArrayList<HashMap<String,MatchSubset>> list, ArrayList<String> titles,String a, String b){
        this.context = context;
        this.list = list;
        this.titles = titles;
        teamA = a;
        teamB = b;
    }

    @Override
    public void onBindViewHolder(@NonNull MyViewHolder holder, int i) {
        holder.title.setText(titles.get(i));
        holder.teamA.setText(this.teamA);
        holder.teamB.setText(this.teamB);
        for(String key:list.get(i).keySet()){
            View x = LayoutInflater.from(context).inflate(R.layout.set_row,null);
            ((TextView)x.findViewById(R.id.sName)).setText(key);
            ((TextView)x.findViewById(R.id.sA)).setText(list.get(i).get(key).getA());
            ((TextView)x.findViewById(R.id.sB)).setText(list.get(i).get(key).getB());
            holder.outer.addView(x);
        }
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
        TextView title,teamA,teamB;
        LinearLayout outer;
        public MyViewHolder(View v){
            super(v);
            outer = v.findViewById(R.id.outerLL);
            title = v.findViewById(R.id.title);
            teamA = v.findViewById(R.id.teamA);
            teamB = v.findViewById(R.id.teamB);
        }
    }
}
