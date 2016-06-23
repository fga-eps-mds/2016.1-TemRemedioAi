package com.gppmds.tra.temremdioa.controller;

import com.gppmds.tra.temremdioa.model.Medicine;
import com.gppmds.tra.temremdioa.model.Notification;
import com.gppmds.tra.temremdioa.model.UBS;
import com.parse.Parse;
import com.parse.ParseFacebookUtils;
import com.parse.ParseObject;
import com.parse.ParseUser;

public class ParseInitializer extends android.app.Application {

    @Override
    public void onCreate(){
        super.onCreate();

        registerParserSubClasses();
        inicializeParser();
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
            Parse.enableLocalDatastore(this);
            Parse.initialize(new Parse.Configuration.Builder(this)
                    .applicationId("TemRemedioAi")
                    .server("http://temremedioai.herokuapp.com/temremedioai/Class")
                    .clientKey("kijasijijasiasjsiajalllkaosiajhsis")
                    .build()
            );
            ParseUser.enableAutomaticUser();
            ParseFacebookUtils.initialize(this);


            return true;
        } catch (Exception e) {
            return false;
        }
    }

}
