//MODEL
package com.gppmds.tra.temremdioa.model;

import com.parse.ParseClassName;
import com.parse.ParseObject;

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

    public Integer getCodMunic(){
        return getInt("cod_munic");
    }

    public void setCodMunic(Integer cod_munic){
        put("cod_munic", cod_munic);
    }

    public Integer getCodCnes(){
        return getInt("cod_cnes");
    }

    public void setCod_cnes(Integer cod_cnes){
        put("cod_cnes", cod_cnes);
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

    public String getDscTelefone(){
        return getString("dsc_telefone");
    }

    public void setDscTelefone(String dsc_telefone){
        put("dsc_telefone", dsc_telefone);
    }

    public String getDscEstrutFisicAmbiencia(){
        return getString("dsc_estrut_fisic_ambiencia");
    }

    public void setDscEstrutFisicAmbiencia(String dsc_estrut_fisic_ambiencia){
        put("dsc_estrut_fisic_ambiencia", dsc_estrut_fisic_ambiencia);
    }

    public String getDscAdapDeficFisicIdosos(){
        return getString("dsc_adap_defic_fisic_idosos");
    }

    public void setDscAdapDeficFisicIdosos(String dsc_adap_defic_fisic_idosos){
        put("dsc_adap_defic_fisic_idosos", dsc_adap_defic_fisic_idosos);
    }

    public String getDscEquipamentos(){
        return getString("dsc_equipamentos");
    }

    public void setDscEquipamentos(String dsc_equipamentos){
        put("dsc_equipamentos", dsc_equipamentos);
    }

    public String getDscMedicamentos(){
        return getString("dsc_medicamentos");
    }

    public void setDscMedicamentos(String dsc_medicamentos){
        put("dsc_medicamentos", dsc_medicamentos);
    }

    @Override
    public String toString(){
        return getString("nom_estab");
    }
}
