package com.dota.arena2019.fragment;

import android.content.ActivityNotFoundException;
import android.content.Context;
import android.content.Intent;
import android.graphics.Color;
import android.net.Uri;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.support.v7.widget.Toolbar;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import com.dota.arena2019.R;
import com.dota.arena2019.adapter.ArticlesAdapter;

import java.util.ArrayList;

public class ArticlesFragment extends Fragment{

    private RecyclerView article_recycler;
    public ArrayList<String> articleitemsList = new ArrayList<>();
    private Context context;
    private ImageView jc_link;
    private String download_link = "https://www.facebook.com/JournalClubBPHC/";

    @Override
    public void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        context = getContext();

    }

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, Bundle savedInstanceState) {
        return inflater.inflate(R.layout.fragment_articles, container, false);
    }

    @Override
    public void onViewCreated(View view, @Nullable Bundle savedInstanceState) {

        TextView title = getActivity().findViewById(R.id.articles_text);
        title.setText("Articles");
        articleitemsList.add("Competitive Gaming");
        articleitemsList.add("Rising importance of sports culture in technical institutions");
        articleitemsList.add("The Sports secretary interview");
        articleitemsList.add("unconventional sports");
        articleitemsList.add("Zero To Hero ");

        jc_link = getActivity().findViewById(R.id.journal_club_link);;

        jc_link.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                try {
                    Intent myIntent = new Intent(Intent.ACTION_VIEW, Uri.parse(download_link));
                    startActivity(myIntent);
                } catch (ActivityNotFoundException e) {
                    Toast.makeText(context,"Web Browser not found",Toast.LENGTH_SHORT).show();
                    e.printStackTrace();
                }
            }
        });

        article_recycler = getActivity().findViewById(R.id.articles_recycler);
        article_recycler.setLayoutManager(new LinearLayoutManager(getActivity()));
        ArticlesAdapter articlesAdapter = new ArticlesAdapter(context,articleitemsList);
        article_recycler.setAdapter(articlesAdapter);

    }
}
