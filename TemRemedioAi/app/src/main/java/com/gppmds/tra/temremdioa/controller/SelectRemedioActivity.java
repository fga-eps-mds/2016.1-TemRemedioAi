package com.gppmds.tra.temremdioa.controller;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.util.Log;
import android.widget.TextView;

import com.gppmds.tra.temremdioa.controller.adapter.CardListAdapterMedicine;
import com.gppmds.tra.temremdioa.model.Medicine;
import com.parse.ParseException;
import com.parse.ParseQuery;
import com.tra.gppmds.temremdioa.R;

import java.util.Arrays;
import java.util.List;

public class SelectRemedioActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_select_remedio);

        getSupportActionBar().setDisplayHomeAsUpEnabled(true);

        RecyclerView recyclerView = (RecyclerView) findViewById(R.id.recycler_view);
        recyclerView.setHasFixedSize(true);

        LinearLayoutManager llm = new LinearLayoutManager(getApplicationContext());
        recyclerView.setLayoutManager(llm);

        //Getting UBS description from UBS holder
        String ubsName = getIntent().getStringExtra("nomeUBS");
        String ubsAttentionLevel = getIntent().getStringExtra("nivelAtencao");
        String attentionLevelFilters[] = ubsAttentionLevel.split(",");

        //Getting UBS attention level count
        for(int i = 0; i < attentionLevelFilters.length; i++) {
            Log.i("CLAUS WHERE", "Nível de atenção da UBS " + i + ": " + attentionLevelFilters[i]);
        }

        TextView textViewSelectedMedicine = (TextView) findViewById(R.id.textViewSelectedUBS);
        textViewSelectedMedicine.setText(ubsName);

        //Query medicine data from parse
        ParseQuery<Medicine> queryMedicine = Medicine.getQuery();
        queryMedicine.whereContainedIn(Medicine.getMedicineAttentionLevelTitle(), Arrays.asList(attentionLevelFilters));
        queryMedicine.orderByAscending(Medicine.getMedicineDescriptionTitle());
        List<Medicine> medicines;
        try {
            medicines = queryMedicine.find();

            CardListAdapterMedicine claMedicine = new CardListAdapterMedicine(SelectRemedioActivity.this, medicines);
            claMedicine.setShowButtonUBSs(false);
            recyclerView.setAdapter(claMedicine);

            TextView textViewMedicineQuantity = (TextView) findViewById(R.id.textViewMedicineQuantity);
            textViewMedicineQuantity.setText("Encontrado(s): " + medicines.size());
        } catch (ParseException e) {
            e.printStackTrace();
        }
    }
}
