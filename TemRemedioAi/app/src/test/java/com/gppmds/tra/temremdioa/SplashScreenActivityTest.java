package com.gppmds.tra.temremdioa;

import android.os.Build;

import com.gppmds.tra.temremdioa.controller.SplashScreenActivity;
import com.tra.gppmds.temremdioa.BuildConfig;

import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.robolectric.Robolectric;
import org.robolectric.RobolectricGradleTestRunner;
import org.robolectric.annotation.Config;

import static org.junit.Assert.assertTrue;

/**
 * Created by Usuário on 08/06/2016.
 */
@RunWith(RobolectricGradleTestRunner.class)
@Config(constants = BuildConfig.class, sdk = Build.VERSION_CODES.LOLLIPOP)
public class SplashScreenActivityTest{

    private SplashScreenActivity splashScreenActivity;

    @Before
    public void setUp() {
        splashScreenActivity = Robolectric.setupActivity(SplashScreenActivity.class);
    }

    @Test
    public void openMainActivityTest(){
        assertTrue(splashScreenActivity.openMainActivity());
    }
}
