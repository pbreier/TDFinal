package fr.esilv.s8.tdfinal.adapters;

/**
 * Created by Pierre-Marie on 17/03/2017.
 */

import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import fr.esilv.s8.tdfinal.R;
import fr.esilv.s8.tdfinal.interfaces.OnVideoSelectedListener;
import fr.esilv.s8.tdfinal.models.ResponseGson;
import fr.esilv.s8.tdfinal.viewholders.VideoViewHolder;




public class VideoAdapter extends RecyclerView.Adapter<VideoViewHolder> {
    private ResponseGson responseGson;
    private OnVideoSelectedListener onVideoSelectedListener;


    public VideoAdapter(ResponseGson responseGson) {
        this.responseGson = responseGson;
    }

    @Override
    public VideoViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.viewholder_video, parent, false);
        return new VideoViewHolder(view);
    }

    @Override
    public void onBindViewHolder(VideoViewHolder holder, int position) {
        holder.bind(responseGson.getItems().get(position));
        holder.setOnVideoSelectedListener(onVideoSelectedListener);
        }

    @Override
    public int getItemCount() {
        return responseGson != null ? responseGson.getItems().size() : 0;
    }

    public void setOnVideoSelectedListener(OnVideoSelectedListener onVideoSelectedListener) {
        this.onVideoSelectedListener = onVideoSelectedListener;
    }

}