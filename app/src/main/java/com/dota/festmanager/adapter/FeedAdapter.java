package com.dota.festmanager.adapter;
import android.content.Context;
import android.support.annotation.NonNull;
import android.support.v7.widget.RecyclerView;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;
import com.dota.festmanager.R;
import java.util.ArrayList;
public class FeedAdapter extends RecyclerView.Adapter<FeedAdapter.FeedViewHolder> {
    Context context;
    LayoutInflater mInflater;
    ArrayList<Long> timeArray =new ArrayList<>();
    ArrayList<String> deptArray =new ArrayList<>();
    ArrayList<String> descArray =new ArrayList<>();
    int i;
    public FeedAdapter(Context context) {
        this.context = context;
        mInflater = LayoutInflater.from(context);
        Log.v("Feed Adapter","timeArray is created..!!!!");
        System.out.print(i);
    }
    public FeedAdapter(Context context, ArrayList<Long> timeArray, ArrayList<String> deptArray, ArrayList<String> descArray,int i) {
        this.context = context;
        this.timeArray = timeArray;
        this.deptArray = deptArray;
        this.descArray = descArray;
        this.i =i;
    }
    @NonNull
    @Override
    public FeedAdapter.FeedViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        LayoutInflater inflater=(LayoutInflater) context.getSystemService(Context.LAYOUT_INFLATER_SERVICE);
        View view=inflater.inflate(R.layout.notification,parent,false);
        return new FeedAdapter.FeedViewHolder(view);
    }
    @Override
    public void onBindViewHolder(@NonNull FeedViewHolder holder, final int position) {
        if(timeArray.get(position) !=null) {
            holder.time.setText(timeArray.get(position).toString());
        }else {
            holder.time.setText("");
        }
        if(deptArray.get(position)!=null&&deptArray.get(position).toString()!="") {
            holder.dept.setText(deptArray.get(position));
        }else {
            holder.dept.setText("");
        }
        if(descArray.get(position)!=null&&descArray.get(position).toString()!="") {
            holder.desc.setText(descArray.get(position));
        }else {
            holder.desc.setText("");
        }
    }
    @Override
    public int getItemCount() {
        return i;
    }
    public class FeedViewHolder extends RecyclerView.ViewHolder {
        TextView time;
        TextView dept;
        TextView desc;
        public FeedViewHolder(View itemView) {
            super(itemView);
            time = itemView.findViewById(R.id.time);
            dept = itemView.findViewById(R.id.dept);
            desc = itemView.findViewById(R.id.desc);
        }
    }
}