package com.gppmds.tra.temremdioa.controller.adapter;

import android.location.Location;

import com.gppmds.tra.temremdioa.controller.SelectUBSActivity;
import com.gppmds.tra.temremdioa.model.UBS;
import com.parse.ParseQuery;

import java.util.Arrays;
import java.util.List;

/**
 * Created by atillagallio on 6/8/2016.
 */
public class SortUBS {

    public List<UBS> ubss;
    private List<Float> ubs_distance;
    private List<Location> ubs_location;
    private Location location;

    public float generateDistance(ParseQuery<UBS> queryUBS)
    {

//        try{
//            ubss = queryUBS.find();
//            location.getLatitude(queryUBS.get().getLatitude());
//        }
//
//       return
    }
}
