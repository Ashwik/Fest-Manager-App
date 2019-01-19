package com.dota.arena2019.fragment;

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
import android.widget.TextView;

import com.dota.arena2019.R;
import com.dota.arena2019.adapter.CreditsAdapter;
import com.dota.arena2019.model.DeveloperDetails;
import com.dota.arena2019.model.DeveloperLayoutDetails;

import java.util.ArrayList;

public class CreditsFragment extends Fragment {
    RecyclerView mRecyclerView;
    private CreditsAdapter mAdapter;
    private Context context;

    public void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        context = getContext();
    }

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, Bundle savedInstanceState) {
        return inflater.inflate(R.layout.fragment_credits, container, false);
    }

    @Override
    public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);
//        Toolbar toolbar = getActivity().findViewById(R.id.toolbar);
//        toolbar.setTitle("App Credits");
        mRecyclerView = getActivity().findViewById(R.id.credits_recycler);
        mRecyclerView.setLayoutManager(new LinearLayoutManager(context));

        mAdapter = new CreditsAdapter(context, getDevData());

        mRecyclerView.setAdapter(mAdapter);


    }

    private ArrayList<DeveloperLayoutDetails> getDevData() {
        ArrayList<DeveloperLayoutDetails> details = new ArrayList<>(3);
        details.add(new DeveloperLayoutDetails("Android Developers", getAndroidDevs()));
        details.add(new DeveloperLayoutDetails(null, getAndroidDevs2()));
        details.add(new DeveloperLayoutDetails("Backend Web-Developers", getWebDevs()));
//        details.add(new DeveloperLayoutDetails("Designers", getDesigners()));

        return details;
    }

    private ArrayList<DeveloperDetails> getAndroidDevs() {
        ArrayList<DeveloperDetails> details = new ArrayList<>();
        details.add(new DeveloperDetails("Ashwik Reddy", R.drawable.dev_ashwik, new String[]{"https://www.facebook.com/ashwik.aileni", "https://github.com/Ashwik", null, null}));
        details.add(new DeveloperDetails("Kartheek Akella", R.drawable.dev_kartheek, new String[]{"https://www.facebook.com/kartheek.asvs", "https://github.com/ASVS-Kartheek", null, null}));
        return details;
    }

    private ArrayList<DeveloperDetails> getAndroidDevs2() {
        ArrayList<DeveloperDetails> details = new ArrayList<>();
        details.add(new DeveloperDetails("Prateek Agarwal", R.drawable.dev_prateek, new String[]{"https://www.facebook.com/prateek.agarwal.94801", "https://github.com/prat-bphc52", null, null}));
        details.add(new DeveloperDetails("Ajith kanduri", R.drawable.dev_ajith, new String[]{"https://www.facebook.com/kanduri.ajith", "https://github.com/ajithkanduri", null, null}));
        return details;
    }

    private ArrayList<DeveloperDetails> getWebDevs() {
        ArrayList<DeveloperDetails> details = new ArrayList<>();
        details.add(new DeveloperDetails("Sohail Rajdev", R.drawable.dev_sohail, new String[]{"https://www.facebook.com/srajdev97", "https://github.com/sohailrajdev97", null, null}));
        details.add(new DeveloperDetails("Kailash Bhalaki", R.drawable.dev_kailash, new String[]{"https://www.facebook.com/Kailash.311.Bhalaki", "https://github.com/Kailash0311", null, null}));
        return details;
    }

    private ArrayList<DeveloperDetails> getDesigners() {
        ArrayList<DeveloperDetails> details = new ArrayList<>();

//        details.add(new DeveloperDetails("Maitreyee Talnikar", R.drawable.des_maitreyee,new String[]{"https://www.facebook.com/maitreyee.talnikar", null, null, "https://www.behance.net/maitreyeet0781"}));
        return details;
    }

}
