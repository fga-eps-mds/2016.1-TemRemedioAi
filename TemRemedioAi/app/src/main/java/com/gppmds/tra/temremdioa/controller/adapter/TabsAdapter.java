package com.gppmds.tra.temremdioa.controller.adapter;

import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentPagerAdapter;

import com.gppmds.tra.temremdioa.controller.fragment.MedicineFragment;
import com.gppmds.tra.temremdioa.controller.fragment.UBSFragment;

public class TabsAdapter extends FragmentPagerAdapter{

    public TabsAdapter(FragmentManager fm){
        super(fm);
    }

    @Override
    public Fragment getItem(int position) {
        switch (position){
            case 0:
                return MedicineFragment.newInstance();
            case 1:
                return UBSFragment.newInstance();
            default:
                /* Nothing to do */
                break;
        }
        return null;
    }

    @Override
    public int getCount() {
        return 2;
    }

    @Override
    public CharSequence getPageTitle(int position) {
        switch (position) {
            case 0:
                return "Remédio";
            case 1:
                return "UBS";
            default:
                /* Nothing to do */
                break;
        }
        return null;
    }
}
