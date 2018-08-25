package com.android.dota.festmanager.database;

import android.app.Application;

import io.realm.Realm;
import io.realm.RealmConfiguration;

/**
 * Created by ashwik on 26-02-2018.
 */

public class RealmDatabase extends Application {

    @Override
    public void onCreate() {
        super.onCreate();
        Realm.init(this);

        RealmConfiguration realmConfiguration =
                new RealmConfiguration.Builder().name(Realm.DEFAULT_REALM_NAME)
                        .schemaVersion(0).build();

        Realm.setDefaultConfiguration(realmConfiguration);


    }
}
