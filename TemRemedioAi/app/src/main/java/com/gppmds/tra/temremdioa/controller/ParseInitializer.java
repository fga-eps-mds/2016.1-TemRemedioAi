package com.gppmds.tra.temremdioa.controller;

import com.gppmds.tra.temremdioa.model.Remedio;
import com.gppmds.tra.temremdioa.model.UBS;
import com.parse.Parse;
import com.parse.ParseObject;

/**
 * Created by Vinicius on 18/04/2016.
 */
public class ParseInitializer extends android.app.Application {

    @Override
    public void onCreate(){
        super.onCreate();

        ParseObject.registerSubclass(UBS.class);
        ParseObject.registerSubclass(Remedio.class);
        // Establish connection with parse server
        Parse.initialize(new Parse.Configuration.Builder(this)
                .applicationId("TemRemedioAi")
                .server("http://temremedioai.herokuapp.com/temremedioai/Class")
                .clientKey("kijasijijasiasjsiajalllkaosiajhsis")

                .build()
        );

    }

    /*
    public static List<UBS> getData(){

    }*/

}
