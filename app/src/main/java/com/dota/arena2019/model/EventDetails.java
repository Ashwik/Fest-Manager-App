package com.dota.arena2019.model;

import com.google.gson.annotations.SerializedName;

import io.realm.RealmObject;

public class EventDetails extends RealmObject {
    @SerializedName("_id")
    String id;
    @SerializedName("name")
    String name;
    @SerializedName("body")
    String body;
    @SerializedName("about")
    String about;
    @SerializedName("prize")
    String prize;
    @SerializedName("price")
    String price;
    @SerializedName("teamSize")
    String teamSize;
    @SerializedName("thumbnail")
    String thumbnail;
    @SerializedName("startTime")
    String startTime;
    @SerializedName("endTime")
    String endTime;
    @SerializedName("type")
    String type;
    @SerializedName("tagline")
    String tagline;
    @SerializedName("venue")
    String venue;
    @SerializedName("route")
    String route;

    String date;

    public void setName(String name) {
        this.name = name;
    }

    public void setId(String id) {
        this.id = id;
    }

    public void setBody(String body) {
        this.body = body;
    }

    public void setAbout(String about) {
        this.about = about;
    }

    public void setPrice(String price) {
        this.price = price;
    }

    public void setPrize(String prize) {
        this.prize = prize;
    }

    public void setTeamSize(String teamSize) {
        this.teamSize = teamSize;
    }

    public void setThumbnail(String thumbnail) {
        this.thumbnail = thumbnail;
    }

    public void setStartTime(String startTime) {
        this.startTime = startTime;
    }

    public void setEndTime(String endTime) {
        this.endTime = endTime;
    }

    public void setType(String type) {
        this.type = type;
    }

    public void setTagline(String tagline) {
        this.tagline = tagline;
    }

    public void setVenue(String venue) {
        this.venue = venue;
    }

    public void setDate(String date) {
        this.date = date;
    }

    public void setRoute(String route) {
        this.route = route;
    }

    public String getName() {
        return name;
    }

    public String getBody() {
        return body;
    }

    public String getId() {
        return id;
    }

    public String getAbout() {
        return about;
    }

    public String getPrice() {
        return price;
    }

    public String getPrize() {
        return prize;
    }

    public String getTeamSize() {
        return teamSize;
    }

    public String getThumbnail() {
        return thumbnail;
    }

    public String getStartTime() {
        return startTime;
    }

    public String getEndTime() {
        return endTime;
    }

    public String getType() {
        return type;
    }

    public String getTagline() {
        return tagline;
    }

    public String getVenue() {
        return venue;
    }

    public String getDate() {
        return date;
    }

    public String getRoute() {
        return route;
    }
}

