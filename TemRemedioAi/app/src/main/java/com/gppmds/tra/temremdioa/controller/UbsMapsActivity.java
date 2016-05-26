package com.gppmds.tra.temremdioa.controller;

import android.content.DialogInterface;
import android.content.Intent;
import android.content.pm.ApplicationInfo;
import android.content.pm.PackageManager;
import android.net.Uri;
import android.os.Bundle;
import android.support.design.widget.FloatingActionButton;
import android.support.v7.app.AlertDialog;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.TextView;

import com.google.android.gms.maps.CameraUpdateFactory;
import com.google.android.gms.maps.GoogleMap;
import com.google.android.gms.maps.MapFragment;
import com.google.android.gms.maps.OnMapReadyCallback;
import com.google.android.gms.maps.model.LatLng;
import com.google.android.gms.maps.model.MarkerOptions;
import com.tra.gppmds.temremdioa.R;

public class UbsMapsActivity extends AppCompatActivity implements OnMapReadyCallback {

    private GoogleMap mMap;
    private Double latitude;
    private Double longitude;
    private String ubsName;
    FloatingActionButton generateTrajectory;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_ubs_maps);

        // Obtain the SupportMapFragment and get notified when the map is ready to be used.
        MapFragment mapFragment = (MapFragment) getFragmentManager().findFragmentById(R.id.map);
        mapFragment.getMapAsync(this);

        //Getting UBS descriptions from UBS Holder class
        ubsName = getIntent().getStringExtra("nomeUBS");
        String descUbsAddress = getIntent().getStringExtra("descEnderecoUBS");
        String descUbsNeighborhood = getIntent().getStringExtra("descBairroUBS");
        String descUbsCity = getIntent().getStringExtra("descCidadeUBS");
        // String telefoneUBS = getIntent().getStringExtra("telefoneUBS");
        latitude = getIntent().getDoubleExtra("latitude", 0);
        longitude = getIntent().getDoubleExtra("longitude", 0);

        TextView editName = (TextView) findViewById(R.id.textViewUbsName);
        editName.setText(ubsName);

        TextView editDscAddress = (TextView) findViewById(R.id.textViewDscAddress);
        editDscAddress.setText(descUbsAddress);

        TextView editDscNeighborhood = (TextView) findViewById(R.id.textViewDscNeighborhood);
        editDscNeighborhood.setText(descUbsNeighborhood);

        TextView editDscCity = (TextView) findViewById(R.id.textViewCityUbs);
        editDscCity.setText(descUbsCity);

        generateTrajectory = (FloatingActionButton) findViewById(R.id.direction);
        generateTrajectory.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                setUpMapIfNeeded();

            }
        });

    }

    private void setUpMapIfNeeded() {


        if(isGoogleMapsInstalled())
        {
            //Get latitude and longitude from ubs Holder and open with GMaps
            String uri = "http://maps.google.com/maps?saddr="+"&daddr="+latitude+","+longitude;
            Intent intent = new Intent(android.content.Intent.ACTION_VIEW, Uri.parse(uri));
            intent.setClassName("com.google.android.apps.maps", "com.google.android.maps.MapsActivity");
            startActivity(intent);

        }
        else
        {
            AlertDialog.Builder builder = new AlertDialog.Builder(this);
            builder.setMessage("Instalar Google Maps");
            builder.setCancelable(true);
            builder.setNegativeButton("Cancelar",null);
            builder.setPositiveButton("Instalar", getGoogleMapsListener());
            AlertDialog dialog = builder.create();
            dialog.show();
        }
    }


    public boolean isGoogleMapsInstalled()
    {
        try
        {
            ApplicationInfo info = getPackageManager().getApplicationInfo("com.google.android.apps.maps", 0 );
            return true;
        }
        catch(PackageManager.NameNotFoundException e)
        {
            return false;
        }
    }

    public DialogInterface.OnClickListener getGoogleMapsListener()
    {
        return new DialogInterface.OnClickListener()
        {
            @Override
            public void onClick(DialogInterface dialog, int which)
            {
                Intent intent = new Intent(Intent.ACTION_VIEW, Uri.parse("market://details?id=com.google.android.apps.maps"));
                startActivity(intent);

                //Finish the activity so they can't circumvent the check
                finish();
            }
        };
    }

    @Override
    public void onMapReady(GoogleMap googleMap) {
        mMap = googleMap;
        //Get latitude and longitude to create a marker on map
        LatLng latLngValues = new LatLng(latitude, longitude);
        mMap.addMarker(new MarkerOptions().position(latLngValues).title(ubsName));
        mMap.moveCamera(CameraUpdateFactory.newLatLngZoom(latLngValues, 13));
    }

}
