package com.android.dota.festmanager.fragment;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.android.dota.festmanager.R;
import com.android.dota.festmanager.activity.MapAdapter;

public class GuideFragment extends Fragment {
    private RecyclerView place_recycler;
    String[] placeName;
    public void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);


    }

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, Bundle savedInstanceState) {
        return inflater.inflate(R.layout.fragment_guide,container,false);
    }
    public void onViewCreated(View view,@Nullable Bundle savedInstanceState)
    {
        placeName=getResources().getStringArray(R.array.placeName);
        place_recycler=getView().findViewById(R.id.place_recycler);

        place_recycler.setLayoutManager(new LinearLayoutManager(getActivity()));
        MapAdapter adapter=new MapAdapter(getActivity(),placeName);
        place_recycler.setAdapter(adapter);
    }
}
