package com.tra.gppmds.temremdioa;

import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentPagerAdapter;
import android.support.v7.widget.RecyclerView;

/**
 * Created by carolina on 01/05/16.
 */
public class TabsAdapter extends FragmentPagerAdapter{
    public TabsAdapter(FragmentManager fm){
        super(fm);
    }

    @Override
    public Fragment getItem(int position) {
        switch (position){
            case 0:
                return RemedioFragment.newInstance();
            case 1:
                return UBSFragment.newInstance();
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
                return "Remedio";
            case 1:
                return "UBS";
        }
        return null;
    }
}
