package com.dota.arena2019;

import android.app.Application;

import com.google.firebase.FirebaseApp;

import io.realm.Realm;

public class MyApplication extends Application {
    @Override
    public void onCreate() {
        super.onCreate();
        FirebaseApp.initializeApp(getApplicationContext());
        Realm.init(getApplicationContext());
    }
}
