package com.dota.pearl2019.adapter;

import android.content.Context;
import android.support.annotation.NonNull;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;

import com.dota.pearl2019.R;

public class TalksAdapter extends RecyclerView.Adapter<TalksAdapter.TalksViewHolder> {
    private  Context context;
    public TalksAdapter(Context context)
    {
        this.context = context;
    }
    @NonNull
    @Override
    public TalksViewHolder onCreateViewHolder(@NonNull ViewGroup viewGroup, int i) {
        View v = LayoutInflater.from(context).inflate(R.layout.card_talks, viewGroup, false);
        return new TalksViewHolder(v);
    }

    @Override
    public void onBindViewHolder(@NonNull TalksViewHolder talksViewHolder, int i) {

    }

    @Override
    public int getItemCount() {
        return 3;
    }

    public class TalksViewHolder extends RecyclerView.ViewHolder {
        ImageView talksImages;
        public TalksViewHolder(@NonNull View itemView) {
            super(itemView);
            talksImages = itemView.findViewById(R.id.talksImage);
        }
    }
}
