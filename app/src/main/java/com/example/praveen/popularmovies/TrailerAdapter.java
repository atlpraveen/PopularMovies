package com.example.praveen.popularmovies;

import android.app.Activity;
import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.TextView;


import java.util.List;

/**
 * Created by praveen on 28/09/15.
 */
public class TrailerAdapter extends ArrayAdapter<Youtube> {

    public TrailerAdapter(Activity context, List<Youtube> trailers) {
        super(context, 0 , trailers);
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {


        Youtube trailer = getItem(position);

        if (convertView == null) {
            convertView = LayoutInflater.from(getContext()).inflate(R.layout.traillayout, parent, false);
        }

        TextView textView = (TextView) convertView.findViewById(R.id.trailerUrl);

      textView.setText(trailer.getName());

        return convertView;
    }

}

