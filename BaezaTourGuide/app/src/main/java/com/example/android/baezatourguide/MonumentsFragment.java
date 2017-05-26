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

public class MonumentsFragment extends Fragment {

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState)
    {
        RecyclerView rv = (RecyclerView) inflater.inflate(
                R.layout.place_list, container, false);

        final ArrayList<Place> places = new ArrayList<Place>();

        places.add(new Place("Cathedral and Santa Maria Square", "Located in the historic center of the city.", "It is built on a Roman temple which later became a mosque, and in the reign of Ferdinand III it converted to Christianity under the advocacy of San Isidoro. The church has undergone numerous transformations and features elements from various different periods, although its dominant character today is Renaissance.", R.drawable.catedral));
        places.add(new Place("Jabalquinto Palace", "The immensely beautiful entrance is framed with large Gothic pinnacles.", "This is one of the best examples of the town's Isabelline Gothic architecture. There are also Mudéjar influences in the decoration. The site has a late 16th-century porticoed courtyard and a large Baroque flight of steps.", R.drawable.jabalquinto));
        places.add(new Place("Pópulo Square", "Amazing walled square.", "It is also called Plaza de los Leones, referring to the fountain, of the same name, that can be found there. The fountain is a square shaped pillar with rounded corners. It is crowned with a statue of Imilce, the Iberian princess who was Hannibal's wife.", R.drawable.leones));
        places.add(new Place("Old University of Baeza", "Baeza had a university before Úbeda and the city of Jaén.", "The building is from the late 16th century. The most significant part of the building is the courtyard.Antonio Machado was a professor here. The Blessed John of Ávila was a rector.", R.drawable.university));

        rv.setLayoutManager(new LinearLayoutManager(rv.getContext()));
        rv.setAdapter(new PlaceAdapter(getActivity(), places));

        Log.d("MonumentsFragment", getActivity() + " " + String.valueOf(places.size()));
        return rv;
    }
}
