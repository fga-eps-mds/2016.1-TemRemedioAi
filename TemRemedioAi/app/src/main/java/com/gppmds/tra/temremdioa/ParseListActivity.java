package com.gppmds.tra.temremdioa;

import android.app.ListActivity;
import android.net.Uri;
import android.os.Bundle;
import android.widget.ArrayAdapter;
import android.widget.Toast;

import com.google.android.gms.appindexing.Action;
import com.google.android.gms.appindexing.AppIndex;
import com.google.android.gms.common.api.GoogleApiClient;
import com.parse.FindCallback;
import com.parse.ParseException;
import com.parse.ParseQuery;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by Usuário on 21/04/2016.
 */

public class ParseListActivity extends ListActivity {
    List<UBS> listaUBS = new ArrayList<UBS>();
    //List<Remedio> listaRemedio = new ArrayList<Remedio>();

    /**
     * ATTENTION: This was auto-generated to implement the App Indexing API.
     * See https://g.co/AppIndexing/AndroidStudio for more information.
     */
    private GoogleApiClient client;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        ParseQuery<UBS> query = new ParseQuery<UBS>("UBS");

        query.findInBackground(new FindCallback<UBS>() {
            @Override
            public void done(List<UBS> list, ParseException e) {
                // tentando entender isso aqui
                if (e != null) {
                    Toast.makeText(ParseListActivity.this, "Error" + e, Toast.LENGTH_SHORT).show();
                } else {
                    // Nothing to do
                }
                for (UBS ubs : list) {
                    UBS newUBS = new UBS();
                    newUBS.setLatitude(ubs.getLatitude());
                    newUBS.setLongitude(ubs.getLongitude());
                    newUBS.setCodMunic(ubs.getCodMunic());
                    newUBS.setCod_cnes(ubs.getCodCnes());
                    newUBS.setNomEstab(ubs.getNomEstab());
                    newUBS.setDscEndereco(ubs.getDscEndereco());
                    newUBS.setDscBairro(ubs.getDscBairro());
                    newUBS.setDscCidade(ubs.getDscCidade());
                    newUBS.setDscTelefone(ubs.getDscTelefone());
                    newUBS.setDscEstrutFisicAmbiencia(ubs.getDscEstrutFisicAmbiencia());
                    newUBS.setDscAdapDeficFisicIdosos(ubs.getDscAdapDeficFisicIdosos());
                    newUBS.setDscEquipamentos(ubs.getDscEquipamentos());
                    newUBS.setDscMedicamentos(ubs.getDscMedicamentos());
                    listaUBS.add(newUBS);
                }

                ArrayAdapter<UBS> adapter = new ArrayAdapter<UBS>(ParseListActivity.this, android.R.layout.simple_expandable_list_item_1, listaUBS);
                setListAdapter(adapter);
            }
        });
        // ATTENTION: This was auto-generated to implement the App Indexing API.
        // See https://g.co/AppIndexing/AndroidStudio for more information.
        client = new GoogleApiClient.Builder(this).addApi(AppIndex.API).build();
    }
}

