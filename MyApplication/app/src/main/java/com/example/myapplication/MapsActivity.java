package com.example.myapplication;

import androidx.fragment.app.FragmentActivity;

import android.location.Location;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;

import com.google.android.gms.maps.CameraUpdateFactory;
import com.google.android.gms.maps.GoogleMap;
import com.google.android.gms.maps.OnMapReadyCallback;
import com.google.android.gms.maps.SupportMapFragment;
import com.google.android.gms.maps.model.BitmapDescriptor;
import com.google.android.gms.maps.model.BitmapDescriptorFactory;
import com.google.android.gms.maps.model.CameraPosition;
import com.google.android.gms.maps.model.CircleOptions;
import com.google.android.gms.maps.model.LatLng;
import com.google.android.gms.maps.model.MarkerOptions;

public class MapsActivity extends FragmentActivity implements OnMapReadyCallback {
    public class shop {
        String name;
        double latitude;
        double longitude;

        public shop (String name, double latitude, double longitude) {
            this.name = name;
            this.latitude = latitude;
            this.longitude = longitude;
        }

        public String getName () {
            return name;
        }

        public double getLatitude () {
            return latitude;
        }

        public double getLongitude () {
            return longitude;
        }
    }
    private GoogleMap mMap;
    shop[] shops;
    int index;
    LatLng default_latLng;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_maps);
        // Obtain the SupportMapFragment and get notified when the map is ready to be used.
        SupportMapFragment mapFragment = (SupportMapFragment) getSupportFragmentManager()
                .findFragmentById(R.id.map);

        mapFragment.getMapAsync(this);
        shop shop1 = new shop("麥當勞", 24.178986, 120.645256);
        shop shop2 = new shop("肯德基", 24.182539, 120.644733);
        shop shop3 = new shop("小辣椒", 24.179317, 120.646322);
        shop shop4 = new shop("八方雲集",24.174406, 120.644547);
        shop shop5 = new shop("泰神打拋豬",24.181986, 120.647673);
        shop shop6 = new shop("吉野烤肉飯",24.180421, 120.645914);
        shop shop7 = new shop("小紅帽韓式烤肉",24.180459, 120.646343);
        shop shop8 = new shop("擄胃專家",24.180572, 120.645477);
        shop shop9 = new shop("紅黑咖哩",24.181093, 120.646093);
        shop shop10 = new shop("黑豬咖哩",24.182041, 120.646139);

        shops = new shop[] { shop1, shop2, shop3, shop4, shop5, shop6, shop7, shop8, shop9, shop10 };

        Bundle bundle = this.getIntent().getExtras();
        index = Integer.parseInt(bundle.getString("Result"));

        Log.d("aaa", shops[index].getName());
    }

    /**
     * Manipulates the map once available.
     * This callback is triggered when the map is ready to be used.
     * This is where we can add markers or lines, add listeners or move the camera. In this case,
     * we just add a marker near Sydney, Australia.
     * If Google Play services is not installed on the device, the user will be prompted to install
     * it inside the SupportMapFragment. This method will only be triggered once the user has
     * installed Google Play services and returned to the app.
     */

    @Override
    public void onMapReady(GoogleMap googleMap) {
        mMap = googleMap;
        final LatLng default_latlng = new LatLng(24.179239, 120.649678);

        // Add a marker in Sydney and move the camera
        final LatLng sydney = new LatLng(shops[index].latitude, shops[index].longitude);

        final CameraPosition cameraPosition = new CameraPosition.Builder().target(sydney).zoom(12).build();

        mMap.animateCamera(CameraUpdateFactory.newCameraPosition(cameraPosition), 2000, new GoogleMap.CancelableCallback() {
            @Override
            public void onFinish() {
                CircleOptions circleOptions = new CircleOptions().center(sydney).radius(100);
                BitmapDescriptor descriptor = BitmapDescriptorFactory.defaultMarker(BitmapDescriptorFactory.HUE_CYAN);
                mMap.addMarker(new MarkerOptions().position(sydney).icon(descriptor).title(shops[index].getName()));
                mMap.moveCamera(CameraUpdateFactory.newLatLng(sydney));
                mMap.animateCamera(CameraUpdateFactory.zoomTo(18));
                mMap.addCircle(circleOptions);
                float[] distance = new float[1];
                Location.distanceBetween(default_latlng.latitude, default_latlng.longitude, shops[index].latitude, shops[index].longitude, distance);
                Toast.makeText(getApplicationContext(), "從資訊電機館到目的地的距離為 " + String.format("%.1f", distance[0]) + " 公尺" , Toast.LENGTH_LONG).show();
            }

            @Override
            public void onCancel() {

            }
        });
    }

    int c = 0;

    public void button(View v) {
        c++;
        int count = c % 4;
        if(count == 0){
            mMap.setMapType(GoogleMap.MAP_TYPE_NORMAL);
        }
        else if (count == 1){
            mMap.setMapType(GoogleMap.MAP_TYPE_SATELLITE);
        }
        else if (count == 2){
            mMap.setMapType(GoogleMap.MAP_TYPE_HYBRID);
        }
        else if (count == 3){
            mMap.setMapType(GoogleMap.MAP_TYPE_TERRAIN);
        }
    }
}