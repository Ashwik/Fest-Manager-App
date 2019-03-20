package com.dota.pearl2019.fragment;

import android.content.res.Resources;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.dota.pearl2019.R;
import com.dota.pearl2019.adapter.CreditsAdapternew;
import com.dota.pearl2019.model.DeveloperDetails;

import java.util.ArrayList;


public class CreditsPagerFragment extends Fragment {
    public static final String CONTACTS_SWITCH = "ContactsSwitch";

    private ArrayList<DeveloperDetails> details;
    RecyclerView mRecyclerView;
    CreditsAdapternew mContactAdapter;
    int switchContacts;

    private String[] names, designations, numbers;


    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        switchContacts = getArguments().getInt(CONTACTS_SWITCH);
        Resources res = container.getResources();
        switch (switchContacts) {
            case 0:
                names = res.getStringArray(R.array.organiser_names);
                designations = res.getStringArray(R.array.organisers_designations);
                numbers = res.getStringArray(R.array.organisers_phone_numbers);
                break;
            case 1:
                names = res.getStringArray(R.array.club_secretaries);
                designations = res.getStringArray(R.array.club_names);
                break;
        }


        return inflater.inflate(R.layout.fragment_credits_pager, container, false);
    }

    @Override
    public void onViewCreated(View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);
        mRecyclerView = view.findViewById(R.id.club_senate_recycler);
        mContactAdapter = new CreditsAdapternew(getActivity());
        mRecyclerView.setAdapter(mContactAdapter);
        mRecyclerView.setLayoutManager(new LinearLayoutManager(getActivity()));
        details = new ArrayList<>();
        feedData();
        mContactAdapter.setArrayList(details);
    }

    public void feedData() {
        if(switchContacts==0){
            details.add(new DeveloperDetails("Ashwik Reddy", R.drawable.dev_ashwik, new String[]{"https://www.facebook.com/ashwik.aileni", "https://github.com/Ashwik", null, null}));
            details.add(new DeveloperDetails("Kartheek Akella", R.drawable.dev_kartheek, new String[]{"https://www.facebook.com/asvs.kartheek", "https://github.com/ASVS-Kartheek", null, null}));
            details.add(new DeveloperDetails("Prateek Agarwal", R.drawable.dev_prateek, new String[]{"https://www.facebook.com/prateek.agarwal.94801", "https://github.com/prat-bphc52", null, null}));
            details.add(new DeveloperDetails("Ajith kanduri", R.drawable.dev_ajith, new String[]{"https://www.facebook.com/kanduri.ajith", "https://github.com/ajithkanduri", null, null}));
            details.add(new DeveloperDetails("Vineeth Kumar", R.drawable.vineeth, new String[]{"https://www.facebook.com/vineethkumarVK11", null, null, null}));
            details.add(new DeveloperDetails("Kailash Bhalaki", R.drawable.dev_kailash, new String[]{"https://www.facebook.com/Kailash.311.Bhalaki", "https://github.com/Kailash0311", null, null}));

        }else{
            details.add(new DeveloperDetails("Nikita Gohel", R.drawable.nikitha, new String[]{"https://www.facebook.com/nikita.gohel.73",null, null, null}));
            details.add(new DeveloperDetails("Maitreyee Talnikar", R.drawable.maitrayee, new String[]{"https://www.facebook.com/maitreyee.talnikar",null, null, null}));
            details.add(new DeveloperDetails("Vikranth Sagar", R.drawable.profile_icon, new String[]{"https://www.facebook.com/VikranthSagar",null, null, null}));

        }

    }
}
