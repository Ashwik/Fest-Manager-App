package com.dota.festmanager.model;

/**
 * Created by Vineeth on 2/13/2018.
 */

public class Contact {

    private String mName, mDesignation, mMobile;

    public Contact(String name, String designation, String mobile){
        mName = name;
        mDesignation = designation;
        mMobile = mobile;
    }

    public String getName() {
        return mName;
    }

    public String getDesignation() {
        return mDesignation;
    }

    public String getMobile() {
        return mMobile;
    }
}
