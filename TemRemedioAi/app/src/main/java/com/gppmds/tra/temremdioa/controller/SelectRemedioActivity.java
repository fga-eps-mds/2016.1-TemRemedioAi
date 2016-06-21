package com.gppmds.tra.temremdioa.controller;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.util.Log;
import android.widget.TextView;

import com.gppmds.tra.temremdioa.controller.adapter.CardListAdapterRemedio;
import com.gppmds.tra.temremdioa.model.Remedio;
import com.parse.ParseException;
import com.parse.ParseQuery;
import com.tra.gppmds.temremdioa.R;

import java.util.Arrays;
import java.util.List;

public class SelectRemedioActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_select_remedio);

        getSupportActionBar().setDisplayHomeAsUpEnabled(true);

        RecyclerView recyclerView = (RecyclerView) findViewById(R.id.recycler_view);
        recyclerView.setHasFixedSize(true);

        LinearLayoutManager llm = new LinearLayoutManager(getApplicationContext());
        recyclerView.setLayoutManager(llm);

        String nomeUBS = getIntent().getStringExtra("nomeUBS");
        String nivelAtencaoUBS = getIntent().getStringExtra("nivelAtencao");
        String filtrosNivelAtencao[] = nivelAtencaoUBS.split(",");

        for(int i = 0; i < filtrosNivelAtencao.length; i++) {
            Log.i("CLAUS WHERE", "Nível de atenção da UBS " + i + ": " + filtrosNivelAtencao[i]);
        }

        TextView textViewRemedioSelecionado = (TextView) findViewById(R.id.textViewUBSSelecionada);
        textViewRemedioSelecionado.setText(nomeUBS);

        ParseQuery<Remedio> queryRemedio = Remedio.getQuery();
        queryRemedio.whereContainedIn(Remedio.getTitleNivelAt(), Arrays.asList(filtrosNivelAtencao));
        queryRemedio.orderByAscending(Remedio.getTitleMedDes());
        List<Remedio> remedios;
        try {
            remedios = queryRemedio.find();

            CardListAdapterRemedio claRemedio = new CardListAdapterRemedio(SelectRemedioActivity.this, remedios);
            claRemedio.setShowButtonUBSs(false);
            claRemedio.setShowButtonInform(true);
            claRemedio.setUbsName(nomeUBS);
            recyclerView.setAdapter(claRemedio);

            TextView textViewQuantidadeLocais = (TextView) findViewById(R.id.textViewQuantidadeLocais);
            textViewQuantidadeLocais.setText("Encontrado(s): " + remedios.size());
        } catch (ParseException e) {
            e.printStackTrace();
        }
    }
}
