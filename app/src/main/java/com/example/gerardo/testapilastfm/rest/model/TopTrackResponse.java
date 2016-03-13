package com.example.gerardo.testapilastfm.rest.model;

import com.example.gerardo.testapilastfm.domain.Track;
import com.google.gson.annotations.SerializedName;

import java.util.ArrayList;

/**
 * Created by Gerardo on 05-02-2016.
 */
public class TopTrackResponse {

    @SerializedName(JsonKeys.TRACKS_RESULTS)
    TopTracksResult results;

    public ArrayList<Track> getTracks(){
        return results.tracks;
    }

    public void setTracks(ArrayList<Track> tracks){
        this.results.tracks = tracks;
    }

    private class TopTracksResult {
        @SerializedName(JsonKeys.TRACKS_ARRAY)
        ArrayList<Track> tracks;
    }
}
