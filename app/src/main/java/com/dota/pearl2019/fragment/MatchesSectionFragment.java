package com.dota.pearl2019.fragment;

import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import com.dota.pearl2019.R;
import com.dota.pearl2019.adapter.CricketAdapter;
import com.dota.pearl2019.adapter.CricketResultAdapter;
import com.dota.pearl2019.adapter.IndividualEventAdapter;
import com.dota.pearl2019.adapter.MatchLiveAdapter1;
import com.dota.pearl2019.adapter.MatchLiveAdapter2;
import com.dota.pearl2019.adapter.MatchScheduleAdapter;
import com.dota.pearl2019.adapter.ResultAdapter1;
import com.dota.pearl2019.model.CricketResult;
import com.dota.pearl2019.model.IndividualEvent;
import com.dota.pearl2019.model.LiveCricket;
import com.dota.pearl2019.model.LiveMatchType1;
import com.dota.pearl2019.model.LiveMatchType2;
import com.dota.pearl2019.model.MatchDetails;
import com.dota.pearl2019.model.ResultType1;
import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.database.ValueEventListener;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;

public class MatchesSectionFragment extends Fragment {
    private int section;
    private String eventId;
    private RecyclerView rootView;
    private TextView status;
    private RecyclerView.Adapter adapter;

    private List<String> type1, type2, type3;
    private String cricket_id = "5c172ddcdeb95b571eaffdcf";

    public MatchesSectionFragment() {
    }

    public static MatchesSectionFragment newInstance(int sectionNumber, String eventId) {
        MatchesSectionFragment fragment = new MatchesSectionFragment();
        Bundle args = new Bundle();
        args.putInt("section", sectionNumber);
        args.putString("ID", eventId);
        fragment.setArguments(args);
        return fragment;
    }

