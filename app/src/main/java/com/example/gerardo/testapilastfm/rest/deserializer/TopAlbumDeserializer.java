package com.example.gerardo.testapilastfm.rest.deserializer;

import com.example.gerardo.testapilastfm.domain.Album;
import com.example.gerardo.testapilastfm.rest.model.JsonKeys;
import com.example.gerardo.testapilastfm.rest.model.TopAlbumResponse;
import com.google.gson.Gson;
import com.google.gson.JsonArray;
import com.google.gson.JsonDeserializationContext;
import com.google.gson.JsonDeserializer;
import com.google.gson.JsonElement;
import com.google.gson.JsonObject;
import com.google.gson.JsonParseException;

import java.lang.reflect.Type;
import java.util.ArrayList;

/**
 * Created by Gerardo on 03-02-2016.
 */
public class TopAlbumDeserializer implements JsonDeserializer<TopAlbumResponse> {

    @Override
    public TopAlbumResponse deserialize(JsonElement json, Type typeOfT, JsonDeserializationContext context) throws JsonParseException {
        Gson gson = new Gson();

        TopAlbumResponse response = gson.fromJson(json,TopAlbumResponse.class);
        //Obtenemos el objeto de topalbums
        JsonObject albumResponseData = json.getAsJsonObject().getAsJsonObject(JsonKeys.ALBUMS_RESULTS);
        //Obtenemos el objeto de albums
        JsonArray albumArray = albumResponseData.getAsJsonArray(JsonKeys.ALBUMS_ARRAY);

        //Convertir el jsonArray de albums a objetos de la clase Album
        response.setAlbums(extractAlbumsFromJsonArray(albumArray));

        return response;
    }

    private ArrayList<Album> extractAlbumsFromJsonArray(JsonArray array){

        ArrayList<Album> albums = new ArrayList<>();

        for (int i = 0; i < array.size(); i++) {
            JsonObject albumData = array.get(i).getAsJsonObject();
            Album currentAlbum = new Album();

            String nameAlbum = albumData.get(JsonKeys.ALBUM_NAME).getAsString();
            String playcountAlbum = albumData.get(JsonKeys.ARTIST_PLAYCOUNT).getAsString();
            JsonArray imagesArray = albumData.getAsJsonArray(JsonKeys.ARTISTS_IMAGE);
            String[] images = extractAlbumsImagesFromJsonArray(imagesArray);

            currentAlbum.setNameAlbum(nameAlbum);
            currentAlbum.setPlayCountAlbum(playcountAlbum);
            currentAlbum.setUrlImage(images[0]);

            albums.add(currentAlbum);

        }
        return albums;
    }

    private String[] extractAlbumsImagesFromJsonArray(JsonArray imagesArray){

        String[] images = new String[2];
        for (int i = 0; i < imagesArray.size(); i++) {
        JsonObject imageData = imagesArray.get(i).getAsJsonObject();

            String url = imageData.get(JsonKeys.IMAGES_URL).getAsString();
            String size = imageData.get(JsonKeys.IMAGES_SIZE).getAsString();

            if (url.isEmpty()){
                url = null;
            }else {
                if (size.matches(JsonKeys.IMAGES_MEDIUM)) {
                    images[0] = url;
                } else {
                    if (size.matches(JsonKeys.IMAGES_LARGE)) {
                        images[1] = url;
                    }
                }
            }
        }
        return images;
    }
}
