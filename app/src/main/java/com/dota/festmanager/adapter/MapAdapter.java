package com.dota.festmanager.adapter;

import android.content.Context;
import android.content.Intent;
import android.net.Uri;
import android.support.annotation.NonNull;
import android.support.v7.widget.RecyclerView;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import com.dota.festmanager.R;

import static android.content.Intent.FLAG_ACTIVITY_NEW_TASK;

public class MapAdapter extends RecyclerView.Adapter<MapAdapter.MyViewHolder> {

    Context context;
    String[] placeName = {
            "Main Gate",
            "Bus Stop",
            "Cafeteria",
            "Auditorium",
            "SBI & ATM",
            "More Shopping mall",
            "Mess 1",
            "Mess 2",
            "Student Activity Center",
            "Cricket Ground",
            "Football Ground",
            "Volleyball Court",
            "Basketball Court",
            "Athletics Track",
            "Kabaddi Arena",
            "Tennis Court",
            "Hockey Ground"};
    public static double[] latitudes = {
            17.547152,
            17.547400,
            17.544982,
            17.545510,
            17.542241,
            17.542021,
            17.542428,
            17.544771,
            17.540799,
            17.539651,
            17.543518,
            17.543027,
            17.541337,
            17.554366,
            17.543386,
            17.541702,
            17.543819};

    public static double[] longitudes = {
            78.572481,
            78.572387,
            78.570834,
            78.570511,
            78.575974,
            78.576085,
            78.574010,
            78.575194,
            78.575273,
            78.577416,
            78.574854,
            78.575390,
            78.575361,
            78.545626,
            78.575632,
            78.575606,
            78.574045};

    public MapAdapter(Context context) {
        this.context = context;
    }

    @NonNull
    @Override
    public MyViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        LayoutInflater inflater = (LayoutInflater) context.getSystemService(Context.LAYOUT_INFLATER_SERVICE);
        View view = inflater.inflate(R.layout.fragment_maps_item, parent, false);
        return new MyViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull MyViewHolder holder, final int position) {
        holder.textView.setText(placeName[position]);

        holder.itemView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(Intent.ACTION_VIEW,
                        Uri.parse("google.navigation:q=" + latitudes[position] + "," + longitudes[position]));
                intent.addFlags(FLAG_ACTIVITY_NEW_TASK);
                Log.e("", "Selected" + position);
                context.getApplicationContext().startActivity(intent);


            }
        });


    }

    @Override
    public int getItemCount() {
        return placeName.length;
    }

    public class MyViewHolder extends RecyclerView.ViewHolder {

        TextView textView;

        public MyViewHolder(View itemView) {
            super(itemView);
            textView = itemView.findViewById(R.id.place_text);

//            textView.setOnClickListener(this);
        }

//        @Override
//        public void onClick(View v) {
//            int position = getAdapterPosition();
//            int i = position;
//            switch (v.getId()) {
//
//                case R.id.place_text:
//
//                    Intent intent = new Intent(Intent.ACTION_VIEW,
//                            Uri.parse("google.navigation:q=" + latitudes[i] + "," + longitudes[i]));
//                    intent.addFlags(FLAG_ACTIVITY_NEW_TASK);
//                    context.getApplicationContext().startActivity(intent);
//                    Log.w("", "Selected" + position);
//                    break;
//            }
//
//        }
    }
}

