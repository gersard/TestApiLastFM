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
import com.example.gerardo.testapilastfm.rest.LastFmApiAdapter;
import com.example.gerardo.testapilastfm.rest.model.TopArtistResponse;
import com.example.gerardo.testapilastfm.ui.adapter.TopArtistAdapter;

import rx.android.schedulers.AndroidSchedulers;
import rx.functions.Action1;

/**
 * A simple {@link Fragment} subclass.
 */
public class TopArtistFragment extends Fragment {

    private RecyclerView artistList;
    private TopArtistAdapter topArtistAdapter;

    public TopArtistFragment() {
        // Required empty public constructor
    }

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        //Se puede inicializar en el onCreateView de igual manera
        topArtistAdapter = new TopArtistAdapter(getActivity());
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View root = inflater.inflate(R.layout.fragment_top_artist,container,false);
        artistList = (RecyclerView) root.findViewById(R.id.top_artist_list);
        setupList();
        return root;
    }
    Throwable error;
    @Override
    public void onResume() {
        super.onResume();
            LastFmApiAdapter.getApiService().getTopArtists().observeOn(AndroidSchedulers.mainThread())
                    .subscribe(new Action1<TopArtistResponse>() {
                        @Override
                        public void call(TopArtistResponse topArtistResponse) {
                            topArtistAdapter.addAll(topArtistResponse.getArtists());
                        }
                    });
    }

    public void setupList(){
        artistList.setLayoutManager(new LinearLayoutManager(getActivity()));
        artistList.setAdapter(topArtistAdapter);
    }

}
