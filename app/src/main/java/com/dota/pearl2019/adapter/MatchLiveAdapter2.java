package com.dota.pearl2019.adapter;

import android.content.Context;
import android.graphics.Color;
import android.support.annotation.NonNull;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import com.dota.pearl2019.R;
import com.dota.pearl2019.model.LiveMatchType2;
import com.dota.pearl2019.model.MatchSubset;

import java.util.ArrayList;
import java.util.HashMap;

public class MatchLiveAdapter2 extends RecyclerView.Adapter<MatchLiveAdapter2.MyViewHolder> {
    private Context context;
    private ArrayList<LiveMatchType2> list;
    private boolean isLive;
    public MatchLiveAdapter2(Context context, ArrayList<LiveMatchType2> list,boolean isLive){
        this.context = context;
        this.list=list;
        this.isLive = isLive;
    }
    @NonNull
    @Override
    public MyViewHolder onCreateViewHolder(@NonNull ViewGroup viewGroup, int i) {
        return new MyViewHolder(LayoutInflater.from(context).inflate(R.layout.card_live_type21,viewGroup,false));
    }

    @Override
    public void onBindViewHolder(@NonNull final MyViewHolder holder, int i) {
        holder.title.setText(list.get(i).getTitle());
        holder.team1.setText(list.get(i).getTeamA());
        holder.team2.setText(list.get(i).getTeamB());
        ArrayList<HashMap<String,MatchSubset>> set = new ArrayList<>();
        ArrayList<String> titles = new ArrayList<>();
        if(list.get(i).getMatches()!=null)
        {
            for(String key:list.get(i).getMatches().keySet()){
                HashMap<String,MatchSubset> s = list.get(i).getMatches().get(key);
                set.add(s);
                titles.add(key);
            }
        }
        RecyclerView.LayoutManager mLayoutManager2 = new LinearLayoutManager(context);
        holder.recycler.setLayoutManager(mLayoutManager2);

        InnerLiveAdapter2 innerAdapter = new InnerLiveAdapter2(context,set,titles,list.get(i).getTeamA(),list.get(i).getTeamB());
        holder.recycler.setAdapter(innerAdapter);
        innerAdapter.notifyDataSetChanged();

        holder.button.setImageResource(R.drawable.drop_down);
        holder.recycler.setVisibility(View.GONE);

        holder.button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if(holder.recycler.getVisibility()==View.GONE) {
                    holder.button.setImageResource(R.drawable.collapse);
                    holder.recycler.setVisibility(View.VISIBLE);
                }
                else {
                    holder.button.setImageResource(R.drawable.drop_down);
                    holder.recycler.setVisibility(View.GONE);
                }
            }
        });
        if(isLive){
            holder.result.setVisibility(View.GONE);
        }
        else{
            holder.result.setVisibility(View.VISIBLE);
            holder.result.setText(list.get(i).getMessage());
            if(list.get(i).getStatus()!=null){
                if(list.get(i).getStatus().equals("1")){
                    holder.team1.setTextColor(Color.parseColor("#00ff00"));
                    holder.team2.setTextColor(Color.parseColor("#ff0000"));
                }
                else if(list.get(i).getStatus().equals("2")){
                    holder.team2.setTextColor(Color.parseColor("#00ff00"));
                    holder.team1.setTextColor(Color.parseColor("#ff0000"));
                }
                else {
                    holder.team1.setTextColor(Color.parseColor("#000000"));
                    holder.team2.setTextColor(Color.parseColor("#000000"));
                }
            }
        }
    }

    @Override
    public int getItemCount() {
        return list.size();
    }

    class MyViewHolder extends RecyclerView.ViewHolder{
        private TextView title,team1,team2,result;
        private RecyclerView recycler;
        private ImageView button;
        MyViewHolder(View v){
            super(v);
            title = v.findViewById(R.id.title);
            team1 = v.findViewById(R.id.teamA);
            team2 = v.findViewById(R.id.teamB);
            recycler = v.findViewById(R.id.innerRecycler);
            button = v.findViewById(R.id.expand);
            result = v.findViewById(R.id.result);
        }
    }
}
