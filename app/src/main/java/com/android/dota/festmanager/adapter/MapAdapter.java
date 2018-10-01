package com.android.dota.festmanager.adapter;

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

import com.android.dota.festmanager.R;

import static android.content.Intent.FLAG_ACTIVITY_NEW_TASK;

public class MapAdapter extends RecyclerView.Adapter<MapAdapter.MyViewHolder> {

    Context context;
    String[] placeName;
    double[] latitudes= {17.547152,
            17.547400,
            17.544982,
            17.545510,
            17.545019,
            17.544013,
            17.542024,
            17.542241,
            17.541928,
            17.542021,
            17.542428,
            17.544771,
            17.544141,
            17.544772,
            17.540799,
            17.545665,
            17.5453394,
            17.5443279,
            17.5456641};
    double[] longitudes={78.572481,
            78.572387,
            78.570834,
            78.570511,
            78.571561,
            78.573877,
            78.575848,
            78.575974,
            78.575802,
            78.576085,
            78.574010,
            78.575194,
            78.572706,
            78.571040,
            78.575273,
            78.571507,
            78.5723279,
            78.571846,
            78.571647};

    public MapAdapter(Context context, String[] placeName) {
        this.context = context;
        this.placeName = placeName;
    }

    @NonNull
    @Override
    public MyViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        LayoutInflater inflater=(LayoutInflater) context.getSystemService(Context.LAYOUT_INFLATER_SERVICE);
        View view=inflater.inflate(R.layout.fragment_maps_item,parent,false);
        return new MyViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull MyViewHolder holder, int position) {
        holder.textView.setText(placeName[position]);

       holder.itemView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent=new Intent(Intent.ACTION_VIEW);
                intent.addFlags(FLAG_ACTIVITY_NEW_TASK);
                context.getApplicationContext().startActivity(intent);
            }
        });


    }

    @Override
    public int getItemCount() {
        return placeName.length;
    }

    public class MyViewHolder extends RecyclerView.ViewHolder implements View.OnClickListener{

        TextView textView;

        public MyViewHolder(View itemView) {
            super(itemView);
            textView=itemView.findViewById(R.id.place_text);

            textView.setOnClickListener(this);
        }

        @Override
        public void onClick(View v) {
            int position=getAdapterPosition();
            int i=position;
            switch (v.getId()){

                case R.id.place_text:

                    Intent intent=new Intent(Intent.ACTION_VIEW,
                            Uri.parse("google.navigation:q="+latitudes[i]+","+longitudes[i]));
                    intent.addFlags(FLAG_ACTIVITY_NEW_TASK);
                    context.getApplicationContext().startActivity(intent);
                    Log.w("", "Selected"+position);
                    break;
            }

        }
        }
    }

