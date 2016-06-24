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

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNull;

@RunWith(RobolectricGradleTestRunner.class)
@Config(constants = BuildConfig.class, sdk = Build.VERSION_CODES.LOLLIPOP)
public class TabsAdapterTest extends FragmentActivity {
    private TabsAdapter tabsAdapter;

    @Before
    public void setUp(){
        tabsAdapter = new TabsAdapter(getSupportFragmentManager());
    }

    @Test
    public void getItemReturnMedicineTest(){
        final int MEDICINE_FRAGMENT_OPTION = 0;
        assertEquals(MedicineFragment.class, tabsAdapter.getItem(MEDICINE_FRAGMENT_OPTION).getClass());
    }

    @Test
    public void getItemReturnUBSTest(){
        final int UBS_FRAGMENT_OPTION = 1;
        assertEquals(UBSFragment.class, tabsAdapter.getItem(UBS_FRAGMENT_OPTION).getClass());
    }

    @Test
    public void getItemReturnNullTest(){
        final int NULL_OPTION = 2;
        assertNull(tabsAdapter.getItem(2));
    }

    @Test
    public void getCountTest(){
        final int NUMBER_OF_TABS = 2;
        assertEquals(tabsAdapter.getCount(), NUMBER_OF_TABS);
    }

    @Test
    public void getPageTitleMedicineTest(){
        final int MEDICINE_STRING = 0;
        assertEquals("Remédio",tabsAdapter.getPageTitle(MEDICINE_STRING));
    }

    @Test
    public void getPageTitleUBSTest(){
        final int UBS_STRING = 1;
        assertEquals("UBS",tabsAdapter.getPageTitle(UBS_STRING));
    }

    @Test
    public void getPageTitleReturnNullTest(){
        final int NULL_OPTION = 2;
        assertNull(tabsAdapter.getPageTitle(2));
    }
}
