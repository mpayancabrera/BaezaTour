package com.example.android.baezatourguide;

/**
 * Created by Manuel on 15/05/2017.
 */

public class Place {

    //private variables
    private String mPlaceName;
    private String mPlaceSubtitle;
    private String mPlaceDescription;
    //default image identifier;
    private static final int NO_IMAGE = -1;
    private int mResourceImage = NO_IMAGE;

    /**
     * @param placeName is the place name
     *
     * @param placeSubtitle is a brief description for RecyclerView
     *
     * @param  placeDesc is an extended place description
     *
     * @param  resourceImage is the resource ID for the image file associated with this place
     */
    public Place(String placeName, String placeSubtitle, String placeDesc, Integer resourceImage) {
        mPlaceName = placeName;
        mPlaceSubtitle = placeSubtitle;
        mPlaceDescription = placeDesc;
        mResourceImage = resourceImage;
    }

    /**
     * Gets the string value of mPlaceName.
     *
     * @return place name.
     */
    public String getPlaceName() {
        return mPlaceName;
    }

    /**
     * Gets the string value of mPlaceSubtitle.
     *
     * @return place subtitle.
     */
    public String getPlaceSubtitle() {
        return mPlaceSubtitle;
    }

    /**
     * Gets the string value of mPlaceDescription.
     *
     * @return place description.
     */
    public String getPlaceDescription() {
        return mPlaceDescription;
    }

    /**
     * Gets the string value of mResourceImage.
     *
     * @return the mResourceImage identifier.
     */
    public int getResourceImage() {
        return mResourceImage;
    }

    /**
     *
     * @return Returns whether or not there is an image for this word
     */
    public boolean hasImage() {
        if (mResourceImage == NO_IMAGE) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "Place{" +
                "mPlaceName " + mPlaceName + "\'" +
                ", mPlaceSubtitle " + mPlaceSubtitle + "\'" +
                ", mPlaceDescription " + mPlaceDescription + "\'" +
                ", mResourceImage " + mResourceImage + '}';
    }
}
