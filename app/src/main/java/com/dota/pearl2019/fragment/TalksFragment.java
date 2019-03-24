package com.dota.pearl2019.fragment;

import android.content.Context;
import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.support.v7.widget.Toolbar;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import com.dota.pearl2019.R;
import com.dota.pearl2019.adapter.TalksAdapter;

public class TalksFragment extends Fragment {
    private Context context;
    private RecyclerView recyclerView;
    private int root;

    @Override
    public void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        context = getContext();
        root = getArguments().getInt("from");
    }

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, Bundle savedInstanceState) {
        return inflater.inflate(R.layout.fragment_talks, container, false);
    }

    public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);

        Toolbar toolbar = getActivity().findViewById(R.id.toolbar);
        TextView textView = view.findViewById(R.id.schedule_text_1);
        if (root == 0) {
            textView.setText("Talks");
        } else {
            textView.setText("Proshows");
        }
        if (root == 0) {
            toolbar.setTitle("Talks");
        } else {
            toolbar.setTitle("Proshows");
        }
        recyclerView = getActivity().findViewById(R.id.schedule_card_recycler_view);
        recyclerView.setLayoutManager(new LinearLayoutManager(context, LinearLayoutManager.HORIZONTAL, false));
        TalksAdapter talksAdapter = new TalksAdapter(context, root);
        recyclerView.setAdapter(talksAdapter);
    }
}
