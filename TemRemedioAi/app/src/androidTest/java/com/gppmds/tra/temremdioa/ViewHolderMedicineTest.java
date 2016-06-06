package com.gppmds.tra.temremdioa;

import android.support.test.espresso.contrib.RecyclerViewActions;
import android.test.ActivityInstrumentationTestCase2;

import com.gppmds.tra.temremdioa.controller.MainActivity;
import com.tra.gppmds.temremdioa.R;

import org.junit.Before;

import static android.support.test.espresso.Espresso.onView;
import static android.support.test.espresso.action.ViewActions.click;
import static android.support.test.espresso.action.ViewActions.doubleClick;
import static android.support.test.espresso.assertion.ViewAssertions.matches;
import static android.support.test.espresso.matcher.ViewMatchers.isDisplayed;
import static android.support.test.espresso.matcher.ViewMatchers.withId;
import static android.support.test.espresso.matcher.ViewMatchers.withText;
import static org.hamcrest.Matchers.allOf;
import static org.hamcrest.Matchers.not;

public class ViewHolderMedicineTest  extends ActivityInstrumentationTestCase2<MainActivity>{

    public ViewHolderMedicineTest() {
        super(MainActivity.class);
    }

    @Before
    public void setUp() throws Exception {
        super.setUp();
        getActivity();

    }

    // This test expand a card and check if the unity and level attention of medicine is displayed
    //  on screen.
    public void testExpandCard() {
        onView(withId(R.id.medicine_recycler_view))
                .perform(RecyclerViewActions.actionOnItemAtPosition(2, click()));
        onView(allOf(withId(R.id.textViewMedicineType),withText("Unidade")))
                .check(matches(isDisplayed()));
        onView(allOf(withId(R.id.textViewMedicineAttetionLevel)
                , withText("Componente Especializado")))
                .check(matches(isDisplayed()));

    }

    // This test collapse a card and check if the unity and level attention of medicine is not
    // displayed on screen.
    public void testCollapseCard() {
        onView(withId(R.id.medicine_recycler_view))
                .perform(RecyclerViewActions.actionOnItemAtPosition(2, doubleClick()));
        onView(allOf(withId(R.id.textViewMedicineType),withText("Unidade")))
                .check(matches(not(isDisplayed())));
        onView(allOf(withId(R.id.textViewMedicineAttetionLevel)
                , withText("Componente Especializado")))
                .check(matches(not(isDisplayed())));
    }
}
