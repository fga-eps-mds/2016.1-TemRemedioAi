//MODEL
package com.gppmds.tra.temremdioa.model;

import com.parse.ParseClassName;
import com.parse.ParseObject;
import com.parse.ParseQuery;

@ParseClassName("UBS")
public class UBS extends ParseObject {

    //Returns the latitude of the establishment
    public Double getUbsLatitude(){
        return getDouble(getUbsLatitudeTitle());
    }

    //Sets a latitude to the establishment
    public void setUbsLatitude(Double ubsLatitude){
        put(getUbsLatitudeTitle(), ubsLatitude);
    }

    //Returns the longitude of the establishment
    public Double getUbsLongitude(){
        return getDouble(getUbsLongitudeTitle());
    }

    //Sets the longitude to the establishment
    public void setUbsLongitude(Double ubsLongitude){
        put(getUbsLongitudeTitle(), ubsLongitude);
    }

    //Returns the name of the establishment
    public String getUbsName(){
        return getString(getUbsNameTitle());
    }

    //Sets a name to the establishment
    public void setUbsName(String ubsName){
        put(getUbsNameTitle(), ubsName);
    }

    //Returns the address of the establishment
    public String getUbsAddress(){
        return getString(getUbsAddressTitle());
    }

    //Sets an address to the establishment
    public void setUbsAddress(String ubsAddress){
        put(getUbsAddressTitle(), ubsAddress);
    }

    //Returns the neighborhood of the establishment
    public String getUbsNeighborhood(){
        return getString(getUbsNeighborhoodTitle());
    }

    //Sets a neighborhood to the establishment
    public void setUbsNeighborhood(String ubsNeighborhood){
        put(getUbsNeighborhoodTitle(), ubsNeighborhood);
    }

    //Returns a city of the establishment
    public String getUbsCity(){
        return getString(getUbsCityTitle());
    }

    //Sets a city to the establishment
    public void setUbsCity(String ubsCity){
        put(getUbsCityTitle(), ubsCity);
    }

    //Returns the attention level of a establishment
    public String getUbsAttentionLevel(){
        return getString(getUbsAttentionLevelTitle());
    }

    //Sets an attention level to a
    public void setUbsAttentionLevel(String ubsAttentionLevel){
        put(getUbsAttentionLevelTitle(), ubsAttentionLevel);
    }

    //Returns the phone of a establishment
    public String getUbsPhone(){
        return getString(getUbsPhoneTitle());
    }

    //Sets the phone of the establishment
    public void setUbsPhone(String ubsPhone){
        put(getUbsPhoneTitle(), ubsPhone);
    }

    //Query UBS data from parse
    public static ParseQuery<UBS> getQuery() {
        return ParseQuery.getQuery(UBS.class);
    }

    //Returns the longitude title of a establishment
    public static String getUbsLongitudeTitle(){
        return "vlr_longitude";
    }

    //Returns the latitude title of a establishment
    public static String getUbsLatitudeTitle(){
        return "vlr_latitude";
    }

    //Returns the name title of a establishment
    public static String getUbsNameTitle(){
        return "nom_estab";
    }

    //Returns the address title of a establishment
    public static String getUbsAddressTitle(){
        return "dsc_endereco";
    }

    //Returns the neighborhood title of a establishment
    public static String getUbsNeighborhoodTitle(){
        return "dsc_bairro";
    }

    //Returns the city title of a establishment
    public static String getUbsCityTitle(){ return "dsc_cidade"; }

    //Returns the attention level title of a establishment
    public static String getUbsAttentionLevelTitle(){
        return "nivel_at";
    }

    //Returns the phone of a establishment
    public static String getUbsPhoneTitle() {
        return "telefone";
    }

    //Overrides the method to returns the description title of a establishment
    @Override
    public String toString(){
        return getString(getUbsNameTitle());
    }
}
