package com.example.gerardo.testapilastfm.rest.model;

import com.example.gerardo.testapilastfm.domain.Artist;
import com.google.gson.annotations.SerializedName;

import java.util.ArrayList;

/**
 * Created by Gerardo on 03-02-2016.
 */
public class TopArtistResponse {

    @SerializedName(JsonKeys.ARTISTS_RESULTS)
    HypedArtistsResults results;

    public ArrayList<Artist> getArtists(){
        return results.artists;
    }

    public void setArtists(ArrayList<Artist> artists){
        this.results.artists = artists;
    }

    private class HypedArtistsResults {


        ArrayList<Artist>artists;
    }
}
