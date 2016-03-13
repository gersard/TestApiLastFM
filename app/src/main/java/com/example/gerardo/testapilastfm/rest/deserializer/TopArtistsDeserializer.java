package com.example.gerardo.testapilastfm.rest.deserializer;

import com.example.gerardo.testapilastfm.domain.Artist;
import com.example.gerardo.testapilastfm.rest.model.JsonKeys;
import com.example.gerardo.testapilastfm.rest.model.TopArtistResponse;
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
public class TopArtistsDeserializer  implements JsonDeserializer<TopArtistResponse> {

    @Override
    public TopArtistResponse deserialize(JsonElement json, Type typeOfT, JsonDeserializationContext context) throws JsonParseException {
        Gson gson = new Gson();

        TopArtistResponse  response = gson.fromJson(json, TopArtistResponse.class);
        //Obtener el objeto artists
        JsonObject artistResponseData = json.getAsJsonObject().getAsJsonObject(JsonKeys.ARTISTS_RESULTS);

        //Obtener el array de artists
        JsonArray artistArray = artistResponseData.getAsJsonArray(JsonKeys.ARTISTS_ARRAY);

        //Convertir el jsonArray de artists a objetos de la clase Artist
        response.setArtists(extractArtistsFromJsonArray(artistArray));

        return response;

    }

    private ArrayList<Artist> extractArtistsFromJsonArray(JsonArray array){

        ArrayList<Artist> artists = new ArrayList();
        for (int i = 0;i<array.size();i++){
            JsonObject artistData = array.get(i).getAsJsonObject();

            Artist currentArtist = new Artist();

            //Obtener el nombre
            String name = artistData.get(JsonKeys.ARTIST_NAME).getAsString();

            //Obtener el Playcount
            String playcount = artistData.get(JsonKeys.ARTIST_PLAYCOUNT).getAsString();

            //Obtener el Listeners
            String listeners = artistData.get(JsonKeys.ARTIST_LISTENERS).getAsString();

            //Manejo del arreglo de imagenes y obtener las imagesnes
            JsonArray imagesArray = artistData.getAsJsonArray(JsonKeys.ARTISTS_IMAGE);
            String[] images = extractArtistsImagesFromJsonArray(imagesArray);

            //Artista con toda la informacion seteada
            currentArtist.setName(name);
            currentArtist.setPlayCount(playcount);
            currentArtist.setListeners(listeners);
            currentArtist.setUrlMediumImage(images[0]);
            currentArtist.setUrlLargeImage(images[1]);

            artists.add(currentArtist);
        }
        return artists;
    }
    private String[] extractArtistsImagesFromJsonArray(JsonArray imagesArray){

        String [] images = new String[2];

        for (int i = 0; i < imagesArray.size(); i++) {
            JsonObject imageData = imagesArray.get(i).getAsJsonObject();

            String url = imageData.get(JsonKeys.IMAGES_URL).getAsString();
            String size = imageData.get(JsonKeys.IMAGES_SIZE).getAsString();

            //posicion 0 del arreglo es para imagenes medium(xl) y la posicion 1 para large(mega)
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
