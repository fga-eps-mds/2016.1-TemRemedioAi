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
        return getDouble("vlr_latitude");
    }

    public void setLatitude(Double vlr_latitude){
        put("vlr_latitude", vlr_latitude);
    }

    public Double getLongitude(){
        return getDouble("vlr_longitude");
    }

    public void setLongitude(Double vlr_longitude){
        put("vlr_longitude", vlr_longitude);
    }

    public String getNomEstab(){
        return getString("nom_estab");
    }

    public void setNomEstab(String name){
        put("nom_estab", name);
    }

    public String getDscEndereco(){
        return getString("dsc_endereco");
    }

    public void setDscEndereco(String dsc_endereco){
        put("dsc_endereco", dsc_endereco);
    }

    public String getDscBairro(){
        return getString("dsc_bairro");
    }

    public void setDscBairro(String dsc_bairro){
        put("dsc_bairro", dsc_bairro);
    }

    public String getDscCidade(){
        return getString("dsc_cidade");
    }

    public void setDscCidade(String dsc_cidade){
        put("dsc_cidade", dsc_cidade);
    }

    public String getNivelAt(){
        return getString("nivel_at");
    }

    public void setNivelAt(String nivel_at){
        put("nivel_at", nivel_at);
    }

    public static ParseQuery<UBS> getQuery() {
        return ParseQuery.getQuery(UBS.class);
    }

    @Override
    public String toString(){
        return getString("nom_estab");
    }
}
