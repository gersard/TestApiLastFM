package com.example.gerardo.testapilastfm.rest.model;

import com.example.gerardo.testapilastfm.domain.Album;
import com.google.gson.annotations.SerializedName;

import java.util.ArrayList;

/**
 * Created by Gerardo on 03-02-2016.
 */
public class TopAlbumResponse {

    @SerializedName(JsonKeys.ALBUMS_RESULTS)
    TopAlbumsResults results;

    public ArrayList<Album>getAlbums(){
        return results.albums;
    }

    public void setAlbums(ArrayList<Album> albums){
        this.results.albums = albums;
    }

    private class TopAlbumsResults {
        ArrayList<Album>albums;
    }
}
