package com.dota.festmanager.activity;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.Toolbar;

import com.dota.festmanager.R;
import com.dota.festmanager.fragment.EventsFragment;

public class EventsActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.app_bar_navigation);
        Toolbar toolbar = findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);
        getSupportActionBar().setDisplayHomeAsUpEnabled(true);
        getSupportActionBar().setHomeButtonEnabled(true);
        if(savedInstanceState==null){
            getSupportFragmentManager().beginTransaction().
                    replace(R.id.nav_fragment_container,new EventsFragment()).
                    commit();
        }
    }

    @Override
    public void onBackPressed() {
        super.onBackPressed();
    }

    @Override
    public boolean onSupportNavigateUp() {
        finish();
        return true;
    }
    public void setActionBarTitle(String Title){
        getSupportActionBar().setTitle(Title);
    }
}
