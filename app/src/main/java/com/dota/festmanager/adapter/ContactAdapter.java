package com.dota.festmanager.adapter;

import android.content.Context;
import android.content.Intent;
import android.net.Uri;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;


import com.dota.festmanager.R;
import com.dota.festmanager.model.Contact;

import java.util.ArrayList;

/**
 * Created by Vineeth on 2/13/2018.
 */

public class ContactAdapter extends RecyclerView.Adapter<ContactAdapter.ContactViewHolder> {

    LayoutInflater mInflater;
    ArrayList<Contact> mArrayList;

    public ContactAdapter(Context context){
        mInflater = LayoutInflater.from(context);
        mArrayList = new ArrayList<>();
    }

    public void setArrayList(ArrayList<Contact> arrayList) {
        mArrayList = arrayList;
    }

    @Override
    public ContactViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View v = mInflater.inflate(R.layout.fragment_contact_item,parent, false);
        return new ContactViewHolder(v);
    }

    @Override
    public void onBindViewHolder(final ContactViewHolder holder, int position) {
        holder.name.setText(mArrayList.get(position).getName());
        holder.designation.setText(mArrayList.get(position).getDesignation());
        holder.callButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                String mobile = mArrayList.get(holder.getAdapterPosition()).getMobile();
                if(mobile != null){
                    Uri number = Uri.parse("tel:" + mArrayList.get(holder.getAdapterPosition()).getMobile());
                    holder.itemView.getContext().startActivity(new Intent(Intent.ACTION_DIAL, number));
                }
            }
        });
    }

    @Override
    public int getItemCount() {
        return mArrayList.size();
    }

    public class ContactViewHolder extends RecyclerView.ViewHolder{
        TextView name;
        TextView designation;
        ImageView callButton;
        public ContactViewHolder(View view){
            super(view);
            name = view.findViewById(R.id.name);
            designation = view.findViewById(R.id.designation);
            callButton = view.findViewById(R.id.call_button);
        }
    }
}
