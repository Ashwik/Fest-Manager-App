package com.android.dota.festmanager.activity;

import android.app.NotificationChannel;
import android.app.NotificationManager;
import android.content.Context;
import android.content.res.Configuration;
import android.media.AudioAttributes;
import android.media.RingtoneManager;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.support.design.widget.NavigationView;
import android.support.v4.view.GravityCompat;
import android.support.v4.widget.DrawerLayout;
import android.support.v7.app.ActionBarDrawerToggle;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.DefaultItemAnimator;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.support.v7.widget.Toolbar;
import android.view.Menu;
import android.view.MenuItem;

import com.android.dota.festmanager.R;
import com.android.dota.festmanager.fragment.AboutFragment;
import com.android.dota.festmanager.fragment.ContactsFragment;
import com.android.dota.festmanager.fragment.CreditsFragment;
import com.android.dota.festmanager.fragment.GuideFragment;
import com.android.dota.festmanager.fragment.HomeFragment;
import com.android.dota.festmanager.fragment.ReachUs;

public class MainActivity extends AppCompatActivity implements NavigationView.OnNavigationItemSelectedListener{



    private DrawerLayout mDrawerLayout;
    private ActionBarDrawerToggle mToggle;
    private NavigationView mNavigationView;
    public Toolbar toolbar;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        toolbar = findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);

        //Guide Recycler

        mDrawerLayout = findViewById(R.id.drawer_layout);
        mNavigationView = findViewById(R.id.nav_view);
        mToggle = new ActionBarDrawerToggle(
                this, mDrawerLayout, toolbar, R.string.navigation_drawer_open, R.string.navigation_drawer_close);
        mDrawerLayout.addDrawerListener(mToggle);
        mNavigationView.setNavigationItemSelectedListener(this);


        if(savedInstanceState==null){
            mNavigationView.getMenu().performIdentifierAction(R.id.home,0);
        }
        mNavigationView.setCheckedItem(R.id.home);

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
                manager.createNotificationChannel(notificationChannel);
                getSharedPreferences("Notifications", MODE_PRIVATE).edit().putBoolean("ChannelCreated",true).apply();
            }
        }
    }

    @Override
    protected void onPostCreate(@Nullable Bundle savedInstanceState) {
        super.onPostCreate(savedInstanceState);
        mToggle.syncState();
    }

    @Override
    public void onConfigurationChanged(Configuration newConfig) {
        super.onConfigurationChanged(newConfig);
        mToggle.onConfigurationChanged(newConfig);
    }

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
        switch (item.getItemId()){
            case R.id.home :
              getSupportFragmentManager().beginTransaction()
                        .replace(R.id.nav_fragment_container,new HomeFragment())
                        .commit();
              break;
            case R.id.about:
              getSupportFragmentManager().beginTransaction()
                      .replace(R.id.nav_fragment_container,new AboutFragment())
                      .commit();
              break;
            case R.id.contact:
                getSupportFragmentManager().beginTransaction()
                        .replace(R.id.nav_fragment_container,new ContactsFragment())
                        .commit();
                break;
            case R.id.guide:
                getSupportFragmentManager().beginTransaction()
                        .replace(R.id.nav_fragment_container,new GuideFragment())
                        .commit();
                break;
            case R.id.credits:
                getSupportFragmentManager().beginTransaction()
                        .replace(R.id.nav_fragment_container,new CreditsFragment())
                        .commit();
                break;
            case R.id.reach:
                getSupportFragmentManager().beginTransaction()
                        .replace(R.id.nav_fragment_container,new ReachUs())
                        .commit();
                break;
        }
        mDrawerLayout.closeDrawer(GravityCompat.START);
        return true;
    }

    @Override
    public void onBackPressed() {
        if (mDrawerLayout.isDrawerOpen(GravityCompat.START)) {
            mDrawerLayout.closeDrawer(GravityCompat.START);
        } else {
            super.onBackPressed();
        }
    }
}
