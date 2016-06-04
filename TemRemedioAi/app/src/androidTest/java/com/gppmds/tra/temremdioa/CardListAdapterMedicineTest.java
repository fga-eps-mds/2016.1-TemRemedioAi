package com.gppmds.tra.temremdioa;

import android.support.v7.widget.RecyclerView;
import android.test.ActivityInstrumentationTestCase2;

import com.gppmds.tra.temremdioa.controller.MainActivity;
import com.gppmds.tra.temremdioa.model.Medicine;
import com.parse.ParseException;
import com.parse.ParseQuery;
import com.tra.gppmds.temremdioa.R;

import org.junit.Before;

import java.util.List;

/**
 * Created by Usuário on 04/06/2016.
 */
public class CardListAdapterMedicineTest extends ActivityInstrumentationTestCase2<MainActivity> {

    public CardListAdapterMedicineTest () {
        super(MainActivity.class);
    }

    @Before
    public void setUp() throws Exception {
        super.setUp();
        getActivity();
    }

    public void testCountMedicinesItensOnCardListAdapter() {
        RecyclerView rv = (RecyclerView) getActivity().findViewById(R.id.medicine_recycler_view);

        ParseQuery<Medicine> queryMedicine = Medicine.getQuery();
        List<Medicine> medicines;

        try {
            medicines = queryMedicine.find();

            assertTrue(medicines.size() == rv.getAdapter().getItemCount());
        } catch (ParseException e) {
            e.printStackTrace();
        }

    }

}
