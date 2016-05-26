package com.gppmds.tra.temremdioa.controller.adapter;

import android.widget.Filter;

import com.gppmds.tra.temremdioa.model.Remedio;

import java.util.ArrayList;
import java.util.List;

public class FilterSearchMedicine extends Filter{

    CardListAdapterMedicine adapter;
    List<Remedio> filterList;


    public FilterSearchMedicine(List<Remedio> filterList, CardListAdapterMedicine adapter)
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
            List<Remedio> filteredMedicines = new ArrayList<>();

            for (int i=0;i<filterList.size();i++)
            {
                if(filterList.get(i).getMedicineDescription().toUpperCase().contains(constraint))
                {
                    filteredMedicines.add(filterList.get(i));
                }
            }

            results.count = filteredMedicines.size();
            results.values = filteredMedicines;
        }else
        {
            results.count = filterList.size();
            results.values = filterList;

        }


        return results;
    }

    @Override
    protected void publishResults(CharSequence constraint, FilterResults results) {
        adapter.dataMedicine = ( List<Remedio>) results.values;

        adapter.notifyDataSetChanged();
    }
}
