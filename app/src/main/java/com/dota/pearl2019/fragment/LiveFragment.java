package com.dota.pearl2019.fragment;

/*
 * Created by Prateek Agarwal on 15-01-2019
 */

import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.v4.app.Fragment;
import android.support.v4.widget.SwipeRefreshLayout;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import com.dota.pearl2019.R;
import com.dota.pearl2019.adapter.LiveAdapter;
import com.dota.pearl2019.model.EventDetails;
import com.dota.pearl2019.model.LiveInfo;
import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.database.ValueEventListener;

import java.util.ArrayList;

import io.realm.Realm;

public class LiveFragment extends Fragment {

    private RecyclerView recyclerView;
    private SwipeRefreshLayout swipe;
    private TextView status;
    private ArrayList<LiveInfo> list;
    private LiveAdapter adapter;
    private Realm realm;

    public LiveFragment() {
        // Required empty public constructor
    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View v = inflater.inflate(R.layout.fragment_live, container, false);
        recyclerView = v.findViewById(R.id.events_live);
        swipe = v.findViewById(R.id.swipe_to_refresh_events);
        status = v.findViewById(R.id.live_status);

        list = new ArrayList<>();

        Realm.init(getContext());
        realm = Realm.getDefaultInstance();

        RecyclerView.LayoutManager mLayoutManager = new LinearLayoutManager(getContext());
        recyclerView.setLayoutManager(mLayoutManager);
        adapter = new LiveAdapter(getActivity(), list);
        recyclerView.setAdapter(adapter);

        swipe.setOnRefreshListener(new SwipeRefreshLayout.OnRefreshListener() {
            @Override
            public void onRefresh() {
                update();
            }
        });

        swipe.setRefreshing(true);
        update();
        return v;
    }

    public void update() {
        FirebaseDatabase.getInstance().getReference().child("Scores/Live Matches").addListenerForSingleValueEvent(new ValueEventListener() {
            @Override
            public void onDataChange(@NonNull DataSnapshot dataSnapshot) {
                Log.d("testlive", dataSnapshot.getChildrenCount() + "");
                list.clear();
                for (DataSnapshot ds : dataSnapshot.getChildren()) {
                    Log.d("testlive", ds.getKey());
                    LiveInfo info = new LiveInfo();
                    info.eventID = ds.getKey();
                    info.count = (int) ds.getChildrenCount();
                    EventDetails details = realm.where(EventDetails.class).equalTo("id", info.eventID).findFirst();
                    if (details != null)
                        info.eventName = details.getName();
                    list.add(info);
                }
                if (list.size() == 0) status.setVisibility(View.VISIBLE);
                else status.setVisibility(View.GONE);
                adapter.notifyDataSetChanged();
                swipe.setRefreshing(false);
            }

            @Override
            public void onCancelled(@NonNull DatabaseError databaseError) {

            }
        });
    }

}
