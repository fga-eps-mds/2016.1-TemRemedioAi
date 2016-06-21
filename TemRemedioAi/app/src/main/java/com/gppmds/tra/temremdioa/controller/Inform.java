package com.gppmds.tra.temremdioa.controller;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.SearchView;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.RadioButton;
import android.widget.Spinner;
import android.widget.TextView;

import com.gppmds.tra.temremdioa.model.Remedio;
import com.parse.ParseQuery;
import com.tra.gppmds.temremdioa.R;

public class Inform extends AppCompatActivity {

    TextView informedMedicineTextView;
    TextView informedUbsTextView;
    RadioButton available;
    RadioButton notAvailable;
    Button informButton;
    Button cancelButton;
    Integer availability;
    TextView availableError;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.inform);

        cancelButton= (Button) findViewById(R.id.cancel_button);
        cancelButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                finish();
            }
        });

        String ubsName = getIntent().getStringExtra("UBSName");
        String medicineName= getIntent().getStringExtra("MedicineName");
        String medicineDos= getIntent().getStringExtra("MedicineDos");

        informButton = (Button) findViewById(R.id.inform_button);
        informedMedicineTextView = (TextView) findViewById(R.id.informed_medicine);
        informedMedicineTextView.setText(medicineName);
        informedUbsTextView = (TextView) findViewById(R.id.informed_ubs);
        informedUbsTextView.setText(ubsName);
        available = (RadioButton) findViewById(R.id.available);
        notAvailable = (RadioButton) findViewById(R.id.not_available);
    }

    private void attemptInform() {

        // Radio Button
        if (!available.isChecked() && !notAvailable.isChecked()) {
            availableError.setError("Disponibilidade não selecionada");
        } else if (available.isChecked()) {
            availability = 1;
        } else if (notAvailable.isChecked()) {
            availability = 0;
        }

        // TextView of Medicine
        informedMedicineTextView = (TextView) findViewById(R.id.informed_medicine);

        // TextView of Ubs
        informedUbsTextView = (TextView)findViewById(R.id.informed_ubs);

    }

}
