package com.example.gerardo.testapilastfm.domain;

/**
 * Created by Gerardo on 03-02-2016.
 */
public class Album {

    String nameAlbum;
    String playCountAlbum;
    String artistName;
    String urlImage;

    public Album() {
    }

    public Album(String name){
        this.nameAlbum = name;
    }

    public String getNameAlbum() {
        return nameAlbum;
    }

    public void setNameAlbum(String nameAlbum) {
        this.nameAlbum = nameAlbum;
    }

    public String getPlayCountAlbum() {
        return playCountAlbum;
    }

    public void setPlayCountAlbum(String playCountAlbum) {
        this.playCountAlbum = playCountAlbum;
    }

    public String getArtistName() {
        return artistName;
    }

    public void setArtistName(String artistName) {
        this.artistName = artistName;
    }

    public String getUrlImage() {
        return urlImage;
    }

    public void setUrlImage(String urlImage) {
        this.urlImage = urlImage;
    }
}
