package com.gppmds.tra.temremdioa.controller.adapter;

import android.widget.Filter;

import com.gppmds.tra.temremdioa.model.Medicine;

import java.util.ArrayList;
import java.util.List;

public class FilterSearchMedicine extends Filter{

    CardListAdapterMedicine adapter;
    List<Medicine> filterList;

    public FilterSearchMedicine(List<Medicine> filterList, CardListAdapterMedicine adapter) {
        this.adapter = adapter;
        this.filterList = filterList;
    }

    @Override
    public FilterResults performFiltering(CharSequence constraint) {
        FilterResults results = new FilterResults();

        if(constraint != null && constraint.length() > 0) {
            constraint = constraint.toString().toUpperCase();
            List<Medicine> filteredMedicines = new ArrayList<>();

            for (int i = 0; i < filterList.size(); i++) {
                if(filterList.get(i).getMedicineDescription().toUpperCase().contains(constraint)) {
                    filteredMedicines.add(filterList.get(i));
                } else {
                    /* Nothing to do */
                }
            }

            results.count = filteredMedicines.size();
            results.values = filteredMedicines;
        } else {
            results.count = filterList.size();
            results.values = filterList;
        }

        return results;
    }

    @Override
    public void publishResults(CharSequence constraint, FilterResults results) {
        adapter.dataMedicine = (List<Medicine>) results.values;
        adapter.notifyDataSetChanged();
    }
}
