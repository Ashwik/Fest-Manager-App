package com.dota.pearl2019.fragment;

import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.support.design.widget.BottomNavigationView;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.MenuItem;
import android.view.View;
import android.view.ViewGroup;

import com.dota.pearl2019.R;

public class HomeFragment extends Fragment {

    private BottomNavigationView.OnNavigationItemSelectedListener mOnNavigationItemSelectedListener;
    private BottomNavigationView mBottomNavigationView;

    @Override
    public void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
    }

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, Bundle savedInstanceState) {
        return inflater.inflate(R.layout.fragment_home, container, false);
    }

    @Override
    public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);
        mBottomNavigationView = getView().findViewById(R.id.bottom_nav_view);


        mOnNavigationItemSelectedListener = new BottomNavigationView.OnNavigationItemSelectedListener() {
            @Override
            public boolean onNavigationItemSelected(@NonNull MenuItem item) {
                switch (item.getItemId()) {
                    case R.id.live:
                        getChildFragmentManager().beginTransaction()
                                .replace(R.id.bottom_nav_container, new LiveFragment())
                                .commit();
                        break;
                    case R.id.feed:
                        getChildFragmentManager().beginTransaction()
                                .replace(R.id.bottom_nav_container, new FeedFragment())
                                .commit();
                        break;
                    case R.id.events:
                        getChildFragmentManager().beginTransaction()
                                .replace(R.id.bottom_nav_container, new EventsFragment())
                                .commit();
                        break;
                    case R.id.contact:
                        getChildFragmentManager().beginTransaction()
                                .replace(R.id.bottom_nav_container, new ContactsFragment())
                                .commit();
                        break;

//                    case R.id.guide:
//                        getChildFragmentManager().beginTransaction()
//                                .replace(R.id.bottom_nav_container, new MapsFragment())
//                                .commit();
//                        break;
                    case R.id.more:
                        getChildFragmentManager().beginTransaction()
                                .replace(R.id.bottom_nav_container, new MoreFragment())
                                .commit();
                        break;

                }
                return true;
            }
        };
        mBottomNavigationView.setOnNavigationItemSelectedListener(mOnNavigationItemSelectedListener);
        if (savedInstanceState == null) {
            mBottomNavigationView.setSelectedItemId(R.id.feed);
        }
    }
}
