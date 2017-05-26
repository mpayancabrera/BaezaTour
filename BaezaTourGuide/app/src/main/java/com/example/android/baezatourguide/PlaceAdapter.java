package com.example.android.baezatourguide;

import android.content.Context;
import android.content.Intent;
import android.support.v7.widget.RecyclerView;
import android.util.Log;
import android.util.TypedValue;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import java.util.ArrayList;

import static android.media.CamcorderProfile.get;
import static android.view.View.GONE;
import static android.view.View.VISIBLE;
import static com.example.android.baezatourguide.R.id.item_image;

/**
 * Created by Manuel on 22/05/2017.
 */

public class PlaceAdapter extends RecyclerView.Adapter<PlaceAdapter.ViewHolder> {

    private ArrayList<Place> mPlaces;
    private Context context;
    private final TypedValue mTypedValue = new TypedValue();
    private int mBackground;

    public PlaceAdapter(Context context, ArrayList<Place> places)
    {
        super();
        context.getTheme().resolveAttribute(R.attr.selectableItemBackground, mTypedValue, true);
        mBackground = mTypedValue.resourceId;
        this.context = context;
        this.mPlaces = places;

    }

    public Place getValueAt(int position) {
        return mPlaces.get(position);
    }

    /**
     *
     * This gets called when each new ViewHolder is created. This happens when the RecyclerView
     * is laid out. Enough ViewHolders will be created to fill the screen and allow for scrolling.
     *
     * @return A new ViewHolder that holds the View for each list item
     */
    @Override
    public PlaceAdapter.ViewHolder onCreateViewHolder(ViewGroup parent, int viewType)
    {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.list_item, parent, false);
        view.setBackgroundResource(mBackground);
        return new ViewHolder(view);
    }

    /**
     * OnBindViewHolder is called by the RecyclerView to display the data at the specified
     * position.
     *
     * @param holder   The ViewHolder which should be updated to represent the contents of the
     *                 item at the given position in the data set.
     * @param position The position of the item within the adapter's data set.
     */
    @Override
    public void onBindViewHolder(final ViewHolder holder, final int position)
    {
        holder.mBoundTitle = getValueAt(position).getPlaceName();
        holder.mBoundDesc = getValueAt(position).getPlaceDescription();
        holder.mIdImage = getValueAt(position).getResourceImage();
        holder.tv_title.setText(getValueAt(position).getPlaceName());
        holder.tv_subtitle.setText(getValueAt(position).getPlaceSubtitle());
        if (getValueAt(position).hasImage()) {
            // Get the image resource ID and
            // set the image to mImageView
            holder.mImageView.setImageResource(getValueAt(position).getResourceImage());
            holder.mImageView.setVisibility(VISIBLE);
        }
        else
        {
            holder.mImageView.setVisibility(GONE);
        }

        holder.mView.setOnClickListener(new View.OnClickListener()
        {
            @Override
            public void onClick(View v) {
                Context context = v.getContext();
                Log.d("PlaceAdapter", mPlaces.get(position).toString());
                Intent intent = new Intent(context, PlaceDetailActivity.class);
                intent.putExtra(PlaceDetailActivity.EXTRA_NAME, holder.mBoundTitle);
                intent.putExtra(PlaceDetailActivity.EXTRA_DESCRIPTION, holder.mBoundDesc);
                intent.putExtra(PlaceDetailActivity.EXTRA_IMAGE, holder.mIdImage);
                context.startActivity(intent);
            }
        });
    }

    /**
     * This method simply returns the number of items to display.
     *
     * @return The number of items available
     */
    @Override
    public int getItemCount()
    {
        return mPlaces.size();
    }

    public class ViewHolder extends RecyclerView.ViewHolder
    {
        public String mBoundTitle;
        public String mBoundDesc;
        public int mIdImage;
        public final View mView;

        public final TextView tv_title;
        public final TextView tv_subtitle;
        public final ImageView mImageView;

        public ViewHolder(View itemView) {
            super(itemView);
            mView = itemView;
            tv_title = (TextView) itemView.findViewById(R.id.item_title);
            tv_subtitle = (TextView) itemView.findViewById(R.id.item_subtitle);
            mImageView = (ImageView) itemView.findViewById(R.id.item_image);
        }

        @Override
        public String toString() {
            return super.toString() + " '" + tv_title.getText();
        }
    }
}
