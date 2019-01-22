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
import com.dota.arena2019.model.ResultType1;

import java.util.ArrayList;

public class ResultAdapter1 extends RecyclerView.Adapter<ResultAdapter1.MyViewHolder>{
    private Context context;
    private ArrayList<ResultType1> list;
    public ResultAdapter1(Context context, ArrayList<ResultType1> list){
        this.context = context;
        this.list = list;
    }

    @Override
    public void onBindViewHolder(@NonNull MyViewHolder holder, int i) {
        holder.title.setText(list.get(i).getTitle());
        holder.scoreA.setText(list.get(i).getTeamA()+" ("+list.get(i).getScoreA()+")");
        holder.scoreB.setText(list.get(i).getTeamB()+" ("+list.get(i).getScoreB()+")");
        holder.msg.setText(list.get(i).getMessage());
        switch (list.get(i).getStatus()){
            case 1:
                holder.scoreA.setTextColor(Color.parseColor("#00ff00"));
                holder.scoreB.setTextColor(Color.parseColor("#ff0000"));
                break;
            case 2:
                holder.scoreB.setTextColor(Color.parseColor("#00ff00"));
                holder.scoreA.setTextColor(Color.parseColor("#ff0000"));
                break;
            case 0:
                holder.scoreA.setTextColor(Color.parseColor("#000000"));
                holder.scoreB.setTextColor(Color.parseColor("#000000"));
                break;
        }
    }

    @NonNull
    @Override
    public MyViewHolder onCreateViewHolder(@NonNull ViewGroup viewGroup, int i) {
        return new MyViewHolder(LayoutInflater.from(context).inflate(R.layout.card_result_type1,viewGroup,false));
    }

    @Override
    public int getItemCount() {
        return list.size();
    }

    class MyViewHolder extends RecyclerView.ViewHolder{
        private TextView title,scoreA,scoreB,msg;
        public MyViewHolder(View v){
            super(v);
            title = v.findViewById(R.id.title);
            scoreA = v.findViewById(R.id.scoreA);
            scoreB = v.findViewById(R.id.scoreB);
            msg = v.findViewById(R.id.result);
        }
    }
}
