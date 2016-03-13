package com.example.gerardo.testapilastfm.domain;

import com.example.gerardo.testapilastfm.rest.model.JsonKeys;
import com.google.gson.annotations.SerializedName;

/**
 * Created by Gerardo on 05-02-2016.
 */
public class Track {
    @SerializedName(JsonKeys.TRACK_NAME)
    String nameTrack;

    @SerializedName(JsonKeys.TRACK_PLAYCOUNT)
    String playcountTrack;

    @SerializedName(JsonKeys.TRACK_LISTENERS)
    String listenerTrack;

    public Track() {
    }

    public String getNameTrack() {
        return nameTrack;
    }

    public void setNameTrack(String nameTrack) {
        this.nameTrack = nameTrack;
    }

    public String getPlaycountTrack() {
        return playcountTrack;
    }

    public void setPlaycountTrack(String playcountTrack) {
        this.playcountTrack = playcountTrack;
    }

    public String getListenerTrack() {
        return listenerTrack;
    }

    public void setListenerTrack(String listenerTrack) {
        this.listenerTrack = listenerTrack;
    }
}
