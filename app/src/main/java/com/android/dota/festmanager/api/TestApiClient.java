package com.android.dota.festmanager.api;

import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;


public class TestApiClient {

    public static final String baseurl = "http://fest-manager.bits-hyd.org/api/";

    public static Retrofit retrofit = null;

    public static Retrofit getClient()
    {
        if(retrofit==null)
        {
            retrofit = new Retrofit.Builder().baseUrl(baseurl).
                    addConverterFactory(GsonConverterFactory.create()).build();
        }
        return retrofit;
    }

}
