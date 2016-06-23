package com.gppmds.tra.temremdioa.controller;

import com.gppmds.tra.temremdioa.model.Medicine;
import com.gppmds.tra.temremdioa.model.Notification;
import com.gppmds.tra.temremdioa.model.UBS;
import com.parse.FindCallback;
import com.parse.Parse;
import com.parse.ParseException;
import com.parse.ParseObject;
import com.parse.ParseQuery;

import java.util.List;

public class ParseInitializer extends android.app.Application {

    @Override
    public void onCreate(){
        super.onCreate();

        registerParserSubClasses();
        inicializeParser();

        loadLocalDateBaseMedicine();
        loadLocalDateBaseUBS();
        loadLocalDateBaseNotification();
    }

    public boolean registerParserSubClasses() {
        try {
            ParseObject.registerSubclass(UBS.class);
            ParseObject.registerSubclass(Medicine.class);
            ParseObject.registerSubclass(Notification.class);
            return true;
        } catch (Exception e) {
            return false;
        }
    }

    public boolean inicializeParser() {
        /* Establish connection with parse server */
        try {
            Parse.initialize(new Parse.Configuration.Builder(this)
                    .applicationId("TemRemedioAi")
                    .server("http://temremedioai.herokuapp.com/temremedioai/Class")
                    .clientKey("kijasijijasiasjsiajalllkaosiajhsis")
                    .enableLocalDataStore()
                    .build()
            );

            return true;
        } catch (Exception e) {
            return false;
        }
    }

    public boolean loadLocalDateBaseMedicine() {
        ParseQuery<Medicine> queryMedicine = Medicine.getQuery();
        queryMedicine.setLimit(1000);
        queryMedicine.findInBackground(new FindCallback<Medicine>() {
            @Override
            public void done(List<Medicine> list, ParseException e) {
                if (e != null) {
                    // Nothing to do
                } else {
                    Medicine.pinAllInBackground(list);
                }
            }
        });
        return true;
    }

    public boolean loadLocalDateBaseUBS() {
        ParseQuery<UBS> queryUBS = UBS.getQuery();
        queryUBS.setLimit(120);
        queryUBS.findInBackground(new FindCallback<UBS>() {
            @Override
            public void done(List<UBS> list, ParseException e) {
                if (e != null) {
                    // Nothing to do
                } else {
                    UBS.pinAllInBackground(list);
                }
            }
        });
        return true;
    }

    public boolean loadLocalDateBaseNotification() {
        ParseQuery<Notification> queryNotification = Notification.getQuery();
        queryNotification.setLimit(1000);
        queryNotification.findInBackground(new FindCallback<Notification>() {
            @Override
            public void done(List<Notification> list, ParseException e) {
                if (e != null) {
                    // Nothing to do
                } else {
                    Notification.pinAllInBackground(list);
                }
            }
        });

        return true;
    }
}
