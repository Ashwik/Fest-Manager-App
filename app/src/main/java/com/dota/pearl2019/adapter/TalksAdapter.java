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
    private  Context context;
    String[] titles = new String[]{
            "Aron Chupa",
            "Tony Junior",
            "Amit Trivedi",
            "Ashish Shakya",
            "Raghu Dixit"
    };
    int[] imagesTalks = new int[]
            {
                    R.drawable.catharsistalks,
                    R.drawable.creatorspanel,
                    R.drawable.offbeat,
                    R.drawable.theminimalist,
                    R.drawable.photogdudes,
                    R.drawable.sanjayabaru,
                    R.drawable.vickykaushal1
            };
    String[] descriptions = new String[]{
            "<b>Date:</b> 23/03/18<br/><b>Desc:</b> Heading the new breed of hitmakers, Aronchupa - Swedish rapper,singer, DJ and record producer.<br/><b>Venue:</b> Stage 1 Lawns",
            "<b>Date:</b> 23/03/18<br/><b>Desc:</b> Tony Junior, a Dutch record producer and DJ.<br/><b>Venue:</b> Stage 1 Lawns",
            "<b>Date:</b> 24/03/18<br/><b>Desc:</b> Amit Trivedi is an Indian film composer, musician, singer and lyricist. Don't miss the Bollywood night of Pearl'18. <br/><b>Venue:</b> Stage 1 Lawns",
            "<b>Date:</b> 24/03/18<br/><b>Desc:</b> Ashish Shakya from AIB is a stand-up comedian, humour columnist, writer, actor and TV writer.<br/><b>Venue:</b> Auditorium",
            "<b>Date:</b> 25/03/18<br/><b>Desc:</b> Raghu Dixit, giving Indian fusion music a new face and voice on a global scale.<br/><b>Venue:</b> Stage 1 Lawns"
    };
    public TalksAdapter(Context context)
    {
        this.context = context;
    }
    @NonNull
    @Override
    public TalksViewHolder onCreateViewHolder(@NonNull ViewGroup viewGroup, int i) {
        View v = LayoutInflater.from(context).inflate(R.layout.card_talks, viewGroup, false);
        return new TalksViewHolder(v);
    }

    @Override
    public void onBindViewHolder(@NonNull TalksViewHolder holder, final int i) {
        holder.talksImages.setImageResource(imagesTalks[i]);
        holder.itemView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                openDialog(i);
            }
        });
    }
    private void openDialog(int position)
    {
        new LovelyInfoDialog(context)
                .setTopColorRes(R.color.colorPrimary)
                .setTopTitleColor(Color.WHITE)
                .setTopTitle(titles[position])
                .setMessage(formatContent(descriptions[position]))
                .show();
    }
    @Override
    public int getItemCount() {
        return 7;
    }

    public class TalksViewHolder extends RecyclerView.ViewHolder {
        ImageView talksImages;
        public TalksViewHolder(@NonNull View itemView) {
            super(itemView);
            talksImages = itemView.findViewById(R.id.talksImage);
        }
    }
    private Spanned formatContent(String content) {
        if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.N) {
            return Html.fromHtml(content, Html.FROM_HTML_MODE_COMPACT);
        } else {
            //noinspection deprecation
            return Html.fromHtml(content);
        }
    }
}
