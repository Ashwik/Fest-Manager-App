package com.dota.festmanager.activity;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;

import com.dota.festmanager.R;
import com.dota.festmanager.fragment.SchedulePagerFragment;

public class ScheduleActivity extends AppCompatActivity {

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
        if (savedInstanceState == null) {
            getSupportFragmentManager().beginTransaction().
                    replace(R.id.nav_fragment_container, new SchedulePagerFragment()).
                    commit();
        }
        setActionBarTitle();

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

    public void setActionBarTitle() {
        Bundle bundle = getIntent().getExtras();
        int page = bundle.getInt("page", 0);
        switch (page) {
            case 0:
                day = "26";
                break;
            case 1:
                day = "27";
                break;
            case 2:
                day = "28";
                break;
        }
        getSupportActionBar().setTitle(day + " OCT 2018");
    }

}
