package com.gppmds.tra.temremdioa.controller;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;

import com.tra.gppmds.temremdioa.R;

import java.util.Timer;
import java.util.TimerTask;

public class SplashScreenActivity extends Activity {

    private static final int waitTime = 2000;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_splash_screen);

        new Timer().schedule(new TimerTask() {
            @Override
            public void run() {
                Intent intent = new Intent(SplashScreenActivity.this, MainActivity.class);
                startActivity(intent);
                finish();
            }
        }, waitTime);
    }
}
