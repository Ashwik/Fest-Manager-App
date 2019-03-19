package com.dota.pearl2019.activity;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.util.Log;

import com.dota.pearl2019.R;
import com.dota.pearl2019.fragment.ContactsFragment;
import com.dota.pearl2019.fragment.CreditsFragment;
import com.dota.pearl2019.fragment.EventsFragment;
import com.dota.pearl2019.fragment.FeedFragment;
import com.dota.pearl2019.fragment.HomeFragment;
import com.dota.pearl2019.fragment.LiveFragment;
import com.dota.pearl2019.fragment.MoreFragment;
import com.dota.pearl2019.fragment.ScheduleCardsFragment;
import com.dota.pearl2019.fragment.SchedulePagerFragment;

public class HomeActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {

        super.onCreate(savedInstanceState);
        setContentView(R.layout.app_bar_navigation);
        Toolbar toolbar = findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);
        getSupportActionBar().setDisplayHomeAsUpEnabled(true);
        getSupportActionBar().setHomeButtonEnabled(true);

        Bundle bundle = getIntent().getExtras();
        String card_category_id  = bundle.getString(String.valueOf(R.string.home_type_id));
        Log.e("card",String.valueOf(card_category_id));
        switch(card_category_id){
            case "FEED": getSupportFragmentManager().beginTransaction()
                    .replace(R.id.nav_fragment_container, new FeedFragment())
                    .commit();
                    break;
            case "EVENTS": getSupportFragmentManager().beginTransaction()
                    .replace(R.id.nav_fragment_container, new EventsFragment())
                    .commit();
                break;
            case "SCHEDULE": getSupportFragmentManager().beginTransaction()
                    .replace(R.id.nav_fragment_container, new ScheduleCardsFragment())
                    .commit();
                break;
            case "CONTACT": getSupportFragmentManager().beginTransaction()
                    .replace(R.id.nav_fragment_container, new ContactsFragment())
                    .commit();
                break;
            case "GUIDE": getSupportFragmentManager().beginTransaction()
                    .replace(R.id.nav_fragment_container, new MoreFragment())
                    .commit();
                break;
            case "APP CREDITS": getSupportFragmentManager().beginTransaction()
                    .replace(R.id.nav_fragment_container, new CreditsFragment())
                    .commit();
                break;

            default: getSupportFragmentManager().beginTransaction()
                    .replace(R.id.nav_fragment_container, new EventsFragment())
                    .commit();
                    break;

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
}
