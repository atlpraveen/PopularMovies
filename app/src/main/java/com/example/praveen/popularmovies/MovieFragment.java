package com.example.praveen.popularmovies;


import android.content.Intent;
import android.content.SharedPreferences;
import android.content.res.Configuration;

import android.os.Bundle;
import android.app.Fragment;

import android.preference.PreferenceManager;

import android.view.LayoutInflater;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;

import android.widget.GridView;

import java.util.ArrayList;

import retrofit.Callback;
import retrofit.RestAdapter;
import retrofit.RetrofitError;
import retrofit.client.Response;



/**
 *
 */
public class MovieFragment extends Fragment implements SharedPreferences.OnSharedPreferenceChangeListener {

     private MovieAdapter movieAdapter;
    private final String baseUrl = "http://api.themoviedb.org/3";
     private ArrayList<MoviePojo> movieList = new ArrayList<MoviePojo>();

    SharedPreferences pref ;

    public MovieFragment() {
        // Required empty public constructor
    }



    @Override
    public void onCreateOptionsMenu(Menu menu, MenuInflater inflater) {
        inflater.inflate(R.menu.menu_main, menu);
    }

    @Override
    public void onStart() {
        super.onStart();
    }

    @Override
    public void onSaveInstanceState(Bundle outState) {
        outState.putParcelableArrayList("movies",movieList);
        super.onSaveInstanceState(outState);
    }

    public void updateMovies() {
        pref.registerOnSharedPreferenceChangeListener(this);
        String sortby = pref.getString(getString(R.string.pref_sortOrderLabel),getString(R.string.pref_default_value));
        RestAdapter restAdapter = new RestAdapter.Builder()
                .setEndpoint(baseUrl).setLogLevel(RestAdapter.LogLevel.FULL)
                .build();

        MovieDBService service = restAdapter.create(MovieDBService.class);
        service.listMovies(sortby, "e659d50d825549c0f9be8f305bc1ef3c", new Callback<MovieResults>() {

            @Override
            public void success(MovieResults movieResults, Response response) {
                if (movieResults != null) {
                    movieAdapter.clear();
                    for (MoviePojo m : movieResults.getResults()) {
                        movieAdapter.add(m);
                    }
                    movieAdapter.notifyDataSetChanged();
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
        pref = PreferenceManager.getDefaultSharedPreferences(getActivity());
        setHasOptionsMenu(true);
      movieAdapter = new MovieAdapter(getActivity(),movieList);

       if(savedInstanceState!=null) {
               movieList = savedInstanceState.getParcelableArrayList("movies");
               movieAdapter.addAll(movieList);
               movieAdapter.notifyDataSetChanged();

       }
        else {
           updateMovies();
       }

        View rootView = inflater.inflate(R.layout.fragment_main, container, false);

        GridView gridView = (GridView)rootView.findViewById(R.id.movieGrid);
        gridView.setAdapter(movieAdapter);
        if(getResources().getConfiguration().orientation== Configuration.ORIENTATION_LANDSCAPE)
        {
            gridView.setNumColumns(4);
        } else {
            gridView.setNumColumns(2);
        }
        //update
        gridView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            public void onItemClick(AdapterView<?> parent, View v,
                                    int position, long id) {
                MoviePojo mv = movieAdapter.getItem(position);
                ArrayList<String> details = new ArrayList<String>();
                details.add(mv.getTitle());
                details.add(mv.getOverview());
                details.add(Double.toString(mv.getVoteAverage()));
                details.add(mv.getReleaseDate());
                details.add(mv.getBackdropPath());
                details.add(mv.getId().toString());
                //Log.v("back path is ", mv.getBackdropPath());
                Intent intent = new Intent(getActivity(), MovieDetailActivity.class).putStringArrayListExtra("details", details);
                startActivity(intent);
            }
        });

        return rootView;

    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {

        int id = item.getItemId();

        switch (item.getItemId()) {

            case R.id.action_settings:
                startActivity(new Intent(getActivity(),SettingsActivity.class));
                return true;
            default:
                return super.onOptionsItemSelected(item);

        }

    }

    @Override
    public void onSharedPreferenceChanged(SharedPreferences sharedPreferences, String key) {
        updateMovies();

    }

}
