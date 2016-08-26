package com.sparshik.maptest;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;

import com.google.android.gms.maps.GoogleMap;
import com.google.android.gms.maps.MapFragment;
import com.google.android.gms.maps.OnStreetViewPanoramaReadyCallback;
import com.google.android.gms.maps.StreetViewPanorama;
import com.google.android.gms.maps.StreetViewPanoramaFragment;
import com.google.android.gms.maps.model.LatLng;
import com.google.android.gms.maps.model.StreetViewPanoramaCamera;

public class GrandCanyon extends AppCompatActivity implements OnStreetViewPanoramaReadyCallback{

    StreetViewPanorama s_panorama;
    boolean panoramaReady=false;
    LatLng grandCanyon = new LatLng(37.400546,-122.108668);
    private long duration = 1000;
    private static final float ZOOM_BY = 0.5f;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_grand_canyon);

        StreetViewPanoramaFragment streetViewPanorama = (StreetViewPanoramaFragment) getFragmentManager().findFragmentById(R.id.street_view_panorama);
        streetViewPanorama.getStreetViewPanoramaAsync(this);
    }

    @Override
    public void onStreetViewPanoramaReady(StreetViewPanorama streetViewPanorama) {
    panoramaReady = true;
        s_panorama = streetViewPanorama;
        s_panorama.setPosition(grandCanyon);

        StreetViewPanoramaCamera camera = new StreetViewPanoramaCamera.Builder()
                .zoom(s_panorama.getPanoramaCamera().zoom)
                .tilt(s_panorama.getPanoramaCamera().tilt)
                .bearing(180)
                .build();
        s_panorama.animateTo(camera,duration);
    }
}
