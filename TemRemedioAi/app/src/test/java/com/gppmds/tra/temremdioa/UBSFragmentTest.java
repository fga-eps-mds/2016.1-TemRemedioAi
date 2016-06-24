package com.gppmds.tra.temremdioa;


import android.os.Build;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentActivity;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentTransaction;

import com.gppmds.tra.temremdioa.controller.fragment.MedicineFragment;
import com.gppmds.tra.temremdioa.controller.fragment.UBSFragment;
import com.tra.gppmds.temremdioa.BuildConfig;

import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.robolectric.Robolectric;
import org.robolectric.RobolectricGradleTestRunner;
import org.robolectric.annotation.Config;

import static junit.framework.Assert.assertNotNull;
import static junit.framework.Assert.assertTrue;

@RunWith(RobolectricGradleTestRunner.class)
@Config(constants = BuildConfig.class, sdk = Build.VERSION_CODES.LOLLIPOP)
public class UBSFragmentTest {

    FragmentActivity fragmentActivity;
    UBSFragment ubsFragment;

    @Before
    public void setup() throws Exception {
        fragmentActivity = Robolectric.buildActivity(FragmentActivity.class).create().start()
                            .resume().get();
        ubsFragment = new UBSFragment();
    }

    @Test
    public void newInstanceTest() {
        assertTrue(UBSFragment.class == ubsFragment.newInstance().getClass());
    }

    @Test
    public void getUbsAdapterTest(){
        addMapFragment(fragmentActivity, ubsFragment);
        assertNotNull(ubsFragment.getUbsAdapter());
    }

    private void addMapFragment(FragmentActivity activity, Fragment fragment) {
        FragmentManager fragmentManager = activity.getSupportFragmentManager();
        FragmentTransaction transaction = fragmentManager.beginTransaction();
        transaction.add(fragment, "ubsFragment");
        transaction.commit();
    }
}
