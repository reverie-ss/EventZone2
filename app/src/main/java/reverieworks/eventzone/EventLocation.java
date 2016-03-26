package reverieworks.eventzone;

import android.content.Intent;
import android.os.Bundle;
import android.support.v4.app.FragmentActivity;

import com.google.android.gms.maps.CameraUpdateFactory;
import com.google.android.gms.maps.GoogleMap;
import com.google.android.gms.maps.OnMapReadyCallback;
import com.google.android.gms.maps.SupportMapFragment;
import com.google.android.gms.maps.model.LatLng;
import com.google.android.gms.maps.model.MarkerOptions;

public class EventLocation extends FragmentActivity implements OnMapReadyCallback {

    private GoogleMap mMap;
    double latitude,longitude;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_event_location);

        Intent intent_map = getIntent();
        latitude = intent_map.getDoubleExtra("latitude_key2",22.0);
        longitude = intent_map.getDoubleExtra("longitude_key2",85.0);

        // Obtain the SupportMapFragment and get notified when the map is ready to be used.
        SupportMapFragment mapFragment = (SupportMapFragment) getSupportFragmentManager()
                .findFragmentById(R.id.map);
        mapFragment.getMapAsync(this);
    }

    @Override
    protected void  onResume()
    {
        super.onResume();
        setUpMapIfNeeded();

    }

    private void setUpMapIfNeeded() {

        if (mMap == null)
            mMap = ((SupportMapFragment)getSupportFragmentManager().findFragmentById(R.id.map)).getMap();

        if(mMap != null) {
            setUpMap();
        }

    }
    //21.4976078,83.9040135
    private void setUpMap() {
        LatLng place = new LatLng(latitude,longitude);
        mMap.addMarker(new MarkerOptions().position(place).title("This is awesome"));
        mMap.moveCamera(CameraUpdateFactory.newLatLng(place));
        mMap.setMyLocationEnabled(true);
        mMap.animateCamera(CameraUpdateFactory.zoomTo(16.0f));
        mMap.setContentDescription("thanks for visiting");
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
    }
}
