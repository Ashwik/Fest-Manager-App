package com.dota.arena2019.adapter;

import android.content.Context;
import android.support.annotation.NonNull;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import com.dota.arena2019.R;
import com.dota.arena2019.model.IndividualEvent;

import java.util.ArrayList;

public class IndividualEventAdapter extends RecyclerView.Adapter<IndividualEventAdapter.MyViewHolder> {
    private ArrayList<IndividualEvent> list;
    private Context context;
    public IndividualEventAdapter(Context context, ArrayList<IndividualEvent> list){
        this.context = context;
        this.list = list;
    }
    @Override
    public int getItemCount() {
        return list.size();
    }

    @Override
    public void onBindViewHolder(@NonNull MyViewHolder holder, int i) {
        holder.title.setText(list.get(i).getMsg());
        holder.pos1.setText("Winner - " + list.get(i).getPos1());
        if(list.get(i).getPos2()!=null)
            holder.pos2.setText("Runner up -" + list.get(i).getPos2());
        if(list.get(i).getPos3()!=null)
            holder.pos3.setText("2nd Runner up -" + list.get(i).getPos3());
    }

    @NonNull
    @Override
    public MyViewHolder onCreateViewHolder(@NonNull ViewGroup viewGroup, int i) {
        return new MyViewHolder(LayoutInflater.from(context).inflate(R.layout.individual_event_result,viewGroup,false));
    }

    class MyViewHolder extends RecyclerView.ViewHolder{
        TextView pos1,pos2,pos3,title;
        public MyViewHolder(View v){
            super(v);
            pos1 = v.findViewById(R.id.pos1);
            pos2 = v.findViewById(R.id.pos2);
            pos3 = v.findViewById(R.id.pos3);
            title = v.findViewById(R.id.title);
        }
    }
}
