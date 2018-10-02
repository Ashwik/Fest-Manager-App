package com.android.dota.festmanager.fragment;

import android.app.ActionBar;
import android.content.Context;
import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ProgressBar;
import android.widget.TextView;
import android.widget.Toast;


import com.android.dota.festmanager.R;
import com.android.dota.festmanager.activity.DetailsActivity;
import com.android.dota.festmanager.activity.MainActivity;
import com.android.dota.festmanager.api.ApiClient;
import com.android.dota.festmanager.api.EventsInterface;
import com.android.dota.festmanager.model.EventDetails;

import io.realm.Realm;
import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class DetailsFragment extends Fragment {

    public String id ;
    private EventDetails eventDetailsmodel;
    private TextView eventDetails,eventName,startTime;
    private ProgressBar progressBar;
    private Realm realm;
    private Context context;
    private String time;
    private String TAG = "DetailsFragment";
    private boolean isNetwork = false;
    @Override
    public void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        context = getContext();

    }

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        return inflater.inflate(R.layout.fragment_details,container,false);
    }

    @Override
    public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);
        Realm.init(context);
        realm = Realm.getDefaultInstance();
        eventDetails = getActivity().findViewById(R.id.eventdetails);
        eventName = getActivity().findViewById(R.id.event_details_name);
        startTime = getActivity().findViewById(R.id.event_startTime);
        progressBar = getActivity().findViewById(R.id.progress_bar_details);
        Bundle bundle= getActivity().getIntent().getExtras();
        id=bundle.getString("id");
        eventName.setVisibility(View.GONE);
        progressBar.setVisibility(View.VISIBLE);
        CallApi();
        }

    private void CallApi(){
        EventsInterface apiservice = ApiClient.getClient().create(EventsInterface.class);
        Call<EventDetails> call = apiservice.getEventDetails(id);
        call.enqueue(new Callback<EventDetails>() {
            @Override
            public void onResponse(Call<EventDetails> call, Response<EventDetails> response) {
                eventDetailsmodel = response.body();
                isNetwork = true;
                addDatatoRealm(eventDetailsmodel);
                getDatafromRealm(realm);
                progressBar.setVisibility(View.GONE);

            }

            @Override
            public void onFailure(Call<EventDetails> call, Throwable t) {
                getDatafromRealm(realm);
                Log.e(TAG,"No Internet");
                progressBar.setVisibility(View.GONE);
            }
        });
    }
    private void addDatatoRealm(EventDetails  details)
    {
        realm.beginTransaction();
        EventDetails model = realm.where(EventDetails.class).equalTo("id",id).findFirst();
        if(model==null)
        {
            EventDetails eventDetails = realm.createObject(EventDetails.class);
            eventDetails.setId(details.getId());
            eventDetails.setName(details.getName());
            eventDetails.setStartTime(details.getStartTime());
            eventDetails.setEndTime(details.getEndTime());
        }
        else
        {
            model.setAbout(details.getAbout());
            model.setName(details.getName());
            model.setStartTime(details.getStartTime());
            model.setEndTime(details.getEndTime());
        }
        realm.commitTransaction();

    }

    private void getDatafromRealm(Realm realm1)
    {
        if(realm1!=null)
        {
            EventDetails result = realm1.where(EventDetails.class).equalTo("id",id).findFirst();

            if(result == null)
            {
                //Toast.makeText(context, "No Network...Get Connected", Toast.LENGTH_SHORT).show();
                startTime.setText("Please connect to network .... the App needs internet to load data for the first time");
            }

            if(result != null)
            {
                if(isNetwork == false){
                    Toast.makeText(context,"No Network....Loading Offline Data",Toast.LENGTH_SHORT).show();

                }

                if(result.getName()!=null) {
                    ((DetailsActivity) getActivity()).setActionBarTitle(result.getName());
                }


                if(result.getAbout() != null) {
                    eventDetails.setText(result.getAbout());
                } else {
                    eventDetails.setText("Please connect to network .... the App needs internet to load data for the first time");
                }

                if (result.getStartTime()==null||result.getStartTime().equals("")) {
                    startTime.setVisibility(View.GONE);
                } else if(result.getStartTime()!=null){
                    time = getEventTime(result.getStartTime())[3] + ":" + getEventTime(result.getStartTime())[4] + " - " +
                            getEventTime(result.getEndTime())[3] + ":" + getEventTime(result.getEndTime())[4];
                    startTime.setText(time);
                }
            }
        }

    }

    public String[] getEventTime(String time)
    {

        // The format of the startTime string is yyyy-MM-dd-HH-mm
        // HH-mm is the time in 24 hour format. Use this after conversion to 12 hour format.

            String pattern = "\\d{4}(-\\d{2}){4}";
            String[] parts = {"", "", "", "", ""};
            // testdate corresponds to 10:05 AM (10:05 hours), 11th August 2018
            String testdate = "2018-08-11-10-05"; // replace with details.getStartTime()

            // validation condition. If false, do not parse the time, and have a default fallback option
            if (time != null && time.matches(pattern)) {
                // Split the testdate String, to obtain the various parts of the time
                parts = time.split("-");
                // wrt to testdate
                // parts[0] => yyyy => 2018
                // parts[1] => MM => 08
                // parts[2] => DD => 11
                // parts[3] => HH => 10
                // parts[4] => mm => 5
//            Log.e(TAG,parts[0]);
                return parts;
            }


            return parts;

        }


}
