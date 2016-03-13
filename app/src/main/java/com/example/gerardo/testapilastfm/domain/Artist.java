package com.example.gerardo.testapilastfm.domain;

import com.example.gerardo.testapilastfm.rest.model.JsonKeys;
import com.google.gson.annotations.SerializedName;

import java.util.ArrayList;

/**
 * Created by Gerardo on 02-02-2016.
 */
public class Artist {

    //Deserializacion automatica
    //Obtenciond e informacion
     @SerializedName(JsonKeys.INFO_ARRAY)
     Artist artist;

    @SerializedName(JsonKeys.ARTISTS_IMAGE)
    ArrayList<ArtistImages> images;

    @SerializedName(JsonKeys.INFO_STATS)
    Stats estadisticas;

    //Obtencionde tags
    @SerializedName(JsonKeys.INFO_TAG)
    Tag tag;

    @SerializedName(JsonKeys.INFO_BIO)
    Bio informacion;

    public Artist getArtist() {
        return artist;
    }


    public String obtenerImagen(){
        return images.get(4).getUrl();
    }

    public String obtenerListener(){
        return estadisticas.getListener();
    }

    public String obtenerPlaycount(){
        return estadisticas.getPlaycount();
    }

    public String obtenerTag(){
        return tag.getTags();
    }

    private class Tag {
        @SerializedName(JsonKeys.ARTIST_TAG)
        ArrayList<tagitos> tags;

        public String getTags() {
            return tags.get(0).getName();
        }

        private class tagitos{
            @SerializedName(JsonKeys.TAG_NAME)
            String name;

            public String getName() {
                return name;
            }
        }
    }

    public String obtenerInfo(){
        return informacion.getContenido();
    }


    //  /Obtencion de informacion

    @SerializedName(JsonKeys.ARTIST_NAME)
    String name;

    String urlLargeImage;
    String urlMediumImage;
    String playCount;
    String listeners;

    public Artist() {
    }

    public Artist(String name) {
        this.name = name;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getUrlMediumImage() {
        return urlMediumImage;
    }

    public void setUrlMediumImage(String urlMediumImage) {
        this.urlMediumImage = urlMediumImage;
    }

    public String getUrlLargeImage() {
        return urlLargeImage;
    }

    public void setUrlLargeImage(String urlLargeImage) {
        this.urlLargeImage = urlLargeImage;
    }

    public String getPlayCount() {
        return playCount;
    }

    public void setPlayCount(String playCount) {
        this.playCount = playCount;
    }

    public String getListeners() {
        return listeners;
    }

    public void setListeners(String listeners) {
        this.listeners = listeners;
    }

    //Clase que contenga el arreglo de imagenes
    private class ArtistImages {
        @SerializedName(JsonKeys.IMAGE_URL)
        private String url;

        public String getUrl() {
            return url;
        }
    }

    private class Stats {
        @SerializedName(JsonKeys.INFO_LISTENERS)
        String listener;

        @SerializedName(JsonKeys.INFO_PLAYCOUNT)
        String playcount;

        public String getListener() {
            return listener;
        }

        public String getPlaycount() {
            return playcount;
        }
    }

    private class Bio {
        @SerializedName(JsonKeys.INFO_CONTENT)
        String contenido;

        public String getContenido() {
            return contenido;
        }
    }
}