    @Override
    public void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        section = this.getArguments().getInt("section", 0);
        eventId = this.getArguments().getString("ID");
        type1 = Arrays.asList(getResources().getStringArray(R.array.type1));
        type2 = Arrays.asList(getResources().getStringArray(R.array.type2));
        type3 = Arrays.asList(getResources().getStringArray(R.array.type3));
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_matches_result, container, false);
        rootView = view.findViewById(R.id.recycleView);
        status = view.findViewById(R.id.status);

        RecyclerView.LayoutManager mLayoutManager2 = new LinearLayoutManager(getContext());
        rootView.setLayoutManager(mLayoutManager2);

        switch (section) {
            case 3:
                status.setText("Result not yet updated");
                status.setVisibility(View.VISIBLE);
                if (eventId.equals(cricket_id)) {
                    final ArrayList<CricketResult> list1 = new ArrayList<>();
                    adapter = new CricketResultAdapter(getActivity(), list1);
                    rootView.setAdapter(adapter);
                    FirebaseDatabase.getInstance().getReference().child("Scores").child("Results").child(eventId).orderByKey().addValueEventListener(new ValueEventListener() {
                        @Override
                        public void onDataChange(@NonNull DataSnapshot dataSnapshot) {
                            list1.clear();
                            for (DataSnapshot ds : dataSnapshot.getChildren())
                                list1.add(ds.getValue(CricketResult.class));
                            Collections.reverse(list1);

                            if (list1.size() == 0) {
                                status.setText("Result not yet updated");
                                status.setVisibility(View.VISIBLE);
                            } else status.setVisibility(View.GONE);

                            adapter.notifyDataSetChanged();
                        }

                        @Override
                        public void onCancelled(@NonNull DatabaseError databaseError) {

                        }
                    });
                } else if (type1.contains(eventId)) {
                    final ArrayList<ResultType1> list1 = new ArrayList<>();
                    adapter = new ResultAdapter1(getActivity(), list1);
                    rootView.setAdapter(adapter);
                    FirebaseDatabase.getInstance().getReference().child("Scores").child("Results").child(eventId).orderByKey().addValueEventListener(new ValueEventListener() {
                        @Override
                        public void onDataChange(@NonNull DataSnapshot dataSnapshot) {
                            list1.clear();
                            for (DataSnapshot ds : dataSnapshot.getChildren())
                                list1.add(ds.getValue(ResultType1.class));
                            Collections.reverse(list1);

                            if (list1.size() == 0) {
                                status.setText("Result not yet updated");
                                status.setVisibility(View.VISIBLE);
                            } else status.setVisibility(View.GONE);

                            adapter.notifyDataSetChanged();
                        }

                        @Override
                        public void onCancelled(@NonNull DatabaseError databaseError) {

                        }
                    });
                } else if (type2.contains(eventId)) {
                    final ArrayList<LiveMatchType2> list2 = new ArrayList<>();
                    adapter = new MatchLiveAdapter2(getActivity(), list2, false);
                    rootView.setAdapter(adapter);
                    FirebaseDatabase.getInstance().getReference().child("Scores").child("Results").child(eventId).orderByKey().addValueEventListener(new ValueEventListener() {
                        @Override
                        public void onDataChange(@NonNull DataSnapshot dataSnapshot) {
                            list2.clear();
                            for (DataSnapshot ds : dataSnapshot.getChildren())
                                list2.add(ds.getValue(LiveMatchType2.class));
                            Collections.reverse(list2);

                            if (list2.size() == 0) {
                                status.setText("Result not yet updated");
                                status.setVisibility(View.VISIBLE);
                            } else status.setVisibility(View.GONE);

                            adapter.notifyDataSetChanged();
                        }

                        @Override
                        public void onCancelled(@NonNull DatabaseError databaseError) {

                        }
                    });
                } else if (type3.contains(eventId)) {
                    final ArrayList<IndividualEvent> list2 = new ArrayList<>();
                    adapter = new IndividualEventAdapter(getActivity(), list2);
                    rootView.setAdapter(adapter);
                    FirebaseDatabase.getInstance().getReference().child("Scores").child("Results").child(eventId).orderByKey().addValueEventListener(new ValueEventListener() {
                        @Override
                        public void onDataChange(@NonNull DataSnapshot dataSnapshot) {
                            list2.clear();
                            for (DataSnapshot ds : dataSnapshot.getChildren())
                                list2.add(ds.getValue(IndividualEvent.class));
                            Collections.reverse(list2);

                            if (list2.size() == 0) {
                                status.setText("Result not yet updated");
                                status.setVisibility(View.VISIBLE);
                            } else status.setVisibility(View.GONE);

                            adapter.notifyDataSetChanged();
                        }

                        @Override
                        public void onCancelled(@NonNull DatabaseError databaseError) {

                        }
                    });
                } else {
                    status.setText("Result not yet updated");
                    status.setVisibility(View.VISIBLE);
                }
                break;


            case 2:
                status.setText("No matches are live currently");
                status.setVisibility(View.VISIBLE);
                if (eventId.equals(cricket_id)) {
                    final ArrayList<LiveCricket> list2 = new ArrayList<>();
                    adapter = new CricketAdapter(getActivity(), list2);
                    rootView.setAdapter(adapter);
                    FirebaseDatabase.getInstance().getReference().child("Scores").child("Live Matches").child(eventId).orderByKey().addValueEventListener(new ValueEventListener() {
                        @Override
                        public void onDataChange(@NonNull DataSnapshot dataSnapshot) {
                            list2.clear();
                            for (DataSnapshot ds : dataSnapshot.getChildren())
                                list2.add(ds.getValue(LiveCricket.class));
                            Collections.reverse(list2);

                            if (list2.size() == 0) {
                                status.setText("No matches are live currently");
                                status.setVisibility(View.VISIBLE);
                            } else status.setVisibility(View.GONE);

                            adapter.notifyDataSetChanged();
                        }

                        @Override
                        public void onCancelled(@NonNull DatabaseError databaseError) {

                        }
                    });
                } else if (type1.contains(eventId)) {
                    final ArrayList<LiveMatchType1> list2 = new ArrayList<>();
                    adapter = new MatchLiveAdapter1(getActivity(), list2);
                    rootView.setAdapter(adapter);
                    FirebaseDatabase.getInstance().getReference().child("Scores").child("Live Matches").child(eventId).orderByKey().addValueEventListener(new ValueEventListener() {
                        @Override
                        public void onDataChange(@NonNull DataSnapshot dataSnapshot) {
                            list2.clear();
                            for (DataSnapshot ds : dataSnapshot.getChildren())
                                list2.add(ds.getValue(LiveMatchType1.class));
                            Collections.reverse(list2);

                            if (list2.size() == 0) {
                                status.setText("No matches are live currently");
                                status.setVisibility(View.VISIBLE);
                            } else status.setVisibility(View.GONE);

                            adapter.notifyDataSetChanged();
                        }

                        @Override
                        public void onCancelled(@NonNull DatabaseError databaseError) {

                        }
                    });
                } else if (type2.contains(eventId)) {
                    final ArrayList<LiveMatchType2> list2 = new ArrayList<>();
                    adapter = new MatchLiveAdapter2(getActivity(), list2, true);
                    rootView.setAdapter(adapter);
                    FirebaseDatabase.getInstance().getReference().child("Scores").child("Live Matches").child(eventId).orderByKey().addValueEventListener(new ValueEventListener() {
                        @Override
                        public void onDataChange(@NonNull DataSnapshot dataSnapshot) {
                            list2.clear();
                            for (DataSnapshot ds : dataSnapshot.getChildren())
                                list2.add(ds.getValue(LiveMatchType2.class));
                            Collections.reverse(list2);

                            if (list2.size() == 0) {
                                status.setText("No matches are live currently");
                                status.setVisibility(View.VISIBLE);
                            } else status.setVisibility(View.GONE);

                            adapter.notifyDataSetChanged();
                        }

                        @Override
                        public void onCancelled(@NonNull DatabaseError databaseError) {

                        }
                    });
                } else if (type3.contains(eventId)) {
                    status.setText("Results will be displayed directly");
                    status.setVisibility(View.VISIBLE);
                } else {
                    status.setText("No matches are live currently");
                    status.setVisibility(View.VISIBLE);
                }
                break;


            case 1:

                if (type3.contains(eventId)) {
                    status.setText("Results will be displayed directly");
                    status.setVisibility(View.VISIBLE);
                } else {
                    final ArrayList<MatchDetails> list3 = new ArrayList<>();
                    adapter = new MatchScheduleAdapter(getActivity(), list3);
                    rootView.setAdapter(adapter);
                    status.setText("No match is scheduled currently");
                    status.setVisibility(View.VISIBLE);
                    FirebaseDatabase.getInstance().getReference().child("Scores").child("Upcoming Matches").child(eventId).orderByChild("date").addValueEventListener(new ValueEventListener() {
                        @Override
                        public void onDataChange(@NonNull DataSnapshot dataSnapshot) {
                            list3.clear();
                            for (DataSnapshot ds : dataSnapshot.getChildren())
                                list3.add(ds.getValue(MatchDetails.class));

                            if (list3.size() == 0) {
                                status.setText("No match is scheduled currently");
                                status.setVisibility(View.VISIBLE);
                            } else status.setVisibility(View.GONE);

                            adapter.notifyDataSetChanged();
                        }

                        @Override
                        public void onCancelled(@NonNull DatabaseError databaseError) {

                        }
                    });
                }
                break;
        }
        return view;
    }
}