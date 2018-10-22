package com.dota.festmanager.services;

import android.app.NotificationChannel;
import android.app.NotificationManager;
import android.app.PendingIntent;
import android.content.Context;
import android.content.Intent;
import android.media.AudioAttributes;
import android.media.RingtoneManager;
import android.support.v4.app.NotificationCompat;
import android.util.Log;

import com.dota.festmanager.R;
import com.dota.festmanager.activity.MainActivity;
import com.google.firebase.messaging.FirebaseMessagingService;
import com.google.firebase.messaging.RemoteMessage;

public class RequestNotificationService extends FirebaseMessagingService {

    private static final String TAG = "FIREBASE MESSAGING",CHANNEL_ID = "EVENT_UPDATES";
    @Override
    public void onMessageReceived(RemoteMessage remoteMessage) {
        Log.d(TAG,"Callback is successful Jai Mahishmathi");
        String s = remoteMessage.getData().get("body");
        Log.d(TAG,s);

        Intent intent = new Intent(this, MainActivity.class);
        intent.setFlags(Intent.FLAG_ACTIVITY_NEW_TASK | Intent.FLAG_ACTIVITY_CLEAR_TASK);
        PendingIntent pendingIntent = PendingIntent.getActivity(this, 0, intent, 0);

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

            assert manager!=null;
            manager.createNotificationChannel(notificationChannel);

        }
        NotificationCompat.Builder mBuilder = new NotificationCompat.Builder( this, CHANNEL_ID)
                //TODO: Add Event logo or ATMOS logo instead of Google Logo
                .setSmallIcon(R.drawable.googleg_disabled_color_18)
                .setColor(getResources().getColor(R.color.colorPrimary))
                //TODO: Change the title to Event Name
                .setContentTitle(remoteMessage.getData().get("title"))
                .setContentIntent(pendingIntent)
                .setContentText(s);

        Log.d(TAG,"Notification Builder is built");

        assert manager!=null;
        manager.notify(0, mBuilder.build());

        Log.d(TAG,"Notification sent");
    }
}
