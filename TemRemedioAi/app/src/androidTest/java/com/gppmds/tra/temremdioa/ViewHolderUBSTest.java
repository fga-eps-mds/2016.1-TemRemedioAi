package com.gppmds.tra.temremdioa;

import android.support.test.espresso.contrib.RecyclerViewActions;
import android.test.ActivityInstrumentationTestCase2;

import com.gppmds.tra.temremdioa.controller.MainActivity;
import com.tra.gppmds.temremdioa.R;

import org.junit.Before;

import static android.support.test.espresso.Espresso.onView;
import static android.support.test.espresso.action.ViewActions.click;
import static android.support.test.espresso.action.ViewActions.doubleClick;
import static android.support.test.espresso.action.ViewActions.swipeLeft;
import static android.support.test.espresso.assertion.ViewAssertions.matches;
import static android.support.test.espresso.matcher.ViewMatchers.isDisplayed;
import static android.support.test.espresso.matcher.ViewMatchers.withId;
import static android.support.test.espresso.matcher.ViewMatchers.withText;
import static org.hamcrest.Matchers.allOf;
import static org.hamcrest.Matchers.not;

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
        onView(withId(R.id.ubs_recycler_view))
                .perform(RecyclerViewActions.actionOnItemAtPosition(0, click()));
        onView(allOf(withId(R.id.textViewUbsCity),withText("Brasília")))
                .check(matches(isDisplayed()));
        onView(allOf(withId(R.id.textViewUbsAttentionLevel)
                , withText("AB")))
                .check(matches(isDisplayed()));
    }

    public void testIfCardCollapses(){
        onView(withId(R.id.container)).perform(swipeLeft());
        onView(withId(R.id.ubs_recycler_view))
                .perform(RecyclerViewActions.actionOnItemAtPosition(0, doubleClick()));
        onView(allOf(withId(R.id.textViewUbsCity),withText("Brasília")))
                .check(matches(not(isDisplayed())));
        onView(allOf(withId(R.id.textViewUbsAttentionLevel)
                , withText("AB")))
                .check(matches(not(isDisplayed())));
    }
}