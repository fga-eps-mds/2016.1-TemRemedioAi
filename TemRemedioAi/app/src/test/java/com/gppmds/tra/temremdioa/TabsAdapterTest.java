package com.gppmds.tra.temremdioa;

import android.os.Build;
import android.support.v4.app.FragmentActivity;

import com.gppmds.tra.temremdioa.controller.adapter.TabsAdapter;
import com.tra.gppmds.temremdioa.BuildConfig;

import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.robolectric.RobolectricGradleTestRunner;
import org.robolectric.annotation.Config;
import static org.junit.Assert.assertArrayEquals;
import static org.junit.Assert.assertEquals;

@RunWith(RobolectricGradleTestRunner.class)
@Config(constants = BuildConfig.class, sdk = Build.VERSION_CODES.LOLLIPOP)
public class TabsAdapterTest extends FragmentActivity {
    private TabsAdapter tabsAdapter;

    @Before
    public void setUp(){
        tabsAdapter = new TabsAdapter(getSupportFragmentManager());
    }

    @Test
    public void getCountTest(){
        assertEquals(tabsAdapter.getCount(), 2);
    }
}
