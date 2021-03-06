package com.sparshik.maptest;

import android.content.Intent;
import android.content.res.Resources;
import android.graphics.Color;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;

import com.google.android.gms.maps.CameraUpdateFactory;
import com.google.android.gms.maps.GoogleMap;
import com.google.android.gms.maps.MapFragment;
import com.google.android.gms.maps.OnMapReadyCallback;
import com.google.android.gms.maps.model.BitmapDescriptorFactory;
import com.google.android.gms.maps.model.CameraPosition;
import com.google.android.gms.maps.model.CircleOptions;
import com.google.android.gms.maps.model.LatLng;
import com.google.android.gms.maps.model.MarkerOptions;
import com.google.android.gms.maps.model.Polyline;
import com.google.android.gms.maps.model.PolylineOptions;

public class MainActivity extends AppCompatActivity implements OnMapReadyCallback {

    GoogleMap m_map;
    boolean mapReady=false;

    MarkerOptions renton;
    MarkerOptions kirkland;
    MarkerOptions everett;
    MarkerOptions lynnwood;
    MarkerOptions montlake;
    MarkerOptions kent;
    MarkerOptions showare;

    LatLng rentonLatLng = new LatLng(47.489805, -122.120502);
    LatLng kirklandLatLng = new LatLng(47.7301986, -122.1768858);
    LatLng everettLatLng = new LatLng(47.978748,-122.202001);
    LatLng lynnwoodLatLng = new LatLng(47.819533,-122.32288);
    LatLng montlakeLatLng = new LatLng(47.7973733,-122.3281771);
    LatLng kentLatLng = new LatLng(47.385938,-122.258212);
    LatLng showareLatLng = new LatLng(47.38702,-122.23986);

    static final CameraPosition SEATTLE = CameraPosition.builder()
            .target(new LatLng(47.6204,-122.2491))
            .zoom(10)
            .bearing(0)
            .tilt(45)
            .build();

    @Override
    public Resources getResources() {
        return super.getResources();
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        renton = new MarkerOptions()
                .position(new LatLng(47.489805, -122.120502))
                .title("Renton")
                .icon(BitmapDescriptorFactory.fromResource(R.mipmap.ic_launcher));

        kirkland = new MarkerOptions()
                .position(new LatLng(47.7301986, -122.1768858))
                .title("Kirkland")
                .icon(BitmapDescriptorFactory.fromResource(R.mipmap.ic_launcher));

        everett = new MarkerOptions()
                .position(new LatLng(47.978748,-122.202001))
                .title("Everett")
                .icon(BitmapDescriptorFactory.fromResource(R.mipmap.ic_launcher));

        lynnwood = new MarkerOptions()
                .position(new LatLng(47.819533,-122.32288))
                .title("Lynnwood")
                .icon(BitmapDescriptorFactory.fromResource(R.mipmap.ic_launcher));

        montlake = new MarkerOptions()
                .position(new LatLng(47.7973733,-122.3281771))
                .title("Montlake Terrace")
                .icon(BitmapDescriptorFactory.fromResource(R.mipmap.ic_launcher));

        kent = new MarkerOptions()
                .position(new LatLng(47.385938,-122.258212))
                .title("Kent Valley")
                .icon(BitmapDescriptorFactory.fromResource(R.mipmap.ic_launcher));

        showare = new MarkerOptions()
                .position(new LatLng(47.38702,-122.23986))
                .title("Showare Center")
                .icon(BitmapDescriptorFactory.fromResource(R.mipmap.ic_launcher));

        MapFragment mapFragment = (MapFragment) getFragmentManager().findFragmentById(R.id.map);
        mapFragment.getMapAsync(this);

    }



    @Override
    public void onMapReady(GoogleMap map){
        //MapsInitializer.initialize(getApplicationContext());
        mapReady=true;
        m_map = map;
        m_map.addMarker(renton);
        m_map.addMarker(kirkland);
        m_map.addMarker(everett);
        m_map.addMarker(lynnwood);
        m_map.addMarker(montlake);
        m_map.addMarker(kent);
        m_map.addMarker(showare);

        m_map.addPolyline(new PolylineOptions().geodesic(true)
        .add(rentonLatLng)
        .add(kirklandLatLng)
        .add(everettLatLng)
        .add(lynnwoodLatLng)
        .add(montlakeLatLng)
        .add(kentLatLng)
        .add(showareLatLng)
        .add(rentonLatLng));

        m_map.addCircle( new CircleOptions()
        .center(rentonLatLng)
        .radius(5000)
        .strokeColor(Color.GREEN)
        .fillColor(Color.argb(64,0,255,0)));
        flyTo(SEATTLE);
    }

    private void flyTo(CameraPosition target)
    {
        m_map.moveCamera(CameraUpdateFactory.newCameraPosition(target));
    }


    /**
     * Override onOptionsItemSelected to use main_menu instead of BaseActivity menu
     *
     * @param menu
     */
    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        /* Inflate the menu; this adds items to the action bar if it is present. */
        getMenuInflater().inflate(R.menu.main, menu);
        return true;
    }

    /**
     * Override onOptionsItemSelected to add action_settings only to the MainActivity
     *
     * @param item
     */
    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        int id = item.getItemId();
        if (id == R.id.action_trail) {
            startActivity(new Intent(MainActivity.this, GrandCanyon.class));
            return true;
        }
        return super.onOptionsItemSelected(item);
    }


}