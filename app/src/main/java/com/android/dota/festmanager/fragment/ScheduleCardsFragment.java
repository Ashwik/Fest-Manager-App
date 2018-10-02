package com.android.dota.festmanager.fragment;

import android.content.Context;
import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.android.dota.festmanager.R;
import com.android.dota.festmanager.adapter.ScheduleCardAdapter;

import java.util.ArrayList;

public class ScheduleCardsFragment extends Fragment{

    private ArrayList<String> list = new ArrayList<>();
    private RecyclerView recyclerView;
    private ScheduleCardAdapter scheduleCardAdapter;
    private Context context ;

    @Override
    public void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        context = getContext();

    }

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, Bundle savedInstanceState) {
        return inflater.inflate(R.layout.fragment_schedule_cards,container,false);
    }

    @Override
    public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);
        recyclerView = getActivity().findViewById(R.id.schedule_card_recycler_view);
        list.add("Day1");
        list.add("Day2");
        list.add("Day3");
        setAdapter(list);


    }

    private void setAdapter(ArrayList<String> List){
        recyclerView.setLayoutManager(new LinearLayoutManager(getActivity()));
        recyclerView.setAdapter(new ScheduleCardAdapter(List,context));
    }
}
