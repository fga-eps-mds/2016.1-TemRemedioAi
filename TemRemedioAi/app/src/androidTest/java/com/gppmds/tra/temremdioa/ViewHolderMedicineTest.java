package com.gppmds.tra.temremdioa;

import android.support.test.espresso.contrib.RecyclerViewActions;
import android.test.ActivityInstrumentationTestCase2;

import com.gppmds.tra.temremdioa.controller.MainActivity;
import com.tra.gppmds.temremdioa.R;

import org.junit.Before;

import static android.support.test.espresso.Espresso.onView;
import static android.support.test.espresso.action.ViewActions.click;
import static android.support.test.espresso.matcher.ViewMatchers.withId;


public class ViewHolderMedicineTest  extends ActivityInstrumentationTestCase2<MainActivity>{

    public ViewHolderMedicineTest() {
        super(MainActivity.class);
    }

    @Before
    public void setUp() throws Exception {
        super.setUp();
        getActivity();

    }

    public void testExpandCard() {
//        onData(hasToString(containsString("ABATACEPTE"))).inAdapterView(withId(R.id.card_view_medicine)).atPosition(2).perform(click());

        onView(withId(R.id.medicine_recycler_view)).
                perform(RecyclerViewActions.actionOnItemAtPosition(1, click()));

//        onView(withId(R.id.expandable)).check(matches(isDisplayed()));
    }

    public void testCollapseCard() {

        onView(withId(R.id.medicine_recycler_view)).
                perform(RecyclerViewActions.actionOnItemAtPosition(1, click()));

        onView(withId(R.id.medicine_recycler_view)).
                perform(RecyclerViewActions.actionOnItemAtPosition(1, click()));
    }
}
