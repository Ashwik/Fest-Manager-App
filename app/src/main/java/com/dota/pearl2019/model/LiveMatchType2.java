package com.dota.pearl2019.model;

import java.util.HashMap;

public class LiveMatchType2 {
    String eventID,title,teamA,teamB,desc,status,message;
    HashMap<String,HashMap<String,MatchSubset>> matches;

    public String getTeamB() {
        return teamB;
    }

    public String getTeamA() {
        return teamA;
    }

    public String getTitle() {
        return title;
    }

    public String getEventID() {
        return eventID;
    }

    public void setTeamB(String teamB) {
        this.teamB = teamB;
    }

    public void setTeamA(String teamA) {
        this.teamA = teamA;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public void setEventID(String eventID) {
        this.eventID = eventID;
    }

    public String getDesc() {
        return desc;
    }

    public void setDesc(String desc) {
        this.desc = desc;
    }

    public HashMap<String, HashMap<String, MatchSubset>> getMatches() {
        return matches;
    }

    public void setMatches(HashMap<String, HashMap<String, MatchSubset>> matches) {
        this.matches = matches;
    }

    public String getMessage() {
        return message;
    }

    public String getStatus() {
        return status;
    }

    public void setMessage(String message) {
        this.message = message;
    }

    public void setStatus(String status) {
        this.status = status;
    }
}
