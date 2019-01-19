package com.dota.arena2019.fragment;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.support.v7.widget.Toolbar;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import com.dota.arena2019.R;


public class ReachUsFragment extends Fragment {
    @Override
    public void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

    }

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, Bundle savedInstanceState) {
        return inflater.inflate(R.layout.fragment_text_display, container, false);
    }

    @Override
    public void onViewCreated(View view, @Nullable Bundle savedInstanceState) {
        TextView display = getActivity().findViewById(R.id.tv_display);
//        Toolbar toolbar = getActivity().findViewById(R.id.toolbar);
//        toolbar.setTitle("Reach Us");
        TextView title = getActivity().findViewById(R.id.morename);
        title.setText("Reach Us");
        display.setText(R.string.directions);
    }
}
