package com.example.praveen.popularmovies;

import android.content.Intent;
import android.support.v4.app.Fragment;
import android.os.Bundle;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.ListView;
import android.widget.RatingBar;
import android.widget.TextView;

import com.squareup.picasso.Picasso;

import java.util.ArrayList;

import retrofit.Callback;
import retrofit.RestAdapter;
import retrofit.RetrofitError;
import retrofit.client.Response;


/**
 * A placeholder fragment containing a simple view.
 */
public class MovieDetailActivityFragment extends Fragment {

    private static final String baseImageUrl = "http://image.tmdb.org/t/p/w780/";
    private final String baseUrl = "http://api.themoviedb.org/3";
    private ArrayList<Youtube> trailerList = new ArrayList<Youtube>();
    private TrailerAdapter trailerAdapter;

    public MovieDetailActivityFragment() {
    }

    public void populateTrailersAndReviews(int movieId) {
        RestAdapter restAdapter = new RestAdapter.Builder()
                .setEndpoint(baseUrl).setLogLevel(RestAdapter.LogLevel.FULL)
                .build();

        MovieDBService service = restAdapter.create(MovieDBService.class);
        service.listTrailersAndReviews(movieId,"e659d50d825549c0f9be8f305bc1ef3c","reviews,trailers", new Callback<TrailerResult>() {

            @Override
            public void success(TrailerResult trailerResult, Response response) {
                if(trailerResult!=null) {
                    trailerAdapter.clear();
                    for(Youtube tr : trailerResult.getTrailers().getYoutube())
                    {
                        trailerAdapter.add(tr);
                    }
                    trailerAdapter.notifyDataSetChanged();
                }

            }

            @Override
            public void failure(RetrofitError error) {

            }
        });
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        Intent intent = getActivity().getIntent();
        trailerAdapter = new TrailerAdapter(getActivity(),trailerList);
        View rootView = inflater.inflate(R.layout.fragment_movie_detail, container, false);
        if(intent!=null) {

            ArrayList<String> details = intent.getStringArrayListExtra("details");
            Picasso.with(getActivity()).load(baseImageUrl+details.get(4)).into(((ImageView) rootView.findViewById(R.id.backdropView)));
            populateTrailersAndReviews(Integer.parseInt(details.get(5)));
            ((TextView)rootView.findViewById(R.id.title)).setText(details.get(0));
            ((TextView)rootView.findViewById(R.id.overview)).setText("PlotSynopsis :" + "\n" + details.get(1));
            ((TextView)rootView.findViewById(R.id.userRating)).setText(details.get(2));
            RatingBar rb = ((RatingBar)rootView.findViewById(R.id.ratingBar));
            float rating = Float.valueOf(details.get(2))/2;
            Log.d("rating is", Float.toString(rating));
            rb.setNumStars(5);
            rb.setRating(rating);
            ((TextView)rootView.findViewById(R.id.releaseDate)).setText("Release Date - " + details.get(3));
            ((ListView)rootView.findViewById(R.id.trailerView)).setAdapter(trailerAdapter);

        }
        return rootView;
    }
}
