package com.example.flixster.models;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;
import org.parceler.Parcel;

import java.util.ArrayList;
import java.util.List;

@Parcel
public class Movie {
    public static final String IMAGE_SIZES = "https://image.tmdb.org/t/p/w342/6bCplVkhowCjTHXWv49UjRPn0eK.jpg";

    int movieId;
    String backdropPath;
    String posterPath;
    String title;
    String overview;
    double rating;

    // empty constructor needed by the Parceler library
    public Movie(){}
    public Movie(JSONObject jsonObject) throws JSONException {
        backdropPath = jsonObject.getString("backdrop_path");
        posterPath = jsonObject.getString("poster_path");
        title = jsonObject.getString("title");
        overview = jsonObject.getString("overview");
        rating = jsonObject.getDouble("vote_average");
        movieId = jsonObject.getInt("id");
    }

    public static List<Movie> fromJsonArray(JSONArray movieJsonArray) throws JSONException {
        List<Movie> movies = new ArrayList<>();
        for (int i = 0; i< movieJsonArray.length(); i++){
            movies.add(new Movie(movieJsonArray.getJSONObject(i)));
        }
        return movies;
    }

    public String getPosterPath() {
//        String posterSize = "";
//        switch(i){
//
//            case 0:
//                posterSize = "w92";
//                break;
//            case 1:
//                posterSize = "w154";
//                break;
//
//            case 2:
//                posterSize = "w185";
//                break;
//            case 3:
//                posterSize = "original";
//                break;
//
//            case 4:
//                posterSize = "w500";
//                break;
//
//            case 5:
//                posterSize = "780";
//                break;
//            default:
//                posterSize = "w342";
//                break;
//        }
        return String.format("https://image.tmdb.org/t/p/w342/%s",posterPath);
    }
    public String getBackdropPath() {
//        String backdropSize = "";
//        switch(i){
//
//            case 0:
//                backdropSize = "w780";
//                break;
//            case 1:
//                backdropSize = "w1280";
//                break;
//            case 2:
//                backdropSize = "original";
//                break;
//            default:
//                backdropSize = "w300";
//                break;
//        }
        return String.format("https://image.tmdb.org/t/p/w300/%s",backdropPath);
    }
    public String getTitle() {
        return title;
    }

    public String getOverview() {
        return overview;
    }

    public double getRating() {
        return rating;
    }

    public int getMovieId() {
        return movieId;
    }
}
