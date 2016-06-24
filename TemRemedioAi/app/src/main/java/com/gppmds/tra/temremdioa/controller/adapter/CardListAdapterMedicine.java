package com.gppmds.tra.temremdioa.controller.adapter;

import android.content.Context;
import android.support.v7.widget.CardView;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Filterable;
import android.widget.RelativeLayout;

import com.gppmds.tra.temremdioa.controller.adapter.holder.ViewHolderMedicine;
import com.gppmds.tra.temremdioa.model.Medicine;
import com.tra.gppmds.temremdioa.R;

import java.util.List;

public class CardListAdapterMedicine extends RecyclerView.Adapter<ViewHolderMedicine> implements Filterable{
    public static List<Medicine> dataMedicine;
    List<Medicine> filterDataMedicine;
    Context contextOpen;
    FilterSearchMedicine filter;
    private Boolean showButtonUBSs;
    private Boolean showButtonInform;
    private String ubsName;

    public CardListAdapterMedicine(Context context, List<Medicine> dataMedicine) {
        this.contextOpen = context;
        this.dataMedicine = dataMedicine;
        this.filterDataMedicine = dataMedicine;
        setShowButtonUBSs(true);
        setShowButtonInform(false);
        setUbsName("");
    }

    @Override
    public ViewHolderMedicine onCreateViewHolder(ViewGroup parent, int viewType) {
        LayoutInflater inflater = LayoutInflater.from(parent.getContext());
        CardView view = (CardView) inflater.inflate(R.layout.card_list_medicine, parent, false);
        return new ViewHolderMedicine(view);
    }

    @Override
    public void onBindViewHolder(ViewHolderMedicine holder, int position) {
        Medicine rowData = this.dataMedicine.get(position);
        holder.getTextViewMedicineName().setText(rowData.getMedicineDescription());
        holder.getTextViewMedicineUnit().setText(rowData.getUnityMedicineFormatted());
        holder.getTextViewMedicineDosage().setText(rowData.getMedicineDosage());

        if (!getShowButtonUBSs()) {
            holder.getButtonSelectUbs().setVisibility(View.GONE);
            RelativeLayout.LayoutParams params = (RelativeLayout.LayoutParams) holder.getButtonMedicineInform().getLayoutParams();
            params.addRule(RelativeLayout.ALIGN_PARENT_END);
            holder.getButtonMedicineInform().setLayoutParams(params);
        } else {
            /* Nothing to do */
        }

        if (!getUbsName().equalsIgnoreCase("")) {
            holder.ubsSelectedName = getUbsName();
        } else {
            holder.ubsSelectedName = "";
        }

        if (!getShowButtonInform()) {
            holder.buttonMedicineInform.setVisibility(View.GONE);
        }
    }

    @Override
    public FilterSearchMedicine getFilter() {
        if(filter == null) {
            filter = new FilterSearchMedicine(filterDataMedicine, this );
        } else {
            /* Nothing to do */
        }

        return filter;
    }

    @Override
    public int getItemCount() {
        return dataMedicine.size();
    }

    public void setShowButtonUBSs(Boolean showButtonUBSs) {
        this.showButtonUBSs = showButtonUBSs;
    }

    private Boolean getShowButtonUBSs() {
        return this.showButtonUBSs;
    }

    public void setShowButtonInform(Boolean showButtonInform){
        this.showButtonInform = showButtonInform;
    }

    private Boolean getShowButtonInform(){
        return this.showButtonInform;
    }

    public String getUbsName(){
        return this.ubsName;
    }

    public void setUbsName(String ubsName){
        this.ubsName = ubsName;
    }

    private void showInformButtonIfThereIsACurrentUser(){
        /* Checar se o usuario está logado antes de mostrar o botao
        if (getCurrentUser() != null){
            setShowButtonInform(true);
        }
        */
    }

    public void createFilter() {
        filter = new FilterSearchMedicine(filterDataMedicine, this);
        Boolean test = getShowButtonUBSs();
    }
}
