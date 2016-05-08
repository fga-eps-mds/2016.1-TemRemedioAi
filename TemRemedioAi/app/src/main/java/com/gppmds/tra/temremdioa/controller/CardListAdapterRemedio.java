package com.gppmds.tra.temremdioa.controller;

import android.content.Context;
import android.support.v7.widget.CardView;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.LinearLayout;
import android.widget.TextView;

import com.gppmds.tra.temremdioa.model.Remedio;
import com.tra.gppmds.temremdioa.R;

import java.util.List;

/**
 * Created by carolina on 04/05/16.
 */
public class CardListAdapterRemedio extends RecyclerView.Adapter<CardListAdapterRemedio.ViewHolder>{
    private List<Remedio> dataRemedio;
    private Context contextOpen;


    public class ViewHolder extends RecyclerView.ViewHolder implements View.OnClickListener{
        public TextView textViewNomeMedicamento;
        public TextView textViewTipoMedicamento;
        public TextView textViewQuantidadePorcao;
        public TextView textViewNivelAtMedicamento;
        public CardView carViewRemedio;

        public ViewHolder(CardView card) {
            super(card);
            this.textViewNomeMedicamento = (TextView) card.findViewById(R.id.textViewNomeMedicamento);
            this.textViewTipoMedicamento = (TextView) card.findViewById(R.id.textViewTipoMedicamento);
            this.textViewQuantidadePorcao = (TextView) card.findViewById(R.id.textViewQuantidadePorcao);
            this.textViewNivelAtMedicamento = (TextView) card.findViewById(R.id.textViewNivelAtMedicamento);
            this.carViewRemedio = card;
            card.setOnClickListener(this);
        }

        @Override
        public void onClick(View view) {
           LinearLayout.LayoutParams lp;
            if (carViewRemedio.getHeight() == 250) {
                lp = new LinearLayout.LayoutParams(LinearLayout.LayoutParams.WRAP_CONTENT, LinearLayout.LayoutParams.WRAP_CONTENT, 1f);
            } else {
                lp = new LinearLayout.LayoutParams(LinearLayout.LayoutParams.WRAP_CONTENT, 250, 1f);
            }
            carViewRemedio.setLayoutParams(lp);
        }
    }

    public CardListAdapterRemedio(Context context, List<Remedio> dataRemedio) {
        this.contextOpen = context;
        this.dataRemedio = dataRemedio;
    }

    @Override
    public CardListAdapterRemedio.ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        LayoutInflater inflater = LayoutInflater.from(parent.getContext());
        CardView view = (CardView) inflater.inflate(R.layout.card_list_remedio, parent, false);

        return new ViewHolder(view);
    }

    @Override
    public void onBindViewHolder(ViewHolder holder, int position) {
        Remedio rowData = this.dataRemedio.get(position);
        holder.textViewNomeMedicamento.setText(rowData.getMedDes());
        holder.textViewTipoMedicamento.setText(rowData.getUnidadeFormated());
//        holder.textViewQuantidadePorcao.setText(rowData.getUnid());
        holder.textViewNivelAtMedicamento.setText(rowData.getNivelAtencaoFormated());

//        LinearLayout.LayoutParams lp = new LinearLayout.LayoutParams(LinearLayout.LayoutParams.WRAP_CONTENT, 50, 1f);
//        holder.carViewRemedio.setLayoutParams(lp);
    }

    @Override
    public int getItemCount() {
        return 30;
    }
}
