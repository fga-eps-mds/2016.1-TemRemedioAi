package com.gppmds.tra.temremdioa.controller.adapter;

import android.content.Context;
import android.support.v7.widget.CardView;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Filterable;

import com.gppmds.tra.temremdioa.controller.adapter.holder.ViewHolderUBS;
import com.gppmds.tra.temremdioa.model.UBS;
import com.tra.gppmds.temremdioa.R;

import java.util.List;

public class CardListAdapterUBS extends RecyclerView.Adapter<ViewHolderUBS> implements Filterable{
    public static List<UBS> dataUBS;
    List<UBS> filterDataUBS;
    private static Context contextOpen;
    FilterSearchUBS filter;

    private Boolean showButtonMedicines;
    private Boolean showButtonInform;
    private String medicineName;
    private String medicineDos;

    public CardListAdapterUBS(Context context, List<UBS> dataUBS) {
        this.contextOpen = context;
        this.dataUBS = dataUBS;
        this.filterDataUBS = dataUBS;
        setShowButtonMedicines(true);
        setShowButtonInform(false);
        setMedicineName("");
        setMedicineDos("");
    }

    @Override
    public FilterSearchUBS getFilter() {
        if(filter == null) {
            filter = new FilterSearchUBS(filterDataUBS, this);
        } else {
            // Nothing to do
        }

        return filter;
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
        holder.getTextViewUbsName().setText(rowData.getUbsName());
        holder.getTextViewUbsNeighborhood().setText(rowData.getUbsNeighborhood());

        if (!getShowButtonMedicines()) {
            holder.getButtonSelectMedicine().setVisibility(View.GONE);
        } else {
            // Nothing to do
        }

        if(!getMedicineName().isEmpty()){
            holder.medicineSelectedName = getMedicineName();
        } else {
            holder.medicineSelectedName = "";
        }

        if(!getMedicineDos().isEmpty()){
            holder.medicineSelectedDos = getMedicineDos();
        } else {
            holder.medicineSelectedDos = "";
        }

        if(!getShowButtonInform()){
            holder.buttonUbsInform.setVisibility(View.GONE);
        }
    }

    @Override
    public int getItemCount() {

        return dataUBS.size();
    }

    public void setShowButtonMedicines(Boolean showButtonMedicines) {
        this.showButtonMedicines = showButtonMedicines;
    }

    private Boolean getShowButtonMedicines() {
        return this.showButtonMedicines;
    }

    public void createFilter() {
        filter = new FilterSearchUBS(filterDataUBS, this);
        Boolean test = getShowButtonMedicines();
    }

    public void setShowButtonInform(boolean showButtonInform) {
        this.showButtonInform = showButtonInform;
    }

    public boolean getShowButtonInform(){
        return this.showButtonInform;
    }

    public void setMedicineName(String medicineName) {
        this.medicineName = medicineName;
    }

    public String getMedicineName(){
        return this.medicineName;
    }

    public void setMedicineDos(String medicineDos) {
        this.medicineDos= medicineDos;
    }

    public String getMedicineDos(){
        return this.medicineDos;
    }
}
