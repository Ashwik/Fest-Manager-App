package com.dota.pearl2019.fragment;

import android.app.Activity;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.design.widget.TabLayout;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentActivity;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentPagerAdapter;
import android.support.v4.view.PagerAdapter;
import android.support.v4.view.ViewPager;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.dota.pearl2019.R;

public class CreditsFragmentnew extends Fragment {
    private ViewPager mPager;
    private PagerAdapter mPagerAdapter;
    private FragmentActivity mycontext;

    public void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
    }

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, Bundle savedInstanceState) {
        return inflater.inflate(R.layout.fragment_credits_new, container, false);
    }

    @Override
    public void onViewCreated(View view, @Nullable Bundle savedInstanceState) {
        mPager = getView().findViewById(R.id.container);

        mPagerAdapter = new SectionsPagerAdapter(getChildFragmentManager());
        mPager.setAdapter(mPagerAdapter);
        TabLayout tabLayout = getView().findViewById(R.id.tabs);
        tabLayout.setupWithViewPager(mPager);
    }

    public class SectionsPagerAdapter extends FragmentPagerAdapter {

        public SectionsPagerAdapter(FragmentManager fragmentManager) {
            super(fragmentManager);
        }

        @Override
        public Fragment getItem(int position) {
            Bundle args = new Bundle();
            CreditsPagerFragment contactsPagerFragment = new CreditsPagerFragment();
            args.putInt(ContactsPagerFragment.CONTACTS_SWITCH, position);
            contactsPagerFragment.setArguments(args);
            return contactsPagerFragment;
        }

        @Override
        public int getCount() {
            return 2;
        }

        @Override
        public CharSequence getPageTitle(int position) {
            switch (position) {
                case 0:
                    return "Developers";
                case 1:
                    return "Designers";
            }
            return null;
        }

    }

    @Override
    public void onAttach(Activity activity) {
        mycontext = (FragmentActivity) activity;
        super.onAttach(activity);
    }
}
