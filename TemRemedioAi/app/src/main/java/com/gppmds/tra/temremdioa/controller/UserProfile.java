package com.gppmds.tra.temremdioa.controller;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

import com.parse.ParseUser;
import com.tra.gppmds.temremdioa.R;

public class UserProfile extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.user_profile);

        // Buttons
        Button logout = (Button) findViewById(R.id.user_profile_logout_button);
        Button cancel = (Button) findViewById(R.id.user_profile_cancel_button);

        cancel.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                finish();
            }
        });

        logout.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                ParseUser currentUser = ParseUser.getCurrentUser();
                if (currentUser != null) {
                    ParseUser.logOut();
                    finish();
                } else {
                    // show the signup or login screen
                }

            }
        });


    }
}
