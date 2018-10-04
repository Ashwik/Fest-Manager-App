package com.android.dota.festmanager.activity;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.View;

import com.android.dota.festmanager.R;
import com.android.dota.festmanager.adapter.SettingsNotificationAdapter;

public class SettingsActivity extends AppCompatActivity {
    private RecyclerView recyclerView;
    private SettingsNotificationAdapter adapter;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_settings);

        String eventnames[] = {"Event 1","Event 2","General","pushNotifications"};
        String topics[]={"event1","event2","general","pushNotifications"};

        recyclerView = findViewById(R.id.notifMenu);
        adapter=new SettingsNotificationAdapter(eventnames,topics,SettingsActivity.this);
        RecyclerView.LayoutManager mLayoutManager = new LinearLayoutManager(getApplicationContext());
        recyclerView.setLayoutManager(mLayoutManager);
        recyclerView.setAdapter(adapter);
        adapter.notifyDataSetChanged();
    }
    public void toggle(View v){
        if(recyclerView.getVisibility()==View.GONE) recyclerView.setVisibility(View.VISIBLE);
        else recyclerView.setVisibility(View.GONE);
    }
}
