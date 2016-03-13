package com.example.gerardo.testapilastfm.rest;

/**
 * Created by Gerardo on 02-02-2016.
 */
public class ApiConstants {

    public static final String URL_BASE = "http://ws.audioscrobbler.com";
    public static final String API_KEY = "123ae7ccee87798c55c82b64c792a083";
    public static final String PATH_VERSION = "/2.0";
    public static final String VALUE_HYPED_ARTIST_METHOD = "chart.getTopArtists";
    public static final String PARAM_METHOD = "method";
    public static final String PARAM_FORMAT = "format";
    public static final String PARAM_API_KEY = "api_key";
    public static final String PARAM_ARTIST = "artist";
    public static final String VALUE_JSON = "json";

    public static final String URL_HYPED_ARTIST = PATH_VERSION+"?"+PARAM_API_KEY+"="+API_KEY+"&"+
            PARAM_METHOD + "="+VALUE_HYPED_ARTIST_METHOD+"&"+
            PARAM_FORMAT + "="+VALUE_JSON;

    //Constantes para el TOP Artist
    public static final String VALUE_TOP_ARTIST_METHOD = "chart.gettopartists";

    public static final String URL_TOP_ARTISTS = PATH_VERSION+"?"+PARAM_API_KEY+"="+API_KEY+"&"+
            PARAM_METHOD + "="+VALUE_TOP_ARTIST_METHOD+"&"+
            PARAM_FORMAT + "="+VALUE_JSON;

    //Constantes para el TOP Album

    //http://ws.audioscrobbler.com/2.0?api_key=123ae7ccee87798c55c82b64c792a083&artist=Muse&method=artist.getTopAlbums&format=json
    public static final String VALUE_TOP_ALBUM_METHOD = "artist.getTopAlbums";
    public static final String PARAM_ARTIST_NAME = "artist";
    public static final String VALUE_ARTIST_NAME = "artistName";

    //Estructura /2.0?&format=json&method=artist.getinfo
    public static final String URL_TOP_ALBUM = PATH_VERSION + "?"
            + "&" + PARAM_FORMAT + "=" + VALUE_JSON
            + "&" + PARAM_METHOD + "=" + VALUE_TOP_ALBUM_METHOD;

    //Top Tracks
    public static final String VALUE_TOP_TRACK_METHOD = "artist.getTopTracks";
    public static final String URL_TOP_TRACK = PATH_VERSION + "?"
            + "&" + PARAM_FORMAT + "=" + VALUE_JSON
            + "&" + PARAM_METHOD + "=" + VALUE_TOP_TRACK_METHOD;

    //Info Artista
    public static final String VALUE_INFO_ARTIST_METHOD = "artist.getInfo";
    public static final String PARAM_LANG = "lang";
    public static final String URL_INFO_ARTIST = PATH_VERSION + "?"
            + "&" + PARAM_FORMAT + "=" + VALUE_JSON
            + "&" + PARAM_METHOD + "=" + VALUE_INFO_ARTIST_METHOD;

}
