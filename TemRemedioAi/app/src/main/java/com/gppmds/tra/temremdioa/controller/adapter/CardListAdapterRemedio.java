package com.gppmds.tra.temremdioa.controller.adapter;

import android.content.Context;
import android.support.v7.widget.CardView;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.ViewGroup;
import android.widget.Filter;
import android.widget.Filterable;

import com.gppmds.tra.temremdioa.controller.adapter.holder.ViewHolderRemedio;
import com.gppmds.tra.temremdioa.model.Remedio;
import com.tra.gppmds.temremdioa.R;

import java.util.List;

/**
 * Created by carolina on 04/05/16.
 */
public class CardListAdapterRemedio extends RecyclerView.Adapter<ViewHolderRemedio> implements Filterable{
    List<Remedio> dataRemedio;
    List<Remedio> filterDataRemedio;
    Context contextOpen;
    FilterSearchRemedio filter;

    public CardListAdapterRemedio(Context context, List<Remedio> dataRemedio) {
        this.contextOpen = context;
        this.dataRemedio = dataRemedio;
        this.filterDataRemedio = dataRemedio;
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
        holder.textViewQuantidadePorcao.setText("300 mg");
        holder.textViewNivelAtMedicamento.setText(rowData.getNivelAtencaoFormated());
    }

    @Override
    public Filter getFilter() {
        if(filter == null) {
            filter = new FilterSearchRemedio( filterDataRemedio , this );
        }

        return filter;
    }

    @Override
    public int getItemCount() {
        return dataRemedio.size();
    }
}
