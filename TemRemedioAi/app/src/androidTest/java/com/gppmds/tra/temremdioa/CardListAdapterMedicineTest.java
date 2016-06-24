package com.gppmds.tra.temremdioa;

import android.support.v7.widget.CardView;
import android.support.v7.widget.RecyclerView;
import android.test.ActivityInstrumentationTestCase2;

import com.gppmds.tra.temremdioa.controller.MainActivity;
import com.gppmds.tra.temremdioa.controller.adapter.CardListAdapterMedicine;
import com.gppmds.tra.temremdioa.model.Medicine;
import com.parse.ParseException;
import com.parse.ParseQuery;
import com.tra.gppmds.temremdioa.R;

import org.junit.Before;

import java.util.List;

public class CardListAdapterMedicineTest extends ActivityInstrumentationTestCase2<MainActivity> {

    public CardListAdapterMedicineTest () {
        super(MainActivity.class);
    }

    @Before
    public void setUp() throws Exception {
        super.setUp();
        getActivity();
    }

    public void testCountMedicinesItens() {
        RecyclerView rv = (RecyclerView) getActivity().findViewById(R.id.medicine_recycler_view);

        ParseQuery<Medicine> queryMedicine = Medicine.getQuery();
        queryMedicine.setLimit(1000);
        List<Medicine> medicines;

        try {
            medicines = queryMedicine.find();

            assertTrue(medicines.size() == rv.getAdapter().getItemCount());
        } catch (ParseException e) {
            e.printStackTrace();
        }

    }

    public void testFilterMedicinesItens() {
//        onView(withId(R.id.action_search))
//                .perform(click(), typeText("ACICLOVIR"));
//
////        SearchView searchView = (SearchView) getActivity().findViewById(R.id.action_search);
////        searchView.setQuery("ACICLOVIR", false);
//
//        RecyclerView rv = (RecyclerView) getActivity().findViewById(R.id.medicine_recycler_view);
//
//        ParseQuery<Medicine> queryMedicine = Medicine.getQuery();
//        queryMedicine.whereContains(Medicine.getMedicineDescriptionTitle(), "ACICLOVIR");
//        List<Medicine> medicines;
//
//        try {
//            medicines = queryMedicine.find();
//
//            assertTrue(medicines.size() == rv.getAdapter().getItemCount());
//        } catch (ParseException e) {
//            e.printStackTrace();
//        }

    }

    public void testShowButtonShowUBSTrue() {
        // This Button need to be checked in primary fragment of medicines. The button is need to be Showed.
        RecyclerView rv = (RecyclerView) getActivity().findViewById(R.id.medicine_recycler_view);
        CardListAdapterMedicine card = (CardListAdapterMedicine) rv.getAdapter();

        // The method getShowButtonUBSs() need to be private.
        // For run the test, set this method to public.
//        assertTrue(card.getShowButtonUBSs());
    }

    public void testShowButtonShowUBSFalse() {
        // This Button need to be checked after click on UBS and go to a new fragment of medicines.
        // The button is not be showed.
    }
}
