//MODEL
package com.gppmds.tra.temremdioa.model;

import com.parse.ParseClassName;
import com.parse.ParseObject;

/**
 * Created by Maria Carolina  on 27/04/2016.
 * Update  by Maria Carolina on 30/04/2016.
 */
@ParseClassName("Medicamentos")
public class Remedio extends ParseObject {
    public String getCodSes(){
        return getString("cod_ses");
    }

    public void setCodSes(String cod_ses){
        put("cod_ses", cod_ses);
    }

    public String getMedDes(){
        return getString("med_des");
    }

    public void setMedDes(String med_des){
        put("med_des", med_des);
    }

    public String getUnid(){
        return getString("unid");
    }

    public String getUnidadeFormated(){
        String returnUnid = getString("unid");
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
        put("unid", unid);
    }

    public String getNivelAt(){
        return getString("nivel_at");
    }

    public String getNivelAtencaoFormated() {
        String returnNivelAt = getString("nivel_at");
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
        put("nivel_at", nivel_at);
    }

    @Override
    public String toString() {
        return getString("med_des");
    }
}
