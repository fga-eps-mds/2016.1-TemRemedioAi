//MODEL
package com.gppmds.tra.temremdioa.model;

import com.parse.ParseClassName;
import com.parse.ParseObject;
import com.parse.ParseQuery;

@ParseClassName("Medicamentos")
public class Medicine extends ParseObject {
    //Returns the SES Code of a medicine
    public String getMedicineSESCode(){
        return getString(getMedicineSESCodeTitle());
    }

    //Sets a SES Code to a medicine
    public void setMedicineSESCode(String sesCode){
        put(getMedicineSESCodeTitle(), sesCode);
    }

    //Returns the medicine description (or name) of a medicine
    public String getMedicineDescription(){
        return getString(getMedicineDescriptionTitle());
    }

    //Sets a description (or name) to a medicine
    public void setMedicineDescription(String medicineDescription){
        put(getMedicineDescriptionTitle(), medicineDescription);
    }

    //Returns the dosage of a medicine
    public String getMedicineDosage(){
        return getString(getMedicineDosageTitle());
    }

    //Sets a dosage to a medicine
    public void setMedicineDosage(String medicineDosage){
        put(getMedicineDosageTitle(), medicineDosage);
    }

    //Returns the unit of a medicine
    public String getMedicineUnit(){
        return getString(getMedicineUnitTitle());
    }

    //Returns the extended unit of a medicine
    public String getMedicineUnitExtended(){
        String medicineUnit = getString(getMedicineUnitTitle());
        switch (medicineUnit) {
            case "AMP":
                medicineUnit = "Ampola";
                break;
            case "BS":
                medicineUnit = "Bisnaga";
                break;
            case "CJ":
                medicineUnit = "Conjunto";
                break;
            case "CP":
                medicineUnit = "Comprimido";
                break;
            case "CS":
                medicineUnit = "Cápsula";
                break;
            case "CT":
                medicineUnit = "Cartela";
                break;
            case "CX":
                medicineUnit = "Caixa";
                break;
            case "DG":
                medicineUnit = "Drageia";
                break;
            case "EN":
                medicineUnit = "Envelope";
                break;
            case "FA":
                medicineUnit = "Frasco-Ampola";
                break;
            case "FR":
                medicineUnit = "Frasco";
                break;
            case "GL":
                medicineUnit = "Galão";
                break;
            case "KT":
                medicineUnit = "Kit";
                break;
            case "PT":
                medicineUnit = "Pote";
                break;
            case "UM":
                medicineUnit = "Unidade";
                break;
            case "UN":
                medicineUnit = "Unidade";
                break;
            default:
                medicineUnit = "Sem medição";
                break;
        }
        return medicineUnit;
    }

    //Sets a unit to a medicine
    public void setMedicineUnit(String medicineUnit){
        put(getMedicineUnitTitle(), medicineUnit);
    }

    //Returns the attention level of a medicine
    public String getMedicineAttentionLevel(){
        return getString(getMedicineAttentionLevelTitle());
    }

    //Returns the extended attention level of a medicine
    public String getMedicineAttentionLevelExtended() {
        String medicineAttentionLevel = getString(getMedicineAttentionLevelTitle());
        switch (medicineAttentionLevel) {
            case "AB":
                medicineAttentionLevel = "Atenção Básica";
                break;
            case "HO":
                medicineAttentionLevel = "Atendimento Hospitalar";
                break;
            case "CE":
                medicineAttentionLevel = "Componente Especializado";
                break;
            case "MC":
                medicineAttentionLevel = "Média Complexidade";
                break;
            case "ME":
                medicineAttentionLevel = "Medicamentos Estratégicos";
                break;
        }
        return medicineAttentionLevel;
    }

    //Sets a attention level to a medicine
    public void setMedicineAttentionLevel(String nivel_at){
        put(getMedicineAttentionLevelTitle(), nivel_at);
    }

    //Returns a parse query of medicine
    public static ParseQuery<Medicine> getQuery() {
        return ParseQuery.getQuery(Medicine.class);
    }
    //Returns the SES Code Title of a medicine
    public static String getMedicineSESCodeTitle(){
        return "cod_ses";
    }

    //Returns the description title of a medicine
    public static String getMedicineDescriptionTitle(){
        return "med_des";
    }

    //Returns the dosage title of a medicine
    public static String getMedicineDosageTitle(){
        return "med_dos";
    }

    //Returns the unit title of a medicine
    public static String getMedicineUnitTitle(){
        return "unid";
    }

    //Returns the attention level title of a medicine
    public static String getMedicineAttentionLevelTitle(){
        return "nivel_at";
    }

    //Overrides the method to returns the description title of a medicine
    @Override
    public String toString() {
        return getString(getMedicineDescriptionTitle());
    }
}