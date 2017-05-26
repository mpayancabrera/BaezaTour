package com.example.android.baezatourguide;

import android.content.Context;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentPagerAdapter;

/**
 * Created by Manuel on 15/05/2017.
 */

public class SimpleFragmentPagerAdapter extends FragmentPagerAdapter {

    /** Context of the app */
    private Context mContext;

    /**
     * Create a new {@link SimpleFragmentPagerAdapter} object.
     *
     * @param context is the context of the app
     * @param fm is the fragment manager that will keep each fragment's state in the adapter
     *           across swipes.
     */
    public SimpleFragmentPagerAdapter(Context context, FragmentManager fm)
    {
        super(fm);
        mContext = context;
    }

    @Override
    public Fragment getItem(int position) {
        if (position == 0) {
            return new MonumentsFragment();
        } else if (position == 1){
            return new RestaurantsFragment();
        } else if (position == 2){
            return new EventsFragment();
        } else {
            return new PublicPlacesFragment();
        }
    }

    @Override
    public int getCount() {
        return 4;
    }

    @Override
    public CharSequence getPageTitle(int position) {
        if (position == 0) {
            return mContext.getString(R.string.tab_monuments);
        } else if (position == 1) {
            return mContext.getString(R.string.tab_restaurants);
        } else if (position == 2) {
            return mContext.getString(R.string.category_events);
        } else {
            return mContext.getString(R.string.tab_public_places);
        }
    }
}
