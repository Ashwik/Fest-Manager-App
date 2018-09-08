package com.android.dota.festmanager.api;

import com.android.dota.festmanager.model.EventDetails;

import java.util.ArrayList;

import retrofit2.Call;
import retrofit2.http.GET;

public interface EventsInterface {
    @GET("events")
    Call<ArrayList<EventDetails>> getEvents();

    @GET("events?fields=name,startTime,endTime,tagline,venue")
    Call<ArrayList<EventDetails>> getEventSchedule();
}
