package com.dota.arena2019.model;

public class LiveMatchType1 {
    String eventID,title,teamA,teamB,scoreA,scoreB,desc;

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

    public String getScoreA() {
        return scoreA;
    }

    public String getScoreB() {
        return scoreB;
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

    public void setScoreA(String scoreA) {
        this.scoreA = scoreA;
    }

    public void setScoreB(String scoreB) {
        this.scoreB = scoreB;
    }

    public String getDesc() {
        return desc;
    }

    public void setDesc(String desc) {
        this.desc = desc;
    }
}
