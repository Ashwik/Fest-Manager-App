package com.dota.pearl2019.adapter;

import android.content.Context;
import android.content.Intent;
import android.support.annotation.NonNull;
import android.support.v7.widget.CardView;
import android.support.v7.widget.RecyclerView;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import com.dota.pearl2019.R;
import com.dota.pearl2019.activity.ArticleDetailActivity;

import java.util.ArrayList;

public class ArticlesAdapter extends RecyclerView.Adapter<ArticlesAdapter.ArticlesViewHolder> {

    private Context context;
    private ArrayList<String> articlesitemsList = new ArrayList<>();

    public ArticlesAdapter(Context context, ArrayList<String> articlesitemsList) {
        this.context = context;
        this.articlesitemsList = articlesitemsList;
    }

    @NonNull
    @Override
    public ArticlesViewHolder onCreateViewHolder(@NonNull ViewGroup viewGroup, int i) {
        View v = LayoutInflater.from(context).inflate(R.layout.fragment_articles_item, viewGroup, false);
        return new ArticlesAdapter.ArticlesViewHolder(v);
    }

    @Override
    public void onBindViewHolder(@NonNull ArticlesViewHolder holder,final int i) {
        holder.title.setText(articlesitemsList.get(i));

        holder.title.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Log.e("Articles","Working");
                Intent intent = new Intent(context, ArticleDetailActivity.class);
                intent.putExtra("id1",i);
                view.getContext().startActivity(intent);
            }
        });
    }

    @Override
    public int getItemCount() {
        return articlesitemsList.size();
    }

    public class ArticlesViewHolder extends RecyclerView.ViewHolder{
        TextView title;
        CardView cardView;
        public ArticlesViewHolder(@NonNull View itemView) {
            super(itemView);
            title = itemView.findViewById(R.id.articletitle);
            cardView = itemView.findViewById(R.id.article_item_cardview);
        }
    }
}
