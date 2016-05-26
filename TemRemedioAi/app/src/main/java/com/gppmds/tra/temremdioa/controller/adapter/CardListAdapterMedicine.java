package com.gppmds.tra.temremdioa.controller.adapter;

import android.content.Context;
import android.support.v7.widget.CardView;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
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
public class CardListAdapterMedicine extends RecyclerView.Adapter<ViewHolderRemedio> implements Filterable{
    public static List<Remedio> dataRemedio;
    List<Remedio> filterDataRemedio;
    Context contextOpen;
    FilterSearchRemedio filter;
    private Boolean showButtonUBSs;

    public CardListAdapterMedicine(Context context, List<Remedio> dataRemedio) {
        this.contextOpen = context;
        this.dataRemedio = dataRemedio;
        this.filterDataRemedio = dataRemedio;
        setShowButtonUBSs(true);
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
        holder.textViewNomeMedicamento.setText(rowData.getMedicineDescription());
        holder.textViewTipoMedicamento.setText(rowData.getMedicineUnitExtended());
        holder.textViewQuantidadePorcao.setText(rowData.getMedicineDosage());
        holder.textViewNivelAtMedicamento.setText(rowData.getMedicineAttentionLevelExtended());
        if (!getShowButtonUBSs()) {
            holder.buttonSelecionaUbs.setVisibility(View.GONE);
        }
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

    public void setShowButtonUBSs(Boolean showButtonUBSs) {
        this.showButtonUBSs = showButtonUBSs;
    }

    private Boolean getShowButtonUBSs() {
        return this.showButtonUBSs;
    }
}
