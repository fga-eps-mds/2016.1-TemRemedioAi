package com.gppmds.tra.temremdioa.controller.adapter;

import android.widget.Filter;

import com.gppmds.tra.temremdioa.model.Remedio;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by elmar on 09/05/16.
 */
public class FilterSearchRemedio extends Filter{

    CardListAdapterRemedio adapter;
    List<Remedio> filterList;


    public FilterSearchRemedio(List<Remedio> filterList, CardListAdapterRemedio adapter)
    {
        this.adapter = adapter;
        this.filterList = filterList;

    }
    @Override
    protected FilterResults performFiltering(CharSequence constraint) {
        FilterResults results = new FilterResults();

        if(constraint != null && constraint.length() > 0)
        {
            constraint = constraint.toString().toUpperCase();
            List<Remedio> filteredRemedios = new ArrayList<>();

            for (int i=0;i<filterList.size();i++)
            {
                if(filterList.get(i).getMedicineDescription().toUpperCase().contains(constraint))
                {
                    filteredRemedios.add(filterList.get(i));
                }
            }

            results.count = filteredRemedios.size();
            results.values = filteredRemedios;
        }else
        {
            results.count = filterList.size();
            results.values = filterList;

        }


        return results;
    }

    @Override
    protected void publishResults(CharSequence constraint, FilterResults results) {
        adapter.dataRemedio = ( List<Remedio>) results.values;

        adapter.notifyDataSetChanged();
    }
}
