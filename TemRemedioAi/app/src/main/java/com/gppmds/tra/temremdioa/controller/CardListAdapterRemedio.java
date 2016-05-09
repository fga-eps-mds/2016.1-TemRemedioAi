package com.gppmds.tra.temremdioa.controller;

import android.animation.Animator;
import android.animation.ValueAnimator;
import android.content.Context;
import android.support.v7.widget.CardView;
import android.support.v7.widget.RecyclerView;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.view.ViewTreeObserver;
import android.widget.LinearLayout;
import android.widget.TextView;

import com.gppmds.tra.temremdioa.model.Remedio;
import com.tra.gppmds.temremdioa.R;

import java.util.List;

/**
 * Created by carolina on 04/05/16.
 */
public class CardListAdapterRemedio extends RecyclerView.Adapter<ViewHolderRemedio>{
    private List<Remedio> dataRemedio;
    private Context contextOpen;

    public CardListAdapterRemedio(Context context, List<Remedio> dataRemedio) {
        this.contextOpen = context;
        this.dataRemedio = dataRemedio;
    }

    @Override
    public ViewHolderRemedio onCreateViewHolder(ViewGroup parent, int viewType) {
        LayoutInflater inflater = LayoutInflater.from(parent.getContext());
        CardView view = (CardView) inflater.inflate(R.layout.card_list_remedio, parent, false);
        return new ViewHolderRemedio(view);
    }

    @Override
    public void onBindViewHolder(ViewHolderRemedio holder, int position) {
        Remedio rowData = this.dataRemedio.get(position);
        holder.textViewNomeMedicamento.setText(rowData.getMedDes());
        holder.textViewTipoMedicamento.setText(rowData.getUnidadeFormated());
//      holder.textViewQuantidadePorcao.setText(rowData.getUnid());
        holder.textViewNivelAtMedicamento.setText(rowData.getNivelAtencaoFormated());
    }

    @Override
    public int getItemCount() {
        return dataRemedio.size();
    }
}
