package com.gppmds.tra.temremdioa.model;

import com.parse.ParseClassName;
import com.parse.ParseObject;
import com.parse.ParseQuery;

import java.util.Date;

/**
 * Created by Usuário on 21/06/2016.
 */
@ParseClassName("Notification")
public class Notification extends ParseObject {

    public String getMedicineName(){
        return getString(getTitleMedicineName());
    }
    public void setMedicineName(String medicine_name){
        put(getTitleMedicineName(), medicine_name);
    }

    public String getMedicineDosage(){
        return getString(getTitleMedicineDosage());
    }
    public void setMedicineDosage(String medicine_dosage){
        put(getTitleMedicineDosage(), medicine_dosage);
    }

    public String getUBSName(){
        return getString(getTitleUBSName());
    }
    public void setUBSName(String ubs_name){
        put(getTitleUBSName(), ubs_name);
    }

    public Date getDateInform(){
        return getDate(getTitleDateInform());
    }
    public void setDateInform(Date date_inform){
        put(getTitleDateInform(), date_inform);
    }

    public Boolean getAvailable(){
        return getBoolean(getTitleAvailable());
    }
    public void setAvailable(Boolean available){
        put(getTitleAvailable(), available);
    }

    public String getUserInform(){
        return getString(getTitleUser());
    }
    public void setUserInform(String code){
        put(getTitleUser(), code);
    }

    public static ParseQuery<Notification> getQuery() {
        return ParseQuery.getQuery(Notification.class);
    }

    public static String getTitleMedicineName(){
        return "medicine_name";
    }
    public static String getTitleMedicineDosage(){
        return "medicine_dosage";
    }
    public static String getTitleUBSName(){
        return "ubs_name";
    }
    public static String getTitleDateInform(){
        return "data_inform";
    }
    public static String getTitleAvailable(){
        return "medicine_available";
    }
    public static String getTitleUser(){ return "user_inform"; }

    @Override
    public String toString(){
        return getString(getTitleMedicineName());
    }

}
