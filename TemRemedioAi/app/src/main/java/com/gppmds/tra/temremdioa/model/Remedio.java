//MODEL
package com.gppmds.tra.temremdioa.model;

import com.parse.ParseClassName;
import com.parse.ParseObject;
import com.parse.ParseQuery;

@ParseClassName("Medicamentos")
public class Remedio extends ParseObject {
    public String getCodSes(){
        return getString(getTitleCodSes());
    }
    public void setCodSes(String cod_ses){
        put(getTitleCodSes(), cod_ses);
    }

    public String getMedDes(){
        return getString(getTitleMedDes());
    }
    public void setMedDes(String med_des){
        put(getTitleMedDes(), med_des);
    }

    public String getUnid(){
        return getString(getTitleUnid());
    }
    public void setUnid(String unid){
        put(getTitleUnid(), unid);
    }

    public String getNivelAt(){
        return getString(getTitleNivelAt());
    }
    public void setNivelAt(String nivel_at){
        put(getTitleNivelAt(), nivel_at);
    }

    public static ParseQuery<Remedio> getQuery() {
        return ParseQuery.getQuery(Remedio.class);
    }

    public static String getTitleCodSes(){
        return "cod_ses";
    }
    public static String getTitleMedDes(){
        return "med_des";
    }
    public static String getTitleUnid(){
        return "unid";
    }
    public static String getTitleNivelAt(){
        return "nivel_at";
    }

    @Override
    public String toString() {
        return getString(getTitleMedDes());
    }
}
