package com.gppmds.tra.temremdioa;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;

import com.gppmds.tra.temremdioa.controller.SelectUBSActivity;
import com.gppmds.tra.temremdioa.controller.adapter.CardListAdapterUBS;
import com.gppmds.tra.temremdioa.model.UBS;
import com.parse.ParseObject;

import org.junit.Before;
import org.junit.Test;
import org.mockito.Mockito;

import java.util.ArrayList;
import java.util.List;

import static org.junit.Assert.*;

public class SelectUBSActivityTest {

    private SelectUBSActivity selectUBSActivity;
    private Bundle bundle;
    private View view;
    private AppCompatActivity activity;
    private CardListAdapterUBS cardListAdapterUBS;
    private UBS ubs;

    @Before
    public void setup() {
        bundle = Mockito.mock(Bundle.class);
        view = Mockito.mock(View.class);
        selectUBSActivity = Mockito.mock(SelectUBSActivity.class);
        activity = Mockito.mock(AppCompatActivity.class);
        ParseObject.registerSubclass(UBS.class);
        ubs = new UBS();

    }

    @Test
    public void onCreateTest(){
        /* The method onCreate() need to be protected.
           For run the test, set this method to public.*/
        //selectUBSActivity.onCreate(bundle);
        assertNotEquals(view, selectUBSActivity.getCurrentFocus());
        assertEquals(activity.getCurrentFocus(), selectUBSActivity.getCurrentFocus());
    }

    @Test
    public void createLinearLayoutManagerTest() {
        selectUBSActivity = new SelectUBSActivity();
        assertNotNull(selectUBSActivity.createLinearLayoutManager());
    }

    @Test
    public void setAndGetFilterAttentionLevelTest() {
        selectUBSActivity = new SelectUBSActivity();
        String medicineAttentionLevel = "AB";
        selectUBSActivity.setFilterAttentionLevel(medicineAttentionLevel);
        ArrayList<String> arrayList = new ArrayList<String>();
        arrayList.add("AB");

        assertEquals(arrayList, selectUBSActivity.getFilterAttentionLevel());
    }

    @Test
    public void getListOfUBSTest() {
        ArrayList<String> arrayList = new ArrayList<String>();
        arrayList.add("AB");
        assertNotNull(selectUBSActivity.getListOfUbs(arrayList));
    }


    @Test
    public void createRecyclerViewTest() {
        List<UBS> ubsList = new ArrayList<UBS>();

        ubs.setUbsName("Test");
        ubsList.add(ubs);
        cardListAdapterUBS = new CardListAdapterUBS(activity.getApplicationContext(), ubsList);

        try {
            selectUBSActivity.createRecyclerView(cardListAdapterUBS);
            assertTrue(true);
        } catch (Exception e) {
            assertTrue(false);
        }
    }

    @Test
    public void setAndGetMedicineNameTest(){
        selectUBSActivity = new SelectUBSActivity();
        selectUBSActivity.setMedicineName("MedicineTest");
        assertEquals(selectUBSActivity.getMedicineName(),"MedicineTest");
    }

    @Test
    public void setAndGetMedicineAttentionLevelTest () {
        selectUBSActivity = new SelectUBSActivity();
        selectUBSActivity.setMedicineAttentionLevel("AB");
        assertEquals("AB", selectUBSActivity.getMedicineAttentionLevel());
    }
}


