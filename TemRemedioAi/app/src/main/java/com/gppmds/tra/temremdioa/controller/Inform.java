package com.gppmds.tra.temremdioa.controller;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;
import android.widget.DatePicker;
import android.widget.RadioButton;
import android.widget.TextView;
import android.widget.Toast;

import com.gppmds.tra.temremdioa.model.Notification;
import com.parse.ParseUser;
import com.tra.gppmds.temremdioa.R;

import java.util.Calendar;
import java.util.GregorianCalendar;

public class Inform extends AppCompatActivity {

    TextView textViewInformedMedicine;
    TextView textViewInformedUbs;
    TextView textViewAvailableError;
    RadioButton radioButtonAvailable;
    RadioButton radioButtonNotAvailable;
    Button informButton;
    Button cancelButton;
    DatePicker datePickerInform;

    private Boolean availability;
    private String ubsName;
    private String medicineName;
    private String medicineDos;

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

        informButton = (Button) findViewById(R.id.inform_button);
        informButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if (validateInform()) {
                    attemptInform();
                    Toast.makeText(view.getContext(), "Informação enviada com sucesso.", Toast.LENGTH_LONG).show();
                    finish();
                } else {
                    Toast.makeText(view.getContext(), "Não foi possível completar a ação.", Toast.LENGTH_LONG).show();
                }
            }
        });

        ubsName = getIntent().getStringExtra("UBSName");
        medicineName = getIntent().getStringExtra("MedicineName");
        medicineDos = getIntent().getStringExtra("MedicineDos");

        textViewInformedMedicine = (TextView) findViewById(R.id.informed_medicine);
        textViewInformedMedicine.setText(medicineName);
        textViewInformedUbs = (TextView) findViewById(R.id.informed_ubs);
        textViewInformedUbs.setText(ubsName);
//        textViewAvailableError = (TextView) findViewById(R.id.)

        radioButtonAvailable = (RadioButton) findViewById(R.id.available);
        radioButtonNotAvailable = (RadioButton) findViewById(R.id.not_available);

        datePickerInform = (DatePicker) findViewById(R.id.date_picker_inform);
    }

    private void attemptInform() {

        if (radioButtonAvailable.isChecked()) {
            availability = true;
        } else if (radioButtonNotAvailable.isChecked()) {
            availability = false;
        } else {
            availability = false;
        }

        Integer selectedYear = datePickerInform.getYear();
        Integer selectedMonth = datePickerInform.getMonth();
        Integer selectedDay = datePickerInform.getDayOfMonth();

        Calendar calendar = new GregorianCalendar();
        calendar.set(selectedYear, selectedMonth, selectedDay);

        ParseUser getCurrentUser = ParseUser.getCurrentUser();

        Notification notification = new Notification();
        notification.setMedicineDosage(medicineDos);
        notification.setMedicineName(medicineName);
        notification.setUBSName(ubsName);
        notification.setAvailable(availability);
        notification.setDateInform(calendar.getTime());
        notification.setUserInform(getCurrentUser.getUsername());
        notification.pinInBackground();
        notification.saveInBackground();
    }

    private boolean validateInform() {
        boolean returnValidate = true;
        if (!radioButtonAvailable.isChecked() && !radioButtonNotAvailable.isChecked()) {
            radioButtonAvailable.setError("Disponibilidade não selecionada");
            returnValidate = false;
        }
        // Validar data;

        return returnValidate;
    }

}
