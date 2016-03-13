package com.example.gerardo.testapilastfm.ui.adapter;

import android.content.Context;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import com.example.gerardo.testapilastfm.R;
import com.example.gerardo.testapilastfm.domain.Artist;
import com.squareup.picasso.Picasso;

import java.util.ArrayList;

/**
 * Created by Gerardo on 03-02-2016.
 */
public class TopArtistAdapter extends RecyclerView.Adapter<TopArtistAdapter.TopArtistHolder> {

    ArrayList<Artist> artists;

    //Necesitamos pasar el contexto de la Actividad a traves del constructor
    Context context;
    public TopArtistAdapter(Context context) {
        this.context = context;
        this.artists = new ArrayList<>();
    }

    //Lo primero que se hace es inflar la vista
    @Override
    public TopArtistHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        //Inflamos la vista.
        View itemView = LayoutInflater.from(context).inflate(R.layout.item_top_artist,parent,false);


        return new TopArtistHolder(itemView);
    }

    @Override
    public void onBindViewHolder(TopArtistHolder holder, int position) {
        //Vamos a conectar el viewHolder con los datos
        //Necesitamos saber la posicion del artista
        Artist currentArtist = artists.get(position);
        //Pones el nombre dle artista de la posicion especifica
        holder.setArtistName(currentArtist.getName());
        holder.setArtistPlaycount(currentArtist.getPlayCount());
        holder.setArtistListeners(currentArtist.getListeners());

        if (currentArtist.getUrlMediumImage() != null){
            holder.setArtistsImage(currentArtist.getUrlMediumImage());
        }else{
            holder.setArtistImageDefault();
        }

    }

    @Override
    public int getItemCount() {
        return artists.size();
    }

    public void addAll(ArrayList<Artist> artists){
        if (artists == null){
            throw new NullPointerException("No puede ser un arreglo nulo");
        }
        this.artists.addAll(artists);
        notifyItemRangeInserted(getItemCount()-1, artists.size());
    }


    public class TopArtistHolder extends RecyclerView.ViewHolder{
        //Se inicializan los elementos que se ocuparan del Viewholder (item_hyped_artists)
        TextView artistName;
        TextView artistPlaycount;
        TextView artistListeners;
        ImageView artistImage;

        //el itemView sera la vista a inflar
        public TopArtistHolder(View itemView) {
            super(itemView);

            //Se inicilizan los componentes
            artistName = (TextView) itemView.findViewById(R.id.txt_name);
            artistImage = (ImageView) itemView.findViewById(R.id.img_artist);
            artistPlaycount = (TextView) itemView.findViewById(R.id.txt_playcount);
            artistListeners = (TextView) itemView.findViewById(R.id.txt_listeners);
        }

        public void setArtistName(String name){
            artistName.setText(name);
        }


        public void setArtistPlaycount(String playcount){
            //El EditText del fragmento, sera igual al parametro que le pasemos al metodo setArtistPlaycount
            artistPlaycount.setText(playcount);
        }
        public void setArtistListeners(String listeners){
            //El EditText del fragmento, sera igual al parametro que le pasemos al metodo setArtistListeners
            artistListeners.setText(listeners);
        }


        public void setArtistsImage(String url){
            Picasso.with(context).load(url).placeholder(R.drawable.artist_placeholder)
                    .into(artistImage);
        }
        public void setArtistImageDefault(){
            Picasso.with(context).load(R.drawable.artist_placeholder).into(artistImage);
        }

    }
}