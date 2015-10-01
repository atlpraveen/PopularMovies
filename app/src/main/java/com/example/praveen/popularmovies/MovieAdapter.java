package com.example.praveen.popularmovies;

import android.app.Activity;
import android.content.Context;
import android.net.Uri;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.ImageView;

import com.squareup.picasso.Picasso;

import java.net.URI;
import java.util.ArrayList;
import java.util.List;

/**
 * Created by praveen on 06/07/15.
 */
public class MovieAdapter extends ArrayAdapter<MoviePojo>{

    private static final String baseImageUrl = "http://image.tmdb.org/t/p/w500/";
    public MovieAdapter(Activity context, List<MoviePojo> movies) {
        super(context, 0, movies);
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {


        MoviePojo movie = getItem(position);

        if (convertView == null) {
            convertView = LayoutInflater.from(getContext()).inflate(R.layout.movielayout, parent, false);
        }

        ImageView movieName = (ImageView) convertView.findViewById(R.id.image_view);

        Picasso.with(this.getContext()).load(baseImageUrl+movie.getPosterPath()).into(movieName);

        return convertView;
    }
}

