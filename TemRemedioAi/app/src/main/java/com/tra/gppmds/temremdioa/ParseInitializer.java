package com.tra.gppmds.temremdioa;

import com.parse.Parse;

/**
 * Created by Vinicius on 18/04/2016.
 */
public class ParseInitializer extends android.app.Application {

    @Override
    public void onCreate(){
        super.onCreate();

        // Establish connection with parse server
        Parse.initialize(new Parse.Configuration.Builder(this)
                .applicationId("TemRemedioAi")
                .server("http://temremedioai.herokuapp.com/temremedioai/Class")
                .clientKey("kijasijijasiasjsiajalllkaosiajhsis")

                .build()
        );

    }

}
