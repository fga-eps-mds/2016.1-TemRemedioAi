package com.gppmds.tra.temremdioa;

import android.os.Bundle;
import android.view.View;

import com.gppmds.tra.temremdioa.controller.AboutActivity;

import org.junit.Before;
import org.junit.Test;
import org.mockito.Mockito;

import static org.junit.Assert.assertNotEquals;

/**
 * Created by niets on 08/06/16.
 */

public class AboutActivityUnitTest {

    private AboutActivity aboutActivity;
    private Bundle bundle;
    private View view;

    @Before
    public void setUp() {
        bundle = Mockito.mock(Bundle.class);
        view = Mockito.mock(View.class);
        aboutActivity = new AboutActivity();
        aboutActivity = Mockito.mock(AboutActivity.class);
    }

    // Protected method, change to public before testing
    @Test
    public void onCreateTest() {
        aboutActivity.onCreate(bundle);
        assertNotEquals(view, aboutActivity.findViewById(0));
    }
}