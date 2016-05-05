package com.gppmds.tra.temremdioa.controller;

import android.support.v4.app.FragmentActivity;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.Window;
import android.widget.TextView;

import com.google.android.gms.maps.CameraUpdateFactory;
import com.google.android.gms.maps.GoogleMap;
import com.google.android.gms.maps.MapFragment;
import com.google.android.gms.maps.OnMapReadyCallback;
import com.google.android.gms.maps.SupportMapFragment;
import com.google.android.gms.maps.model.LatLng;
import com.google.android.gms.maps.model.MarkerOptions;
import com.gppmds.tra.temremdioa.model.UBS;
import com.tra.gppmds.temremdioa.R;

public class UbsMapsActivity extends AppCompatActivity implements OnMapReadyCallback {

    private GoogleMap mMap;
    private UBS ubsSelecionada;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_ubs_maps);

        // Obtain the SupportMapFragment and get notified when the map is ready to be used.
        MapFragment mapFragment = (MapFragment) getFragmentManager().findFragmentById(R.id.map);
        mapFragment.getMapAsync(this);

        ubsSelecionada = (UBS) getIntent().getSerializableExtra("UBS");

        TextView editTitulo = (TextView) findViewById(R.id.textViewTitleUbs);
        editTitulo.setText(ubsSelecionada.getNomEstab());

        TextView editDscEndereco = (TextView) findViewById(R.id.textViewDscEndereco);
        editDscEndereco.setText(ubsSelecionada.getDscEndereco());

        TextView editDscBairro = (TextView) findViewById(R.id.textViewDscBairro);
        editDscBairro.setText(ubsSelecionada.getDscBairro());

        TextView editDscTelefone = (TextView) findViewById(R.id.textViewDscTelefone);
        editDscTelefone.setText(ubsSelecionada.getDscTelefone());

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

        // Add a marker in Sydney and move the camera
        LatLng latLngValues = new LatLng(ubsSelecionada.getLatitude(), ubsSelecionada.getLongitude());
        mMap.addMarker(new MarkerOptions().position(latLngValues).title("Marker of UBS"));
        mMap.moveCamera(CameraUpdateFactory.newLatLngZoom(latLngValues, 15));
    }

}
