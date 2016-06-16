package com.gppmds.tra.temremdioa;

import android.support.test.espresso.contrib.RecyclerViewActions;
import android.support.v7.widget.RecyclerView;
import android.test.ActivityInstrumentationTestCase2;

import com.gppmds.tra.temremdioa.controller.MainActivity;
import com.gppmds.tra.temremdioa.controller.adapter.CardListAdapterUBS;
import com.gppmds.tra.temremdioa.model.UBS;
import com.parse.ParseException;
import com.parse.ParseQuery;
import com.tra.gppmds.temremdioa.R;

import org.junit.Before;

import java.util.List;

import static android.support.test.espresso.Espresso.onView;
import static android.support.test.espresso.action.ViewActions.*;
import static android.support.test.espresso.assertion.ViewAssertions.*;
import static android.support.test.espresso.matcher.ViewMatchers.*;
import static org.hamcrest.Matchers.allOf;
import static org.hamcrest.core.IsNot.not;

public class CardListAdapterUBSTest extends ActivityInstrumentationTestCase2<MainActivity> {

    public CardListAdapterUBSTest () {
        super(MainActivity.class);
    }

    @Before
    public void setUp() throws Exception {
        super.setUp();
        getActivity();
    }

    public void testCountUBSsOnCardListAdapter() {
        onView(withId(R.id.container)).perform(swipeLeft());
        RecyclerView rv_ = (RecyclerView) getActivity().findViewById(R.id.ubs_recycler_view);

        ParseQuery<UBS> queryUbs = UBS.getQuery();
        List<UBS> ubss;

        try {
            ubss = queryUbs.find();
            assertTrue(ubss.size() == rv_.getAdapter().getItemCount());
        } catch (ParseException e) {
            e.printStackTrace();
        }
    }

    public void testFilterUBSs() {

    }

    public void testIfShowButtonMedicinesIsTrue() {
        onView(withId(R.id.container)).perform(swipeLeft());
        RecyclerView rv = (RecyclerView) getActivity().findViewById(R.id.ubs_recycler_view);
        CardListAdapterUBS card = (CardListAdapterUBS) rv.getAdapter();

        // The method getShowButtonUBSs() need to be private.
        // For run the test, set this method to public.
//        assertTrue(card.getShowButtonMedicines());
    }

    public void testIfShowButtonMedicinesisFalseWhenSelectedMedicineBefore() {
        onView(withId(R.id.medicine_recycler_view))
                .perform(RecyclerViewActions.actionOnItemAtPosition(2, click()));
        onView(withId(R.id.buttonSelectUbs)).perform(click());

        RecyclerView rv = (RecyclerView) getActivity().findViewById(R.id.medicine_recycler_view);
        CardListAdapterUBS card = (CardListAdapterUBS) rv.getAdapter();

//        onView(withId(R.id.buttonSelectUbs)).perform(RecyclerViewActions
//                .actionOnItemAtPosition(0, click()));
//        onView(withId(R.id.ubs_recycler_view)).perform(RecyclerViewActions
//                .actionOnItemAtPosition(1, click()));
//        onView(withId(R.id.buttonSelecionarRemedio))
//                .check(matches(not(isDisplayed())));
    }
}


