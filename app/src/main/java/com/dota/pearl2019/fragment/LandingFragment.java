package com.dota.pearl2019.fragment;

import android.content.Context;
import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.support.v7.widget.Toolbar;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.azoft.carousellayoutmanager.CarouselLayoutManager;
import com.azoft.carousellayoutmanager.CarouselZoomPostLayoutListener;
import com.dota.pearl2019.R;
import com.dota.pearl2019.adapter.EventCardsAdapter;
import com.dota.pearl2019.adapter.LandingAdapter;

import java.util.ArrayList;

public class LandingFragment extends Fragment {
    private Context context;
    private RecyclerView recyclerView;
    private ArrayList<String> list = new ArrayList<>();

    @Override
    public void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        context = getContext();

    }

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        return inflater.inflate(R.layout.fragment_landing, container, false);
    }

    @Override
    public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);

        Toolbar toolbar = getActivity().findViewById(R.id.toolbar);
        toolbar.setTitle("Events");


        recyclerView = getActivity().findViewById(R.id.landing_recycler_view);
        list.add("FEED");
        list.add("EVENTS");
        list.add("SCHEDULE");
        list.add("PROSHOW");
        list.add("TALKS");
        list.add("CONTACT");
        list.add("GUIDE");
        list.add("CREDITS");

        recyclerView.setLayoutManager(new LinearLayoutManager(context));
        recyclerView.setHasFixedSize(true);
        recyclerView.setAdapter(new LandingAdapter(list, context));
    }
}
