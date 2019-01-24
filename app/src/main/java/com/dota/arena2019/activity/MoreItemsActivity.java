package com.dota.arena2019.activity;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;

import com.dota.arena2019.R;
import com.dota.arena2019.fragment.AboutFragment;
import com.dota.arena2019.fragment.ArticlesFragment;
import com.dota.arena2019.fragment.CreditsFragment;
import com.dota.arena2019.fragment.MapsFragment;
import com.dota.arena2019.fragment.ReachUsFragment;
import com.dota.arena2019.fragment.SettingsFragment;

public class MoreItemsActivity extends AppCompatActivity {

    private Toolbar toolbar;
    private String day;
    private int page;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.app_bar_navigation);
        toolbar = findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);
        getSupportActionBar().setDisplayHomeAsUpEnabled(true);
        getSupportActionBar().setHomeButtonEnabled(true);

        Bundle bundle = getIntent().getExtras();
        int position = bundle.getInt("position", 0);
        switch (position) {
            case 0:
                getSupportFragmentManager().beginTransaction()
                        .replace(R.id.nav_fragment_container,new ArticlesFragment())
                        .commit();
                getSupportActionBar().setTitle("Articles");
                break;
            case 1:
                getSupportFragmentManager().beginTransaction()
                        .replace(R.id.nav_fragment_container, new AboutFragment())
                        .commit();
                getSupportActionBar().setTitle("About Arena");
                break;
            case 2:
                getSupportFragmentManager().beginTransaction()
                        .replace(R.id.nav_fragment_container, new ReachUsFragment())
                        .commit();
                getSupportActionBar().setTitle("Reach Us");
                break;
            case 3:
                getSupportFragmentManager().beginTransaction()
                        .replace(R.id.nav_fragment_container, new MapsFragment())
                        .commit();
                getSupportActionBar().setTitle("Directions");
                break;
            case 4:
                getSupportFragmentManager().beginTransaction()
                        .replace(R.id.nav_fragment_container, new CreditsFragment())
                        .commit();
                getSupportActionBar().setTitle("App Credits");
                break;
            case 5:
                getSupportFragmentManager().beginTransaction()
                        .replace(R.id.nav_fragment_container, new SettingsFragment())
                        .commit();
                getSupportActionBar().setTitle("Settings");
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
