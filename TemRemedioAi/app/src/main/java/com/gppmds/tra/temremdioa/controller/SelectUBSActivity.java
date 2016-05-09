package com.gppmds.tra.temremdioa.controller;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;

import com.gppmds.tra.temremdioa.controller.adapter.CardListAdapterUBS;
import com.gppmds.tra.temremdioa.model.UBS;
import com.parse.ParseException;
import com.parse.ParseQuery;
import com.tra.gppmds.temremdioa.R;

import java.util.List;

public class SelectUBSActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_select_ubs);

        RecyclerView recyclerView = (RecyclerView) findViewById(R.id.recycler_view);
        recyclerView.setHasFixedSize(true);

        LinearLayoutManager llm = new LinearLayoutManager(getApplicationContext());
        recyclerView.setLayoutManager(llm);

        ParseQuery<UBS> queryUBS = UBS.getQuery();
        queryUBS.orderByAscending(UBS.getTitleNomEstab());
        List<UBS> ubss;
        try {
            ubss = queryUBS.find();

            CardListAdapterUBS claUbs = new CardListAdapterUBS(SelectUBSActivity.this, ubss);
            recyclerView.setAdapter(claUbs);
        } catch (ParseException e) {
            e.printStackTrace();
        }
    }
}
