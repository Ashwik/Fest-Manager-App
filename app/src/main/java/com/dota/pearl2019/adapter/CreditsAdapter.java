package com.dota.pearl2019.adapter;

import android.content.Context;
import android.content.Intent;
import android.net.Uri;
import android.support.v4.content.ContextCompat;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.view.animation.Animation;
import android.view.animation.AnimationUtils;
import android.widget.Button;
import android.widget.LinearLayout;
import android.widget.TextView;

import com.dota.pearl2019.R;
import com.dota.pearl2019.model.DeveloperDetails;
import com.dota.pearl2019.model.DeveloperLayoutDetails;
import com.jaouan.compoundlayout.CircleGradientRadioLayout;

import java.util.ArrayList;

/**
 * Created by Vineeth on 2/14/2018.
 */

public class CreditsAdapter extends RecyclerView.Adapter<CreditsAdapter.CreditsViewHolder> {

    private ArrayList<DeveloperLayoutDetails> data;
    private Context mContext;

    public CreditsAdapter(Context context, ArrayList<DeveloperLayoutDetails> data) {
        this.data = data;
        mContext = context;
    }

    @Override
    public CreditsViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View v = LayoutInflater.from(mContext).inflate(R.layout.fragment_credits_item, parent, false);
        return new CreditsViewHolder(v);
    }

    @Override
    public void onBindViewHolder(final CreditsViewHolder holder, int position) {
        DeveloperLayoutDetails layoutDetails = data.get(position);
        final ArrayList<DeveloperDetails> devDetails = layoutDetails.getDevs();

        if (layoutDetails.getTitle() == null) holder.mTitle.setVisibility(View.GONE);
        holder.mTitle.setText(layoutDetails.getTitle());

        if (devDetails.size() < 3) {
            holder.mProfiles[2].setVisibility(View.GONE);
        } else {
            holder.mProfiles[2].setVisibility(View.VISIBLE);
        }

        for (int i = 0; i < devDetails.size(); i++) {
            final DeveloperDetails dev = devDetails.get(i);
            final String[] devLinks = dev.getLinks();

            //set Image
            final CircleGradientRadioLayout circleLayout = holder.mProfiles[i];
            circleLayout.setBackgroundResource(dev.getProfileImage());

            circleLayout.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View view) {
                    final Animation fadeOutAnimation = AnimationUtils.loadAnimation(mContext, android.R.anim.fade_out);
                    fadeOutAnimation.setAnimationListener(new Animation.AnimationListener() {
                        @Override
                        public void onAnimationStart(Animation animation) {

                        }

                        @Override
                        public void onAnimationEnd(Animation animation) {
                            //set Name
                            holder.mDevName.setText(dev.getName());

                            //set Links
                            for (int j = 0; j < 4; j++) {
                                Button currentButton = holder.mSocialButtons[j];
                                final String currentLink = devLinks[j];
                                if (currentLink != null) {
                                    currentButton.setVisibility(View.VISIBLE);
                                    currentButton.setOnClickListener(new View.OnClickListener() {
                                        @Override
                                        public void onClick(View view) {
                                            Uri uri = Uri.parse(currentLink);
                                            Intent intent = new Intent(Intent.ACTION_VIEW, uri);
                                            mContext.startActivity(intent);
                                        }
                                    });
                                } else {
                                    currentButton.setVisibility(View.GONE);
                                }
                            }
                        }

                        @Override
                        public void onAnimationRepeat(Animation animation) {

                        }
                    });

                    circleLayout.setColorA(ContextCompat.getColor(mContext, R.color.circle3));
                    circleLayout.setColorB(ContextCompat.getColor(mContext, R.color.circle4));
                    circleLayout.setAngle(45);

                    holder.mDescriptionLayout.setVisibility(View.VISIBLE);
                    holder.mDescriptionLayout.startAnimation(fadeOutAnimation);
                }
            });
        }

    }

    @Override
    public int getItemCount() {
        return data != null ? data.size() : 0;
    }

    public class CreditsViewHolder extends RecyclerView.ViewHolder {

        TextView mTitle;
        CircleGradientRadioLayout[] mProfiles = new CircleGradientRadioLayout[3];

        LinearLayout mDescriptionLayout;
        TextView mDevName;

        Button[] mSocialButtons = new Button[4];

        public CreditsViewHolder(View v) {
            super(v);
            mTitle = v.findViewById(R.id.credits_title);

            mProfiles[0] = itemView.findViewById(R.id.profile_1);
            mProfiles[1] = itemView.findViewById(R.id.profile_2);
            mProfiles[2] = itemView.findViewById(R.id.profile_3);

            mDescriptionLayout = itemView.findViewById(R.id.description_layout);
            mDevName = itemView.findViewById(R.id.credits_devname);

            mSocialButtons[0] = itemView.findViewById(R.id.credit_button1);
            mSocialButtons[1] = itemView.findViewById(R.id.credit_button2);
            mSocialButtons[2] = itemView.findViewById(R.id.credit_button3);
            mSocialButtons[3] = itemView.findViewById(R.id.credit_button4);
        }

    }
}
