//MODEL
package com.gppmds.tra.temremdioa.model;

import com.parse.ParseClassName;
import com.parse.ParseObject;
import com.parse.ParseQuery;

/**
 * Created by Maria Carolina  on 21/04/2016.
 * Update  by Maria Carolina on 30/04/2016.
 */
@ParseClassName("UBS")
public class UBS extends ParseObject {
    public Double getLatitude(){
        return getDouble(getTitleLatitude());
    }
    public void setLatitude(Double vlr_latitude){
        put(getTitleLatitude(), vlr_latitude);
    }

    public Double getLongitude(){
        return getDouble(getTitleLongitude());
    }
    public void setLongitude(Double vlr_longitude){
        put(getTitleLongitude(), vlr_longitude);
    }

    public String getNomEstab(){
        return getString(getTitleNomEstab());
    }
    public void setNomEstab(String name){
        put(getTitleNomEstab(), name);
    }

    public String getDscEndereco(){
        return getString(getTitleDscEndereco());
    }
    public void setDscEndereco(String dsc_endereco){
        put(getTitleDscEndereco(), dsc_endereco);
    }

    public String getDscBairro(){
        return getString(getTitleDscBairro());
    }
    public void setDscBairro(String dsc_bairro){
        put(getTitleDscBairro(), dsc_bairro);
    }

    public String getDscCidade(){
        return getString(getTitleDscCidade());
    }
    public void setDscCidade(String dsc_cidade){
        put(getTitleDscCidade(), dsc_cidade);
    }

    public String getNivelAt(){
        return getString(getTitleNivelAt());
    }
    public void setNivelAt(String nivel_at){
        put(getTitleNivelAt(), nivel_at);
    }

    public static ParseQuery<UBS> getQuery() {
        return ParseQuery.getQuery(UBS.class);
    }

    public static String getTitleLongitude(){
        return "vlr_longitude";
    }
    public static String getTitleLatitude(){
        return "vlr_latitude";
    }
    public static String getTitleNomEstab(){
        return "nom_estab";
    }
    public static String getTitleDscEndereco(){
        return "dsc_endereco";
    }
    public static String getTitleDscBairro(){
        return "dsc_bairro";
    }
    public static String getTitleDscCidade(){ return "dsc_cidade"; }
    public static String getTitleNivelAt(){
        return "nivel_at";
    }

    @Override
    public String toString(){
        return getString(getTitleNomEstab());
    }
}
