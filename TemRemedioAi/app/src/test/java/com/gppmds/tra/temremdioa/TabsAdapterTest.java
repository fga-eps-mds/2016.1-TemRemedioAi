package com.gppmds.tra.temremdioa;

import android.os.Build;
import android.support.v4.app.FragmentActivity;

import com.gppmds.tra.temremdioa.controller.adapter.TabsAdapter;
import com.gppmds.tra.temremdioa.controller.fragment.MedicineFragment;
import com.gppmds.tra.temremdioa.controller.fragment.UBSFragment;
import com.tra.gppmds.temremdioa.BuildConfig;

import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.robolectric.RobolectricGradleTestRunner;
import org.robolectric.annotation.Config;
import static org.junit.Assert.assertArrayEquals;
import static org.junit.Assert.*;

@RunWith(RobolectricGradleTestRunner.class)
@Config(constants = BuildConfig.class, sdk = Build.VERSION_CODES.LOLLIPOP)
public class TabsAdapterTest extends FragmentActivity {
    private TabsAdapter tabsAdapter;

    @Before
    public void setUp(){
        tabsAdapter = new TabsAdapter(getSupportFragmentManager());
    }

    @Test
    public void getItemReturnNullTest(){
//        MedicineFragment medicineFragment = new MedicineFragment();
//        UBSFragment ubsFragment = new UBSFragment();
//
//        assert
//
//        assertEquals(MedicineFragment.newInstance(), tabsAdapter.getItem(0));
//        assertEquals(UBSFragment.newInstance(), tabsAdapter.getItem(1));
        assertNull(tabsAdapter.getItem(2));
    }

    @Test
    public void getCountTest(){
        assertEquals(tabsAdapter.getCount(), 2);
    }

    @Test
    public void getPageTitleTest(){
        assertEquals("Remédio",tabsAdapter.getPageTitle(0));
        assertEquals("UBS",tabsAdapter.getPageTitle(1));
        assertNull(tabsAdapter.getPageTitle(2));
    }
}
