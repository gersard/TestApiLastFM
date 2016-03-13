package com.example.gerardo.testapilastfm.ui.fragment;


import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.example.gerardo.testapilastfm.R;
import com.example.gerardo.testapilastfm.rest.ApiConstants;
import com.example.gerardo.testapilastfm.rest.LastFmApiAdapter;
import com.example.gerardo.testapilastfm.rest.model.TopAlbumResponse;
import com.example.gerardo.testapilastfm.ui.adapter.TopAlbumAdapter;

import retrofit.Callback;
import retrofit.RetrofitError;
import retrofit.client.Response;

/**
 * A simple {@link Fragment} subclass.
 */
public class TopAlbumFragment extends Fragment implements Callback<TopAlbumResponse> {

    //Definimos la cantidad de columnas del grid
    public static final int NUM_COL = 2;

    //Crear variable para obtener el RecyclerView
    private RecyclerView albumList;
    private TopAlbumAdapter topAlbumAdapter;

    private String recoveryNombre;

    public TopAlbumFragment() {
        // Required empty public constructor
    }

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        topAlbumAdapter = new TopAlbumAdapter(getActivity());
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View root = inflater.inflate(R.layout.fragment_top_album,container,false);

        //recupero el nombre del artista
        recoveryNombre = this.getArguments().getString("artista");
        Log.i("vernombre",recoveryNombre);

        //Se incrusta el fragmento al RecyclerView
        albumList = (RecyclerView) root.findViewById(R.id.top_album_list);
        setupList();
        return root;
    }


    @Override
    public void onResume() {
        super.onResume();
        LastFmApiAdapter.getApiService().getAlbumInfo(ApiConstants.API_KEY,recoveryNombre,this);
    }

    //Crear el metodo para realizar configuraciones iniciales al Recyclerview
    public void setupList(){
        //Definimos cual sera el comportamiento. El getActivity nos devolvera la actividad a la cual esta relacionada
        albumList.setLayoutManager(new LinearLayoutManager(getActivity()));
        //le seteamos el adaptador
        albumList.setAdapter(topAlbumAdapter);
    }

    @Override
    public void success(TopAlbumResponse topAlbumResponse, Response response) {
        topAlbumAdapter.addAll(topAlbumResponse.getAlbums());
    }

    @Override
    public void failure(RetrofitError error) {

    }
}
