package com.example.gerardo.testapilastfm.ui.adapter;

import android.content.Context;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import com.example.gerardo.testapilastfm.R;
import com.example.gerardo.testapilastfm.domain.Album;
import com.squareup.picasso.Picasso;

import java.util.ArrayList;

/**
 * Created by Gerardo on 03-02-2016.
 */
public class TopAlbumAdapter extends RecyclerView.Adapter<TopAlbumAdapter.TopAlbumViewHolder> {

    ArrayList<Album> albums;
    //Necesitamos pasar el contexto de la Actividad a traves del constructor
    Context context;

    //Constructor
    public TopAlbumAdapter(Context context){
        this.context = context;
        this.albums = new ArrayList<>();
    }

    //Se infla la vista en primer lugar
    @Override
    public TopAlbumViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        //inflar la vista
        View itemView = LayoutInflater.from(context).inflate(R.layout.item_top_album,parent,false);

        return new TopAlbumViewHolder(itemView);
    }

    @Override
    public void onBindViewHolder(TopAlbumAdapter.TopAlbumViewHolder holder, int position) {
        //Vamos a conectar el viewHolder con los datos
        //Necesitamos saber la posicion del album actual
        Album currentAlbum = albums.get(position);
        //Pones el nombre dle album de la posicion especifica
        holder.setNameAlbum(currentAlbum.getNameAlbum());
        holder.setPlaycountAlbum(currentAlbum.getPlayCountAlbum());
        if(currentAlbum.getUrlImage() != null){
            holder.setImageAlbum(currentAlbum.getUrlImage());
        }else{
            holder.setImageAlbumDefault();
        }
    }



    @Override
    public int getItemCount() {
        return albums.size();
    }

    public void addAll(ArrayList<Album> albums){
        if (albums == null){
            throw new NullPointerException("No puede ser un arreglo nulo");
        }
        this.albums.addAll(albums);
        notifyItemRangeInserted(getItemCount()-1,albums.size());
    }

    public class TopAlbumViewHolder extends RecyclerView.ViewHolder{
        //Se inicializan los elementos que se ocuparan del Viewholder (item_top_album)
        TextView nameAlbum;
        TextView playcountAlbum;
        ImageView albumImage;

        //el itemView sera la vista a inflar - Constructor
        public TopAlbumViewHolder(View itemView){
            super(itemView);

            //Se inicializan los elementos
            nameAlbum = (TextView) itemView.findViewById(R.id.txt_name_album);
            playcountAlbum = (TextView) itemView.findViewById(R.id.txt_album_playcount);
            albumImage = (ImageView) itemView.findViewById(R.id.img_album);
        }


        //Setters para insertar los datos

        public void setNameAlbum(String name) {
            //El EditText del fragmento, sera igual al parametro que le pasemos a este metodo
            nameAlbum.setText(name);
        }

        public void setPlaycountAlbum(String playcount) {
            playcountAlbum.setText(playcount);
        }

        public void setImageAlbum(String url){
            Picasso.with(context).load(url).placeholder(R.drawable.artist_placeholder)
                    .into(albumImage);
        }
        public void setImageAlbumDefault(){
            Picasso.with(context).load(R.drawable.artist_placeholder).into(albumImage);
        }
    }
}
