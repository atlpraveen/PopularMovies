package com.example.praveen.popularmovies;


import java.util.List;

import retrofit.Callback;
import retrofit.http.GET;
import retrofit.http.Path;
import retrofit.http.Query;

/**
 * Created by praveen on 23/07/15.
 */
public interface MovieDBService {
        @GET("/discover/movie")
        void listMovies(@Query("sort_by") String sortby,@Query("api_key") String apikey, Callback<MovieResults> cb);

        @GET("/movie/{movieId}")
        void listTrailersAndReviews(@Path("movieId") int movieId, @Query("api_key") String apikey, @Query("append_to_response") String appendToResponse, Callback<TrailerResult> cb);
}
