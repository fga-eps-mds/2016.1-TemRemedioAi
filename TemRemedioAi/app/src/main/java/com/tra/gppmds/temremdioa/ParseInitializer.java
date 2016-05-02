package com.tra.gppmds.temremdioa;

import com.gppmds.tra.temremdioa.model.UBS;
import com.parse.Parse;

import java.util.ArrayList;
import java.util.List;

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

    /*
    public static List<UBS> getData(){

    }*/

}
