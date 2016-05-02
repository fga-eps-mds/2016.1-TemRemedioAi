package com.tra.gppmds.temremdioa;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

/**
 * Created by carolina on 01/05/16.
 */
public class UBSFragment extends Fragment{
    public UBSFragment(){
    }

    public static UBSFragment newInstance(){
       return new UBSFragment();
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        View rootView = inflater.inflate(R.layout.fragment_ubs, container, false);
//        RecyclerView recyclerView = (RecyclerView) ;

        return super.onCreateView(inflater, container, savedInstanceState);
    }
}
