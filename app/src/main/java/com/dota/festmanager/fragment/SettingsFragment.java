package com.dota.festmanager.fragment;

import android.app.Fragment;
import android.content.Context;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.support.v7.widget.Toolbar;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import com.dota.festmanager.R;
import com.dota.festmanager.adapter.SettingsNotificationAdapter;

import static io.realm.internal.SyncObjectServerFacade.getApplicationContext;

public class SettingsFragment extends android.support.v4.app.Fragment {
    private RecyclerView recyclerView;
    private TextView tv;
    private SettingsNotificationAdapter adapter;

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
    }
        @Nullable
        @Override
        public View onCreateView (LayoutInflater inflater, @Nullable ViewGroup container, Bundle
        savedInstanceState){
            return inflater.inflate(R.layout.fragment_settings, container, false);
        }
        public void onViewCreated (View view, @Nullable Bundle savedInstanceState)
        {
            Toolbar toolbar = getActivity().findViewById(R.id.toolbar);
            toolbar.setTitle("Settings");

            String event_list[] = {"Event 1", "Event 2", "General", "pushNotifications"};
            String topics[] = {"event1", "event2", "general", "pushNotifications"};

            recyclerView=getView().findViewById(R.id.notifMenu);
            tv=getView().findViewById(R.id.showNotifMenu);

            recyclerView.setLayoutManager(new LinearLayoutManager(getActivity()));

            adapter = new SettingsNotificationAdapter(event_list,topics,getActivity());
            recyclerView.setAdapter(adapter);
            adapter.notifyDataSetChanged();
            toggle(view);
        }
        public void toggle (View view){
            if (recyclerView.getVisibility() == View.GONE) recyclerView.setVisibility(View.VISIBLE);
            else recyclerView.setVisibility(View.GONE);
        }
    }

