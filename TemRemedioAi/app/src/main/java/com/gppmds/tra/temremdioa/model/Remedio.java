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

    public String getMedDos(){
        return getString(getTitleMedDos());
    }
    public void setMedDos(String med_dos){
        put(getTitleMedDos(), med_dos);
    }

    public String getUnid(){
        return getString(getTitleUnid());
    }
    public String getUnidadeFormated(){
        String returnUnid = getString(getTitleUnid());
        switch (returnUnid) {
            case "AMP":
                returnUnid = "Ampola";
                break;
            case "BS":
                returnUnid = "Bisnaga";
                break;
            case "CJ":
                returnUnid = "Conjunto";
                break;
            case "CP":
                returnUnid = "Comprimido";
                break;
            case "CS":
                returnUnid = "Cápsula";
                break;
            case "CT":
                returnUnid = "Cartela";
                break;
            case "CX":
                returnUnid = "Caixa";
                break;
            case "DG":
                returnUnid = "Drageia";
                break;
            case "EN":
                returnUnid = "Envelope";
                break;
            case "FA":
                returnUnid = "Frasco-Ampola";
                break;
            case "FR":
                returnUnid = "Frasco";
                break;
            case "GL":
                returnUnid = "Galão";
                break;
            case "KT":
                returnUnid = "Kit";
                break;
            case "PT":
                returnUnid = "Pote";
                break;
            case "UM":
                returnUnid = "Unidade";
                break;
            case "UN":
                returnUnid = "Unidade";
                break;
            default:
                returnUnid = "Sem medição";
                break;
        }
        return returnUnid;
    }
    public void setUnid(String unid){
        put(getTitleUnid(), unid);
    }

    public String getNivelAt(){
        return getString(getTitleNivelAt());
    }
    public String getNivelAtencaoFormated() {
        String returnNivelAt = getString(getTitleNivelAt());
        switch (returnNivelAt) {
            case "AB":
                returnNivelAt = "Atenção Básica";
                break;
            case "HO":
                returnNivelAt = "Atendimento Hospitalar";
                break;
            case "CE":
                returnNivelAt = "Componetne Especializado";
                break;
            case "MC":
                returnNivelAt = "Média Complexidade";
                break;
            case "ME":
                returnNivelAt = "Medicamentos Estratégicos";
                break;
        }
        return returnNivelAt;
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
    public static String getTitleMedDos(){
        return "med_dos";
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
