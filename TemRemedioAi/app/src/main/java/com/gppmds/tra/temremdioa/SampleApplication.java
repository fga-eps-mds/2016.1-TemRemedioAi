package com.gppmds.tra.temremdioa;

import android.app.Application;

import com.parse.Parse;
import com.parse.ParseObject;

/**
 * Created by Usuário on 21/04/2016.
 */
public class SampleApplication extends Application {
    public void OnCreate(){
        ParseObject.registerSubclass(UBS.class);
        ParseObject.registerSubclass(Remedio.class);
        //like what esse lance de Parse.initialize ?
        Parse.initialize(this, "TemRemedioAi", "kijasijijasiasjsiajalllkaosiajhsis");

    }
}
