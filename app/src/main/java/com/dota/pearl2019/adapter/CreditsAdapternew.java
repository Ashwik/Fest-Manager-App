package com.dota.pearl2019.adapter;

import android.content.Context;
import android.content.Intent;
import android.net.Uri;
import android.support.v7.widget.CardView;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import com.dota.pearl2019.R;
import com.dota.pearl2019.model.DeveloperDetails;

import java.util.ArrayList;

/**
 * Created by Vineeth on 2/13/2018.
 */

public class CreditsAdapternew extends RecyclerView.Adapter<CreditsAdapternew.ContactViewHolder> {

    LayoutInflater mInflater;
    ArrayList<DeveloperDetails> mArrayList;
    Context context;

    public CreditsAdapternew(Context context) {
        mInflater = LayoutInflater.from(context);
        mArrayList = new ArrayList<>();
        this.context = context;
    }

    public void setArrayList(ArrayList<DeveloperDetails> arrayList) {
        mArrayList = arrayList;
    }

    @Override
    public ContactViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View v = mInflater.inflate(R.layout.fragment_credit_item_c, parent, false);
        return new ContactViewHolder(v);
    }

    @Override
    public void onBindViewHolder(final ContactViewHolder holder, final int position) {
        holder.name.setText(mArrayList.get(position).getName());
        holder.contactimage.setImageResource(mArrayList.get(position).getProfileImage());
//        holder.callButton.setVisibility(View.VISIBLE);
//        holder.callButton.setOnClickListener(new View.OnClickListener() {
//            @Override
//            public void onClick(View view) {
//                String mobile = mArrayList.get(holder.getAdapterPosition()).getMobile();
//                if (mobile != null) {
//                    Uri number = Uri.parse("tel:" + mArrayList.get(holder.getAdapterPosition()).getMobile());
//                    holder.itemView.getContext().startActivity(new Intent(Intent.ACTION_DIAL, number));
//                }
//            }
//        });
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
        holder.contactimage.setVisibility(View.VISIBLE);
        holder.credits_card.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Uri uri = Uri.parse(mArrayList.get(position).getLinks()[0]);
                Intent intent = new Intent(Intent.ACTION_VIEW, uri);
                view.getContext().startActivity(intent);
            }
        });


    }

    @Override
    public int getItemCount() {
        return mArrayList.size();
    }

    public class ContactViewHolder extends RecyclerView.ViewHolder {
        TextView name;
        CardView credits_card;
        TextView designation;
        ImageView callButton, contactimage;

        public ContactViewHolder(View view) {
            super(view);
            name = view.findViewById(R.id.name);
            credits_card = view.findViewById(R.id.credits_card);
            contactimage = view.findViewById(R.id.contact_image);
        }
    }
}
