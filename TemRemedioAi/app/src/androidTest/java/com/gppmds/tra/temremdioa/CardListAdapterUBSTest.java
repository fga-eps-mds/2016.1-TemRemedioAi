package com.gppmds.tra.temremdioa;

import android.support.v7.widget.RecyclerView;
import android.test.ActivityInstrumentationTestCase2;

import com.gppmds.tra.temremdioa.controller.MainActivity;
import com.gppmds.tra.temremdioa.model.UBS;
import com.parse.ParseException;
import com.parse.ParseQuery;
import com.tra.gppmds.temremdioa.R;

import org.junit.Before;

import java.util.List;

import static android.support.test.espresso.Espresso.onView;
import static android.support.test.espresso.action.ViewActions.swipeLeft;
import static android.support.test.espresso.matcher.ViewMatchers.withId;

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
        List<UBS> ubses;

        try {
            ubses = queryUbs.find();
            assertTrue(ubses.size() == rv_.getAdapter().getItemCount());
        } catch (ParseException e) {
            e.printStackTrace();
        }

    }
}


