package com.dota.pearl2019.model;

public class LiveCricket {
    String eventID, title, teamA, teamB, scoreA, scoreB, desc, inning, t1;

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

    public String getInning() {
        return inning;
    }

    public void setInning(String inning) {
        this.inning = inning;
    }

    public String getT1() {
        return t1;
    }

    public void setT1(String t1) {
        this.t1 = t1;
    }
}
