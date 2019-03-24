package com.dota.pearl2019.adapter;

import android.content.Context;
import android.graphics.Color;
import android.os.Build;
import android.support.annotation.NonNull;
import android.support.v7.widget.RecyclerView;
import android.text.Html;
import android.text.Spanned;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;

import com.dota.pearl2019.R;
import com.yarolegovich.lovelydialog.LovelyInfoDialog;

public class TalksAdapter extends RecyclerView.Adapter<TalksAdapter.TalksViewHolder> {
    private Context context;
    private int root;
    String[] titles = new String[]{

    };
    int[] imagesTalks = new int[]
            {
                    R.drawable.vickykaushal1,
                    R.drawable.catharsistalks,
                    R.drawable.creatorspanel,
                    R.drawable.offbeat,
                    R.drawable.theminimalist,
                    R.drawable.photogdudes,
                    R.drawable.sanjayabaru,

            };
    int[] proShows = new int[]
            {
                    R.drawable.vishalshekhar,
                    R.drawable.pineappleexpress,
                    R.drawable.loststories,
                    R.drawable.mashdnkutcher,
                    R.drawable.sabysingh,
                    R.drawable.samarmehdi,
                    R.drawable.sitarmetal,
                    R.drawable.standupcomedy,
                    R.drawable.whenchaimettoast
            };
    String[] descriptions = new String[]{
            "<b>Date:</b> 22/03/19<br/>Venue:</b> Auditorium<br/>Time:</b>12:00PM",
            "<b>Date:</b> 23/03/19<br/>Venue:</b><br/>Time:</b>4:30PM",
            "<b>Date:</b> 24/03/19<br/>Venue:</b> F102<br/>Time:</b>12:00PM",
            "<b>Date:</b> 23/03/19<br/>Venue:</b> F105<br/>Time:</b>3:00PM",
            "<b>Date:</b> 22/03/19<br/>Venue:</b> F101<br/>Time:</b>4:00PM",
            "<b>Date:</b> 22/03/19<br/>Venue:</b> F102<br/>Time:</b>3:00PM",
            "<b>Date:</b> 24/03/19<br/>Venue:</b> F102<br/>Time:</b>3:00PM",

    };
    String[] descriptions_2 = new String[]{
            "<b>Date:</b> 24/03/19<br/>Venue:</b> Stage 1<br/>",
            "<b>Date:</b> 23/03/19<br/>Venue:</b> Stage 1<br/>",
            "<b>Date:</b> 22/03/19<br/>Venue:</b> Stage 1<br/>",
            "<b>Date:</b> 22/03/19<br/>Venue:</b> Stage 1<br/>",
            "<b>Date:</b> <br/>Venue:</b> Stage 1<br/>",
            "<b>Date:</b> 22/03/19<br/>Venue:</b> Stage 1<br/>",
            "<b>Date:</b> 24/03/19<br/>Venue:</b> Stage 1<br/>",
            "<b>Date:</b> 22/03/19<br/>Venue:</b> Auditorium<br/>",
            "<b>Date:</b> 23/03/19<br/>Venue:</b> Stage 1<br/>",
    };

    public TalksAdapter(Context context, int root) {
        this.context = context;
        this.root = root;
    }

    @NonNull
    @Override
    public TalksViewHolder onCreateViewHolder(@NonNull ViewGroup viewGroup, int i) {
        View v = LayoutInflater.from(context).inflate(R.layout.card_talks, viewGroup, false);
        return new TalksViewHolder(v);
    }

    @Override
    public void onBindViewHolder(@NonNull TalksViewHolder holder, final int i) {
        if (root == 0) {
            holder.talksImages.setImageResource(imagesTalks[i]);
        } else {
            holder.talksImages.setImageResource(proShows[i]);
        }
        holder.itemView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                openDialog(i);
            }
        });
    }

    private void openDialog(int position) {
        if (root == 0) {
            new LovelyInfoDialog(context)
                    .setTopColorRes(R.color.colorPrimary)
                    .setTopTitleColor(Color.WHITE)
                    .setMessage(formatContent(descriptions[position]))
                    .show();
        } else {
            new LovelyInfoDialog(context)
                    .setTopColorRes(R.color.colorPrimary)
                    .setTopTitleColor(Color.WHITE)
                    .setMessage(formatContent(descriptions_2[position]))
                    .show();
        }
    }

    @Override
    public int getItemCount() {
        if (root == 0) {
            return 7;
        } else {
            return 9;
        }
    }

    public class TalksViewHolder extends RecyclerView.ViewHolder {
        ImageView talksImages;

        public TalksViewHolder(@NonNull View itemView) {
            super(itemView);
            talksImages = itemView.findViewById(R.id.talksImage);
        }
    }

    public Spanned formatContent(String content) {
        if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.N) {
            return Html.fromHtml(content, Html.FROM_HTML_MODE_COMPACT);
        } else {
            //noinspection deprecation
            return Html.fromHtml(content);
        }
    }
}
