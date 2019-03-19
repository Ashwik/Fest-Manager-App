package com.dota.pearl2019.fragment;

import android.content.Context;
import android.graphics.Color;
import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ProgressBar;
import android.widget.TextView;
import android.widget.Toast;

import com.dota.pearl2019.R;
import com.dota.pearl2019.api.ApiClient;
import com.dota.pearl2019.api.EventsInterface;
import com.dota.pearl2019.model.EventDetails;

import io.realm.Realm;
import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;
import us.feras.mdv.MarkdownView;

public class DetailsFragment extends Fragment {

    public String id;
    private EventDetails eventDetailsmodel;
    private TextView eventName, startTime, eventFee, eventPrizemoney;
    private MarkdownView eventDetails;
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
        return inflater.inflate(R.layout.fragment_details, container, false);
    }

    @Override
    public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);


        Realm.init(context);
        realm = Realm.getDefaultInstance();
        eventDetails = getActivity().findViewById(R.id.eventdetails);
        eventName = getActivity().findViewById(R.id.event_details_name);
        startTime = getActivity().findViewById(R.id.event_startTime);
        eventFee = getActivity().findViewById(R.id.event_fee);
        eventPrizemoney = getActivity().findViewById(R.id.event_prizemoney);
        progressBar = getActivity().findViewById(R.id.progress_bar_details);
        Bundle bundle = getActivity().getIntent().getExtras();
        id = bundle.getString("id");
//        eventName.setVisibility(View.GONE);
        progressBar.setVisibility(View.VISIBLE);
        eventDetails.setBackgroundColor(Color.TRANSPARENT);
        CallApi();
    }

    private void CallApi() {
        EventsInterface apiservice = ApiClient.getClient().create(EventsInterface.class);
        Call<EventDetails> call = apiservice.getEventDetails(id);
        call.enqueue(new Callback<EventDetails>() {
            @Override
            public void onResponse(Call<EventDetails> call, Response<EventDetails> response) {
                eventDetailsmodel = response.body();
                try {
                    isNetwork = true;
                    addDatatoRealm(eventDetailsmodel);
                } catch (Exception e) {
                    Toast.makeText(context, "Network problem", Toast.LENGTH_SHORT).show();
                }
                getDatafromRealm(realm);
                progressBar.setVisibility(View.GONE);

            }

            @Override
            public void onFailure(Call<EventDetails> call, Throwable t) {
                getDatafromRealm(realm);
                Log.e(TAG, "No Internet");
                progressBar.setVisibility(View.GONE);
            }
        });
    }

    private void addDatatoRealm(EventDetails details) {
        realm.beginTransaction();
        EventDetails model = realm.where(EventDetails.class).equalTo("id", id).findFirst();
        if (model == null) {
            EventDetails eventDetails = realm.createObject(EventDetails.class);
            eventDetails.setId(details.getId());
            eventDetails.setName(details.getName());
            eventDetails.setAbout(details.getAbout());
            eventDetails.setStartTime(getEventTime(details.getStartTime())[3] + ":" + getEventTime(details.getStartTime())[4]);
            eventDetails.setEndTime(details.getEndTime());
        } else {
            model.setName(details.getName());
            model.setAbout(details.getAbout());
            model.setStartTime(getEventTime(details.getStartTime())[3] + ":" + getEventTime(details.getStartTime())[4]);
            model.setEndTime(details.getEndTime());
        }
        realm.commitTransaction();

    }

    private void getDatafromRealm(Realm realm1) {
        if (realm1 != null) {
            EventDetails result = realm1.where(EventDetails.class).equalTo("id", id).findFirst();

            if (result == null) {
                //Toast.makeText(context, "No Network...Get Connected", Toast.LENGTH_SHORT).show();
                startTime.setText("Please connect to network .... the App needs internet to load data for the first time");
            }

            if (result != null) {
                if (isNetwork == false) {
                    Toast.makeText(context, "No Network....Loading Offline Data", Toast.LENGTH_SHORT).show();

                }

//                if(result.getName()!=null) {
//                    try {
//                        ((DetailsActivity) getActivity()).setActionBarTitle(result.getName());
//                    } catch (Exception e) {
//                        ((DetailsActivity) getActivity()).setActionBarTitle("");
//                    }
//                }else {
//                    ((DetailsActivity) getActivity()).setActionBarTitle("");
//                }


                if (result.getAbout() != null) {
                    eventDetails.loadMarkdown(result.getAbout(), "file:///android_asset/alt.css");
                    eventDetails.setBackgroundColor(Color.TRANSPARENT);
                } else {
                    eventDetails.loadMarkdown("Please connect to network .... the App needs internet to load data for the first time", "file:///android_asset/alt.css");
                }
                if (result.getName() != null) {
                    eventName.setText(result.getName());
                } else {
                    eventName.setVisibility(View.GONE);
                }
                if (result.getEndTime() == null || result.getEndTime().equals("")) {
                    startTime.setVisibility(View.GONE);
                } else if (result.getStartTime() != null && result.getEndTime() != null) {
                    //Since the fest is happening on 26th, 27th, 29th the suffix th is added.
                    Log.e(TAG, result.getStartTime());
                    time = result.getStartTime() + " - " +
                            getEventTime(result.getEndTime())[3] + ":" + getEventTime(result.getEndTime())[4];
                    startTime.setText(time);
                }

                if(eventFee.equals("")){
                    eventFee.setVisibility(View.GONE);
                }
                else {
                    eventFee.setVisibility(View.VISIBLE);
                    eventFee.setText("FEE "+result.getPrice());
                }
                if(eventPrizemoney.equals("")){
                    eventPrizemoney.setVisibility(View.GONE);
                }else{
                    eventPrizemoney.setVisibility(View.VISIBLE);
                    eventPrizemoney.setText("PRIZE "+result.getPrize());
                }


            }
        }

    }

    public String[] getEventTime(String time) {

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
