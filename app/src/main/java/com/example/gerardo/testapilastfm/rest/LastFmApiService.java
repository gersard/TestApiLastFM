package com.example.gerardo.testapilastfm.rest;

import com.example.gerardo.testapilastfm.domain.Artist;
import com.example.gerardo.testapilastfm.rest.model.HypedArtistsResponse;
import com.example.gerardo.testapilastfm.rest.model.TopAlbumResponse;
import com.example.gerardo.testapilastfm.rest.model.TopArtistResponse;
import com.example.gerardo.testapilastfm.rest.model.TopTrackResponse;


import retrofit.http.GET;
import retrofit.http.Query;


/**
 * Created by Gerardo on 02-02-2016.
 */
public interface LastFmApiService {

    //Llamada a travse de Retrofit
    @GET(ApiConstants.URL_HYPED_ARTIST)
    void getHypedArtists (retrofit.Callback<HypedArtistsResponse> serverResponse);

    @GET(ApiConstants.URL_TOP_ALBUM)
    void getAlbumInfo(@Query(ApiConstants.PARAM_API_KEY) String key,@Query(ApiConstants.PARAM_ARTIST) String name,
                      retrofit.Callback<TopAlbumResponse> serverResponse);

    @GET(ApiConstants.URL_TOP_TRACK)
    void getTopTracks (@Query(ApiConstants.PARAM_API_KEY) String key,@Query(ApiConstants.PARAM_ARTIST) String name,
                       retrofit.Callback<TopTrackResponse> serverResponse);

    @GET(ApiConstants.URL_INFO_ARTIST)
    void getInfoArtist (@Query(ApiConstants.PARAM_API_KEY) String key,@Query(ApiConstants.PARAM_ARTIST) String name,
                        @Query(ApiConstants.PARAM_LANG) String lang, retrofit.Callback<Artist> serverResponse);

    //Artistas TOP - Llamada a atraves de Rxjava
    @GET(ApiConstants.URL_TOP_ARTISTS)
    rx.Observable<TopArtistResponse> getTopArtists();
}
