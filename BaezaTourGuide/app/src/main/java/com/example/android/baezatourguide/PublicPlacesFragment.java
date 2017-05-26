package com.example.android.baezatourguide;

import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import java.util.ArrayList;

/**
 * Created by Manuel on 15/05/2017.
 */

public class PublicPlacesFragment extends Fragment {

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState)
    {
        RecyclerView rv = (RecyclerView) inflater.inflate(
                R.layout.place_list, container, false);

        final ArrayList<Place> places = new ArrayList<Place>();
        places.add(new Place("Cathedral Walls", "Discover the wonderful walls of Baeza.", "The walled remains of Baeza are one of the most beautiful images of the city. Step into the hysterical shell.", R.drawable.callejones));
        places.add(new Place("Spain Square", "Have an ice cream or coffee in the Spain Square", "Enjoy the Plaza de España, located in the heart of Baeza. Here you can rest or take advantage to eat in the multitude of restaurants located around the square.", R.drawable.paseo));
        places.add(new Place("Antonio Machado Route", "Walk along the route of Antonio Machado", "Route in honor to the writer Antonio Machado. Antonio Machado was one of the best Spanish writers and lived in Baeza during a long season of his life. Through this walk you can enjoy the views of Baeza.", R.drawable.paseo_antonio_machado));

        rv.setLayoutManager(new LinearLayoutManager(rv.getContext()));
        rv.setAdapter(new PlaceAdapter(getActivity(), places));

        Log.d("PublicPlacesFragment", getActivity() + " " + String.valueOf(places.size()));
        return rv;
    }
}
