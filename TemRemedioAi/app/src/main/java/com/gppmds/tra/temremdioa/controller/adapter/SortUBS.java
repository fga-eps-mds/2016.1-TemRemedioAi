package com.gppmds.tra.temremdioa.controller.adapter;

import android.Manifest;
import android.content.pm.PackageManager;
import android.location.Location;
import android.support.v4.content.ContextCompat;

import com.google.android.gms.location.LocationServices;
import com.gppmds.tra.temremdioa.controller.SelectUBSActivity;
import com.gppmds.tra.temremdioa.model.UBS;
import com.parse.ParseQuery;

import java.util.Arrays;
import java.util.List;
import java.util.Map;
import java.util.TreeMap;

/**
 * Created by atillagallio on 6/8/2016.
 */
public class SortUBS {

    private List<Double> ubs_distance;
    private List<Location> ubs_location_list;
    public List<UBS> ubs_sorted;
    private Location location;
    private int ubs_list_size;

    public List<UBS> sortList(List<UBS> ubss)
    {
        ubs_list_size = ubss.size();

        for(int i = 0; i <= ubs_list_size; i++) {
            Location ubs_location = new Location("service Provider");
            ubs_location.setLatitude(ubss.get(i).getLatitude());
            ubs_location.setLongitude(ubss.get(i).getLongitude());


            ubs_location_list.get(i).set(ubs_location);

            ubs_distance.get(i).equals(distance(ubs_location, user_location));

        }
        ubs_sorted = sortByDistance(ubss);

      return ubs_sorted;
    }


    private List<UBS> sortByDistance(List<UBS> ubss)
    {
        Map<Double, UBS> ubs_to_location_hashmap = new TreeMap<Double, UBS>();
        for (int i=0; i<ubs_distance.size(); ++i) ubs_to_location_hashmap.put(ubs_distance.get(i), ubss.get(i));
        ubss.clear();
        ubss.addAll(ubs_to_location_hashmap.values());

        return ubss;
    }

    private double distance(Location ubs_location, Location user_location)
    {
        return ubs_location.distanceTo(user_location);
    }
}
