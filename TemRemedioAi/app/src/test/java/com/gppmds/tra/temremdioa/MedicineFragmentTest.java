package com.gppmds.tra.temremdioa;

import android.os.Build;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentActivity;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentTransaction;

import com.gppmds.tra.temremdioa.controller.fragment.MedicineFragment;
import com.tra.gppmds.temremdioa.BuildConfig;

import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.robolectric.Robolectric;
import org.robolectric.RobolectricGradleTestRunner;
import org.robolectric.annotation.Config;

import static junit.framework.Assert.assertNotNull;
import static junit.framework.Assert.assertTrue;

/**
 * Created by Usuário on 12/06/2016.
 */

@RunWith(RobolectricGradleTestRunner.class)
@Config(constants = BuildConfig.class, sdk = Build.VERSION_CODES.LOLLIPOP)
public class MedicineFragmentTest {

    FragmentActivity activity;
    MedicineFragment medicineFragment;

    private static final String FRAGMENT_TAG = "medicineFragment";

    @Before
    public void setup() throws Exception {
        activity = Robolectric.buildActivity(FragmentActivity.class).create().start().resume().get();
        medicineFragment = new MedicineFragment();
    }

    @Test
    public void newInstanceTest() {
        assertTrue(MedicineFragment.class == medicineFragment.newInstance().getClass());
    }

    @Test
    public void getListOfMedicinesTest() {
        medicineFragment = new MedicineFragment();
        assertNotNull(medicineFragment.getListOfMedicines());
    }

    @Test
    public void getMedicineAdapterTest() throws Exception {
        addMapFragment(activity, medicineFragment);
        assertNotNull(medicineFragment.getMedicineAdapter());
    }

    private void addMapFragment(FragmentActivity activity, Fragment fragment) {
        FragmentManager fragmentManager = activity.getSupportFragmentManager();
        FragmentTransaction transaction = fragmentManager.beginTransaction();
        transaction.add(fragment, FRAGMENT_TAG);
        transaction.commit();
    }

}
