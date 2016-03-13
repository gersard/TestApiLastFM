package com.example.gerardo.testapilastfm.rest;


import android.util.Log;

import com.example.gerardo.testapilastfm.rest.deserializer.HypedArtistsDeserializer;
import com.example.gerardo.testapilastfm.rest.deserializer.TopAlbumDeserializer;
import com.example.gerardo.testapilastfm.rest.deserializer.TopArtistsDeserializer;
import com.example.gerardo.testapilastfm.rest.model.HypedArtistsResponse;
import com.example.gerardo.testapilastfm.rest.model.TopAlbumResponse;
import com.example.gerardo.testapilastfm.rest.model.TopArtistResponse;
import com.google.gson.Gson;
import com.google.gson.GsonBuilder;

import retrofit.RestAdapter;
import retrofit.converter.GsonConverter;

/**
 * Created by Gerardo on 02-02-2016.
 */
public class LastFmApiAdapter {

    //Instacia del apiService para realizar las peticiones
    private static LastFmApiService API_SERVICE;

    private static LastFmApiService API_SERVICE2;
    private static LastFmApiService API_SERVICE3;

    //singleton

    public static LastFmApiService getApiService (){
        //Comprobar que el api no sea nulo
        if (API_SERVICE == null){
            //Al adaptador hay que pasarle el endpoint que sera la Url Base
            //
            RestAdapter adapter = new RestAdapter.Builder().setEndpoint(ApiConstants.URL_BASE)
                    .setLogLevel(RestAdapter.LogLevel.BASIC)
                    .setConverter(buildLastFmApiGsonConverter())
                    .build();
            //Se crea la api service mediante el adaptador
            API_SERVICE = adapter.create(LastFmApiService.class);

        }
        Log.i("APINOTNULL","LA API NO ES NULLA");
        return API_SERVICE;
    }
    public static LastFmApiService getApiServiceSerializado2 (){
        API_SERVICE3 = null;
        if (API_SERVICE3 == null){
            RestAdapter adapter = new RestAdapter.Builder().setEndpoint(ApiConstants.URL_BASE)
                    .setLogLevel(RestAdapter.LogLevel.BASIC)
                    .build();
            API_SERVICE3 = adapter.create(LastFmApiService.class);
            Log.i("API3","LA API fue nula");
        }

        return API_SERVICE3;
    }


    //Metodo getApiService ya serializado (automaticamente)
    public static LastFmApiService getApiServiceSerializado (){
        if (API_SERVICE2 == null){
            RestAdapter adapter = new RestAdapter.Builder().setEndpoint(ApiConstants.URL_BASE)
                    .setLogLevel(RestAdapter.LogLevel.BASIC)
                    .build();
            API_SERVICE2 = adapter.create(LastFmApiService.class);

        }
        Log.i("APIserializado","LA API NO ES NULLA");
        return API_SERVICE2;
    }



    private static GsonConverter buildLastFmApiGsonConverter(){
        Gson gsonConf = new GsonBuilder().registerTypeAdapter(HypedArtistsResponse.class, new HypedArtistsDeserializer())
                .registerTypeAdapter(TopArtistResponse.class,new TopArtistsDeserializer())
                .registerTypeAdapter(TopAlbumResponse.class, new TopAlbumDeserializer())
                .create();

        return new GsonConverter(gsonConf);
    }



}
