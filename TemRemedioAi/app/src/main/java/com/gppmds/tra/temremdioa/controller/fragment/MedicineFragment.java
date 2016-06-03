package com.gppmds.tra.temremdioa.controller.fragment;

import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.gppmds.tra.temremdioa.controller.adapter.CardListAdapterMedicine;
import com.gppmds.tra.temremdioa.model.Medicine;
import com.parse.ParseException;
import com.parse.ParseQuery;
import com.tra.gppmds.temremdioa.R;

import java.util.List;


public class MedicineFragment extends Fragment{

    private RecyclerView medicineRecyclerView;
    public static CardListAdapterMedicine medicineAdapter;

    public MedicineFragment(){
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {

        View rootView = inflater.inflate(R.layout.fragment_remedio, container, false);

        medicineRecyclerView = (RecyclerView) rootView.findViewById(R.id.recycler_view);
        medicineRecyclerView.setHasFixedSize(true);
        medicineRecyclerView.setLayoutManager(new LinearLayoutManager(getContext()));

        /* Query medicine data from parse */
        ParseQuery<Medicine> queryMedicine = Medicine.getQuery();
        List<Medicine> medicines;

        try {
            medicines = queryMedicine.find();
            medicineAdapter = new CardListAdapterMedicine(MedicineFragment.this.getContext(), medicines);
            medicineRecyclerView.setAdapter(medicineAdapter);
        } catch (ParseException e) {
            e.printStackTrace();
        }

        return rootView;
    }

    public static MedicineFragment newInstance(){
        return new MedicineFragment();
    }

    public static CardListAdapterMedicine getMedicineAdapter() {
        return medicineAdapter;
    }
}