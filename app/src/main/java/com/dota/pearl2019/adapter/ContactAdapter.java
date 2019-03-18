package com.dota.pearl2019.adapter;

import android.content.Context;
import android.content.Intent;
import android.net.Uri;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import com.bumptech.glide.Glide;
import com.bumptech.glide.request.RequestOptions;
import com.dota.pearl2019.R;
import com.dota.pearl2019.model.Contact;

import java.util.ArrayList;

/**
 * Created by Vineeth on 2/13/2018.
 */

public class ContactAdapter extends RecyclerView.Adapter<ContactAdapter.ContactViewHolder> {

    LayoutInflater mInflater;
    ArrayList<Contact> mArrayList;
    Context context;

    public ContactAdapter(Context context) {
        mInflater = LayoutInflater.from(context);
        mArrayList = new ArrayList<>();
        this.context = context;
    }

    public void setArrayList(ArrayList<Contact> arrayList) {
        mArrayList = arrayList;
    }

    @Override
    public ContactViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View v = mInflater.inflate(R.layout.fragment_contact_item_c, parent, false);
        return new ContactViewHolder(v);
    }

    @Override
    public void onBindViewHolder(final ContactViewHolder holder, int position) {
        holder.name.setText(mArrayList.get(position).getName());
        holder.designation.setText(mArrayList.get(position).getDesignation());
        holder.callButton.setVisibility(View.VISIBLE);
        holder.callButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                String mobile = mArrayList.get(holder.getAdapterPosition()).getMobile();
                if (mobile != null) {
                    Uri number = Uri.parse("tel:" + mArrayList.get(holder.getAdapterPosition()).getMobile());
                    holder.itemView.getContext().startActivity(new Intent(Intent.ACTION_DIAL, number));
                }
            }
        });
//        if(mArrayList.get(0).getDesignation().equals("President")&&position!= (mArrayList.size()-1)){
//            holder.contactimage.setVisibility(View.VISIBLE);
//            switch (position){
//                case 0: Glide.with(context).load(R.drawable.oc_one)
//                        .apply(RequestOptions.circleCropTransform())
//                        .into(holder.contactimage);break;
//                case 1: Glide.with(context).load(R.drawable.oc_two)
//                        .apply(RequestOptions.circleCropTransform())
//                        .into(holder.contactimage);break;
//                case 2: Glide.with(context).load(R.drawable.oc_three)
//                        .apply(RequestOptions.circleCropTransform())
//                        .into(holder.contactimage);break;
//                case 3: Glide.with(context).load(R.drawable.oc_four)
//                        .apply(RequestOptions.circleCropTransform())
//                        .into(holder.contactimage);break;
//                case 4: Glide.with(context).load(R.drawable.oc_five)
//                        .apply(RequestOptions.circleCropTransform())
//                        .into(holder.contactimage);break;
//                case 5: Glide.with(context).load(R.drawable.oc_six)
//                        .apply(RequestOptions.circleCropTransform())
//                        .into(holder.contactimage);break;
//                case 6: Glide.with(context).load(R.drawable.oc_sev)
//                        .apply(RequestOptions.circleCropTransform())
//                        .into(holder.contactimage);break;
//                case 7: Glide.with(context).load(R.drawable.oc_eig)
//                        .apply(RequestOptions.circleCropTransform())
//                        .into(holder.contactimage);break;
//                case 8: Glide.with(context).load(R.drawable.oc_ni)
//                        .apply(RequestOptions.circleCropTransform())
//                        .into(holder.contactimage);break;
//                case 9: Glide.with(context).load(R.drawable.oc_ele)
//                        .apply(RequestOptions.circleCropTransform())
//                        .into(holder.contactimage);break;
//                case 10: Glide.with(context).load(R.drawable.oc_ten)
//                        .apply(RequestOptions.circleCropTransform())
//                        .into(holder.contactimage);break;
//                case 11: Glide.with(context).load(R.drawable.oc_fift)
//                        .apply(RequestOptions.circleCropTransform())
//                        .into(holder.contactimage);break;
//                case 12: Glide.with(context).load(R.drawable.oc_fourt)
//                        .apply(RequestOptions.circleCropTransform())
//                        .into(holder.contactimage);break;
//                case 13: Glide.with(context).load(R.drawable.oc_twe)
//                        .apply(RequestOptions.circleCropTransform())
//                        .into(holder.contactimage);break;
//                case 14: Glide.with(context).load(R.drawable.oc_thir)
//                        .apply(RequestOptions.circleCropTransform())
//                        .into(holder.contactimage);break;
//
//            }
//
//        }
            holder.contactimage.setVisibility(View.GONE);


        if(position==mArrayList.size()-1){
            holder.callButton.setVisibility(View.GONE);
        }

    }

    @Override
    public int getItemCount() {
        return mArrayList.size();
    }

    public class ContactViewHolder extends RecyclerView.ViewHolder {
        TextView name;
        TextView designation;
        ImageView callButton, contactimage;

        public ContactViewHolder(View view) {
            super(view);
            name = view.findViewById(R.id.name);
            designation = view.findViewById(R.id.designation);
            callButton = view.findViewById(R.id.call_button);
            contactimage = view.findViewById(R.id.contact_image);
        }
    }
}
