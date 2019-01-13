package com.dota.festmanager.fragment;

import android.content.Context;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.dota.festmanager.R;
import com.dota.festmanager.adapter.MoreAdapter;

import java.util.ArrayList;

public class MoreFragment extends Fragment {
    private RecyclerView more_recycler;
    public ArrayList<String> moreitemsList = new ArrayList<>();
    private Context context;
    private String TAG = "MoreFragment";

    public void onCreate(@Nullable Bundle savedInstanceState) {
        context = getContext();
        super.onCreate(savedInstanceState);
    }

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, Bundle savedInstanceState) {
        return inflater.inflate(R.layout.fragment_more, container, false);
    }

    public void onViewCreated(View view, @Nullable Bundle savedInstanceState) {

//        Toolbar toolbar = getActivity().findViewById(R.id.toolbar);
//        toolbar.setTitle("Campus Map");

        moreitemsList.add("About");
        moreitemsList.add("Reach Us");
        moreitemsList.add("App Credits");
        moreitemsList.add("Settings");

        more_recycler = getActivity().findViewById(R.id.more_recycler_view);

        more_recycler.setLayoutManager(new LinearLayoutManager(getActivity()));
        MoreAdapter adapter = new MoreAdapter(context, moreitemsList);
        more_recycler.setAdapter(adapter);
    }
}
