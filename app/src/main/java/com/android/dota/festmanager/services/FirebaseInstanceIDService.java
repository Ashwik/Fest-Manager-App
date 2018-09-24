package com.android.dota.festmanager.services;

import android.util.Log;

import com.google.firebase.iid.FirebaseInstanceId;
import com.google.firebase.iid.FirebaseInstanceIdService;

public class FirebaseInstanceIDService extends FirebaseInstanceIdService {

    private static final String TAG = "MyFirebaseInstanceID";
    @Override
    public void onTokenRefresh() {
        String refreshedToken = FirebaseInstanceId.getInstance().getToken();
        try {
            sendRegistrationToServer();
        } catch (NullPointerException e) {
            Log.e("MyFirebaseInstanceID", "Null pointer exception for token");
        }
    }
    public static void sendRegistrationToServer() throws NullPointerException {
        final String token = FirebaseInstanceId.getInstance().getToken();
    }
}

