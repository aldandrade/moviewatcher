package com.movie.watcher.service;

import com.google.gson.*;
import com.movie.watcher.model.Movie;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import java.sql.Array;
import java.util.*;

@Service
public class OmdbService {
    private static final Gson gson = new Gson();
    private static final JsonParser jsonParser = new JsonParser();
    private final static String URI = "http://www.omdbapi.com/?apikey=22e6d02f&s=";

    /**
     * This method will return a list of movies that contains the movieName passed as input
     * @param movieName the movie title that will be used to search on Omdb
     * @return
     */
    public List<Movie> getMovies(String movieName) {
        RestTemplate restTemplate = new RestTemplate();
        String receivedMovies =restTemplate.getForObject(URI.concat(movieName), String.class);
        System.out.println(receivedMovies);
        return parseResponse(receivedMovies);
    }

    private List<Movie> parseResponse(String response){
        JsonObject jsonObject = jsonParser.parse(response).getAsJsonObject();
        jsonParser.parse(response).getAsJsonObject();
        JsonArray movieJsonArray = jsonObject.get("Search").getAsJsonArray();
        return Arrays.asList(gson.fromJson(movieJsonArray.toString(), Movie[].class));
    }
}

