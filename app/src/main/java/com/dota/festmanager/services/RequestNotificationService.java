package com.dota.festmanager.services;

import android.app.NotificationChannel;
import android.app.NotificationManager;
import android.content.Context;
import android.media.AudioAttributes;
import android.media.RingtoneManager;
import android.support.v4.app.NotificationCompat;
import android.util.Log;

import com.dota.festmanager.R;
import com.google.firebase.messaging.FirebaseMessagingService;
import com.google.firebase.messaging.RemoteMessage;

public class RequestNotificationService extends FirebaseMessagingService {

    private static final String TAG = "RequestNotificationService",CHANNEL_ID = "EVENT_UPDATES";
    @Override
    public void onMessageReceived(RemoteMessage remoteMessage) {
        String s = remoteMessage.getData().get("body");
        if(s == null || s.equals(""))
            s = "You have a new notification";
        Log.d("FIREBASE MESSAGING",s);

        NotificationManager manager =(NotificationManager)getSystemService(Context.NOTIFICATION_SERVICE);
        if (android.os.Build.VERSION.SDK_INT >= android.os.Build.VERSION_CODES.O) {
            NotificationChannel notificationChannel = new NotificationChannel(CHANNEL_ID,
                    "ATMOS Updates", NotificationManager.IMPORTANCE_HIGH);
            AudioAttributes audioAttributes = new AudioAttributes.Builder()
                    .setContentType(AudioAttributes.CONTENT_TYPE_SONIFICATION)
                    .setUsage(AudioAttributes.USAGE_NOTIFICATION_RINGTONE)
                    .build();
            notificationChannel.setSound(RingtoneManager.getDefaultUri(RingtoneManager.TYPE_NOTIFICATION),audioAttributes);
            notificationChannel.setLockscreenVisibility(android.app.Notification.VISIBILITY_PUBLIC);
            manager.createNotificationChannel(notificationChannel);
        }
        NotificationCompat.Builder mBuilder = new NotificationCompat.Builder( this, CHANNEL_ID)
                .setSmallIcon(android.R.drawable.ic_dialog_info)
                .setColor(getResources().getColor(R.color.colorPrimary))
                .setContentTitle("ATMOS'18")
                .setContentText(s);
        manager.notify(0, mBuilder.build());
    }
}
