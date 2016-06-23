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

import java.util.ArrayList;
import java.util.List;

public class SelectUBSActivity extends AppCompatActivity {

    private ArrayList<String> filterAttentionLevel;
    private String medicineName;
    private String medicineAttentionLevel;
    private String medicineDosage;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_select_ubs);

        getSupportActionBar().setDisplayHomeAsUpEnabled(true);

        setMedicineInfo();

        try {
            setTextViewSelectedMedicine(getMedicineName());
        } catch (Exception e) {

        }


        CardListAdapterUBS claUbs = new CardListAdapterUBS(SelectUBSActivity.this, getListOfUbs(getFilterAttentionLevel()));
        claUbs.setShowButtonMedicines(false);
        claUbs.setShowButtonInform(true);
        claUbs.setMedicineName(getMedicineName());
        claUbs.setMedicineDos(getMedicineDosage());

        try {
            createRecyclerView(claUbs);
        } catch (Exception e) {

        }

        try {
            setTextViewUbsQuantityFound(claUbs.getItemCount());
        } catch (Exception e) {

        }
    }

    public LinearLayoutManager createLinearLayoutManager() {
        LinearLayoutManager llm = new LinearLayoutManager(getApplicationContext());
        return llm;
    }

    public void createRecyclerView(CardListAdapterUBS cardListAdapterUBS) throws Exception {
        RecyclerView recyclerView = (RecyclerView) findViewById(R.id.ubs_recycler_view);
        if (recyclerView != null) {
            recyclerView.setLayoutManager(createLinearLayoutManager());
            recyclerView.setAdapter(cardListAdapterUBS);
            recyclerView.setHasFixedSize(true);
        } else {
            throw new Exception("Fail to found ubs_recycler_view");
        }
    }

    public List<UBS> getListOfUbs(ArrayList<String> filterAttentionLevel) {
        /* Query ubs data from parse */
        ParseQuery<UBS> queryUBS = UBS.getQuery();
        queryUBS.whereContainedIn(UBS.getUbsAttentionLevelTitle(), filterAttentionLevel);
        queryUBS.orderByAscending(UBS.getUbsNameTitle());
        queryUBS.fromLocalDatastore();
        List<UBS> ubsList = null;

        try {
            ubsList = queryUBS.find();
        } catch (ParseException e) {
            e.printStackTrace();
        }

        return ubsList;
    }

    private void setTextViewSelectedMedicine(String medicineSelected) throws Exception {
        TextView textViewMedicineSelected = (TextView) findViewById(R.id.textViewMedicineSelected);
        if (textViewMedicineSelected != null) {
            textViewMedicineSelected.setText(medicineSelected);
        } else {
            throw new Exception("Fail to found textViewMedicineSelected");
        }
    }

    private void setTextViewUbsQuantityFound(int quantityFound) throws Exception {
        TextView textViewUbsQuantity = (TextView) findViewById(R.id.textViewUbsQuantity);
        if (textViewUbsQuantity != null) {
            textViewUbsQuantity.setText("Encontrada(s): " + quantityFound);
        } else {
            throw new Exception("Fail to found textViewUbsQuantity");
        }
    }

    public void setMedicineInfo() {
        setMedicineName(getIntent().getStringExtra("nomeRemedio"));
        setMedicineDosage(getIntent().getStringExtra("medicineDos"));
        setMedicineAttentionLevel(getIntent().getStringExtra("nivelAtencao"));
        setFilterAttentionLevel(getMedicineAttentionLevel());
    }

    public void setFilterAttentionLevel(String medicineAttentionLevel) {
        String[] attentionLevelFilters = medicineAttentionLevel.split(",");

        /* Getting attention level count */
        filterAttentionLevel = new ArrayList<String>();
        for(int i = 0; i < attentionLevelFilters.length; i++) {
            if ("HO".equalsIgnoreCase(attentionLevelFilters[i])) {
                attentionLevelFilters[i] = "HO,AB";
            }
            Log.i("CLAUS WHERE", "Nível de atenção do Remédio " + i + ": "
                    + attentionLevelFilters[i]);
            filterAttentionLevel.add(attentionLevelFilters[i]);
        }
    }

    public ArrayList<String> getFilterAttentionLevel() {
        return filterAttentionLevel;
    }

    public void setMedicineName(String medicineName) {
        this.medicineName = medicineName;
    }

    public void setMedicineDosage(String medicineDosage) {
        this.medicineDosage = medicineDosage;
    }

    public void setMedicineAttentionLevel(String medicineAttentionLevel) {
        this.medicineAttentionLevel = medicineAttentionLevel;
    }

    public String getMedicineAttentionLevel() {
        return this.medicineAttentionLevel;
    }

    public String getMedicineName() {
        return this.medicineName;
    }
    public String getMedicineDosage() {
        return this.medicineDosage;
    }
}
