package com.dota.festmanager.model;


import android.support.annotation.DrawableRes;

import com.dota.festmanager.R;


public class DeveloperDetails {
    private String mName;
    private int mProfileImage;
    private String[] mLinks = {null, null, null, null};

    public DeveloperDetails(String name, @DrawableRes int profileImage, String[] links) {
        mName = name;
        mProfileImage = profileImage;
        mLinks = links;
    }

    public DeveloperDetails(String name, String[] links) {
        mName = name;
        mProfileImage = R.drawable.profile_icon;
        mLinks = links;
    }

    public String getName() {
        return mName;
    }

    public int getProfileImage() {
        return mProfileImage;
    }

    public String[] getLinks() {
        return mLinks;
    }
}
