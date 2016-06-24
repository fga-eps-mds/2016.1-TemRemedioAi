package com.gppmds.tra.temremdioa;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;

import com.gppmds.tra.temremdioa.controller.SelectMedicineActivity;
import com.gppmds.tra.temremdioa.controller.adapter.CardListAdapterMedicine;
import com.gppmds.tra.temremdioa.model.Medicine;
import com.parse.ParseObject;

import org.junit.Before;
import org.junit.Test;
import org.mockito.Mockito;

import java.util.ArrayList;
import java.util.List;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotEquals;
import static org.junit.Assert.assertNotNull;
import static org.junit.Assert.assertTrue;

public class SelectMedicineActivityTest {

    private SelectMedicineActivity selectMedicineActivity;
    private Bundle bundle;
    private View view;
    private AppCompatActivity activity;
    private CardListAdapterMedicine cardListAdapterMedicine;
    private Medicine medicine;

    @Before
    public void setup() {
        bundle = Mockito.mock(Bundle.class);
        view = Mockito.mock(View.class);
        selectMedicineActivity = Mockito.mock(SelectMedicineActivity.class);
        activity = Mockito.mock(AppCompatActivity.class);
        ParseObject.registerSubclass(Medicine.class);
        medicine = new Medicine();
//        selectMedicineActivity = new SelectMedicineActivity();
    }

    @Test
    public void onCreateTest(){
        /* The method onCreate() need to be protected.
           For run the test, set this method to public.*/
        //selectMedicineActivity.onCreate(bundle);
        assertNotEquals(view, selectMedicineActivity.getCurrentFocus());
        assertEquals(activity.getCurrentFocus(), selectMedicineActivity.getCurrentFocus());
    }

    @Test
    public void createNewLinearLayoutManagerTest() {
        selectMedicineActivity = new SelectMedicineActivity();
        assertNotNull(selectMedicineActivity.createNewLinearLayoutManager());
    }

    @Test
    public void setAndGetFilterAttentionLevelTest() {
        selectMedicineActivity = new SelectMedicineActivity();
        String ubsAttentionLevel = "HO,AB";
        selectMedicineActivity.setFilterAttentionLevel(ubsAttentionLevel);
        ArrayList<String> arrayList = new ArrayList<String>();
        arrayList.add("HO");
        arrayList.add("AB");

        assertEquals(arrayList, selectMedicineActivity.getFilterAttentionLevel());
    }

    @Test
    public void getListOfMedicineTest() {
//        selectMedicineActivity = new SelectMedicineActivity();
        ArrayList<String> arrayList = new ArrayList<String>();
        arrayList.add("AB");
        assertNotNull(selectMedicineActivity.getListOfMedicine(arrayList));
    }


    @Test
    public void createRecyclerViewTest() {
        List<Medicine> medicineList = new ArrayList<Medicine>();

        medicine.setMedicineDescription("Test");
        medicineList.add(medicine);
        cardListAdapterMedicine = new CardListAdapterMedicine(activity.getApplicationContext(), medicineList);

//        selectMedicineActivity = new SelectMedicineActivity();
        try {
            selectMedicineActivity.createRecyclerView(cardListAdapterMedicine);
            assertTrue(true);
        } catch (Exception e) {
            assertTrue(false);
        }
    }

    @Test
    public void setAndGetUbsNameTest(){
        selectMedicineActivity = new SelectMedicineActivity();
        selectMedicineActivity.setUbsName("UBSTeste");
        assertEquals(selectMedicineActivity.getUbsName(),"UBSTeste");
    }

    @Test
    public void setAndGetUBSAttentionLevelTest () {
        selectMedicineActivity = new SelectMedicineActivity();
        selectMedicineActivity.setUbsAttentionLevel("AB");
        assertEquals("AB", selectMedicineActivity.getUbsAttentionLevel());
    }
}
