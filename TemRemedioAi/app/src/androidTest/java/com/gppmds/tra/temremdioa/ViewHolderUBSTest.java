package com.gppmds.tra.temremdioa;

import org.junit.Before;
import android.media.audiofx.Virtualizer;
import android.support.test.espresso.contrib.RecyclerViewActions;
import android.test.ActivityInstrumentationTestCase2;
import com.gppmds.tra.temremdioa.controller.MainActivity;
import com.tra.gppmds.temremdioa.R;

import static android.support.test.espresso.action.ViewActions.*;
import static android.support.test.espresso.Espresso.*;
import static android.support.test.espresso.assertion.ViewAssertions.matches;
import static android.support.test.espresso.matcher.ViewMatchers.*;
import static org.hamcrest.Matchers.*;

public class ViewHolderUBSTest extends ActivityInstrumentationTestCase2<MainActivity> {

    public ViewHolderUBSTest() {
        super(MainActivity.class);
    }

    @Before
    public void setUp() throws Exception{
        super.setUp();
        getActivity();
    }

    public void testIfCardExpands(){
        onView(withId(R.id.container)).perform(swipeLeft());
        onView(allOf(withId(R.id.ubs_recycler_view),withText("ADOLEScentro"))).perform(click());
        onView(allOf(withId(R.id.textViewCidadeUBS),withText("Brasília")))
                .check(matches(isDisplayed()));
    }

    public void testIfCardCollapses(){
        onView(withId(R.id.container)).perform(swipeLeft());
        onView(withId(R.id.ubs_recycler_view)).
                perform(RecyclerViewActions.actionOnItemAtPosition(0, click()));
        onView(allOf(withId(R.id.textViewCidadeUBS),withText("Brasília")))
                .check(matches(isDisplayed()));
        onView(withId(R.id.ubs_recycler_view)).
                perform(RecyclerViewActions.actionOnItemAtPosition(0, click()));
        onView(allOf(withId(R.id.textViewCidadeUBS),withText("Brasília")))
                .check(matches(not(isDisplayed())));
    }
}