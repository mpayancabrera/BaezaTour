package com.example.android.baezatourguide;

import android.content.Intent;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.design.widget.CollapsingToolbarLayout;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.widget.ImageView;
import android.widget.TextView;

import com.bumptech.glide.Glide;

/**
 * Created by Manuel on 15/05/2017.
 */

public class PlaceDetailActivity extends AppCompatActivity {
    public static final String EXTRA_NAME = "place_name";
    public static final String EXTRA_DESCRIPTION = "place_description";
    public static final String EXTRA_IMAGE = "place_image";

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_detail);

        Intent intent = getIntent();
        final String placeName = intent.getStringExtra(EXTRA_NAME);
        final String placeDescription = intent.getStringExtra(EXTRA_DESCRIPTION);

        final Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);
        getSupportActionBar().setDisplayHomeAsUpEnabled(true);

        CollapsingToolbarLayout collapsingToolbarLayout = (CollapsingToolbarLayout) findViewById(R.id.collapsing_toolbar);
        collapsingToolbarLayout.setTitle(placeName);
        //collapsingToolbarLayout.setExpandedTitleColor(getResources().getColor(android.R.color.transparent));


        TextView tv_title = (TextView) findViewById(R.id.tv_place_name);
        tv_title.setText("Info");

        TextView tv_desc = (TextView) findViewById(R.id.tv_place_desc);
        tv_desc.setText(placeDescription);

        final int id_image = intent.getIntExtra(EXTRA_IMAGE, -1);

        loadImage(id_image);
    }

    private void loadImage(int image) {
        final ImageView imageView = (ImageView) findViewById(R.id.image_detail);
        Glide.with(this).load(image).centerCrop().into(imageView);
    }
}



