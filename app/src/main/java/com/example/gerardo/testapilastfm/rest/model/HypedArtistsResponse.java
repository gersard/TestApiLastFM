package com.example.gerardo.testapilastfm.rest.model;

import com.example.gerardo.testapilastfm.domain.Artist;
import com.google.gson.annotations.SerializedName;

import java.util.ArrayList;

/**
 * Created by Gerardo on 02-02-2016.
 */
//Modelo de respuesta al callback
public class HypedArtistsResponse {

    //Define el encabezado del Json
    @SerializedName(JsonKeys.ARTISTS_RESULTS)
    HypedArtistsResults results;

    public ArrayList<Artist> getArtists(){
        return results.artists;

    }

    public void setArtists(ArrayList<Artist> artists){
        this.results.artists = artists;
    }

    private class HypedArtistsResults {

        //Version original del video
        /*
        @SerializedName(JsonKeys.ARTISTS_ARRAY) = artist
        ArrayList<Artist>artists;
         */
        @SerializedName(JsonKeys.ARTISTS_ARRAY)
        ArrayList<Artist>artists;
    }
}
