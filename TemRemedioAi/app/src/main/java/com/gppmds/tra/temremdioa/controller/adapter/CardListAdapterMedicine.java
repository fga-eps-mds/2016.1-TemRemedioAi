package com.gppmds.tra.temremdioa.controller.adapter;

import android.content.Context;
import android.support.v7.widget.CardView;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Filterable;

import com.gppmds.tra.temremdioa.controller.adapter.holder.ViewHolderMedicine;
import com.gppmds.tra.temremdioa.model.Medicine;
import com.gppmds.tra.temremdioa.model.Notification;
import com.parse.ParseException;
import com.parse.ParseQuery;
import com.tra.gppmds.temremdioa.R;

import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.List;
import java.util.Locale;

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

        List<Notification> notificationList = null;
        notificationList = getNotifications(rowData);

        holder.haveNotification = false;
        if (notificationList.size() >= 1) {
            holder.haveNotification = true;
            holder.getTextViewLastInformation1().setText("1. " + generateTextNotification(notificationList.get(0)));
        } else {
            holder.getTextViewLastInformation1().setText("");
        }

        if (notificationList.size() >= 2) {
            holder.getTextViewLastInformation2().setText("2. " + generateTextNotification(notificationList.get(1)));
        } else {
            holder.getTextViewLastInformation2().setText("");
        }

        if (notificationList.size() >= 3) {
            holder.getTextViewLastInformation3().setText("3. " + generateTextNotification(notificationList.get(2)));
        } else {
            holder.getTextViewLastInformation3().setText("");
        }
    }

    private String generateTextNotification(Notification notification) {
        String textOfNotification = "";
        if (notification.getAvailable()) {
            textOfNotification = "Disponível em ";
        } else {
            textOfNotification = "Indisponível em ";
        }
        Calendar dayCalendar = Calendar.getInstance(new Locale("pt", "BR"));
        SimpleDateFormat simpleDateFormat = new SimpleDateFormat("dd MMM yyyy");

        dayCalendar.setTime(notification.getDateInform());
        textOfNotification = textOfNotification + simpleDateFormat.format(dayCalendar.getTime());

        return textOfNotification;
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

    private List<Notification> getNotifications(Medicine medicine) {
        List<Notification> listNotification = null;

        ParseQuery<Notification> queryNotification = Notification.getQuery();
        queryNotification.whereEqualTo(Notification.getTitleMedicineName(), medicine.getMedicineDescription());
        queryNotification.whereEqualTo(Notification.getTitleMedicineDosage(), medicine.getMedicineDosage());
        if (!getUbsName().isEmpty()) {
            queryNotification.whereEqualTo(Notification.getTitleUBSName(), getUbsName());
        }
        queryNotification.orderByDescending(Notification.getTitleDateInform());
        queryNotification.setLimit(3);

        try {
            listNotification = queryNotification.find();
        } catch (ParseException e) {
            e.printStackTrace();
        }

        return listNotification;
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
