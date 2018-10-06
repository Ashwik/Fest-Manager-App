package com.dota.festmanager.adapter;

import android.app.ProgressDialog;
import android.content.Context;
import android.content.SharedPreferences;
import android.support.annotation.NonNull;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.CheckBox;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import com.dota.festmanager.R;
import com.google.android.gms.tasks.OnFailureListener;
import com.google.android.gms.tasks.OnSuccessListener;
import com.google.firebase.messaging.FirebaseMessaging;

public class SettingsNotificationAdapter extends RecyclerView.Adapter<SettingsNotificationAdapter.MyViewHolder> {
    private String event_list[];
    private String topics[];
    private Context context;
    private SharedPreferences preferences;

    public SettingsNotificationAdapter(String list[], String topics[],Context context){
        this.event_list=list;
        this.topics=topics;
        this.context=context;
        preferences = context.getSharedPreferences("Notifications",Context.MODE_PRIVATE);
    }

    @Override
    public void onBindViewHolder(@NonNull final MyViewHolder holder, final int position) {
        holder.tv.setText(event_list[position]);

        if(preferences.getBoolean(topics[position],false)) holder.checkBox.setChecked(true);
        else holder.checkBox.setChecked(false);

        holder.checkBox.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if(holder.checkBox.isChecked()){
                    final ProgressDialog dialog = new ProgressDialog(holder.checkBox.getContext());
                    dialog.setMessage("Subscribing to "+event_list[position]);
                    dialog.show();
                    FirebaseMessaging.getInstance().subscribeToTopic(topics[position])
                            .addOnSuccessListener(new OnSuccessListener<Void>() {
                                @Override
                                public void onSuccess(Void aVoid) {
                                    preferences.edit().putBoolean(topics[position],true).apply();
                                    dialog.dismiss();
                                }
                            })
                            .addOnFailureListener(new OnFailureListener() {
                                @Override
                                public void onFailure(@NonNull Exception e) {
                                    Toast.makeText(context,"Facing some network issue",Toast.LENGTH_SHORT).show();
                                    holder.checkBox.setChecked(false);
                                    dialog.dismiss();
                                }
                            });
                }
                else{
                    final ProgressDialog dialog = new ProgressDialog(holder.checkBox.getContext());
                    dialog.setMessage("Unsubscribing from "+event_list[position]);
                    dialog.show();
                    FirebaseMessaging.getInstance().unsubscribeFromTopic(topics[position])
                            .addOnSuccessListener(new OnSuccessListener<Void>() {
                                @Override
                                public void onSuccess(Void aVoid) {
                                    preferences.edit().putBoolean(topics[position],false).apply();
                                    dialog.dismiss();
                                }
                            })
                            .addOnFailureListener(new OnFailureListener() {
                                @Override
                                public void onFailure(@NonNull Exception e) {
                                    Toast.makeText(context,"Facing some network issue",Toast.LENGTH_SHORT).show();
                                    holder.checkBox.setChecked(true);
                                    dialog.dismiss();
                                }
                            });
                }
            }
        });
    }

    @NonNull
    @Override
    public MyViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        return new MyViewHolder(LayoutInflater.from(parent.getContext()).inflate(R.layout.notif_row,parent,false));
    }

    @Override
    public int getItemCount() {
        return event_list.length;
    }

    class MyViewHolder extends RecyclerView.ViewHolder{
        private TextView tv;
        private CheckBox checkBox;
        private ImageView icon;
        MyViewHolder(View view){
            super(view);
            tv = view.findViewById(R.id.notifName);
            checkBox = view.findViewById(R.id.notifCheck);
            icon = view.findViewById(R.id.notifIcon);
        }
    }
}
