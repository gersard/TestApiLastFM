package com.example.gerardo.testapilastfm.ui.fragment;



import android.content.Intent;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.support.v7.widget.GridLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.example.gerardo.testapilastfm.ui.AlbumActivity;
import com.example.gerardo.testapilastfm.R;
import com.example.gerardo.testapilastfm.rest.LastFmApiAdapter;
import com.example.gerardo.testapilastfm.rest.model.HypedArtistsResponse;
import com.example.gerardo.testapilastfm.ui.ItemOffsetDecoration;
import com.example.gerardo.testapilastfm.ui.adapter.HypedArtistsAdapter;

import retrofit.Callback;
import retrofit.RetrofitError;
import retrofit.client.Response;

/**
 * Created by Gerardo on 01-02-2016.
 */
public class HypedArtistFragment extends Fragment implements Callback<HypedArtistsResponse> {

    public static final int NUM_COL = 2;
    //Recuperamos el RecyclerView
    private RecyclerView mHypedArtistsList;


    private HypedArtistsAdapter adapter;

    @Override
    public void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        adapter = new HypedArtistsAdapter(getActivity());
    }

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        //Inflar la vista del fragmento. Pasamos el fragmento a inflar y luego A DONDE lo inflaremos
        View root = inflater.inflate(R.layout.fragment_hyped_artist,container,false);

        //Buscamos y asignamos el RecyclerView
        mHypedArtistsList = (RecyclerView) root.findViewById(R.id.hyped_artists_list);
        setupArtistsList();

        adapter.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Log.i("DemoRecView", "Pulsado el elemento ");
                Intent intent = new Intent(getActivity(), AlbumActivity.class);
                intent.putExtra("Posicion", mHypedArtistsList.getChildAdapterPosition(v));
                intent.putExtra("Nombre",adapter.getNameArtist(mHypedArtistsList.getChildAdapterPosition(v)));
                //

                startActivity(intent);

            }
        });

        return root;
    }

    @Override
    public void onResume() {
        super.onResume();
        //Se realiza la peticion
        LastFmApiAdapter.getApiService().getHypedArtists(this);
    }

    //Crear el metodo para realizar configuraciones iniciales al Recyclerview
    private void setupArtistsList(){
        //Definimos cual sera el comportamiento. El getActivity nos devolvera la actividad a la cual esta relacionada
        mHypedArtistsList.setLayoutManager(new GridLayoutManager(getActivity(),NUM_COL));

        mHypedArtistsList.setAdapter(adapter);


        mHypedArtistsList.addItemDecoration(new ItemOffsetDecoration(getActivity(),R.integer.offset));


    }

    @Override
    public void success(HypedArtistsResponse hypedArtistsResponse, Response response) {
        adapter.addAll(hypedArtistsResponse.getArtists());
    }

    @Override
    public void failure(RetrofitError error) {

    }
}
