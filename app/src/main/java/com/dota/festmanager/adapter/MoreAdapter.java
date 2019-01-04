package com.dota.festmanager.adapter;

import android.content.Context;
import android.support.annotation.NonNull;
import android.support.v7.widget.RecyclerView;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import com.dota.festmanager.R;

import java.util.ArrayList;

public class MoreAdapter extends RecyclerView.Adapter<MoreAdapter.MoreViewHolder> {

    private Context context;
    private ArrayList<String> moreitemsList = new ArrayList<>();
    public MoreAdapter(Context context,ArrayList<String> moreitemsList) {
        this.context = context;
        this.moreitemsList = moreitemsList;
    }

    @NonNull
    @Override
    public MoreAdapter.MoreViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int i) {
        View v = LayoutInflater.from(context).inflate(R.layout.fragment_more_item, parent, false);
        return new MoreViewHolder(v);
    }

    @Override
    public void onBindViewHolder(@NonNull MoreAdapter.MoreViewHolder holder, int i) {
        holder.moreitemText.setText(moreitemsList.get(i));
    }

    @Override
    public int getItemCount() {
        return moreitemsList.size();
    }


    public class MoreViewHolder extends RecyclerView.ViewHolder{
        TextView moreitemText ;
        public MoreViewHolder(@NonNull View itemView) {
            super(itemView);
            moreitemText = itemView.findViewById(R.id.more_item_text);
        }
    }
}
