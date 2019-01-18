package com.dota.arena2019.fragment;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.support.v7.widget.Toolbar;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.dota.arena2019.R;
import com.dota.arena2019.adapter.MapAdapter;

public class MapsFragment extends Fragment {
    private RecyclerView place_recycler;

    public void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
    }

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, Bundle savedInstanceState) {
        return inflater.inflate(R.layout.fragment_maps, container, false);
    }

    public void onViewCreated(View view, @Nullable Bundle savedInstanceState) {

        Toolbar toolbar = getActivity().findViewById(R.id.toolbar);
//        toolbar.setTitle("Campus Map");


        place_recycler = getView().findViewById(R.id.place_recycler);

        place_recycler.setLayoutManager(new LinearLayoutManager(getActivity()));
        MapAdapter adapter = new MapAdapter(getActivity());
        place_recycler.setAdapter(adapter);
    }
}
