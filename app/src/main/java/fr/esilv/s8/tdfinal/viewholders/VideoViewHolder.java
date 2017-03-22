package fr.esilv.s8.tdfinal.viewholders;

import android.content.Context;
import android.support.v7.widget.RecyclerView;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;

import com.squareup.picasso.Picasso;

import fr.esilv.s8.tdfinal.R;
import fr.esilv.s8.tdfinal.interfaces.OnVideoSelectedListener;
import fr.esilv.s8.tdfinal.models.Item;

/**
 * Created by Pierre-Marie on 16/03/2017.
 */

public class VideoViewHolder extends RecyclerView.ViewHolder {


        //private TextView id;
        private TextView title;
        private ImageView thumbnail;
        private TextView description;
        private TextView author;
        private Context context;
        private OnVideoSelectedListener onVideoSelectedListener;
        private TextView publication_date;


        public VideoViewHolder(View itemView) {
            super(itemView);
            context = itemView.getContext();
            title = (TextView) itemView.findViewById(R.id.title);
            description = (TextView) itemView.findViewById(R.id.description);
            author = (TextView) itemView.findViewById(R.id.author);
            thumbnail = (ImageView) itemView.findViewById(R.id.ithumbnail);
            publication_date = (TextView) itemView.findViewById(R.id.publication_date);

        }

    public void bind(final Item video) {
        //id.setText(contract.getId());
        title.setText(video.getSnippet().getTitle());
        Picasso.with(context)
                .load(video.getSnippet().getThumbnails().getHigh().getUrl())
                .resize(video.getSnippet().getThumbnails().getHigh().getWidth(), video.getSnippet().getThumbnails().getHigh().getHeight())
                .into(thumbnail);
        description.setText(video.getSnippet().getDescription());
        author.setText(video.getSnippet().getChannelTitle());
        publication_date.setText(video.getSnippet().getPublishedAt());
        itemView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (onVideoSelectedListener == null) {
                    return;
                }
                onVideoSelectedListener.onVideoSelected(video);
            }
        });
    }

    public void setOnVideoSelectedListener(OnVideoSelectedListener onVideoSelectedListener) {
        this.onVideoSelectedListener = onVideoSelectedListener;
    }
}
