package com.gppmds.tra.temremdioa.controller;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import org.mockito.Mockito;
import org.junit.Before;
import org.junit.Test;

import static org.junit.Assert.*;

/**
 * Created by niets on 08/06/16.
 */
public class AboutActivityTest {

    private AboutActivity aboutActivity;
    private Bundle bundle;
    private View view;
    private AppCompatActivity activity;

    @Before
    public void setUp() {
        bundle = Mockito.mock(Bundle.class);
        view = Mockito.mock(View.class);
        aboutActivity = Mockito.mock(AboutActivity.class);
        activity = Mockito.mock(AppCompatActivity.class);
    }

    @Test
    public void onCreateTest(){
        aboutActivity.onCreate(bundle);
        assertNotEquals(view, aboutActivity.getCurrentFocus());
        assertEquals(activity.getCurrentFocus(), aboutActivity.getCurrentFocus());
    }
}
