package com.gppmds.tra.temremdioa.controller.adapter;

import android.content.Context;
import android.support.v7.widget.CardView;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Filter;
import android.widget.Filterable;

import com.gppmds.tra.temremdioa.controller.adapter.holder.ViewHolderUBS;
import com.gppmds.tra.temremdioa.model.UBS;
import com.tra.gppmds.temremdioa.R;

import java.util.List;

/**
 * Created by carolina on 01/05/16.
 */
public class CardListAdapterUBS extends RecyclerView.Adapter<ViewHolderUBS> implements Filterable{
    public static List<UBS> dataUBS;
    List<UBS> filterDataUBS;
    public static Context contextOpen;
    FilterSearchUBS filter;
    private Boolean showButtonRemedios;

    @Override
    public Filter getFilter() {
        if(filter == null) {
            filter = new FilterSearchUBS( filterDataUBS ,this );
        }

        return filter;
    }

    public CardListAdapterUBS(Context context, List<UBS> dataUBS) {
        this.contextOpen = context;
        this.dataUBS = dataUBS;
        this.filterDataUBS = dataUBS;
        setShowButtonRemedios(true);
    }

    @Override
    public ViewHolderUBS onCreateViewHolder(ViewGroup parent, int viewType) {
        LayoutInflater inflater = LayoutInflater.from(parent.getContext());
        CardView view = (CardView) inflater.inflate(R.layout.card_list_ubs, parent, false);

        return new ViewHolderUBS(view);
    }

    @Override
    public void onBindViewHolder(ViewHolderUBS holder, int position) {
        UBS rowData = this.dataUBS.get(position);
        holder.textViewNomeUBS.setText(rowData.getNomEstab());
        holder.textViewBairroUBS.setText(rowData.getDscBairro());
        holder.textViewCidadeUBS.setText(rowData.getDscCidade());
        holder.textViewNivelAtencaoUBS.setText(rowData.getNivelAt());
        if (!getShowButtonRemedios()) {
            holder.buttonSelecionaRemedio.setVisibility(View.GONE);
        }
    }

    @Override
    public int getItemCount() {
        return dataUBS.size();
    }

    public void setShowButtonRemedios(Boolean showButtonRemedios) {
        this.showButtonRemedios = showButtonRemedios;
    }

    private Boolean getShowButtonRemedios() {
        return this.showButtonRemedios;
    }

}
