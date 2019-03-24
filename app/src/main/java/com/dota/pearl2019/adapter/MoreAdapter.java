package com.dota.pearl2019.adapter;

import android.content.Context;
import android.content.Intent;
import android.support.annotation.NonNull;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import com.dota.pearl2019.R;
import com.dota.pearl2019.activity.MoreItemsActivity;

import java.util.ArrayList;

public class MoreAdapter extends RecyclerView.Adapter<MoreAdapter.MoreViewHolder> {

    private Context context;
    private ArrayList<String> moreitemsList = new ArrayList<>();

    public MoreAdapter(Context context, ArrayList<String> moreitemsList) {
        this.context = context;
        this.moreitemsList = moreitemsList;
    }

    @NonNull
    @Override
    public MoreAdapter.MoreViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int i) {
        View v = LayoutInflater.from(context).inflate(R.layout.fragment_more_item_2, parent, false);
        return new MoreViewHolder(v);
    }

    @Override
    public void onBindViewHolder(@NonNull MoreAdapter.MoreViewHolder holder, final int i) {
        holder.moreitemText.setText(moreitemsList.get(i));
        holder.moreitemText2.setText(moreitemsList.get(i));

        holder.itemView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(context, MoreItemsActivity.class);
                intent.putExtra("position", i);
                view.getContext().startActivity(intent);
            }
        });
        switch (i) {
            case 1:
                holder.moreitemIcon.setImageResource(R.drawable.reachus);
                holder.moreitemIcon2.setImageResource(R.drawable.reachus);
                break;
            case 2:
                holder.moreitemIcon.setImageResource(R.drawable.map);
                holder.moreitemIcon2.setImageResource(R.drawable.map);
                break;
            case 3:
                holder.moreitemIcon.setImageResource(R.drawable.ic_baseline_settings_20px);
                holder.moreitemIcon2.setImageResource(R.drawable.ic_baseline_settings_20px);
                break;
            case 0:
                holder.moreitemIcon.setImageResource(R.drawable.aboutus);
                holder.moreitemIcon2.setImageResource(R.drawable.aboutus);
                break;
        }
    }

    @Override
    public int getItemCount() {
        return moreitemsList.size();
    }


    public class MoreViewHolder extends RecyclerView.ViewHolder {
        TextView moreitemText, moreitemText2;
        ImageView moreitemIcon, moreitemIcon2;

        public MoreViewHolder(@NonNull View itemView) {
            super(itemView);
            moreitemText = itemView.findViewById(R.id.more_item_text_1);
            moreitemIcon = itemView.findViewById(R.id.more_item_icon_1);
            moreitemText2 = itemView.findViewById(R.id.more_item_text_2);
            moreitemIcon2 = itemView.findViewById(R.id.more_item_icon_2);
        }
    }
}
