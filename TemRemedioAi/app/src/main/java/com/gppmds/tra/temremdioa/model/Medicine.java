/**
 * Medicine.java to define Remedio
 * Used to get data of medicine from Parse
 */
package com.gppmds.tra.temremdioa.model;

import com.parse.ParseClassName;
import com.parse.ParseObject;
import com.parse.ParseQuery;

@ParseClassName("Medicamentos")
public class Medicine extends ParseObject {
    /**
     * getMedicineSESCode get the medicine code in "Secretaria de Estado de Saúde"
     * @return string representing code of medicine
     */
    public String getMedicineSESCode(){
        return getString(getMedicineSESCodeTitle());
    }

    /**
     * setMedicineSESCode the code of medicine im "Secretaria de Estado de Saúde"
     * @param sesCode
     */
    public void setMedicineSESCode(String sesCode){
        put(getMedicineSESCodeTitle(), sesCode);
    }

    /**
     * getMedicineDescription to get the nome of the medicine from database
     * @return string representing the name of the medicine
     */
    public String getMedicineDescription(){
        return getString(getMedicineDescriptionTitle());
    }

    /**
     * setMedicineDescription to set the name of the medicine
     * @param medicineDescription
     */
    public void setMedicineDescription(String medicineDescription){
        put(getMedicineDescriptionTitle(), medicineDescription);
    }

    /**
     * getMedicineDosage to get the dosage of the medicine from database
     * @return string representing dosage of the medicine
     */
    public String getMedicineDosage(){
        return getString(getMedicineDosageTitle());
    }

    /**
     * setMedicinedOSAGE to set the dosage of the medicine
     * @param medicineDosage
     */
    public void setMedicineDosage(String medicineDosage){
        put(getMedicineDosageTitle(), medicineDosage);
    }

    /**
     * getMedicineUnit get the unity of the medicine, like "CP" that's represent "pill" from
     * database
     * @return string representind the initials of unity medicine
     */
    public String getMedicineUnit(){
        return getString(getMedicineUnitTitle());
    }

    /**
     * getUnityMedicineFormatted get the initiaçs of the unity medicine and write the complete name
     * to show in screen
     * @return string representing every initials from unity medicine
     */
    public String getUnityMedicineFormatted(){
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

    /**
     * setMedicineUnit set the initials of unity medicine
     * @param medicineUnit
     */
    public void setMedicineUnit(String medicineUnit){
        put(getMedicineUnitTitle(), medicineUnit);
    }

    /**
     * getMedicineAttentionLevel get the level of attention from medicine
     * @return string representing the initials of attention level of medicine
     */
    public String getMedicineAttentionLevel(){
        return getString(getMedicineAttentionLevelTitle());
    }

    /**
     * getMedicineAttentionLevelExtended get the initials from attention level of medicine and
     * write the complete name
     * @return string representing every initials from attention level medicine
     */
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
            default:
                /* Nothing to do */
                break;
        }
        return medicineAttentionLevel;
    }

    /**
     * setMedicineAttentionLevel set the initials of attention level of medicine
     * @param medicineAttentionLevel
     */
    public void setMedicineAttentionLevel(String medicineAttentionLevel){
        put(getMedicineAttentionLevelTitle(), medicineAttentionLevel);
    }

    /**
     * @return a parse query of medicine
     */
    public static ParseQuery<Medicine> getQuery() {
        return ParseQuery.getQuery(Medicine.class);
    }

    /**
     * getMedicineSESCodeTitle get the medicine code in "Secretaria de Estado e Saúde"
     * @return string representing the code of medicine
     */
    public static String getMedicineSESCodeTitle(){
        return "cod_ses";
    }

    /**
     * getMedicineDescriptionTitle get the name of medicine
     * @return string representing the name of medicine
     */
    public static String getMedicineDescriptionTitle(){
        return "med_des";
    }

    /**
     * getMedicineDosageTitle get the dosage of medicine
     * @return string representing the dosage of medicine
     */
    public static String getMedicineDosageTitle(){
        return "med_dos";
    }

    /**
     * getMedicineUnitTitle get the title of medicine unity
     * @return string representing the title of unity from medicine
     */
    public static String getMedicineUnitTitle(){
        return "unid";
    }

    /**
     * getMedicineAttentionLevelTitle get the attention level from medicine
     * @return string representing the attention level of medicine
     */
    public static String getMedicineAttentionLevelTitle(){
        return "nivel_at";
    }

    /**
     * toString get the title of medicine
     * @return string representing the name of medicine
     */
    @Override
    public String toString() {
        return getString(getMedicineDescriptionTitle());
    }
}