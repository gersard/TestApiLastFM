package com.example.gerardo.testapilastfm.ui.fragment;


import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.example.gerardo.testapilastfm.R;
import com.example.gerardo.testapilastfm.rest.ApiConstants;
import com.example.gerardo.testapilastfm.rest.LastFmApiAdapter;
import com.example.gerardo.testapilastfm.rest.model.TopTrackResponse;
import com.example.gerardo.testapilastfm.ui.adapter.TopAlbumAdapter;
import com.example.gerardo.testapilastfm.ui.adapter.TopTrackAdapter;

import retrofit.Callback;
import retrofit.RetrofitError;
import retrofit.client.Response;

/**
 * A simple {@link Fragment} subclass.
 */
public class TopTrackFragment extends Fragment implements Callback<TopTrackResponse> {

    private RecyclerView trackList;
    private TopTrackAdapter topTrackAdapter;
    private String recoveryNombre;

    public TopTrackFragment() {
        // Required empty public constructor
    }

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        topTrackAdapter = new TopTrackAdapter(getActivity());
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        View root = inflater.inflate(R.layout.fragment_top_track,container,false);

        recoveryNombre = this.getArguments().getString("artista");

        trackList = (RecyclerView) root.findViewById(R.id.top_track_list);
        setupList();
        return root;
    }

    @Override
    public void onResume() {
        super.onResume();
        LastFmApiAdapter.getApiServiceSerializado().getTopTracks(ApiConstants.API_KEY,recoveryNombre,this);
    }

    public void setupList(){
        trackList.setLayoutManager(new LinearLayoutManager(getActivity()));
        //le seteamos el adaptador
        trackList.setAdapter(topTrackAdapter);
    }


    @Override
    public void success(TopTrackResponse topTrackResponse, Response response) {
        topTrackAdapter.addAll(topTrackResponse.getTracks());
    }

    @Override
    public void failure(RetrofitError error) {

    }
}
