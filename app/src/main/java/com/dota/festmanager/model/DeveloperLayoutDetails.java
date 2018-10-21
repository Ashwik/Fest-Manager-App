package com.dota.festmanager.model;

import java.util.ArrayList;

public class DeveloperLayoutDetails {

    String title;
    ArrayList<DeveloperDetails> devs;

    public DeveloperLayoutDetails(String title, ArrayList<DeveloperDetails> devs) {
        this.title = title;
        this.devs = devs;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public ArrayList<DeveloperDetails> getDevs() {
        return devs;
    }

    public void setDevs(ArrayList<DeveloperDetails> devs) {
        this.devs = devs;
    }

}
