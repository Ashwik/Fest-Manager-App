package com.dota.festmanager.fragment;
import android.app.ProgressDialog;
import android.content.Context;
import android.net.ConnectivityManager;
import android.net.NetworkInfo;
import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.support.v7.widget.Toolbar;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ProgressBar;
import android.widget.Toast;

import com.dota.festmanager.R;
import com.dota.festmanager.adapter.FeedAdapter;
import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.database.ValueEventListener;
import java.util.ArrayList;
public class FeedFragment extends Fragment {
    RecyclerView mRecyclerView;
    FeedAdapter mFeedAdapter;
    ArrayList<Long> timeArray =new ArrayList<>();
    ArrayList<String> deptArray =new ArrayList<>();
    ArrayList<String> descArray =new ArrayList<>();
    int i=0;
    private ProgressBar progressBar;
    private  Context context;
    public void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        context = getContext();
    }
    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, Bundle savedInstanceState) {
        return inflater.inflate(R.layout.fragment_feed,container,false);
    }
    @Override
    public void onViewCreated( View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);

        Toolbar toolbar = getActivity().findViewById(R.id.toolbar);
        toolbar.setTitle("Feed");
        progressBar = getActivity().findViewById(R.id.progress_bar);

        mRecyclerView = view.findViewById(R.id.feed1);

        progressBar.setVisibility(View.VISIBLE);


        final DatabaseReference database = FirebaseDatabase.getInstance().getReference();
        final DatabaseReference notification = database.child("notifications");
        Log.v("Feed Adapter","timeArray is created..!!!!");
        notification.addValueEventListener(new ValueEventListener() {
            @Override
            public void onDataChange(@NonNull DataSnapshot dataSnapshot) {
                timeArray = new ArrayList<>();
                descArray = new ArrayList<>();
                deptArray = new ArrayList<>();
                i=0;
                for (DataSnapshot ds:dataSnapshot.getChildren())
                {
                    timeArray.add(ds.child("timestamp").getValue(Long.class));
                    descArray.add(ds.child("content").getValue(String.class));
                    deptArray.add(ds.child("title").getValue(String.class));
                    i++;
                }
                Log.e("FEED FRAGMENT",Integer.toString(deptArray.size()));
                mRecyclerView.setLayoutManager(new LinearLayoutManager(getActivity()));
                mFeedAdapter = new FeedAdapter(getActivity(),timeArray,deptArray,descArray,i);
                //mFeedAdapter.notifyDataSetChanged();
                mRecyclerView.setAdapter(mFeedAdapter);
                progressBar.setVisibility(View.GONE);

            }
            @Override
            public void onCancelled(@NonNull DatabaseError databaseError) {

            }
        });
        System.out.println(descArray.size());
        if(!isOnline()){
            progressBar.setVisibility(View.GONE);
            Toast.makeText(context,"No Network",Toast.LENGTH_SHORT).show();
        }else{
                Toast.makeText(context, "Feed Updated!", Toast.LENGTH_SHORT).show();
        }
    }

    @Override
    public void onStop() {
        super.onStop();
        progressBar.setVisibility(View.GONE);
    }

    public boolean isOnline() {
        ConnectivityManager cm =
                (ConnectivityManager) getActivity().getSystemService(context.CONNECTIVITY_SERVICE);
        NetworkInfo netInfo = cm.getActiveNetworkInfo();
        return netInfo != null && netInfo.isConnectedOrConnecting();
    }
}
