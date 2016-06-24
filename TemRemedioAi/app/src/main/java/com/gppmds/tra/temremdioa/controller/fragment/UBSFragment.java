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

    private RecyclerView ubsRecyclerView;
    private static CardListAdapterUBS ubsAdapter;

    public static UBSFragment newInstance(){
        return new UBSFragment();
    }

    public static CardListAdapterUBS getUbsAdapter() {
        return ubsAdapter;
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {

        View rootView = inflater.inflate(R.layout.fragment_ubs, container, false);

        ubsAdapter = new CardListAdapterUBS(UBSFragment.this.getContext(), getListOfUBS());
        ubsAdapter.setShowButtonInform(false);
        ubsAdapter.setMedicineName("");
        ubsAdapter.setMedicineDos("");

        ubsRecyclerView = (RecyclerView) rootView.findViewById(R.id.ubs_recycler_view);
        ubsRecyclerView.setHasFixedSize(true);
        ubsRecyclerView.setLayoutManager(new LinearLayoutManager(getContext()));
        ubsRecyclerView.setAdapter(getUbsAdapter());

        return rootView;
    }

    public List<UBS> getListOfUBS(){
        /* Query UBS data from parse */
        ParseQuery<UBS> queryUBS = UBS.getQuery();
        queryUBS.fromLocalDatastore();
        queryUBS.orderByAscending(UBS.getUbsNameTitle());
        List<UBS> ubsList = null;

        try {
            ubsList = queryUBS.find();

        } catch (ParseException e) {
            e.printStackTrace();
        }

        return ubsList;
    }
}
