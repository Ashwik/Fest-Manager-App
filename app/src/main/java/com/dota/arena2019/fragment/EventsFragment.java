package com.dota.arena2019.fragment;

import android.content.Context;
import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.support.v4.widget.SwipeRefreshLayout;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ProgressBar;
import android.widget.Toast;

import com.dota.arena2019.R;
import com.dota.arena2019.adapter.EventsAdapter;
import com.dota.arena2019.api.ApiClient;
import com.dota.arena2019.api.EventsInterface;
import com.dota.arena2019.model.EventDetails;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;

import io.realm.Realm;
import io.realm.RealmResults;
import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class EventsFragment extends Fragment {
    private ArrayList<EventDetails> eventDetailsList = new ArrayList<>();
    private ArrayList<EventDetails> realmList = new ArrayList<>();
    private RecyclerView recyclerView;
    private SwipeRefreshLayout swipeRefreshLayout;
    private Realm realm;
    private Context context;
    private boolean isnetwork = false;
    private String TAG = "EventsFragment";
    private ProgressBar progressBar;
    private String event_category;
    private Integer event_category_id;


    public void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        context = getContext();
    }

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, Bundle savedInstanceState) {
        return inflater.inflate(R.layout.fragment_events, container, false);
    }

    @Override
    public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);


//        Bundle bundle= getActivity().getIntent().getExtras();
//        event_category = bundle.getString(String.valueOf(R.string.event_type_id));

//       event_category_id  = bundle.getInt(String.valueOf(R.string.event_type_id));
//        Log.e("Events",String.valueOf(event_category_id));
//        switch(event_category_id){
//            case R.drawable.workshops : event_category = "Workshop";break;
//            case R.drawable.competitions: event_category = "Competition";break;
//            case R.drawable.talks: event_category ="Talk";break;
//            default:event_category="Workshop";break;
//
//        }

//        ((EventsActivity)getActivity()).setActionBarTitle(event_category+"s");

        Realm.init(context);
        realm = Realm.getDefaultInstance();
        recyclerView = getActivity().findViewById(R.id.event_recycler_view);
        swipeRefreshLayout = getActivity().findViewById(R.id.swipe_to_refresh_events);
        progressBar = getActivity().findViewById(R.id.progress_bar);
        progressBar.setVisibility(View.VISIBLE);
        callApi();

        swipeRefreshLayout.setOnRefreshListener(new SwipeRefreshLayout.OnRefreshListener() {
            @Override
            public void onRefresh() {
                callApi();
            }
        });


    }

    private void callApi() {
        EventsInterface apiservice = ApiClient.getClient().create(EventsInterface.class);
        Call<ArrayList<EventDetails>> call = apiservice.getEvents();
        call.enqueue(new Callback<ArrayList<EventDetails>>() {
            @Override
            public void onResponse(Call<ArrayList<EventDetails>> call, Response<ArrayList<EventDetails>> response) {
                eventDetailsList = response.body();
                try {
                    for (int i = 0; i < eventDetailsList.size(); i++) {
                        addDatatoRealm(eventDetailsList.get(i));
                    }
                    isnetwork = true;
                } catch (Exception e) {
                    Toast.makeText(context, "Network Problem", Toast.LENGTH_SHORT).show();
                }
                getDatafromRealm(realm);
                swipeRefreshLayout.setRefreshing(false);
                progressBar.setVisibility(View.GONE);
            }

            @Override
            public void onFailure(Call<ArrayList<EventDetails>> call, Throwable t) {
                Log.e(TAG, "No Internet");
                getDatafromRealm(realm);
                swipeRefreshLayout.setRefreshing(false);
                progressBar.setVisibility(View.GONE);
            }
        });
    }

    private void addDatatoRealm(EventDetails details) {
        realm.beginTransaction();
        EventDetails model = realm.where(EventDetails.class).equalTo("id", details.getId()).findFirst();
        if (model == null) {
            EventDetails event = realm.createObject(EventDetails.class);
            event.setId(details.getId());
            event.setName(details.getName());
            event.setAbout(details.getAbout());
            event.setTagline(details.getTagline());
            event.setPrize(details.getPrize());
            event.setPrice(details.getPrice());
            event.setVenue(details.getVenue());
            event.setType(details.getType());
            event.setStartTime(getEventTime(details.getStartTime())[3] + ":" + getEventTime(details.getStartTime())[4]);
            event.setEndTime(details.getEndTime());
            event.setRoute(details.getRoute());
        } else {
            model.setName(details.getName());
            model.setAbout(details.getAbout());
            model.setTagline(details.getTagline());
            model.setPrize(details.getPrize());
            model.setPrice(details.getPrice());
            model.setVenue(details.getVenue());
            model.setType(details.getType());
            model.setStartTime(getEventTime(details.getStartTime())[3] + ":" + getEventTime(details.getStartTime())[4]);
            model.setEndTime(details.getEndTime());
            model.setRoute(details.getRoute());
        }
        realm.commitTransaction();
    }

    private void getDatafromRealm(Realm realm1) {
        if (realm1 != null) {
            realmList = new ArrayList<>();

            RealmResults<EventDetails> results = realm1.where(EventDetails.class).findAll();

            if (results.size() == 0) {
                Toast.makeText(context, "No Internet", Toast.LENGTH_SHORT).show();
            } else {
                if (!isnetwork) {
                    Toast.makeText(context, "Loading....Offline Data", Toast.LENGTH_SHORT).show();
                }

                for (int i = 0; i < results.size(); i++) {
                    if (results.get(i).getRoute() == null || results.get(i).getRoute().equals("")) {
                        Log.e(TAG, "No Route found");
                    } else {
                        realmList.add(results.get(i));
                        Log.e(TAG, results.get(i).getRoute());
                    }
                }

                Log.e(TAG, String.valueOf(realmList.size()) + " " + String.valueOf(results.size()));
            }
            setAdapter(realmList);
        } else {
            Log.e(TAG, "realm is null");
        }
    }

    private void setAdapter(ArrayList<EventDetails> eventList) {
        recyclerView.setLayoutManager(new LinearLayoutManager(getActivity()));
        recyclerView.setAdapter(new EventsAdapter(eventList, context));
    }

    @Override
    public void onStop() {
        super.onStop();
        progressBar.setVisibility(View.GONE);
    }

    public String[] getEventTime(String time) {

        // The format of the startTime string is yyyy-MM-dd-HH-mm
        // HH-mm is the time in 24 hour format. Use this after conversion to 12 hour format.

        String pattern = "\\d{4}(-\\d{2}){4}";
        String[] parts = {"", "", "", "", ""};
        // testdate corresponds to 10:05 AM (10:05 hours), 11th August 2018
        String testdate = "2018-08-11-10-05"; // replace with details.getStartTime()

        // validation condition. If false, do not parse the time, and have a default fallback option
        if (time.matches(pattern)) {
            // Split the testdate String, to obtain the various parts of the time
            parts = time.split("-");
            // wrt to testdate
            // parts[0] => yyyy => 2018
            // parts[1] => MM => 08
            // parts[2] => DD => 11
            // parts[3] => HH => 10
            // parts[4] => mm => 5
            return parts;
        }

        return parts;

    }
}
