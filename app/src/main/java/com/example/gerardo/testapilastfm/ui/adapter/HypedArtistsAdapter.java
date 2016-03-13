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
import com.example.gerardo.testapilastfm.rest.LastFmApiAdapter;
import com.example.gerardo.testapilastfm.rest.LastFmApiService;
import com.example.gerardo.testapilastfm.rest.model.TopAlbumResponse;
import com.squareup.picasso.Picasso;

import java.util.ArrayList;

import rx.Observable;

/**
 * Created by Gerardo on 02-02-2016.
 */
//Debemos colocar la clase Viewholder e insertarla en el Adapter
public class HypedArtistsAdapter extends RecyclerView.Adapter<HypedArtistsAdapter.HypedArtistViewHolder>
        implements View.OnClickListener {

    ArrayList<Artist> artists;

    //listener para el evento onclick
    private View.OnClickListener listener;

    //Necesitamos pasar el contexto de la Actividad a traves del constructor
    Context context;
    public HypedArtistsAdapter(Context context) {
        this.context = context;
        this.artists = new ArrayList<>();
    }

    //Lo primero que se hace es inflar la vista
    @Override
    public HypedArtistViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        //Inflamos la vista.
        View itemView = LayoutInflater.from(context).inflate(R.layout.item_hyped_artists,parent,false);

        //evento onclick
        itemView.setOnClickListener(this);

        return new HypedArtistViewHolder(itemView);
    }

    @Override
    public void onBindViewHolder(HypedArtistViewHolder holder, int position) {
        //Vamos a conectar el viewHolder con los datos
        //Necesitamos saber la posicion del artista
        Artist currentArtist = artists.get(position);
        //Pones el nombre dle artista de la posicion especifica
        holder.setArtistName(currentArtist.getName());
        if (currentArtist.getUrlMediumImage() != null){
            holder.setArtistsImage(currentArtist.getUrlMediumImage());
        }else{
            holder.setArtistImageDefault();
        }

    }



    //Metodos del OnClickListener
    public void setOnClickListener(View.OnClickListener listener){
        this.listener = listener;
    }
    @Override
    public void onClick(View view){
        if(listener != null){
            listener.onClick(view);
        }
    }

    public String getNameArtist(int posicion){
        Artist currentArtist = artists.get(posicion);
        return currentArtist.getName();
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


    public class HypedArtistViewHolder extends RecyclerView.ViewHolder{
        //Se inicializan los elementos que se ocuparan del Viewholder (item_hyped_artists)
        TextView artistName;
        ImageView artistImage;

        //el itemView sera la vista a inflar
        public HypedArtistViewHolder(View itemView) {
            super(itemView);

            //Se inicilizan los componentes
            artistName = (TextView) itemView.findViewById(R.id.txt_name);
            artistImage = (ImageView) itemView.findViewById(R.id.img_artist);
        }

        public void setArtistName(String name){
            artistName.setText(name);
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
