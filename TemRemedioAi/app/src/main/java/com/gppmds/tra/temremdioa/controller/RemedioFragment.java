package com.gppmds.tra.temremdioa.controller;

import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import com.gppmds.tra.temremdioa.model.Remedio;
import com.parse.ParseException;
import com.parse.ParseQuery;
import com.tra.gppmds.temremdioa.R;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by carolina on 01/05/16.
 */
public class RemedioFragment extends Fragment{

    public RecyclerView recyclerView;

    public RemedioFragment(){
    }

    public static RemedioFragment newInstance(){
        return new RemedioFragment();
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {

        List<Remedio> newsRemedio = new ArrayList<Remedio>();

        View rootView = inflater.inflate(R.layout.fragment_remedio, container, false);

        recyclerView = (RecyclerView) rootView.findViewById(R.id.recycler_view);
        recyclerView.setHasFixedSize(true);
        recyclerView.setLayoutManager(new LinearLayoutManager(getContext()));

        ParseQuery<Remedio> queryRemedio = Remedio.getQuery();
        List<Remedio> remedios;
        try {
            remedios = queryRemedio.find();
            if (MainActivity.searchQuery != null) {
                for (int i = 0; i < remedios.size(); i++) {
                    if (remedios.get(i).getMedDes().toLowerCase().startsWith(MainActivity.searchQuery.toLowerCase())) {
                        newsRemedio.add(remedios.get(i));
                    }
                }
                recyclerView.setAdapter(new CardListAdapterRemedio(RemedioFragment.this.getContext(), newsRemedio));
            }
            else {
                recyclerView.setAdapter(new CardListAdapterRemedio(RemedioFragment.this.getContext(), remedios));
            }

        } catch (ParseException e) {
            e.printStackTrace();
        }

//            Remedio.pinAllInBackground(remedios);
        return rootView;
    }

}