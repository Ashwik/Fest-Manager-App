package com.dota.arena2019.fragment;

import android.os.Bundle;
import android.provider.ContactsContract;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import com.dota.arena2019.R;
import com.dota.arena2019.adapter.CricketAdapter;
import com.dota.arena2019.adapter.MatchLiveAdapter1;
import com.dota.arena2019.adapter.MatchScheduleAdapter;
import com.dota.arena2019.adapter.ResultAdapter1;
import com.dota.arena2019.model.LiveCricket;
import com.dota.arena2019.model.LiveMatchType1;
import com.dota.arena2019.model.MatchDetails;
import com.dota.arena2019.model.ResultType1;
import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.database.ValueEventListener;

import java.util.ArrayList;

public class MatchesSectionFragment extends Fragment {
    private int section;
    private String eventId;
    private RecyclerView rootView;
    private TextView status;
    private RecyclerView.Adapter adapter;

    private ArrayList<String> type1,type2;
    private String cricket_id = "5c172ddcdeb95b571eaffdcf";
    public MatchesSectionFragment(){}

    public static MatchesSectionFragment newInstance(int sectionNumber, String eventId) {
        MatchesSectionFragment fragment = new MatchesSectionFragment();
        Bundle args = new Bundle();
        args.putInt("section", sectionNumber);
        args.putString("ID",eventId);
        fragment.setArguments(args);
        return fragment;
    }

    @Override
    public void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        section = this.getArguments().getInt("section",0);
        eventId = this.getArguments().getString("ID");
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_matches_result, container, false);
        rootView = view.findViewById(R.id.recycleView);
        status = view.findViewById(R.id.status);

        RecyclerView.LayoutManager mLayoutManager2 = new LinearLayoutManager(getContext());
        rootView.setLayoutManager(mLayoutManager2);

        switch (section){
            case 1:
                final ArrayList<ResultType1> list1 = new ArrayList<>();
                FirebaseDatabase.getInstance().getReference().child("Scores").child("Live Matches").child(eventId).addValueEventListener(new ValueEventListener() {
                    @Override
                    public void onDataChange(@NonNull DataSnapshot dataSnapshot) {
                        list1.clear();
                        if(dataSnapshot!=null){
                            for(DataSnapshot ds:dataSnapshot.getChildren())
                                list1.add(ds.getValue(ResultType1.class));

                        }
                        if(list1.size()==0) {
                            status.setText("Result not yet updated");
                            status.setVisibility(View.VISIBLE);
                        }
                        else {
                            status.setVisibility(View.GONE);
                            adapter = new ResultAdapter1(getActivity(),list1);
                            rootView.setAdapter(adapter);
                            adapter.notifyDataSetChanged();
                        }
                    }

                    @Override
                    public void onCancelled(@NonNull DatabaseError databaseError) {

                    }
                });
                break;
            case 2:
                if(eventId.equals(cricket_id)){
                    final ArrayList<LiveCricket> list2 = new ArrayList<>();
                    FirebaseDatabase.getInstance().getReference().child("Scores").child("Live Matches").child(eventId).addValueEventListener(new ValueEventListener() {
                        @Override
                        public void onDataChange(@NonNull DataSnapshot dataSnapshot) {
                            list2.clear();
                            if (dataSnapshot != null) {
                                for (DataSnapshot ds : dataSnapshot.getChildren())
                                    list2.add(ds.getValue(LiveCricket.class));
                            }
                            if (list2.size() == 0) {
                                status.setText("No matches are live currently");
                                status.setVisibility(View.VISIBLE);
                            } else {
                                status.setVisibility(View.GONE);
                                adapter = new CricketAdapter(getActivity(), list2);
                                rootView.setAdapter(adapter);
                                adapter.notifyDataSetChanged();
                            }
                        }

                        @Override
                        public void onCancelled(@NonNull DatabaseError databaseError) {

                        }
                    });
                }
                else {
                    final ArrayList<LiveMatchType1> list2 = new ArrayList<>();
                    FirebaseDatabase.getInstance().getReference().child("Scores").child("Live Matches").child(eventId).addValueEventListener(new ValueEventListener() {
                        @Override
                        public void onDataChange(@NonNull DataSnapshot dataSnapshot) {
                            list2.clear();
                            if (dataSnapshot != null) {
                                for (DataSnapshot ds : dataSnapshot.getChildren())
                                    list2.add(ds.getValue(LiveMatchType1.class));

                            }
                            if (list2.size() == 0) {
                                status.setText("No matches are live currently");
                                status.setVisibility(View.VISIBLE);
                            } else {
                                status.setVisibility(View.GONE);
                                adapter = new MatchLiveAdapter1(getActivity(), list2);
                                rootView.setAdapter(adapter);
                                adapter.notifyDataSetChanged();
                            }
                        }

                        @Override
                        public void onCancelled(@NonNull DatabaseError databaseError) {

                        }
                    });
                }
                break;
            case 3:
                final ArrayList<MatchDetails> list3 = new ArrayList<>();
                FirebaseDatabase.getInstance().getReference().child("Scores").child("Upcoming Matches").child(eventId).addValueEventListener(new ValueEventListener() {
                    @Override
                    public void onDataChange(@NonNull DataSnapshot dataSnapshot) {
                        list3.clear();
                        if(dataSnapshot!=null){
                            for(DataSnapshot ds:dataSnapshot.getChildren())
                                list3.add(ds.getValue(MatchDetails.class));

                        }
                        if(list3.size()==0) {
                            status.setText("No match is scheduled currently");
                            status.setVisibility(View.VISIBLE);
                        }
                        else {
                            status.setVisibility(View.GONE);
                            adapter = new MatchScheduleAdapter(getActivity(),list3);
                            rootView.setAdapter(adapter);
                            adapter.notifyDataSetChanged();
                        }
                    }

                    @Override
                    public void onCancelled(@NonNull DatabaseError databaseError) {

                    }
                });
                break;
        }
        return view;
    }
}