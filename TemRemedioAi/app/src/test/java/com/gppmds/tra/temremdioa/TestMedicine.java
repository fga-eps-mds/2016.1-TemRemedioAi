package com.gppmds.tra.temremdioa;

import com.gppmds.tra.temremdioa.model.Medicine;
import com.parse.ParseObject;
import com.parse.ParseQuery;

import org.junit.Before;
import org.junit.Test;

import static java.lang.Double.valueOf;
import static org.junit.Assert.*;

/**
 * To work on unit tests, switch the Test Artifact in the Build Variants view.
 */
public class TestMedicine {

    private Medicine medicine;

    @Before
    public void setUp() {
        ParseObject.registerSubclass(Medicine.class);
        medicine = new Medicine();
    }

    @Test
    public void testGetMedicineSESCode(){
        medicine.setMedicineSESCode("test SES Code");
        assertEquals("test SES Code", medicine.getMedicineSESCode());
    }

    @Test
    public void test_getMedicineDescription(){
        medicine.setMedicineDescription("test description");
        assertEquals("test description", medicine.getMedicineDescription());
    }

    @Test
    public void test_getMedicineDosage(){
        medicine.setMedicineDosage("test dosage");
        assertEquals("test dosage", medicine.getMedicineDosage());
    }

    @Test
    public void test_getMedicineUnit(){
        medicine.setMedicineUnit("test unit");
        assertEquals("test unit", medicine.getMedicineUnit());
    }

    @Test
    public void test_getUnityMedicineFormatted(){
        medicine.setMedicineUnit("AMP");
        assertEquals("Ampola", medicine.getUnityMedicineFormatted());
        medicine.setMedicineUnit("BS");
        assertEquals("Bisnaga", medicine.getUnityMedicineFormatted());
        medicine.setMedicineUnit("CJ");
        assertEquals("Conjunto", medicine.getUnityMedicineFormatted());
        medicine.setMedicineUnit("CP");
        assertEquals("Comprimido", medicine.getUnityMedicineFormatted());
        medicine.setMedicineUnit("CS");
        assertEquals("Cápsula", medicine.getUnityMedicineFormatted());
        medicine.setMedicineUnit("CT");
        assertEquals("Cartela", medicine.getUnityMedicineFormatted());
        medicine.setMedicineUnit("CX");
        assertEquals("Caixa", medicine.getUnityMedicineFormatted());
        medicine.setMedicineUnit("DG");
        assertEquals("Drageia", medicine.getUnityMedicineFormatted());
        medicine.setMedicineUnit("EN");
        assertEquals("Envelope", medicine.getUnityMedicineFormatted());
        medicine.setMedicineUnit("FA");
        assertEquals("Frasco-Ampola", medicine.getUnityMedicineFormatted());
        medicine.setMedicineUnit("FR");
        assertEquals("Frasco", medicine.getUnityMedicineFormatted());
        medicine.setMedicineUnit("GL");
        assertEquals("Galão", medicine.getUnityMedicineFormatted());
        medicine.setMedicineUnit("KT");
        assertEquals("Kit", medicine.getUnityMedicineFormatted());
        medicine.setMedicineUnit("PT");
        assertEquals("Pote", medicine.getUnityMedicineFormatted());
        medicine.setMedicineUnit("UM");
        assertEquals("Unidade", medicine.getUnityMedicineFormatted());
        medicine.setMedicineUnit("UN");
        assertEquals("Unidade", medicine.getUnityMedicineFormatted());
        medicine.setMedicineUnit("teste default");
        assertEquals("Sem medição", medicine.getUnityMedicineFormatted());
    }

    @Test
    public void test_getMedicineAttentionLevel(){
        medicine.setMedicineAttentionLevel("test Attention Level");
        assertEquals("test Attention Level", medicine.getMedicineAttentionLevel());
    }

    @Test
    public void test_getMedicineAttentionLevelExtended(){
        medicine.setMedicineAttentionLevel("AB");
        assertEquals("Atenção Básica", medicine.getMedicineAttentionLevelExtended());
        medicine.setMedicineAttentionLevel("HO");
        assertEquals("Atendimento Hospitalar", medicine.getMedicineAttentionLevelExtended());
        medicine.setMedicineAttentionLevel("CE");
        assertEquals("Componente Especializado", medicine.getMedicineAttentionLevelExtended());
        medicine.setMedicineAttentionLevel("MC");
        assertEquals("Média Complexidade", medicine.getMedicineAttentionLevelExtended());
        medicine.setMedicineAttentionLevel("ME");
        assertEquals("Medicamentos Estratégicos", medicine.getMedicineAttentionLevelExtended());
    }

    @Test
    public void test_toString(){
        medicine.setMedicineDescription("test toStrong");
        assertEquals("test toStrong", medicine.toString());
    }

    @Test
    public void test_getQuery() {
        assertNotEquals(medicine.getQuery(), ParseQuery.getQuery(Medicine.class));
    }

}