package com.dota.pearl2019.fragment;

import android.content.Context;
import android.media.Image;
import android.os.Bundle;
import android.os.Handler;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.support.v7.widget.GridLayoutManager;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.support.v7.widget.Toolbar;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.view.animation.AlphaAnimation;
import android.view.animation.Animation;
import android.widget.ImageView;

import com.dota.pearl2019.R;
import com.dota.pearl2019.adapter.LandingAdapter;

import java.util.ArrayList;

public class LandingFragment extends Fragment {
    private Context context;
    private RecyclerView recyclerView;
    private ArrayList<String> list = new ArrayList<>();

    @Override
    public void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        context = getContext();

    }

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        return inflater.inflate(R.layout.fragment_landing, container, false);
    }

    @Override
    public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);

        Toolbar toolbar = getActivity().findViewById(R.id.toolbar);
        toolbar.setTitle("Events");
        final ImageView splash = view.findViewById(R.id.splash_image);

        recyclerView = getActivity().findViewById(R.id.landing_recycler_view);
        list.add("FEED");
        list.add("EVENTS");
        list.add("SCHEDULE");
        list.add("PROSHOWS");
        list.add("TALKS");
        list.add("CONTACTS");
        list.add("GUIDE");
        list.add("CREDITS");

        recyclerView.setLayoutManager(new GridLayoutManager(context,2));
        recyclerView.setHasFixedSize(true);
        recyclerView.setAdapter(new LandingAdapter(list, context));

        recyclerView.setVisibility(View.GONE);
        new Handler().postDelayed(new Runnable() {
            @Override
            public void run() {
                AlphaAnimation anim = new AlphaAnimation(1.0f, 0.0f);
                anim.setDuration(500);
                anim.setRepeatCount(0);
                anim.setAnimationListener(new Animation.AnimationListener() {
                    @Override
                    public void onAnimationStart(Animation animation) {

                    }

                    @Override
                    public void onAnimationEnd(Animation animation) {
                        splash.setVisibility(View.GONE);
                    }

                    @Override
                    public void onAnimationRepeat(Animation animation) {

                    }
                });
                splash.startAnimation(anim);

                AlphaAnimation anim2 = new AlphaAnimation(0.0f, 1.0f);
                anim2.setDuration(500);
                anim2.setRepeatCount(0);
                anim2.setAnimationListener(new Animation.AnimationListener() {
                    @Override
                    public void onAnimationStart(Animation animation) {

                    }

                    @Override
                    public void onAnimationEnd(Animation animation) {
                       recyclerView.setVisibility(View.VISIBLE);
                    }

                    @Override
                    public void onAnimationRepeat(Animation animation) {

                    }
                });
                recyclerView.startAnimation(anim2);
            }
        }, 1500);
    }
}
