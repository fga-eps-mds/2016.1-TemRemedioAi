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
    public void getItemReturnMedicineTest(){
        assertEquals(MedicineFragment.class, tabsAdapter.getItem(0).getClass());
    }

    @Test
    public void getItemReturnUBSTest(){
        assertEquals(UBSFragment.class, tabsAdapter.getItem(1).getClass());
    }

    @Test
    public void getItemReturnNullTest(){
        assertNull(tabsAdapter.getItem(2));
    }

    @Test
    public void getCountTest(){
        assertEquals(tabsAdapter.getCount(), 2);
    }

    @Test
    public void getPageTitleMedicineTest(){
        assertEquals("Remédio",tabsAdapter.getPageTitle(0));
    }

    @Test
    public void getPageTitleUBSTest(){
        assertEquals("UBS",tabsAdapter.getPageTitle(1));
    }

    @Test
    public void getPageTitleReturnNullTest(){
        assertNull(tabsAdapter.getPageTitle(2));
    }
}
