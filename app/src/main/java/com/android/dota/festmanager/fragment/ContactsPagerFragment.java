package com.android.dota.festmanager.fragment;

import android.content.res.Resources;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.android.dota.festmanager.R;
import com.android.dota.festmanager.model.Contact;
import com.android.dota.festmanager.adapter.ContactAdapter;

import java.util.ArrayList;


public class ContactsPagerFragment extends Fragment {
    public static final String CONTACTS_SWITCH = "ContactsSwitch";

    private ArrayList<Contact> data;
    RecyclerView mRecyclerView;
    ContactAdapter mContactAdapter;
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
        switch(switchContacts){
            case 0:
                names = res.getStringArray(R.array.organiser_names);
                designations = res.getStringArray(R.array.organisers_designations);
                numbers = res.getStringArray(R.array.organisers_phone_numbers);
                break;
            case 1:
                names = res.getStringArray(R.array.club_secretaries);
                designations = res.getStringArray(R.array.club_names);
                numbers = res.getStringArray(R.array.club_senate_phone_numbers);
                break;
        }



        return inflater.inflate(R.layout.fragment_contacts_pager, container, false);
    }

    @Override
    public void onViewCreated(View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);
        mRecyclerView = view.findViewById(R.id.club_senate_recycler);
        mContactAdapter = new ContactAdapter(getActivity());
        mRecyclerView.setAdapter(mContactAdapter);
        mRecyclerView.setLayoutManager(new LinearLayoutManager(getActivity()));
        data = new ArrayList<>();
        feedData();
        mContactAdapter.setArrayList(data);
    }

    public void feedData(){
        for(int i = 0; i < names.length ; i++){
            data.add(new Contact(names[i],designations[i],numbers[i]));
        }
    }
}
