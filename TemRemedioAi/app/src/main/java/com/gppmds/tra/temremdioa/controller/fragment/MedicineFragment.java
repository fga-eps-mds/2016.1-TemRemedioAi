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

    public RecyclerView recyclerView;
    public static CardListAdapterMedicine adapter;

    public MedicineFragment(){
    }

    public static MedicineFragment newInstance(){
        return new MedicineFragment();
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {

        View rootView = inflater.inflate(R.layout.fragment_remedio, container, false);

        recyclerView = (RecyclerView) rootView.findViewById(R.id.recycler_view);
        recyclerView.setHasFixedSize(true);
        recyclerView.setLayoutManager(new LinearLayoutManager(getContext()));

        //Query medicine data from parse
        ParseQuery<Medicine> queryMedicine = Medicine.getQuery();
        List<Medicine> medicines;
        try {
            medicines = queryMedicine.find();
                adapter = new CardListAdapterMedicine(MedicineFragment.this.getContext(), medicines);
                recyclerView.setAdapter( adapter );


        } catch (ParseException e) {
            e.printStackTrace();
        }

        return rootView;
    }

}