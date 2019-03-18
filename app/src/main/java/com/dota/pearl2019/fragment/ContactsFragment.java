package com.dota.pearl2019.fragment;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.design.widget.TabLayout;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentPagerAdapter;
import android.support.v4.view.PagerAdapter;
import android.support.v4.view.ViewPager;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.dota.pearl2019.R;

public class ContactsFragment extends Fragment {
    private ViewPager mPager;
    private PagerAdapter mPagerAdapter;

    public void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
    }

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, Bundle savedInstanceState) {
        return inflater.inflate(R.layout.fragment_contacts, container, false);
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
            ContactsPagerFragment contactsPagerFragment = new ContactsPagerFragment();
            args.putInt(ContactsPagerFragment.CONTACTS_SWITCH, position);
            contactsPagerFragment.setArguments(args);
            return contactsPagerFragment;
        }

        @Override
        public int getCount() {
            return 2;
        }
    }
}
