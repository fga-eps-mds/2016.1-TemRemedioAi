package com.gppmds.tra.temremdioa.controller.fragment;

import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.gppmds.tra.temremdioa.controller.adapter.CardListAdapterUBS;
import com.gppmds.tra.temremdioa.model.UBS;
import com.parse.ParseException;
import com.parse.ParseQuery;
import com.tra.gppmds.temremdioa.R;

import java.util.List;

public class UBSFragment extends Fragment{

    public RecyclerView recyclerView;
    public static CardListAdapterUBS adapter;

    public UBSFragment(){
    }

    public static UBSFragment newInstance(){
        return new UBSFragment();
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {

        View rootView = inflater.inflate(R.layout.fragment_ubs, container, false);

        recyclerView = (RecyclerView) rootView.findViewById(R.id.recycler_view);
        recyclerView.setHasFixedSize(true);
        recyclerView.setLayoutManager(new LinearLayoutManager(getContext()));

        //Query UBS data from parse
        ParseQuery<UBS> queryUBS = UBS.getQuery();
        queryUBS.orderByAscending(UBS.getUbsNameTitle());
        List<UBS> ubsList;
        try {
            ubsList = queryUBS.find();
            adapter = new CardListAdapterUBS(UBSFragment.this.getContext(), ubsList);
            recyclerView.setAdapter( adapter );
        } catch (ParseException e) {
            e.printStackTrace();
        }

        return rootView;
    }
}
