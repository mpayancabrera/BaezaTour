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

import static com.example.android.baezatourguide.R.drawable.toros;

/**
 * Created by Manuel on 15/05/2017.
 */

public class EventsFragment extends Fragment {

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState)
    {
        RecyclerView rv = (RecyclerView) inflater.inflate(
                R.layout.place_list, container, false);

        final ArrayList<Place> places = new ArrayList<Place>();
        places.add(new Place("Holy Week", "Revive the passion of Jesus Christ", "In Baeza and the rest of Andalucia is an event that literally transforms towns and cities across this region. Processions of elaborately decorated floats with Jesus and Mary statues, groups of pointy-hood wearing Nazarenos (penitents), and shrill brass bands, walk slowly through the streets, from their parish church to the cathedral and back. It is an amazing experience, and a great time to come to Baeza.", R.drawable.lacaida));
        places.add(new Place("Rosel's virgin Pilgrimage", "A beautiful parade of decorated carriages.", "The horses and carriages open the cortege, preceding the chariot of the Rosell Virgin and then more chariot beautifully decked with flowers. During the tour are singing festive songs and others in honor of the Virgin. At the stops that are made along the way, the typical food are tasted. On arrival at the village, they all stop before our Virgin. Once the route is finished, the Virgin is transported to the Sanctuary.", R.drawable.romeria));
        places.add(new Place("Bullfight (Corrida de toros)", "¡Authentic show!.", "Enjoy the best atmosphere in a bullfight like you've never seen before. One of the oldest traditions in Spain.", toros));

        rv.setLayoutManager(new LinearLayoutManager(rv.getContext()));
        rv.setAdapter(new PlaceAdapter(getActivity(), places));

        Log.d("EventsFragment", getActivity() + " " + String.valueOf(places.size()));
        return rv;
    }
}
