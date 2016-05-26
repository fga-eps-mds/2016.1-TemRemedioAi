//MODEL
package com.gppmds.tra.temremdioa.model;

import com.parse.ParseClassName;
import com.parse.ParseObject;
import com.parse.ParseQuery;

@ParseClassName("UBS")
public class UBS extends ParseObject {

    //Returns the latitude of a establishment
    public Double getEstablishmentLatitude(){
        return getDouble(getEstablishmentLatitudeTitle());
    }

    //Sets a latitude to a establishment
    public void setEstablishmentLatitude(Double establishmentLatitude){
        put(getEstablishmentLatitudeTitle(), establishmentLatitude);
    }

    //Returns the longitude of a establishment
    public Double getEstablishmentLongitude(){
        return getDouble(getEstablishmentLongitudeTitle());
    }

    //Sets the longitude to a establishment
    public void setEstablishmentLongitude(Double establishmentLongitude){
        put(getEstablishmentLongitudeTitle(), establishmentLongitude);
    }

    //Returns the name of a establishment
    public String getEstablishmentName(){
        return getString(getEstablishmentNameTitle());
    }

    //Sets a name to a establishment
    public void setEstablishmentName(String establishmentName){
        put(getEstablishmentNameTitle(), establishmentName);
    }

    //Returns the address of a establishment
    public String getEstablishmentAddress(){
        return getString(getEstablishmentAddressTitle());
    }

    //Sets an address to a establishment
    public void setEstablishmentAddress(String establishmentAddress){
        put(getEstablishmentAddressTitle(), establishmentAddress);
    }

    //Returns the neighborhood of a establishment
    public String getEstablishmentNeighborhood(){
        return getString(getEstablishmentNeighborhoodTitle());
    }

    //Sets a neighborhood to a establishment
    public void setEstablishmentNeighborhood(String establishmentNeighborhood){
        put(getEstablishmentNeighborhoodTitle(), establishmentNeighborhood);
    }

    //Returns a city of a establishment
    public String getEstablishmentCity(){
        return getString(getEstablishmentCityTitle());
    }

    //Sets a city to a establishment
    public void setEstablishmentCity(String establishmentCity){
        put(getEstablishmentCityTitle(), establishmentCity);
    }

    //Returns the attention level of a establishment
    public String getEstablishmentAttentionLevel(){
        return getString(getEstablishmentAttentionLevelTitle());
    }

    //Sets an attention level to a
    public void setEstablishmentAttentionLevel(String establishmentAttentionLevel){
        put(getEstablishmentAttentionLevelTitle(), establishmentAttentionLevel);
    }

    //Returns the parse query of establishments
    public static ParseQuery<UBS> getQuery() {
        return ParseQuery.getQuery(UBS.class);
    }

    //Returns the longitude title of a establishment
    public static String getEstablishmentLongitudeTitle(){
        return "vlr_longitude";
    }

    //Returns the latitude title of a establishment
    public static String getEstablishmentLatitudeTitle(){
        return "vlr_latitude";
    }

    //Returns the name title of a establishment
    public static String getEstablishmentNameTitle(){
        return "nom_estab";
    }

    //Returns the address title of a establishment
    public static String getEstablishmentAddressTitle(){
        return "dsc_endereco";
    }

    //Returns the neighborhood title of a establishment
    public static String getEstablishmentNeighborhoodTitle(){
        return "dsc_bairro";
    }

    //Returns the city title of a establishment
    public static String getEstablishmentCityTitle(){ return "dsc_cidade"; }

    //Returns the attention level title of a establishment
    public static String getEstablishmentAttentionLevelTitle(){
        return "nivel_at";
    }

    //Overrides the method to returns the description title of a establishment
    @Override
    public String toString(){
        return getString(getEstablishmentNameTitle());
    }
}
