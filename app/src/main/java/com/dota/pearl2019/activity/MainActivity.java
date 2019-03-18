package com.dota.pearl2019.activity;

import android.app.NotificationChannel;
import android.app.NotificationManager;
import android.content.Context;
import android.content.Intent;
import android.content.SharedPreferences;
import android.media.AudioAttributes;
import android.media.RingtoneManager;
import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.design.widget.NavigationView;
import android.support.v4.app.Fragment;
import android.support.v4.widget.DrawerLayout;
import android.support.v7.app.ActionBarDrawerToggle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.util.Log;
import android.view.Menu;
import android.view.MenuItem;

import com.dota.pearl2019.R;
import com.dota.pearl2019.fragment.FeedFragment;
import com.dota.pearl2019.fragment.HomeFragment;
import com.dota.pearl2019.fragment.LandingFragment;
import com.google.android.gms.tasks.OnSuccessListener;
import com.google.firebase.iid.FirebaseInstanceId;
import com.google.firebase.messaging.FirebaseMessaging;

public class MainActivity extends AppCompatActivity implements NavigationView.OnNavigationItemSelectedListener {


    private DrawerLayout mDrawerLayout;
    private ActionBarDrawerToggle mToggle;
    private NavigationView mNavigationView;
    private Fragment fragment;
    public Toolbar toolbar;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.app_bar_navigation);
        toolbar = findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);
        if (savedInstanceState == null) {
            getSupportFragmentManager().beginTransaction().
                    replace(R.id.nav_fragment_container, new LandingFragment()).
                    commit();
        }

        //Guide Recycler

        Log.v("Firebase", "token " + FirebaseInstanceId.getInstance().getToken());

        Intent sourceIntent = getIntent();
        if (sourceIntent != null) {

        }


//        mDrawerLayout = findViewById(R.id.drawer_layout);
//        mNavigationView = findViewById(R.id.nav_view);
//        mToggle = new ActionBarDrawerToggle(
//                this, mDrawerLayout, toolbar, R.string.navigation_drawer_open, R.string.navigation_drawer_close);
//        mDrawerLayout.addDrawerListener(mToggle);
//        mNavigationView.setNavigationItemSelectedListener(this);
//        mDrawerLayout.setScrimColor(getResources().getColor(android.R.color.transparent));
//
//
//        if(savedInstanceState==null){
//            mNavigationView.getMenu().performIdentifierAction(R.id.schedule,0);
//        }
//        mNavigationView.setCheckedItem(R.id.schedule);
//        try {
//            getSupportActionBar().setTitle("Schedule");
//        } catch (Exception e) {
//            e.printStackTrace();
//        }

        String type = getIntent().getStringExtra("Destination");
        if (type != null) {
            switch (type) {
                case "FeedFragment":
                    fragment = new FeedFragment();
                    getSupportFragmentManager().beginTransaction()
                            .replace(R.id.nav_fragment_container, fragment)
                            .commit();
                    break;
            }
        }

        final SharedPreferences preferences = getSharedPreferences("Notifications", MODE_PRIVATE);

        if (android.os.Build.VERSION.SDK_INT >= android.os.Build.VERSION_CODES.O) {
            boolean flag = getSharedPreferences("Notifications", MODE_PRIVATE).getBoolean("ChannelCreated", false);
            if (!flag) {
                NotificationManager manager = (NotificationManager) getSystemService(Context.NOTIFICATION_SERVICE);
                NotificationChannel notificationChannel = new NotificationChannel("EVENT_UPDATES",
                        "ATMOS Updates", NotificationManager.IMPORTANCE_HIGH);
                AudioAttributes audioAttributes = new AudioAttributes.Builder()
                        .setContentType(AudioAttributes.CONTENT_TYPE_SONIFICATION)
                        .setUsage(AudioAttributes.USAGE_NOTIFICATION_RINGTONE)
                        .build();
                notificationChannel.setSound(RingtoneManager.getDefaultUri(RingtoneManager.TYPE_NOTIFICATION), audioAttributes);
                notificationChannel.setLockscreenVisibility(android.app.Notification.VISIBILITY_PUBLIC);

                assert manager != null;
                manager.createNotificationChannel(notificationChannel);

                preferences.edit().putBoolean("ChannelCreated", true).apply();
            }
        }


        //todo: change it to actual event names
        String events[] = {"event1", "event2", "general", "pushNotifications"};
        for (final String s : events) {
            if (!preferences.contains(s)) {
                FirebaseMessaging.getInstance().subscribeToTopic(s).addOnSuccessListener(new OnSuccessListener<Void>() {
                    @Override
                    public void onSuccess(Void aVoid) {
                        preferences.edit().putBoolean(s, true).apply();
                    }
                });
            }
        }
    }

//    @Override
//    protected void onPostCreate(@Nullable Bundle savedInstanceState) {
//        super.onPostCreate(savedInstanceState);
//        mToggle.syncState();
//    }
//
//    @Override
//    public void onConfigurationChanged(Configuration newConfig) {
//        super.onConfigurationChanged(newConfig);
//        mToggle.onConfigurationChanged(newConfig);
//    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        return false;
    }


    @Override
    public boolean onNavigationItemSelected(@NonNull MenuItem item) {
//        switch (item.getItemId()){
//            case R.id.feed:
//                fragment = new FeedFragment();
//                break;
//            case R.id.events:
//                fragment = new EventCardsFragment();
//                break;
//            case R.id.schedule:
//                fragment = new ScheduleCardsFragment();
//                break;
//            case R.id.about:
//                fragment = new AboutFragment();
//                break;
//            case R.id.contact:
//                fragment = new ContactsFragment();
//                break;
//            case R.id.guide:
//                fragment = new MapsFragment();
//                break;
//            case R.id.credits:
//                fragment = new CreditsFragment();
//                break;
//            case R.id.reach:
//                fragment = new ReachUsFragment();
//                break;
//            case R.id.settings:
//                  fragment = new SettingsFragment();
//                  break;
//        }
//        getSupportFragmentManager().beginTransaction()
//                .replace(R.id.nav_fragment_container, fragment)
//                .commit();
//        mDrawerLayout.closeDrawer(GravityCompat.START);
        return true;
    }

    @Override
    public void onBackPressed() {
        super.onBackPressed();

//        if (mDrawerLayout.isDrawerOpen(GravityCompat.START)) {
//            mDrawerLayout.closeDrawer(GravityCompat.START);
//        } else if (!(fragment instanceof ScheduleCardsFragment)){
//            fragment = new ScheduleCardsFragment();
//            getSupportFragmentManager().beginTransaction()
//                    .replace(R.id.nav_fragment_container, fragment)
//                    .commit();
//        } else {
//            super.onBackPressed();
//        }
    }
}
