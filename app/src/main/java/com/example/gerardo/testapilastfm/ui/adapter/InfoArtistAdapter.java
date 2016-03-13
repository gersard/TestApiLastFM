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

/**
 * Created by Gerardo on 06-02-2016.
 */
public class InfoArtistAdapter extends RecyclerView.Adapter<InfoArtistAdapter.InfoArtistViewHolder> {

    Artist artist;
    String URLImagen,lis,play,tag,biografia;
    Context context;

    public InfoArtistAdapter(Context context){
        artist = new Artist();
        this.context = context;
    }


    @Override
    public InfoArtistViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View itemView = LayoutInflater.from(context).inflate(R.layout.item_info_artist,parent,false);
        return new InfoArtistViewHolder(itemView);
    }

    @Override
    public void onBindViewHolder(InfoArtistViewHolder holder, int position) {


        holder.setNameArtist(artist.getName());
        if (URLImagen != null){
            holder.setImageArtist(URLImagen);
        }else{
            holder.setDefaultImageArtist();
        }
        holder.setListenerArtist(lis);
        holder.setPlayCountArtist(play);
        holder.setTagArtist(tag);
        holder.setInfoArtist(biografia);
        /*holder.setPlayCountArtist(currentInfo.getPlaycountArtist());
        holder.setListenerArtist(currentInfo.getListenerArtist());
//        holder.setTagArtist(currentInfo.getTagArtist().toString());
//        holder.setInfoArtist(currentInfo.getInfoArtist().get(1).getContent());
        if (currentInfo.getUrlImage() != null){
            holder.setImageArtist(currentInfo.getUrlImage().toString());
        }else{
            holder.setDefaultImageArtist();
        }*/
    }

    @Override
    public int getItemCount() {
        return 1;
    }

    public void addAll(Artist artista){
        if (artista == null){
            throw new NullPointerException("No puede ser un arreglo nulo");
        }
        artist.setName(artista.getName());
        URLImagen = artista.obtenerImagen();
        lis = artista.obtenerListener();
        play = artista.obtenerPlaycount();
        tag = artista.obtenerTag();
        biografia = artista.obtenerInfo();
        notifyDataSetChanged();

        //notifyItemInserted();
    }


    public class InfoArtistViewHolder extends RecyclerView.ViewHolder{

        TextView nameArtist,playCountArtist,listenerArtist,tagArtist,infoArtist;
        ImageView imageArtist;


        public InfoArtistViewHolder(View itemView) {
            super(itemView);

            nameArtist = (TextView) itemView.findViewById(R.id.txt_nombre_artista);
            playCountArtist = (TextView) itemView.findViewById(R.id.txt_playcount_artista);
            listenerArtist = (TextView) itemView.findViewById(R.id.txt_listeners_artista);
            tagArtist = (TextView) itemView.findViewById(R.id.txt_tag_artista);
            infoArtist = (TextView) itemView.findViewById(R.id.txt_artist_info);
            imageArtist = (ImageView) itemView.findViewById(R.id.img_artist_info);
        }

        public void setNameArtist(String nameArtist) {
            this.nameArtist.setText(nameArtist);
        }

        public void setPlayCountArtist(String playCountArtist) {
            this.playCountArtist.setText(playCountArtist);
        }

        public void setListenerArtist(String listenerArtist) {
            this.listenerArtist.setText(listenerArtist);
        }

        public void setTagArtist(String tagArtist) {
            this.tagArtist.setText(tagArtist);
        }

        public void setInfoArtist(String infoArtist) {
            this.infoArtist.setText(infoArtist);
        }

        public void setImageArtist(String imageArtist) {
            Picasso.with(context).load(imageArtist).placeholder(R.drawable.artist_placeholder)
                    .into(this.imageArtist);
        }

        public void setDefaultImageArtist(){
            Picasso.with(context).load(R.drawable.artist_placeholder).into(this.imageArtist);
        }
    }

    //Llave final
}
