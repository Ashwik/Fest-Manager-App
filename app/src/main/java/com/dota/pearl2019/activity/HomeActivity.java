package com.dota.pearl2019.activity;

import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.util.Log;

import com.dota.pearl2019.R;
import com.dota.pearl2019.fragment.ContactsFragment;
import com.dota.pearl2019.fragment.CreditsFragmentnew;
import com.dota.pearl2019.fragment.EventsFragment;
import com.dota.pearl2019.fragment.FeedFragment;
import com.dota.pearl2019.fragment.MoreFragment;
import com.dota.pearl2019.fragment.ScheduleCardsFragment;
import com.dota.pearl2019.fragment.TalksFragment;

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
        String card_category_id = bundle.getString(String.valueOf(R.string.home_type_id));
        Log.e("card", String.valueOf(card_category_id));
        switch (card_category_id) {
            case "FEED":
                getSupportFragmentManager().beginTransaction()
                        .replace(R.id.nav_fragment_container, new FeedFragment())
                        .commit();
                break;
            case "EVENTS":
                getSupportFragmentManager().beginTransaction()
                        .replace(R.id.nav_fragment_container, new EventsFragment())
                        .commit();
                break;
            case "SCHEDULE":
                getSupportFragmentManager().beginTransaction()
                        .replace(R.id.nav_fragment_container, new ScheduleCardsFragment())
                        .commit();
                break;
            case "CONTACTS":
                getSupportFragmentManager().beginTransaction()
                        .replace(R.id.nav_fragment_container, new ContactsFragment())
                        .commit();
                break;
            case "TALKS":
                Fragment fragment = new TalksFragment();
                Bundle bundle1 = new Bundle();
                bundle1.putInt("from", 0);
                fragment.setArguments(bundle1);
                getSupportFragmentManager().beginTransaction()
                        .replace(R.id.nav_fragment_container, fragment)
                        .commit();
                break;
            case "PROSHOWS":
                Fragment fragment1 = new TalksFragment();
                Bundle bundle2 = new Bundle();
                bundle2.putInt("from", 1);
                fragment1.setArguments(bundle2);
                getSupportFragmentManager().beginTransaction()
                        .replace(R.id.nav_fragment_container, fragment1)
                        .commit();
                break;
            case "GUIDE":
                getSupportFragmentManager().beginTransaction()
                        .replace(R.id.nav_fragment_container, new MoreFragment())
                        .commit();
                break;
            case "CREDITS":
                getSupportFragmentManager().beginTransaction()
                        .replace(R.id.nav_fragment_container, new CreditsFragmentnew())
                        .commit();
                break;

            default:
                getSupportFragmentManager().beginTransaction()
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
