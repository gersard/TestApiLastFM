package com.example.gerardo.testapilastfm.ui.fragment;


import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.example.gerardo.testapilastfm.R;
import com.example.gerardo.testapilastfm.domain.Artist;
import com.example.gerardo.testapilastfm.rest.ApiConstants;
import com.example.gerardo.testapilastfm.rest.LastFmApiAdapter;
import com.example.gerardo.testapilastfm.ui.adapter.InfoArtistAdapter;

import retrofit.Callback;
import retrofit.RetrofitError;
import retrofit.client.Response;

/**
 * A simple {@link Fragment} subclass.
 */
public class InfoArtistFragment extends Fragment{

    private RecyclerView infoList;
    private InfoArtistAdapter adapter;
    private String recoveryNombre;

    public InfoArtistFragment() {
        // Required empty public constructor
    }

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        adapter = new InfoArtistAdapter(getActivity());
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        View root = inflater.inflate(R.layout.fragment_info_artist,container,false);

        recoveryNombre = this.getArguments().getString("artista");

        infoList = (RecyclerView) root.findViewById(R.id.info_artist_list);
        setupList();
        return root;
    }

    @Override
    public void onResume() {
        super.onResume();
        LastFmApiAdapter.getApiServiceSerializado2().getInfoArtist(ApiConstants.API_KEY, recoveryNombre, "es", new Callback<Artist>() {
            @Override
            public void success(Artist artist, Response response) {
                adapter.addAll(artist.getArtist());
            }

            @Override
            public void failure(RetrofitError error) {

            }
        });
    }
    public void setupList(){
        infoList.setLayoutManager(new LinearLayoutManager(getActivity()));
        //le seteamos el adaptador
        infoList.setAdapter(adapter);
    }


}
