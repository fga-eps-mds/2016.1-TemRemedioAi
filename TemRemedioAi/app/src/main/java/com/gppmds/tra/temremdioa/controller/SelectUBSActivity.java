package com.gppmds.tra.temremdioa.controller;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.util.Log;
import android.widget.TextView;

import com.gppmds.tra.temremdioa.controller.adapter.CardListAdapterUBS;
import com.gppmds.tra.temremdioa.model.UBS;
import com.parse.ParseException;
import com.parse.ParseQuery;
import com.tra.gppmds.temremdioa.R;

import java.util.Arrays;
import java.util.List;

public class SelectUBSActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_select_ubs);

        getSupportActionBar().setDisplayHomeAsUpEnabled(true);

        RecyclerView recyclerView = (RecyclerView) findViewById(R.id.ubs_recycler_view);
        recyclerView.setHasFixedSize(true);

        LinearLayoutManager llm = new LinearLayoutManager(getApplicationContext());
        recyclerView.setLayoutManager(llm);

        /* Getting medicine description from medicine holder */
        String mecicineName = getIntent().getStringExtra("nomeRemedio");
        String medicineAttentionLevel = getIntent().getStringExtra("nivelAtencao");
        String[] attentionLevelFilters = medicineAttentionLevel.split(",");

        /* Getting attention level count */
        for(int i = 0; i < attentionLevelFilters.length; i++) {
            if ("HO".equalsIgnoreCase(attentionLevelFilters[i])) {
                attentionLevelFilters[i] = "HO,AB";
            }
            Log.i("CLAUS WHERE", "Nível de atenção do Remédio " + i + ": " + attentionLevelFilters[i]);
        }
        TextView textViewMedicineSelected = (TextView) findViewById(R.id.textViewMedicineSelected);
        textViewMedicineSelected.setText(mecicineName);

        /* Query ubs data from parse */
        ParseQuery<UBS> queryUBS = UBS.getQuery();
        queryUBS.whereContainedIn(UBS.getUbsAttentionLevelTitle(), Arrays.asList(attentionLevelFilters));
        queryUBS.orderByAscending(UBS.getUbsNameTitle());
        List<UBS> ubsList;

        try {
            ubsList = queryUBS.find();

            CardListAdapterUBS claUbs = new CardListAdapterUBS(SelectUBSActivity.this, ubsList);
            claUbs.setShowButtonMedicines(false);
            recyclerView.setAdapter(claUbs);

            TextView textViewUbsQuantity = (TextView) findViewById(R.id.textViewUbsQuantity);
            textViewUbsQuantity.setText("Encontrada(s): " + ubsList.size());
        } catch (ParseException e) {
            e.printStackTrace();
        }
    }
}
