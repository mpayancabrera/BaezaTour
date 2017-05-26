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

public class RestaurantsFragment extends Fragment {
    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState)
    {
        RecyclerView rv = (RecyclerView) inflater.inflate(
                R.layout.place_list, container, false);

        final ArrayList<Place> places = new ArrayList<Place>();
        places.add(new Place("Palacio de Gallego", "Enjoy of the best grilled food.", "Old taste.Culture and gastronomy, art and sabor.Tras the doors of Palace of Gallego mixes traditional cuisine music and history.", R.drawable.gallego));
        places.add(new Place("Juanito", "Reference of the gastronomy of Baeza.", "Juanito offers traditional and Andalusian cuisine with the good raw materials that gives the area; The big and small hunting, the products derived from its peculiar agriculture and its great gastronomic culture of the olive oil.", R.drawable.juanito));
        places.add(new Place("Tasca Burladero", "Nice terrace, good food.", "Located in the Spain square, in our Taberna you will find a cozy place where you can enjoy the best traditional gastronomy surrounded by family and friends.", R.drawable.burladero));

        rv.setLayoutManager(new LinearLayoutManager(rv.getContext()));
        rv.setAdapter(new PlaceAdapter(getActivity(), places));

        Log.d("RestaurantFragment", getActivity() + " " + String.valueOf(places.size()));
        return rv;
    }
}
