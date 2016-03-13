package com.example.gerardo.testapilastfm.ui.adapter;

import android.content.Context;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import com.example.gerardo.testapilastfm.R;
import com.example.gerardo.testapilastfm.domain.Track;

import java.util.ArrayList;

/**
 * Created by Gerardo on 05-02-2016.
 */
public class TopTrackAdapter extends RecyclerView.Adapter<TopTrackAdapter.TopTrackViewHolder> {

    ArrayList<Track> tracks;
    Context context;

    public TopTrackAdapter(Context context){
        this.context = context;
        this.tracks = new ArrayList<>();
    }

    @Override
    public TopTrackViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View itemView = LayoutInflater.from(context).inflate(R.layout.item_top_track,parent,false);

        return new TopTrackViewHolder(itemView);
    }

    @Override
    public void onBindViewHolder(TopTrackViewHolder holder, int position) {
        Track currentTrack = tracks.get(position);

        holder.setNameTrack(currentTrack.getNameTrack());
        holder.setPlaycountTrack(currentTrack.getPlaycountTrack());
        holder.setListenerTrack(currentTrack.getListenerTrack());
    }

    @Override
    public int getItemCount() {
        return tracks.size();
    }

    public void addAll(ArrayList<Track> tracks){
        if (tracks == null){
            throw new NullPointerException("No puede ser un arreglo nulo");
        }
        this.tracks.addAll(tracks);
        notifyItemRangeInserted(getItemCount()-1,tracks.size());
    }


    public class TopTrackViewHolder extends RecyclerView.ViewHolder{

        TextView nameTrack,playcountTrack,listenerTrack;

        public TopTrackViewHolder(View itemView){
            super(itemView);

            //Inicializacion de los elementos
            nameTrack = (TextView) itemView.findViewById(R.id.txt_nombre_track);
            playcountTrack = (TextView) itemView.findViewById(R.id.txt_playcount_track);
            listenerTrack = (TextView) itemView.findViewById(R.id.txt_listeners_track);
        }

        public void setNameTrack(String name_Track) {
            nameTrack.setText(name_Track);
        }

        public void setPlaycountTrack(String playcount_Track) {
            playcountTrack.setText(playcount_Track);
        }

        public void setListenerTrack(String listener_Track) {
            listenerTrack.setText(listener_Track);
        }
    }

//Llave final
}
