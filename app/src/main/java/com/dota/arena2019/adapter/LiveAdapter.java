package com.dota.arena2019.adapter;

import android.content.Context;
import android.content.Intent;
import android.support.annotation.NonNull;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import com.dota.arena2019.R;
import com.dota.arena2019.activity.MatchesActivity;
import com.dota.arena2019.model.LiveInfo;

import java.util.ArrayList;

public class LiveAdapter extends RecyclerView.Adapter<LiveAdapter.MyViewHolder> {
    private Context context;
    private ArrayList<LiveInfo> list;
    public LiveAdapter(Context context, ArrayList<LiveInfo> list){
        this.context = context;
        this.list = list;
    }
    @NonNull
    @Override
    public MyViewHolder onCreateViewHolder(@NonNull ViewGroup viewGroup, int i) {
        return new MyViewHolder(LayoutInflater.from(context).inflate(R.layout.card_live_info,viewGroup,false));
    }

    @Override
    public void onBindViewHolder(@NonNull MyViewHolder myViewHolder, final int i) {
        myViewHolder.title.setText(list.get(i).eventName);

        if(list.get(i).count <= 1)
            myViewHolder.count.setText(list.get(i).count+" match in progress");
        else
            myViewHolder.count.setText(list.get(i).count+" matches in progress");

        if(list.get(i).eventName!=null)
            myViewHolder.bg.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View view) {
                    Intent intent = new Intent(context, MatchesActivity.class);
                    intent.putExtra("id", list.get(i).eventID);
                    intent.putExtra("name",list.get(i).eventName);
                    view.getContext().startActivity(intent);
                }
            });
    }

    @Override
    public int getItemCount() {
        return list.size();
    }

    class MyViewHolder extends RecyclerView.ViewHolder{
        TextView title,count;
        View bg;
        public MyViewHolder(View v){
            super(v);
            title = v.findViewById(R.id.title);
            count = v.findViewById(R.id.count);
            bg = v.findViewById(R.id.card);
        }
    }
}
